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

package org.eclipse.etrice.generator.java.setup;

import org.eclipse.etrice.core.scoping.PlatformRelativeUriResolver;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.AbstractGeneratorBaseModule;
import org.eclipse.etrice.generator.base.GlobalGeneratorSettings;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.base.ITranslationProvider;
import org.eclipse.etrice.generator.java.Main;
import org.eclipse.etrice.generator.java.gen.GlobalSettings;
import org.eclipse.etrice.generator.java.gen.MainGen;
import org.eclipse.etrice.generator.java.gen.JavaTranslationProvider;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.etrice.generator.generic.ILanguageExtension;
import org.eclipse.etrice.generator.java.gen.JavaExtensions;





import com.google.inject.Binder;

public class GeneratorModule extends AbstractGeneratorBaseModule {

//	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		
		binder.bind(AbstractGenerator.class).to(Main.class);
		binder.bind(IGenerator.class).to(MainGen.class);

		binder.bind(ImportUriResolver.class).to(PlatformRelativeUriResolver.class);
		
		binder.bind(GlobalGeneratorSettings.class).to(GlobalSettings.class);
	}

	@Override
	public Class<? extends ILanguageExtension> bindILanguageExtension() {
		return JavaExtensions.class;
	}

	@Override
	public Class<? extends ITranslationProvider> bindITranslationProvider() {
		return JavaTranslationProvider.class;
	}

	@Override
	public Class<? extends IDataConfiguration> bindIDataConfiguration() {
		return org.eclipse.etrice.generator.config.DataConfiguration.class;
	}

}
