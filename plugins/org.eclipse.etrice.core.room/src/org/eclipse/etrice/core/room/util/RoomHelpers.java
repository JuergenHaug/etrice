/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.core.room.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.common.base.KeyValue;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.FSMFactory;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorInstanceMapping;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefPath;
import org.eclipse.etrice.core.room.RefSegment;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;

/**
 * This class provides a collection of convenience functions that extract implicit information
 * from model elements. It is assumed that the elements are part of a valid model.<br/><br/>
 * 
 * There is a second layer which gives access to informations which is even more indirectly
 * contained and requires a somewhat larger effort to extract them.
 * This is provided by the
 * {@link org.eclipse.etrice.core.genmodel.builder.GeneratorModelBuilder eTrice Generator Model}.
 *
 * @author Henrik Rentz-Reichert initial contribution and API
 *
 * @see org.eclipse.etrice.core.genmodel.builder.GeneratorModelBuilder eTrice Generator Model
 */
public class RoomHelpers extends FSMHelpers {
	
	/**
	 * Compute a list of the class itself and its base classes in reverse order (super classes to sub classes)
	 * 
	 * @param ac the {@link ActorClass}
	 * @return a list of the class itself and its base classes in reverse order (super classes to sub classes)
	 */
	public List<ActorClass> getClassHierarchy(ActorClass ac) {
		ArrayList<ActorClass> result = new ArrayList<ActorClass>();
		
		while (ac!=null) {
			result.add(0, ac);
			ac = ac.getActorBase();
		}
		
		return result;
	}
	
	/**
	 * Return a list of all {@link InterfaceItem}s ({@link Port}s and
	 * {@link SPP}s) of a {@link StructureClass}.
	 * Internal end ports and SAPs are <em>not</em> included.
	 * 
	 * @param sc the {@link StructureClass}
	 * @param includeInherited <code>true</code> if inherited items should be included (applies only for actor classes)
	 * 
	 * @return a list of all (external) interface items
	 */
	public List<InterfaceItem> getInterfaceItems(StructureClass sc, boolean includeInherited) {
		ArrayList<InterfaceItem> result = new ArrayList<InterfaceItem>();
		
		if (sc instanceof ActorClass) {
			ActorClass ac = (ActorClass) sc;
			do {
				result.addAll(ac.getServiceProvisionPoints());
				result.addAll(ac.getInterfacePorts());
				ac = ac.getActorBase();
			}
			while (includeInherited && ac!=null);
		}
		else if (sc instanceof SubSystemClass) {
			result.addAll(((SubSystemClass) sc).getServiceProvisionPoints());
			result.addAll(((SubSystemClass) sc).getRelayPorts());
		}
		else if (sc instanceof LogicalSystem) {
			// has no interface items
		}
		else {
			assert(false): "unexpected sub type";
		}
		
		return result;
	}

	/**
	 * Returns a list of all {@link ActorContainerRef}s of a structure class.
	 * For {@link SubSystemClass}es and {@link ActorClass}es these are
	 * {@link ActorRef}s, for {@link LogicalSystem}s these are {@link SubSystemRef}s.
	 * 
	 * @param sc the {@link StructureClass}
	 * @param includeInherited <code>true</code> if inherited refs should be included (applies only for actor classes)
	 * 
	 * @return a list of all {@link ActorContainerRef}s of a structure class.
	 */
	public List<ActorContainerRef> getRefs(StructureClass sc, boolean includeInherited) {
		ArrayList<ActorContainerRef> result = new ArrayList<ActorContainerRef>();

		if (sc instanceof ActorClass) {
			ActorClass ac = (ActorClass) sc;
			do {
				result.addAll(ac.getActorRefs());
				ac = ac.getActorBase();
			}
			while (includeInherited && ac!=null);
		}
		else if (sc instanceof SubSystemClass) {
			result.addAll(((SubSystemClass) sc).getActorRefs());
		}
		else if (sc instanceof LogicalSystem) {
			result.addAll(((LogicalSystem) sc).getSubSystems());
		}
		else {
			assert(false): "unexpected sub type";
		}

		return result;
	}
	
	/**
	 * Returns a list of all {@link Binding}s of a {@link StructureClass}.
	 * 
	 * @param sc the {@link StructureClass}
	 * @param includeInherited <code>true</code> if inherited bindings should be included (applies only for actor classes)
	 * 
	 * @return a list of all {@link Binding}s of a {@link StructureClass}.
	 */
	public List<Binding> getBindings(StructureClass sc, boolean includeInherited) {
		ArrayList<Binding> result = new ArrayList<Binding>();

		if (sc instanceof ActorClass) {
			ActorClass ac = (ActorClass) sc;
			do {
				result.addAll(ac.getBindings());
				ac = ac.getActorBase();
			}
			while (includeInherited && ac!=null);
		}
		else if (sc instanceof SubSystemClass) {
			result.addAll(((SubSystemClass) sc).getBindings());
		}
		else if (sc instanceof LogicalSystem) {
			result.addAll(((LogicalSystem) sc).getBindings());
		}
		else {
			assert(false): "unexpected sub type";
		}

		return result;
	}
	
	/**
	 * Returns a list of all {@link LayerConnection}s of a {@link StructureClass}.
	 * 
	 * @param sc the {@link StructureClass}
	 * @param includeInherited <code>true</code> if inherited layer
	 * 			connections should be included (applies only for actor classes)
	 * 
	 * @return a list of all {@link LayerConnection}s of a {@link StructureClass}.
	 */
	public List<LayerConnection> getConnections(StructureClass sc, boolean includeInherited) {
		ArrayList<LayerConnection> result = new ArrayList<LayerConnection>();

		if (sc instanceof ActorClass) {
			ActorClass ac = (ActorClass) sc;
			do {
				result.addAll(ac.getConnections());
				ac = ac.getActorBase();
			}
			while (includeInherited && ac!=null);
		}
		else if (sc instanceof SubSystemClass) {
			result.addAll(((SubSystemClass) sc).getConnections());
		}
		else if (sc instanceof LogicalSystem) {
			result.addAll(((LogicalSystem) sc).getConnections());
		}
		else {
			assert(false): "unexpected sub type";
		}

		return result;
	}

	/**
	 * Returns the user code 1 of a {@link DataClass} including inherited class code as String.
	 * The code is ordered super class first.
	 * 
	 * @param dc the {@link DataClass}
	 * 
	 * @return the user code 1 of a {@link DataClass} including inherited case class code as String
	 */
	public String getDeepUserCode1(DataClass dc) {
		return getDeepUserCode(dc, RoomPackage.Literals.DATA_CLASS__USER_CODE1);
	}


