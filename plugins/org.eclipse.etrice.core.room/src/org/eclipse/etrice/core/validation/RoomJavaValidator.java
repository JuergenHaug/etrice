/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 		Eyrak Paen
 * 
 *******************************************************************************/


package org.eclipse.etrice.core.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.common.base.AnnotationType;
import org.eclipse.etrice.core.common.base.BasePackage;
import org.eclipse.etrice.core.common.base.Import;
import org.eclipse.etrice.core.common.base.LiteralType;
import org.eclipse.etrice.core.common.validation.ValidationHelpers;
import org.eclipse.etrice.core.common.validation.ValidationHelpers.NamedObject;
import org.eclipse.etrice.core.common.validation.ValidationHelpers.NamedObjectList;
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.validation.FSMValidationUtilXtend.Result;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorInstanceMapping;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.CompoundProtocolClass;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.EnumerationType;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefPath;
import org.eclipse.etrice.core.room.ReferenceType;
import org.eclipse.etrice.core.room.RoomAnnotationTargetEnum;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.xtext.validation.Check;

import com.google.common.collect.Maps;
import com.google.inject.Inject;

 

public class RoomJavaValidator extends AbstractRoomJavaValidator {

	@Inject
	private RoomHelpers roomHelpers;

	@Inject
	private RoomNameProvider roomNameProvider;
	
	@Inject
	private ValidationUtil ValidationUtil;
	
	/* message strings */
	public static final String OPTIONAL_REFS_HAVE_TO_HAVE_MULTIPLICITY_ANY = "optional refs have to have multiplicity any [*]";
	public static final String MULTIPLICITY_ANY_REQUIRES_OPTIONAL = "multiplicity any [*] requires optional";
	public static final String A_REPLICATED_PORT_MUST_HAVE_AT_MOST_ONE_REPLICATED_PEER = "a replicated port must have at most one replicated peer";
	
	/* tags for quick fixes */
	public static final String THREAD_MISSING = "RoomJavaValidator.ThreadMissing";
	public static final String DUPLICATE_ACTOR_INSTANCE_MAPPING = "RoomJavaValidator.DuplicateActorInstanceMapping";
	public static final String WRONG_NAMESPACE = "RoomJavaValidator.WrongNamespace";
	public static final String CIRCULAR_CONTAINMENT = "RoomJavaValidator.CircularContainment";
	public static final String ACTOR_REF_CHANGE_REF_TYPE_TO_FIXED_OR_MULT_TO_ANY = "RoomJavaValidator.ActorRefChangeRefTypeToFixed";
	public static final String ACTOR_REF_CHANGE_REF_TYPE_TO_OPTIONAL = "RoomJavaValidator.ActorRefChangeRefTypeToOptional";
	public static final String CHANGE_DESTRUCTOR_NAME = "RoomJavaValidator.ChangeDestructorName";
	public static final String CHANGE_CONSTRUCTOR_NAME = "RoomJavaValidator.ChangeConstructorName";
	public static final String INVALID_ANNOTATION_TARGET = "RoomJavaValidator.InvalidAnnotationTarget";
	public static final String OPERATION_MISSING_OVERRIDE = "RoomJavaValidator.OperationMissingOverride";
	public static final String OPERATION_EXTRANEOUS_OVERRIDE = "RoomJavaValidator.OperationExtraneousOverride";
	
	@Inject ImportUriResolver importUriResolver;
	
