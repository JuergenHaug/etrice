/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class FSMtestStandaloneSetup extends FSMtestStandaloneSetupGenerated{

	public static void doSetup() {
		new FSMtestStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

