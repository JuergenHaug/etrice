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

package org.eclipse.etrice.ui.common.support;

import org.eclipse.etrice.ui.common.Activator;
import org.eclipse.etrice.ui.common.preferences.PreferenceConstants;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class DeleteWithoutConfirmFeature extends DefaultDeleteFeature {

	public DeleteWithoutConfirmFeature(IFeatureProvider fp) {
		super(fp);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.ui.features.DefaultDeleteFeature#getUserDecision(org.eclipse.graphiti.features.context.IDeleteContext)
	 */
	@Override
	protected boolean getUserDecision(IDeleteContext context) {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		boolean confirm = store.getBoolean(PreferenceConstants.CONFIRM_DELETE);
		return confirm? super.getUserDecision(context) : true;
	}
}
