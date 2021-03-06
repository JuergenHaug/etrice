/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;



/**
 * An abstract base class for port instances.
 * 
 * @author Thomas Schuetz
 *
 */
public abstract class PortBase extends InterfaceItemBase {
	
	public PortBase (IInterfaceItemOwner actor, String name, int localId){
		super(actor, name, localId, 0);
	}
	
	public PortBase (IInterfaceItemOwner actor, String name, int localId, int idx){
		super(actor, name, localId, idx);
	}
}
