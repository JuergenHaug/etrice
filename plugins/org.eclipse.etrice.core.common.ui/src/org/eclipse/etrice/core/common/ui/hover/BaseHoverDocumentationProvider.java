/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.ui.hover;

import static org.eclipse.etrice.core.common.documentation.DocumentationMarkup.MARKUP_ASCIIDOC;
import static org.eclipse.etrice.core.common.documentation.DocumentationMarkup.getMarkupType;
import static org.eclipse.etrice.core.common.documentation.DocumentationMarkup.trimMarkupTag;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.hover.html.DefaultHoverDocumentationProvider;

public class BaseHoverDocumentationProvider extends DefaultHoverDocumentationProvider {
	
	@Override
	public String getDocumentation(EObject object) { 
		String text = super.getDocumentation(object);
		if (text != null) {
			// hide copyright header
			int totalOffset = NodeModelUtils.getNode(object).getTotalOffset();
			if (totalOffset == 0 && text.trim().toLowerCase().startsWith("copyright")) {
				return null;
			} else {
				return processMarkup(text);
			}
		}

		return null;
	}
	
	protected String processMarkup(String text) {
		String markup = getMarkupType(text);
		String normText = text.replace("\r\n", "\n").trim();
		
		// return eclipse hover output html
		if(MARKUP_ASCIIDOC.equals(markup)) {
			// # asciidoctor markup
			// simulate asciidoctor line break behavior
			// 1. asciidoc new paragraph
			// 2. asciidoc new line
			return trimMarkupTag(normText).trim()
					.replaceAll("\\n\\n", "<br><br>")
					.replaceAll(" \\+\\n", "<br>");
		} 
		else {
			// # html markup
			return normText;
		}	
	}
}
