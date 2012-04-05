/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Thomas Schuetz (refactoring, adapted for other target languages)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.generic

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DetailCode
import org.eclipse.etrice.core.room.Operation
import org.eclipse.etrice.core.room.VarDecl
import org.eclipse.etrice.core.room.ComplexType
import static extension org.eclipse.etrice.core.room.util.RoomHelpers.*

import org.eclipse.etrice.generator.base.DetailCodeTranslator
import org.eclipse.etrice.generator.base.ILogger
import org.eclipse.etrice.generator.base.ITranslationProvider
import org.eclipse.emf.common.util.EList
import org.eclipse.etrice.core.room.RefableType



@Singleton
class ProcedureHelpers {

	@Inject extension ILanguageExtension languageExt
	@Inject public ITranslationProvider translator
	@Inject extension TypeHelpers
	@Inject ILogger logger

	def userCode(DetailCode dc) {'''
		�IF dc!=null�
			/*--------------------- begin user code ---------------------*/
			�FOR command : dc.commands�	�command�
			�ENDFOR�
			/*--------------------- end user code ---------------------*/
		�ENDIF�
	'''
	}
	
	// Attributes 
	/* TODO: add ref type */
	def attributes(List<Attribute> attribs) {'''
		/*--------------------- attributes ---------------------*/
		�FOR attribute : attribs�
			�IF attribute.size==0�
				�attribute.refType.type.typeName��IF attribute.refType.ref��languageExt.pointerLiteral()��ENDIF� �attribute.name�;
			�ELSE�
				�languageExt.arrayDeclaration(attribute.refType.type.typeName, attribute.size, attribute.name, attribute.refType.ref)�;
			�ENDIF� 
		�ENDFOR�
	'''
	}

	def arrayInitializer(Attribute att) {
		var dflt = if (att.defaultValueLiteral!=null) att.defaultValueLiteral else att.refType.type.defaultValue

		if (dflt.startsWith("{")) {
			if (dflt.split(",").size!=att.size)
				logger.logInfo("WARNING: array size determined by initializer differs from attribute size ("+att.name+"["+att.size+"] <-> "+dflt+")")
				
			return dflt
		}

		var result = "{"
		var int i = 0
		while (i<att.size) {
			result = result + dflt
			i=i+1
			if (i<att.size)
				result = result + ", "
		}
		return result+"}"
	}
	
	def attributeInitialization(List<Attribute> attribs, boolean useClassDefaultsOnly) {
		'''
			// initialize attributes
			�FOR a : attribs�
				�IF a.defaultValueLiteral!=null�
					�IF a.size==0�
						�a.name� = �a.defaultValueLiteral�;
					�ELSEIF a.defaultValueLiteral.startsWith("{")�
							�a.name� = new �a.refType.type.typeName�[] �a.defaultValueLiteral�;
					�ELSE�
						�a.name� = new �a.refType.type.typeName�[�a.size�];
						for (int i=0;i<�a.size�;i++){
							�a.name�[i] = �a.defaultValueLiteral�;
						}
					�ENDIF�
				�ELSEIF a.refType.type instanceof ComplexType || a.size>1 || !useClassDefaultsOnly�
					�IF a.size==0�
						�IF a.refType.isRef�
							�a.name� = �languageExt.nullPointer()�;
						�ELSE�
							�a.name� = �a.refType.type.defaultValue�;
						�ENDIF�
					�ELSE�
						�a.name� = new �a.refType.type.typeName�[�a.size�];
						�IF !useClassDefaultsOnly�
							for (int i=0;i<�a.size�;i++){
								�a.name�[i] = �IF a.refType.isRef��languageExt.nullPointer()��ELSE��a.refType.type.defaultValue��ENDIF�;
							}
						�ENDIF�
					�ENDIF�
				�ENDIF�
			�ENDFOR�
		'''
	}
	
	// Attribute setters & getters
	def attributeSettersGettersDeclaration(List<Attribute> attribs, String classname) {'''
		//--------------------- attribute setters and getters
		�FOR attribute : attribs�
			�setterHeader(attribute, classname)�;
			�getterHeader(attribute, classname)�;
		�ENDFOR�
	'''
	}
	
