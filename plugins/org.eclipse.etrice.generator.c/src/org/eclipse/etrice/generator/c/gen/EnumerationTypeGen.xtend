/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.c.gen

import com.google.inject.Inject
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.room.EnumerationType
import org.eclipse.etrice.generator.base.io.IGeneratorFileIO
import org.eclipse.etrice.generator.generic.TypeHelpers

/**
 * @author Henrik Rentz-Reichert
 *
 */
class EnumerationTypeGen {

	@Inject IGeneratorFileIO fileIO
	@Inject extension CExtensions
	@Inject extension RoomExtensions
	@Inject extension TypeHelpers
	
	def doGenerate(Root root) {
		for (et: root.enumClasses) {
			val path = et.generationTargetPath+et.getPath
			val infopath = et.generationInfoPath+et.getPath
			var file = et.getCHeaderFileName

			// header file
			fileIO.generateFile("generating Enumeration header", path, infopath, file, root.generateHeaderFile(et))

			// header file
			file = et.getCSourceFileName
			fileIO.generateFile("generating Enumeration source", path, infopath, file, root.generateSourceFile(et))
		}
	}
	
	private def generateHeaderFile(Root root, EnumerationType et) {
		'''
		/**
		 * @author generated by eTrice
		 *
		 * Header File of Enumeration �et.name�
		 * 
		 */

		�generateIncludeGuardBegin(et)�
		
		#include "etDatatypes.h"
		
		�IF et.getPrimitiveType()!==null�
			�FOR lit: et.literals�
				#define �et.name�_�lit.name� �lit.castedValue�
			�ENDFOR�
		�ELSE�
			typedef enum �et.name� {
				�FOR lit: et.literals SEPARATOR ","�
					�et.name�_�lit.name� = �lit.literalValue�
				�ENDFOR�
			}
			�et.name�;
		�ENDIF�
		
		const char* �et.name�_getLiteralName(�et.typeName� literal);
		
		�generateIncludeGuardEnd(et)�
		'''
	}
	
	private def generateSourceFile(Root root, EnumerationType et) {
		'''
		/**
		 * @author generated by eTrice
		 *
		 * Source File of ProtocolClass �et.name�
		 * 
		 */

		#include "�et.getCHeaderFileName�"
		
		const char* �et.name�_getLiteralName(�et.typeName� literal) {
			switch(literal) {
				�FOR lit: et.literals�
					case �et.name�_�lit.name�: return "�lit.name�";
				�ENDFOR�
			}
			return NULL;
		}
		
		'''
	}
	
}