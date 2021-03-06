/**
 */
package org.eclipse.etrice.core.room;

import org.eclipse.etrice.core.common.base.Documentation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>An attribute is a named member of a
 * <ul>
 *   <li>{@link DataClass}</li>
 *   <li>{@link ActorClass}</li>
 *   <li>{@link PortClass}</li>
 * </ul>
 * <p>
 * It can be of scalar or array type and is of a {@link RefableType}.
 * It is possible to assign a default value literal.
 * </p>
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.Attribute#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.Attribute#getSize <em>Size</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.Attribute#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.Attribute#getDefaultValueLiteral <em>Default Value Literal</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.Attribute#getDocu <em>Docu</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends RoomElement
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The name of the attribute by which it is referred to in the model.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.etrice.core.room.RoomPackage#getAttribute_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.Attribute#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>The default is scalar ({@code size=1}), values {@code >1} indicate an array.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Size</em>' attribute.
   * @see #setSize(int)
   * @see org.eclipse.etrice.core.room.RoomPackage#getAttribute_Size()
   * @model
   * @generated
   */
  int getSize();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.Attribute#getSize <em>Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Size</em>' attribute.
   * @see #getSize()
   * @generated
   */
  void setSize(int value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the attribute's type.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(RefableType)
   * @see org.eclipse.etrice.core.room.RoomPackage#getAttribute_Type()
   * @model containment="true"
   * @generated
   */
  RefableType getType();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.Attribute#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(RefableType value);

  /**
   * Returns the value of the '<em><b>Default Value Literal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is an optional default value literal.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Default Value Literal</em>' attribute.
   * @see #setDefaultValueLiteral(String)
   * @see org.eclipse.etrice.core.room.RoomPackage#getAttribute_DefaultValueLiteral()
   * @model
   * @generated
   */
  String getDefaultValueLiteral();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.Attribute#getDefaultValueLiteral <em>Default Value Literal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default Value Literal</em>' attribute.
   * @see #getDefaultValueLiteral()
   * @generated
   */
  void setDefaultValueLiteral(String value);

  /**
   * Returns the value of the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is an optional documentation.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Docu</em>' containment reference.
   * @see #setDocu(Documentation)
   * @see org.eclipse.etrice.core.room.RoomPackage#getAttribute_Docu()
   * @model containment="true"
   * @generated
   */
  Documentation getDocu();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.Attribute#getDocu <em>Docu</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Docu</em>' containment reference.
   * @see #getDocu()
   * @generated
   */
  void setDocu(Documentation value);

} // Attribute
