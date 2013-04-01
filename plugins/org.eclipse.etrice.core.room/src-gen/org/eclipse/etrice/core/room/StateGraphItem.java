/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Graph Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>The super class of
 * <ul>
 *   <li>{@link StateStateGraphNode}</li>
 *   <li>{@link Transition}</li>
 * </ul>
 * 
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getStateGraphItem()
 * @model
 * @generated
 */
public interface StateGraphItem extends EObject
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof org.eclipse.etrice.core.room.State) \r\n\treturn ((org.eclipse.etrice.core.room.State)this).getName();\r\nelse if (this instanceof org.eclipse.etrice.core.room.TrPoint)\r\n\treturn ((org.eclipse.etrice.core.room.TrPoint)this).getName();\r\nelse if (this instanceof org.eclipse.etrice.core.room.ChoicePoint)\r\n\treturn ((org.eclipse.etrice.core.room.ChoicePoint)this).getName();\r\nelse if (this instanceof org.eclipse.etrice.core.room.Transition)\r\n\treturn ((org.eclipse.etrice.core.room.Transition)this).getName();\r\nreturn \"\";\r\n'"
   * @generated
   */
  String getName();

} // StateGraphItem
