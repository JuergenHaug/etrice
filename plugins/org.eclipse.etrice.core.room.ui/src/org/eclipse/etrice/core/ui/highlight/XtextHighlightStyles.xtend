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
 * 		juergen.haug@protos.de (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.highlight

import org.eclipse.etrice.expressions.ui.highlight.AbstractHighlightStyles

import static org.eclipse.etrice.core.ui.highlight.RoomHighlightingConfiguration.*
import static org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration.*

class XtextHighlightStyles extends AbstractHighlightStyles {

	override getDefault() {
		// xtext settings
		DEFAULT_ID
	}
	
	override getTargetKeyword() {
		// xtext settings
		KEYWORD_ID
	}
	
	override getComment() {
		// xtext settings
		COMMENT_ID
	}
	
	override getString() {
		// xtext settings
		STRING_ID
	}
	
	override getNumber() {
		// xtext settings
		NUMBER_ID
	}
	
	override getSpecialFeature() {
		HL_EXPR_SPECIAL_FEATURE_ID
	}
	
	override getOperation() {
		HL_EXPR_OPERATION_ID
	}
	
	override getAttribute() {
		HL_EXPR_ATTRIBUTE_ID
	}
	
	override getInterfaceItem() {
		HL_EXPR_INTERFACE_ITEM_ID
	}
	
	override getEnum() {
		HL_EXPR_ENUM_ID
	}
	
	override getDataClass() {
		HL_EXPR_DATA_CLASS_ID
	}
	
	override getPrimitiveType() {
		HL_PRIMITIVE_TYPE_ID
	}
	
	override getExternalType() {
		HL_EXTERNAL_TYPE_ID
	}
	
}