	/**
	 * Returns the user code 2 of a {@link DataClass} including inherited class code as String.
	 * The code is ordered super class first.
	 * 
	 * @param dc the {@link DataClass}
	 * 
	 * @return the user code 2 of a {@link DataClass} including inherited case class code as String
	 */
	public String getDeepUserCode2(DataClass dc) {
		return getDeepUserCode(dc, RoomPackage.Literals.DATA_CLASS__USER_CODE2);
	}


	/**
	 * Returns the user code 3 of a {@link DataClass} including inherited class code as String.
	 * The code is ordered super class first.
	 * 
	 * @param dc the {@link DataClass}
	 * 
	 * @return the user code 3 of a {@link DataClass} including inherited case class code as String
	 */
	public String getDeepUserCode3(DataClass dc) {
		return getDeepUserCode(dc, RoomPackage.Literals.DATA_CLASS__USER_CODE3);
	}


	/**
	 * Returns the user code 1 of a {@link ProtocolClass} including inherited class code as String.
	 * The code is ordered super class first.
	 * 
	 * @param pc the {@link ProtocolClass}
	 * 
	 * @return the user code 1 of a {@link ProtocolClass} including inherited case class code as String
	 */
	public String getDeepUserCode1(ProtocolClass pc) {
		return getDeepUserCode(pc, RoomPackage.Literals.PROTOCOL_CLASS__USER_CODE1);
	}

	/**
	 * Returns the user code 2 of a {@link ProtocolClass} including inherited class code as String.
	 * The code is ordered super class first.
	 * 
	 * @param pc the {@link ProtocolClass}
	 * 
	 * @return the user code 2 of a {@link ProtocolClass} including inherited case class code as String
	 */
	public String getDeepUserCode2(ProtocolClass pc) {
		return getDeepUserCode(pc, RoomPackage.Literals.PROTOCOL_CLASS__USER_CODE2);
	}

	/**
	 * Returns the user code 3 of a {@link ProtocolClass} including inherited class code as String.
	 * The code is ordered super class first.
	 * 
	 * @param pc the {@link ProtocolClass}
	 * 
	 * @return the user code 3 of a {@link ProtocolClass} including inherited case class code as String
	 */
	public String getDeepUserCode3(ProtocolClass pc) {
		return getDeepUserCode(pc, RoomPackage.Literals.PROTOCOL_CLASS__USER_CODE3);
	}

	/**
	 * Returns the user code 1 of a {@link ActorContainerClass} including inherited class code as String.
	 * The code is ordered super class first.
	 * 
	 * @param ac the {@link ActorContainerClass}
	 * 
	 * @return the user code 1 of a {@link ActorContainerClass} including inherited case class code as String
	 */
	public String getDeepUserCode1(ActorContainerClass ac) {
		return getDeepUserCode(ac, RoomPackage.Literals.ACTOR_CONTAINER_CLASS__USER_CODE1);
	}

	/**
	 * Returns the user code 2 of a {@link ActorContainerClass} including inherited class code as String.
	 * The code is ordered super class first.
	 * 
	 * @param ac the {@link ActorContainerClass}
	 * 
	 * @return the user code 2 of a {@link ActorContainerClass} including inherited case class code as String
	 */
	public String getDeepUserCode2(ActorContainerClass ac) {
		return getDeepUserCode(ac, RoomPackage.Literals.ACTOR_CONTAINER_CLASS__USER_CODE2);
	}

	/**
	 * Returns the user code 3 of a {@link ActorContainerClass} including inherited class code as String.
	 * The code is ordered super class first.
	 * 
	 * @param ac the {@link ActorContainerClass}
	 * 
	 * @return the user code 3 of a {@link ActorContainerClass} including inherited case class code as String
	 */
	public String getDeepUserCode3(ActorContainerClass ac) {
		return getDeepUserCode(ac, RoomPackage.Literals.ACTOR_CONTAINER_CLASS__USER_CODE3);
	}
	
	private String getDeepUserCode(EObject obj, EStructuralFeature code) {
		StringBuilder result = new StringBuilder();
		
		while (obj!=null) {
			DetailCode dc = (DetailCode) obj.eGet(code);
			result.insert(0, getDetailCode(dc));
			
			if (obj instanceof ActorClass)
				obj = ((ActorClass) obj).getBase();
			else if (obj instanceof ProtocolClass)
				obj = ((ProtocolClass) obj).getBase();
			else if (obj instanceof DataClass)
				obj = ((DataClass) obj).getBase();
			else
				break;
		}

		return result.toString();
	}
	
	/**
	 * @param pc a {@link ProtocolClass}
	 * @return all incoming {@link Message}s including base class with base class messages first
	 */
	public List<Message> getAllIncomingMessages(ProtocolClass pc) {
		return getAllMessages(pc, true);
	}
	
	/**
	 * @param pc a {@link ProtocolClass}
	 * @return all outgoing {@link Message}s including base class with base class messages first
	 */
	public List<Message> getAllOutgoingMessages(ProtocolClass pc) {
		return getAllMessages(pc, false);
	}
	
	/**
	 * Returns a list of all {@link Message}s of one direction a {@link ProtocolClass}
	 * including base classes.
	 * 
	 * @param pc a {@link ProtocolClass}
	 * @param incoming if <code>true</code> the incoming messages are returned, else outgoing
	 * 
	 * @return a list of all {@link Message}s of one direction a {@link ProtocolClass} including base classes
	 */
	public List<Message> getAllMessages(ProtocolClass pc, boolean incoming) {
		ArrayList<Message> result = new ArrayList<Message>();
		
		while (pc!=null) {
			if (incoming)
				result.addAll(0, pc.getIncomingMessages());
			else
				result.addAll(0, pc.getOutgoingMessages());
			
			pc = pc.getBase();
		}
		
		return result;
	}

	/**
	 * @param item an {@link InterfaceItem}
	 * @return a list of all incoming {@link Message}s of this item
	 */
	public List<Message> getIncoming(InterfaceItem item) {
		if (getProtocol(item)!=null)
			return getAllMessages(getProtocol(item), !isConjugated(item));
		else
			return Collections.emptyList();
	}

	/**
	 * @param item an {@link InterfaceItem}
	 * @return a list of all outgoing {@link Message}s of this item
	 */
	public List<Message> getOutgoing(InterfaceItem item) {
		if (getProtocol(item)!=null)
			return getAllMessages(getProtocol(item), isConjugated(item));
		else
			return Collections.emptyList();
	}
	
	/**
	 * @param item an {@link InterfaceItem}
	 * @return <code>true</code> if the item is logically conjugate
	 */
	public boolean isConjugated(InterfaceItem item) {
		if (item instanceof Port)
			return ((Port) item).isConjugated();
		else if (item instanceof SAP)
			return true;
		else if (item instanceof SPP)
			return false;
		
		assert(false): "unexpected sub type";
		return true;
	}
	
