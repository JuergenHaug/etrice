
/*******************************************************************************
 * Copyright (c) 2012 Rohit Agrawal
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Rohit Agrawal (initial contribution)
 * 
 *******************************************************************************/


package org.eclipse.etrice.abstractexec.behavior;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.abstractexec.behavior.util.AbstractExecutionUtil;
import org.eclipse.etrice.core.common.validation.ICustomValidator;
import org.eclipse.etrice.core.genmodel.fsm.base.NullDiagnostician;
import org.eclipse.etrice.core.genmodel.fsm.base.NullLogger;
import org.eclipse.etrice.core.genmodel.fsm.builder.FSMGeneratorModelBuilder;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;


public class ReachabilityValidator implements ICustomValidator {

	public static final String DIAG_CODE_UNREACHABLE = "etrice.unreachable";
	
	private static final Set<EClass> classesToCheck = new HashSet<EClass>();
	{
		classesToCheck.add(FSMPackage.Literals.MODEL_COMPONENT);
	}
	
	@Override
	public void validate(EObject object, ValidationMessageAcceptor messageAcceptor, ICustomValidator.ValidationContext context) {

		if (!(object instanceof ModelComponent))
			return;
		
		if (context.isGeneration())
			return;
		
		ModelComponent mc = (ModelComponent) object;
		
		if (mc.isAbstract())
			return;
		
		if (AbstractExecutionUtil.getInstance().getRoomHelpers().isCircularClassHierarchy(mc))
			// is checked elsewhere
			return;

		NullDiagnostician diagnostician = new NullDiagnostician();
		FSMGeneratorModelBuilder builder = new FSMGeneratorModelBuilder(new NullLogger(), diagnostician);
		ExpandedModelComponent xpac = null;
		try {
			xpac = builder.createExpandedModelComponent(mc);
		}
		catch (Throwable t) {
			return;
		}
		
		if (xpac != null && !diagnostician.isFailed()) {
			ReachabilityCheck checker = new ReachabilityCheck(xpac);
			checker.computeReachability();
			TreeIterator<EObject> it = xpac.getStateMachine().eAllContents();
			while (it.hasNext()) {
				EObject item = it.next();
				if (item instanceof StateGraphItem)
				{
					StateGraphItem toCheck = (StateGraphItem) item;
					if (!checker.isReachable(toCheck)) {
						EObject orig = xpac.getOrig(toCheck);
						if (toCheck.getName()==null)
							// we cannot create an error message
							continue;
						
						EObject container = orig.eContainer();
						@SuppressWarnings("unchecked")
						int idx = ((List<? extends EObject>)container.eGet(orig.eContainingFeature())).indexOf(orig);
						messageAcceptor.acceptWarning(
								"Unreachable state/point of graph",
								xpac.getOrig(toCheck).eContainer(), xpac.getOrig(toCheck).eContainingFeature(), idx,
								DIAG_CODE_UNREACHABLE, toCheck.getName());
					}
				}
			}
		}
	}

	@Override
	public String getName() {
		return "State Reachability Validator";
	}

	@Override
	public String getDescription() {
		return "This validator checks the reachability of state graph items.";
	}

	@Override
	public Set<EClass> getClassesToCheck() {
		return classesToCheck;
	}

}
