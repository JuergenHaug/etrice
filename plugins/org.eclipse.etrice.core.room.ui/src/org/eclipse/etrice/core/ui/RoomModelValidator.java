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

package org.eclipse.etrice.core.ui;

import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.validation.RoomJavaValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckMode;

import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.generator.builder.ILogger;
import org.eclipse.etrice.generator.builder.GeneratorModelBuilder;
import org.eclipse.etrice.generator.etricegen.IDiagnostician;

public class RoomModelValidator extends RoomJavaValidator implements ILogger {

	private class Diag implements IDiagnostician {
		private boolean failed = false;

		@Override
		public void warning(String msg, EObject source, EStructuralFeature feature) {
			warning(msg, source, feature, INSIGNIFICANT_INDEX);
		}

		@Override
		public void warning(String msg, EObject source, EStructuralFeature feature, int index) {
			issueWarning(msg, source, feature, index);
		}

		@Override
		public void error(String msg, EObject source, EStructuralFeature feature) {
			error(msg, source, feature, INSIGNIFICANT_INDEX);
		}

		@Override
		public void error(String msg, EObject source, EStructuralFeature feature, int index) {
			failed = true;
			issueError(msg, source, feature, index);
		}

		@Override
		public boolean isFailed() {
			return failed;
		}
	}
	
	@Check
	public void checkModel(RoomModel model) {
		if (getCheckMode()==CheckMode.ALL) {
			System.out.println("checking model "+model.getName());
			
			Diag diagnostician = new Diag();
			GeneratorModelBuilder builder = new GeneratorModelBuilder(this, diagnostician);
			
			LinkedList<RoomModel> models = new LinkedList<RoomModel>();
			models.add(model);
			builder.createGeneratorModel(models);

			System.out.println("done checking model "+model.getName()+" with result: "+(diagnostician.isFailed()?"failed":"ok"));
		}
	}
	
	public void issueError(String msg, EObject source, EStructuralFeature feature, int index) {
		if (index==IDiagnostician.INSIGNIFICANT_INDEX)
			index = INSIGNIFICANT_INDEX;
		error(msg, source, feature, index);
	}

	public void issueWarning(String msg, EObject source, EStructuralFeature feature, int index) {
		if (index==IDiagnostician.INSIGNIFICANT_INDEX)
			index = INSIGNIFICANT_INDEX;
		warning(msg, source, feature, index);
	}

	@Override
	public void logInfo(String text) {
	}

	@Override
	public void logError(String text, EObject obj) {
	}

}
