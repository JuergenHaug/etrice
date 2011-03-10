/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.outline;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.ui.internal.RoomActivator;
import org.eclipse.etrice.ui.behavior.DiagramAccess;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.DefaultDocumentEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Injector;

/**
 * Handler for outline menu item to open behavior editor.
 * The handler will ask to save unsaved editor before opening the diagram.
 * 
 * If there are unnamed transitions they will be named with unique names.
 *
 * @author Henrik Rentz-Reichert initial contribution and API
 *
 */
public class EditBehaviorHandler extends AbstractEditHandler {

	protected boolean prepare(XtextEditor xtextEditor, final String fragment) {
		if (hasUnnamedTransitions(xtextEditor.getDocument(), fragment)) {
			if (!MessageDialog.openQuestion(xtextEditor.getSite().getShell(), "Create transition names", "Transition names will be created where missing.\nProceed?"))
				return false;
			createTransitionNames(xtextEditor.getDocument(), fragment);
			xtextEditor.doSave(new NullProgressMonitor());
		}
		return true;
	}

	/**
	 * @param document
	 * @param fragment
	 */
	private void createTransitionNames(IXtextDocument document, final String fragment) {
		DefaultDocumentEditor edit = new DefaultDocumentEditor();
		Injector injector = RoomActivator.getInstance().getInjector("org.eclipse.etrice.core.Room");
		injector.injectMembers(edit);
		edit.process(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource resource) throws Exception {
				if (resource != null) {
					EObject object = resource.getEObject(fragment);
					if (object instanceof ActorClass) {
						createTransitionNames(((ActorClass) object).getStateMachine());
					}
				}
			}

			private void createTransitionNames(StateGraph sg) {
				if (sg==null)
					return;
				
				for (Transition tr : sg.getTransitions()) {
					if (tr.getName()==null || tr.getName().isEmpty()) {
						tr.setName(RoomNameProvider.getUniqueTransitionName(sg));
					}
				}
				
				for (State s : sg.getStates()) {
					createTransitionNames(s.getSubgraph());
				}
			}
			
		}, document);
	}

	/**
	 * @param document
	 * @param fragment 
	 * @return
	 */
	private boolean hasUnnamedTransitions(IXtextDocument document, final String fragment) {
		return document.readOnly(new IUnitOfWork<Boolean, XtextResource>() {
			@Override
			public Boolean exec(XtextResource resource) throws Exception {
				if (resource != null) {
					EObject object = resource.getEObject(fragment);
					if (object instanceof ActorClass) {
						return hasUnnamedTransitions(((ActorClass) object).getStateMachine());
					}
				}
				return false;
			}

			private boolean hasUnnamedTransitions(StateGraph sg) {
				if (sg==null)
					return false;
				
				for (Transition tr : sg.getTransitions()) {
					if (tr.getName()==null || tr.getName().isEmpty())
						return true;
				}
				
				for (State s : sg.getStates()) {
					if (hasUnnamedTransitions(s.getSubgraph()))
						return true;
				}
				
				return false;
			}
		});
	}

	protected void openEditor(EObject object) {
		if (object instanceof ActorClass) {
			DiagramAccess diagramAccess = new DiagramAccess();
			diagramAccess.openDiagramEditor((ActorClass) object);
		}
	}

}
