/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.launch.java;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.etrice.generator.base.ILineOutput;
import org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate;

/**
 * @author hrentz
 *
 */
public class JavaGeneratorLaunchConfigurationDelegate extends GeneratorLaunchConfigurationDelegate {

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate#addArguments(org.eclipse.debug.core.ILaunchConfiguration, java.lang.StringBuffer)
	 */
	@Override
	protected void addArguments(ILaunchConfiguration configuration, StringBuffer argString) throws CoreException {
		if (configuration.getAttribute(JavaGeneratorConfigTab.SAVE_GEN_MODEL, false)) {
			argString.append(" -saveGenModel");
			argString.append(" file://"+configuration.getAttribute(JavaGeneratorConfigTab.GEN_MODEL_PATH, "?"));
		}
		if (configuration.getAttribute(JavaGeneratorConfigTab.GEN_INSTANCE_DIAGRAM, false))
			argString.append(" -genInstDiag");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate#runGenerator(java.lang.String[], org.eclipse.etrice.generator.launch.ILineOutput)
	 */
	@Override
	protected void runGenerator(String[] args, ILineOutput out) {
		org.eclipse.etrice.generator.java.Main.setOutput(out);
		org.eclipse.etrice.generator.java.Main.main(args);
	}

}
