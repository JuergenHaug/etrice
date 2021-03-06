/*
 * generated by Xtext
 */
package org.eclipse.etrice.core.common.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.etrice.core.common.services.BaseGrammarAccess;

public class BaseParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private BaseGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.eclipse.etrice.core.common.parser.antlr.internal.InternalBaseParser createParser(XtextTokenStream stream) {
		return new org.eclipse.etrice.core.common.parser.antlr.internal.InternalBaseParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Annotation";
	}
	
	public BaseGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(BaseGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
