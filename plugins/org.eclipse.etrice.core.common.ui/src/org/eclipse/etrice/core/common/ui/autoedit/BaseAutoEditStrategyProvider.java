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

package org.eclipse.etrice.core.common.ui.autoedit;

import org.eclipse.etrice.core.common.ui.editor.model.BaseTokenTypeToPartitionMapper;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

public class BaseAutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {

	@Override
	protected void configureIndentationEditStrategy(IEditStrategyAcceptor acceptor) {
		acceptor.accept(defaultIndentLineAutoEditStrategy.get(), BaseTokenTypeToPartitionMapper.CCSTRING_LITERAL_PARTITION);
		super.configureIndentationEditStrategy(acceptor);
	}
	
	@Override
	protected void configureStringLiteral(IEditStrategyAcceptor acceptor) {
		acceptor.accept(partitionInsert.newInstance("'''", "'''"), IDocument.DEFAULT_CONTENT_TYPE);
		super.configureStringLiteral(acceptor);
	}
	
	protected void configureCompoundBracesBlocks(IEditStrategyAcceptor acceptor) {
		acceptor.accept(compoundMultiLineTerminals.newInstanceFor("{", "}").and("[", "]").and("(", ")"), BaseTokenTypeToPartitionMapper.CCSTRING_LITERAL_PARTITION);
		super.configureCompoundBracesBlocks(acceptor);
	}
	
	@Override
	protected void configureCurlyBracesBlock(IEditStrategyAcceptor acceptor) {
		acceptor.accept(singleLineTerminals.newInstance("{", "}"), BaseTokenTypeToPartitionMapper.CCSTRING_LITERAL_PARTITION);
		super.configureCurlyBracesBlock(acceptor);
	}

	@Override
	protected void configureSquareBrackets(IEditStrategyAcceptor acceptor) {
		acceptor.accept(singleLineTerminals.newInstance("[", "]"), BaseTokenTypeToPartitionMapper.CCSTRING_LITERAL_PARTITION);
		super.configureSquareBrackets(acceptor);
	}

	@Override
	protected void configureParenthesis(IEditStrategyAcceptor acceptor) {
		acceptor.accept(singleLineTerminals.newInstance("(", ")"), BaseTokenTypeToPartitionMapper.CCSTRING_LITERAL_PARTITION);
		super.configureParenthesis(acceptor);
	}
	
}
