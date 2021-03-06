/**
 */
package org.eclipse.etrice.core.room.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.etrice.core.room.ActorInstanceMapping;
import org.eclipse.etrice.core.room.LogicalThread;
import org.eclipse.etrice.core.room.RefPath;
import org.eclipse.etrice.core.room.RoomPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor Instance Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorInstanceMappingImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorInstanceMappingImpl#getThread <em>Thread</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.impl.ActorInstanceMappingImpl#getActorInstanceMappings <em>Actor Instance Mappings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActorInstanceMappingImpl extends MinimalEObjectImpl.Container implements ActorInstanceMapping
{
  /**
   * The cached value of the '{@link #getPath() <em>Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPath()
   * @generated
   * @ordered
   */
  protected RefPath path;

  /**
   * The cached value of the '{@link #getThread() <em>Thread</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThread()
   * @generated
   * @ordered
   */
  protected LogicalThread thread;

  /**
   * The cached value of the '{@link #getActorInstanceMappings() <em>Actor Instance Mappings</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActorInstanceMappings()
   * @generated
   * @ordered
   */
  protected EList<ActorInstanceMapping> actorInstanceMappings;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ActorInstanceMappingImpl()
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
    return RoomPackage.Literals.ACTOR_INSTANCE_MAPPING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefPath getPath()
  {
    return path;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPath(RefPath newPath, NotificationChain msgs)
  {
    RefPath oldPath = path;
    path = newPath;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_INSTANCE_MAPPING__PATH, oldPath, newPath);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPath(RefPath newPath)
  {
    if (newPath != path)
    {
      NotificationChain msgs = null;
      if (path != null)
        msgs = ((InternalEObject)path).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RoomPackage.ACTOR_INSTANCE_MAPPING__PATH, null, msgs);
      if (newPath != null)
        msgs = ((InternalEObject)newPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RoomPackage.ACTOR_INSTANCE_MAPPING__PATH, null, msgs);
      msgs = basicSetPath(newPath, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_INSTANCE_MAPPING__PATH, newPath, newPath));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalThread getThread()
  {
    if (thread != null && thread.eIsProxy())
    {
      InternalEObject oldThread = (InternalEObject)thread;
      thread = (LogicalThread)eResolveProxy(oldThread);
      if (thread != oldThread)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoomPackage.ACTOR_INSTANCE_MAPPING__THREAD, oldThread, thread));
      }
    }
    return thread;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalThread basicGetThread()
  {
    return thread;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setThread(LogicalThread newThread)
  {
    LogicalThread oldThread = thread;
    thread = newThread;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RoomPackage.ACTOR_INSTANCE_MAPPING__THREAD, oldThread, thread));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ActorInstanceMapping> getActorInstanceMappings()
  {
    if (actorInstanceMappings == null)
    {
      actorInstanceMappings = new EObjectContainmentEList<ActorInstanceMapping>(ActorInstanceMapping.class, this, RoomPackage.ACTOR_INSTANCE_MAPPING__ACTOR_INSTANCE_MAPPINGS);
    }
    return actorInstanceMappings;
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
      case RoomPackage.ACTOR_INSTANCE_MAPPING__PATH:
        return basicSetPath(null, msgs);
      case RoomPackage.ACTOR_INSTANCE_MAPPING__ACTOR_INSTANCE_MAPPINGS:
        return ((InternalEList<?>)getActorInstanceMappings()).basicRemove(otherEnd, msgs);
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
      case RoomPackage.ACTOR_INSTANCE_MAPPING__PATH:
        return getPath();
      case RoomPackage.ACTOR_INSTANCE_MAPPING__THREAD:
        if (resolve) return getThread();
        return basicGetThread();
      case RoomPackage.ACTOR_INSTANCE_MAPPING__ACTOR_INSTANCE_MAPPINGS:
        return getActorInstanceMappings();
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
      case RoomPackage.ACTOR_INSTANCE_MAPPING__PATH:
        setPath((RefPath)newValue);
        return;
      case RoomPackage.ACTOR_INSTANCE_MAPPING__THREAD:
        setThread((LogicalThread)newValue);
        return;
      case RoomPackage.ACTOR_INSTANCE_MAPPING__ACTOR_INSTANCE_MAPPINGS:
        getActorInstanceMappings().clear();
        getActorInstanceMappings().addAll((Collection<? extends ActorInstanceMapping>)newValue);
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
      case RoomPackage.ACTOR_INSTANCE_MAPPING__PATH:
        setPath((RefPath)null);
        return;
      case RoomPackage.ACTOR_INSTANCE_MAPPING__THREAD:
        setThread((LogicalThread)null);
        return;
      case RoomPackage.ACTOR_INSTANCE_MAPPING__ACTOR_INSTANCE_MAPPINGS:
        getActorInstanceMappings().clear();
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
      case RoomPackage.ACTOR_INSTANCE_MAPPING__PATH:
        return path != null;
      case RoomPackage.ACTOR_INSTANCE_MAPPING__THREAD:
        return thread != null;
      case RoomPackage.ACTOR_INSTANCE_MAPPING__ACTOR_INSTANCE_MAPPINGS:
        return actorInstanceMappings != null && !actorInstanceMappings.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ActorInstanceMappingImpl
