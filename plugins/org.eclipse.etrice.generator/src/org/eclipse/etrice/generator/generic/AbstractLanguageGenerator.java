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

import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.Trigger;
import org.eclipse.etrice.core.room.TriggeredTransition;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.generator.base.AbstractGenerator;
import org.eclipse.etrice.generator.base.DetailCodeTranslator;
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass;
import org.eclipse.etrice.generator.etricegen.TransitionChain;

public abstract class AbstractLanguageGenerator {

	public String getExecuteChain(ExpandedActorClass ac, TransitionChain tc, DetailCodeTranslator dct) {
		LanguageTransitionChainVisitor tcv = new LanguageTransitionChainVisitor(dct);
		AbstractGenerator.getInjector().injectMembers(tcv);

		String dataArg = "";
		String typedData = "";
		if (tc.getTransition() instanceof TriggeredTransition) {
			VarDecl data = ((TriggeredTransition)tc.getTransition()).getTriggers().get(0).getMsgFromIfPairs().get(0).getMessage().getData();
			String[] result = getArglistAndTypedData(data);
			dataArg = result[0];
			typedData = result[1];
		}
		tcv.init(tc, dataArg, typedData);
		
		return tc.genExecuteChain(tcv);
	}

	public String getArgumentList(ExpandedActorClass xpac, Transition t) {
		if (t instanceof InitialTransition)
			// actually is InitialTransition
			return "";
		
		TransitionChain chain = xpac.getChain(t);
		if (!(chain.getTransition() instanceof TriggeredTransition))
			return "";
		
		Trigger trigger = ((TriggeredTransition)chain.getTransition()).getTriggers().get(0);
		MessageFromIf mif = trigger.getMsgFromIfPairs().get(0);
		
		return getTypedArgumentList(mif.getMessage());
	}

	public String getArgumentList(Message m) {
		return getArglistAndTypedData(m.getData())[0];
	}

	public String getTypedData(Message m) {
		return getArglistAndTypedData(m.getData())[1];
	}

	public String getTypedArgumentList(Message m) {
		return getArglistAndTypedData(m.getData())[2];
	}
	
	public abstract String[] getArglistAndTypedData(VarDecl data);
}
