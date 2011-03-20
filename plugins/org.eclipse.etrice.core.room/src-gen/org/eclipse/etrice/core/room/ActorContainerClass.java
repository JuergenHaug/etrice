/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor Container Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.ActorContainerClass#getUserCode1 <em>User Code1</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorContainerClass#getUserCode2 <em>User Code2</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorContainerClass#getIfSPPs <em>If SP Ps</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.ActorContainerClass#getActorRefs <em>Actor Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getActorContainerClass()
 * @model
 * @generated
 */
public interface ActorContainerClass extends StructureClass
{
  /**
   * Returns the value of the '<em><b>User Code1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>User Code1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>User Code1</em>' containment reference.
   * @see #setUserCode1(DetailCode)
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorContainerClass_UserCode1()
   * @model containment="true"
   * @generated
   */
  DetailCode getUserCode1();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ActorContainerClass#getUserCode1 <em>User Code1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>User Code1</em>' containment reference.
   * @see #getUserCode1()
   * @generated
   */
  void setUserCode1(DetailCode value);

  /**
   * Returns the value of the '<em><b>User Code2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>User Code2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>User Code2</em>' containment reference.
   * @see #setUserCode2(DetailCode)
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorContainerClass_UserCode2()
   * @model containment="true"
   * @generated
   */
  DetailCode getUserCode2();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ActorContainerClass#getUserCode2 <em>User Code2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>User Code2</em>' containment reference.
   * @see #getUserCode2()
   * @generated
   */
  void setUserCode2(DetailCode value);

  /**
   * Returns the value of the '<em><b>If SP Ps</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.SPPRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>If SP Ps</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>If SP Ps</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorContainerClass_IfSPPs()
   * @model containment="true"
   * @generated
   */
  EList<SPPRef> getIfSPPs();

  /**
   * Returns the value of the '<em><b>Actor Refs</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.ActorRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actor Refs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actor Refs</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getActorContainerClass_ActorRefs()
   * @model containment="true"
   * @generated
   */
  EList<ActorRef> getActorRefs();

} // ActorContainerClass
