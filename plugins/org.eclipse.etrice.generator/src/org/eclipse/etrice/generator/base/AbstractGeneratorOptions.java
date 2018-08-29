/*******************************************************************************
* Copyright (c) 2018 protos software gmbh (http://www.protos.de).
* All rights reserved.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* CONTRIBUTORS:
*           Jan Belle (initial contribution)
*
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

import java.util.List;

import org.eclipse.etrice.generator.base.args.BooleanOption;
import org.eclipse.etrice.generator.base.args.Option;
import org.eclipse.etrice.generator.base.args.StringOption;
import org.eclipse.etrice.generator.base.setup.GeneratorBaseOptions;

public class AbstractGeneratorOptions extends GeneratorBaseOptions {
	
	public static final BooleanOption LIB = new BooleanOption(
			"lib",
			"generateAsLibrary",
			"if specified all classes are generated, not only instanciated ones",
			false);
	
	public static final BooleanOption DOCUMENTATION = new BooleanOption(
			"genDocu",
			"generateDocumentation",
			"if specified documentation is created",
			false);
	
	public static final StringOption SAVE_GEN_MODEL = new StringOption(
			"saveGenModel",
			"genmodel path",
			"if specified the generator model will be saved to this location",
			"");
	
	public static final StringOption MAIN_NAME = new StringOption(
			"mainName",
			"name",
			"if specified the generated main method will be named as stated",
			"main");
	
	public static final StringOption GEN_DOC_DIR = new StringOption(
			"genDocDir",
			"directory",
			"the directory for generated documentation files",
			"doc-gen");
	
	public static final BooleanOption MSC_INSTR = new BooleanOption(
			"msc_instr",
			"generateMSCInstrumentation",
			"generate instrumentation for MSC generation",
			false);
	
	public static final BooleanOption DATA_INSTR = new BooleanOption(
			"data_instr",
			"generateDataInstrumentation",
			"generate instrumentation for data logging",
			false);
	
	public static final BooleanOption VERBOSE_RT = new BooleanOption(
			"gen_as_verbose",
			"generateWithVerboseOutput",
			"generate instrumentation for verbose console output",
			false);
	
	public static final BooleanOption NOTRANSLATE = new BooleanOption(
			"notranslate",
			"noTranslation",
			"if specified the detail codes won't be translated",
			false);
	
	@Override
	public void configure(List<Option<?>> options) {
		super.configure(options);
		
		options.add(LIB);
		options.add(DOCUMENTATION);
		options.add(SAVE_GEN_MODEL);
		options.add(MAIN_NAME);
		options.add(GEN_DOC_DIR);
		options.add(MSC_INSTR);
		options.add(DATA_INSTR);
		options.add(VERBOSE_RT);
		options.add(NOTRANSLATE);
	}
}
