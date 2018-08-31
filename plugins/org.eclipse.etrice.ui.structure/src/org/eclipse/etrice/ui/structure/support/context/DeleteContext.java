/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.structure.support.context;

import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

/**
 * Used to restrict update process to deletion (of proxies).
 */
public class DeleteContext extends UpdateContext {

	/**
	 * {@link DeleteContext}
	 * @param pictogramElement
	 */
	public DeleteContext(PictogramElement pictogramElement) {
		super(pictogramElement);
		// TODO Auto-generated constructor stub
	}

}
