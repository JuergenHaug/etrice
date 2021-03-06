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

package org.eclipse.etrice.runtime.java.modelbase;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public interface IOptionalActorFactory {

	/**
	 * @param parent the {@link OptionalActorInterfaceBase} that owns the optional actor
	 * @param name the name of the new actor instance
	 * @return the created {@link ActorClassBase}
	 */
	ActorClassBase create(OptionalActorInterfaceBase parent, String name);

}
