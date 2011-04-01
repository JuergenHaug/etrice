/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.editor;


import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.ui.behavior.Activator;
import org.eclipse.etrice.ui.behavior.support.ContextSwitcher;
import org.eclipse.etrice.ui.common.editor.RoomDiagramEditor;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.swt.graphics.Image;


public class BehaviorEditor extends RoomDiagramEditor {

	public static final String BEHAVIOR_EDITOR_ID = "org.eclipse.etrice.ui.behavior.editor.BehaviorEditor";
	
	public BehaviorEditor() {
		super();
	}
	
	@Override
	public Image getDefaultImage() {
		return Activator.getImage("icons/Behavior.gif");
	}

	@SuppressWarnings("restriction")
	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		
		ResourceSet rs = getEditingDomain().getResourceSet();
		if (rs.getResources().size()>1)
			rs.getResources().get(1).setTrackingModification(true);
		
		Command cmd = new RecordingCommand(getEditingDomain()) {
			@Override
			protected void doExecute() {
				ContextSwitcher.switchTop(getDiagramTypeProvider().getDiagram());
			}
		};
		getEditingDomain().getCommandStack().execute(cmd);
		getEditingDomain().getCommandStack().flush();
	}

	/**
	 * @return the actor class of this editor
	 */
	public ActorClass getActorClass() {
		Diagram diagram = ((DiagramEditorInput)getEditorInput()).getDiagram();
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);
		if (bo instanceof ActorClass)
			return (ActorClass) bo;
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.ui.internal.editor.DiagramEditorInternal#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@SuppressWarnings("restriction")
	@Override
	public void doSave(IProgressMonitor monitor) {
		getEditingDomain().getCommandStack().execute(new RecordingCommand(getEditingDomain()) {
			protected void doExecute() {
				removeEmptySubgraphs();
			}
		});
		
		super.doSave(monitor);
	}

	@SuppressWarnings("restriction")
	protected void removeEmptySubgraphs() {
		Diagram diagram = getDiagramTypeProvider().getDiagram();

		// if our current context is an empty state graph we go one level up
		StateGraph current = ContextSwitcher.getCurrentStateGraph(diagram);
		if (current.eContainer() instanceof State) {
			State s = (State) current.eContainer();
			if (!RoomHelpers.hasSubStructure(s)) {
				ContextSwitcher.goUp(diagram, current);
			}
		}
		
		ArrayList<Shape> toBeRemoved = new ArrayList<Shape>();
		for (Shape ctxShape : diagram.getChildren()) {
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(ctxShape);
			assert(bo instanceof StateGraph): "expected state graph";
			
			StateGraph sg = (StateGraph) bo;
			if (sg.eContainer() instanceof State) {
				State s = (State) sg.eContainer();
				if (!RoomHelpers.hasSubStructure(s)) {
					EcoreUtil.delete(sg);
					toBeRemoved.add(ctxShape);
				}
			}
		}
		
		// need to recursively delete the shapes to avoid dangling HREFs
		for (Shape shape : toBeRemoved) {
			EcoreUtil.delete(shape, true);
		}
	}
}
