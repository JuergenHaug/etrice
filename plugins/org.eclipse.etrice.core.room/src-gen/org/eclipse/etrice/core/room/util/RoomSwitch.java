/**
 */
package org.eclipse.etrice.core.room.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.IInterfaceItemOwner;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;

import org.eclipse.etrice.core.room.*;

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
 * @see org.eclipse.etrice.core.room.RoomPackage
 * @generated
 */
public class RoomSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static RoomPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoomSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = RoomPackage.eINSTANCE;
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
      case RoomPackage.ROOM_MODEL:
      {
        RoomModel roomModel = (RoomModel)theEObject;
        T result = caseRoomModel(roomModel);
        if (result == null) result = caseRoomElement(roomModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.ROOM_CLASS:
      {
        RoomClass roomClass = (RoomClass)theEObject;
        T result = caseRoomClass(roomClass);
        if (result == null) result = caseRoomElement(roomClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.STRUCTURE_CLASS:
      {
        StructureClass structureClass = (StructureClass)theEObject;
        T result = caseStructureClass(structureClass);
        if (result == null) result = caseRoomClass(structureClass);
        if (result == null) result = caseRoomElement(structureClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.ACTOR_CONTAINER_CLASS:
      {
        ActorContainerClass actorContainerClass = (ActorContainerClass)theEObject;
        T result = caseActorContainerClass(actorContainerClass);
        if (result == null) result = caseStructureClass(actorContainerClass);
        if (result == null) result = caseRoomClass(actorContainerClass);
        if (result == null) result = caseRoomElement(actorContainerClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.VAR_DECL:
      {
        VarDecl varDecl = (VarDecl)theEObject;
        T result = caseVarDecl(varDecl);
        if (result == null) result = caseRoomElement(varDecl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.MESSAGE_DATA:
      {
        MessageData messageData = (MessageData)theEObject;
        T result = caseMessageData(messageData);
        if (result == null) result = caseRoomElement(messageData);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.REFABLE_TYPE:
      {
        RefableType refableType = (RefableType)theEObject;
        T result = caseRefableType(refableType);
        if (result == null) result = caseRoomElement(refableType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.DATA_TYPE:
      {
        DataType dataType = (DataType)theEObject;
        T result = caseDataType(dataType);
        if (result == null) result = caseRoomClass(dataType);
        if (result == null) result = caseRoomElement(dataType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.COMPLEX_TYPE:
      {
        ComplexType complexType = (ComplexType)theEObject;
        T result = caseComplexType(complexType);
        if (result == null) result = caseDataType(complexType);
        if (result == null) result = caseRoomClass(complexType);
        if (result == null) result = caseRoomElement(complexType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.PRIMITIVE_TYPE:
      {
        PrimitiveType primitiveType = (PrimitiveType)theEObject;
        T result = casePrimitiveType(primitiveType);
        if (result == null) result = caseDataType(primitiveType);
        if (result == null) result = caseRoomClass(primitiveType);
        if (result == null) result = caseRoomElement(primitiveType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.ENUMERATION_TYPE:
      {
        EnumerationType enumerationType = (EnumerationType)theEObject;
        T result = caseEnumerationType(enumerationType);
        if (result == null) result = caseDataType(enumerationType);
        if (result == null) result = caseRoomClass(enumerationType);
        if (result == null) result = caseRoomElement(enumerationType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.ENUM_LITERAL:
      {
        EnumLiteral enumLiteral = (EnumLiteral)theEObject;
        T result = caseEnumLiteral(enumLiteral);
        if (result == null) result = caseRoomElement(enumLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.EXTERNAL_TYPE:
      {
        ExternalType externalType = (ExternalType)theEObject;
        T result = caseExternalType(externalType);
        if (result == null) result = caseComplexType(externalType);
        if (result == null) result = caseDataType(externalType);
        if (result == null) result = caseRoomClass(externalType);
        if (result == null) result = caseRoomElement(externalType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.DATA_CLASS:
      {
        DataClass dataClass = (DataClass)theEObject;
        T result = caseDataClass(dataClass);
        if (result == null) result = caseComplexType(dataClass);
        if (result == null) result = caseDataType(dataClass);
        if (result == null) result = caseRoomClass(dataClass);
        if (result == null) result = caseRoomElement(dataClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.ATTRIBUTE:
      {
        Attribute attribute = (Attribute)theEObject;
        T result = caseAttribute(attribute);
        if (result == null) result = caseRoomElement(attribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.OPERATION:
      {
        Operation operation = (Operation)theEObject;
        T result = caseOperation(operation);
        if (result == null) result = caseRoomElement(operation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.STANDARD_OPERATION:
      {
        StandardOperation standardOperation = (StandardOperation)theEObject;
        T result = caseStandardOperation(standardOperation);
        if (result == null) result = caseOperation(standardOperation);
        if (result == null) result = caseRoomElement(standardOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.PORT_OPERATION:
      {
        PortOperation portOperation = (PortOperation)theEObject;
        T result = casePortOperation(portOperation);
        if (result == null) result = caseOperation(portOperation);
        if (result == null) result = caseRoomElement(portOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.CLASS_STRUCTOR:
      {
        ClassStructor classStructor = (ClassStructor)theEObject;
        T result = caseClassStructor(classStructor);
        if (result == null) result = caseRoomElement(classStructor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.GENERAL_PROTOCOL_CLASS:
      {
        GeneralProtocolClass generalProtocolClass = (GeneralProtocolClass)theEObject;
        T result = caseGeneralProtocolClass(generalProtocolClass);
        if (result == null) result = caseRoomClass(generalProtocolClass);
        if (result == null) result = caseRoomElement(generalProtocolClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.PROTOCOL_CLASS:
      {
        ProtocolClass protocolClass = (ProtocolClass)theEObject;
        T result = caseProtocolClass(protocolClass);
        if (result == null) result = caseGeneralProtocolClass(protocolClass);
        if (result == null) result = caseRoomClass(protocolClass);
        if (result == null) result = caseRoomElement(protocolClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.COMPOUND_PROTOCOL_CLASS:
      {
        CompoundProtocolClass compoundProtocolClass = (CompoundProtocolClass)theEObject;
        T result = caseCompoundProtocolClass(compoundProtocolClass);
        if (result == null) result = caseGeneralProtocolClass(compoundProtocolClass);
        if (result == null) result = caseRoomClass(compoundProtocolClass);
        if (result == null) result = caseRoomElement(compoundProtocolClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.SUB_PROTOCOL:
      {
        SubProtocol subProtocol = (SubProtocol)theEObject;
        T result = caseSubProtocol(subProtocol);
        if (result == null) result = caseRoomElement(subProtocol);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.MESSAGE:
      {
        Message message = (Message)theEObject;
        T result = caseMessage(message);
        if (result == null) result = caseRoomElement(message);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.PORT_CLASS:
      {
        PortClass portClass = (PortClass)theEObject;
        T result = casePortClass(portClass);
        if (result == null) result = caseRoomElement(portClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.MESSAGE_HANDLER:
      {
        MessageHandler messageHandler = (MessageHandler)theEObject;
        T result = caseMessageHandler(messageHandler);
        if (result == null) result = caseRoomElement(messageHandler);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.IN_MESSAGE_HANDLER:
      {
        InMessageHandler inMessageHandler = (InMessageHandler)theEObject;
        T result = caseInMessageHandler(inMessageHandler);
        if (result == null) result = caseMessageHandler(inMessageHandler);
        if (result == null) result = caseRoomElement(inMessageHandler);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.OUT_MESSAGE_HANDLER:
      {
        OutMessageHandler outMessageHandler = (OutMessageHandler)theEObject;
        T result = caseOutMessageHandler(outMessageHandler);
        if (result == null) result = caseMessageHandler(outMessageHandler);
        if (result == null) result = caseRoomElement(outMessageHandler);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.ACTOR_CLASS:
      {
        ActorClass actorClass = (ActorClass)theEObject;
        T result = caseActorClass(actorClass);
        if (result == null) result = caseActorContainerClass(actorClass);
        if (result == null) result = caseModelComponent(actorClass);
        if (result == null) result = caseStructureClass(actorClass);
        if (result == null) result = caseIInterfaceItemOwner(actorClass);
        if (result == null) result = caseRoomClass(actorClass);
        if (result == null) result = caseRoomElement(actorClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.INTERFACE_ITEM:
      {
        InterfaceItem interfaceItem = (InterfaceItem)theEObject;
        T result = caseInterfaceItem(interfaceItem);
        if (result == null) result = caseAbstractInterfaceItem(interfaceItem);
        if (result == null) result = caseRoomElement(interfaceItem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.PORT:
      {
        Port port = (Port)theEObject;
        T result = casePort(port);
        if (result == null) result = caseInterfaceItem(port);
        if (result == null) result = caseAbstractInterfaceItem(port);
        if (result == null) result = caseRoomElement(port);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.EXTERNAL_PORT:
      {
        ExternalPort externalPort = (ExternalPort)theEObject;
        T result = caseExternalPort(externalPort);
        if (result == null) result = caseRoomElement(externalPort);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.SAP:
      {
        SAP sap = (SAP)theEObject;
        T result = caseSAP(sap);
        if (result == null) result = caseInterfaceItem(sap);
        if (result == null) result = caseAbstractInterfaceItem(sap);
        if (result == null) result = caseRoomElement(sap);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.SPP:
      {
        SPP spp = (SPP)theEObject;
        T result = caseSPP(spp);
        if (result == null) result = caseInterfaceItem(spp);
        if (result == null) result = caseAbstractInterfaceItem(spp);
        if (result == null) result = caseRoomElement(spp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.SERVICE_IMPLEMENTATION:
      {
        ServiceImplementation serviceImplementation = (ServiceImplementation)theEObject;
        T result = caseServiceImplementation(serviceImplementation);
        if (result == null) result = caseRoomElement(serviceImplementation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.LOGICAL_SYSTEM:
      {
        LogicalSystem logicalSystem = (LogicalSystem)theEObject;
        T result = caseLogicalSystem(logicalSystem);
        if (result == null) result = caseStructureClass(logicalSystem);
        if (result == null) result = caseRoomClass(logicalSystem);
        if (result == null) result = caseRoomElement(logicalSystem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.ACTOR_CONTAINER_REF:
      {
        ActorContainerRef actorContainerRef = (ActorContainerRef)theEObject;
        T result = caseActorContainerRef(actorContainerRef);
        if (result == null) result = caseRoomElement(actorContainerRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.SUB_SYSTEM_REF:
      {
        SubSystemRef subSystemRef = (SubSystemRef)theEObject;
        T result = caseSubSystemRef(subSystemRef);
        if (result == null) result = caseActorContainerRef(subSystemRef);
        if (result == null) result = caseRoomElement(subSystemRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.SUB_SYSTEM_CLASS:
      {
        SubSystemClass subSystemClass = (SubSystemClass)theEObject;
        T result = caseSubSystemClass(subSystemClass);
        if (result == null) result = caseActorContainerClass(subSystemClass);
        if (result == null) result = caseStructureClass(subSystemClass);
        if (result == null) result = caseRoomClass(subSystemClass);
        if (result == null) result = caseRoomElement(subSystemClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.LOGICAL_THREAD:
      {
        LogicalThread logicalThread = (LogicalThread)theEObject;
        T result = caseLogicalThread(logicalThread);
        if (result == null) result = caseRoomElement(logicalThread);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.ACTOR_INSTANCE_MAPPING:
      {
        ActorInstanceMapping actorInstanceMapping = (ActorInstanceMapping)theEObject;
        T result = caseActorInstanceMapping(actorInstanceMapping);
        if (result == null) result = caseRoomElement(actorInstanceMapping);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.REF_PATH:
      {
        RefPath refPath = (RefPath)theEObject;
        T result = caseRefPath(refPath);
        if (result == null) result = caseRoomElement(refPath);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.REF_SEGMENT:
      {
        RefSegment refSegment = (RefSegment)theEObject;
        T result = caseRefSegment(refSegment);
        if (result == null) result = caseRoomElement(refSegment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.BINDING:
      {
        Binding binding = (Binding)theEObject;
        T result = caseBinding(binding);
        if (result == null) result = caseRoomElement(binding);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.BINDING_END_POINT:
      {
        BindingEndPoint bindingEndPoint = (BindingEndPoint)theEObject;
        T result = caseBindingEndPoint(bindingEndPoint);
        if (result == null) result = caseRoomElement(bindingEndPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.LAYER_CONNECTION:
      {
        LayerConnection layerConnection = (LayerConnection)theEObject;
        T result = caseLayerConnection(layerConnection);
        if (result == null) result = caseRoomElement(layerConnection);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.SA_POINT:
      {
        SAPoint saPoint = (SAPoint)theEObject;
        T result = caseSAPoint(saPoint);
        if (result == null) result = caseRoomElement(saPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.REF_SA_POINT:
      {
        RefSAPoint refSAPoint = (RefSAPoint)theEObject;
        T result = caseRefSAPoint(refSAPoint);
        if (result == null) result = caseSAPoint(refSAPoint);
        if (result == null) result = caseRoomElement(refSAPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.RELAY_SA_POINT:
      {
        RelaySAPoint relaySAPoint = (RelaySAPoint)theEObject;
        T result = caseRelaySAPoint(relaySAPoint);
        if (result == null) result = caseSAPoint(relaySAPoint);
        if (result == null) result = caseRoomElement(relaySAPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.SP_POINT:
      {
        SPPoint spPoint = (SPPoint)theEObject;
        T result = caseSPPoint(spPoint);
        if (result == null) result = caseRoomElement(spPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.ACTOR_REF:
      {
        ActorRef actorRef = (ActorRef)theEObject;
        T result = caseActorRef(actorRef);
        if (result == null) result = caseActorContainerRef(actorRef);
        if (result == null) result = caseRoomElement(actorRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RoomPackage.ROOM_ELEMENT:
      {
        RoomElement roomElement = (RoomElement)theEObject;
        T result = caseRoomElement(roomElement);
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
  public T caseRoomModel(RoomModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRoomClass(RoomClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Structure Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Structure Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStructureClass(StructureClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Actor Container Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Actor Container Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActorContainerClass(ActorContainerClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Var Decl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Var Decl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVarDecl(VarDecl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Message Data</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Message Data</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMessageData(MessageData object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Refable Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Refable Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRefableType(RefableType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataType(DataType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Complex Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Complex Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComplexType(ComplexType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimitiveType(PrimitiveType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enumeration Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enumeration Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumerationType(EnumerationType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumLiteral(EnumLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>External Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>External Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExternalType(ExternalType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataClass(DataClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttribute(Attribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperation(Operation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Standard Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Standard Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStandardOperation(StandardOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePortOperation(PortOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class Structor</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class Structor</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassStructor(ClassStructor object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>General Protocol Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>General Protocol Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGeneralProtocolClass(GeneralProtocolClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Protocol Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Protocol Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProtocolClass(ProtocolClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Compound Protocol Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Compound Protocol Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCompoundProtocolClass(CompoundProtocolClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sub Protocol</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sub Protocol</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubProtocol(SubProtocol object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Message</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Message</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMessage(Message object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePortClass(PortClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Message Handler</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Message Handler</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMessageHandler(MessageHandler object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>In Message Handler</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>In Message Handler</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInMessageHandler(InMessageHandler object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Out Message Handler</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Out Message Handler</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOutMessageHandler(OutMessageHandler object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Actor Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Actor Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActorClass(ActorClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Interface Item</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Interface Item</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInterfaceItem(InterfaceItem object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePort(Port object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>External Port</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>External Port</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExternalPort(ExternalPort object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>SAP</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>SAP</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSAP(SAP object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>SPP</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>SPP</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSPP(SPP object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Service Implementation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Service Implementation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseServiceImplementation(ServiceImplementation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Logical System</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Logical System</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLogicalSystem(LogicalSystem object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Actor Container Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Actor Container Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActorContainerRef(ActorContainerRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sub System Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sub System Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubSystemRef(SubSystemRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sub System Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sub System Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubSystemClass(SubSystemClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Logical Thread</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Logical Thread</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLogicalThread(LogicalThread object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Actor Instance Mapping</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Actor Instance Mapping</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActorInstanceMapping(ActorInstanceMapping object)
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
   * Returns the result of interpreting the object as an instance of '<em>Binding</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Binding</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBinding(Binding object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Binding End Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Binding End Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBindingEndPoint(BindingEndPoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Layer Connection</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Layer Connection</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLayerConnection(LayerConnection object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>SA Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>SA Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSAPoint(SAPoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ref SA Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ref SA Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRefSAPoint(RefSAPoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relay SA Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relay SA Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelaySAPoint(RelaySAPoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>SP Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>SP Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSPPoint(SPPoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Actor Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Actor Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActorRef(ActorRef object)
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
  public T caseRoomElement(RoomElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>IInterface Item Owner</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>IInterface Item Owner</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIInterfaceItemOwner(IInterfaceItemOwner object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model Component</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Component</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModelComponent(ModelComponent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Interface Item</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Interface Item</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractInterfaceItem(AbstractInterfaceItem object)
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

} //RoomSwitch
