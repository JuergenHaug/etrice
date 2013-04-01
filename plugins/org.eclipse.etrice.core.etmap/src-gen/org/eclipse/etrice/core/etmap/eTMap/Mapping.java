/**
 */
package org.eclipse.etrice.core.etmap.eTMap;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem;

import org.eclipse.etrice.core.room.LogicalSystem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>This is the mapping of a logical system (defined in a ROOM model) to a
 * physical system (defined in a physical model).
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.Mapping#getLogicalSys <em>Logical Sys</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.Mapping#getPhysicalSys <em>Physical Sys</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.etmap.eTMap.Mapping#getSubsysMappings <em>Subsys Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.etrice.core.etmap.eTMap.ETMapPackage#getMapping()
 * @model
 * @generated
 */
public interface Mapping extends EObject
{
  /**
   * Returns the value of the '<em><b>Logical Sys</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the logical system being mapped.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Logical Sys</em>' reference.
   * @see #setLogicalSys(LogicalSystem)
   * @see org.eclipse.etrice.core.etmap.eTMap.ETMapPackage#getMapping_LogicalSys()
   * @model
   * @generated
   */
  LogicalSystem getLogicalSys();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etmap.eTMap.Mapping#getLogicalSys <em>Logical Sys</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Logical Sys</em>' reference.
   * @see #getLogicalSys()
   * @generated
   */
  void setLogicalSys(LogicalSystem value);

  /**
   * Returns the value of the '<em><b>Physical Sys</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the physical system being mapped to.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Physical Sys</em>' reference.
   * @see #setPhysicalSys(PhysicalSystem)
   * @see org.eclipse.etrice.core.etmap.eTMap.ETMapPackage#getMapping_PhysicalSys()
   * @model
   * @generated
   */
  PhysicalSystem getPhysicalSys();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.etmap.eTMap.Mapping#getPhysicalSys <em>Physical Sys</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Physical Sys</em>' reference.
   * @see #getPhysicalSys()
   * @generated
   */
  void setPhysicalSys(PhysicalSystem value);

  /**
   * Returns the value of the '<em><b>Subsys Mappings</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of nested mappings of the sub systems of this system.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Subsys Mappings</em>' containment reference list.
   * @see org.eclipse.etrice.core.etmap.eTMap.ETMapPackage#getMapping_SubsysMappings()
   * @model containment="true"
   * @generated
   */
  EList<SubSystemMapping> getSubsysMappings();

} // Mapping