	@Check
	public void checkImportedNamespace(Import imp) {
		if (imp.getImportedNamespace()==null)
			return;
		
		if (imp.getImportURI()==null)
			return;
		
		String uriString = importUriResolver.resolve(imp);
		if(uriString == null) {
			warning("could not load referenced model", BasePackage.Literals.IMPORT__IMPORT_URI);
			return;
		}
		
		URI uri = URI.createURI(uriString);
		ResourceSet rs = imp.eResource().getResourceSet();

		try {
			Resource res = rs.getResource(uri, true);
			if (res==null)
				return;
			
			if (res.getContents().isEmpty()) {
				error("referenced model is empty", BasePackage.Literals.IMPORT__IMPORT_URI);
				return;
			}
			
			if (!(res.getContents().get(0) instanceof RoomModel)) {
				if (uri.lastSegment().endsWith(".room"))
					error("referenced model is no ROOM model (but has .room extension)", BasePackage.Literals.IMPORT__IMPORT_URI);
				else
					warning("referenced model is no ROOM model", BasePackage.Literals.IMPORT__IMPORT_URI);
				return;
			}
			
			RoomModel model = (RoomModel) res.getContents().get(0);
			if (!imp.getImportedNamespace().equals(model.getName()+".*")) {
				error("the imported namespace should be '"+model.getName()+".*'", BasePackage.Literals.IMPORT__IMPORTED_NAMESPACE, WRONG_NAMESPACE, model.getName()+".*");
			}
		}
		catch (RuntimeException re) {
			warning("could not load referenced model", BasePackage.Literals.IMPORT__IMPORT_URI);
			return;
		}
	}
	
	@Check
	public void checkActorRef(ActorRef ar) {
		if (ar.eContainer() instanceof ActorClass) {
			ActorClass ac = (ActorClass) ar.eContainer();
			
			if (roomHelpers.isReferencing(ar.getType(), ac)) {
				error("Actor reference is circular", RoomPackage.eINSTANCE.getActorRef_Type());
			}
		}
		
		// check actor ref array upper bound
		if (ar.getMultiplicity()<0) {
			// multiplicity * requires optional
			if (ar.getRefType()!=ReferenceType.OPTIONAL)
				error(MULTIPLICITY_ANY_REQUIRES_OPTIONAL,
						RoomPackage.eINSTANCE.getActorRef_RefType(), ACTOR_REF_CHANGE_REF_TYPE_TO_OPTIONAL);
		}
		else if (ar.getMultiplicity()>1) {
			// fixed multiplicity requires fixed type
			if (ar.getRefType()==ReferenceType.OPTIONAL)
				error(OPTIONAL_REFS_HAVE_TO_HAVE_MULTIPLICITY_ANY,
						RoomPackage.eINSTANCE.getActorRef_RefType(), ACTOR_REF_CHANGE_REF_TYPE_TO_FIXED_OR_MULT_TO_ANY, ar.getName());
		}
		
		// check actor ref array has ports with fixed multiplicity
		if (ar!=null) {
			ActorClass ac = ar.getType();
			if (ar.getMultiplicity()>1) {
				for (Port p : ac.getInterfacePorts()) {
					if (p.getMultiplicity()<0) {
						int idx = ((ActorContainerClass)ar.eContainer()).getActorRefs().indexOf(ar);
						error("replicated actor must not have replicated port with arbitrary multiplicity", null);
					}
				}
			}
		}
	}

	@Check
	public void checkLayerConnectiontarget(LayerConnection lc) {
		if (lc.getTo().getRef() instanceof ActorRef)
			if (((ActorRef)lc.getTo().getRef()).getMultiplicity()>1) 
				error("layer connection must not connect to replicated actor", null);		
	}
	
	@Check
	public void checkBaseClassesNotCircular(DataClass dc) {
		if (dc==null)
			return;
		
		if (roomHelpers.isCircularClassHierarchy(dc))
			error("Base classes are circular", RoomPackage.eINSTANCE.getDataClass_Base());
	}

	@Check
	public void checkAttributeNotCircular(Attribute att) {
		if (att.eContainer() instanceof ActorClass)
			// no circle possible
			return;
		
		if (att.eContainer() instanceof PortClass)
			// no circle possible
			return;
		
		if (!(att.eContainer() instanceof DataClass)) {
			assert(false): "unexpected parent class";
			return;
		}
		
		DataClass dc = (DataClass) att.eContainer();
		if (roomHelpers.isCircularClassHierarchy(dc))
			return;
		
		while (dc!=null) {
			if (att.getType().getType()==dc && !att.getType().isRef()) {
				error(
						"Attribute type must not refer to own class or a super class",
						RoomPackage.Literals.ATTRIBUTE__TYPE,
						CIRCULAR_CONTAINMENT,
						""+att.getType().getType().getName().length()
					);
				break;
			}
			
			dc = dc.getBase();
		}
	}
	
