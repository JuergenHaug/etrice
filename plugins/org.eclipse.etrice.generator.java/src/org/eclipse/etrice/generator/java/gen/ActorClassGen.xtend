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
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.generator.base.ILogger
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass
import org.eclipse.etrice.generator.etricegen.Root
import org.eclipse.xtext.generator.JavaIoFileSystemAccess

import org.eclipse.etrice.generator.extensions.RoomExtensions
import org.eclipse.etrice.generator.generic.ProcedureHelpers

@Singleton
class ActorClassGen {
	
	@Inject extension JavaIoFileSystemAccess fileAccess
	@Inject extension JavaExtensions stdExt
	@Inject extension RoomExtensions roomExt
	
	@Inject extension ProcedureHelpers helpers
	@Inject extension StateMachineGen stateMachineGen
	@Inject ILogger logger
	
	def doGenerate(Root root) {
		for (xpac: root.xpActorClasses) {
			var path = xpac.actorClass.generationTargetPath+xpac.actorClass.getPath
			var file = xpac.actorClass.getJavaFileName
			logger.logInfo("generating ActorClass implementation '"+file+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(file, root.generate(xpac, xpac.actorClass))
		}
	}
	
	def generate(Root root, ExpandedActorClass xpac, ActorClass ac) {'''
		package �ac.getPackage�;
		
		import org.eclipse.etrice.runtime.java.messaging.Address;
		import org.eclipse.etrice.runtime.java.messaging.IRTObject;
		import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
		import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
		import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
		import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
		import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
		
		�FOR model : root.getReferencedModels(ac)�import �model.name�.*;
		�ENDFOR�
		
		�FOR pc : root.getReferencedProtocolClasses(ac)�import �pc.^package�.�pc.name�.*;
		�ENDFOR�
		
		�helpers.UserCode(ac.userCode1)�
		
		
		public �IF ac.abstract�abstract �ENDIF�class �ac.name� extends �IF ac.base!=null��ac.base.name��ELSE�ActorClassBase�ENDIF� {
		
			�helpers.UserCode(ac.userCode2)�
			
			//--------------------- ports
			�FOR ep : ac.getEndPorts()�
				protected �ep.getPortClassName()� �ep.name� = null;
			�ENDFOR�
			//--------------------- saps
			�FOR sap : ac.strSAPs�
				protected �sap.getPortClassName()� �sap.name� = null;
			�ENDFOR�
			//--------------------- services
			�FOR svc : ac.serviceImplementations�
				protected �svc.getPortClassName()� �svc.spp.name� = null;
			�ENDFOR�
		
			//--------------------- interface item IDs
			�FOR ep : ac.getEndPorts()�
				protected static final int IFITEM_�ep.name� = �xpac.getInterfaceItemLocalId(ep)+1�;
			�ENDFOR�
			�FOR sap : ac.strSAPs�
				protected static final int IFITEM_�sap.name� = �xpac.getInterfaceItemLocalId(sap)+1�;
			�ENDFOR�
			�FOR svc : ac.serviceImplementations�
				protected static final int IFITEM_�svc.spp.name� = �xpac.getInterfaceItemLocalId(svc.spp)+1�;
			�ENDFOR�
			
			�helpers.Attributes(ac.attributes)�
			�helpers.OperationsImplementation(ac.operations, ac.name)�
		
			//--------------------- construction
			public �ac.name�(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
				�IF ac.base==null�
					super(parent, name, port_addr[0][0], peer_addr[0][0]);
				�ELSE�
					super(parent, name, port_addr, peer_addr);
				�ENDIF�
				setClassName("�ac.name�");
				
				// initialize attributes
				�FOR a : ac.attributes �
					�IF a.defaultValueLiteral!=null�
						�a.name� = �a.defaultValueLiteral�;
					�ELSEIF a.type.type!=null�
						�a.name� = new �a.type.type.name�();
					�ENDIF�
				�ENDFOR�
		
				// own ports
				�FOR ep : ac.getEndPorts()�
					�ep.name� = new �ep.getPortClassName()�(this, "�ep.name�", IFITEM_�ep.name�, �IF ep.multiplicity==1�0, �ENDIF�port_addr[IFITEM_�ep.name�]�IF ep.multiplicity==1�[0]�ENDIF�, peer_addr[IFITEM_�ep.name�]�IF ep.multiplicity==1�[0]�ENDIF�); 
				�ENDFOR�
				// own saps
				�FOR sap : ac.strSAPs�
					�sap.name� = new �sap.getPortClassName()�(this, "�sap.name�", IFITEM_�sap.name�, 0, port_addr[IFITEM_�sap.name�][0], peer_addr[IFITEM_�sap.name�][0]); 
				�ENDFOR�
				// own service implementations
				�FOR svc : ac.serviceImplementations�
					�svc.spp.name� = new �svc.getPortClassName()�(this, "�svc.spp.name�", IFITEM_�svc.spp.name�, port_addr[IFITEM_�svc.spp.name�], peer_addr[IFITEM_�svc.spp.name�]); 
				�ENDFOR�
			}
			
		
			//--------------------- lifecycle functions
			public void init(){
				initUser();
			}
		
			public void start(){
				startUser();
			}
		
			�IF !ac.overridesStop()�
			public void stop(){
				stopUser();
			}
			�ENDIF�
			
			public void destroy(){
				destroyUser();
			}	
		
			�IF ac.stateMachine != null�
				�stateMachineGen.genStateMachine(xpac, ac)�
			�ELSEIF !xpac.hasStateMachine()�
				//--------------------- no state machine
				@Override
				public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data) {
				handleSystemEvent(ifitem, evt, data);
				}
				
				@Override
				public void executeInitTransition(){
				}
			�ENDIF�
		};
	'''
	}
	
	def msgArgs(Message msg) {
		'''�IF msg.data!=null��msg.data.defaultValue()��ENDIF�'''
	}
}