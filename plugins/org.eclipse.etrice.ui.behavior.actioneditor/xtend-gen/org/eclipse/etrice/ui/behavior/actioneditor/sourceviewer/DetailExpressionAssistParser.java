/**
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 */
package org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer;

import com.google.common.base.Objects;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.etrice.ui.behavior.fsm.detailcode.IDetailExpressionProvider;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class DetailExpressionAssistParser {
  private final IDocument document;
  
  private final int invocationOffset;
  
  private final IDetailExpressionProvider provider;
  
  private final IWordDetector anyIdScanner = new IWordDetector() {
    public boolean isWordPart(final char c) {
      return Character.isJavaIdentifierPart(c);
    }
    
    public boolean isWordStart(final char c) {
      return Character.isJavaIdentifierStart(c);
    }
  };
  
  public String computeIdentifierPrefix(final int offset) throws BadLocationException {
    int start = (offset - 1);
    while (((start >= 0) && this.anyIdScanner.isWordPart(this.document.getChar(start)))) {
      start--;
    }
    start++;
    return this.document.get(start, (offset - start));
  }
  
  public IDetailExpressionProvider.ExpressionFeature computeExpressionFeature(final int offset) throws BadLocationException {
    IDetailExpressionProvider.ExpressionPostfix postfixResult = null;
    char openingChar = 0;
    char closingChar = 0;
    char _char = this.document.getChar((offset - 1));
    String _string = Character.valueOf(_char).toString();
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_string, ")")) {
        _matched=true;
        postfixResult = IDetailExpressionProvider.ExpressionPostfix.PARENTHESES;
        openingChar = '(';
        closingChar = ')';
      }
    }
    if (!_matched) {
      if (Objects.equal(_string, "]")) {
        _matched=true;
        postfixResult = IDetailExpressionProvider.ExpressionPostfix.BRACKETS;
        openingChar = '[';
        closingChar = ']';
      }
    }
    if (!_matched) {
      postfixResult = IDetailExpressionProvider.ExpressionPostfix.NONE;
    }
    int start = offset;
    boolean _notEquals = (!Objects.equal(postfixResult, IDetailExpressionProvider.ExpressionPostfix.NONE));
    if (_notEquals) {
      start--;
      int counter = 1;
      while (((start > 0) && (counter > 0))) {
        {
          start--;
          char _char_1 = this.document.getChar(start);
          boolean _matched_1 = false;
          if (!_matched_1) {
            if (Objects.equal(_char_1, openingChar)) {
              _matched_1=true;
              counter--;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(_char_1, closingChar)) {
              _matched_1=true;
              counter++;
            }
          }
        }
      }
      if ((counter > 0)) {
        postfixResult = null;
      }
    }
    String idResult = null;
    try {
      String _computeIdentifierPrefix = this.computeIdentifierPrefix(start);
      idResult = _computeIdentifierPrefix;
    } catch (final Throwable _t) {
      if (_t instanceof BadLocationException) {
        final BadLocationException e = (BadLocationException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return new IDetailExpressionProvider.ExpressionFeature(idResult, postfixResult);
  }
  
  /**
   * Try to resolve latest complete ExpressionFeature, e.g.:
   *  <ul>
   * 	 <li>port0.m_ => port0</li>
   * 	<li> port0. => port0 </li>
   * 	 <li>port0 => null</li>
   *  </ul>
   */
  public IDetailExpressionProvider.ExpressionFeature resolveLatestCompleted() {
    int lastSeparatorPos = (this.invocationOffset - 1);
    try {
      final String invocationPrefix = this.computeIdentifierPrefix(this.invocationOffset);
      int _lastSeparatorPos = lastSeparatorPos;
      int _length = invocationPrefix.length();
      lastSeparatorPos = (_lastSeparatorPos - _length);
    } catch (final Throwable _t) {
      if (_t instanceof BadLocationException) {
        final BadLocationException e = (BadLocationException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    final LinkedList<IDetailExpressionProvider.ExpressionFeature> parsedFeatures = CollectionLiterals.<IDetailExpressionProvider.ExpressionFeature>newLinkedList();
    try {
      while ((this.document.getChar(lastSeparatorPos) == IDetailExpressionProvider.SEPARATOR)) {
        {
          final IDetailExpressionProvider.ExpressionFeature parseResult = this.computeExpressionFeature(lastSeparatorPos);
          boolean _isValid = this.isValid(parseResult);
          boolean _not = (!_isValid);
          if (_not) {
            return null;
          }
          parsedFeatures.push(parseResult);
          int _lastSeparatorPos_1 = lastSeparatorPos;
          String _id = parseResult.getId();
          int _length_1 = _id.length();
          int _plus = (_length_1 + 1);
          lastSeparatorPos = (_lastSeparatorPos_1 - _plus);
        }
      }
    } catch (final Throwable _t_1) {
      if (_t_1 instanceof BadLocationException) {
        final BadLocationException e_1 = (BadLocationException)_t_1;
      } else {
        throw Exceptions.sneakyThrow(_t_1);
      }
    }
    boolean _isEmpty = parsedFeatures.isEmpty();
    if (_isEmpty) {
      return null;
    }
    final IDetailExpressionProvider.ExpressionFeature firstParseResult = parsedFeatures.pop();
    List<IDetailExpressionProvider.ExpressionFeature> _initialFeatures = this.provider.getInitialFeatures();
    final Function1<IDetailExpressionProvider.ExpressionFeature, Boolean> _function = new Function1<IDetailExpressionProvider.ExpressionFeature, Boolean>() {
      public Boolean apply(final IDetailExpressionProvider.ExpressionFeature it) {
        return Boolean.valueOf(DetailExpressionAssistParser.this.matches(it, firstParseResult));
      }
    };
    IDetailExpressionProvider.ExpressionFeature lastMatch = IterableExtensions.<IDetailExpressionProvider.ExpressionFeature>findFirst(_initialFeatures, _function);
    while (((!Objects.equal(lastMatch, null)) && (!parsedFeatures.isEmpty()))) {
      {
        final IDetailExpressionProvider.ExpressionFeature nextParseResult = parsedFeatures.pop();
        List<IDetailExpressionProvider.ExpressionFeature> _contextFeatures = this.provider.getContextFeatures(lastMatch);
        final Function1<IDetailExpressionProvider.ExpressionFeature, Boolean> _function_1 = new Function1<IDetailExpressionProvider.ExpressionFeature, Boolean>() {
          public Boolean apply(final IDetailExpressionProvider.ExpressionFeature it) {
            return Boolean.valueOf(DetailExpressionAssistParser.this.matches(it, nextParseResult));
          }
        };
        IDetailExpressionProvider.ExpressionFeature _findFirst = IterableExtensions.<IDetailExpressionProvider.ExpressionFeature>findFirst(_contextFeatures, _function_1);
        lastMatch = _findFirst;
      }
    }
    return lastMatch;
  }
  
  /**
   * non-empty id + not-null suffix
   */
  private boolean isValid(final IDetailExpressionProvider.ExpressionFeature feature) {
    boolean _and = false;
    String _id = feature.getId();
    boolean _isEmpty = Strings.isEmpty(_id);
    boolean _not = (!_isEmpty);
    if (!_not) {
      _and = false;
    } else {
      IDetailExpressionProvider.ExpressionPostfix _postfix = feature.getPostfix();
      boolean _notEquals = (!Objects.equal(_postfix, null));
      _and = _notEquals;
    }
    return _and;
  }
  
  private boolean matches(final IDetailExpressionProvider.ExpressionFeature f1, final IDetailExpressionProvider.ExpressionFeature f2) {
    boolean _and = false;
    String _id = f1.getId();
    String _id_1 = f2.getId();
    boolean _equals = Objects.equal(_id, _id_1);
    if (!_equals) {
      _and = false;
    } else {
      IDetailExpressionProvider.ExpressionPostfix _postfix = f1.getPostfix();
      IDetailExpressionProvider.ExpressionPostfix _postfix_1 = f2.getPostfix();
      boolean _equals_1 = Objects.equal(_postfix, _postfix_1);
      _and = _equals_1;
    }
    return _and;
  }
  
  public DetailExpressionAssistParser(final IDocument document, final int invocationOffset, final IDetailExpressionProvider provider) {
    super();
    this.document = document;
    this.invocationOffset = invocationOffset;
    this.provider = provider;
  }
}
