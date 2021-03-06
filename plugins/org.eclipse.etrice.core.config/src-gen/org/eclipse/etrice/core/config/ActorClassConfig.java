/**
 */
package org.eclipse.etrice.core.config;

import org.eclipse.emf.common.util.EList;

import org.eclipse.etrice.core.room.ActorClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor Class Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <br>This class models a configuration for an {@link org.eclipse.etrice.core.room.ActorClass actor class}.
 * The configuration defines the default values for all instances of the {@link #getActor actor}.
 * The values are applied at generation time.
 * The config sub elements are:
 * <ul>
 * 	<li>{@link AttrClassConfig attribute class config}</li>
 * </ul>				
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.etrice.core.config.ActorClassConfig#getActor <em>Actor</em>}</li>
 *   <li>{@link org.eclipse.etrice.core.config.ActorClassConfig#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.etrice.core.config.ConfigPackage#getActorClassConfig()
 * @model
 * @generated
 */
public interface ActorClassConfig extends ConfigElement
{
  /**
   * Returns the value of the '<em><b>Actor</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is the actor class.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Actor</em>' reference.
   * @see #setActor(ActorClass)
   * @see org.eclipse.etrice.core.config.ConfigPackage#getActorClassConfig_Actor()
   * @model
   * @generated
   */
  ActorClass getActor();

  /**
   * Sets the value of the '{@link org.eclipse.etrice.core.config.ActorClassConfig#getActor <em>Actor</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Actor</em>' reference.
   * @see #getActor()
   * @generated
   */
  void setActor(ActorClass value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.etrice.core.config.AttrClassConfig}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * <br>This is a list of all attribute configurations.
   * 
   * <!-- end-model-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see org.eclipse.etrice.core.config.ConfigPackage#getActorClassConfig_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<AttrClassConfig> getAttributes();

} // ActorClassConfig
