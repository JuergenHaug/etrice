/*
 * generated by Xtext
 */
package org.eclipse.etrice.core.etphys.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.etrice.core.etphys.services.ETPhysGrammarAccess;

public class ETPhysParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private ETPhysGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.eclipse.etrice.core.etphys.parser.antlr.internal.InternalETPhysParser createParser(XtextTokenStream stream) {
		return new org.eclipse.etrice.core.etphys.parser.antlr.internal.InternalETPhysParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "PhysicalModel";
	}
	
	public ETPhysGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(ETPhysGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
