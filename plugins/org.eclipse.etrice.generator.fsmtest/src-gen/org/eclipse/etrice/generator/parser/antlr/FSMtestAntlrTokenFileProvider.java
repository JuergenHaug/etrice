/*
* generated by Xtext
*/
package org.eclipse.etrice.generator.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class FSMtestAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/etrice/generator/parser/antlr/internal/InternalFSMtest.tokens");
	}
}
