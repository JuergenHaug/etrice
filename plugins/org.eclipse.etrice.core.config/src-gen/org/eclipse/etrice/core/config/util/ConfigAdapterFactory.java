/**
 */
package org.eclipse.etrice.core.config.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.etrice.core.config.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.etrice.core.config.ConfigPackage
 * @generated
 */
public class ConfigAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ConfigPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConfigAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ConfigPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConfigSwitch<Adapter> modelSwitch =
    new ConfigSwitch<Adapter>()
    {
      @Override
      public Adapter caseConfigModel(ConfigModel object)
      {
        return createConfigModelAdapter();
      }
      @Override
      public Adapter caseConfigElement(ConfigElement object)
      {
        return createConfigElementAdapter();
      }
      @Override
      public Adapter caseSubSystemConfig(SubSystemConfig object)
      {
        return createSubSystemConfigAdapter();
      }
      @Override
      public Adapter caseDynamicConfig(DynamicConfig object)
      {
        return createDynamicConfigAdapter();
      }
      @Override
      public Adapter caseActorClassConfig(ActorClassConfig object)
      {
        return createActorClassConfigAdapter();
      }
      @Override
      public Adapter caseActorInstanceConfig(ActorInstanceConfig object)
      {
        return createActorInstanceConfigAdapter();
      }
      @Override
      public Adapter caseProtocolClassConfig(ProtocolClassConfig object)
      {
        return createProtocolClassConfigAdapter();
      }
      @Override
      public Adapter casePortClassConfig(PortClassConfig object)
      {
        return createPortClassConfigAdapter();
      }
      @Override
      public Adapter casePortInstanceConfig(PortInstanceConfig object)
      {
        return createPortInstanceConfigAdapter();
      }
      @Override
      public Adapter caseAttrConfig(AttrConfig object)
      {
        return createAttrConfigAdapter();
      }
      @Override
      public Adapter caseAttrClassConfig(AttrClassConfig object)
      {
        return createAttrClassConfigAdapter();
      }
      @Override
      public Adapter caseAttrInstanceConfig(AttrInstanceConfig object)
      {
        return createAttrInstanceConfigAdapter();
      }
      @Override
      public Adapter caseConfigValueArray(ConfigValueArray object)
      {
        return createConfigValueArrayAdapter();
      }
      @Override
      public Adapter caseConfigValue(ConfigValue object)
      {
        return createConfigValueAdapter();
      }
      @Override
      public Adapter caseLiteralConfigValue(LiteralConfigValue object)
      {
        return createLiteralConfigValueAdapter();
      }
      @Override
      public Adapter caseEnumConfigValue(EnumConfigValue object)
      {
        return createEnumConfigValueAdapter();
      }
      @Override
      public Adapter caseRefPath(RefPath object)
      {
        return createRefPathAdapter();
      }
      @Override
      public Adapter caseRefSegment(RefSegment object)
      {
        return createRefSegmentAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.config.ConfigModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.config.ConfigModel
   * @generated
   */
  public Adapter createConfigModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.config.ConfigElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.config.ConfigElement
   * @generated
   */
  public Adapter createConfigElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.config.SubSystemConfig <em>Sub System Config</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.config.SubSystemConfig
   * @generated
   */
  public Adapter createSubSystemConfigAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.config.DynamicConfig <em>Dynamic Config</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.config.DynamicConfig
   * @generated
   */
  public Adapter createDynamicConfigAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.config.ActorClassConfig <em>Actor Class Config</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.config.ActorClassConfig
   * @generated
   */
  public Adapter createActorClassConfigAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.config.ActorInstanceConfig <em>Actor Instance Config</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.config.ActorInstanceConfig
   * @generated
   */
  public Adapter createActorInstanceConfigAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.config.ProtocolClassConfig <em>Protocol Class Config</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.config.ProtocolClassConfig
   * @generated
   */
  public Adapter createProtocolClassConfigAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.config.PortClassConfig <em>Port Class Config</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.config.PortClassConfig
   * @generated
   */
  public Adapter createPortClassConfigAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.config.PortInstanceConfig <em>Port Instance Config</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.config.PortInstanceConfig
   * @generated
   */
  public Adapter createPortInstanceConfigAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.config.AttrConfig <em>Attr Config</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.config.AttrConfig
   * @generated
   */
  public Adapter createAttrConfigAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.config.AttrClassConfig <em>Attr Class Config</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.config.AttrClassConfig
   * @generated
   */
  public Adapter createAttrClassConfigAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.config.AttrInstanceConfig <em>Attr Instance Config</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.config.AttrInstanceConfig
   * @generated
   */
  public Adapter createAttrInstanceConfigAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.config.ConfigValueArray <em>Value Array</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.config.ConfigValueArray
   * @generated
   */
  public Adapter createConfigValueArrayAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.config.ConfigValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.config.ConfigValue
   * @generated
   */
  public Adapter createConfigValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.config.LiteralConfigValue <em>Literal Config Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.config.LiteralConfigValue
   * @generated
   */
  public Adapter createLiteralConfigValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.config.EnumConfigValue <em>Enum Config Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.config.EnumConfigValue
   * @generated
   */
  public Adapter createEnumConfigValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.config.RefPath <em>Ref Path</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.config.RefPath
   * @generated
   */
  public Adapter createRefPathAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.etrice.core.config.RefSegment <em>Ref Segment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.etrice.core.config.RefSegment
   * @generated
   */
  public Adapter createRefSegmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //ConfigAdapterFactory
