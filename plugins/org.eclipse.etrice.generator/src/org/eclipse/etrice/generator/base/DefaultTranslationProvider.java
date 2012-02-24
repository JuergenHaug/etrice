/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

import java.util.ArrayList;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;

public class DefaultTranslationProvider implements ITranslationProvider {

	@Override
	public boolean translateMembers() {
		return false;
	}

	@Override
	public String getAttributeText(Attribute att, String orig) {
		return orig;
	}

	@Override
	public String getOperationText(Operation op, ArrayList<String> args, String orig) {
		return orig;
	}

	@Override
	public String getInterfaceItemMessageText(InterfaceItem item, Message msg, ArrayList<String> args, String orig) {
		return orig;
	}

	@Override
	public String getInterfaceItemMessageValue(InterfaceItem item, Message msg, String orig) {
		return orig;
	}

	@Override
	public boolean translateTags() {
		return false;
	}

	@Override
	public String translateTag(String tag, DetailCode code) {
		return DetailCodeTranslator.TAG_START+tag+DetailCodeTranslator.TAG_END;
	}

	@Override
	public void setActorClass(ActorClass ac) {
	}
	
}