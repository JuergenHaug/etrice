/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Thomas Schuetz (changed for C code generator)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.c.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.room.SubSystemClass
import org.eclipse.etrice.generator.etricegen.Root
import org.eclipse.etrice.generator.etricegen.SubSystemInstance
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.etrice.generator.generic.RoomExtensions

@Singleton
class SubSystemRunnerGen {

	@Inject extension JavaIoFileSystemAccess fileAccess
	@Inject extension RoomExtensions roomExt
	
	def doGenerate(Root root) {
		for (sc: root.subSystemInstances) {
			fileAccess.setOutputPath(sc.subSystemClass.generationTargetPath+sc.subSystemClass.getPath)
			fileAccess.generateFile( sc.name+"_Runner.c", root.generateSourceFile(sc, sc.subSystemClass))
		}
	}
	
	def generateSourceFile(Root root, SubSystemInstance ssi, SubSystemClass ssc) {'''
		/**
		 * @author generated by eTrice
		 *
		 * this class contains the main function running component �ssi.name�
		 * it instantiates �ssi.name� and starts and ends the lifecycle
		 */
		
		
		#include "�ssi.name�.h"

		#include "debugging/etLogger.h"
		#include "debugging/etMSCLogger.h"
		#include "platform/etPlatform.h"
		
		
		/**
		 * main function
		 * creates component and starts and stops the lifecycle
		 */
		
		int main(void) {
			etUserEntry(); /* platform specific */
			
			etLogger_logInfo("***   T H E   B E G I N   ***");
			ET_MSC_LOGGER_OPEN("main");
		
			/* startup sequence  of lifecycle */
			�ssi.name�_init(); 		/* lifecycle init */
			�ssi.name�_start(); 	/* lifecycle start */
		
			etUserPreRun(); /* platform specific */

			/* run Scheduler */
			�ssi.name�_run();
		
			etUserPostRun(); /* platform specific */

			/* shutdown sequence of lifecycle */
			�ssi.name�_stop(); 		/* lifecycle stop */
			�ssi.name�_destroy(); 	/* lifecycle destroy */
		
			ET_MSC_LOGGER_CLOSE
			etLogger_logInfo("***   T H E   E N D   ***");
		
			etUserExit(); /* platform specific */
		
			return 0;
		}
		
	'''
	}	
}