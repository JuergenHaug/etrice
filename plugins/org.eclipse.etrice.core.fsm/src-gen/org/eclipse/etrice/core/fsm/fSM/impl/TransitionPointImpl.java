/**
 */
package org.eclipse.etrice.core.fsm.fSM.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.impl.TransitionPointImpl#isHandler <em>Handler</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionPointImpl extends TrPointImpl implements TransitionPoint
{
  /**
   * The default value of the '{@link #isHandler() <em>Handler</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHandler()
   * @generated
   * @ordered
   */
  protected static final boolean HANDLER_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isHandler() <em>Handler</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isHandler()
   * @generated
   * @ordered
   */
  protected boolean handler = HANDLER_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransitionPointImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return FSMPackage.Literals.TRANSITION_POINT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isHandler()
  {
    return handler;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHandler(boolean newHandler)
  {
    boolean oldHandler = handler;
    handler = newHandler;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FSMPackage.TRANSITION_POINT__HANDLER, oldHandler, handler));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case FSMPackage.TRANSITION_POINT__HANDLER:
        return isHandler();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FSMPackage.TRANSITION_POINT__HANDLER:
        setHandler((Boolean)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case FSMPackage.TRANSITION_POINT__HANDLER:
        setHandler(HANDLER_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case FSMPackage.TRANSITION_POINT__HANDLER:
        return handler != HANDLER_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (handler: ");
    result.append(handler);
    result.append(')');
    return result.toString();
  }

} //TransitionPointImpl
