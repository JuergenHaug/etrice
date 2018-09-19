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

package org.eclipse.etrice.generator.doc.setup;

import org.eclipse.etrice.generator.base.AbstractGeneratorOptionsHelper;
import org.eclipse.etrice.generator.base.args.Arguments;

public class DocGeneratorOptionsHelper extends AbstractGeneratorOptionsHelper {
	
	public boolean isGenerateInstanceDiagram(Arguments args) {
		return args.get(DocGeneratorOptions.GEN_INST_DIAG);
	}
}
