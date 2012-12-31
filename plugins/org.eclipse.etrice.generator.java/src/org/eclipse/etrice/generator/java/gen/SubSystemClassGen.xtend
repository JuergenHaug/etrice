/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.java.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.genmodel.base.ILogger
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.xtext.generator.JavaIoFileSystemAccess

import static extension org.eclipse.etrice.generator.base.Indexed.*
import org.eclipse.etrice.generator.base.IDataConfiguration
import org.eclipse.etrice.core.room.LogicalThread

@Singleton
class SubSystemClassGen {
	
	@Inject JavaIoFileSystemAccess fileAccess
	@Inject extension JavaExtensions
	@Inject extension RoomExtensions
	@Inject IDataConfiguration dataConfigExt
	@Inject ConfigGenAddon configGenAddon
	@Inject extension ProcedureHelpers

	@Inject VariableServiceGen varService
	@Inject ILogger logger
	
	def doGenerate(Root root) {
		for (ssi: root.subSystemInstances) {
			var path = ssi.subSystemClass.generationTargetPath+ssi.subSystemClass.getPath
			var file = ssi.subSystemClass.getJavaFileName
			logger.logInfo("generating SubSystemClass implementation: '"+file+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(file, root.generate(ssi))
			if(dataConfigExt.hasVariableService(ssi))
				varService.doGenerate(root, ssi);
		}
	}

	def generate(Root root, SubSystemInstance comp) {
		val cc = comp.subSystemClass
	'''
		package �cc.getPackage()�;
		
		�IF dataConfigExt.hasVariableService(comp)�
			import org.eclipse.etrice.runtime.java.config.VariableService;
		�ENDIF�
		import org.eclipse.etrice.runtime.java.messaging.IRTObject;
		import org.eclipse.etrice.runtime.java.messaging.MessageService;
		import org.eclipse.etrice.runtime.java.messaging.MessageServiceController;
		import org.eclipse.etrice.runtime.java.messaging.RTServices;
		import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
		import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
		import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
		
		�var models = root.getReferencedModels(cc)�
		�FOR model : models�import �model.name�.*;�ENDFOR�
		
		
		�cc.userCode(1)�
		
		public class �cc.name� extends SubSystemClassBase {
			
			public final int THREAD__DEFAULT = 0;
			�FOR thread : cc.threads.indexed�
				public final int �thread.value.threadId� = �thread.index1�;
			�ENDFOR�
		
			�cc.userCode(2)�
			
			public �cc.name�(IRTObject parent, String name) {
				super(parent, name);
			}
			
			@Override
			public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data){
			}
			
			@Override	
			public void instantiateMessageServices() {
			
				RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, 0, THREAD__DEFAULT, "MessageService_Main"));
				�FOR thread : cc.threads�
					RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, 0, �thread.threadId�, "MessageService_�thread.name�" /*, thread_prio */));
				�ENDFOR�
			}
		
			@Override
			public void instantiateActors() {
				
				MessageServiceController msgSvcCtrl = RTServices.getInstance().getMsgSvcCtrl();

				// thread mappings
				msgSvcCtrl.addPathToThread("�comp.path�", THREAD__DEFAULT);
				�FOR ai : comp.allContainedInstances�
					�val threadId = if (ai.threadId==0) "THREAD__DEFAULT" else cc.threads.get(ai.threadId-1).threadId�
					msgSvcCtrl.addPathToThread("�ai.path�", �threadId�);
				�ENDFOR�
				
				// port to peer port mappings
				�FOR ai : comp.allContainedInstances�
					�FOR pi : ai.orderedIfItemInstances�
						�val path=pi.path�
						�FOR peer : pi.peers�
							msgSvcCtrl.addPathToPeer("�path�", "�peer.path�");
						�ENDFOR�
					�ENDFOR�
				�ENDFOR�
		
				// instantiate all actor instances
				instances = new ActorClassBase[�comp.allContainedInstances.size�];
				�FOR ai : comp.allContainedInstances�
					instances[�comp.allContainedInstances.indexOf(ai)�] = new �ai.actorClass.name�(
						�IF ai.eContainer instanceof SubSystemInstance�
							this,
						�ELSE�
							instances[�comp.allContainedInstances.indexOf(ai.eContainer)�],
						�ENDIF�
						"�ai.name�"
						�IF !(dataConfigExt.getDynConfigReadAttributes(ai).empty && 
							dataConfigExt.getDynConfigWriteAttributes(ai).empty)�
							, variableService
						�ENDIF�
					); 
				�ENDFOR�
				
				// apply instance attribute configurations
				�FOR ai: comp.allContainedInstances�
					�val cfg = configGenAddon.genActorInstanceConfig(ai, "inst")�
					�IF cfg.length>0�
						{
							�ai.actorClass.name� inst = (�ai.actorClass.name�) instances[�comp.allContainedInstances.indexOf(ai)�];
							�cfg�
						}
					�ENDIF�
				�ENDFOR�
			}
			
			�IF dataConfigExt.hasVariableService(comp)�
				private VariableService variableService;
			�ENDIF�
			
			@Override
			public void init(){
				�IF dataConfigExt.hasVariableService(comp)�
					variableService = new �cc.name�VariableService(this);
				�ENDIF�
				super.init();
				�IF dataConfigExt.hasVariableService(comp)�
					variableService.init();
				�ENDIF�
			}
				
			@Override
			public void stop(){
				super.stop();
				�IF dataConfigExt.hasVariableService(comp)�
					variableService.stop();
				�ENDIF�
			}
				
		};
	'''
	}

	def private getThreadId(LogicalThread thread) {
		"THREAD_"+thread.name.toUpperCase
	}
}
