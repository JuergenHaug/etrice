/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/
package org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer

import com.google.common.base.Strings
import com.google.inject.Inject
import org.eclipse.core.runtime.Assert
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.InterfaceItem
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.Operation
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.SPP
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.etrice.ui.behavior.fsm.detailcode.IDetailExpressionProvider
import org.eclipse.jface.viewers.ILabelProvider
import org.eclipse.swt.graphics.Image
import org.eclipse.swt.graphics.Point
import org.eclipse.swt.graphics.RGB
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.etrice.ui.behavior.detailcode.RuntimeDetailExpressionProvider.RuntimeMethodExpressionData
import org.eclipse.etrice.ui.behavior.actioneditor.Activator

@FinalFieldsConstructor
class DetailExpressionUIProvider implements IDetailExpressionProvider {

	static val String IMAGE_RT_METHOD = "icons/rt_method.png"

	@Delegate
	val IDetailExpressionProvider delegate

	@Inject
	protected ILabelProvider labelProvider

	@Inject
	protected RoomHelpers roomHelpers

	/**
	 * Return postfix string and its selection (relative start, length)
	 */
	def Pair<String, Point> getPostfixReplacement(ExpressionFeature feature) {
		feature.assertNotNull

		var String[] brackets = switch feature.postfix {
			case PARENTHESES: #['(', ')']
			case BRACKETS: #['[', ']']
			default: return "" -> null
		}
		var String replacement = switch data : feature.data {
			Operation:
				data.arguments.map[name].join(', ')
			Message case data.data != null:
				data.data.name
			Attribute, // fall through
			InterfaceItem:
				'0'
			default:
				''
		}

		val selection = if(!replacement.empty) new Point(1, replacement.length)
		brackets.head + replacement + brackets.last -> selection
	}

	/**
	 * Return completion string and its selection (relative start, length)
	 */
	def Pair<String, Point> getCompletion(ExpressionFeature feature) {
		feature.assertNotNull

		var postfix = getPostfixReplacement(feature)
		var point = postfix.value
		if (point != null)
			point.x += feature.id.length

		return feature.id + postfix.key -> point
	}

	def RGB getColor(ExpressionFeature feature) {
		feature.assertNotNull

		return switch data : feature.data {
			InterfaceItem: ActionCodeColorManager.INTERFACE_ITEM
			Attribute: ActionCodeColorManager.ATTRIBUTE
			Operation: ActionCodeColorManager.OPERATION
			EObject: ActionCodeColorManager.SPECIAL_FEATURE
		}
	}

	/**
	 * Text format:
	 * {@code completionInfo : typedInfo - classInfo}
	 */
	def String getDisplayString(ExpressionFeature feature) {
		feature.assertNotNull

		val data = feature.data
		
		var completionInfo = feature.id + feature.getPostfixReplacement.key
		var typedInfo = ""
		var classInfo = if(data instanceof EObject) data.eClass.name else ""
		switch data {
			Attribute:
				typedInfo = data.type.type.name
			InterfaceItem:
				typedInfo = roomHelpers.getProtocol(data).name
			RuntimeMethodExpressionData:
				typedInfo = 'int'	
			default: {
				val label = labelProvider.getText(data)
				// if label starts with completion then label might be better
				if(!Strings.commonPrefix(label, completionInfo).empty) completionInfo = label
			}
		}
		// mark port as broadcast
		if (feature.postfix == ExpressionPostfix.NONE) {
			switch data {
				SPP case data.isEventDriven/* fall through */,
				Port case data.isReplicated && data.isEventDriven:
					completionInfo = completionInfo + " (broadcast)"
			}
		}

		if(!typedInfo.empty) typedInfo = " : " + typedInfo 
		if(!classInfo.empty) classInfo = " - " + classInfo

		return completionInfo + typedInfo + classInfo
	}

	def Image getImage(ExpressionFeature feature) {
		feature.assertNotNull
		
		switch feature.data {
			EObject : labelProvider.getImage(feature.data)
			RuntimeMethodExpressionData: Activator.getImage(IMAGE_RT_METHOD)
		}
	}
	
	/**
	 * Filter by prefix
	 */
	def getContextFeaturesWithPrefix(ExpressionFeature ctx, String prefix) {
		delegate.getContextFeatures(ctx).filter[id.startsWith(prefix)]
	}

	/**
	 * Filter by prefix
	 */
	def getInitialFeaturesWithPrefix(String prefix) {
		delegate.initialFeatures.filter[id.startsWith(prefix)]
	}

	def protected assertNotNull(ExpressionFeature feature) {
		Assert.isTrue(!Strings.isNullOrEmpty(feature.id))
		Assert.isNotNull(feature.postfix)
		Assert.isNotNull(feature.data)
	}

}
