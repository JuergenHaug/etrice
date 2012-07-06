/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.generic;

import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.TransitionChain;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.TriggeredTransition;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.DetailCodeTranslator;

/**
 * base class for 
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class AbstractTransitionChainGenerator implements ITypedDataProvider {

	public String generateExecuteChain(ExpandedActorClass ac, TransitionChain tc, DetailCodeTranslator dct) {
		TransitionChainVisitor tcv = new TransitionChainVisitor(ac, this, dct);
		AbstractGenerator.getInjector().injectMembers(tcv);
		tcv.init(tc);
		
		return tc.genExecuteChain(tcv);
	}

	public String generateArgumentList(ExpandedActorClass xpac, Transition t) {
		if (t instanceof InitialTransition)
			// actually is InitialTransition
			return "";
		
		TransitionChain chain = xpac.getChain(t);
		if (!(chain.getTransition() instanceof TriggeredTransition))
			return "";
		
		return generateTypedArgumentList(xpac.getData(t));
	}

	public String generateArgumentList(VarDecl data) {
		return generateArglistAndTypedData(data)[0];
	}

	public String generateTypedData(VarDecl data) {
		return generateArglistAndTypedData(data)[1];
	}

	public String generateTypedArgumentList(VarDecl data) {
		return generateArglistAndTypedData(data)[2];
	}
}