	@Check
	public void checkAttributeNoStringArray(Attribute att){
		// TODO-Enum
		if(!att.getType().isRef() && att.getType().getType() instanceof PrimitiveType){
			PrimitiveType type = (PrimitiveType)att.getType().getType();
			if(type.getName().equalsIgnoreCase("string") && att.getSize() > 0)
				error("string type must have multiplicity 0", RoomPackage.Literals.ATTRIBUTE__SIZE);
		}
	}
	
	@Check
	public void checkBaseClassesNotCircular(ProtocolClass pc) {
		if (pc==null)
			return;
		
		if (roomHelpers.isCircularClassHierarchy(pc))
			error("Base classes are circular", RoomPackage.eINSTANCE.getProtocolClass_Base());
	}

	@Check
	public void checkBaseClassesNotCircular(ActorClass ac) {
		if (ac==null)
			return;
		
		if (roomHelpers.isCircularClassHierarchy(ac))
			error("Base classes are circular", FSMPackage.eINSTANCE.getModelComponent_Base());
	}
	
	@Check
	public void checkUniqueNames(ActorClass ac) {
		if (roomHelpers.isCircularClassHierarchy(ac))
			return;
		
		HashMap<String, EObject> name2obj = new HashMap<String, EObject>();
		
		// first add all base class objects (we'll add no errors for them)
		if (ac.getActorBase()!=null) {
			ActorClass base = ac.getActorBase();
			List<InterfaceItem> items = roomHelpers.getAllInterfaceItems(base);
			for (InterfaceItem item : items) {
				name2obj.put(item.getName(), item);
			}
			List<ActorContainerRef> refs = roomHelpers.getAllActorContainerRefs(base);
			for (ActorContainerRef ref : refs) {
				name2obj.put(ref.getName(), ref);
			}
		}
		
		// now we check our own items and refs
		List<InterfaceItem> items = roomHelpers.getInterfaceItems(ac);
		for (InterfaceItem item : items) {
			if (name2obj.containsKey(item.getName())) {
				EObject duplicate = name2obj.get(item.getName());
				String location = roomNameProvider.getLocation(duplicate);
				EObject parent = item.eContainer();
				@SuppressWarnings("unchecked")
				int idx = ((List<EObject>)parent.eGet(item.eContainingFeature())).indexOf(item);
				error("names must be unique (duplicate of "+location+")", parent, item.eContainingFeature(), idx);
			}
			else
				name2obj.put(item.getName(), item);
		}
		
		List<ActorContainerRef> refs = roomHelpers.getRefs(ac, false);
		for (ActorContainerRef ref : refs) {
			if (name2obj.containsKey(ref.getName())) {
				EObject duplicate = name2obj.get(ref.getName());
				String location = roomNameProvider.getLocation(duplicate);
				EObject parent = ref.eContainer();
				@SuppressWarnings("unchecked")
				int idx = ((List<EObject>)parent.eGet(ref.eContainingFeature())).indexOf(ref);
				error("names must be unique (duplicate of "+location+")", parent, ref.eContainingFeature(), idx);
			}
			else
				name2obj.put(ref.getName(), ref);
		}
	}
	
	@Check
	public void checkExecModelConsistent(ActorClass ac) {
		if (roomHelpers.isCircularClassHierarchy(ac))
			return;
		
		ComponentCommunicationType commType = ac.getCommType();
		
		switch (commType) {
		case ASYNCHRONOUS:
			break;
		case DATA_DRIVEN:
			break;
		case EVENT_DRIVEN:
			break;
		case SYNCHRONOUS:
			error("synchronous communication type not supported yet", FSMPackage.eINSTANCE.getModelComponent_CommType());
		}
		
		while (ac.getActorBase()!=null) {
			ac = ac.getActorBase();

			if (commType!=ac.getCommType())
				error("data_driven attribute not consistent in inheritance hierarchy", FSMPackage.eINSTANCE.getModelComponent_CommType());
		}
	}
	
	@Check
	public void checkTopLevelRefinedStates(ActorClass ac) {
		List<Result> errors = ValidationUtil.checkTopLevelRefinedStates(ac);
		for (Result err : errors) {
			error(err);
		}
	}
	
