/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
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
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.PortClass
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.TypeHelpers
import static extension org.eclipse.etrice.core.room.util.RoomHelpers.*

@Singleton
class Initialization {

	@Inject extension TypeHelpers typeHelpers
	@Inject extension RoomExtensions
	@Inject extension JavaExtensions languageExt
	@Inject extension ProcedureHelpers procedureHelpers
	
	def attributeInitialization(List<Attribute> attribs, EObject roomClass, boolean useClassDefaultsOnly) {	
		'''
			// initialize attributes
			�FOR a : attribs�
				�attributeClassInit(a, roomClass, useClassDefaultsOnly)�
				�IF a.type.type.dataClass��attributeInitPrimitiveRec(new ArrayList<Attribute>.union(a), roomClass)��ENDIF�
			�ENDFOR�
		'''
	}
	
	def private attributeClassInit(Attribute a, EObject roomClass, boolean useClassDefaultsOnly){
		var aType = a.type.type
		if(a.type.ref){
			if(a.defaultValueLiteral != null)
				attributeInit(a, a.defaultValueLiteral)
			else if(languageExt.needsInitialization(a))
				attributeInit(a, languageExt.nullPointer)	
		}
		else{
			if(aType.primitive){
				var value = getDataConfigValue(new ArrayList<Attribute>.union(a), roomClass)
				if(value == null) value = a.defaultValueLiteral
				if(value != null) attributeInit(a, languageExt.toValueLiteral(aType as PrimitiveType, value))
				else if(!useClassDefaultsOnly || languageExt.needsInitialization(a)) attributeInit(a, languageExt.defaultValue(aType))
			} else
				attributeInit(a, languageExt.defaultValue(aType))			
		}
	}
	
	def private CharSequence attributeInitPrimitiveRec(List<Attribute> path, EObject roomClass){
		var a = path.last
		var aType = a.type.type
		if(aType.dataClass){
			return '''
				�FOR e : (aType as DataClass).allAttributes�
					�attributeInitPrimitiveRec(path.union(e), roomClass)�
				�ENDFOR�
			'''
		}
		else if(aType.primitive){
			var value = getDataConfigValue(path, roomClass)
			return if(value != null) attributeInit(path, languageExt.toValueLiteral(aType as PrimitiveType, value))
		}
		else if(aType.enumeration) {
			// TODO-Enum
		}
	}
	
	def private attributeInit(Attribute a, String value){
		attributeInit(new ArrayList<Attribute>.union(a), value)
	}
	
	def private attributeInit(List<Attribute> path, String value){
		val getter = if(path.size == 1) "this" else procedureHelpers.invokeGetters(path.take(path.size-1), null).toString
	 	return genAttributeInitializer(path.last, value, getter)
	}
	
	def genAttributeInitializer(Attribute a, String value, String invokes){
		var aType = a.type.type
		// special treatment of char array with single character ('x')
		'''
		�IF a.size == 0 || (a.size > 0 && "char".equals(aType.typeName) && !value.matches("'.'|\\(char\\).*"))�
			�invokes�.�procedureHelpers.invokeSetter(a.name, null, value)�;
		�ELSEIF !value.trim.startsWith('{') || "char".equals(aType.typeName)�
			{
				�aType.typeName�[] array = new �aType.typeName�[�a.size�];
				�IF !(a.type.ref && aType.primitive)�
					for (int i=0;i<�a.size�;i++){
						array[i] = �value�;
					}
				�ENDIF�
				�invokes�.�procedureHelpers.invokeSetter(a.name, null, "array")�;
			}
		�ELSE�
			�invokes�.�procedureHelpers.invokeSetter(a.name,null, '''new �aType.typeName�[] �value�''')�;
		�ENDIF�
	 	'''
	}
	
	def private getDataConfigValue(List<Attribute> path, EObject roomClass){
		return switch roomClass{
			ActorClass:
				typeHelpers.getAttrClassConfigValue(path, roomClass, false)
			PortClass:
				typeHelpers.getAttrClassConfigValue(path, roomClass)
			DataClass: null
		}
	}
	
}