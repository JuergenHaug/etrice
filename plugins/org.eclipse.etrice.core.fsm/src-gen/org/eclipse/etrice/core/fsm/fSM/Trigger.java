/**
 */
package org.eclipse.etrice.core.fsm.fSM;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>A transition trigger is a list of {@link MessageFromIf} pairs
 * and an optional {@link Guard}.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.Trigger#getMsgFromIfPairs <em>Msg From If Pairs</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.Trigger#getGuard <em>Guard</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getTrigger()
 * @model
 * @generated
 */
public interface Trigger extends EObject
{
  /**
   * Returns the value of the '<em><b>Msg From If Pairs</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.fsm.fSM.MessageFromIf}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of message/interface item pairs.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Msg From If Pairs</em>' containment reference list.
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getTrigger_MsgFromIfPairs()
   * @model containment="true"
   * @generated
   */
  EList<MessageFromIf> getMsgFromIfPairs();

  /**
   * Returns the value of the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is an optional guard condition of the trigger specified in the code generator's target language.
   * It has to evaluate to a boolean value.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Guard</em>' containment reference.
   * @see #setGuard(Guard)
   * @see org.eclipse.etrice.core.fsm.fSM.FSMPackage#getTrigger_Guard()
   * @model containment="true"
   * @generated
   */
  Guard getGuard();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.fsm.fSM.Trigger#getGuard <em>Guard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Guard</em>' containment reference.
   * @see #getGuard()
   * @generated
   */
  void setGuard(Guard value);

} // Trigger
