/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.etrice.core.room;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.room.RoomModel#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.RoomModel#getDocu <em>Docu</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.RoomModel#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.RoomModel#getPrimitiveTypes <em>Primitive Types</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.RoomModel#getExternalTypes <em>External Types</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.RoomModel#getDataClasses <em>Data Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.RoomModel#getProtocolClasses <em>Protocol Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.RoomModel#getActorClasses <em>Actor Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.RoomModel#getSubSystemClasses <em>Sub System Classes</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.room.RoomModel#getSystems <em>Systems</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.room.RoomPackage#getRoomModel()
 * @model
 * @generated
 */
public interface RoomModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.etrice.core.room.RoomPackage#getRoomModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.RoomModel#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Docu</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Docu</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Docu</em>' containment reference.
   * @see #setDocu(Documentation)
   * @see org.eclipse.etrice.core.room.RoomPackage#getRoomModel_Docu()
   * @model containment="true"
   * @generated
   */
  Documentation getDocu();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.room.RoomModel#getDocu <em>Docu</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Docu</em>' containment reference.
   * @see #getDocu()
   * @generated
   */
  void setDocu(Documentation value);

  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.Import}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getRoomModel_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

  /**
   * Returns the value of the '<em><b>Primitive Types</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.PrimitiveType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Primitive Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Primitive Types</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getRoomModel_PrimitiveTypes()
   * @model containment="true"
   * @generated
   */
  EList<PrimitiveType> getPrimitiveTypes();

  /**
   * Returns the value of the '<em><b>External Types</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.ExternalType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>External Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>External Types</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getRoomModel_ExternalTypes()
   * @model containment="true"
   * @generated
   */
  EList<ExternalType> getExternalTypes();

  /**
   * Returns the value of the '<em><b>Data Classes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.DataClass}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Classes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Classes</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getRoomModel_DataClasses()
   * @model containment="true"
   * @generated
   */
  EList<DataClass> getDataClasses();

  /**
   * Returns the value of the '<em><b>Protocol Classes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.ProtocolClass}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Protocol Classes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Protocol Classes</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getRoomModel_ProtocolClasses()
   * @model containment="true"
   * @generated
   */
  EList<ProtocolClass> getProtocolClasses();

  /**
   * Returns the value of the '<em><b>Actor Classes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.ActorClass}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actor Classes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actor Classes</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getRoomModel_ActorClasses()
   * @model containment="true"
   * @generated
   */
  EList<ActorClass> getActorClasses();

  /**
   * Returns the value of the '<em><b>Sub System Classes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.SubSystemClass}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub System Classes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub System Classes</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getRoomModel_SubSystemClasses()
   * @model containment="true"
   * @generated
   */
  EList<SubSystemClass> getSubSystemClasses();

  /**
   * Returns the value of the '<em><b>Systems</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.room.LogicalSystem}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Systems</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Systems</em>' containment reference list.
   * @see org.eclipse.etrice.core.room.RoomPackage#getRoomModel_Systems()
   * @model containment="true"
   * @generated
   */
  EList<LogicalSystem> getSystems();

} // RoomModel
