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
 * 		Thomas Schuetz (changed for C code generator)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.c.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.core.etmap.util.ETMapUtil
import org.eclipse.etrice.core.common.base.util.BaseHelpers
import org.eclipse.etrice.generator.c.Main
import org.eclipse.etrice.generator.c.setup.GeneratorOptionsHelper
import org.eclipse.etrice.generator.base.io.IGeneratorFileIO

@Singleton
class NodeRunnerGen {

	@Inject extension BaseHelpers
	@Inject extension IGeneratorFileIO fileIO
	@Inject extension CExtensions
	@Inject extension RoomExtensions
	@Inject protected extension GeneratorOptionsHelper
	
	def doGenerate(Root root) {
		var first = true
		for (nr : ETMapUtil::getNodeRefs()) {
			for (instpath : ETMapUtil::getSubSystemInstancePaths(nr)) {
				val ssi = root.getInstance(instpath) as SubSystemInstance
				if (ssi!==null) {
					val clsname = nr.name+"_"+ssi.name
					val path = ssi.subSystemClass.getPath
					val file = clsname + "_Runner.c"
					fileIO.generateFile(path + file, root.generateSourceFile(ssi, first))
					first = false
				}
			}
		}
	}
	
	def generateSourceFile(Root root, SubSystemInstance ssi, boolean first) {
	val nr = ETMapUtil::getNodeRef(ssi)
	val clsname = nr.name+"_"+ssi.name
	val logData = Main.getSettings.isGenerateDataInstrumentation && ssi.subSystemClass.annotations.isAnnotationPresent("DataLogging")
	'''
		/**
		 * @author generated by eTrice
		 *
		 * this class contains the main function running Node �nr.name� with SubSystem �ssi.name�
		 * it instantiates Node �nr.name� with SubSystem �ssi.name� and starts and ends the lifecycle
		 */
		
		#include <string.h>
		
		#include "�nr.getCHeaderFileName(ssi)�"

		#include "debugging/etLogger.h"
		#include "debugging/etMSCLogger.h"
		#include "debugging/etDataLogger.h"
		
		#include "osal/etPlatformLifecycle.h"
		
		/**
		 * �Main.getSettings.mainMethodName� function
		 * creates components and starts and stops the lifecycle
		 */
		
		int �Main.getSettings.mainMethodName�(int argc, char** argv) {
			etBool runAsTest = ET_FALSE;
		
		#ifdef ET_DO_NOT_USE_ARGC_ARGV
		#else
			if (argc>1 && strcmp(argv[1], "-headless")==0)
				runAsTest = ET_TRUE;
			if (argc>1 && strcmp(argv[1], "-run_as_test")==0)
				runAsTest = ET_TRUE;
		#endif		
		
			etUserEntry(); /* platform specific */
			
			etLogger_logInfo("***   T H E   B E G I N   ***");
			ET_MSC_LOGGER_OPEN("main");
			�IF logData�
				ET_DATA_LOGGER_OPEN("main");
			�ENDIF�
		
			/* startup sequence  of lifecycle */
			�clsname�_init(); 		/* lifecycle init */
			�clsname�_start(); 	/* lifecycle start */
		
			etUserPreRun(); /* platform specific */

			/* run Scheduler */
			�clsname�_run(runAsTest);
		
			etUserPostRun(); /* platform specific */

			/* shutdown sequence of lifecycle */
			�clsname�_stop(); 		/* lifecycle stop */
			�clsname�_destroy(); 	/* lifecycle destroy */
		
			�IF logData�
				ET_DATA_LOGGER_CLOSE
			�ENDIF�
			ET_MSC_LOGGER_CLOSE
			etLogger_logInfo("***   T H E   E N D   ***");
		
			etUserExit(); /* platform specific */
		
			return 0;
		}
		
	'''
	}	
}