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

package org.eclipse.etrice.generator.doc.setup;

import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.AbstractGeneratorBaseModule;
import org.eclipse.etrice.generator.base.AbstractGeneratorOptions;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.base.ITranslationProvider;
import org.eclipse.etrice.generator.doc.Main;
import org.eclipse.etrice.generator.generic.ILanguageExtension;

import com.google.inject.Binder;

public class GeneratorModule extends AbstractGeneratorBaseModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		
		binder.bind(AbstractGeneratorOptions.class).to(GeneratorOptions.class);
	}
	
	@Override
	public Class<? extends AbstractGenerator> bindAbstractGenerator() {
		return Main.class;
	}

	@Override
	public Class<? extends ILanguageExtension> bindILanguageExtension() {
		return null;
	}

	@Override
	public Class<? extends ITranslationProvider> bindITranslationProvider() {
		return null;
	}

	@Override
	public Class<? extends IDataConfiguration> bindIDataConfiguration() {
		return null;
	}

}
