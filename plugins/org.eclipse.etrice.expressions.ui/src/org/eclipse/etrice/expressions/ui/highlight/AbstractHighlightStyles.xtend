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

package org.eclipse.etrice.expressions.ui.highlight

import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.EnumLiteral
import org.eclipse.etrice.core.room.EnumerationType
import org.eclipse.etrice.core.room.InterfaceItem
import org.eclipse.etrice.core.room.MessageData
import org.eclipse.etrice.core.room.Operation
import org.eclipse.etrice.core.room.VarDecl
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider.ExpressionFeature
import org.eclipse.swt.graphics.RGB
import org.eclipse.etrice.core.room.PrimitiveType
import org.eclipse.etrice.core.room.ExternalType

/** Enables re-usability of scanner for xtext and jface editor */
abstract class AbstractHighlightStyles {
	
	// aligned with xtext
	public static val DEFAULT_RGB = new RGB(0, 0, 0)
	public static val TARGET_KEYWORD_RGB = new RGB(127, 0, 85)
	public static val COMMENT_RGB = new RGB(63, 127, 95)
	public static val STRING_RGB = new RGB(42, 0, 255)
	public static val NUMBER_RGB = new RGB(125, 125, 125)

	public static val SPECIAL_FEATURE_RGB = new RGB(220, 48, 0)
	public static val OPERATION_RGB = new RGB(204, 153, 0)
	public static val ATTRIBUTE_RGB = new RGB(105, 185, 0)
	public static val INTERFACE_ITEM_RGB = new RGB(200, 100, 0)
	public static val ENUM_RGB = new RGB(90, 95, 180)
	public static val DATA_CLASS_RGB = new RGB(0, 125, 0)
	public static val PRIMITIVE_TYPE_RGB = new RGB(60, 135, 130)
	public static val EXTERNAL_TYPE_RGB = new RGB(140, 125, 0)
	
	def Object getDefault()
	def Object getTargetKeyword()
	def Object getComment()
	def Object getString()
	def Object getNumber()
	def Object getSpecialFeature()
	def Object getOperation()
	def Object getAttribute()
	def Object getInterfaceItem()
	def Object getEnum()
	def Object getDataClass()
	def Object getPrimitiveType()
	def Object getExternalType()
	
	def Object getStyle(ExpressionFeature feature) {
		// xtext uses ID
		switch feature.data {
			InterfaceItem:
				interfaceItem
			Attribute:
				attribute
			Operation:
				operation
			EnumerationType,
			EnumLiteral:
				enum
			DataClass:
				dataClass
			PrimitiveType:
				primitiveType
			ExternalType:
				externalType
			MessageData,
			VarDecl:
				specialFeature
//			RuntimeMethodExpressionData:
//				operation
		}
	}
	
}
