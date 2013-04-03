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
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.etrice.generator.base.ILineOutput;
import org.eclipse.etrice.generator.java.Main;
import org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate;
import org.eclipse.etrice.generator.ui.preferences.PreferenceConstants;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class JavaGeneratorLaunchConfigurationDelegate extends GeneratorLaunchConfigurationDelegate {

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate#addArguments(org.eclipse.debug.core.ILaunchConfiguration, java.lang.StringBuffer)
	 */
	@SuppressWarnings("deprecation")	// stay compatible with older launch configurations
	@Override
	protected void addArguments(ILaunchConfiguration configuration, StringBuffer argString) throws CoreException {
		if (configuration.getAttribute(JavaGeneratorConfigTab.LIB, false)) {
			argString.append(" "+Main.OPTION_LIB);
		}
		if (configuration.getAttribute(JavaGeneratorConfigTab.SAVE_GEN_MODEL, false)) {
			argString.append(" "+Main.OPTION_SAVE_GEN_MODEL);
			argString.append(" "+configuration.getAttribute(JavaGeneratorConfigTab.GEN_MODEL_PATH, "?"));
		}
		if (configuration.getAttribute(JavaGeneratorConfigTab.GEN_DOCUMENTATION, false)
				|| configuration.getAttribute(JavaGeneratorConfigTab.GEN_INSTANCE_DIAGRAM, false))
			argString.append(" "+Main.OPTION_DOCUMENTATION);
		if (configuration.getAttribute(JavaGeneratorConfigTab.DEBUG, false)) {
			argString.append(" "+Main.OPTION_DEBUG);
		}
		if (configuration.getAttribute(JavaGeneratorConfigTab.MSC, false)) {
			argString.append(" "+Main.OPTION_MSC);
		}
		if (configuration.getAttribute(JavaGeneratorConfigTab.VERBOSE, false)) {
			argString.append(" "+Main.OPTION_VERBOSE_RT);
		}
		
		ScopedPreferenceStore prefStore = new ScopedPreferenceStore(InstanceScope.INSTANCE, "org.eclipse.etrice.generator.ui");
		if (prefStore.getBoolean(PreferenceConstants.GEN_INCREMENTAL)) {
			argString.append(" "+Main.OPTION_GEN_INCREMENTAL);
		}
		
		argString.append(" "+Main.OPTION_GEN_DIR);
		argString.append(" "+prefStore.getString(PreferenceConstants.GEN_DIR));
		
		argString.append(" "+Main.OPTION_GEN_INFO_DIR);
		argString.append(" "+prefStore.getString(PreferenceConstants.GEN_INFO_DIR));
		
		argString.append(" "+Main.OPTION_GEN_DOC_DIR);
		argString.append(" "+prefStore.getString(PreferenceConstants.GEN_DOC_DIR));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate#runGenerator(java.lang.String[], org.eclipse.etrice.generator.launch.ILineOutput)
	 */
	@Override
	protected void runGenerator(String[] args, ILineOutput out) {
		org.eclipse.etrice.generator.java.Main.setOutput(out);
		org.eclipse.etrice.generator.java.Main.setTerminateOnError(false);
		org.eclipse.etrice.generator.java.Main.main(args);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate#getConsoleName()
	 */
	@Override
	protected String getConsoleName() {
		return "eTrice Java Generator Console";
	}

}
