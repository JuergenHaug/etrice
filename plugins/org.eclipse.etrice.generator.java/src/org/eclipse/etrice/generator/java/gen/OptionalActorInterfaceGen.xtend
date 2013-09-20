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

import com.google.inject.Singleton
import com.google.inject.Inject
import org.eclipse.etrice.generator.base.IGeneratorFileIo
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.core.genmodel.etricegen.Root

import static extension org.eclipse.etrice.core.room.util.RoomHelpers.*
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.generator.java.Main

@Singleton
class OptionalActorInterfaceGen extends GenericActorClassGenerator {

	@Inject IGeneratorFileIo fileIO
	@Inject extension JavaExtensions
	@Inject extension RoomExtensions
	
	def doGenerate(Root root) {
		for (ac: root.optionalActorClasses) {
			val path = ac.generationTargetPath+ac.path
			val infopath = ac.generationInfoPath+ac.path
			var file = ac.getJavaInterfaceFileName(false)
			fileIO.generateFile("generating ActorClass Interface implementation", path, infopath, file, root.generate(ac, false))

			file = ac.getJavaInterfaceFileName(true)
			fileIO.generateFile("generating ActorClass Interface implementation", path, infopath, file, root.generate(ac, true))
		}
	}
	
	def generate(Root root, ActorClass ac, boolean replicated) {
		val baseClass = if (replicated) "ReplicatedOptionalActorInterfaceBase" else "ScalarOptionalActorInterfaceBase"
		'''
			package �ac.getPackage�;
			
			�IF Main::settings.generateMSCInstrumentation�
				import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
			�ENDIF�
			import org.eclipse.etrice.runtime.java.modelbase.IEventReceiver;
			import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBroker;
			import org.eclipse.etrice.runtime.java.modelbase.�baseClass�;
			
			class �ac.getJavaInterfaceName(replicated)� extends �baseClass� {
				//--------------------- brokers for ports on the interface
				�FOR ep : ac.allInterfacePorts�
					protected InterfaceItemBroker �ep.name� = null;
				�ENDFOR�

				//--------------------- interface item IDs
				�ac.genInterfaceItemConstantsForOptionalActor�
				
				//--------------------- construction
				public �ac.getJavaInterfaceName(replicated)� (IEventReceiver parent, String name) {
					super(parent, name, "�ac.name�");
					
					�FOR ep : ac.allInterfacePorts�
						�IF ep.replicated�
							�ep.name� = new ReplicatedInterfaceItemBroker(this, "�ep.name�", IFITEM_�ep.name�);
						�ELSE�
							�ep.name� = new InterfaceItemBroker(this, "�ep.name�", IFITEM_�ep.name�);
						�ENDIF�
					�ENDFOR�
				}
				�IF Main::settings.generateMSCInstrumentation�
					
					@Override
					protected void logCreation(String actorClass, String name) {
						DebuggingService.getInstance().addMessageActorCreate(this, actorClass, name);
					}
					
					@Override
					protected void logDeletion(String name) {
						DebuggingService.getInstance().addMessageActorDestroy(this, name);
					}
				�ENDIF�
			}
		'''
	}	
}