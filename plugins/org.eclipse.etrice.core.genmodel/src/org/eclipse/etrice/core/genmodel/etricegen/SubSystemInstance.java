/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.etricegen;

import org.eclipse.etrice.core.room.SubSystemClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub System Instance</b></em>' derived from
 * {@link StructureInstance}.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance#getSubSystemClass <em>Sub System Class</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance#getMaxObjId <em>Max Obj Id</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getSubSystemInstance()
 * @model
 * @generated
 */
public interface SubSystemInstance extends StructureInstance {
	/**
	 * Returns the value of the '<em><b>Sub System Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * This is the associated ROOM sub system class.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub System Class</em>' reference.
	 * @see #setSubSystemClass(SubSystemClass)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getSubSystemInstance_SubSystemClass()
	 * @model
	 * @generated
	 */
	SubSystemClass getSubSystemClass();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance#getSubSystemClass <em>Sub System Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub System Class</em>' reference.
	 * @see #getSubSystemClass()
	 * @generated
	 */
	void setSubSystemClass(SubSystemClass value);

	/**
	 * Returns the value of the '<em><b>Max Obj Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * The highest object ID used.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Obj Id</em>' attribute.
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getSubSystemInstance_MaxObjId()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getMaxObjId();

	/**
	 * <!-- begin-user-doc -->
	 * @param instance an instance object
	 * @return the thread ID of this instance
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int getThreadId(InstanceBase instance);

} // SubSystemInstance
