/**
 */
package org.eclipse.etrice.core.config.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.etrice.core.config.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.config.ConfigPackage
 * @generated
 */
public class ConfigSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ConfigPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConfigSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ConfigPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case ConfigPackage.CONFIG_MODEL:
      {
        ConfigModel configModel = (ConfigModel)theEObject;
        T result = caseConfigModel(configModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ConfigPackage.CONFIG_ELEMENT:
      {
        ConfigElement configElement = (ConfigElement)theEObject;
        T result = caseConfigElement(configElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ConfigPackage.SUB_SYSTEM_CONFIG:
      {
        SubSystemConfig subSystemConfig = (SubSystemConfig)theEObject;
        T result = caseSubSystemConfig(subSystemConfig);
        if (result == null) result = caseConfigElement(subSystemConfig);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ConfigPackage.DYNAMIC_CONFIG:
      {
        DynamicConfig dynamicConfig = (DynamicConfig)theEObject;
        T result = caseDynamicConfig(dynamicConfig);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ConfigPackage.ACTOR_CLASS_CONFIG:
      {
        ActorClassConfig actorClassConfig = (ActorClassConfig)theEObject;
        T result = caseActorClassConfig(actorClassConfig);
        if (result == null) result = caseConfigElement(actorClassConfig);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ConfigPackage.ACTOR_INSTANCE_CONFIG:
      {
        ActorInstanceConfig actorInstanceConfig = (ActorInstanceConfig)theEObject;
        T result = caseActorInstanceConfig(actorInstanceConfig);
        if (result == null) result = caseConfigElement(actorInstanceConfig);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ConfigPackage.PROTOCOL_CLASS_CONFIG:
      {
        ProtocolClassConfig protocolClassConfig = (ProtocolClassConfig)theEObject;
        T result = caseProtocolClassConfig(protocolClassConfig);
        if (result == null) result = caseConfigElement(protocolClassConfig);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ConfigPackage.PORT_CLASS_CONFIG:
      {
        PortClassConfig portClassConfig = (PortClassConfig)theEObject;
        T result = casePortClassConfig(portClassConfig);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ConfigPackage.PORT_INSTANCE_CONFIG:
      {
        PortInstanceConfig portInstanceConfig = (PortInstanceConfig)theEObject;
        T result = casePortInstanceConfig(portInstanceConfig);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ConfigPackage.ATTR_CONFIG:
      {
        AttrConfig attrConfig = (AttrConfig)theEObject;
        T result = caseAttrConfig(attrConfig);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ConfigPackage.ATTR_CLASS_CONFIG:
      {
        AttrClassConfig attrClassConfig = (AttrClassConfig)theEObject;
        T result = caseAttrClassConfig(attrClassConfig);
        if (result == null) result = caseAttrConfig(attrClassConfig);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ConfigPackage.ATTR_INSTANCE_CONFIG:
      {
        AttrInstanceConfig attrInstanceConfig = (AttrInstanceConfig)theEObject;
        T result = caseAttrInstanceConfig(attrInstanceConfig);
        if (result == null) result = caseAttrConfig(attrInstanceConfig);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ConfigPackage.CONFIG_VALUE_ARRAY:
      {
        ConfigValueArray configValueArray = (ConfigValueArray)theEObject;
        T result = caseConfigValueArray(configValueArray);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ConfigPackage.CONFIG_VALUE:
      {
        ConfigValue configValue = (ConfigValue)theEObject;
        T result = caseConfigValue(configValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ConfigPackage.LITERAL_CONFIG_VALUE:
      {
        LiteralConfigValue literalConfigValue = (LiteralConfigValue)theEObject;
        T result = caseLiteralConfigValue(literalConfigValue);
        if (result == null) result = caseConfigValue(literalConfigValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ConfigPackage.ENUM_CONFIG_VALUE:
      {
        EnumConfigValue enumConfigValue = (EnumConfigValue)theEObject;
        T result = caseEnumConfigValue(enumConfigValue);
        if (result == null) result = caseConfigValue(enumConfigValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ConfigPackage.REF_PATH:
      {
        RefPath refPath = (RefPath)theEObject;
        T result = caseRefPath(refPath);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ConfigPackage.REF_SEGMENT:
      {
        RefSegment refSegment = (RefSegment)theEObject;
        T result = caseRefSegment(refSegment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConfigModel(ConfigModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConfigElement(ConfigElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sub System Config</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sub System Config</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubSystemConfig(SubSystemConfig object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Dynamic Config</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Dynamic Config</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDynamicConfig(DynamicConfig object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Actor Class Config</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Actor Class Config</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActorClassConfig(ActorClassConfig object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Actor Instance Config</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Actor Instance Config</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActorInstanceConfig(ActorInstanceConfig object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Protocol Class Config</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Protocol Class Config</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProtocolClassConfig(ProtocolClassConfig object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port Class Config</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port Class Config</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePortClassConfig(PortClassConfig object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port Instance Config</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port Instance Config</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePortInstanceConfig(PortInstanceConfig object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attr Config</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attr Config</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttrConfig(AttrConfig object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attr Class Config</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attr Class Config</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttrClassConfig(AttrClassConfig object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attr Instance Config</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attr Instance Config</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttrInstanceConfig(AttrInstanceConfig object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value Array</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Array</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConfigValueArray(ConfigValueArray object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConfigValue(ConfigValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Literal Config Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Literal Config Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLiteralConfigValue(LiteralConfigValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Config Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Config Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumConfigValue(EnumConfigValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ref Path</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ref Path</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRefPath(RefPath object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ref Segment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ref Segment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRefSegment(RefSegment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //ConfigSwitch
