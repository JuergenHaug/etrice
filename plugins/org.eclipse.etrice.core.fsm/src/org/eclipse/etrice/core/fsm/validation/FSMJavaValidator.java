/*
* generated by Xtext
*/
package org.eclipse.etrice.core.fsm.validation;

import java.util.ArrayList;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.NonInitialTransition;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.SimpleState;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.validation.FSMValidationUtilXtend.Result;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Check;

import com.google.inject.Inject;

/**
 * Custom validation rules. 
 *
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
public class FSMJavaValidator extends org.eclipse.etrice.core.fsm.validation.AbstractFSMJavaValidator {

	public static final String MULTI_LINE_DETAILCODE = "RoomJavaValidator.MultiLineDetailCode";
	
	@Inject
	private FSMValidationUtil ValidationUtil;
	
	@Check
	public void checkRefinedStateUnique(RefinedState rs) {
		StateGraph sg = (StateGraph) rs.eContainer();
		TreeIterator<EObject> it = sg.eAllContents();
		while (it.hasNext()) {
			EObject obj = it.next();
			if (obj!=rs && obj instanceof RefinedState)
				if (rs.getTarget()==((RefinedState)obj).getTarget()) {
					if (rs.eContainer().eContainer() instanceof ModelComponent)
						error("refined state conflicts with nested refined state with same target", FSMPackage.Literals.REFINED_STATE__TARGET);
					else
						error("refined state not unique", FSMPackage.Literals.REFINED_STATE__TARGET);
				}
		}
	}
	
	@Check
	public void checkStateNameUnique(SimpleState s) {
		Result result = ValidationUtil.isUniqueName(s, s.getName());
		if (!result.isOk())
			error(result.getMsg(), FSMPackage.Literals.SIMPLE_STATE__NAME);
	}
	
	@Check
	public void checkTrPoint(TrPoint tp) {
		Result result = ValidationUtil.isValid(tp);
		if (!result.isOk())
			error(result);
	}
	
	@Check
	public void checkChoicePoint(ChoicePoint cp) {
		if (!ValidationUtil.isUniqueName(cp, cp.getName()).isOk())
			error("name is not unique", FSMPackage.Literals.CHOICE_POINT__NAME);
	}
	
	@Check
	public void checkTransition(Transition trans) {
		Result result = ValidationUtil.checkTransition(trans);
		if (!result.isOk())
			error(result);

		if (trans instanceof InitialTransition) {
			result = ValidationUtil.isConnectable(null, trans.getTo(), trans, (StateGraph)trans.eContainer());
		}
		else {
			result = ValidationUtil.isConnectable(((NonInitialTransition)trans).getFrom(), trans.getTo(), trans, (StateGraph)trans.eContainer());
		}
		if (!result.isOk())
			error(result);
		
		
	}
	
	@Check
	public void checkState(org.eclipse.etrice.core.fsm.fSM.State state) {
		Result result = ValidationUtil.checkState(state);
		if (!result.isOk())
			error(result);
	
		ArrayList<Result> res = ValidationUtil.uniqueOriginTriggers(state);
		for (Result r : res) {
			error(r);
		}
	}
	
	@Check
	public void checkRefinedTransition(RefinedTransition rt) {
		if (!(rt.eContainer().eContainer() instanceof ModelComponent)) {
			StateGraph sg = (StateGraph) rt.eContainer();
			int idx = sg.getRefinedTransitions().indexOf(rt);
			error("RefinedTransition only allowed in top level state graph of an actor", sg, FSMPackage.Literals.STATE_GRAPH__REFINED_TRANSITIONS, idx);
		}
	}
	
	@Check
	public void checkDetailCode(DetailCode dc) {
		if (dc.getLines().isEmpty())
			error("detail code must not be empty", dc, FSMPackage.Literals.DETAIL_CODE__LINES);
		
		for(String line : dc.getLines()){
			// bad: "\r\n" is affected too
			if(line.contains(Strings.newLine()))
				warning("multi line string", dc, FSMPackage.Literals.DETAIL_CODE__LINES, dc.getLines().indexOf(line), MULTI_LINE_DETAILCODE);
		}
	}
	
	private void error(Result result) {
		error(result.getMsg(), result.getSource(), result.getFeature(), result.getIndex());
	}
}