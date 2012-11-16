/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ref Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.RefPath#getRefs <em>Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getRefPath()
 * @model
 * @generated
 */
public interface RefPath extends EObject
{
  /**
   * Returns the value of the '<em><b>Refs</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Refs</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Refs</em>' attribute list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getRefPath_Refs()
   * @model unique="false"
   * @generated
   */
  EList<String> getRefs();

} // RefPath