	/**
	 * Returns a list of all {@link Attribute}s of an {@link ActorClass}
	 * including base classes.
	 * 
	 * @param ac an {@link ActorClass}
	 * 
	 * @return a list of all {@link Attribute}s of an {@link ActorClass}
	 */
	public List<Attribute> getAllAttributes(ActorClass ac) {
		ArrayList<Attribute> result = new ArrayList<Attribute>();
		
		while (ac!=null) {
			result.addAll(0, ac.getAttributes());
			
			ac = ac.getActorBase();
		}
		
		return result;
	}
	
	/**
	 * Returns a list of all {@link Attribute}s of a {@link DataClass}
	 * including base classes.
	 * 
	 * @param dc an {@link DataClass}
	 * 
	 * @return a list of all {@link Attribute}s of a {@link DataClass}
	 */
	public List<Attribute> getAllAttributes(DataClass dc) {
		ArrayList<Attribute> result = new ArrayList<Attribute>();
		
		while (dc!=null) {
			result.addAll(0, dc.getAttributes());
			
			dc = dc.getBase();
		}
		
		return result;
	}

	/**
	 * Returns a list of all {@link Operation}s of an {@link ActorClass}
	 * including base classes.
	 * 
	 * @param ac an {@link ActorClass}
	 * 
	 * @return a list of all {@link Operation}s of an {@link ActorClass}
	 */
	public List<Operation> getAllOperations(ActorClass ac) {
		ArrayList<Operation> result = new ArrayList<Operation>();
		
		while (ac!=null) {
			result.addAll(0, ac.getOperations());
			
			ac = ac.getActorBase();
		}
		
		return result;
	}

	/**
	 * Returns a list of all {@link Operation}s of a {@link DataClass}
	 * including base classes.
	 * 
	 * @param dc an {@link DataClass}
	 * 
	 * @return a list of all {@link Operation}s of a {@link DataClass}
	 */
	public List<Operation> getAllOperations(DataClass dc) {
		ArrayList<Operation> result = new ArrayList<Operation>();
		
		while (dc!=null) {
			result.addAll(0, dc.getOperations());
			
			dc = dc.getBase();
		}
		
		return result;
	}
	
	/**
	 * Returns a list of the (internal and external) end {@link Port}s of an {@link ActorClass}.
	 * 
	 * @param ac an {@link ActorClass}
	 * 
	 * @return a list of the end {@link Port}s of an {@link ActorClass}
	 */
	public List<Port> getEndPorts(ActorClass ac) {
		ArrayList<Port> result = new ArrayList<Port>(ac.getInternalPorts());

		// to preserve the order of external ports we use insertAt
		int insertAt = 0;
		for (ExternalPort p : ac.getExternalPorts()) {
			result.add(insertAt++, p.getInterfacePort());
		}

		return result;
	}
	
	/**
	 * Returns a list of {@link SAP}s of an {@link ActorClass}
	 * including base classes.
	 * 
	 * @param ac an {@link ActorClass}
	 * 
	 * @return a list of all end {@link SAP}s of an {@link ActorClass}
	 * 		with base class items first
	 */
	public List<SAP> getAllSAPs(ActorClass ac) {
		ArrayList<SAP> result = new ArrayList<SAP>();
		
		while (ac!=null) {
			result.addAll(0, ac.getServiceAccessPoints());
			ac = ac.getActorBase();
		}
		
		return result;
	}
	
	/**
	 * Returns a list of all (internal and external) end {@link ServiceImplementation}s of an {@link ActorClass}
	 * including base classes.
	 * 
	 * @param ac an {@link ActorClass}
	 * 
	 * @return a list of all end {@link ServiceImplementation}s of an {@link ActorClass}
	 * 		with base class items first
	 */
	public List<ServiceImplementation> getAllServiceImplementations(ActorClass ac) {
		ArrayList<ServiceImplementation> result = new ArrayList<ServiceImplementation>();
		
		while (ac!=null) {
			result.addAll(0, ac.getServiceImplementations());
			ac = ac.getActorBase();
		}
		
		return result;
	}
	
	/**
	 * Returns a list of all {@link Port}s of an {@link ActorClass}
	 * including base classes.
	 * 
	 * @param ac an {@link ActorClass}
	 * 
	 * @return a list of all end {@link Port}s of an {@link ActorClass}
	 * 		with base class items first
	 */
	public List<Port> getAllEndPorts(ActorClass ac) {
		ArrayList<Port> result = new ArrayList<Port>();
		
		while (ac!=null) {
			result.addAll(0, ac.getInternalPorts());
			
			// to preserve the order of external ports we use insertAt
			int insertAt = 0;
			for (ExternalPort p : ac.getExternalPorts()) {
				result.add(insertAt++, p.getInterfacePort());
			}
			
			ac = ac.getActorBase();
		}
		
		return result;
	}
    
	/**
	 * @param ac an {@link ActorClass}
	 * @return a list of the interface ports
	 */
	public List<Port> getInterfacePorts(ActorContainerClass ac) {
		if (ac instanceof ActorClass)
			return ((ActorClass) ac).getInterfacePorts();
		else if (ac instanceof SubSystemClass)
			return ((SubSystemClass) ac).getRelayPorts();

		assert (false) : "unexpected sub type";
		return null;
	}

	/**
	 * @param ac an {@link ActorClass}
	 * @return a list of the all interface ports <i>including</i> inherited with base
	 *         class ports first
	 * @see #getInterfaceItems(ActorClass)
	 */
	public List<Port> getAllInterfacePorts(ActorContainerClass ac) {
		if (ac instanceof ActorClass) {
			ArrayList<Port> result = new ArrayList<Port>();
			ActorClass curr = (ActorClass) ac;
			while (curr != null) {
				result.addAll(0, curr.getInterfacePorts());
				curr = curr.getActorBase();
			}
			return result;
		} else if (ac instanceof SubSystemClass)
			return ((SubSystemClass) ac).getRelayPorts();

		assert (false) : "unexpected sub type";
		return null;
	}
	
	/**
	 * @param ac an {@link ActorClass}
	 * @return a list of all interface items <i>without</i> inherited ones
	 * @see #getAllInterfaceItems(ActorClass)
	 */
	public List<InterfaceItem> getInterfaceItems(ActorClass ac) {
		ArrayList<InterfaceItem> result = new ArrayList<InterfaceItem>();

		result.addAll(ac.getInternalPorts());
		result.addAll(ac.getExternalEndPorts());
		result.addAll(ac.getServiceAccessPoints());
		result.addAll(ac.getImplementedSPPs());
		
		return result;
	}
	