	@Check  
	public void checkSubSystem(SubSystemClass ssc){
		if (ssc.getActorRefs().isEmpty())
			warning("SubSystemClass must contain at least one ActorRef", RoomPackage.eINSTANCE.getActorContainerClass_ActorRefs());

		if (ssc.getThreads().isEmpty())
			warning("at least one thread has to be defined", RoomPackage.Literals.SUB_SYSTEM_CLASS__THREADS, THREAD_MISSING, "LogicalThread dflt_thread");
		
		checkMappings(ssc.getActorInstanceMappings());
	}

	@Check
	public void checkLogicalSystem(LogicalSystem ls){
		if (ls.getSubSystems().isEmpty())
			error("LogicalSystem must contain at least one SubSystemRef", RoomPackage.eINSTANCE.getLogicalSystem_SubSystems());
	}


	@Check
	public void checkActorInstanceMapping(ActorInstanceMapping aim) {
		ActorContainerClass root = roomHelpers.getParentContainer(aim);
		if (root != null && !root.eIsProxy()) {
			RefPath path = aim.getPath();
			if (path != null) {
				String invalidSegment = roomHelpers.checkPath(root, path);
				if (invalidSegment != null)
					error("no match for segment '" + invalidSegment + "'",
							RoomPackage.Literals.ACTOR_INSTANCE_MAPPING__PATH);
				else {
					ActorRef aRef = roomHelpers.getLastActorRef(root, path);
					if (aRef == null)
						error("invalid actor reference",
								RoomPackage.Literals.ACTOR_INSTANCE_MAPPING__PATH);
				}
			}
		}
		checkMappings(aim.getActorInstanceMappings());
	}
	
	private void checkMappings(EList<ActorInstanceMapping> actorInstanceMappings) {
		HashSet<String> paths = new HashSet<String>();
		for (ActorInstanceMapping aim : actorInstanceMappings) {
			if (!paths.add(aim.getPath().toString())) {
				EObject parent = aim.eContainer();
				int idx = actorInstanceMappings.indexOf(aim);
				error("duplicate mapping", parent, aim.eContainingFeature(), idx, DUPLICATE_ACTOR_INSTANCE_MAPPING);
			}
		}
	}

	@Check
	public void checkPortCompatibility(Binding bind) {
		Result result = ValidationUtil.isValid(bind);
		if (!result.isOk()) {
			EObject sc = bind.eContainer();
			@SuppressWarnings("unchecked")
			int idx = ((List<EObject>)sc.eGet(bind.eContainingFeature())).indexOf(bind);
			error(result.getMsg(), sc, bind.eContainingFeature(), idx);
		}
	}
	
	@Check
	public void checkServiceCompatibility(LayerConnection conn) {
		Result result = ValidationUtil.isValid(conn);
		if (!result.isOk())
			error(result.getMsg(), RoomPackage.eINSTANCE.getLayerConnection_From());
	}
	
	@Check
	public void checkInterfaceItemUniqueName(InterfaceItem item) {
		Result result = ValidationUtil.isUniqueName(item);
		if (!result.isOk())
			error(result.getMsg(), FSMPackage.eINSTANCE.getAbstractInterfaceItem_Name());
	}
	
	@Check
	public void checkPortCommunicationCompatibility(ActorClass ac){
		if(ac.getCommType() == ComponentCommunicationType.SYNCHRONOUS){
			// not supported yet
			return;
		}
		
		// check external ports
		List<InterfaceItem> extPorts = new ArrayList<InterfaceItem>();
		for(ExternalPort exPort : ac.getExternalPorts())
			extPorts.add(exPort.getInterfacePort());
		checkPortCommunicationCompatibility(ac, extPorts, RoomPackage.eINSTANCE.getActorClass_ExternalPorts());
		// check internal ports
		checkPortCommunicationCompatibility(ac, ac.getInternalPorts(), RoomPackage.eINSTANCE.getActorClass_InternalPorts());
		// check SAPs
		checkPortCommunicationCompatibility(ac, ac.getServiceAccessPoints(), RoomPackage.eINSTANCE.getActorClass_ServiceAccessPoints());
		// check service implementations
		List<InterfaceItem> serviceImpls = new ArrayList<InterfaceItem>();
		for(ServiceImplementation si: ac.getServiceImplementations())
			serviceImpls.add(si.getSpp());
		checkPortCommunicationCompatibility(ac, serviceImpls, RoomPackage.eINSTANCE.getActorClass_ServiceImplementations());
	}
	
