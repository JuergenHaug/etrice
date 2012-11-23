/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

/*
	collection of convenience functions for code generation
*/


package org.eclipse.etrice.generator.java.gen

import com.google.inject.Singleton
import java.util.List
import org.eclipse.etrice.core.room.DataType
import org.eclipse.etrice.core.room.ExternalType
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.VarDecl
import org.eclipse.etrice.generator.generic.ILanguageExtension
import org.eclipse.xtext.util.Pair

@Singleton
class JavaExtensions implements ILanguageExtension {

	override String getTypedDataDefinition(Message m) {
		generateArglistAndTypedData(m.data).get(1)
	}

	def String getJavaFileName(RoomClass rc) {rc.name+".java"}
	
	def String toWrapper(String type){
		switch(type){
			case "int": "Integer"
			case "char" : "Character"
			default: type.toFirstUpper
		}
	}
	
	override String accessLevelPrivate() {"private "}
	override String accessLevelProtected() {"protected "}
	override String accessLevelPublic() {"public "}
	
	override String memberAccess() {"this."} 	 
	override String selfPointer(String classname, boolean hasArgs) {""}
	override String selfPointer(boolean hasArgs) { "" }
	
	override String operationScope(String classname, boolean isDeclaration) {""}
	

	override String memberInDeclaration(String namespace, String member) {
		return member
	}
	
	override String memberInUse(String namespace, String member) {
		return namespace+"."+member
	}
	
	override boolean usesInheritance() {
		return true
	}
	
	override String genEnumeration(String name, List<Pair<String, String>> entries) {
		'''
		�FOR entry: entries�
			public static final int �entry.first� = �entry.second�;
		�ENDFOR�
		'''.toString
	}

	override String booleanConstant(boolean b) {
		b.toString
	}
	
	override String pointerLiteral() { "" }
	override String nullPointer() { "null" }
	override String voidPointer() { "Object" }

	override String arrayDeclaration(String type, int size, String name, boolean isRef) {
		type+" "+name+"[]"
	}
	
	override String constructorName(String cls) {
		cls
	}
	override String destructorName(String cls) {
		cls+"_dtor"
	}
	override String constructorReturnType() {
		""
	}
	override String destructorReturnType() {
		"void"
	}
	
	override String superCall(String baseClassName, String method, String args) {
		"super."+method+"("+args+");"
	}
	
	override toValueLiteral(PrimitiveType type, String value) {
		switch(type.targetName){
			case "char":
				castValue(type, value)
			case "string":
				castValue(type, value)
			case  value.contains(','):{
				var singleValues = value.replace('{', '').replace('}', '').trim.split(',')
				'''{ �FOR v: singleValues SEPARATOR ', '��castValue(type, v.trim)��ENDFOR� }'''.toString
			}
			default:
				castValue(type, value)		
		}
	}
	
	def private castValue(PrimitiveType type, String value){
		switch(type.targetName){
			case "boolean":
				return value
			case "byte":
				return "(byte)"+value
			case "short":
				return "(short)"+value
			case "int":
				return value
			case "long":
				return value+"L"
			case "float":
				return value+"f"
			case "double":
				return value+"d"
			case "char":{
				if(value.length == 1)
					return "'"+value+"'"
				else
					return "\""+value.replace("\\", "\\\\").replace("\"", "\\\"")+"\".toCharArray()"
			}
			case "String":
				return "\""+value.replace("\\", "\\\\").replace("\"", "\\\"")+"\""
		}
		
		throw new UnsupportedOperationException(type.targetName)
	}

	override defaultValue(DataType dt) {
		if (dt instanceof PrimitiveType) {
			var pType = dt as PrimitiveType
			return toValueLiteral(pType, pType.defaultValueLiteral)
		}
		else if (dt instanceof ExternalType)
			return "new "+(dt as ExternalType).targetName+"()"
		else
			return "new "+dt.name+"()"
	}
	

	override initializationWithDefaultValues(DataType dt, int size) {
		val dv = dt.defaultValue
		if (size>1) {
			var res = "{"
			var i = 0
			while (i<size) {
				res = res + dv
				i = i+1
				if (i<size)
					res = res + ","
			}
			res+"}"
		}
		else
			dv
	}

	override generateArglistAndTypedData(VarDecl data) {
		if (data==null)
			return newArrayList("", "", "")
		
		var typeName = data.getRefType().getType().getName();
		var castTypeName = typeName;
		if (data.getRefType().getType() instanceof PrimitiveType) {
			typeName = (data.getRefType().getType() as PrimitiveType).getTargetName();
			val ct = (data.getRefType().getType() as PrimitiveType).getCastName();
			if (ct!=null && !ct.isEmpty())
				castTypeName = ct;
		}

		val typedData = typeName+" "+data.getName() + " = ("+castTypeName+") generic_data;\n";
		val dataArg = ", "+data.getName();
		val typedArgList = ", "+typeName+" "+data.getName();
		
		return newArrayList(dataArg, typedData, typedArgList);
	}
	

	
}
