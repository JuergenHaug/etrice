/**
 */
package org.eclipse.etrice.core.fsm.fSM.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.impl.StateGraphImpl#getStates <em>States</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.impl.StateGraphImpl#getTrPoints <em>Tr Points</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.impl.StateGraphImpl#getChPoints <em>Ch Points</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.impl.StateGraphImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.fsm.fSM.impl.StateGraphImpl#getRefinedTransitions <em>Refined Transitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StateGraphImpl extends MinimalEObjectImpl.Container implements StateGraph
{
  /**
   * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStates()
   * @generated
   * @ordered
   */
  protected EList<State> states;

  /**
   * The cached value of the '{@link #getTrPoints() <em>Tr Points</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrPoints()
   * @generated
   * @ordered
   */
  protected EList<TrPoint> trPoints;

  /**
   * The cached value of the '{@link #getChPoints() <em>Ch Points</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChPoints()
   * @generated
   * @ordered
   */
  protected EList<ChoicePoint> chPoints;

  /**
   * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransitions()
   * @generated
   * @ordered
   */
  protected EList<Transition> transitions;

  /**
   * The cached value of the '{@link #getRefinedTransitions() <em>Refined Transitions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefinedTransitions()
   * @generated
   * @ordered
   */
  protected EList<RefinedTransition> refinedTransitions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StateGraphImpl()
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
    return FSMPackage.Literals.STATE_GRAPH;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<State> getStates()
  {
    if (states == null)
    {
      states = new EObjectContainmentEList<State>(State.class, this, FSMPackage.STATE_GRAPH__STATES);
    }
    return states;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TrPoint> getTrPoints()
  {
    if (trPoints == null)
    {
      trPoints = new EObjectContainmentEList<TrPoint>(TrPoint.class, this, FSMPackage.STATE_GRAPH__TR_POINTS);
    }
    return trPoints;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ChoicePoint> getChPoints()
  {
    if (chPoints == null)
    {
      chPoints = new EObjectContainmentEList<ChoicePoint>(ChoicePoint.class, this, FSMPackage.STATE_GRAPH__CH_POINTS);
    }
    return chPoints;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Transition> getTransitions()
  {
    if (transitions == null)
    {
      transitions = new EObjectContainmentEList<Transition>(Transition.class, this, FSMPackage.STATE_GRAPH__TRANSITIONS);
    }
    return transitions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RefinedTransition> getRefinedTransitions()
  {
    if (refinedTransitions == null)
    {
      refinedTransitions = new EObjectContainmentEList<RefinedTransition>(RefinedTransition.class, this, FSMPackage.STATE_GRAPH__REFINED_TRANSITIONS);
    }
    return refinedTransitions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case FSMPackage.STATE_GRAPH__STATES:
        return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
      case FSMPackage.STATE_GRAPH__TR_POINTS:
        return ((InternalEList<?>)getTrPoints()).basicRemove(otherEnd, msgs);
      case FSMPackage.STATE_GRAPH__CH_POINTS:
        return ((InternalEList<?>)getChPoints()).basicRemove(otherEnd, msgs);
      case FSMPackage.STATE_GRAPH__TRANSITIONS:
        return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
      case FSMPackage.STATE_GRAPH__REFINED_TRANSITIONS:
        return ((InternalEList<?>)getRefinedTransitions()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case FSMPackage.STATE_GRAPH__STATES:
        return getStates();
      case FSMPackage.STATE_GRAPH__TR_POINTS:
        return getTrPoints();
      case FSMPackage.STATE_GRAPH__CH_POINTS:
        return getChPoints();
      case FSMPackage.STATE_GRAPH__TRANSITIONS:
        return getTransitions();
      case FSMPackage.STATE_GRAPH__REFINED_TRANSITIONS:
        return getRefinedTransitions();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case FSMPackage.STATE_GRAPH__STATES:
        getStates().clear();
        getStates().addAll((Collection<? extends State>)newValue);
        return;
      case FSMPackage.STATE_GRAPH__TR_POINTS:
        getTrPoints().clear();
        getTrPoints().addAll((Collection<? extends TrPoint>)newValue);
        return;
      case FSMPackage.STATE_GRAPH__CH_POINTS:
        getChPoints().clear();
        getChPoints().addAll((Collection<? extends ChoicePoint>)newValue);
        return;
      case FSMPackage.STATE_GRAPH__TRANSITIONS:
        getTransitions().clear();
        getTransitions().addAll((Collection<? extends Transition>)newValue);
        return;
      case FSMPackage.STATE_GRAPH__REFINED_TRANSITIONS:
        getRefinedTransitions().clear();
        getRefinedTransitions().addAll((Collection<? extends RefinedTransition>)newValue);
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
      case FSMPackage.STATE_GRAPH__STATES:
        getStates().clear();
        return;
      case FSMPackage.STATE_GRAPH__TR_POINTS:
        getTrPoints().clear();
        return;
      case FSMPackage.STATE_GRAPH__CH_POINTS:
        getChPoints().clear();
        return;
      case FSMPackage.STATE_GRAPH__TRANSITIONS:
        getTransitions().clear();
        return;
      case FSMPackage.STATE_GRAPH__REFINED_TRANSITIONS:
        getRefinedTransitions().clear();
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
      case FSMPackage.STATE_GRAPH__STATES:
        return states != null && !states.isEmpty();
      case FSMPackage.STATE_GRAPH__TR_POINTS:
        return trPoints != null && !trPoints.isEmpty();
      case FSMPackage.STATE_GRAPH__CH_POINTS:
        return chPoints != null && !chPoints.isEmpty();
      case FSMPackage.STATE_GRAPH__TRANSITIONS:
        return transitions != null && !transitions.isEmpty();
      case FSMPackage.STATE_GRAPH__REFINED_TRANSITIONS:
        return refinedTransitions != null && !refinedTransitions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //StateGraphImpl
