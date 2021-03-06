/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.ui.behavior.actioneditor.modelaware

import java.util.Map
import org.eclipse.etrice.expressions.ui.highlight.AbstractHighlightStyles
import org.eclipse.jface.text.TextAttribute
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.Color
import org.eclipse.swt.graphics.RGB
import org.eclipse.swt.widgets.Display

class JFaceHighlightStyles extends AbstractHighlightStyles {

	override getDefault() {
		new TextAttribute(getColor(DEFAULT_RGB))
	}
	
	override getTargetKeyword() {
		new TextAttribute(getColor(TARGET_KEYWORD_RGB), null, SWT.BOLD)
	}
	
	override getComment() {
		new TextAttribute(getColor(COMMENT_RGB))
	}
	
	override getString() {
		new TextAttribute(getColor(STRING_RGB))
	}
	
	override getNumber() {
		new TextAttribute(getColor(NUMBER_RGB))
	}
	
	override getSpecialFeature() {
		new TextAttribute(getColor(SPECIAL_FEATURE_RGB))
	}
	
	override getOperation() {
		new TextAttribute(getColor(OPERATION_RGB))
	}
	
	override getAttribute() {
		new TextAttribute(getColor(ATTRIBUTE_RGB))
	}
	
	override getInterfaceItem() {
		new TextAttribute(getColor(INTERFACE_ITEM_RGB))
	}
	
	override getEnum() {
		new TextAttribute(getColor(ENUM_RGB))
	}
	
	override getDataClass() {
		new TextAttribute(getColor(DATA_CLASS_RGB))
	}
	
	override getPrimitiveType() {
		new TextAttribute(getColor(PRIMITIVE_TYPE_RGB))
	}
	
	override getExternalType() {
		new TextAttribute(getColor(EXTERNAL_TYPE_RGB))
	}
	
	protected Map<RGB, Color> fColorTable = newHashMap
	
	def private Color getColor(RGB rgb) {
		var color = fColorTable.get(rgb)
		if (color === null) {
			color = new Color(Display.getCurrent(), rgb)
			fColorTable.put(rgb, color)
		}
		
		return color
	}
	
}