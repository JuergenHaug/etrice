/*
* generated by Xtext
*/
package org.eclipse.etrice.core.fsm.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class FSMAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/etrice/core/fsm/parser/antlr/internal/InternalFSM.tokens");
	}
}
