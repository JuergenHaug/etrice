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
import java.util.ArrayList
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType
import org.eclipse.etrice.core.genmodel.fsm.base.ILogger
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.generator.base.AbstractGenerator
import org.eclipse.etrice.generator.cpp.Main
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.xtext.generator.JavaIoFileSystemAccess

/**
 * @author Peter Karlitschek
 *
 */
@Singleton
class ActorClassGen extends GenericActorClassGenerator {
	
	@Inject JavaIoFileSystemAccess fileAccess
	@Inject extension CppExtensions
	@Inject extension RoomExtensions
	@Inject extension Initialization
	@Inject extension ProcedureHelpers
	@Inject extension StateMachineGen
	@Inject ILogger logger
	
	def doGenerate(Root root) {
		for (xpac: root.xpActorClasses) {
			var path = xpac.actorClass.generationTargetPath+xpac.actorClass.getPath

			logger.logInfo("generating ActorClass header '"+xpac.actorClass.getCppHeaderFileName+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(xpac.actorClass.getCppHeaderFileName, root.generateHeaderFile(xpac, xpac.actorClass))

			logger.logInfo("generating ActorClass source '"+xpac.actorClass.getCppSourceFileName+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(xpac.actorClass.getCppSourceFileName, root.generateSourceFile(xpac, xpac.actorClass))
		}
	}
	
	def private generateHeaderFile(Root root, ExpandedActorClass xpac, ActorClass ac) {
//		val ctor = ac.operations.filter(op|op.constructor).head
//		val dtor = ac.operations.filter(op|op.destructor).head
		
	'''
		/**
		 * @author generated by eTrice
		 *
		 * Header File of ActorClass �ac.name�
		 * 
		 */

		�generateIncludeGuardBegin(ac.name)�
	
		#include "platforms/generic/etDatatypes.h"
		#include "common/messaging/IRTObject.h"
		#include "common/modelbase/PortBase.h"
		#include "common/modelbase/InterfaceItemBase.h"
		#include "common/modelbase/ActorClassBase.h"
		#include "common/modelbase/SubSystemClassBase.h"
		#include "common/messaging/Address.h"
		#include "common/messaging/IMessageReceiver.h"
		#include "common/debugging/DebuggingService.h"
		�IF Main::settings.isUseEtUnit�
			extern "C" {
				#include "etUnit.h"
			}
		�ENDIF�
		#include <string>
		#include <vector>
		
		�FOR model : root.getReferencedModels(ac)�
���			#include "�model.name�.h"
		�ENDFOR�
		
		�FOR pc : root.getReferencedProtocolClasses(ac)�
			#include "�pc.path��pc.name�.h"
		�ENDFOR�
		�FOR dc : root.getReferencedDataClasses(ac)�
			#include "�dc.path��dc.name�.h"
		�ENDFOR�

		
		�ac.userCode(1, true)�
		
		
		class �ac.name� : public �IF ac.actorBase!=null��ac.actorBase.name��ELSE�etRuntime::ActorClassBase�ENDIF� {
		
			
			protected:
				//--------------------- ports
				�ac.endPorts.map(port | '''�port.portClassName� �port.name�;''').join("\n")�
				//--------------------- saps
				�ac.serviceAccessPoints.map(sap | '''�sap.portClassName� �sap.name�;''').join("\n")�
				//--------------------- services
				�ac.serviceImplementations.map(svc | '''�svc.portClassName� �svc.spp.name�;''').join("\n")�
			
				//--------------------- interface item IDs
				�xpac.genInterfaceItemConstants�
					
				�ac.attributes.attributes�

				�operationsImplementation(ac.operations, ac.name)�
		
			public:
				//--------------------- construction
				�ac.name�(etRuntime::IRTObject* parent, std::string name, const std::vector<std::vector<etRuntime::Address> >& port_addr, 
																		  const std::vector<std::vector<etRuntime::Address> >& peer_addr);

���	TODO: check whether attribute setters/getters are necessary at all, if yes own cpp implementation is needed for *,[],& variables
���				�attributeSettersGettersImplementation(ac.attributes, ac.name)�
				//--------------------- port getters
			�FOR ep : ac.getEndPorts()�
				�ep.portClassName.getterImplementation(ep.name, ac.name)�
			�ENDFOR�
			�FOR sap : ac.serviceAccessPoints�
				�sap.portClassName.getterImplementation(sap.name, ac.name)�
			�ENDFOR�
			�FOR svc : ac.serviceImplementations�
				�svc.portClassName.getterImplementation(svc.spp.name, ac.name)�
			�ENDFOR�
		
			//--------------------- lifecycle functions
				virtual void init();
				virtual void start();
			�IF !ac.overridesStop()�
				virtual void stop();
			�ENDIF�
				virtual void destroy();			
			�IF ac.hasNonEmptyStateMachine�
				�xpac.genStateMachineMethodDeclarations()�
			�ELSEIF !xpac.hasStateMachine()�
			public: 
				//--------------------- no state machine
				virtual void receiveEvent(etRuntime::InterfaceItemBase* ifitem, int evt, void* data);
				virtual void executeInitTransition();
			�ENDIF�

			�ac.userCode(2, false)�

		};
		
		
		�generateIncludeGuardEnd(ac.name)�
	'''
	}
	def private generateConstructorInitalizerList(ActorClass ac) { 
		var initializerList = new ArrayList<CharSequence>();
		if (ac.actorBase==null) {
			initializerList.add('''ActorClassBase( parent, name, port_addr[0][0], peer_addr[0][0])''')
		}
		else {
			initializerList.add('''�ac.actorBase.name�(*this, parent, name, port_addr, peer_addr)''')
		}
	    // own ports
		for ( ep : ac.getEndPorts() ) {
			initializerList.add('''�ep.name�(*this, this, "�ep.name�", IFITEM_�ep.name�, �IF ep.multiplicity==1�0, �ENDIF�port_addr[IFITEM_�ep.name�]�IF ep.multiplicity==1�[0]�ENDIF�, peer_addr[IFITEM_�ep.name�]�IF ep.multiplicity==1�[0]�ENDIF�)''');
		}
		// own saps
		for ( sap : ac.serviceAccessPoints ) {
			initializerList.add('''�sap.name�(*this, this, "�sap.name�", IFITEM_�sap.name�, 0, port_addr[IFITEM_�sap.name�][0], peer_addr[IFITEM_�sap.name�][0])''');
		}
		// own service implementations
		for (svc : ac.serviceImplementations) {
			initializerList.add('''�svc.spp.name�(*this, this, "�svc.spp.name�", IFITEM_�svc.spp.name�, port_addr[IFITEM_�svc.spp.name�], peer_addr[IFITEM_�svc.spp.name�])''');
		}
		for (attrib: ac.attributes) {
			initializerList.add(attrib.attributeInitialization(false))
		}
		return 
		'''
		  �initializerList.join(',\n')�
		'''
	}

	
	def private generateSourceFile(Root root, ExpandedActorClass xpac, ActorClass ac) {
//		val ctor = ac.operations.filter(op|op.constructor).head
//		val dtor = ac.operations.filter(op|op.destructor).head
		val async = xpac.actorClass.commType==ComponentCommunicationType::ASYNCHRONOUS
		
		'''
		/**
		 * @author generated by eTrice
		 *
		 * Source File of ActorClass �ac.name�
		 * 
		 */

		#include "�ac.getCppHeaderFileName�"
		#include "common/debugging/DebuggingService.h"
		#include <iostream>
		
		using namespace etRuntime;
		
		
		�ac.name�::�ac.name�(etRuntime::IRTObject* parent, std::string name, const std::vector<std::vector<etRuntime::Address> >& port_addr, 
		 						  											 const std::vector<std::vector<etRuntime::Address> >& peer_addr)
		:  �ac.generateConstructorInitalizerList�
		{
			�IF ac.hasNonEmptyStateMachine�
			history = new int[s_numberOfStates];
			for (int i = 0; i < s_numberOfStates; i++) {
				history[i] = NO_STATE;
			}
			�ENDIF�
			setClassName("�ac.name�");
			�ac.attributes.attributeInitialization(false)�
		
			�IF async�
			getMsgsvc()->addAsyncActor(*this);
			�ENDIF�
���			�IF ctor!=null�
���			// user defined constructor body
���			�AbstractGenerator::getInstance().getTranslatedCode(ctor.detailCode)�
���			�ENDIF�
		}
		
		void �ac.name�::init(){
			initUser();
		}
		
		void �ac.name�::start(){
			startUser();
		}
		
		�IF !ac.overridesStop()�
		void �ac.name�::stop(){
			stopUser();
		}
		�ENDIF�
		
���		void �ac.name�::destroy(){
���			�IF dtor!=null�
���				
���					// user defined destructor body
���					�AbstractGenerator::getInstance().getTranslatedCode(dtor.detailCode)�
���			�ENDIF�
���		}
		
		�IF ac.hasNonEmptyStateMachine�
			�xpac.genStateMachine(false)�
		�ELSEIF !xpac.hasStateMachine()�
			//--------------------- no state machine
			void �ac.name�::receiveEvent(etRuntime::InterfaceItemBase* ifitem, int evt, void* data) {
				handleSystemEvent(ifitem, evt, data);
			}
			
			void �ac.name�::executeInitTransition(){
			}
		�ENDIF�
		'''
	}
	
	
}