	def attributeSettersGettersImplementation(List<Attribute> attribs, String classname) {'''
		//--------------------- attribute setters and getters
		�FOR attribute : attribs��setterHeader(attribute, classname)� {
			 �languageExt.memberAccess()��attribute.name� = �attribute.name�;
		}
		�getterHeader(attribute, classname)� {
			return �languageExt.memberAccess()��attribute.name�;
		}
		�ENDFOR�
	'''
	}
	
	def private setterHeader(Attribute attribute, String classname){'''
		�languageExt.accessLevelPublic()�void set�attribute.name.toFirstUpper()� (�languageExt.selfPointer(classname, true)��attribute.refType.type.typeName��IF attribute.size!=0�[]�ENDIF� �attribute.name�)'''
	}
	def private getterHeader(Attribute attribute, String classname){'''
		�languageExt.accessLevelPublic()��attribute.refType.type.typeName��IF attribute.size!=0�[]�ENDIF� get�attribute.name.toFirstUpper()� (�languageExt.selfPointer(classname, false)�)'''
	}
	
	def argList(List<Attribute> attributes) {
		'''�FOR a : attributes SEPARATOR ", "��a.refType.type.typeName��IF a.size>1�[]�ENDIF� �a.name��ENDFOR�'''
	}

	
	// Operations
	def operationsDeclaration(List<? extends Operation> operations, String classname) {'''
		/*--------------------- operations ---------------------*/
		�FOR operation : operations�
			�IF !(languageExt.usesInheritance && operation.constructor)�
				�operationSignature(operation, classname, true)�;
			�ENDIF�
		�ENDFOR�
		'''
	}

	def operationsImplementation(List<? extends Operation> operations, String classname) {
	'''
		/*--------------------- operations ---------------------*/
		�FOR operation : operations�
			�IF !(languageExt.usesInheritance && operation.constructor)�
				�operationSignature(operation, classname, false)� {
					�FOR command : operation.detailCode.commands�
						�command�
					�ENDFOR�
				}
			�ENDIF�
		�ENDFOR�
		'''
	}

	def operationsImplementation(ActorClass ac) {
		translator.setActorClass(ac)
		var dct = new DetailCodeTranslator(ac, translator)
		
	'''
		/*--------------------- operations ---------------------*/
		�FOR operation : ac.operations�
			�IF !(languageExt.usesInheritance && operation.constructor)�
				�operationSignature(operation, ac.name, false)� {
					�dct.translateDetailCode(operation.detailCode)�
				}
			�ENDIF�
		�ENDFOR�
		'''
	}
	
	
	def private operationSignature(Operation operation, String classname, boolean isDeclaration) {
		if (operation.constructor)
			classOperationSignature(classname, languageExt.constructorName(classname), "", languageExt.constructorReturnType, isDeclaration)
		else if (operation.destructor)
			classOperationSignature(classname, languageExt.destructorName(classname), "", languageExt.destructorReturnType, isDeclaration)
		else
			classOperationSignature(classname, operation.name, BuildArgumentList(operation.arguments).toString, dataTypeToString(operation.returntype), isDeclaration)
	}

	def private dataTypeToString(RefableType type) {
		return if (type==null)
			"void"
		else 
			if (type.isRef){
				type.type.typeName+languageExt.pointerLiteral();
			}else{
				type.type.typeName
			}
	}

	/*
	 * builds comma separated argument list as string from EList<VarDecl> arguments
	 */
	def private BuildArgumentList(EList<VarDecl> arguments){
		'''�FOR argument : arguments SEPARATOR ", "��argument.refType.type.typeName��IF argument.refType.ref��languageExt.pointerLiteral()��ENDIF� �argument.name��ENDFOR�'''
	}
	
	def private classOperationSignature(String classname, String operationname, String argumentList, String returnType, boolean isDeclaration){
		'''�languageExt.accessLevelPublic()��returnType� �memberInDeclaration(classname, operationname)�(�languageExt.selfPointer(classname, !argumentList.empty)��argumentList�)'''
	}
	
}