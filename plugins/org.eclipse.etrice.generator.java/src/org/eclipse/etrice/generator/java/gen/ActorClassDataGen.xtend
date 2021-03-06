/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.java.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.HashMap
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.etrice.generator.base.io.IGeneratorFileIO
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions

@Singleton
class ActorClassDataGen {
	
	@Inject IGeneratorFileIO fileIO
	@Inject extension RoomHelpers
	@Inject extension RoomExtensions
	@Inject extension ProcedureHelpers
	
	def doGenerate(Root root) {
		val HashMap<ActorClass, WiredActorClass> ac2wired = new HashMap<ActorClass, WiredActorClass>
		root.wiredInstances.filter(w|w instanceof WiredActorClass).forEach[w|ac2wired.put((w as WiredActorClass).actorClass, w as WiredActorClass)]
		root.actorClasses.filter[!isDeprecatedGeneration].map[root.getExpandedActorClass(it)].forEach[xpac |
			val wired = ac2wired.get(xpac.actorClass)
			val path = xpac.actorClass.getPath
			var file = xpac.actorClass.name+"_DataObject.java"
			fileIO.generateFile("generating ActorClass implementation", path + file, root.generate(xpac, wired))
		]
	}
	
	def generate(Root root, ExpandedActorClass xpac, WiredActorClass wired) {
		val ac = xpac.actorClass
		val clsname = ac.name+"_DataObject"
		val models = root.getReferencedModels(ac)
		val baseClass = if (ac.base!==null) "extends "+ac.actorBase.name+"_DataObject " else ""
		
	'''
		package �ac.getPackage�;
		
		import org.eclipse.etrice.runtime.java.modelbase.IActorClassDataObject;
		�FOR model : models�
			import �model.name�.*;
		�ENDFOR�
		
		public class �clsname� �baseClass�implements IActorClassDataObject {
			
			�IF ac.hasNonEmptyStateMachine�
				// state and history
				private int state;
				private int[] history;
				
			�ENDIF�
			�ac.attributes.attributes�
			
			�IF ac.hasNonEmptyStateMachine�
				public int getState() {
					return state;
				}
				
				public void setState(int state) {
					this.state = state;
				}
				
				public int[] getHistory() {
					return history;
				}
				
				public void setHistory(int[] history)  {
					this.history = history;
				}
				
			�ENDIF�
			�attributeSettersGettersImplementation(ac.attributes, ac.name)�
			
		};
	'''
	}
}
