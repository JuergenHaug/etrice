/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ref SA Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Links from a {@link ActorContainerRef}, i.e. from a sub actor.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.RefSAPoint#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getRefSAPoint()
 * @model
 * @generated
 */
public interface RefSAPoint extends SAPoint
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * This is the referenced actor container ref.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(ActorContainerRef)
   * @see org.eclipse.etrice.core.room.RoomPackage#getRefSAPoint_Ref()
   * @model
   * @generated
   */
  ActorContainerRef getRef();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.RefSAPoint#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(ActorContainerRef value);

} // RefSAPoint
