/**
 */
package org.eclipse.etrice.generator.fsmtest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Postcondition Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.fsmtest.PostconditionDeclaration#getSignal <em>Signal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getPostconditionDeclaration()
 * @model
 * @generated
 */
public interface PostconditionDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Signal</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Signal</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Signal</em>' containment reference.
   * @see #setSignal(SignalDeclaration)
   * @see org.eclipse.etrice.generator.fsmtest.FsmtestPackage#getPostconditionDeclaration_Signal()
   * @model containment="true"
   * @generated
   */
  SignalDeclaration getSignal();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.generator.fsmtest.PostconditionDeclaration#getSignal <em>Signal</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Signal</em>' containment reference.
   * @see #getSignal()
   * @generated
   */
  void setSignal(SignalDeclaration value);

} // PostconditionDeclaration
