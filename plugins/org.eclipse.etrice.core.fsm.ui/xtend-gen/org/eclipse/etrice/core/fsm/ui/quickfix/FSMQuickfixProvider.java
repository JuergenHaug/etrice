/**
 * generated by Xtext
 */
package org.eclipse.etrice.core.fsm.ui.quickfix;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.common.converter.CC_StringConveter;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.validation.FSMJavaValidator;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Custom quickfixes.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#quickfixes
 */
@SuppressWarnings("all")
public class FSMQuickfixProvider extends DefaultQuickfixProvider {
  @Inject
  private IWhitespaceInformationProvider whitespaceProvider;
  
  @Fix(FSMJavaValidator.PLAIN_STRING_DETAILCODE)
  public void fixMultiLineDetailCode(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final ISemanticModification _function = (EObject element, IModificationContext context) -> {
      final DetailCode dc = ((DetailCode) element);
      EList<String> _lines = dc.getLines();
      Resource _eResource = dc.eResource();
      URI _uRI = _eResource.getURI();
      ILineSeparatorInformation _lineSeparatorInformation = this.whitespaceProvider.getLineSeparatorInformation(_uRI);
      String _lineSeparator = _lineSeparatorInformation.getLineSeparator();
      final String ccString = IterableExtensions.join(_lines, _lineSeparator);
      ICompositeNode _findActualNodeFor = NodeModelUtils.findActualNodeFor(dc);
      final Procedure1<ICompositeNode> _function_1 = (ICompositeNode it) -> {
        try {
          IXtextDocument _xtextDocument = context.getXtextDocument();
          int _offset = it.getOffset();
          int _length = it.getLength();
          _xtextDocument.replace(_offset, _length, ((CC_StringConveter.DELIM + ccString) + CC_StringConveter.DELIM));
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      ObjectExtensions.<ICompositeNode>operator_doubleArrow(_findActualNodeFor, _function_1);
    };
    acceptor.accept(issue, "Convert to smart string", "", "correction_change.gif", _function);
  }
}
