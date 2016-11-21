/*******************************************************************************
 * Copyright (c) 2011 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

package org.eclipse.etrice.generator.cpp.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.Collection
import java.util.Map
import org.eclipse.etrice.core.common.converter.TimeConverter
import org.eclipse.etrice.core.etmap.util.ETMapUtil
import org.eclipse.etrice.core.etphys.eTPhys.ExecMode
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance
import org.eclipse.etrice.core.genmodel.etricegen.WiredSubSystemClass
import org.eclipse.etrice.core.room.SubSystemClass
import org.eclipse.etrice.generator.cpp.Main
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions

import static extension org.eclipse.etrice.generator.fsm.base.Indexed.*

@Singleton
class NodeGen {

	@Inject extension CppExtensions
	@Inject extension RoomExtensions
	@Inject extension ProcedureHelpers
	@Inject extension FileSystemHelpers
	
	@Inject IGeneratorFileIo fileIO
	@Inject Initialization initHelper

	def doGenerate(Root root) {
		val Map<SubSystemClass, WiredSubSystemClass> sscc2wired = newHashMap
		root.wiredInstances.filter(typeof(WiredSubSystemClass)).forEach[sscc2wired.put(subSystemClass, it)]

		for (nr : ETMapUtil::getNodeRefs()) {
			for (instpath : ETMapUtil::getSubSystemInstancePaths(nr)) {
				val ssi = root.getInstance(instpath) as SubSystemInstance
				if (ssi!=null && ssi.subSystemClass.validGenerationLocation) {
					val wired = sscc2wired.get(ssi.subSystemClass)
					val path = ssi.subSystemClass.generationTargetPath+ssi.subSystemClass.getPath
					val infopath = ssi.subSystemClass.generationInfoPath+ssi.subSystemClass.getPath

					//checkDataPorts(ssi)

					val usedThreads = ETMapUtil::getUsedThreads(nr, ssi)

					fileIO.generateFile("generating Node declaration", path, infopath, getCppHeaderFileName(nr, ssi), root.generateHeaderFile(ssi, wired, usedThreads))
					fileIO.generateFile("generating Node implementation", path, infopath, getCppSourceFileName(nr, ssi), root.generateSourceFile(ssi, wired, usedThreads))
				}
			}
		}
	}

	def generateHeaderFile(Root root, SubSystemInstance comp, WiredSubSystemClass wired, Collection<PhysicalThread> usedThreads) {
		val cc = comp.subSystemClass
		val models = root.getReferencedModels(cc)
		val nr = ETMapUtil::getNodeRef(comp)
		val clsname = nr.getCppClassName(comp)
		val threads = nr.type.threads.filter(t|usedThreads.contains(t))

	'''
		/**
		 * @author generated by eTrice
		 *
		 * Header File of SubSystemClass �clsname�
		 *
		 */

		�generateIncludeGuardBegin(cc, '')�

		#include "common/messaging/IMessageService.h"
		#include "common/modelbase/SubSystemClassBase.h"
		�FOR ai : comp.actorInstances�
			#include "�ai.actorClass.actorIncludePath�"
		�ENDFOR�

