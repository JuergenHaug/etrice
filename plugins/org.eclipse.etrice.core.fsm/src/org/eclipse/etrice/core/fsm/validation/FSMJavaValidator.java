/*
* generated by Xtext
*/
package org.eclipse.etrice.core.fsm.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.common.converter.BaseConverterService;
import org.eclipse.etrice.core.common.converter.CCStringIndentation;
import org.eclipse.etrice.core.common.validation.IssueUtils;
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
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.services.FSMGrammarAccess;
import org.eclipse.etrice.core.fsm.validation.FSMValidationUtilXtend.Result;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Check;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * Custom validation rules. 
 *
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
public class FSMJavaValidator extends org.eclipse.etrice.core.fsm.validation.AbstractFSMJavaValidator {

	public static final String PLAIN_STRING_DETAILCODE = "RoomJavaValidator.PlainStringDetailCode";
	
	@Inject
	private FSMValidationUtil validationUtil;

	@Inject
	FSMGrammarAccess grammar;
	
	@Inject
	BaseConverterService converterService;
	
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
	public void checkRefinedStateNotEmpty(RefinedState rs) {
		if (validationUtil.isRefinedStateEmpty(rs)) {
			error("Refined state must not be empty (needs to have at least one action code or a subgraph).", FSMPackage.Literals.STATE__ENTRY_CODE);
		}
	}
	
	@Check
	public void checkStateNameUnique(SimpleState s) {
//		Result result = validationUtil.isUniqueName(s, s.getName());
//		if (!result.isOk())
//			error(result.getMsg(), FSMPackage.Literals.SIMPLE_STATE__NAME);
	}
	
	@Check
	public void checkTrPoint(TrPoint tp) {
		Result result = validationUtil.isValid(tp);
		if (!result.isOk())
			error(result);
	}
	
	@Check
	public void checkChoicePoint(ChoicePoint cp) {
//		if (!validationUtil.isUniqueName(cp, cp.getName()).isOk())
//			error("name is not unique", FSMPackage.Literals.CHOICE_POINT__NAME);
	}
	
	@Check
	public void checkTransition(Transition trans) {
		Result result = validationUtil.checkTransition(trans);
		if (!result.isOk())
			error(result);

		if (trans instanceof InitialTransition) {
			result = validationUtil.isConnectable(null, trans.getTo(), trans, (StateGraph)trans.eContainer());
		}
		else {
			result = validationUtil.isConnectable(((NonInitialTransition)trans).getFrom(), trans.getTo(), trans, (StateGraph)trans.eContainer());
		}
		if (!result.isOk())
			error(result);
		
		
	}
	
	@Check
	public void checkState(org.eclipse.etrice.core.fsm.fSM.State state) {
		Result result = validationUtil.checkState(state);
		if (!result.isOk())
			error(result);
	
		ArrayList<Result> res = validationUtil.uniqueOriginTriggers(state);
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
		if (dc.getLines().isEmpty()) {
			error("detail code must not be empty", dc, FSMPackage.Literals.DETAIL_CODE__LINES);
			return;
		}
		
		// ccstring is new standard for detail code
		boolean isPlainStyle = false;
		List<INode> lineNodes = NodeModelUtils.findNodesForFeature(dc, FSMPackage.Literals.DETAIL_CODE__LINES);
		for(INode lineNode : lineNodes){
			if(lineNode.getGrammarElement() instanceof RuleCall){
				AbstractRule rule = ((RuleCall)lineNode.getGrammarElement()).getRule();
				if(rule == grammar.getCC_STRINGRule()) {
					if(!new CCStringIndentation(converterService.getCC_StringConverter().stripDelim(lineNode.getText())).hasConsistentIndentation())
						warning("Inconsistent indentation", dc, FSMPackage.Literals.DETAIL_CODE__LINES, lineNodes.indexOf(lineNode));
				} else if(rule == grammar.getSTRINGRule()) {
					isPlainStyle = true;
					if(Strings.countLineBreaks(lineNode.getText()) > 0)
						warning("multi line string, use smart string instead", dc, FSMPackage.Literals.DETAIL_CODE__LINES, lineNodes.indexOf(lineNode));
				}
			}
		}
		if(isPlainStyle) {
			// TODO quickfix here does not work yet, see FSMQuickfixProvider
			warning("old style line string", dc, null, PLAIN_STRING_DETAILCODE);
		}
		
	}
	
	@Check
	public void checkUniqueNamesInStateGraph(final StateGraph sg) {
	    Multimap<String, StateGraphItem> names2items = ArrayListMultimap.create();
	    
	    // fill the multimap with all objects
	    StateGraph stateGraph = sg;
	    do {
            for (org.eclipse.etrice.core.fsm.fSM.State st : stateGraph.getStates()) {
                // the parent state of refined states is in this scope - so we don't add the name now 
                if (!(st instanceof RefinedState)) {
                    names2items.put(st.getName(), st);
                }
            }
            for (TrPoint tp : stateGraph.getTrPoints()) {
                names2items.put(tp.getName(), tp);
            }
            for (ChoicePoint cp : stateGraph.getChPoints()) {
                names2items.put(cp.getName(), cp);
            }
            for (Transition tr : stateGraph.getTransitions()) {
                names2items.put(tr.getName(), tr);
            }
            
            if (stateGraph.eContainer() instanceof RefinedState) {
            	stateGraph = ((RefinedState)stateGraph.eContainer()).getTarget().getSubgraph();
            }
            else if (sg.eContainer() instanceof ModelComponent) {
                ModelComponent base = ((ModelComponent)stateGraph.eContainer()).getBase();
                stateGraph = base!=null? base.getStateMachine():null;
            }
            else {
                break;
            }
        }
        while (stateGraph != null);
        
        // check for duplicates
        for (String key: names2items.keySet()) {
            Collection<StateGraphItem> list = names2items.get(key);
            if (list.size()>1) {
                for (StateGraphItem item: list) {
                	if(sg.eContents().contains(item))
                		error("Name is not unique in state graph (including super graph)", item, getNameFeature(item));
                	else if(sg.eResource() == item.eResource())
                		warning("Name is also used in derived graph(s)", item, getNameFeature(item));
                }
            }
        }
	}
	
	/**
     * @param item
     * @return
     */
    private EStructuralFeature getNameFeature(StateGraphItem item) {
        if (item instanceof SimpleState) {
            return FSMPackage.Literals.SIMPLE_STATE__NAME;
        }
        else if (item instanceof ChoicePoint) {
            return FSMPackage.Literals.CHOICE_POINT__NAME;
        }
        else if (item instanceof TrPoint) {
            return FSMPackage.Literals.TR_POINT__NAME;
        }
        else if (item instanceof Transition) {
            return FSMPackage.Literals.TRANSITION__NAME;
        }
        else {
            assert(false): "internal error: unexpected sub type";
            return null;
        }
    }

    private void error(Result result) {
		error(result.getMsg(), result.getSource(), result.getFeature(), result.getIndex(), IssueUtils.DUMMY_CODE, IssueUtils.BLOCKING_MARKER);
	}
}
