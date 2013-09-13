/*
* generated by Xtext
*/
package org.eclipse.etrice.core.common.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class BaseGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class LiteralArrayElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "LiteralArray");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cLiteralsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cLiteralsLiteralParserRuleCall_0_0 = (RuleCall)cLiteralsAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cCommaKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cLiteralsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cLiteralsLiteralParserRuleCall_1_1_0 = (RuleCall)cLiteralsAssignment_1_1.eContents().get(0);
		
		//LiteralArray:
		//
		//	literals+=Literal ("," literals+=Literal)*;
		public ParserRule getRule() { return rule; }

		//literals+=Literal ("," literals+=Literal)*
		public Group getGroup() { return cGroup; }

		//literals+=Literal
		public Assignment getLiteralsAssignment_0() { return cLiteralsAssignment_0; }

		//Literal
		public RuleCall getLiteralsLiteralParserRuleCall_0_0() { return cLiteralsLiteralParserRuleCall_0_0; }

		//("," literals+=Literal)*
		public Group getGroup_1() { return cGroup_1; }

		//","
		public Keyword getCommaKeyword_1_0() { return cCommaKeyword_1_0; }

		//literals+=Literal
		public Assignment getLiteralsAssignment_1_1() { return cLiteralsAssignment_1_1; }

		//Literal
		public RuleCall getLiteralsLiteralParserRuleCall_1_1_0() { return cLiteralsLiteralParserRuleCall_1_1_0; }
	}

	public class LiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Literal");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cBooleanLiteralParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cNumberLiteralParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cStringLiteralParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//// Value Types for Attributes
		//
		//Literal:
		//
		//	BooleanLiteral | NumberLiteral | StringLiteral;
		public ParserRule getRule() { return rule; }

		//BooleanLiteral | NumberLiteral | StringLiteral
		public Alternatives getAlternatives() { return cAlternatives; }

		//BooleanLiteral
		public RuleCall getBooleanLiteralParserRuleCall_0() { return cBooleanLiteralParserRuleCall_0; }

		//NumberLiteral
		public RuleCall getNumberLiteralParserRuleCall_1() { return cNumberLiteralParserRuleCall_1; }

		//StringLiteral
		public RuleCall getStringLiteralParserRuleCall_2() { return cStringLiteralParserRuleCall_2; }
	}

	public class BooleanLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "BooleanLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cBooleanLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Keyword cFalseKeyword_1_0 = (Keyword)cAlternatives_1.eContents().get(0);
		private final Assignment cIsTrueAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final Keyword cIsTrueTrueKeyword_1_1_0 = (Keyword)cIsTrueAssignment_1_1.eContents().get(0);
		
		//BooleanLiteral:
		//
		//	{BooleanLiteral} ("false" | isTrue?="true");
		public ParserRule getRule() { return rule; }

		//{BooleanLiteral} ("false" | isTrue?="true")
		public Group getGroup() { return cGroup; }

		//{BooleanLiteral}
		public Action getBooleanLiteralAction_0() { return cBooleanLiteralAction_0; }

		//"false" | isTrue?="true"
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//"false"
		public Keyword getFalseKeyword_1_0() { return cFalseKeyword_1_0; }

		//isTrue?="true"
		public Assignment getIsTrueAssignment_1_1() { return cIsTrueAssignment_1_1; }

		//"true"
		public Keyword getIsTrueTrueKeyword_1_1_0() { return cIsTrueTrueKeyword_1_1_0; }
	}

	public class NumberLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NumberLiteral");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cIntLiteralParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cRealLiteralParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//NumberLiteral:
		//
		//	IntLiteral | RealLiteral;
		public ParserRule getRule() { return rule; }

		//IntLiteral | RealLiteral
		public Alternatives getAlternatives() { return cAlternatives; }

		//IntLiteral
		public RuleCall getIntLiteralParserRuleCall_0() { return cIntLiteralParserRuleCall_0; }

		//RealLiteral
		public RuleCall getRealLiteralParserRuleCall_1() { return cRealLiteralParserRuleCall_1; }
	}

	public class RealLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RealLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cRealLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueRealParserRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//RealLiteral:
		//
		//	{RealLiteral} value=Real;
		public ParserRule getRule() { return rule; }

		//{RealLiteral} value=Real
		public Group getGroup() { return cGroup; }

		//{RealLiteral}
		public Action getRealLiteralAction_0() { return cRealLiteralAction_0; }

		//value=Real
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//Real
		public RuleCall getValueRealParserRuleCall_1_0() { return cValueRealParserRuleCall_1_0; }
	}

	public class IntLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "IntLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cIntLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueIntegerParserRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//IntLiteral:
		//
		//	{IntLiteral} value=Integer;
		public ParserRule getRule() { return rule; }

		//{IntLiteral} value=Integer
		public Group getGroup() { return cGroup; }

		//{IntLiteral}
		public Action getIntLiteralAction_0() { return cIntLiteralAction_0; }

		//value=Integer
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//Integer
		public RuleCall getValueIntegerParserRuleCall_1_0() { return cValueIntegerParserRuleCall_1_0; }
	}

	public class StringLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "StringLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cStringLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueSTRINGTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//StringLiteral:
		//
		//	{StringLiteral} value=STRING;
		public ParserRule getRule() { return rule; }

		//{StringLiteral} value=STRING
		public Group getGroup() { return cGroup; }

		//{StringLiteral}
		public Action getStringLiteralAction_0() { return cStringLiteralAction_0; }

		//value=STRING
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_1_0() { return cValueSTRINGTerminalRuleCall_1_0; }
	}

	public class IntegerElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Integer");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSignedIntegerParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cHexadecimalParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//Integer returns ecore::ELong:
		//
		//	SignedInteger | Hexadecimal;
		public ParserRule getRule() { return rule; }

		//SignedInteger | Hexadecimal
		public Alternatives getAlternatives() { return cAlternatives; }

		//SignedInteger
		public RuleCall getSignedIntegerParserRuleCall_0() { return cSignedIntegerParserRuleCall_0; }

		//Hexadecimal
		public RuleCall getHexadecimalParserRuleCall_1() { return cHexadecimalParserRuleCall_1; }
	}

	public class SignedIntegerElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SignedInteger");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Keyword cPlusSignKeyword_0_0 = (Keyword)cAlternatives_0.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_0_1 = (Keyword)cAlternatives_0.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		
		//SignedInteger hidden():
		//
		//	("+" | "-")? INT;
		public ParserRule getRule() { return rule; }

		//("+" | "-")? INT
		public Group getGroup() { return cGroup; }

		//("+" | "-")?
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//"+"
		public Keyword getPlusSignKeyword_0_0() { return cPlusSignKeyword_0_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_0_1() { return cHyphenMinusKeyword_0_1; }

		//INT
		public RuleCall getINTTerminalRuleCall_1() { return cINTTerminalRuleCall_1; }
	}

	public class HexadecimalElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Hexadecimal");
		private final RuleCall cHEXTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//Hexadecimal hidden():
		//
		//	HEX;
		public ParserRule getRule() { return rule; }

		//HEX
		public RuleCall getHEXTerminalRuleCall() { return cHEXTerminalRuleCall; }
	}

	public class RealElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Real");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cDecimalParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cDotDecimalParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cDecimalDotParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cDecimalExpParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//Real returns ecore::EDouble:
		//
		//	Decimal | DotDecimal | DecimalDot | DecimalExp;
		public ParserRule getRule() { return rule; }

		//Decimal | DotDecimal | DecimalDot | DecimalExp
		public Alternatives getAlternatives() { return cAlternatives; }

		//Decimal
		public RuleCall getDecimalParserRuleCall_0() { return cDecimalParserRuleCall_0; }

		//DotDecimal
		public RuleCall getDotDecimalParserRuleCall_1() { return cDotDecimalParserRuleCall_1; }

		//DecimalDot
		public RuleCall getDecimalDotParserRuleCall_2() { return cDecimalDotParserRuleCall_2; }

		//DecimalExp
		public RuleCall getDecimalExpParserRuleCall_3() { return cDecimalExpParserRuleCall_3; }
	}

	public class DecimalElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Decimal");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Keyword cPlusSignKeyword_0_0 = (Keyword)cAlternatives_0.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_0_1 = (Keyword)cAlternatives_0.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final RuleCall cINTTerminalRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		
		//Decimal hidden():
		//
		//	("+" | "-")? INT "." INT;
		public ParserRule getRule() { return rule; }

		//("+" | "-")? INT "." INT
		public Group getGroup() { return cGroup; }

		//("+" | "-")?
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//"+"
		public Keyword getPlusSignKeyword_0_0() { return cPlusSignKeyword_0_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_0_1() { return cHyphenMinusKeyword_0_1; }

		//INT
		public RuleCall getINTTerminalRuleCall_1() { return cINTTerminalRuleCall_1; }

		//"."
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }

		//INT
		public RuleCall getINTTerminalRuleCall_3() { return cINTTerminalRuleCall_3; }
	}

	public class DotDecimalElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DotDecimal");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Keyword cPlusSignKeyword_0_0 = (Keyword)cAlternatives_0.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_0_1 = (Keyword)cAlternatives_0.eContents().get(1);
		private final Keyword cFullStopKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		
		//DotDecimal hidden():
		//
		//	("+" | "-")? "." INT;
		public ParserRule getRule() { return rule; }

		//("+" | "-")? "." INT
		public Group getGroup() { return cGroup; }

		//("+" | "-")?
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//"+"
		public Keyword getPlusSignKeyword_0_0() { return cPlusSignKeyword_0_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_0_1() { return cHyphenMinusKeyword_0_1; }

		//"."
		public Keyword getFullStopKeyword_1() { return cFullStopKeyword_1; }

		//INT
		public RuleCall getINTTerminalRuleCall_2() { return cINTTerminalRuleCall_2; }
	}

	public class DecimalDotElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DecimalDot");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Keyword cPlusSignKeyword_0_0 = (Keyword)cAlternatives_0.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_0_1 = (Keyword)cAlternatives_0.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//DecimalDot hidden():
		//
		//	("+" | "-")? INT ".";
		public ParserRule getRule() { return rule; }

		//("+" | "-")? INT "."
		public Group getGroup() { return cGroup; }

		//("+" | "-")?
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//"+"
		public Keyword getPlusSignKeyword_0_0() { return cPlusSignKeyword_0_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_0_1() { return cHyphenMinusKeyword_0_1; }

		//INT
		public RuleCall getINTTerminalRuleCall_1() { return cINTTerminalRuleCall_1; }

		//"."
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }
	}

	public class DecimalExpElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DecimalExp");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Keyword cPlusSignKeyword_0_0 = (Keyword)cAlternatives_0.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_0_1 = (Keyword)cAlternatives_0.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final RuleCall cINTTerminalRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		private final RuleCall cEXPTerminalRuleCall_4 = (RuleCall)cGroup.eContents().get(4);
		
		//DecimalExp hidden():
		//
		//	("+" | "-")? INT "." INT EXP;
		public ParserRule getRule() { return rule; }

		//("+" | "-")? INT "." INT EXP
		public Group getGroup() { return cGroup; }

		//("+" | "-")?
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//"+"
		public Keyword getPlusSignKeyword_0_0() { return cPlusSignKeyword_0_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_0_1() { return cHyphenMinusKeyword_0_1; }

		//INT
		public RuleCall getINTTerminalRuleCall_1() { return cINTTerminalRuleCall_1; }

		//"."
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }

		//INT
		public RuleCall getINTTerminalRuleCall_3() { return cINTTerminalRuleCall_3; }

		//EXP
		public RuleCall getEXPTerminalRuleCall_4() { return cEXPTerminalRuleCall_4; }
	}
	
	
	private LiteralArrayElements pLiteralArray;
	private LiteralElements pLiteral;
	private BooleanLiteralElements pBooleanLiteral;
	private NumberLiteralElements pNumberLiteral;
	private RealLiteralElements pRealLiteral;
	private IntLiteralElements pIntLiteral;
	private StringLiteralElements pStringLiteral;
	private IntegerElements pInteger;
	private SignedIntegerElements pSignedInteger;
	private HexadecimalElements pHexadecimal;
	private RealElements pReal;
	private DecimalElements pDecimal;
	private DotDecimalElements pDotDecimal;
	private DecimalDotElements pDecimalDot;
	private DecimalExpElements pDecimalExp;
	private TerminalRule tEXP;
	private TerminalRule tHEX;
	
	private final Grammar grammar;

	private TerminalsGrammarAccess gaTerminals;

	@Inject
	public BaseGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.etrice.core.common.Base".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	
	public Grammar getGrammar() {
		return grammar;
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//LiteralArray:
	//
	//	literals+=Literal ("," literals+=Literal)*;
	public LiteralArrayElements getLiteralArrayAccess() {
		return (pLiteralArray != null) ? pLiteralArray : (pLiteralArray = new LiteralArrayElements());
	}
	
	public ParserRule getLiteralArrayRule() {
		return getLiteralArrayAccess().getRule();
	}

	//// Value Types for Attributes
	//
	//Literal:
	//
	//	BooleanLiteral | NumberLiteral | StringLiteral;
	public LiteralElements getLiteralAccess() {
		return (pLiteral != null) ? pLiteral : (pLiteral = new LiteralElements());
	}
	
	public ParserRule getLiteralRule() {
		return getLiteralAccess().getRule();
	}

	//BooleanLiteral:
	//
	//	{BooleanLiteral} ("false" | isTrue?="true");
	public BooleanLiteralElements getBooleanLiteralAccess() {
		return (pBooleanLiteral != null) ? pBooleanLiteral : (pBooleanLiteral = new BooleanLiteralElements());
	}
	
	public ParserRule getBooleanLiteralRule() {
		return getBooleanLiteralAccess().getRule();
	}

	//NumberLiteral:
	//
	//	IntLiteral | RealLiteral;
	public NumberLiteralElements getNumberLiteralAccess() {
		return (pNumberLiteral != null) ? pNumberLiteral : (pNumberLiteral = new NumberLiteralElements());
	}
	
	public ParserRule getNumberLiteralRule() {
		return getNumberLiteralAccess().getRule();
	}

	//RealLiteral:
	//
	//	{RealLiteral} value=Real;
	public RealLiteralElements getRealLiteralAccess() {
		return (pRealLiteral != null) ? pRealLiteral : (pRealLiteral = new RealLiteralElements());
	}
	
	public ParserRule getRealLiteralRule() {
		return getRealLiteralAccess().getRule();
	}

	//IntLiteral:
	//
	//	{IntLiteral} value=Integer;
	public IntLiteralElements getIntLiteralAccess() {
		return (pIntLiteral != null) ? pIntLiteral : (pIntLiteral = new IntLiteralElements());
	}
	
	public ParserRule getIntLiteralRule() {
		return getIntLiteralAccess().getRule();
	}

	//StringLiteral:
	//
	//	{StringLiteral} value=STRING;
	public StringLiteralElements getStringLiteralAccess() {
		return (pStringLiteral != null) ? pStringLiteral : (pStringLiteral = new StringLiteralElements());
	}
	
	public ParserRule getStringLiteralRule() {
		return getStringLiteralAccess().getRule();
	}

	//Integer returns ecore::ELong:
	//
	//	SignedInteger | Hexadecimal;
	public IntegerElements getIntegerAccess() {
		return (pInteger != null) ? pInteger : (pInteger = new IntegerElements());
	}
	
	public ParserRule getIntegerRule() {
		return getIntegerAccess().getRule();
	}

	//SignedInteger hidden():
	//
	//	("+" | "-")? INT;
	public SignedIntegerElements getSignedIntegerAccess() {
		return (pSignedInteger != null) ? pSignedInteger : (pSignedInteger = new SignedIntegerElements());
	}
	
	public ParserRule getSignedIntegerRule() {
		return getSignedIntegerAccess().getRule();
	}

	//Hexadecimal hidden():
	//
	//	HEX;
	public HexadecimalElements getHexadecimalAccess() {
		return (pHexadecimal != null) ? pHexadecimal : (pHexadecimal = new HexadecimalElements());
	}
	
	public ParserRule getHexadecimalRule() {
		return getHexadecimalAccess().getRule();
	}

	//Real returns ecore::EDouble:
	//
	//	Decimal | DotDecimal | DecimalDot | DecimalExp;
	public RealElements getRealAccess() {
		return (pReal != null) ? pReal : (pReal = new RealElements());
	}
	
	public ParserRule getRealRule() {
		return getRealAccess().getRule();
	}

	//Decimal hidden():
	//
	//	("+" | "-")? INT "." INT;
	public DecimalElements getDecimalAccess() {
		return (pDecimal != null) ? pDecimal : (pDecimal = new DecimalElements());
	}
	
	public ParserRule getDecimalRule() {
		return getDecimalAccess().getRule();
	}

	//DotDecimal hidden():
	//
	//	("+" | "-")? "." INT;
	public DotDecimalElements getDotDecimalAccess() {
		return (pDotDecimal != null) ? pDotDecimal : (pDotDecimal = new DotDecimalElements());
	}
	
	public ParserRule getDotDecimalRule() {
		return getDotDecimalAccess().getRule();
	}

	//DecimalDot hidden():
	//
	//	("+" | "-")? INT ".";
	public DecimalDotElements getDecimalDotAccess() {
		return (pDecimalDot != null) ? pDecimalDot : (pDecimalDot = new DecimalDotElements());
	}
	
	public ParserRule getDecimalDotRule() {
		return getDecimalDotAccess().getRule();
	}

	//DecimalExp hidden():
	//
	//	("+" | "-")? INT "." INT EXP;
	public DecimalExpElements getDecimalExpAccess() {
		return (pDecimalExp != null) ? pDecimalExp : (pDecimalExp = new DecimalExpElements());
	}
	
	public ParserRule getDecimalExpRule() {
		return getDecimalExpAccess().getRule();
	}

	//terminal EXP:
	//
	//	("e" | "E") ("+" | "-")? "0".."9"+;
	public TerminalRule getEXPRule() {
		return (tEXP != null) ? tEXP : (tEXP = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "EXP"));
	} 

	//terminal HEX:
	//
	//	("0x" | "0X") ("0".."9" | "a".."f" | "A".."F")+;
	public TerminalRule getHEXRule() {
		return (tHEX != null) ? tHEX : (tHEX = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "HEX"));
	} 

	//terminal ID:
	//
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" |
	//
	//	"n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}