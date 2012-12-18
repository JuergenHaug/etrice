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

package org.eclipse.etrice.generator.launch;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class GeneratorConfigTab extends AbstractLaunchConfigurationTab {

	protected class UpdateConfig implements SelectionListener {
		public UpdateConfig() {
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			validate();
			setDirty(true);
			updateLaunchConfigurationDialog();
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			widgetSelected(e);
		}
	}

	/**
	 * @deprecated
	 * @see GEN_DOCUMENTATION
	 */
	public static final String GEN_INSTANCE_DIAGRAM = "GenInstanceDiagram";
	public static final String GEN_DOCUMENTATION = "GenDocumentation";
	
	public static final String GEN_MODEL_PATH = "GenModelPath";
	public static final String SAVE_GEN_MODEL = "SaveGenModel";
	public static final String LIB = "Lib";
	public static final String DEBUG = "Debug";
	public static final String MSC = "MSC";
	public static final String VERBOSE = "Verbose";
	
	private Button libButton;
	private Button documentationButton;
	private Button saveGenModel;
	private Text genModelPath;
	private Button browsePath;
	private Button debugButton;
	private Button mscButton;
	private Button verboseButton;

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		// Create main composite
		Composite mainComposite = new Composite(parent,SWT.NONE);
		setControl(mainComposite);
		
		GridLayout layout= new GridLayout();
		layout.numColumns = 2;
		layout.marginHeight = 10;
		layout.marginWidth = 10;
		mainComposite.setLayout(layout);
		
		libButton = createCheckButton(mainComposite, "generate all classes as library");
		libButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 2, 1));
		libButton.addSelectionListener(new UpdateConfig());

		saveGenModel = createCheckButton(mainComposite, "save generator model");
		saveGenModel.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 2, 1));
		saveGenModel.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleSaveGenModelSelected();
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				handleSaveGenModelSelected();
			}
			
		});
		genModelPath = new Text(mainComposite, SWT.SINGLE | SWT.BORDER);
    	genModelPath.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		genModelPath.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validate();
				setDirty(true);
				updateLaunchConfigurationDialog();
			}
		});
		browsePath = createPushButton(mainComposite, "Browse...", null);
		//browsePath.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 1, 1));
		browsePath.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handlePathButtonSelected();
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				handlePathButtonSelected();
			}
		});
		documentationButton = createCheckButton(mainComposite, "generate documentation");
		documentationButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 2, 1));
		documentationButton.addSelectionListener(new UpdateConfig());

		debugButton = createCheckButton(mainComposite, "debug output");
		debugButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 2, 1));
		debugButton.addSelectionListener(new UpdateConfig());

		mscButton = createCheckButton(mainComposite, "generate instrumentation for MSC generation");
		mscButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 2, 1));
		mscButton.addSelectionListener(new UpdateConfig());

		verboseButton = createCheckButton(mainComposite, "generate instrumentation for verbose output");
		verboseButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 2, 1));
		verboseButton.addSelectionListener(new UpdateConfig());
		
		addFurtherControls(mainComposite);
	}

	/**
	 * @param mainComposite
	 */
	protected void addFurtherControls(Composite mainComposite) {
	}

	/**
	 * 
	 */
	protected void handleSaveGenModelSelected() {
		boolean save = saveGenModel.getSelection();
		genModelPath.setEnabled(save);
		browsePath.setEnabled(save);
		validate();
		setDirty(true);
		updateLaunchConfigurationDialog();
	}

	/**
	 * 
	 */
	protected void validate() {
		if (saveGenModel.getSelection())
			if (genModelPath.getText().trim().isEmpty()) {
				setErrorMessage("generator model path must not be empty");
				return;
			}
		setErrorMessage(null);
	}

	/**
	 * 
	 */
	protected void handlePathButtonSelected() {
		ContainerSelectionDialog dialog = new ContainerSelectionDialog(getShell(),
				   ResourcesPlugin.getWorkspace().getRoot(),
				   false,
				   "select a container for the generator model");
		dialog.showClosedProjects(false);
		dialog.open();
		Object[] results = dialog.getResult();	
		if ((results != null) && (results.length > 0) && (results[0] instanceof IPath)) {
			IPath path = (IPath)results[0];
			//path = path.append("genmodel.rim");
			String fname = path.toString();
			fname = VariablesPlugin.getDefault().getStringVariableManager().generateVariableExpression("workspace_loc", fname);
			genModelPath.setText(fname);
			setErrorMessage(null);
			setDirty(true);
			updateLaunchConfigurationDialog();
		}		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			libButton.setSelection(configuration.getAttribute(LIB, false));
			boolean save = configuration.getAttribute(SAVE_GEN_MODEL, false);
			saveGenModel.setSelection(save);
			genModelPath.setEnabled(save);
			browsePath.setEnabled(save);
			genModelPath.setText(configuration.getAttribute(GEN_MODEL_PATH, ""));
			boolean genDocu = configuration.getAttribute(GEN_DOCUMENTATION, false);
			if (configuration.getAttribute(GEN_INSTANCE_DIAGRAM, false))
				genDocu = true;
			documentationButton.setSelection(genDocu);
			debugButton.setSelection(configuration.getAttribute(DEBUG, false));
			mscButton.setSelection(configuration.getAttribute(MSC, false));
			verboseButton.setSelection(configuration.getAttribute(VERBOSE, false));
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(LIB, libButton.getSelection());
		configuration.setAttribute(SAVE_GEN_MODEL, saveGenModel.getSelection());
		configuration.setAttribute(GEN_MODEL_PATH, genModelPath.getText());
		configuration.setAttribute(GEN_INSTANCE_DIAGRAM, documentationButton.getSelection());
		configuration.setAttribute(GEN_DOCUMENTATION, documentationButton.getSelection());
		configuration.setAttribute(DEBUG, debugButton.getSelection());
		configuration.setAttribute(MSC, mscButton.getSelection());
		configuration.setAttribute(VERBOSE, verboseButton.getSelection());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#canSave()
	 */
	@Override
	public boolean canSave() {
		if (saveGenModel.getSelection())
			return !genModelPath.getText().trim().isEmpty();
		
		return true;
	}

}