	private void checkPortCommunicationCompatibility(ActorClass ac, List<? extends InterfaceItem> items, EReference ref){
		boolean datadriven = ac.getCommType() == ComponentCommunicationType.DATA_DRIVEN;
		boolean eventdriven = ac.getCommType() == ComponentCommunicationType.EVENT_DRIVEN;
		boolean async = ac.getCommType() == ComponentCommunicationType.ASYNCHRONOUS;
		//boolean synchronous = ac.getCommType() == ComponentCommunicationType.SYNCHRONOUS;
		
		for(InterfaceItem item : items){
			ProtocolClass pc = roomHelpers.getProtocol(item);
			if (pc!=null)
				switch(pc.getCommType()){
					case DATA_DRIVEN:
						if(!datadriven && !async)
							error("ports with datadriven protocols not allowed", ref, items.indexOf(item));
						break;
					case EVENT_DRIVEN:
						if(!eventdriven && !async)
							error("ports with eventdriven protocols not allowed", ref, items.indexOf(item));
						break;
					case SYNCHRONOUS:
						// not supported yet
				}
		}
	}
	
	@Check
	public void checkPort(Port port) {
		if (port.getMultiplicity()==0)
			error("multiplicity must not be 0", RoomPackage.eINSTANCE.getPort_Multiplicity());
		if (port.getMultiplicity()<-1)
			error("multiplicity must be -1 or positive", RoomPackage.eINSTANCE.getPort_Multiplicity());
		if (port.getProtocol() instanceof ProtocolClass)
			if (((ProtocolClass)port.getProtocol()).getCommType()==CommunicationType.DATA_DRIVEN && port.getMultiplicity()!=1)
			error("multiplicity must be 1 for data driven ports", RoomPackage.eINSTANCE.getPort_Multiplicity());
	}
	
	@Check
	public void checkProtocol(ProtocolClass pc) {
		if (roomHelpers.isCircularClassHierarchy(pc))
			return;
		
		switch (pc.getCommType()) {
		case DATA_DRIVEN:
			if (pc.getBase()!=null && pc.getBase().getCommType()!=CommunicationType.DATA_DRIVEN)
				error("super protocol has to have same communication type", RoomPackage.Literals.PROTOCOL_CLASS__COMM_TYPE);
			if (roomHelpers.getAllMessages(pc, true).isEmpty())
				error("at least one incoming message must be defined", RoomPackage.Literals.PROTOCOL_CLASS__INCOMING_MESSAGES);
			if (!roomHelpers.getAllMessages(pc, false).isEmpty())
				error("data driven protocols must have no outgoing messages", RoomPackage.Literals.PROTOCOL_CLASS__OUTGOING_MESSAGES);
			break;
		case EVENT_DRIVEN:
			if (pc.getBase()!=null && pc.getBase().getCommType()!=CommunicationType.EVENT_DRIVEN)
				error("super protocol has to have same communication type", RoomPackage.Literals.PROTOCOL_CLASS__COMM_TYPE);
			if (roomHelpers.getAllMessages(pc, true).isEmpty()
					&& roomHelpers.getAllMessages(pc, false).isEmpty()
					&& roomHelpers.getAllOperations(pc, true).isEmpty()
					&& roomHelpers.getAllOperations(pc, false).isEmpty())
				error("at least one message/port operation (incoming or outgoing) must be defined", RoomPackage.Literals.PROTOCOL_CLASS__INCOMING_MESSAGES);
			break;
		case SYNCHRONOUS:
			error("synchronous communication type not supported yet", RoomPackage.Literals.PROTOCOL_CLASS__COMM_TYPE);
			break;
		default:
		}
		
		checkDuplicates(pc, true);
		checkDuplicates(pc, false);
		
		if (pc.getBase()!=null) {
			// derived protocol
			if (pc.getIncomingMessages().size()>0 && pc.getOutgoingMessages().size()>0) {
				warning("a derived protocol should add either incoming or outgoing messages, not both", RoomPackage.Literals.PROTOCOL_CLASS__OUTGOING_MESSAGES);
			}
		}
	}

