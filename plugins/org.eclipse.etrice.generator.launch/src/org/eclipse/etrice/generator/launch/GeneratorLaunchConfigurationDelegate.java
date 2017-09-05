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

package org.eclipse.etrice.generator.launch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.core.variables.IStringVariableManager;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.ui.RefreshTab;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.fsm.base.ILineOutput;
import org.eclipse.etrice.generator.ui.preferences.PreferenceConstants;
import org.eclipse.jdt.launching.AbstractJavaLaunchConfigurationDelegate;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

import com.google.common.collect.Lists;

/**
 * @author Henrik Rentz-Reichert (initial contribution)
 *
 */
public abstract class GeneratorLaunchConfigurationDelegate extends AbstractJavaLaunchConfigurationDelegate{
	
	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		
		monitor.beginTask(configuration.getName()+"...", 3); //$NON-NLS-1$
		
		if (monitor.isCanceled()) {
			return;
		}
		try {
			StringBuffer argString = new StringBuffer();

			// constructing program arguments
			addModels(configuration, argString);
			addArguments(configuration, argString);

			String pgmArgs = argString.toString().trim();
			pgmArgs = VariablesPlugin.getDefault().getStringVariableManager()
					.performStringSubstitution(pgmArgs);

			// split at single spaces but keep strings in double quotes as single argument
			// (with double quotes removed)
			ArrayList<String> res = new ArrayList<String>();
			int begin = 0;
			int end = pgmArgs.indexOf(' ');
			boolean inQuotes = false;
			while (end>0) {
				if (pgmArgs.charAt(begin)=='\"')
					inQuotes = true;
				if ((inQuotes && pgmArgs.charAt(end-1)=='\"')) {
					inQuotes = false;
				}
				
				if (!inQuotes) {
					res.add(pgmArgs.substring(begin, end).replace("\"", ""));
					begin = end+1;
				}
				end = pgmArgs.indexOf(' ', end+1);
			}
			res.add(pgmArgs.substring(begin).replace("\"", ""));
			
			String[] args = new String[res.size()];
			res.toArray(args);

			final MessageConsole myConsole = findConsole(getConsoleName());
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					try {
						IWorkbench wb = PlatformUI.getWorkbench();
						IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
						IWorkbenchPage page = win.getActivePage();
						String id = IConsoleConstants.ID_CONSOLE_VIEW;
						IConsoleView view = (IConsoleView) page.showView(id);
						view.display(myConsole);
					} catch (PartInitException e) {
						e.printStackTrace();
					}
				}
			});
			MessageConsoleStream out = myConsole.newMessageStream();
			out.getConsole().clearConsole();
			ConsoleOutput output = new ConsoleOutput(out);
			runGenerator(args, output);

			// check for cancellation
			if (monitor.isCanceled()) {
				return;
			}
		} finally {
			monitor.done();
		}
		
		launchRefreshJob(configuration);
	}

	private void launchRefreshJob(final ILaunchConfiguration configuration) {
		Job job = new Job("refresh resources after code generation") {
			public IStatus run(IProgressMonitor monitor) {
				try {
					RefreshTab.refreshResources(configuration, monitor);
				} catch (CoreException e) {
					e.printStackTrace();
					return e.getStatus();
				}
				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}
	
	private MessageConsole findConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++)
			if (name.equals(existing[i].getName()))
				return (MessageConsole) existing[i];
		
		// no console found, so create a new one
		MessageConsole myConsole = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		return myConsole;
	}

	protected void addModels(ILaunchConfiguration configuration, StringBuffer argString) throws CoreException {
		IStringVariableManager variableManager = VariablesPlugin.getDefault().getStringVariableManager();
		
		List<String> models = Lists.newArrayList();
		for(String model : getModels(configuration)) {
			models.add(variableManager.performStringSubstitution(model));
		}
		if(configuration.getAttribute(GeneratorConfigTab.GEN_DEPS_WITHIN_PROJECT, true)) {
			// generate all dependencies within project for .etmap
			models = Lists.newArrayList(GeneratorLaunchHelper.getAllDependenciesWithinProjects(models));
		}
		for(String model : models) {
			argString.append(" \""+model+"\"");
		}		
	}
	
	@SuppressWarnings("unchecked")
	protected List<String> getModels(ILaunchConfiguration configuration) throws CoreException {
		return configuration.getAttribute("ModelFiles", Collections.EMPTY_LIST);
	}
	
	/**
	 * assemble the command line by adding further parameters
	 * 
	 * @param configuration
	 * @param argString
	 * @throws CoreException
	 */
	@SuppressWarnings("deprecation")	// keep compatible
	protected void addArguments(ILaunchConfiguration configuration, StringBuffer argString) throws CoreException {
		if (configuration.getAttribute(GeneratorConfigTab.LIB, false)) {
			argString.append(" "+AbstractGenerator.OPTION_LIB);
		}
		if (configuration.getAttribute(GeneratorConfigTab.SAVE_GEN_MODEL, false)) {
			argString.append(" "+AbstractGenerator.OPTION_SAVE_GEN_MODEL);
			argString.append(" "+configuration.getAttribute(GeneratorConfigTab.GEN_MODEL_PATH, "?"));
		}
		if (!configuration.getAttribute(GeneratorConfigTab.MAIN_METHOD_NAME, AbstractGenerator.DEFAULT_MAIN_NAME).equals(AbstractGenerator.DEFAULT_MAIN_NAME)) {
			argString.append(" "+AbstractGenerator.OPTION_MAIN_NAME);
			argString.append(" "+configuration.getAttribute(GeneratorConfigTab.MAIN_METHOD_NAME, AbstractGenerator.DEFAULT_MAIN_NAME));
		}
		if (configuration.getAttribute(GeneratorConfigTab.GEN_DOCUMENTATION, false)
				|| configuration.getAttribute(GeneratorConfigTab.GEN_INSTANCE_DIAGRAM, false))
			argString.append(" "+AbstractGenerator.OPTION_DOCUMENTATION);
		if (configuration.getAttribute(GeneratorConfigTab.DEBUG, false)) {
			argString.append(" "+AbstractGenerator.OPTION_DEBUG);
		}
		if (configuration.getAttribute(GeneratorConfigTab.MSC_INSTR, false)) {
			argString.append(" "+AbstractGenerator.OPTION_MSC_INSTR);
		}
		if (configuration.getAttribute(GeneratorConfigTab.DATA_INSTR, false)) {
			argString.append(" "+AbstractGenerator.OPTION_DATA_INSTR);
		}
		if (configuration.getAttribute(GeneratorConfigTab.VERBOSE, false)) {
			argString.append(" "+AbstractGenerator.OPTION_VERBOSE_RT);
		}
		if (!configuration.getAttribute(GeneratorConfigTab.USE_TRAANSLATION, true)) {
			argString.append(" "+AbstractGenerator.OPTION_NOTRANSLATE);
		}
		
		ScopedPreferenceStore prefStore = new ScopedPreferenceStore(InstanceScope.INSTANCE, "org.eclipse.etrice.generator.ui");
		if (prefStore.getBoolean(PreferenceConstants.GEN_INCREMENTAL)) {
			argString.append(" "+AbstractGenerator.OPTION_GEN_INCREMENTAL);
		}
		
		boolean override = configuration.getAttribute(GeneratorConfigTab.OVERRIDE_DIRECTORIES, false);
		String srcgenDir = prefStore.getString(PreferenceConstants.GEN_DIR);
		String infoDir = prefStore.getString(PreferenceConstants.GEN_INFO_DIR);
		String docDir = prefStore.getString(PreferenceConstants.GEN_DOC_DIR);
		if (override) {
			srcgenDir = configuration.getAttribute(GeneratorConfigTab.SRCGEN_PATH, srcgenDir);
			infoDir = configuration.getAttribute(GeneratorConfigTab.INFO_PATH, infoDir);
			docDir = configuration.getAttribute(GeneratorConfigTab.DOC_PATH, docDir);
		}
		argString.append(" "+AbstractGenerator.OPTION_GEN_DIR);
		argString.append(" "+srcgenDir);
		
		argString.append(" "+AbstractGenerator.OPTION_GEN_INFO_DIR);
		argString.append(" "+infoDir);
		
		argString.append(" "+AbstractGenerator.OPTION_GEN_DOC_DIR);
		argString.append(" "+docDir);
	}
	
	/**
	 * call the generator main method
	 * 
	 * @param args the command line arguments
	 * @param out line wise output to console
	 */
	protected abstract void runGenerator(String[] args, ILineOutput out);
	
	/**
	 * @return the name of the console for the generator output
	 */
	protected abstract String getConsoleName();
}
