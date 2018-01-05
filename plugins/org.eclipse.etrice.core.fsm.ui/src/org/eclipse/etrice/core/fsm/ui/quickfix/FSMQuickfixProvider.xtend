/*
* generated by Xtext
*/
package org.eclipse.etrice.core.fsm.ui.quickfix

import com.google.inject.Inject
import org.eclipse.etrice.core.fsm.fSM.DetailCode
import org.eclipse.etrice.core.fsm.validation.FSMJavaValidator
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue

/**
 * Custom quickfixes.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#quickfixes
 */
class FSMQuickfixProvider extends DefaultQuickfixProvider {

	@Inject
	IWhitespaceInformationProvider whitespaceProvider;

	@Fix(FSMJavaValidator.PLAIN_STRING_DETAILCODE)
	def void fixMultiLineDetailCode(Issue issue, IssueResolutionAcceptor acceptor){		
		acceptor.accept(issue, "Convert to smart string", "", "correction_change.gif", [ element, context |
			element as DetailCode => [
				val ccString = lines.join(whitespaceProvider.getLineSeparatorInformation(eResource.URI).lineSeparator)
				
				used = false
				lines.clear
				lines += ccString
			]			
		])
	}
	
}