	/**
	 * checks duplicates in the set of messages and operations including inherited items
	 * per direction
	 * 
	 * @param pc the protocol class
	 * @param incoming a flag giving the direction to be checked
	 */
	private void checkDuplicates(ProtocolClass pc, boolean incoming) {
		NamedObjectList all = new NamedObjectList();
		all.addAll(roomHelpers.getAllMessages(pc, incoming), RoomPackage.Literals.MESSAGE__NAME);
		all.addAll(roomHelpers.getAllOperations(pc, incoming), RoomPackage.Literals.OPERATION__NAME);
		Iterable<NamedObject> duplicates = ValidationHelpers.inSameResource(ValidationHelpers.removeUniques(all), pc.eResource());
		for (NamedObject dupl : duplicates) {
			error("duplicate message name", dupl.getObj(), dupl.getFeature());
		}
	}
	
	@Check
	public void checkMessage(Message msg) {
		ProtocolClass pc = (ProtocolClass) msg.eContainer();
		if (pc.getCommType()==CommunicationType.DATA_DRIVEN)
			if (msg.getData()==null)
				error("Messages of data driven protocols must carry data", RoomPackage.Literals.MESSAGE__DATA);
	}
	
	@Check
	public void checkMessageFromIf(MessageFromIf mfi){
		if(mfi.getFrom() != null){
			if(roomHelpers.getProtocol((InterfaceItem)mfi.getFrom()).getCommType() != CommunicationType.EVENT_DRIVEN)
				error("port must have event driven protocol", mfi, FSMPackage.eINSTANCE.getMessageFromIf_From());
		}
	}
	
	@Check
	public void checkDataClass(DataClass dc) {
		if (dc.getAttributes().isEmpty() && dc.getBase()==null)
			error("Non-derived data classes have to define at least one attribute", RoomPackage.Literals.DATA_CLASS__ATTRIBUTES);
	}
	
	@Check
	public void checkAttribute(Attribute att) {
		ArrayList<Attribute> all = new ArrayList<Attribute>();
		
		if (att.eContainer() instanceof ActorClass) {
			ActorClass ac = (ActorClass) att.eContainer();
			if (roomHelpers.isCircularClassHierarchy(ac))
				// is checked elsewhere
				return;
			
			do {
				all.addAll(ac.getAttributes());
				ac = ac.getActorBase();
			}
			while (ac!=null);
		}
		else if (att.eContainer() instanceof DataClass) {
			DataClass dc = (DataClass) att.eContainer();
			if (roomHelpers.isCircularClassHierarchy(dc))
				// is checked elsewhere
				return;
			
			do {
				all.addAll(dc.getAttributes());
				dc = dc.getBase();
			}
			while (dc!=null);
		}
		// skip PortClass case since they don't inherit (yet)
		
		String name = att.getName();
		for (Attribute a : all) {
			if (a!=att && a.getName().equals(name))
				if (a.eContainer()!=att.eContainer())
					error("name already used in base class '"+((RoomClass)a.eContainer()).getName()+"'",
							RoomPackage.Literals.ATTRIBUTE__NAME);
				else
					error("name already used", RoomPackage.Literals.ATTRIBUTE__NAME);
		}
	}
	
	@Check
	public void checkReplicatedPortBindingPatterns(StructureClass sc) {
		HashSet<Port> haveReplPeer = new HashSet<Port>();
		for (Binding bind : sc.getBindings()) {
			Port p1 = bind.getEndpoint1().getPort();
			Port p2 = bind.getEndpoint2().getPort();
			if (p1.getMultiplicity()!=1 && p2.getMultiplicity()!=1) {
				if (!haveReplPeer.add(p1))
					error(A_REPLICATED_PORT_MUST_HAVE_AT_MOST_ONE_REPLICATED_PEER,
							bind,
							RoomPackage.Literals.BINDING__ENDPOINT1);
				if (!haveReplPeer.add(p2))
					error(A_REPLICATED_PORT_MUST_HAVE_AT_MOST_ONE_REPLICATED_PEER,
							bind,
							RoomPackage.Literals.BINDING__ENDPOINT2);
			}
		}
	}
	