	/**
	 * @param ac an {@link ActorClass}
	 * @return a list of {@link MessageFromIf} that may come in through one of the
	 * event driven interface items of this actor class (<i>without</i> inherited ones)
	 */
	public List<MessageFromIf> getMessagesFromInterfaces(ActorClass ac) {
		ArrayList<MessageFromIf> result = new ArrayList<MessageFromIf>();
		
		List<InterfaceItem> items = getInterfaceItems(ac);
		for (InterfaceItem item : items) {
			if (item.getGeneralProtocol() instanceof ProtocolClass) {
				ProtocolClass pc = (ProtocolClass) item.getGeneralProtocol();
				if (pc.getCommType()==CommunicationType.EVENT_DRIVEN) {
					for (Message msg : getIncoming(item)) {
						MessageFromIf mif = FSMFactory.eINSTANCE.createMessageFromIf();
						mif.setMessage(msg);
						mif.setFrom(item);
						result.add(mif);
					}
				}
			}
		}
		
		return result;
	}
	
	/**
	 * @param ac an {@link ActorClass}
	 * @return a list of {@link MessageFromIf} that may come in through one of the
	 * event driven interface items of this actor class (<i>with</i> inherited ones as far as a base class has its own state machine)
	 */
	public List<MessageFromIf> getOwnMessagesFromInterfaces(ActorClass ac) {
		ArrayList<MessageFromIf> result = new ArrayList<MessageFromIf>();
		
		result.addAll(getMessagesFromInterfaces(ac));
		ac = ac.getActorBase();
		while (ac!=null) {
			if (hasNonEmptyStateMachine(ac))
				break;
			
			List<InterfaceItem> items = getInterfaceItems(ac);
			for (InterfaceItem item : items) {
				if (item.getGeneralProtocol() instanceof ProtocolClass) {
					ProtocolClass pc = (ProtocolClass) item.getGeneralProtocol();
					if (pc.getCommType()==CommunicationType.EVENT_DRIVEN) {
						for (Message msg : getIncoming(item)) {
							MessageFromIf mif = FSMFactory.eINSTANCE.createMessageFromIf();
							mif.setMessage(msg);
							mif.setFrom(item);
							result.add(mif);
						}
					}
				}
			}
			
			ac = ac.getActorBase();
		}
		
		return result;
	}
	
	/**
	 * @param ac an {@link ActorClass}
	 * @return a list of {@link MessageFromIf} that may come in through one of the
	 * event driven interface items of this actor class(<i>including</i> inherited ones)
	 */
	public List<MessageFromIf> getAllMessagesFromInterfaces(ActorClass ac) {
		ArrayList<MessageFromIf> result = new ArrayList<MessageFromIf>();
		
		while (ac!=null) {
			List<InterfaceItem> items = getInterfaceItems(ac);
			for (InterfaceItem item : items) {
				if (item.getGeneralProtocol() instanceof ProtocolClass) {
					ProtocolClass pc = (ProtocolClass) item.getGeneralProtocol();
					if (pc.getCommType()==CommunicationType.EVENT_DRIVEN) {
						for (Message msg : getIncoming(item)) {
							MessageFromIf mif = FSMFactory.eINSTANCE.createMessageFromIf();
							mif.setMessage(msg);
							mif.setFrom(item);
							result.add(mif);
						}
					}
				}
			}
			
			ac = ac.getActorBase();
		}
		
		return result;
	}
	
	/**
	 * @param dc the data class to check
	 * @return {@code true} if the class hierarchy is circular (i.e. a base class refers to one of its sub classes)
	 */
	public boolean isCircularClassHierarchy(DataClass dc) {
		HashSet<DataClass> classes = new HashSet<DataClass>();
		classes.add(dc);
		
		while (dc.getBase()!=null) {
			dc = dc.getBase();
			if (classes.contains(dc))
				return true;
			
			classes.add(dc);
		}
		
		return false;
	}

	/**
	 * @param pc the protocol class to check
	 * @return {@code true} if the class hierarchy is circular (i.e. a base class refers to one of its sub classes)
	 */
	public boolean isCircularClassHierarchy(ProtocolClass pc) {
		HashSet<ProtocolClass> classes = new HashSet<ProtocolClass>();
		classes.add(pc);
		
		while (pc.getBase()!=null) {
			pc = pc.getBase();
			if (classes.contains(pc))
				return true;
			
			classes.add(pc);
		}
		
		return false;
	}
	
	/**
	 * Returns a list of all end {@link InterfaceItem}s of an {@link ActorClass}
	 * including base classes. I.e. all end ports, all SAPs and all non-relaying SPPs.
	 * 
	 * @param ac an {@link ActorClass}
	 * 
	 * @return a list of all end {@link InterfaceItem}s of an {@link ActorClass}
	 */
	public List<InterfaceItem> getAllInterfaceItems(ActorClass ac) {
		ArrayList<InterfaceItem> result = new ArrayList<InterfaceItem>();
		if (isCircularClassHierarchy(ac))
			return result;
		
		while (ac!=null) {
			result.addAll(ac.getInternalPorts());
			result.addAll(ac.getExternalEndPorts());
			result.addAll(ac.getServiceAccessPoints());
			result.addAll(ac.getImplementedSPPs());
			
			ac = ac.getActorBase();
		}
		
		return result;
	}
	
	/**
	 * Returns a list of all {@link Port}s of an {@link ActorClass}
	 * including base classes.
	 * 
	 * @param ac an {@link ActorClass}
	 * 
	 * @return a list of all {@link Port}s of an {@link ActorClass}
	 */
	public List<Port> getAllPorts(ActorClass ac) {
		ArrayList<Port> result = new ArrayList<Port>();
		if (isCircularClassHierarchy(ac))
			return result;
		
		while (ac!=null) {
			result.addAll(ac.getInternalPorts());
			result.addAll(ac.getInterfacePorts());
			
			ac = ac.getActorBase();
		}
		
		return result;
	}
	
	public List<ActorContainerRef> getAllActorContainerRefs(StructureClass sc) {
		List<ActorContainerRef> refs = new ArrayList<ActorContainerRef>();
		
		if(sc instanceof LogicalSystem)
			refs.addAll(((LogicalSystem)sc).getSubSystems());
		else if(sc instanceof ActorContainerClass) {
			refs.addAll(((ActorContainerClass)sc).getActorRefs());
			if(sc instanceof ActorClass){
				ActorClass base = (ActorClass)sc;
				while((base = base.getActorBase()) != null)
					refs.addAll(base.getActorRefs());
			}
		}
		
		return refs;
	}
	
