/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.core.genmodel.etricegen;

import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.SimpleState;
import org.eclipse.etrice.core.room.RefinedState;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expanded Refined State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedRefinedState#getInheritedEntry <em>Inherited Entry</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedRefinedState#getInheritedExit <em>Inherited Exit</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedRefinedState#getInheritedDo <em>Inherited Do</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getExpandedRefinedState()
 * @model
 * @generated
 */
public interface ExpandedRefinedState extends SimpleState {
	/**
	 * Returns the value of the '<em><b>Inherited Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherited Entry</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited Entry</em>' containment reference.
	 * @see #setInheritedEntry(DetailCode)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getExpandedRefinedState_InheritedEntry()
	 * @model containment="true"
	 * @generated
	 */
	DetailCode getInheritedEntry();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedRefinedState#getInheritedEntry <em>Inherited Entry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inherited Entry</em>' containment reference.
	 * @see #getInheritedEntry()
	 * @generated
	 */
	void setInheritedEntry(DetailCode value);

	/**
	 * Returns the value of the '<em><b>Inherited Exit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherited Exit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited Exit</em>' containment reference.
	 * @see #setInheritedExit(DetailCode)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getExpandedRefinedState_InheritedExit()
	 * @model containment="true"
	 * @generated
	 */
	DetailCode getInheritedExit();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedRefinedState#getInheritedExit <em>Inherited Exit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inherited Exit</em>' containment reference.
	 * @see #getInheritedExit()
	 * @generated
	 */
	void setInheritedExit(DetailCode value);

	/**
	 * Returns the value of the '<em><b>Inherited Do</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherited Do</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited Do</em>' containment reference.
	 * @see #setInheritedDo(DetailCode)
	 * @see org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage#getExpandedRefinedState_InheritedDo()
	 * @model containment="true"
	 * @generated
	 */
	DetailCode getInheritedDo();

	/**
	 * Sets the value of the '{@link org.eclipse.etrice.core.genmodel.etricegen.ExpandedRefinedState#getInheritedDo <em>Inherited Do</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inherited Do</em>' containment reference.
	 * @see #getInheritedDo()
	 * @generated
	 */
	void setInheritedDo(DetailCode value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void init(RefinedState rs);

} // ExpandedRefinedState