	@Check
	public void checkPortClassContents(PortClass pc) {
		if (pc.getAttributes().isEmpty() && pc.getMsgHandlers().isEmpty() && pc.getOperations().isEmpty())
			error("port class must not be empty", pc, RoomPackage.Literals.PORT_CLASS__ATTRIBUTES);
	}
	
	@Check
	public void checkCompoundProtocolClass(CompoundProtocolClass cpc) {
		if (cpc.getSubProtocols().isEmpty())
			error("no sub protocols defined", cpc, RoomPackage.Literals.COMPOUND_PROTOCOL_CLASS__SUB_PROTOCOLS);
	}
	
	@Check
	public void checkAnnotationTarget(Annotation a) {
		if(a.getType() == null || a.getType().eIsProxy())
			return;
		
		EObject parent = a.eContainer();
		EList<String> targetList = a.getType().getTargets();
		RoomAnnotationTargetEnum invalidTargetType = null;
		if(parent instanceof ActorClass) {
			ActorClass actorParent = (ActorClass)parent;
			if(actorParent.getAnnotations().contains(a) && !targetList.contains(RoomAnnotationTargetEnum.ACTOR_CLASS.getLiteral())) {
				invalidTargetType = RoomAnnotationTargetEnum.ACTOR_CLASS;
			}
			else if(actorParent.getBehaviorAnnotations().contains(a) && !targetList.contains(RoomAnnotationTargetEnum.ACTOR_BEHAVIOR.getLiteral())) {
				invalidTargetType = RoomAnnotationTargetEnum.ACTOR_BEHAVIOR;
			}
		}
		else if(parent instanceof DataClass && !targetList.contains(RoomAnnotationTargetEnum.DATA_CLASS.getLiteral())) {
			invalidTargetType = RoomAnnotationTargetEnum.DATA_CLASS;
		}
		else if(parent instanceof ProtocolClass && !targetList.contains(RoomAnnotationTargetEnum.PROTOCOL_CLASS.getLiteral())) {
			invalidTargetType = RoomAnnotationTargetEnum.PROTOCOL_CLASS;
		}
		else if(parent instanceof CompoundProtocolClass && !targetList.contains(RoomAnnotationTargetEnum.COMPOUND_PROTOCOL_CLASS.getLiteral())) {
			invalidTargetType = RoomAnnotationTargetEnum.COMPOUND_PROTOCOL_CLASS;
		}
		else if(parent instanceof LogicalSystem && !targetList.contains(RoomAnnotationTargetEnum.LOGICAL_SYSTEM_CLASS.getLiteral())) {
			invalidTargetType = RoomAnnotationTargetEnum.LOGICAL_SYSTEM_CLASS;
		}
		else if(parent instanceof SubSystemClass && !targetList.contains(RoomAnnotationTargetEnum.SUBSYSTEM_CLASS.getLiteral())) {
			invalidTargetType = RoomAnnotationTargetEnum.SUBSYSTEM_CLASS;
		}
		if(invalidTargetType != null) {
			error("AnnotationType " + a.getType().getName() + " is not allowed for target " + invalidTargetType.getLiteral(),
					a,
					BasePackage.Literals.ANNOTATION__TYPE,
					INVALID_ANNOTATION_TARGET,
					a.getType().getName(),
					a.getType().getName()+" {target = "+invalidTargetType.getLiteral()+" ...",
					invalidTargetType.getLiteral());
		}
		}
	
	@Check
	public void checkRoomClassAnnotationTypeUniqueness(RoomClass rc) {
		if(rc.eContainer() instanceof RoomModel) {
			RoomModel model = (RoomModel)rc.eContainer();
			for(AnnotationType at : model.getAnnotationTypes()) {
				if(rc.getName().equals(at.getName())) {
					error("The name \""+at.getName()+"\" already exists as an AnnotationType name", rc, RoomPackage.Literals.ROOM_CLASS__NAME); 
				}
			}
		}
	}
	
