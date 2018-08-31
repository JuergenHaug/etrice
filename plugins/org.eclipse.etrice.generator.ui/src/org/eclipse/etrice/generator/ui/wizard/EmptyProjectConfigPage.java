/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.ui.wizard;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.etrice.generator.ui.preferences.PreferenceConstants;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

/**
 * @author Henrik Rentz-Reichert
 *
 */
class EmptyProjectConfigPage extends WizardPage {
	
	private Button jdtBuild;
	private Button mvnBuild;
	private boolean useJDTBuild;
	
	/**
	 * @param pageName
	 */
	EmptyProjectConfigPage(String pageName) {
		super(pageName);
	}
	
	@Override
	public void createControl(Composite parent) {
	    Composite composite = new Composite(parent, SWT.NULL);

	    initializeDialogUnits(parent);
	    composite.setLayout(new GridLayout());
	    composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		
	    jdtBuild = new Button(composite, SWT.RADIO);
	    jdtBuild.setText("use &Eclipse JDT build");
	    jdtBuild.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
			    setPageComplete(validatePage());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
	    mvnBuild = new Button(composite, SWT.RADIO);
	    mvnBuild.setText("use &Maven build");
	    
		ScopedPreferenceStore prefStore = new ScopedPreferenceStore(InstanceScope.INSTANCE, "org.eclipse.etrice.generator.ui");
		if (prefStore.getString(PreferenceConstants.BUILD_KIND).equals(PreferenceConstants.MAVEN))
			mvnBuild.setSelection(true);
		else
		    jdtBuild.setSelection(true);
	    
	    // Show description on opening
	    setErrorMessage(null);
	    setMessage(null);
	    setControl(composite);
	    Dialog.applyDialogFont(composite);
	    
	    setPageComplete(validatePage());
	}
	
	protected boolean validatePage() {
		useJDTBuild = jdtBuild==null || jdtBuild.getSelection();
		
		setErrorMessage(null);
		
		return true;
	}
	
	public boolean useJDTBuild() {
		return useJDTBuild;
	}
	
	public boolean useMVNBuild() {
		return !useJDTBuild;
	}
}