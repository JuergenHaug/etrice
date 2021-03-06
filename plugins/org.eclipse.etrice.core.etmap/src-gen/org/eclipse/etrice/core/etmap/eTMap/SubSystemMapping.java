/**
 */
package org.eclipse.etrice.core.etmap.eTMap;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;

import org.eclipse.etrice.core.room.SubSystemRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub System Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>This is the mapping of a sub system (defined in a ROOM model) to a
 * node (defined in a physical model).
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping#getLogicalSubSys <em>Logical Sub Sys</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping#getNode <em>Node</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping#getThreadMappings <em>Thread Mappings</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.etmap.eTMap.ETMapPackage#getSubSystemMapping()
 * @model
 * @generated
 */
public interface SubSystemMapping extends EObject
{
  /**
   * Returns the value of the '<em><b>Logical Sub Sys</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the logical sub system being mapped.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Logical Sub Sys</em>' reference.
   * @see #setLogicalSubSys(SubSystemRef)
   * @see org.eclipse.etrice.core.etmap.eTMap.ETMapPackage#getSubSystemMapping_LogicalSubSys()
   * @model
   * @generated
   */
  SubSystemRef getLogicalSubSys();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping#getLogicalSubSys <em>Logical Sub Sys</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Logical Sub Sys</em>' reference.
   * @see #getLogicalSubSys()
   * @generated
   */
  void setLogicalSubSys(SubSystemRef value);

  /**
   * Returns the value of the '<em><b>Node</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the node being mapped to.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Node</em>' reference.
   * @see #setNode(NodeRef)
   * @see org.eclipse.etrice.core.etmap.eTMap.ETMapPackage#getSubSystemMapping_Node()
   * @model
   * @generated
   */
  NodeRef getNode();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping#getNode <em>Node</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node</em>' reference.
   * @see #getNode()
   * @generated
   */
  void setNode(NodeRef value);

  /**
   * Returns the value of the '<em><b>Thread Mappings</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.etmap.eTMap.ThreadMapping}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of nested mappings of logical to physical threads.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Thread Mappings</em>' containment reference list.
   * @see org.eclipse.etrice.core.etmap.eTMap.ETMapPackage#getSubSystemMapping_ThreadMappings()
   * @model containment="true"
   * @generated
   */
  EList<ThreadMapping> getThreadMappings();

} // SubSystemMapping