	/**
	 * Returns a list of all {@link Binding}s of an {@link ActorClass}
	 * including base classes.
	 * 
	 * @param ac an {@link ActorClass}
	 * 
	 * @return a list of all {@link Binding}s of an {@link ActorClass}
	 */
	public List<Binding> getAllBindings(ActorClass ac) {
		ArrayList<Binding> result = new ArrayList<Binding>();
		if (isCircularClassHierarchy(ac))
			return result;
		
		while (ac!=null) {
			result.addAll(ac.getBindings());
			
			ac = ac.getActorBase();
		}
		
		return result;
	}
	
	/**
	 * Returns a list of all {@link LayerConnection}s of an {@link ActorClass}
	 * including base classes.
	 * 
	 * @param ac an {@link ActorClass}
	 * 
	 * @return a list of all {@link LayerConnection}s of an {@link ActorClass}
	 */
	public List<LayerConnection> getAllLayerConnections(ActorClass ac) {
		ArrayList<LayerConnection> result = new ArrayList<LayerConnection>();
		if (isCircularClassHierarchy(ac))
			return result;
		
		while (ac!=null) {
			result.addAll(ac.getConnections());
			
			ac = ac.getActorBase();
		}
		
		return result;
	}

	/**
	 * Returns the parent {@link ActorClass} of a {@link StateGraphItem}.
	 * 
	 * @param item a {@link StateGraphItem}
	 * 
	 * @return the parent {@link ActorClass} of a {@link StateGraphItem}
	 */
	public ActorClass getActorClass(StateGraphItem item) {
		EObject parent = item;
		while (parent!=null) {
			parent = parent.eContainer();
			if (parent instanceof ActorClass)
				return (ActorClass) parent;
		}
		assert(false): "data structure broken";
		return null;
	}
	
	/**
	 * Returns the parent {@link ActorClass} of an arbitrary EObject (result may be null).
	 * 
	 * @param obj an {@link EObject}
	 * 
	 * @return the parent {@link ActorClass} of an arbitrary EObject (result may be null)
	 */
	public ActorClass getActorClass(EObject obj) {
		EObject parent = obj;
		while (parent!=null) {
			parent = parent.eContainer();
			if (parent instanceof ActorClass)
				return (ActorClass) parent;
		}
		return null;
	}

	/**
	 * @param obj an {@link EObject}
	 * @return the {@link RoomClass} containing this object or null
	 */
	public RoomClass getRoomClass(EObject obj) {
		while (obj!=null) {
			if (obj instanceof RoomClass) {
				return (RoomClass) obj;
			}
			obj = obj.eContainer();
		}
		return null;
	}
	
	/**
	 * Returns the parent {@link ProtocolClass} of an arbitrary EObject (result may be null).
	 * 
	 * @param obj an {@link EObject}
	 * 
	 * @return the parent {@link ProtocolClass} of an arbitrary EObject (result may be null)
	 */
	public ProtocolClass getProtocolClass(EObject obj) {
		EObject ctx = obj.eContainer();
		while (!(ctx instanceof ProtocolClass) && ctx.eContainer()!=null)
			ctx = ctx.eContainer();
		if (ctx instanceof ProtocolClass)
			return (ProtocolClass) ctx;
		
		return null;
	}
	
	/**
	 * <code>true</code> if the named annotation is present in the {@link ActorClass}.
	 * 
	 * @param ac the {@link ActorClass}
	 * @param name the name to be searched
	 * 
	 * @return <code>true</code> if the named annotation is present in the {@link ActorClass}
	 */
	public boolean isAnnotationPresent(ActorClass ac, String name) {
		return isAnnotationPresent(ac.getAnnotations(), name);
	}
	
	/**
	 * <code>true</code> if the named annotation is present in the <em>behavior</em>
	 * of the {@link ActorClass}.
	 * 
	 * @param ac the {@link ActorClass}
	 * @param name the name to be searched
	 * 
	 * @return <code>true</code> if the named annotation is present in the <em>behavior</em>
	 * of the {@link ActorClass}
	 */
	public boolean isBehaviorAnnotationPresent(ActorClass ac, String name) {
		return isAnnotationPresent(ac.getBehaviorAnnotations(), name);
	}
	
	/**
	 * Returns a list of the {@link Annotation} attributes of the named annotation.
	 * Returns an empty list if no such annotation is found.
	 * 
	 * @param ac the {@link ActorClass}
	 * @param name the name to be searched
	 * 
	 * @return a list of the {@link Annotation} attributes of the named annotation
	 */
	public List<KeyValue> getAttributes(ActorClass ac, String name) {
		return getAttributes(ac.getAnnotations(), name);
	}
	
	
	/**
	 * Returns a list of the <em>behavior</em> {@link Annotation} attributes of the named annotation.
	 * Returns an empty list if no such annotation is found.
	 * 
	 * @param ac the {@link ActorClass}
	 * @param name the name to be searched
	 * 
	 * @return a list of the {@link Annotation} attributes of the named annotation
	 */
	public List<KeyValue> getBehaviorAttributes(ActorClass ac, String name) {
		return getAttributes(ac.getBehaviorAnnotations(), name);
	}
	
	/**
	 * Searches the annotation attributes of an {@link ActorClass} for a given name.
	 *  
	 * @param ac the actor class
	 * @param name the annotation name
	 * @param key the attribute name
	 * 
	 * @return <code>true</code> if such an attribute is present
	 * 
	 * @see #isBehaviorAttributePresent(ActorClass, String, String)
	 */
	public boolean isAttributePresent(ActorClass ac, String name, String key) {
		return isAttributePresent(ac.getAnnotations(), name, key);
	}
	
	/**
	 * Searches the behavior annotation attributes of an {@link ActorClass} for a given name.
	 *  
	 * @param ac the actor class
	 * @param name the annotation name
	 * @param key the attribute name
	 * 
	 * @return <code>true</code> if such an attribute is present
	 * 
	 * @see #isAttributePresent(ActorClass, String, String)
	 */
	public boolean isBehaviorAttributePresent(ActorClass ac, String name, String key) {
		return isAttributePresent(ac.getBehaviorAnnotations(), name, key);
	}
	
	/**
	 * Returns the value of an annotation attribute of an {@link ActorClass}
	 * 
	 * @param ac the actor class
	 * @param name the annotation name
	 * @param key the attribute name
	 * 
	 * @return the string value of the attribute or an empty string if not found
	 */
	public String getAttribute(ActorClass ac, String name, String key) {
		return getAttribute(ac.getAnnotations(), name, key);
	}
	
	/**
	 * Returns the value of an behavior annotation attribute of an {@link ActorClass}
	 * 
	 * @param ac the actor class
	 * @param name the annotation name
	 * @param key the attribute name
	 * 
	 * @return the string value of the attribute or an empty string if not found
	 */
	public String getBehaviorAttribute(ActorClass ac, String name, String key) {
		return getAttribute(ac.getBehaviorAnnotations(), name, key);
	}
	
