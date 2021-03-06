/**
 */
package org.eclipse.etrice.core.room;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>An external port is part of the actor structure and references an interface port.
 * An interface port which is referenced by an external port is an external end port.
 * If it is not referenced it is a relay port.
 * 
 * @see Port
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.ExternalPort#getInterfacePort <em>Interface Port</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getExternalPort()
 * @model
 * @generated
 */
public interface ExternalPort extends RoomElement
{
  /**
   * Returns the value of the '<em><b>Interface Port</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the referenced interface port of the actor class which is now an external end port.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Interface Port</em>' reference.
   * @see #setInterfacePort(Port)
   * @see org.eclipse.etrice.core.room.RoomPackage#getExternalPort_InterfacePort()
   * @model
   * @generated
   */
  Port getInterfacePort();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.ExternalPort#getInterfacePort <em>Interface Port</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Interface Port</em>' reference.
   * @see #getInterfacePort()
   * @generated
   */
  void setInterfacePort(Port value);

} // ExternalPort
