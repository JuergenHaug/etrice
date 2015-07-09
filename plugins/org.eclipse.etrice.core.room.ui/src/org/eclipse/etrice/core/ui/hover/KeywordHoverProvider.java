/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		https://borisdevnotes.wordpress.com/2014/02/28/xtext-usability-hovers-on-keywords/
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.hover;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.ui.RoomUiActivator;
import org.eclipse.etrice.doc.ETriceHelp;
import org.eclipse.jface.internal.text.html.HTMLPrinter;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;
import org.eclipse.xtext.util.Files;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class KeywordHoverProvider extends DefaultEObjectHoverProvider {

	private static final String styleSheetFileName = "/eTriceKeywordHoverStyle.css";

	@Inject
	protected ILabelProvider labelProvider;

	private String styleSheet = null;

	@Override
	protected XtextBrowserInformationControlInput getHoverInfo(EObject element, IRegion hoverRegion,
			XtextBrowserInformationControlInput previous) {
		if (element instanceof Keyword) {
			Keyword keyword = (Keyword) element;
			String html = ETriceHelp.getKeywordHoverContentProvider().getHTMLContent(keyword.getValue());
			if (html != null) {
				StringBuffer buffer = new StringBuffer(html);
				HTMLPrinter.insertPageProlog(buffer, 0, getKeywordStyleSheet());
				HTMLPrinter.addPageEpilog(buffer);
				return new XtextBrowserInformationControlInput(previous, element, buffer.toString(), labelProvider);
			}
		}
		return super.getHoverInfo(element, hoverRegion, previous);
	}

	protected String getKeywordStyleSheet() {
		String superStyle = super.getStyleSheet();
		if (styleSheet == null || ETriceHelp.DEV_MODE) {
			styleSheet = "";
			try {
				styleSheet = Files.readStreamIntoString(RoomUiActivator.getDefault().getBundle()
						.getEntry(styleSheetFileName).openStream());
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}

		return superStyle + styleSheet;
	}
}