	/**
	 * Computes a list of all messages that can be received or sent by an {@link InterfaceItem}
	 * (i.e. {@link Port}, {@link SAP} or {@link SPP}.
	 * 
	 * @param item the interface item
	 * @param outgoing <code>true</code> for outgoing, <code>false</code> for incoming
	 * 
	 * @return a list of all messages
	 * 
	 * @see #getAllMessages(ProtocolClass, boolean)
	 */
	public List<Message> getMessageListDeep(InterfaceItem item, boolean outgoing) {
		ProtocolClass protocol = null;
		if (item instanceof Port) {
			if (!(((Port) item).getProtocol() instanceof ProtocolClass)) {
				// end ports (for which this is called) can have no CompoundProtocolClass
				assert(false): "unexpected protocol type";
				return null;
			}
			
			protocol = (ProtocolClass) ((Port) item).getProtocol();
			if (((Port) item).isConjugated())
				outgoing = !outgoing;
		}
		else if (item instanceof SAP) {
			outgoing = !outgoing;
			protocol = ((SAP)item).getProtocol();
		}
		else if (item instanceof SPP) {
			protocol = ((SPP)item).getProtocol();
		}
		else {
			assert(false): "unexpected sub type";
			return null;
		}
		
		return getAllMessages(protocol, !outgoing);
	}
	
	/**
	 * Returns the {@link PortClass} associated with an {@link InterfaceItem}
	 * (i.e. {@link Port}, {@link SAP} or {@link SPP}.
	 * For regular ports this is the regular PortClass of the associated {@link ProtocolClass}.
	 * 
	 * @param item the interface item
	 * 
	 * @return the PortClass or null if not defined
	 */
	public PortClass getPortClass(InterfaceItem item) {
		ProtocolClass protocol = null;
		boolean conjugated = false;
		if (item instanceof Port) {
			if (!(((Port) item).getProtocol() instanceof ProtocolClass)) {
				// end ports (for which this is called) can have no CompoundProtocolClass
				assert(false): "unexpected protocol type";
				return null;
			}
			
			protocol = (ProtocolClass) ((Port) item).getProtocol();
			conjugated = ((Port) item).isConjugated();
		}
		else if (item instanceof SAP) {
			protocol = ((SAP)item).getProtocol();
			conjugated = true;
		}
		else if (item instanceof SPP) {
			protocol = ((SPP)item).getProtocol();
		}
		else {
			assert(false): "unexpected sub type";
			return null;
		}
		
		return conjugated? protocol.getConjugated():protocol.getRegular();
	}
	
	/**
	 * returns true if this is a relay port
	 * 
	 * @param port
	 * @return true if relay port
	 */
	public boolean isRelay(Port port) {
		ActorContainerClass acc = (ActorContainerClass) port.eContainer();
		if (acc instanceof ActorClass) {
			if (((ActorClass)acc).getInterfacePorts().contains(port)) {
				for (ExternalPort xp : ((ActorClass)acc).getExternalPorts()) {
					if (xp.getInterfacePort()==port)
						return false;
				}
				return true;
			}
			return false;
		}
		else
			return true;
	}
	
	/**
	 * Returns true if this is an internal port.
	 * 
	 * @param port
	 * @return true if internal port
	 */
	public boolean isInternal(Port port) {
		ActorContainerClass acc = (ActorContainerClass) port.eContainer();
		if (acc instanceof ActorClass) {
			if (((ActorClass)acc).getInternalPorts().contains(port)) {
				return true;
			}
			return false;
		}
		else
			return false;
	}
	
