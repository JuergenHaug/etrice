/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.preferences;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.etrice.ui.common.Activator;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class ETricePreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	private BooleanFieldEditor snap;
	private StringFieldEditor hor;
	private StringFieldEditor ver;
	private Button useGridCheck;

	public ETricePreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("eTrice Preferences");
	}
	
	public void createFieldEditors() {
		addLabel("");
		addLabel("Diagram Editors");
		addField(
				new BooleanFieldEditor(
					PreferenceConstants.CONFIRM_DELETE,
					"&Confirm diagram element deletion",
					getFieldEditorParent()));
		
		BooleanFieldEditor useGrid = new BooleanFieldEditor(
			PreferenceConstants.USE_GRID,
			"Use &Grid (grid settings apply to new diagrams only)",
			getFieldEditorParent());
		addField(useGrid);
		
		snap = new BooleanFieldEditor(
			PreferenceConstants.SNAP_TO_GRID,
			"&Snap to Grid",
			getFieldEditorParent());
		addField(snap);
		
		hor = new StringFieldEditor(PreferenceConstants.HOR_GRID_UNIT, "&Horizontal Grid Unit [px]:", getFieldEditorParent());
		addField(hor);
		
		ver = new StringFieldEditor(PreferenceConstants.VER_GRID_UNIT, "&Vertical Grid Unit [px]:", getFieldEditorParent());
		addField(ver);

		useGridCheck = (Button) useGrid.getDescriptionControl(getFieldEditorParent());
		useGridCheck.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateGridFields();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				updateGridFields();
			}
		});
	}

	@Override
	protected void initialize() {
		super.initialize();
		updateGridFields();
	}
	
	private void updateGridFields() {
		boolean enabled = useGridCheck.getSelection();
		snap.setEnabled(enabled, getFieldEditorParent());
		hor.setEnabled(enabled, getFieldEditorParent());
		ver.setEnabled(enabled, getFieldEditorParent());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

	private void addLabel(String message) {
		Label label = new Label(getFieldEditorParent(), SWT.None);
		GridData data = new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false, 2, 1);
		label.setLayoutData(data);
		label.setForeground(ColorConstants.red);
		if (message != null)
			label.setText(message);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#performOk()
	 */
	@Override
	public boolean performOk() {
		boolean ok = super.performOk();
		
		if (ok) {
			// TODO: apply to open editors
//			IPreferenceStore store = Activator.getDefault().getPreferenceStore();
//			boolean snap = store.getBoolean(PreferenceConstants.SNAP_TO_GRID);
//			boolean useGrid = store.getBoolean(PreferenceConstants.USE_GRID);
//			int horUnit = useGrid? store.getInt(PreferenceConstants.HOR_GRID_UNIT) : 0;
//			int verUnit = useGrid? store.getInt(PreferenceConstants.VER_GRID_UNIT) : 0;
//
//			IWorkbench wb = PlatformUI.getWorkbench();
//			IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
//			IWorkbenchPage page = win.getActivePage();
//			IEditorReference[] editorReferences = page.getEditorReferences();
//			for (IEditorReference ref : editorReferences) {
//				IEditorPart editor = ref.getEditor(true);
//				if (editor instanceof RoomDiagramEditor) {
//					Diagram diagram = ((DiagramEditorInput)editor.getEditorInput()).getDiagram();
//					diagram.setSnapToGrid(snap);
//					diagram.setGridUnit(horUnit);
//					diagram.setVerticalGridUnit(verUnit);
//				}
//			}
		}
		
		return ok;
	}
}