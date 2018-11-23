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

package org.eclipse.etrice.core.fsm.formatting2

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.common.converter.BaseConverterService
import org.eclipse.etrice.core.common.formatting2.BaseFormatter
import org.eclipse.etrice.core.common.formatting2.CCStringReplacer
import org.eclipse.etrice.core.fsm.fSM.DetailCode
import org.eclipse.etrice.core.fsm.fSM.ProtocolSemantics
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.fsm.fSM.StateGraph
import org.eclipse.etrice.core.fsm.fSM.TransitionBase
import org.eclipse.etrice.core.fsm.fSM.Trigger
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition
import org.eclipse.etrice.core.fsm.services.FSMGrammarAccess
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion

class FSMFormatter extends BaseFormatter {
	
	@Inject extension FSMGrammarAccess
	
	override void formatAllByKeywords(EObject it, extension IFormattableDocument document) {
		super.formatAllByKeywords(it, document)
		
		allRegionsFor.keywords('->', 'extends', '=', 'or', '|').forEach[surround[oneSpace]]
	}
	
	protected def prependDefaultNewLines(EObject it, extension IFormattableDocument document) {
		if(previousHiddenRegion !== null && previousHiddenRegion.lineCount > 2) prepend[newLines = 2] else prepend[newLine]
	}
	
	protected def prependDefaultNewLines(ISemanticRegion it, extension IFormattableDocument document) {
		if(previousHiddenRegion.lineCount > 2) prepend[newLines = 2] else prepend[newLine]
	}
	
	def dispatch void format(StateGraph it, extension IFormattableDocument document) {
		eContents.forEach[prependDefaultNewLines(document)]
		eContents.forEach[format] // format children
	}
	
	def dispatch void format(State it, extension IFormattableDocument document) {
		regionFor.keywords('entry', 'exit', 'do', 'subgraph').forEach[prependDefaultNewLines(document) append[oneSpace]]
		eContents.forEach[format] // format children
	}
	
	def dispatch void format(TransitionBase it, extension IFormattableDocument document) {
		regionFor.keywords('action', 'guard', 'cond', 'triggers').forEach[prependDefaultNewLines(document) append[oneSpace]]	
		if(it instanceof TriggeredTransition) {
			triggers.head.prepend[newLine]
			triggers.tail.forEach[prepend[oneSpace]]
		}
		eContents.forEach[format] // format children
	}
	
	def dispatch void format(Trigger it, extension IFormattableDocument document) {
		regionFor.keywordPairs('<', '>').forEach[interior[noSpace]]
		eContents.forEach[format] // format children
	}
	
	def dispatch void format(ProtocolSemantics it, extension IFormattableDocument document) {
		rules.forEach[prependDefaultNewLines(document)]
		eContents.forEach[format] // format children
	}
	
	@Inject
	BaseConverterService converterService
	
	def dispatch void format(DetailCode detailcode, extension IFormattableDocument document) {		
		val ccRegion = detailcode.regionFor.assignment(detailCodeAccess.linesAssignment_0_1)
		if(ccRegion !== null) {
			detailcode.prepend[oneSpace]
			if(detailcode.multiline) document.addReplacer(new CCStringReplacer(document, ccRegion, converterService.CC_StringConverter))
		} else {
			detailcode.regionFor.assignments(detailCodeAccess.linesAssignment_1_1).forEach[prepend[newLine]]
		}
	}
}
