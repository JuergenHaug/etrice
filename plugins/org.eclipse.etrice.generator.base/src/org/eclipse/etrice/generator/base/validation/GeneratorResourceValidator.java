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

package org.eclipse.etrice.generator.base.validation;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.generator.base.GeneratorException;
import org.eclipse.etrice.generator.base.args.Arguments;
import org.eclipse.etrice.generator.base.logging.ILogger;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;

/**
 * Simple implementation of an resource validator using an {@link IResourceValidator}.
 */
public class GeneratorResourceValidator implements IGeneratorResourceValidator {
	
	private IResourceValidator resourceValidator;
	
	/**
	 * Creates a new instance that uses the specified resource validator.
	 * 
	 * @param resourceValiator the validator to use
	 */
	@Inject
	public GeneratorResourceValidator(IResourceValidator resourceValidator) {
		this.resourceValidator = resourceValidator;
	}
	
	@Override
	public void validate(List<Resource> resources, Arguments arguments, ILogger logger) throws GeneratorException {
		int errors = 0;
		int warnings = 0;
		
		ImmutableList<Resource> toValidate = ImmutableList.copyOf(resources);
		for (Resource resource : toValidate) {
			List<Issue> list = resourceValidator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
			
			for (Issue issue : list) {
				if (issue.getSeverity() == Severity.ERROR) {
					++errors;
					logger.logError(issue.toString());
				}
				else if(issue.getSeverity() == Severity.WARNING) {
					++warnings;
					logger.logWarning(issue.toString());
				}
				else {
					logger.logInfo(issue.toString());
				}
			}
		}
		
		// Bug 544504
		if(toValidate.size() != resources.size()) {
			throw new IllegalStateException("List of resources has changed during validation");
		}
		
		if(warnings > 0) {
			logger.logWarning(warnings + " warnings");
		}
		if(errors > 0) {
			logger.logError(errors + " errors");
			throw new GeneratorException("validation failed");
		}
	}
	
}
