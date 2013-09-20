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

package org.eclipse.etrice.generator.cpp;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.etmap.eTMap.MappingModel;
import org.eclipse.etrice.core.etmap.util.ETMapUtil;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.IDataConfiguration;
import org.eclipse.etrice.generator.base.IResourceURIAcceptor;
import org.eclipse.etrice.generator.cpp.gen.GeneratorSettings;
import org.eclipse.etrice.generator.cpp.gen.Validator;
import org.eclipse.etrice.generator.cpp.setup.GeneratorModule;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;

import com.google.inject.Inject;

public class Main extends AbstractGenerator {

	public static final String OPTION_ETUNIT = "-etunit";
	
	/**
	 * print usage message to output/console
	 */
	protected void printUsage() {
		output.println(this.getClass().getName()+getCommonOptions()
				+" <list of model file paths>");
		output.println(getCommonOptionDescriptions());
	}

	public static void main(String[] args) {
		int ret = createAndRunGenerator(new GeneratorModule(), args);
		if (isTerminateOnError() && ret!=GENERATOR_OK)
			System.exit(ret);
	}

	@Inject
	private IGenerator mainGenerator;

	@Inject
	protected org.eclipse.etrice.generator.doc.gen.MainGen mainDocGenerator; 
	
	@Inject
	private Validator validator;
	
	@Inject
	protected IDataConfiguration dataConfig;
	
	@Inject
	protected ImportUriResolver uriResolver;

	/**
	 * @return the unique {@link GlobalSettings}
	 */
	public static GeneratorSettings getSettings() {
		return (GeneratorSettings) getInstance().getGeneratorSettings();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.base.AbstractGenerator#parseOption(java.lang.String, java.util.Iterator)
	 */
	@Override
	protected boolean parseOption(String arg, Iterator<String> it) {
		if (arg.equals(OPTION_ETUNIT)) {
			getSettings().setUseEtUnit(true);
			return true;
		}
		
		return super.parseOption(arg, it);
	}
	
	protected int runGenerator() {
		setupRoomModel();
		dataConfig.doSetup();

		if (!loadModels(getSettings().getInputModelURIs())) {
			logger.logInfo("loading of models failed");
			logger.logError("-- terminating", null);
			return GENERATOR_ERROR;
		}

		if (!validateModels()) {
			logger.logInfo("validation failed");
			logger.logError("-- terminating", null);
			return GENERATOR_ERROR;
		}

		if (!dataConfig.setResources(getResourceSet(), logger)) {
			logger.logInfo("configuration errors");
			logger.logError("-- terminating", null);
			return GENERATOR_ERROR;
		}
		
		Root genModel = createGeneratorModel(getSettings().isGenerateAsLibrary(), getSettings().getGeneratorModelPath());
		if (diagnostician.isFailed() || genModel==null) {
			logger.logInfo("errors during build of generator model");
			logger.logError("-- terminating", null);
			return GENERATOR_ERROR;
		}
		
		if (!validator.validate(genModel)) {
			logger.logInfo("validation failed during build of generator model");
			logger.logError("-- terminating", null);
			return GENERATOR_ERROR;
		}
		
		ETMapUtil.processModels(genModel, getResourceSet(), diagnostician);
		if (getSettings().isDebugMode()) {
			logger.logInfo("-- begin dump of mappings");
			logger.logInfo(ETMapUtil.dumpMappings());
			logger.logInfo("-- end dump of mappings");
		}
		if (diagnostician.isFailed() || genModel==null) {
			logger.logInfo("errors in mapping");
			logger.logError("-- terminating", null);
			return GENERATOR_ERROR;
		}
		
		logger.logInfo("-- starting code generation");
		fileAccess.setOutputPath("src-gen/");
		mainGenerator.doGenerate(genModel.eResource(), fileAccess);
		
		if (getSettings().isGenerateDocumentation()) {
			mainDocGenerator.doGenerate(genModel);
		}
		
		if (diagnostician.isFailed()) {
			logger.logInfo("errors during code generation");
			logger.logError("-- terminating", null);
			return GENERATOR_ERROR;
		}
		logger.logInfo("-- finished code generation");
		
		return GENERATOR_OK;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.base.AbstractGenerator#addReferencedModels(org.eclipse.emf.ecore.resource.Resource, java.util.List)
	 */
	@Override
	protected void addReferencedModels(EObject root, IResourceURIAcceptor acceptor) {
		super.addReferencedModels(root, acceptor);
		
		if (root instanceof PhysicalModel) {
			for (org.eclipse.etrice.core.etphys.eTPhys.Import imp : ((PhysicalModel)root).getImports()) {
				String importURI = uriResolver.resolve(imp);
				acceptor.addResourceURI(importURI);
			}
		}
		else if (root instanceof MappingModel) {
			for (org.eclipse.etrice.core.etmap.eTMap.Import imp : ((MappingModel)root).getImports()) {
				String importURI = uriResolver.resolve(imp);
				acceptor.addResourceURI(importURI);
			}
		}
		else {
			dataConfig.addReferencedModels(acceptor, root);
		}
	}
}