	@Check
	public void checkRoomClassAnnotationTypeUniqueness(AnnotationType at) {
		if(at.eContainer() instanceof RoomModel) {
			RoomModel model = (RoomModel)at.eContainer();
			for(Object obj : org.eclipse.emf.ecore.util.EcoreUtil.getObjectsByType(model.eContents(), RoomPackage.Literals.ROOM_CLASS)) {
				RoomClass rc = (RoomClass)obj;
				if(at.getName().equals(rc.getName())) {
					error("The name \""+at.getName()+"\" already exists as a RoomClass name", at, BasePackage.Literals.ANNOTATION_TYPE__NAME); 
				}
			}
		}
	}
	
	@Check
	public void checkEnumeration(EnumerationType et) {
		if (et.getPrimitiveType()!=null) {
			if (et.getPrimitiveType().getType()!=LiteralType.INT) {
				error("enumerations must be of integer type", RoomPackage.Literals.ENUMERATION_TYPE__PRIMITIVE_TYPE);
			}
		}
		
		if (et.getLiterals().isEmpty())
			error("at least one literal has to be specified", RoomPackage.Literals.ENUMERATION_TYPE__LITERALS);
	}
	
	
	private void error(Result result) {
		error(result.getMsg(), result.getSource(), result.getFeature(), result.getIndex());
	}
	
	@Check
	public void checkOperations(ActorClass ac){
		if(roomHelpers.isCircularClassHierarchy(ac))
			return;
		
		// issue warning for deprecated ctor/dtor operations
		for(Operation op : ac.getOperations())
			if(ac.getName().equals(op.getName()))
				warning("Operation name is discouraged, may be mistaken for ctor/dtor", op, RoomPackage.Literals.OPERATION__NAME);
		checkOperationsOverride(roomHelpers.getAllOperations(ac), ac.getOperations());
	}
	
	@Check
	public void checkOperations(DataClass dc){
		if(roomHelpers.isCircularClassHierarchy(dc))
			return;
		
		// issue warning for deprecated ctor/dtor operations
		for(Operation op : dc.getOperations())
			if(dc.getName().equals(op.getName()))
				warning("Operation name is discouraged, may be mistaken for ctor/dtor", op, RoomPackage.Literals.OPERATION__NAME);
		checkOperationsOverride(roomHelpers.getAllOperations(dc), dc.getOperations());
	}
	
	/**
	 * @param allOperations list of all operations ordered by base class first
	 * @param toCheck
	 */
	private void checkOperationsOverride(List<StandardOperation> allOperations, List<StandardOperation> toCheck){
		Map<String, StandardOperation> map = Maps.newHashMap();
		for(StandardOperation op : allOperations){
			if(!map.containsKey(op.getName()))
				map.put(op.getName(), op);
		}
		for(StandardOperation op : toCheck){
			if(op.getName() == null)
				continue;
			StandardOperation baseOp = map.get(op.getName());
			if(baseOp == op){
				if(op.isOverride())
					error("Operation '"+op.getName()+"' must override an operation in super class", op, RoomPackage.Literals.STANDARD_OPERATION__OVERRIDE, OPERATION_EXTRANEOUS_OVERRIDE);
				continue;
			}
			String baseOpFQN = roomHelpers.getRoomClass(baseOp).getName()+"."+baseOp.getName()+"()";
			if(!op.isOverride()){
				error("Implicit override of operation "+baseOpFQN, op, RoomPackage.Literals.OPERATION__NAME, OPERATION_MISSING_OVERRIDE);
				continue;
			}
			if(!roomHelpers.matchingArguments(baseOp, op))
				error("Arguments must be identical to overriden operation in " +baseOpFQN, op, RoomPackage.Literals.OPERATION__ARGUMENTS);
			
			if(!roomHelpers.matchingReturnType(baseOp, op))
				error("Return type  must be identical to overriden operation " +baseOpFQN, op, RoomPackage.Literals.OPERATION__RETURN_TYPE);
		}
	}
}
