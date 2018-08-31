/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior;

import org.eclipse.etrice.ui.behavior.fsm.editor.AbstractFSMDiagramTypeProvider;
import org.eclipse.etrice.ui.behavior.fsm.support.AbstractFSMProviderDispatcher;
import org.eclipse.etrice.ui.common.base.support.DiagramAccessBase;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

import com.google.inject.Injector;

public class DiagramTypeProvider extends AbstractFSMDiagramTypeProvider {

	public static final String PROVIDER_ID = "org.eclipse.etrice.ui.behavior.diagramTypeProvider";

	private static final boolean USE_AUTO_UPDATE = true;
	
	private IToolBehaviorProvider[] toolBehaviorProviders;
	private AbstractFSMProviderDispatcher dispatcher;

	public DiagramTypeProvider() {
		super();
		dispatcher = new AbstractFSMProviderDispatcher(this);
		setFeatureProvider(dispatcher.getFeatureProvider());
	}

	@Override
    public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
        if (toolBehaviorProviders == null) {
            toolBehaviorProviders =
                new IToolBehaviorProvider[] {
            		dispatcher.getToolBehaviorProvider() };
        }
        return toolBehaviorProviders;
    }

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.dt.AbstractDiagramTypeProvider#isAutoUpdateAtStartup()
	 */
	@Override
	public boolean isAutoUpdateAtStartup() {
		return USE_AUTO_UPDATE;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.dt.AbstractDiagramTypeProvider#isAutoUpdateAtReset()
	 */
	@Override
	public boolean isAutoUpdateAtReset() {
		return USE_AUTO_UPDATE;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.dt.AbstractDiagramTypeProvider#isAutoUpdateAtRuntime()
	 */
	@Override
	public boolean isAutoUpdateAtRuntime() {
		return USE_AUTO_UPDATE;
	}
	
	@Override
	public Injector getInjector() {
		return Activator.getDefault().getInjector();
	}

	@Override
	public DiagramAccessBase getDiagramAccess() {
		return new DiagramAccess();
	}
}
