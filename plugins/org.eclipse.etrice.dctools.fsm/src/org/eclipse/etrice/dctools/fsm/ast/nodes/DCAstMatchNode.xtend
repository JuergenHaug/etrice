/*******************************************************************************
 * Copyright (c) 2018 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.dctools.fsm.ast.nodes

class DCAstMatchNode extends DCAstNode {
	
	new(DCAstNode parent) {
		super(parent, 0 /* no own tokens */)
	}
	
	override protected doPrint(String indent) {
		println(indent + "DCAstMatchNode")
	}
}