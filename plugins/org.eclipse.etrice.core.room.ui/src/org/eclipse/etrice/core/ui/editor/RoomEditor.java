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

package org.eclipse.etrice.core.ui.editor;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class RoomEditor extends XtextEditor implements IValidatingEditor {

	@Inject
	protected IResourceValidator resourceValidator;

	private SaveOnFocusLostListener partListener;
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.XtextEditor#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		
		partListener = new SaveOnFocusLostListener(this);
		getSite().getPage().addPartListener(partListener);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.XtextEditor#dispose()
	 */
	@Override
	public void dispose() {
		getSite().getPage().removePartListener(partListener);
		
		super.dispose();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.core.ui.editor.IValidatingEditor#isValid()
	 */
	@Override
	public boolean isValid() {
		return getDocument().readOnly(new IUnitOfWork<Boolean, XtextResource>() {
			@Override
			public Boolean exec(XtextResource resource) throws Exception {
				List<Issue> result = resourceValidator.validate(resource, CheckMode.NORMAL_AND_FAST, new CancelIndicator() {
					public boolean isCanceled() {
						return false;
					}
				});
				if (!result.isEmpty()) {
					for (Issue issue : result) {
						if (issue.isSyntaxError() || issue.getSeverity()==Severity.ERROR)
							return false;
					}
				}
				return true;
			}
		});
	}
}
