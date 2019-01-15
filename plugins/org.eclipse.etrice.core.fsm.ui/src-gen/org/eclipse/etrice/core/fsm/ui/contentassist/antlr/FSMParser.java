/*
 * generated by Xtext
 */
package org.eclipse.etrice.core.fsm.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.eclipse.etrice.core.fsm.services.FSMGrammarAccess;

public class FSMParser extends AbstractContentAssistParser {
	
	@Inject
	private FSMGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.eclipse.etrice.core.fsm.ui.contentassist.antlr.internal.InternalFSMParser createParser() {
		org.eclipse.etrice.core.fsm.ui.contentassist.antlr.internal.InternalFSMParser result = new org.eclipse.etrice.core.fsm.ui.contentassist.antlr.internal.InternalFSMParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getStateGraphNodeAccess().getAlternatives(), "rule__StateGraphNode__Alternatives");
					put(grammarAccess.getStateGraphItemAccess().getAlternatives(), "rule__StateGraphItem__Alternatives");
					put(grammarAccess.getStateGraphAccess().getAlternatives_2(), "rule__StateGraph__Alternatives_2");
					put(grammarAccess.getStateMachineAccess().getAlternatives_3(), "rule__StateMachine__Alternatives_3");
					put(grammarAccess.getStateAccess().getAlternatives(), "rule__State__Alternatives");
					put(grammarAccess.getDetailCodeAccess().getAlternatives(), "rule__DetailCode__Alternatives");
					put(grammarAccess.getTrPointAccess().getAlternatives(), "rule__TrPoint__Alternatives");
					put(grammarAccess.getTransitionBaseAccess().getAlternatives(), "rule__TransitionBase__Alternatives");
					put(grammarAccess.getTransitionAccess().getAlternatives(), "rule__Transition__Alternatives");
					put(grammarAccess.getNonInitialTransitionAccess().getAlternatives(), "rule__NonInitialTransition__Alternatives");
					put(grammarAccess.getTransitionChainStartTransitionAccess().getAlternatives(), "rule__TransitionChainStartTransition__Alternatives");
					put(grammarAccess.getTransitionTerminalAccess().getAlternatives(), "rule__TransitionTerminal__Alternatives");
					put(grammarAccess.getSemanticsRuleAccess().getAlternatives(), "rule__SemanticsRule__Alternatives");
					put(grammarAccess.getInSemanticsRuleAccess().getAlternatives_3_1(), "rule__InSemanticsRule__Alternatives_3_1");
					put(grammarAccess.getOutSemanticsRuleAccess().getAlternatives_3_1(), "rule__OutSemanticsRule__Alternatives_3_1");
					put(grammarAccess.getAnnotationTypeAccess().getAlternatives_6(), "rule__AnnotationType__Alternatives_6");
					put(grammarAccess.getAnnotationAttributeAccess().getAlternatives(), "rule__AnnotationAttribute__Alternatives");
					put(grammarAccess.getSimpleAnnotationAttributeAccess().getAlternatives_0(), "rule__SimpleAnnotationAttribute__Alternatives_0");
					put(grammarAccess.getEnumAnnotationAttributeAccess().getAlternatives_0(), "rule__EnumAnnotationAttribute__Alternatives_0");
					put(grammarAccess.getImportAccess().getAlternatives_1(), "rule__Import__Alternatives_1");
					put(grammarAccess.getTIMEAccess().getAlternatives(), "rule__TIME__Alternatives");
					put(grammarAccess.getLiteralAccess().getAlternatives(), "rule__Literal__Alternatives");
					put(grammarAccess.getBooleanLiteralAccess().getAlternatives_1(), "rule__BooleanLiteral__Alternatives_1");
					put(grammarAccess.getNumberLiteralAccess().getAlternatives(), "rule__NumberLiteral__Alternatives");
					put(grammarAccess.getIntegerAccess().getAlternatives(), "rule__Integer__Alternatives");
					put(grammarAccess.getIntegerAccess().getAlternatives_0_0(), "rule__Integer__Alternatives_0_0");
					put(grammarAccess.getRealAccess().getAlternatives(), "rule__Real__Alternatives");
					put(grammarAccess.getDecimalAccess().getAlternatives_0(), "rule__Decimal__Alternatives_0");
					put(grammarAccess.getDecimalExpAccess().getAlternatives_0(), "rule__DecimalExp__Alternatives_0");
					put(grammarAccess.getDecimalExpAccess().getAlternatives_4(), "rule__DecimalExp__Alternatives_4");
					put(grammarAccess.getDecimalExpAccess().getAlternatives_5(), "rule__DecimalExp__Alternatives_5");
					put(grammarAccess.getComponentCommunicationTypeAccess().getAlternatives(), "rule__ComponentCommunicationType__Alternatives");
					put(grammarAccess.getLiteralTypeAccess().getAlternatives(), "rule__LiteralType__Alternatives");
					put(grammarAccess.getModelComponentAccess().getGroup(), "rule__ModelComponent__Group__0");
					put(grammarAccess.getModelComponentAccess().getGroup_3(), "rule__ModelComponent__Group_3__0");
					put(grammarAccess.getStateGraphAccess().getGroup(), "rule__StateGraph__Group__0");
					put(grammarAccess.getStateMachineAccess().getGroup(), "rule__StateMachine__Group__0");
					put(grammarAccess.getSimpleStateAccess().getGroup(), "rule__SimpleState__Group__0");
					put(grammarAccess.getSimpleStateAccess().getGroup_3(), "rule__SimpleState__Group_3__0");
					put(grammarAccess.getSimpleStateAccess().getGroup_3_2(), "rule__SimpleState__Group_3_2__0");
					put(grammarAccess.getSimpleStateAccess().getGroup_3_3(), "rule__SimpleState__Group_3_3__0");
					put(grammarAccess.getSimpleStateAccess().getGroup_3_4(), "rule__SimpleState__Group_3_4__0");
					put(grammarAccess.getSimpleStateAccess().getGroup_3_5(), "rule__SimpleState__Group_3_5__0");
					put(grammarAccess.getRefinedStateAccess().getGroup(), "rule__RefinedState__Group__0");
					put(grammarAccess.getRefinedStateAccess().getGroup_5(), "rule__RefinedState__Group_5__0");
					put(grammarAccess.getRefinedStateAccess().getGroup_6(), "rule__RefinedState__Group_6__0");
					put(grammarAccess.getRefinedStateAccess().getGroup_7(), "rule__RefinedState__Group_7__0");
					put(grammarAccess.getRefinedStateAccess().getGroup_8(), "rule__RefinedState__Group_8__0");
					put(grammarAccess.getDetailCodeAccess().getGroup_0(), "rule__DetailCode__Group_0__0");
					put(grammarAccess.getDetailCodeAccess().getGroup_1(), "rule__DetailCode__Group_1__0");
					put(grammarAccess.getTransitionPointAccess().getGroup(), "rule__TransitionPoint__Group__0");
					put(grammarAccess.getEntryPointAccess().getGroup(), "rule__EntryPoint__Group__0");
					put(grammarAccess.getExitPointAccess().getGroup(), "rule__ExitPoint__Group__0");
					put(grammarAccess.getChoicePointAccess().getGroup(), "rule__ChoicePoint__Group__0");
					put(grammarAccess.getInitialTransitionAccess().getGroup(), "rule__InitialTransition__Group__0");
					put(grammarAccess.getInitialTransitionAccess().getGroup_7(), "rule__InitialTransition__Group_7__0");
					put(grammarAccess.getInitialTransitionAccess().getGroup_7_2(), "rule__InitialTransition__Group_7_2__0");
					put(grammarAccess.getContinuationTransitionAccess().getGroup(), "rule__ContinuationTransition__Group__0");
					put(grammarAccess.getContinuationTransitionAccess().getGroup_7(), "rule__ContinuationTransition__Group_7__0");
					put(grammarAccess.getContinuationTransitionAccess().getGroup_7_2(), "rule__ContinuationTransition__Group_7_2__0");
					put(grammarAccess.getTriggeredTransitionAccess().getGroup(), "rule__TriggeredTransition__Group__0");
					put(grammarAccess.getTriggeredTransitionAccess().getGroup_12(), "rule__TriggeredTransition__Group_12__0");
					put(grammarAccess.getTriggeredTransitionAccess().getGroup_14(), "rule__TriggeredTransition__Group_14__0");
					put(grammarAccess.getGuardedTransitionAccess().getGroup(), "rule__GuardedTransition__Group__0");
					put(grammarAccess.getGuardedTransitionAccess().getGroup_11(), "rule__GuardedTransition__Group_11__0");
					put(grammarAccess.getCPBranchTransitionAccess().getGroup(), "rule__CPBranchTransition__Group__0");
					put(grammarAccess.getCPBranchTransitionAccess().getGroup_11(), "rule__CPBranchTransition__Group_11__0");
					put(grammarAccess.getRefinedTransitionAccess().getGroup(), "rule__RefinedTransition__Group__0");
					put(grammarAccess.getTrPointTerminalAccess().getGroup(), "rule__TrPointTerminal__Group__0");
					put(grammarAccess.getSubStateTrPointTerminalAccess().getGroup(), "rule__SubStateTrPointTerminal__Group__0");
					put(grammarAccess.getChoicepointTerminalAccess().getGroup(), "rule__ChoicepointTerminal__Group__0");
					put(grammarAccess.getTriggerAccess().getGroup(), "rule__Trigger__Group__0");
					put(grammarAccess.getTriggerAccess().getGroup_2(), "rule__Trigger__Group_2__0");
					put(grammarAccess.getMessageFromIfAccess().getGroup(), "rule__MessageFromIf__Group__0");
					put(grammarAccess.getGuardAccess().getGroup(), "rule__Guard__Group__0");
					put(grammarAccess.getProtocolSemanticsAccess().getGroup(), "rule__ProtocolSemantics__Group__0");
					put(grammarAccess.getInSemanticsRuleAccess().getGroup(), "rule__InSemanticsRule__Group__0");
					put(grammarAccess.getInSemanticsRuleAccess().getGroup_3(), "rule__InSemanticsRule__Group_3__0");
					put(grammarAccess.getInSemanticsRuleAccess().getGroup_3_1_1(), "rule__InSemanticsRule__Group_3_1_1__0");
					put(grammarAccess.getInSemanticsRuleAccess().getGroup_3_1_1_2(), "rule__InSemanticsRule__Group_3_1_1_2__0");
					put(grammarAccess.getOutSemanticsRuleAccess().getGroup(), "rule__OutSemanticsRule__Group__0");
					put(grammarAccess.getOutSemanticsRuleAccess().getGroup_3(), "rule__OutSemanticsRule__Group_3__0");
					put(grammarAccess.getOutSemanticsRuleAccess().getGroup_3_1_1(), "rule__OutSemanticsRule__Group_3_1_1__0");
					put(grammarAccess.getOutSemanticsRuleAccess().getGroup_3_1_1_2(), "rule__OutSemanticsRule__Group_3_1_1_2__0");
					put(grammarAccess.getAnnotationAccess().getGroup(), "rule__Annotation__Group__0");
					put(grammarAccess.getAnnotationAccess().getGroup_2(), "rule__Annotation__Group_2__0");
					put(grammarAccess.getAnnotationAccess().getGroup_2_2(), "rule__Annotation__Group_2_2__0");
					put(grammarAccess.getKeyValueAccess().getGroup(), "rule__KeyValue__Group__0");
					put(grammarAccess.getAnnotationTypeAccess().getGroup(), "rule__AnnotationType__Group__0");
					put(grammarAccess.getAnnotationTypeAccess().getGroup_6_1(), "rule__AnnotationType__Group_6_1__0");
					put(grammarAccess.getAnnotationTypeAccess().getGroup_6_1_2(), "rule__AnnotationType__Group_6_1_2__0");
					put(grammarAccess.getSimpleAnnotationAttributeAccess().getGroup(), "rule__SimpleAnnotationAttribute__Group__0");
					put(grammarAccess.getEnumAnnotationAttributeAccess().getGroup(), "rule__EnumAnnotationAttribute__Group__0");
					put(grammarAccess.getEnumAnnotationAttributeAccess().getGroup_6(), "rule__EnumAnnotationAttribute__Group_6__0");
					put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
					put(grammarAccess.getImportAccess().getGroup_1_0(), "rule__Import__Group_1_0__0");
					put(grammarAccess.getImportedFQNAccess().getGroup(), "rule__ImportedFQN__Group__0");
					put(grammarAccess.getDocumentationAccess().getGroup(), "rule__Documentation__Group__0");
					put(grammarAccess.getTIMEAccess().getGroup_0(), "rule__TIME__Group_0__0");
					put(grammarAccess.getTIMEAccess().getGroup_1(), "rule__TIME__Group_1__0");
					put(grammarAccess.getTIMEAccess().getGroup_2(), "rule__TIME__Group_2__0");
					put(grammarAccess.getTIMEAccess().getGroup_3(), "rule__TIME__Group_3__0");
					put(grammarAccess.getLiteralArrayAccess().getGroup(), "rule__LiteralArray__Group__0");
					put(grammarAccess.getLiteralArrayAccess().getGroup_1(), "rule__LiteralArray__Group_1__0");
					put(grammarAccess.getBooleanLiteralAccess().getGroup(), "rule__BooleanLiteral__Group__0");
					put(grammarAccess.getRealLiteralAccess().getGroup(), "rule__RealLiteral__Group__0");
					put(grammarAccess.getIntLiteralAccess().getGroup(), "rule__IntLiteral__Group__0");
					put(grammarAccess.getStringLiteralAccess().getGroup(), "rule__StringLiteral__Group__0");
					put(grammarAccess.getIntegerAccess().getGroup_0(), "rule__Integer__Group_0__0");
					put(grammarAccess.getDecimalAccess().getGroup(), "rule__Decimal__Group__0");
					put(grammarAccess.getDecimalExpAccess().getGroup(), "rule__DecimalExp__Group__0");
					put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
					put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
					put(grammarAccess.getFSMModelAccess().getComponentsAssignment(), "rule__FSMModel__ComponentsAssignment");
					put(grammarAccess.getModelComponentAccess().getAbstractAssignment_0_0(), "rule__ModelComponent__AbstractAssignment_0_0");
					put(grammarAccess.getModelComponentAccess().getCommTypeAssignment_0_1(), "rule__ModelComponent__CommTypeAssignment_0_1");
					put(grammarAccess.getModelComponentAccess().getComponentNameAssignment_2(), "rule__ModelComponent__ComponentNameAssignment_2");
					put(grammarAccess.getModelComponentAccess().getBaseAssignment_3_1(), "rule__ModelComponent__BaseAssignment_3_1");
					put(grammarAccess.getModelComponentAccess().getStateMachineAssignment_4(), "rule__ModelComponent__StateMachineAssignment_4");
					put(grammarAccess.getStateGraphAccess().getStatesAssignment_2_0(), "rule__StateGraph__StatesAssignment_2_0");
					put(grammarAccess.getStateGraphAccess().getTrPointsAssignment_2_1(), "rule__StateGraph__TrPointsAssignment_2_1");
					put(grammarAccess.getStateGraphAccess().getChPointsAssignment_2_2(), "rule__StateGraph__ChPointsAssignment_2_2");
					put(grammarAccess.getStateGraphAccess().getTransitionsAssignment_2_3(), "rule__StateGraph__TransitionsAssignment_2_3");
					put(grammarAccess.getStateGraphAccess().getRefinedTransitionsAssignment_2_4(), "rule__StateGraph__RefinedTransitionsAssignment_2_4");
					put(grammarAccess.getStateMachineAccess().getStatesAssignment_3_0(), "rule__StateMachine__StatesAssignment_3_0");
					put(grammarAccess.getStateMachineAccess().getTrPointsAssignment_3_1(), "rule__StateMachine__TrPointsAssignment_3_1");
					put(grammarAccess.getStateMachineAccess().getChPointsAssignment_3_2(), "rule__StateMachine__ChPointsAssignment_3_2");
					put(grammarAccess.getStateMachineAccess().getTransitionsAssignment_3_3(), "rule__StateMachine__TransitionsAssignment_3_3");
					put(grammarAccess.getStateMachineAccess().getRefinedTransitionsAssignment_3_4(), "rule__StateMachine__RefinedTransitionsAssignment_3_4");
					put(grammarAccess.getSimpleStateAccess().getNameAssignment_1(), "rule__SimpleState__NameAssignment_1");
					put(grammarAccess.getSimpleStateAccess().getDocuAssignment_2(), "rule__SimpleState__DocuAssignment_2");
					put(grammarAccess.getSimpleStateAccess().getAnnotationsAssignment_3_1(), "rule__SimpleState__AnnotationsAssignment_3_1");
					put(grammarAccess.getSimpleStateAccess().getEntryCodeAssignment_3_2_1(), "rule__SimpleState__EntryCodeAssignment_3_2_1");
					put(grammarAccess.getSimpleStateAccess().getExitCodeAssignment_3_3_1(), "rule__SimpleState__ExitCodeAssignment_3_3_1");
					put(grammarAccess.getSimpleStateAccess().getDoCodeAssignment_3_4_1(), "rule__SimpleState__DoCodeAssignment_3_4_1");
					put(grammarAccess.getSimpleStateAccess().getSubgraphAssignment_3_5_1(), "rule__SimpleState__SubgraphAssignment_3_5_1");
					put(grammarAccess.getRefinedStateAccess().getTargetAssignment_1(), "rule__RefinedState__TargetAssignment_1");
					put(grammarAccess.getRefinedStateAccess().getDocuAssignment_2(), "rule__RefinedState__DocuAssignment_2");
					put(grammarAccess.getRefinedStateAccess().getAnnotationsAssignment_4(), "rule__RefinedState__AnnotationsAssignment_4");
					put(grammarAccess.getRefinedStateAccess().getEntryCodeAssignment_5_1(), "rule__RefinedState__EntryCodeAssignment_5_1");
					put(grammarAccess.getRefinedStateAccess().getExitCodeAssignment_6_1(), "rule__RefinedState__ExitCodeAssignment_6_1");
					put(grammarAccess.getRefinedStateAccess().getDoCodeAssignment_7_1(), "rule__RefinedState__DoCodeAssignment_7_1");
					put(grammarAccess.getRefinedStateAccess().getSubgraphAssignment_8_1(), "rule__RefinedState__SubgraphAssignment_8_1");
					put(grammarAccess.getDetailCodeAccess().getLinesAssignment_0_1(), "rule__DetailCode__LinesAssignment_0_1");
					put(grammarAccess.getDetailCodeAccess().getUsedAssignment_1_0(), "rule__DetailCode__UsedAssignment_1_0");
					put(grammarAccess.getDetailCodeAccess().getLinesAssignment_1_1(), "rule__DetailCode__LinesAssignment_1_1");
					put(grammarAccess.getTransitionPointAccess().getHandlerAssignment_0(), "rule__TransitionPoint__HandlerAssignment_0");
					put(grammarAccess.getTransitionPointAccess().getNameAssignment_2(), "rule__TransitionPoint__NameAssignment_2");
					put(grammarAccess.getEntryPointAccess().getNameAssignment_1(), "rule__EntryPoint__NameAssignment_1");
					put(grammarAccess.getExitPointAccess().getNameAssignment_1(), "rule__ExitPoint__NameAssignment_1");
					put(grammarAccess.getChoicePointAccess().getNameAssignment_1(), "rule__ChoicePoint__NameAssignment_1");
					put(grammarAccess.getChoicePointAccess().getDocuAssignment_2(), "rule__ChoicePoint__DocuAssignment_2");
					put(grammarAccess.getInitialTransitionAccess().getNameAssignment_1(), "rule__InitialTransition__NameAssignment_1");
					put(grammarAccess.getInitialTransitionAccess().getToAssignment_5(), "rule__InitialTransition__ToAssignment_5");
					put(grammarAccess.getInitialTransitionAccess().getDocuAssignment_6(), "rule__InitialTransition__DocuAssignment_6");
					put(grammarAccess.getInitialTransitionAccess().getAnnotationsAssignment_7_1(), "rule__InitialTransition__AnnotationsAssignment_7_1");
					put(grammarAccess.getInitialTransitionAccess().getActionAssignment_7_2_1(), "rule__InitialTransition__ActionAssignment_7_2_1");
					put(grammarAccess.getContinuationTransitionAccess().getNameAssignment_1(), "rule__ContinuationTransition__NameAssignment_1");
					put(grammarAccess.getContinuationTransitionAccess().getFromAssignment_3(), "rule__ContinuationTransition__FromAssignment_3");
					put(grammarAccess.getContinuationTransitionAccess().getToAssignment_5(), "rule__ContinuationTransition__ToAssignment_5");
					put(grammarAccess.getContinuationTransitionAccess().getDocuAssignment_6(), "rule__ContinuationTransition__DocuAssignment_6");
					put(grammarAccess.getContinuationTransitionAccess().getAnnotationsAssignment_7_1(), "rule__ContinuationTransition__AnnotationsAssignment_7_1");
					put(grammarAccess.getContinuationTransitionAccess().getActionAssignment_7_2_1(), "rule__ContinuationTransition__ActionAssignment_7_2_1");
					put(grammarAccess.getTriggeredTransitionAccess().getNameAssignment_1(), "rule__TriggeredTransition__NameAssignment_1");
					put(grammarAccess.getTriggeredTransitionAccess().getFromAssignment_3(), "rule__TriggeredTransition__FromAssignment_3");
					put(grammarAccess.getTriggeredTransitionAccess().getToAssignment_5(), "rule__TriggeredTransition__ToAssignment_5");
					put(grammarAccess.getTriggeredTransitionAccess().getDocuAssignment_6(), "rule__TriggeredTransition__DocuAssignment_6");
					put(grammarAccess.getTriggeredTransitionAccess().getAnnotationsAssignment_10(), "rule__TriggeredTransition__AnnotationsAssignment_10");
					put(grammarAccess.getTriggeredTransitionAccess().getTriggersAssignment_11(), "rule__TriggeredTransition__TriggersAssignment_11");
					put(grammarAccess.getTriggeredTransitionAccess().getTriggersAssignment_12_1(), "rule__TriggeredTransition__TriggersAssignment_12_1");
					put(grammarAccess.getTriggeredTransitionAccess().getActionAssignment_14_1(), "rule__TriggeredTransition__ActionAssignment_14_1");
					put(grammarAccess.getGuardedTransitionAccess().getNameAssignment_1(), "rule__GuardedTransition__NameAssignment_1");
					put(grammarAccess.getGuardedTransitionAccess().getFromAssignment_3(), "rule__GuardedTransition__FromAssignment_3");
					put(grammarAccess.getGuardedTransitionAccess().getToAssignment_5(), "rule__GuardedTransition__ToAssignment_5");
					put(grammarAccess.getGuardedTransitionAccess().getDocuAssignment_6(), "rule__GuardedTransition__DocuAssignment_6");
					put(grammarAccess.getGuardedTransitionAccess().getAnnotationsAssignment_8(), "rule__GuardedTransition__AnnotationsAssignment_8");
					put(grammarAccess.getGuardedTransitionAccess().getGuardAssignment_10(), "rule__GuardedTransition__GuardAssignment_10");
					put(grammarAccess.getGuardedTransitionAccess().getActionAssignment_11_1(), "rule__GuardedTransition__ActionAssignment_11_1");
					put(grammarAccess.getCPBranchTransitionAccess().getNameAssignment_1(), "rule__CPBranchTransition__NameAssignment_1");
					put(grammarAccess.getCPBranchTransitionAccess().getFromAssignment_3(), "rule__CPBranchTransition__FromAssignment_3");
					put(grammarAccess.getCPBranchTransitionAccess().getToAssignment_5(), "rule__CPBranchTransition__ToAssignment_5");
					put(grammarAccess.getCPBranchTransitionAccess().getDocuAssignment_6(), "rule__CPBranchTransition__DocuAssignment_6");
					put(grammarAccess.getCPBranchTransitionAccess().getAnnotationsAssignment_8(), "rule__CPBranchTransition__AnnotationsAssignment_8");
					put(grammarAccess.getCPBranchTransitionAccess().getConditionAssignment_10(), "rule__CPBranchTransition__ConditionAssignment_10");
					put(grammarAccess.getCPBranchTransitionAccess().getActionAssignment_11_1(), "rule__CPBranchTransition__ActionAssignment_11_1");
					put(grammarAccess.getRefinedTransitionAccess().getTargetAssignment_1(), "rule__RefinedTransition__TargetAssignment_1");
					put(grammarAccess.getRefinedTransitionAccess().getDocuAssignment_2(), "rule__RefinedTransition__DocuAssignment_2");
					put(grammarAccess.getRefinedTransitionAccess().getAnnotationsAssignment_4(), "rule__RefinedTransition__AnnotationsAssignment_4");
					put(grammarAccess.getRefinedTransitionAccess().getActionAssignment_6(), "rule__RefinedTransition__ActionAssignment_6");
					put(grammarAccess.getStateTerminalAccess().getStateAssignment(), "rule__StateTerminal__StateAssignment");
					put(grammarAccess.getTrPointTerminalAccess().getTrPointAssignment_1(), "rule__TrPointTerminal__TrPointAssignment_1");
					put(grammarAccess.getSubStateTrPointTerminalAccess().getTrPointAssignment_0(), "rule__SubStateTrPointTerminal__TrPointAssignment_0");
					put(grammarAccess.getSubStateTrPointTerminalAccess().getStateAssignment_2(), "rule__SubStateTrPointTerminal__StateAssignment_2");
					put(grammarAccess.getChoicepointTerminalAccess().getCpAssignment_1(), "rule__ChoicepointTerminal__CpAssignment_1");
					put(grammarAccess.getTriggerAccess().getMsgFromIfPairsAssignment_1(), "rule__Trigger__MsgFromIfPairsAssignment_1");
					put(grammarAccess.getTriggerAccess().getMsgFromIfPairsAssignment_2_1(), "rule__Trigger__MsgFromIfPairsAssignment_2_1");
					put(grammarAccess.getTriggerAccess().getGuardAssignment_3(), "rule__Trigger__GuardAssignment_3");
					put(grammarAccess.getMessageFromIfAccess().getMessageAssignment_0(), "rule__MessageFromIf__MessageAssignment_0");
					put(grammarAccess.getMessageFromIfAccess().getFromAssignment_2(), "rule__MessageFromIf__FromAssignment_2");
					put(grammarAccess.getAbstractInterfaceItemAccess().getNameAssignment(), "rule__AbstractInterfaceItem__NameAssignment");
					put(grammarAccess.getGuardAccess().getGuardAssignment_1(), "rule__Guard__GuardAssignment_1");
					put(grammarAccess.getProtocolSemanticsAccess().getRulesAssignment_3(), "rule__ProtocolSemantics__RulesAssignment_3");
					put(grammarAccess.getInSemanticsRuleAccess().getMsgAssignment_2(), "rule__InSemanticsRule__MsgAssignment_2");
					put(grammarAccess.getInSemanticsRuleAccess().getFollowUpsAssignment_3_1_0(), "rule__InSemanticsRule__FollowUpsAssignment_3_1_0");
					put(grammarAccess.getInSemanticsRuleAccess().getFollowUpsAssignment_3_1_1_1(), "rule__InSemanticsRule__FollowUpsAssignment_3_1_1_1");
					put(grammarAccess.getInSemanticsRuleAccess().getFollowUpsAssignment_3_1_1_2_1(), "rule__InSemanticsRule__FollowUpsAssignment_3_1_1_2_1");
					put(grammarAccess.getOutSemanticsRuleAccess().getMsgAssignment_2(), "rule__OutSemanticsRule__MsgAssignment_2");
					put(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsAssignment_3_1_0(), "rule__OutSemanticsRule__FollowUpsAssignment_3_1_0");
					put(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsAssignment_3_1_1_1(), "rule__OutSemanticsRule__FollowUpsAssignment_3_1_1_1");
					put(grammarAccess.getOutSemanticsRuleAccess().getFollowUpsAssignment_3_1_1_2_1(), "rule__OutSemanticsRule__FollowUpsAssignment_3_1_1_2_1");
					put(grammarAccess.getAnnotationAccess().getTypeAssignment_1(), "rule__Annotation__TypeAssignment_1");
					put(grammarAccess.getAnnotationAccess().getAttributesAssignment_2_1(), "rule__Annotation__AttributesAssignment_2_1");
					put(grammarAccess.getAnnotationAccess().getAttributesAssignment_2_2_1(), "rule__Annotation__AttributesAssignment_2_2_1");
					put(grammarAccess.getKeyValueAccess().getKeyAssignment_0(), "rule__KeyValue__KeyAssignment_0");
					put(grammarAccess.getKeyValueAccess().getValueAssignment_2(), "rule__KeyValue__ValueAssignment_2");
					put(grammarAccess.getAnnotationTypeAccess().getNameAssignment_1(), "rule__AnnotationType__NameAssignment_1");
					put(grammarAccess.getAnnotationTypeAccess().getDocuAssignment_2(), "rule__AnnotationType__DocuAssignment_2");
					put(grammarAccess.getAnnotationTypeAccess().getTargetsAssignment_6_0(), "rule__AnnotationType__TargetsAssignment_6_0");
					put(grammarAccess.getAnnotationTypeAccess().getTargetsAssignment_6_1_1(), "rule__AnnotationType__TargetsAssignment_6_1_1");
					put(grammarAccess.getAnnotationTypeAccess().getTargetsAssignment_6_1_2_1(), "rule__AnnotationType__TargetsAssignment_6_1_2_1");
					put(grammarAccess.getAnnotationTypeAccess().getAttributesAssignment_7(), "rule__AnnotationType__AttributesAssignment_7");
					put(grammarAccess.getSimpleAnnotationAttributeAccess().getOptionalAssignment_0_0(), "rule__SimpleAnnotationAttribute__OptionalAssignment_0_0");
					put(grammarAccess.getSimpleAnnotationAttributeAccess().getNameAssignment_2(), "rule__SimpleAnnotationAttribute__NameAssignment_2");
					put(grammarAccess.getSimpleAnnotationAttributeAccess().getTypeAssignment_4(), "rule__SimpleAnnotationAttribute__TypeAssignment_4");
					put(grammarAccess.getEnumAnnotationAttributeAccess().getOptionalAssignment_0_0(), "rule__EnumAnnotationAttribute__OptionalAssignment_0_0");
					put(grammarAccess.getEnumAnnotationAttributeAccess().getNameAssignment_2(), "rule__EnumAnnotationAttribute__NameAssignment_2");
					put(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_5(), "rule__EnumAnnotationAttribute__ValuesAssignment_5");
					put(grammarAccess.getEnumAnnotationAttributeAccess().getValuesAssignment_6_1(), "rule__EnumAnnotationAttribute__ValuesAssignment_6_1");
					put(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1_0_0(), "rule__Import__ImportedNamespaceAssignment_1_0_0");
					put(grammarAccess.getImportAccess().getImportURIAssignment_2(), "rule__Import__ImportURIAssignment_2");
					put(grammarAccess.getDocumentationAccess().getLinesAssignment_2(), "rule__Documentation__LinesAssignment_2");
					put(grammarAccess.getLiteralArrayAccess().getLiteralsAssignment_0(), "rule__LiteralArray__LiteralsAssignment_0");
					put(grammarAccess.getLiteralArrayAccess().getLiteralsAssignment_1_1(), "rule__LiteralArray__LiteralsAssignment_1_1");
					put(grammarAccess.getBooleanLiteralAccess().getIsTrueAssignment_1_1(), "rule__BooleanLiteral__IsTrueAssignment_1_1");
					put(grammarAccess.getRealLiteralAccess().getValueAssignment_1(), "rule__RealLiteral__ValueAssignment_1");
					put(grammarAccess.getIntLiteralAccess().getValueAssignment_1(), "rule__IntLiteral__ValueAssignment_1");
					put(grammarAccess.getStringLiteralAccess().getValueAssignment_1(), "rule__StringLiteral__ValueAssignment_1");
					put(grammarAccess.getModelComponentAccess().getUnorderedGroup_0(), "rule__ModelComponent__UnorderedGroup_0");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.eclipse.etrice.core.fsm.ui.contentassist.antlr.internal.InternalFSMParser typedParser = (org.eclipse.etrice.core.fsm.ui.contentassist.antlr.internal.InternalFSMParser) parser;
			typedParser.entryRuleFSMModel();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public FSMGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(FSMGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