���		�FOR model : root.getReferencedModels(cc)�
���		���			#include "�model.name�.h"
���		�ENDFOR�
		�cc.userCode1.userCode�

		�cc.generateNamespaceBegin�

		class �clsname� : public etRuntime::SubSystemClassBase{

			�cc.userCode2.userCode�

			public:
				�FOR thread : threads.indexed�
					static const int �thread.value.threadId�;
				�ENDFOR�
				
				// sub actors
				�FOR sub : cc.actorRefs�
					�IF sub.multiplicity>1�
						Replicated�sub.type.implementationClassName� �sub.name�;
					�ELSE�
						�sub.type.implementationClassName� �sub.name�;
					�ENDIF�
				�ENDFOR�

				�clsname�(IRTObject* parent, const std::string& name);
				~�clsname�();

				virtual void receiveEvent(etRuntime::InterfaceItemBase* ifitem, int evt, void* data);
				virtual void instantiateMessageServices();
				virtual void mapThreads(void);
				virtual void initialize(void);
				�IF Main::settings.generateMSCInstrumentation�
					virtual void setProbesActive(bool recursive, bool active);
				�ENDIF�

				virtual void init();

				�IF Main::settings.generateMSCInstrumentation�
					etBool hasGeneratedMSCInstrumentation() const { return true; }
					virtual void destroy();
				�ENDIF�

			private:
				// MessageServices
				�FOR thread : threads�
					IMessageService* msgSvc_�thread.name�;
				�ENDFOR�

				�clsname�();
				�clsname�(�clsname� const&);
				�clsname�& operator=(�clsname� const&);
		};

		�cc.generateNamespaceEnd�

		�generateIncludeGuardEnd(cc, '')�
	'''
	}

	def private getThreadId(PhysicalThread thread) {
		"THREAD_"+thread.name.toUpperCase
	}

	def private generateConstructorInitalizerList(SubSystemClass cc) {
		val extension initHelper = initHelper
		var initList = <CharSequence>newArrayList
		
		// super class
		initList += '''SubSystemClassBase(parent, name)'''
	    // own sub actors
	    initList += cc.actorRefs.map['''�name�(this, "�name�")''']

		initList.generateCtorInitializerList
	}

	def generateSourceFile(Root root, SubSystemInstance comp, WiredSubSystemClass wired, Collection<PhysicalThread> usedThreads) {
		val cc = comp.subSystemClass
		val models = root.getReferencedModels(cc)
		val nr = ETMapUtil::getNodeRef(comp)
		val clsname = nr.getCppClassName(comp)
		val threads = nr.type.threads.filter(t|usedThreads.contains(t))

	'''
		/**
		 * @author generated by eTrice
		 *
		 * Source File of SubsystemClass �clsname�
		 *
		 */

		#include "�getCppHeaderFileName(nr, comp)�"

		#include "common/debugging/DebuggingService.h"
		#include "common/debugging/MSCFunctionObject.h"
		#include "common/messaging/IMessageService.h"
		#include "common/messaging/MessageService.h"
		#include "common/messaging/MessageServiceController.h"
		#include "common/messaging/RTServices.h"
		#include "common/messaging/StaticMessageMemory.h"
		#include "common/modelbase/InterfaceItemBase.h"

		using namespace etRuntime;

		�cc.generateNamespaceBegin�

		�FOR thread : threads.indexed�
			const int �clsname�::�thread.value.threadId� = �thread.index0�;
		�ENDFOR�

		�clsname�::�clsname�(IRTObject* parent, const std::string& name)
				�cc.generateConstructorInitalizerList�
				�FOR thread : threads�
					, msgSvc_�thread.name�(NULL)
				�ENDFOR�
		{
			�IF Main::settings.generateMSCInstrumentation�
				MSCFunctionObject mscFunctionObject(getInstancePathName(), "Constructor");
			�ENDIF�
			�FOR sub : cc.actorRefs�
				�IF sub.multiplicity>1�
					�sub.name�.createSubActors(�sub.multiplicity�);
				�ENDIF�
			�ENDFOR�
		}
		
		�clsname�::~�clsname�() {
			�IF Main::settings.generateMSCInstrumentation�
				MSCFunctionObject mscFunctionObject(getInstancePathName(), "Destructor");
			�ENDIF�
			�FOR thread : threads�
				delete msgSvc_�thread.name�;
			�ENDFOR�
		}

		void �clsname�::receiveEvent(InterfaceItemBase* ifitem, int evt, void* data){
		}

		void �clsname�::instantiateMessageServices(){

			�IF Main::settings.generateMSCInstrumentation�
				MSCFunctionObject mscFunctionObject(getInstancePathName(), "instantiateMessageServices()");
			�ENDIF�

			IMessageMemory* msgMemory;
			�FOR thread: threads.sortBy[-prio]�
				{
					msgMemory = new StaticMessageMemory(this, "MessageMemory_�thread.name�", �thread.msgblocksize�, �thread.msgpoolsize�);
					�IF thread.execmode==ExecMode::POLLED || thread.execmode==ExecMode::MIXED�
						etTime interval;
						interval.sec = �TimeConverter::split(thread.time, TimeConverter.SEC, true)�;
						interval.nSec = �TimeConverter::split(thread.time, TimeConverter.MILLI_SEC, false)�L;
						
						msgSvc_�thread.name� = new MessageService(this, IMessageService::�thread.execmode.getName�, interval, 0, �thread.threadId�, "MessageService_�thread.name�", msgMemory, �thread.prio�);
					�ELSE�
						msgSvc_�thread.name� = new MessageService(this, IMessageService::�thread.execmode.getName�, 0, �thread.threadId�, "MessageService_�thread.name�", msgMemory, �thread.prio�);
					�ENDIF�
					RTServices::getInstance().getMsgSvcCtrl().addMsgSvc(*msgSvc_�thread.name�);
				}
			�ENDFOR�
		}

		void �clsname�::mapThreads() {
			// thread mappings
			�FOR ai : comp.allContainedInstances�
				�val mapped = ETMapUtil::getMappedThread(ai)�
				�IF !(mapped.implicit || mapped.asParent)�
					addPathToThread("�ai.path�", �mapped.thread.threadId�);
				�ENDIF�
			�ENDFOR�
		}

		void �clsname�::initialize() {
			�IF Main::settings.generateMSCInstrumentation�
				DebuggingService::getInstance().getSyncLogger().addVisibleComment("starting initialization");
				MSCFunctionObject mscFunctionObject(getInstancePathName(), "initialize()");
				�FOR sub : cc.actorRefs�
					�IF sub.multiplicity>1�
						for (int i=0; i<�sub.multiplicity�; ++i) {
							DebuggingService::getInstance().addMessageActorCreate(*this, �sub.name�.getSubActor(i)->getName());
						}
					�ELSE�
						DebuggingService::getInstance().addMessageActorCreate(*this, "�sub.name�");
					�ENDIF�
				�ENDFOR�			
			�ENDIF�
			
			// wiring
			�FOR wire: wired.wires�
				�if (wire.dataDriven) "DataPortBase" else "InterfaceItemBase"�::connect(this, "�wire.path1.join('/')�", "�wire.path2.join('/')�");
			�ENDFOR�
			
			// call initialize of sub actors
			�FOR sub : cc.actorRefs�
				�sub.name�.initialize();
			�ENDFOR�
		}
		
		�IF Main::settings.generateMSCInstrumentation�
			void �clsname�::setProbesActive(bool recursive, bool active) {
				for(int i = 0; i < m_RTSystemPort.getNInterfaceItems(); i++)
					DebuggingService::getInstance().addPortInstance(*(m_RTSystemPort.getInterfaceItem(i)));
				if(recursive) {
					�FOR sub : cc.actorRefs�
						�sub.name�.setProbesActive(recursive, active);
					�ENDFOR�
				}
			}
		�ENDIF�

		void �clsname�::init(){
			SubSystemClassBase::init();
			�IF Main::settings.generateMSCInstrumentation�
				DebuggingService::getInstance().addVisibleComment("done sub system initialization");
			�ENDIF�
		}
		�IF Main::settings.generateMSCInstrumentation�

			void �clsname�::destroy() {
				�IF Main::settings.generateMSCInstrumentation�
					DebuggingService::getInstance().getSyncLogger().addVisibleComment("starting destruction");
					MSCFunctionObject mscFunctionObject(getInstancePathName(), "destroy()");
					DebuggingService::getInstance().addVisibleComment("begin sub system destruction");
				�ENDIF�
				SubSystemClassBase::destroy();
				�IF Main::settings.generateMSCInstrumentation�
					DebuggingService::getInstance().addVisibleComment("done sub system destruction");
				�ENDIF�
			}
		�ENDIF�

		�cc.generateNamespaceEnd�

	'''
	}


}