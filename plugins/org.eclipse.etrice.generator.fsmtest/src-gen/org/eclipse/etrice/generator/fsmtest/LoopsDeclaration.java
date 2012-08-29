/**
 */
package org.eclipse.etrice.generator.fsmtest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loops Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.LoopsDeclaration#getVal <em>Val</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getLoopsDeclaration()
 * @model
 * @generated
 */
public interface LoopsDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val</em>' attribute.
   * @see #setVal(int)
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getLoopsDeclaration_Val()
   * @model
   * @generated
   */
  int getVal();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.LoopsDeclaration#getVal <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val</em>' attribute.
   * @see #getVal()
   * @generated
   */
  void setVal(int value);

} // LoopsDeclaration
