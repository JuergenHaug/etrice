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

package org.eclipse.etrice.ui.common.base.support;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.etrice.core.common.ui.linking.GlobalNonPlatformURIEditorOpener;
import org.eclipse.etrice.core.fsm.ui.FSMUiModule;
import org.eclipse.etrice.ui.common.base.UIBaseActivator;
import org.eclipse.etrice.ui.common.base.editor.DiagramEditorBase;
import org.eclipse.etrice.ui.common.base.preferences.UIBasePreferenceConstants;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class DiagramAccessBase {

	public static final String DIAGRAMS_FOLDER_NAME = "diagrams";
	
	@Inject
	private IResourceSetProvider resourceSetProvider;
	
	/**
	 * 
	 */
	public DiagramAccessBase() {
		super();
		
		Injector injector = FSMUiModule.getInjector();
        injector.injectMembers(this);
	}

	public Diagram getDiagram(EObject rootObject) {
		Resource resource = rootObject.eResource();
		if (resource==null)
			return null;
		
		URI uri = resource.getURI();
		
		ResourceSet rs = newResourceSet(uri);
		
		URI diagURI = null;
		boolean exists = false;
		if (uri.isPlatformResource()) {
			uri = uri.trimSegments(1);
			IFolder diagramFolder = null;
			if (uri.segmentCount()==2) {
				IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(uri.lastSegment());
				diagramFolder = project.getFolder(DIAGRAMS_FOLDER_NAME);
			}
			else {
				IFolder parentFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(uri.toPlatformString(true)));
				diagramFolder = parentFolder.getFolder(DIAGRAMS_FOLDER_NAME);
			}
			
			IFile diagramFile = diagramFolder.getFile(getDigramFileName(rootObject));
			diagURI = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
			exists = diagramFile.exists();
		}
		else {
			File diagramFile = new File(uri.toFileString());
			diagramFile = new File(diagramFile.getParent()
					+File.separator+DIAGRAMS_FOLDER_NAME
					+File.separator+getDigramFileName(rootObject));
			diagURI = URI.createFileURI(diagramFile.getPath());
			exists = diagramFile.exists();
		}
		
		if (exists) {
			Resource diagRes = rs.getResource(diagURI, true);
			if (diagRes.getContents().isEmpty())
				return null;
			if (diagRes.getContents().get(0) instanceof Diagram) {
				Diagram diagram = (Diagram) diagRes.getContents().get(0);
				updateDiagram(diagram, false);
				return diagram;
			}
		}
		else {
			Resource diagRes = rs.createResource(diagURI);
			
			IPreferenceStore store = UIBaseActivator.getDefault().getPreferenceStore();
			boolean snap = store.getBoolean(UIBasePreferenceConstants.SNAP_TO_GRID);
			boolean useGrid = store.getBoolean(UIBasePreferenceConstants.USE_GRID);
			int horUnit = useGrid? store.getInt(UIBasePreferenceConstants.HOR_GRID_UNIT) : 0;
			int verUnit = useGrid? store.getInt(UIBasePreferenceConstants.VER_GRID_UNIT) : 0;
			
			Diagram diagram = Graphiti.getPeCreateService().createDiagram(
					getDiagramTypeId(),
					getDiagramName(rootObject),
					horUnit,
					verUnit,
					snap);
			diagRes.getContents().add(diagram);
			
			populateDiagram(rootObject, diagram);
			
			try {
				diagRes.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return diagram;
		}
		
		return null;
	}

	private ResourceSet newResourceSet(URI uri) {
		ResourceSet rs;
		if (uri.isPlatformResource()) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
			IProject project = file.getProject();
			rs = resourceSetProvider.get(project);
		}
		else {
			rs = new XtextResourceSet();
		}
		return rs;
	}
	
	private void populateDiagram(EObject rootObject, Diagram diagram) {
		ResourceSet rs = newResourceSet(rootObject.eResource().getURI());
		
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(rs);
		if (editingDomain == null) {
			// Not yet existing, create one
			editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);
		}
	
		// IMPORTANT STEP: this resolves the object and creates a new resource in the resource set
		URI boUri = EcoreUtil.getURI(rootObject);
		rootObject = editingDomain.getResourceSet().getEObject(boUri, true);
		
		editingDomain.getCommandStack().execute(getInitialCommand(rootObject, diagram, editingDomain));
		editingDomain.dispose();
	}

	/**
	 * @param diagram
	 */
	private void updateDiagram(Diagram diagram, boolean doSave) {
		ResourceSet rs = diagram.eResource().getResourceSet();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(rs);
		try {
			if (editingDomain == null) {
				// Not yet existing, create one and start a write transaction
				editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);
				((TransactionalEditingDomainImpl)editingDomain).startTransaction(false, null);
			}
			
			Command updateCommand = getUpdateCommand(diagram, editingDomain);
			if (updateCommand!=null) {
				editingDomain.getCommandStack().execute(updateCommand);
				
				if (doSave) {
					try {
						diagram.eResource().save(Collections.EMPTY_MAP);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		catch (InterruptedException e) {
		}
		
		editingDomain.dispose();
	}

	public DiagramEditorBase findDiagramEditor(EObject rootObject) {
		IFileEditorInput input = getEditorInput(rootObject);
	
		return (DiagramEditorBase) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findEditor(input);
	}

	public DiagramEditorBase openDiagramEditor(EObject rootObject) {
		IFileEditorInput input = getEditorInput(rootObject);
	
		try {
			return (DiagramEditorBase) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, getEditorId());
		} catch (PartInitException e) {
			String error = "Error while opening diagram editor";
			System.err.println(error);
		}
		return null;
	}

	private IFileEditorInput getEditorInput(EObject rootObject) {
		Diagram diagram = getDiagram(rootObject);
		
		URI uri = diagram.eResource().getURI();
		String platformString = null;
		if (uri.isPlatform()) {
			platformString = uri.toPlatformString(true);
		}
		else {
			uri = GlobalNonPlatformURIEditorOpener.getPlatformURI(uri);
			platformString = uri.toPlatformString(true);
		}
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformString));
		IFileEditorInput input = new FileEditorInput(file);
		return input;
	}

	public abstract String getDiagramName(EObject rootObject);
	abstract protected String getDigramFileName(EObject rootObject);
	abstract protected String getDiagramTypeId();
	abstract protected String getEditorId();
	abstract protected Command getInitialCommand(EObject rootObject, Diagram diagram, TransactionalEditingDomain editingDomain);
	abstract protected Command getUpdateCommand(Diagram diagram, TransactionalEditingDomain editingDomain);
}