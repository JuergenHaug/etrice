/*******************************************************************************
* Copyright (c) 2018 protos software gmbh (http://www.protos.de).
* All rights reserved.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* CONTRIBUTORS:
*           Jan Belle (initial contribution)
*
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

/**
 * An Exception that indicates an error in a generator application.
 */
public class GeneratorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GeneratorException() {
	}
	
	public GeneratorException(String message) {
		super(message);
	}
	
	public GeneratorException(Throwable cause) {
		super(cause);
	}
	
	public GeneratorException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
