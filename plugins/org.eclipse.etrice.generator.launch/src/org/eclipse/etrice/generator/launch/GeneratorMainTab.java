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

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;

/**
 * @author Henrik Rentz-Reichert (initial contribution)
 *
 */
public abstract class GeneratorMainTab extends AbstractLaunchConfigurationTab {

	private List modelList;
	private Text projectText;
	private Button browseProject;
	
	@Override
	public void createControl(Composite parent) {
		try{
			// Create main composite
			Composite mainComposite = new Composite(parent,SWT.NONE);
			setControl(mainComposite);
			
			GridLayout layout= new GridLayout();
			layout.numColumns = 2;
			layout.marginHeight = 10;
			layout.marginWidth = 10;
			mainComposite.setLayout(layout);
	
			createProjectEditor(mainComposite);
			
			createModelsEditor(mainComposite);
			
			Dialog.applyDialogFont(mainComposite);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param mainComposite
	 */
	private void createModelsEditor(Composite mainComposite) {
		createModelList(mainComposite);
		createModelButtons(mainComposite);
	}

	/**
	 * @param parent
	 */
	private void createModelButtons(Composite parent) {
		Composite buttons = new Composite(parent,SWT.NONE | SWT.TOP);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		buttons.setLayout(layout);
		GridData gd = new GridData();
		gd.verticalAlignment = SWT.BEGINNING;
		buttons.setLayoutData(gd);

		makeButton(buttons, new AddModel(), "Add (filtered)");
		makeButton(buttons, new AddModelAlt(), "Add (selection)");
		makeButton(buttons, new RemoveModel(), "Remove");
		makeButton(buttons, new MoveModelUp(), "Move Up");
		makeButton(buttons, new MoveModelDown(), "Move Down");
	}

	/**
	 * @param parent
	 */
	private void createModelList(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText("ROOM Models:");
		GridData gd = new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false, 2, 1);
		gd.verticalIndent = 20;
		label.setLayoutData(gd);

		modelList = new List(parent,SWT.NONE | SWT.BORDER | SWT.SINGLE);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		modelList.setLayoutData(gridData);
	}

	/**
	 * @param buttons
	 * @param listener
	 * @param label
	 * @return
	 */
	private GridData makeButton(Composite buttons, Listener listener, String label) {
		Button addBtn = new Button(buttons, SWT.PUSH | SWT.CENTER | SWT.TOP);
		addBtn.setText(label);
		GridData gd = new GridData();
		gd.horizontalAlignment = GridData.FILL;
		gd.grabExcessHorizontalSpace = false;
		addBtn.setLayoutData(gd);
		addBtn.addListener(SWT.Selection,listener);
		return gd;
	}
	
	protected void createProjectEditor(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText("Project:");
		GridData gd = new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false, 2, 1);
		label.setLayoutData(gd);
		
		projectText = createSingleText(parent, 1);
		projectText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
		browseProject = createPushButton(parent, "Browse...", null); 
		browseProject.addSelectionListener(new SelectionListener(	) {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleProjectButtonSelected();
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				handleProjectButtonSelected();
			}
		});
	}

	private void updateProjectFromConfig(ILaunchConfiguration config) {
		String projectName = "";
		try {
			projectName = config.getAttribute(IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME, "");	
		}
		catch (CoreException ce) {
			setErrorMessage(ce.getStatus().getMessage());
		}
		projectText.setText(projectName);
	}
	
	private void handleProjectButtonSelected() {
		IJavaProject project = chooseJavaProject();
		if (project == null) {
			return;
		}
		String projectName = project.getElementName();
		projectText.setText(projectName);
		updateLaunchConfigurationDialog();
	}
	
	private IJavaProject chooseJavaProject() {
		ILabelProvider labelProvider= new JavaElementLabelProvider(JavaElementLabelProvider.SHOW_DEFAULT);
		ElementListSelectionDialog dialog= new ElementListSelectionDialog(getShell(), labelProvider);
		dialog.setTitle("Project Selection"); 
		dialog.setMessage("Select a project to constrain your search"); 
		try {
			dialog.setElements(JavaCore.create(getWorkspaceRoot()).getJavaProjects());
		}
		catch (JavaModelException jme) {Activator.getDefault().log(jme);}
		IJavaProject javaProject= getJavaProject();
		if (javaProject != null) {
			dialog.setInitialSelections(new Object[] { javaProject });
		}
		if (dialog.open() == Window.OK) {			
			return (IJavaProject) dialog.getFirstResult();
		}		
		return null;		
	}

	private IJavaModel getJavaModel() {
		return JavaCore.create(getWorkspaceRoot());
	}
	
	private IJavaProject getJavaProject() {
		String projectName = projectText.getText().trim();
		if (projectName.length() < 1) {
			return null;
		}
		return getJavaModel().getJavaProject(projectName);		
	}

	private IWorkspaceRoot getWorkspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	private static Text createSingleText(Composite parent, int hspan) {
    	Text t = new Text(parent, SWT.SINGLE | SWT.BORDER);
    	t.setFont(parent.getFont());
    	GridData gd = new GridData(GridData.FILL_HORIZONTAL);
    	gd.horizontalSpan = hspan;
    	t.setLayoutData(gd);
    	return t;
    }

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			updateProjectFromConfig(configuration);
			
			modelList.removeAll();
			ArrayList<String> param = new ArrayList<String>();
			param = (ArrayList<String>) configuration.getAttribute("ModelFiles", param);
			for (String tmp : param) {
				addModelFile(tmp);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		try {
			ArrayList<String> param = new ArrayList<String>();
			String[] tmp = modelList.getItems();
			for (int i = 0; i < tmp.length; i++) {
				param.add(tmp[i]);
			}
			configuration.setAttribute("ModelFiles", param);
			configuration.setAttribute(IJavaLaunchConfigurationConstants.ATTR_PROJECT_NAME, projectText.getText().trim());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getName() {
		return "Main";
	}

	private void addModelFile(String str) {
		modelList.add(str);
		setDirty(true);
		updateLaunchConfigurationDialog();
	}
	
	protected abstract boolean isValidModelFile(IResource resource);
	
	private class AddModel implements Listener {
		@Override
		public void handleEvent(Event event) {
			ModelSelectionDialog dialog = new ModelSelectionDialog(modelList.getShell());
			dialog.setTitle("Resource Selection");
			dialog.setMessage("Select Room Model:");
			if (dialog.open() == Window.OK) {
				Object[] tmp = dialog.getResult();
				if (tmp != null) {
					IResource f;
					for (int i = 0; i < tmp.length; i++) {
						f = (IResource) tmp[i];
			            String arg = f.getFullPath().toString();
			            String fileLoc = VariablesPlugin.getDefault().getStringVariableManager().generateVariableExpression("workspace_loc", arg); //$NON-NLS-1$
						addModelFile(fileLoc);
					}
				}
			}
		}
	}
	
	private class AddModelAlt implements Listener {
		@Override
		public void handleEvent(Event event) {
			ResourceSelectionDialog dialog = new ResourceSelectionDialog(modelList.getShell(), ResourcesPlugin.getWorkspace().getRoot(), "");
			dialog.setTitle("Resource Selection");
			dialog.setMessage("Select Room Model:");
			if (dialog.open() == Window.OK) {
				Object[] tmp = dialog.getResult();
				if (tmp != null) {
					IResource f;
					for (int i = 0; i < tmp.length; i++) {
						f = (IResource) tmp[i];
			            String arg = f.getFullPath().toString();
			            String fileLoc = VariablesPlugin.getDefault().getStringVariableManager().generateVariableExpression("workspace_loc", arg); //$NON-NLS-1$
						addModelFile(fileLoc);
					}
				}
			}
		}
	}

	private class RemoveModel implements Listener{
		@Override
		public void handleEvent(Event event) {
			String[] arr = modelList.getSelection();
			for (int i = 0; i < arr.length; i++) {
				modelList.remove(arr[i]);
			}
			setDirty(true);
			updateLaunchConfigurationDialog();
		}
	}
	
	private class MoveModelUp implements Listener{
		@Override
		public void handleEvent(Event event) {
			String[] arr=modelList.getSelection();
			for(int i=0; i<arr.length;i++){
				int index=modelList.indexOf(arr[i]);
				if(index!=0){
					modelList.remove(arr[i]);
					modelList.add(arr[i], index-1);
					modelList.setSelection(index-1);
				}
			}
			setDirty(true);
			updateLaunchConfigurationDialog();
		}
	}
	private class MoveModelDown implements Listener{
		@Override
		public void handleEvent(Event event) {
			String[] arr = modelList.getSelection();
			for (int i = 0; i < arr.length; i++) {
				int index = modelList.indexOf(arr[i]);
				if (index != (modelList.getItemCount() - 1)) {
					modelList.remove(arr[i]);
					modelList.add(arr[i], index + 1);
					modelList.setSelection(index + 1);
				}
			}
			setDirty(true);
			updateLaunchConfigurationDialog();
		}
	}
	
	private class ModelSelectionDialog extends ResourceListSelectionDialog {

		public ModelSelectionDialog(Shell parentShell) {
			super(parentShell, ResourcesPlugin.getWorkspace().getRoot(), IResource.FILE);
		}

		@Override
		protected boolean select(IResource resource) {
			return isValidModelFile(resource);
		}
	}
}