	/**
	 * Returns true if this is an external port.
	 * 
	 * @param port
	 * @return true if external port
	 */
	public boolean isExternal(Port port) {
		ActorContainerClass acc = (ActorContainerClass) port.eContainer();
		if (acc instanceof ActorClass) {
			for (ExternalPort ep : ((ActorClass)acc).getExternalPorts()) {
				if (ep.getInterfacePort()==port) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Returns <code>true</code> if an operation is a constructor.
	 * This is the case if the operation's name coincides with it's class's name
	 * and if it is no destructor (destructor flag set).
	 * 
	 * @param op the operation
	 * 
	 * @return <code>true</code> if the operation is a constructor
	 */
	public boolean isConstructor(Operation op) {
		if (op instanceof PortOperation)
			return false;
		
		RoomClass cls = (RoomClass) op.eContainer();
		if (cls.getName().equals(op.getName()))
			return !((StandardOperation)op).isDestructor();
		
		return false;
	}
	
	/**
	 * Returns <code>true</code> if an operation is a destructor.
	 * This is the case if the operation's name coincides with it's class's name
	 * and if its destructor flag set.
	 * 
	 * @param op the operation
	 * 
	 * @return <code>true</code> if the operation is a destructor
	 */
	public boolean isDestructor(Operation op) {
		if (op instanceof PortOperation)
			return false;
		
		RoomClass cls = (RoomClass) op.eContainer();
		if (cls.getName().equals(op.getName()))
			return ((StandardOperation)op).isDestructor();
		
			return false;
	}
	
	/**
	 * Checks whether an {@link ActorClass} has a constructor operation defined.
	 * 
	 * @param ac the actor class
	 * 
	 * @return <code>true</code> if the actor class has a constructor
	 */
	public boolean hasConstructor(ActorClass ac) {
		for (StandardOperation op : ac.getOperations()) {
			if (op.getName().equals(ac.getName()))
				if (!op.isDestructor())
					return true;
				}
		
		return false;
	}

	/**
	 * Checks whether an {@link ActorClass} has a destructor operation defined.
	 * 
	 * @param ac the actor class
	 * 
	 * @return <code>true</code> if the actor class has a destructor
	 */
	public boolean hasDestructor(ActorClass ac) {
		for (StandardOperation op : ac.getOperations()) {
			if (op.getName().equals(ac.getName()))
				if (op.isDestructor())
					return true;
		}
		
		return false;
	}
	
	/**
	 * Returns the {@link ProtocolClass} of an {@link InterfaceItem}.
	 * In case of a relay port with a CompoundProtocolClass <code>null</code> is returned.
	 * 
	 * @param item the interface item
	 * 
	 * @return the {@link ProtocolClass} of an {@link InterfaceItem}
	 */
	public ProtocolClass getProtocol(InterfaceItem item) {
		GeneralProtocolClass pc = getGeneralProtocol(item);
		if (pc instanceof ProtocolClass)
			return (ProtocolClass) pc;
			else
				return null;
	}
	
	/**
	 * Returns {@code true} if the interface item is data driven (i.e. has a data driven {@link ProtocolClass}.
	 * 
	 * @param item an {@link InterfaceItem}
	 * @return {@code true} if the interface item is data driven (i.e. has a data driven {@link ProtocolClass}
	 */
	public boolean isDataDriven(InterfaceItem item) {
		ProtocolClass pc = getProtocol(item);
		if (pc!=null && pc.getCommType()==CommunicationType.DATA_DRIVEN)
			return true;
		
		return false;
	}
	
	/**
	 * Returns the {@link GeneralProtocolClass} of an {@link InterfaceItem}.
	 * 
	 * @param item the interface item
	 * 
	 * @return the {@link GeneralProtocolClass} of an {@link InterfaceItem}
	 */
	public GeneralProtocolClass getGeneralProtocol(InterfaceItem item) {
		if (item instanceof Port) {
			return ((Port)item).getProtocol();
		}
		else if (item instanceof SAP)
			return ((SAP)item).getProtocol();
		else if (item instanceof SPP)
			return ((SPP)item).getProtocol();
		
		assert(item.eIsProxy()): "unexpected sub type";
		return null;
	}

	/**
	 * Returns the recursive base class entry code of a {@link RefinedState} as string.
	 * 
	 * @param state the state
	 * 
	 * @return the recursive base class entry code of a {@link RefinedState} as string
	 */
	public String getBaseEntryCode(RefinedState state) {
		return getBaseCode(state, FSMPackage.Literals.STATE__ENTRY_CODE);
	}

	/**
	 * Returns the recursive base class exit code of a {@link RefinedState} as string.
	 * 
	 * @param state the state
	 * 
	 * @return the recursive base class exit code of a {@link RefinedState} as string
	 */
	public String getBaseExitCode(RefinedState state) {
		return getBaseCode(state, FSMPackage.Literals.STATE__EXIT_CODE);
	}

	/**
	 * Returns the recursive base class do code of a {@link RefinedState} as string.
	 * 
	 * @param state the state
	 * 
	 * @return the recursive base class do code of a {@link RefinedState} as string
	 */
	public String getBaseDoCode(RefinedState state) {
		return getBaseCode(state, FSMPackage.Literals.STATE__DO_CODE);
	}
	
	private String getBaseCode(RefinedState state, EStructuralFeature feat) {
		StringBuilder result = new StringBuilder();
		
		State base = state.getTarget();
		while (base!=null) {
			String code = getDetailCode((DetailCode) base.eGet(feat));
			result.append(code);
			if (base instanceof RefinedState)
				base = ((RefinedState)base).getTarget();
			else
				break;
		}
		return result.toString();
	}

	/**
	 * Determines the last common super type of a list of types or <code>null</code> if no such exists.
	 * If a  {@link RefableType} is returned then it is an independent copy not part of the model.
	 * 
	 * @param types a list of {@link RefableType}s
	 * 
	 * @return the last common super type of a list of types or <code>null</code> if no such exists
	 */
	public RefableType getLastCommonSuperType(List<RefableType> types) {
		int nref = 0;
		int ndc = 0;
		for (RefableType rt : types) {
			if (rt==null)
				// no data
				return null;
			
			if (rt.getType() instanceof DataClass)
				++ndc;
			
			if (rt.isRef())
				++nref;
		}
		
		// all or none can be ref
		if (!(nref==0 || nref==types.size()))
			return null;
		
		if (ndc==0) {
			// in this case all types have to be the same
			DataType type = types.get(0).getType();
			for (RefableType rt : types) {
				if (rt.getType()!=type)
					return null;
			}
			return EcoreUtil.copy(types.get(0));
		}
		else if (ndc==types.size()) {
			// in this case we have to find a common super type
			ArrayList<ArrayList<DataClass>> allSuperTypes = new ArrayList<ArrayList<DataClass>>();
			for (RefableType rt : types) {
				DataClass dc = (DataClass) rt.getType();
				ArrayList<DataClass> superTypes = new ArrayList<DataClass>();
				allSuperTypes.add(superTypes);
				
				// add base classes first
				while (dc!=null) {
					superTypes.add(0, dc);
					dc = dc.getBase();
				}
			}
			int min = allSuperTypes.get(0).size();
			DataClass common = allSuperTypes.get(0).get(0);
			for (ArrayList<DataClass> superTypes : allSuperTypes) {
				min = Math.min(min, superTypes.size());
				if (superTypes.get(0)!=common)
					return null;
			}
			
			// common is a candidate
			
			// lets try to improve
			tryImprove:
				for (int idx = 1; idx<min; ++idx) {
					DataClass better = allSuperTypes.get(0).get(idx);
					for (ArrayList<DataClass> superTypes : allSuperTypes) {
						if (superTypes.get(idx)!=better)
							break tryImprove;
					}
					common = better;
				}
			
			RefableType rt = RoomFactory.eINSTANCE.createRefableType();
			rt.setRef(nref>0);
			rt.setType(common);
			return rt;
		}
		
		return null;
	}

	/**
	 * Returns the recursive base class code of a transition.
	 * 
	 * @param trans the transition
	 * @param ac the actor class
	 * 
	 * @return the recursive base class code of a transition
	 */
	public String getInheritedActionCode(Transition trans, ActorClass ac) {
		return getActionCode(trans, ac, false);
	}

	/**
	 * @param sg a {@link StateGraph}
	 * @return the initial transition or <code>null</code> if no such is available
	 */
	public Transition getInitTransition(StateGraph sg) {
		for (Transition tr : sg.getTransitions()) {
			if (tr instanceof InitialTransition)
				return tr;
		}
		return null;
	}
	
	/**
	 * @param sg a {@link StateGraph}
	 * @return <code>true</code> if an initial transition is available
	 */
	public boolean hasInitTransition(StateGraph sg) {
		return getInitTransition(sg)!=null;
	}
	
	/**
	 * Returns the complete action code including base class code of a {@link Transition}.
	 * 
	 * @param trans the transition
	 * @param ac the actor class
	 * 
	 * @return the complete action code including base class code of a {@link Transition}
	 */
	public String getAllActionCode(Transition trans, ActorClass ac) {
		return getActionCode(trans, ac, true);
	}
	
	private String getActionCode(Transition trans, ActorClass ac, boolean includeOwn) {
		StringBuilder result = new StringBuilder();
		
		ActorClass baseAC = getActorClass(trans);
		
		if (!includeOwn) {
			if (ac==baseAC)
				return null;
			ac = ac.getActorBase();
		}
		
		while (ac!=null) {
			if (ac==baseAC) {
				result.insert(0, getDetailCode(trans.getAction()));
				return result.toString();
			}
			
			if (ac.getStateMachine()!=null)
				for (RefinedTransition rt : ac.getStateMachine().getRefinedTransitions()) {
					if (rt.getTarget()==trans)
						result.insert(0, getDetailCode(rt.getAction()));
				}
			
			ac = ac.getActorBase();
		}
		
		return null;
	}
	
	/**
	 * Returns the parent container of an {@link ActorInstanceMapping}.
	 * 
	 * @param aim the actor instance mapping
	 * 
	 * @return the parent container of an {@link ActorInstanceMapping}
	 */
	public ActorContainerClass getParentContainer(ActorInstanceMapping aim) {
		ActorContainerClass root = null;
		if (aim.eContainer() instanceof ActorInstanceMapping) {
			ActorInstanceMapping parent = (ActorInstanceMapping) aim.eContainer();
			root = getActorContainerClass(parent);
		}
		else if (aim.eContainer() instanceof SubSystemClass) {
			root = (SubSystemClass) aim.eContainer();
		}
		return root;
	}

	/**
	 * Return the target {@link ActorContainerClass} of an instance mapping.
	 * 
	 * @param aim the actor instance mapping
	 * 
	 * @return the target {@link ActorContainerClass} of an instance mapping
	 */
	public ActorContainerClass getActorContainerClass(ActorInstanceMapping aim) {
		// follow segments
		ActorContainerClass result = getParentContainer(aim);
		for (RefSegment ref : aim.getPath().getRefs()) {
			ActorRef match = null;
			for (ActorContainerRef actor : getRefs(result, true)) {
				if (actor instanceof ActorRef && actor.getName().equals(ref.getRef())) {
					match = (ActorRef) actor;
					break;
				}
			}

			if (match == null)
				return null;
			
			result = match.getType();
		}

		return result;
	}
	
	/**
	 * Returns a {@link RefPath} as string.
	 * 
	 * @param path the reference path of a mapping
	 * 
	 * @return a {@link RefPath} as string
	 */
	public String asString(RefPath path) {
		StringBuilder sb = new StringBuilder();
		for (RefSegment ref : path.getRefs()) {
			sb.append("/"+ref);
		}
		return sb.toString();
	}
	
	/**
	 * Returns the last {@link ActorRef} of a {@link RefPath} relative to a
	 * {@link ActorContainerClass}.
	 * 
	 * @param root the starting point (an {@link ActorContainerClass})
	 * @param path the path of actor references
	 * 
	 * @return the last {@link ActorRef} of a {@link RefPath}
	 */
	public ActorRef getLastActorRef(ActorContainerClass root, RefPath path) {
		if (path.getRefs().isEmpty())
			return null;
		
		ActorRef lastMatch = null;
		ActorContainerClass result = root;
		for (RefSegment ref : path.getRefs()) {
			ActorRef match = null;
			for (ActorContainerRef actor : getRefs(result, true)) {
				if (actor instanceof ActorRef && actor.getName().equals(ref.getRef())) {
					match = (ActorRef) actor;
					break;
				}
			}

			if (match == null)
				return null;
			
			result = match.getType();
			lastMatch = match;
		}

		return lastMatch;
	}

	/**
	 * returns first invalid path segment else {@code null}
	 * 
	 * @param root
	 * @param path
	 * @return first invalid path segment else {@code null}
	 */
	public String checkPath(ActorContainerClass root, RefPath path) {
		if (path == null)
			return null;

		ActorContainerClass last = root;
		Iterator<RefSegment> it = path.getRefs().iterator();
		RefSegment ref;
		while (it.hasNext()) {
			ref = it.next();
			// actor
			ActorRef match = null;
			for (ActorRef actor : last.getActorRefs()) {
				if (actor.getName().equals(ref.getRef())) {
					match = actor;
					break;
				}
			}
			// port
			List<InterfaceItem> ifs = new ArrayList<InterfaceItem>();
			ifs.addAll(last.getServiceProvisionPoints());
			if (last instanceof ActorClass) {
				ActorClass actor = (ActorClass) last;
				ifs.addAll(actor.getInterfacePorts());
				ifs.addAll(actor.getInternalPorts());
			}
			if (last instanceof SubSystemClass)
				ifs.addAll(((SubSystemClass) last).getRelayPorts());
			for (InterfaceItem item : ifs) {
				// not nested, quit if last segment
				if (item.getName().equals(ref) && !it.hasNext())
					return null;
			}
			if (match == null)
				return ref.getRef();
			
			if (match.getMultiplicity()==1) {
				if (ref.getIdx()!=-1)
					return ref.toString()+" (ref not indexed )";
			}
			else {
				if (ref.getIdx()<0)
					return ref.toString()+" (ref needs index)";
				if (ref.getIdx()>=match.getMultiplicity())
					return ref.toString()+" (index out of bounds)";
			}
			
			last = match.getType();
		}

		return null;
	}

	/**
	 * checks whether pc1 is derived from (but not equal) pc2
	 * 
	 * @param pc1 potential sub class
	 * @param pc2 potential super class
	 * 
	 * @return true if pc1 is derived from pc2
	 */
	public boolean isDerivedFrom(ProtocolClass pc1, ProtocolClass pc2) {
		if (pc1==pc2)
			return false;
		
		while (pc1!=null) {
			if (pc1==pc2)
				return true;
			pc1 = pc1.getBase();
		}
		return false;
	}

	/**
	 * check whether ac2 is super type of ac1 
	 * @param ac1
	 * @param ac2
	 * @return <code>true</code> if ac1 or one of its base types is identical to ac2
	 */
	public boolean isKindOf(ActorClass ac1, ActorClass ac2) {
		if (ac2==null)
			return false;

		if (ac1==null || isCircularClassHierarchy(ac1))
			return false;
		
		while (ac1!=null) {
			if (ac2==ac1)
				return true;
			
			ac1 = ac1.getActorBase();
		}
		return false;
	}
	
	/**
	 * check if ref recursively is referencing ac
	 * @param ref
	 * @param ac
	 * @return <code>true</code> if ref recursively is referencing ac
	 */
	public boolean isReferencing(ActorClass ref, ActorClass ac) {
		if (isKindOf(ref,ac))
			return true;
		
		Set<ActorClass> visited = new HashSet<ActorClass>();
		LinkedList<ActorClass> stack = new LinkedList<ActorClass>();
		visited.add(ac);
		stack.push(ref);
		
		ActorClass next;
		while(!stack.isEmpty()){
			next = stack.pop();
			if(visited.contains(next))
				continue;
			
			for (ActorRef ar : next.getActorRefs()) {
				if (isKindOf(ar.getType(), ac) || isKindOf(next, ar.getType()))
					return true;
				stack.push(ar.getType());
			}
			visited.add(next);
		}
		
		return false;
	}
}
