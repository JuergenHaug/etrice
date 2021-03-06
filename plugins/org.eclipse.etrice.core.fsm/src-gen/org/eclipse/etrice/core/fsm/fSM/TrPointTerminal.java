/**
 */
package org.eclipse.etrice.core.fsm.fSM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tr Point Terminal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>The terminal point (source or target) of a transition ending
 * at a local {@link TrPoint}.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.TrPointTerminal#getTrPoint <em>Tr Point</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getTrPointTerminal()
 * @model
 * @generated
 */
public interface TrPointTerminal extends TransitionTerminal
{
  /**
   * Returns the value of the '<em><b>Tr Point</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the target transition, entry or exit point.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Tr Point</em>' reference.
   * @see #setTrPoint(TrPoint)
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getTrPointTerminal_TrPoint()
   * @model
   * @generated
   */
  TrPoint getTrPoint();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.fsm.fSM.TrPointTerminal#getTrPoint <em>Tr Point</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tr Point</em>' reference.
   * @see #getTrPoint()
   * @generated
   */
  void setTrPoint(TrPoint value);

} // TrPointTerminal
