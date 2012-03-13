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
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.Annotation;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.KeyValue;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.Trigger;
import org.eclipse.etrice.core.room.VarDecl;

/**
 * description
 *
 * @author Henrik Rentz-Reichert initial contribution and API
 *
 */
public class RoomHelpers {
	
	public static List<InterfaceItem> getInterfaceItems(StructureClass sc, boolean includeInherited) {
		ArrayList<InterfaceItem> result = new ArrayList<InterfaceItem>();
		
		if (sc instanceof ActorClass) {
			ActorClass ac = (ActorClass) sc;
			do {
				result.addAll(ac.getIfSPPs());
				result.addAll(ac.getIfPorts());
				ac = ac.getBase();
			}
			while (includeInherited && ac!=null);
		}
		else if (sc instanceof SubSystemClass) {
			result.addAll(((SubSystemClass) sc).getIfSPPs());
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

	public static List<ActorContainerRef> getRefs(StructureClass sc, boolean includeInherited) {
		ArrayList<ActorContainerRef> result = new ArrayList<ActorContainerRef>();

		if (sc instanceof ActorClass) {
			ActorClass ac = (ActorClass) sc;
			do {
				result.addAll(ac.getActorRefs());
				ac = ac.getBase();
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
	
	public static List<Binding> getBindings(StructureClass sc, boolean includeInherited) {
		ArrayList<Binding> result = new ArrayList<Binding>();

		if (sc instanceof ActorClass) {
			ActorClass ac = (ActorClass) sc;
			do {
				result.addAll(ac.getBindings());
				ac = ac.getBase();
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
	
	public static List<LayerConnection> getConnections(StructureClass sc, boolean includeInherited) {
		ArrayList<LayerConnection> result = new ArrayList<LayerConnection>();

		if (sc instanceof ActorClass) {
			ActorClass ac = (ActorClass) sc;
			do {
				result.addAll(ac.getConnections());
				ac = ac.getBase();
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
	
	public static List<EObject> getContainedObjects(StructureClass sc) {
		ArrayList<EObject> result = new ArrayList<EObject>();
		
		result.addAll(getInterfaceItems(sc, true));
		result.addAll(getRefs(sc, true));
		result.addAll(getBindings(sc, true));
		result.addAll(getConnections(sc, true));
		
		return result;
	}

	public static boolean hasSubStructure(State state, ActorClass ac) {
		if (hasDirectSubStructure(state))
			return true;
		
		if (ac.getStateMachine()!=null) {
			for (State s : ac.getStateMachine().getStates()) {
				State predecessor = s;
				while (predecessor instanceof RefinedState) {
					predecessor = ((RefinedState) s).getBase();
					if (predecessor==state) {
						// we have a chain form s -> state
						// check this chain
						predecessor = s;
						while (predecessor instanceof RefinedState) {
							if (hasDirectSubStructure(predecessor))
								return true;
							predecessor = ((RefinedState) s).getBase();
							if (predecessor==state)
								break;
						}
						break;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean hasDirectSubStructure(State s) {
		return !isEmpty(s.getSubgraph());
	}

	public static boolean hasNonEmptyStateMachine(ActorClass ac) {
		return isEmpty(ac.getStateMachine());
	}
	
	private static boolean isEmpty(StateGraph sg) {
		if (sg==null)
			return true;
		
		if (!sg.getStates().isEmpty())
			return false;
		if (!sg.getTransitions().isEmpty())
			return false;
		if (!sg.getTrPoints().isEmpty())
			return false;
		if (!sg.getChPoints().isEmpty())
			return false;
		
		return true;
	}

	/**
	 * @param state
	 * @param ac
	 * @return
	 */
	public static State getTargettingState(State state, ActorClass ac) {
		State targetting = state;
		for (State s : ac.getStateMachine().getStates()) {
			State predecessor = s;
			while (predecessor instanceof RefinedState) {
				predecessor = ((RefinedState) s).getBase();
				if (predecessor==state)
					targetting = s;
			}
		}
		return targetting;
	}
	
	public static boolean hasDetailCode(DetailCode dc) {
		if (dc==null)
			return false;
		if (dc.getCommands().isEmpty())
			return false;
		
		return true;
	}

	/**
	 * @param action
	 * @return
	 */
	public static String getDetailCode(DetailCode dc) {
		if (dc==null)
			return "";
		if (dc.getCommands().isEmpty())
			return "";
		
		Iterator<String> it = dc.getCommands().iterator();
		StringBuilder result = new StringBuilder(it.next());
		while (it.hasNext()) {
			result.append("\n").append(it.next());
		}
		
		return result.toString();
	}

	public static boolean isGuarded(Trigger trig) {
		return trig.getGuard()!=null && RoomHelpers.hasDetailCode(trig.getGuard().getGuard());
	}
	public static List<State> getAllStates(StateGraph sg) {
		return getAllStateGraphItems(sg, RoomPackage.eINSTANCE.getStateGraph_States());
	}

	public static List<TrPoint> getAllTrPoints(StateGraph sg) {
		return getAllStateGraphItems(sg, RoomPackage.eINSTANCE.getStateGraph_TrPoints());
	}

	public static List<ChoicePoint> getAllChoicePoints(StateGraph sg) {
		return getAllStateGraphItems(sg, RoomPackage.eINSTANCE.getStateGraph_ChPoints());
	}

	public static List<Transition> getAllTransitions(StateGraph sg) {
		return getAllStateGraphItems(sg, RoomPackage.eINSTANCE.getStateGraph_Transitions());
	}
	
	@SuppressWarnings("unchecked")
	private static <T extends StateGraphItem> List<T> getAllStateGraphItems(StateGraph sg, EReference feature) {
		ArrayList<T> result = new ArrayList<T>();
		
		do {
			Object items = sg.eGet(feature);
			if (items instanceof List<?>)
				result.addAll((List<? extends T>) items);
			
			if (sg.eContainer() instanceof RefinedState) {
				sg = ((RefinedState)sg.eContainer()).getBase().getSubgraph();
			}
			else if (sg.eContainer() instanceof ActorClass) {
				ActorClass base = ((ActorClass)sg.eContainer()).getBase();
				sg = base!=null? base.getStateMachine():null;
			}
			else {
				break;
			}
		}
		while (sg!=null);
		
		return result;
	}
	
	public static Set<String> getAllNames(StateGraph sg) {
		return getAllNames(sg, null);
	}
	
	public static Set<String> getAllNames(StateGraph sg, StateGraphItem skip) {
		HashSet<String> result = new HashSet<String>();
		do {
			for (State st : sg.getStates()) {
				if (st!=skip)
					result.add(st.getName());
			}
			for (TrPoint tp : sg.getTrPoints()) {
				if (tp!=skip)
					result.add(tp.getName());
			}
			for (ChoicePoint cp : sg.getChPoints()) {
				if (cp!=skip)
					result.add(cp.getName());
			}
			for (Transition tr : sg.getTransitions()) {
				if (tr!=skip)
					result.add(tr.getName());
			}
			
			if (sg.eContainer() instanceof RefinedState) {
				sg = ((RefinedState)sg.eContainer()).getBase().getSubgraph();
			}
			else if (sg.eContainer() instanceof ActorClass) {
				ActorClass base = ((ActorClass)sg.eContainer()).getBase();
				sg = base!=null? base.getStateMachine():null;
			}
			else {
				break;
			}
		}
		while (sg!=null);
		
		return result;
	}
	
	public static Set<String> getAllStateNames(StateGraph sg) {
		return getAllNames(sg, null, RoomPackage.eINSTANCE.getStateGraph_States());
	}

	public static Set<String> getAllStateNames(StateGraph sg, State skip) {
		return getAllNames(sg, skip, RoomPackage.eINSTANCE.getStateGraph_States());
	}
	
	public static Set<String> getAllTrPointNames(StateGraph sg) {
		return getAllNames(sg, null, RoomPackage.eINSTANCE.getStateGraph_TrPoints());
	}
	
	public static Set<String> getAllTrPointNames(StateGraph sg, TrPoint skip) {
		return getAllNames(sg, skip, RoomPackage.eINSTANCE.getStateGraph_TrPoints());
	}
	
	public static Set<String> getAllChoicePointNames(StateGraph sg) {
		return getAllNames(sg, null, RoomPackage.eINSTANCE.getStateGraph_ChPoints());
	}
	
	public static Set<String> getAllChoicePointNames(StateGraph sg, ChoicePoint skip) {
		return getAllNames(sg, skip, RoomPackage.eINSTANCE.getStateGraph_ChPoints());
	}
	
	public static Set<String> getAllTransitionNames(StateGraph sg) {
		return getAllNames(sg, null, RoomPackage.eINSTANCE.getStateGraph_Transitions());
	}
	
	public static Set<String> getAllTransitionNames(StateGraph sg, Transition skip) {
		return getAllNames(sg, skip, RoomPackage.eINSTANCE.getStateGraph_Transitions());
	}

	/*
	public static Set<String> getAllNames(StateGraph sg, StateGraphItem skip) {
		if (skip instanceof Transition)
			return getAllNames(sg, skip, RoomPackage.eINSTANCE.getStateGraph_Transitions());
		else if (skip instanceof State)
			return getAllNames(sg, skip, RoomPackage.eINSTANCE.getStateGraph_States());
		else if (skip instanceof ChoicePoint)
			return getAllNames(sg, skip, RoomPackage.eINSTANCE.getStateGraph_ChPoints());
		else if (skip instanceof TrPoint)
			return getAllNames(sg, skip, RoomPackage.eINSTANCE.getStateGraph_TrPoints());
		
		return Collections.emptySet();
	}
	*/
	
	private static <T extends StateGraphItem> Set<String> getAllNames(StateGraph sg, T skip, EReference feature) {
		List<T> states = RoomHelpers.getAllStateGraphItems(sg, feature);
		
		HashSet<String> names = new HashSet<String>();
		for (T s : states) {
			if (s!=skip)
				names.add(s.getName());
		}
		
		return names;
	}
	
	public static List<Attribute> getAllAttributes(ActorClass ac) {
		ArrayList<Attribute> result = new ArrayList<Attribute>();
		
		while (ac!=null) {
			result.addAll(ac.getAttributes());
			
			ac = ac.getBase();
		}
		
		return result;
	}
	
	public static List<Operation> getAllOperations(ActorClass ac) {
		ArrayList<Operation> result = new ArrayList<Operation>();
		
		while (ac!=null) {
			result.addAll(ac.getOperations());
			
			ac = ac.getBase();
		}
		
		return result;
	}
	
	public static List<Port> getAllEndPorts(ActorClass ac) {
		ArrayList<Port> result = new ArrayList<Port>();
		
		while (ac!=null) {
			result.addAll(ac.getIntPorts());
			for (ExternalPort p : ac.getExtPorts()) {
				result.add(p.getIfport());
			}
			
			ac = ac.getBase();
		}
		
		return result;
	}
	
	public static List<InterfaceItem> getAllInterfaceItems(ActorClass ac) {
		ArrayList<InterfaceItem> result = new ArrayList<InterfaceItem>();
		
		while (ac!=null) {
			result.addAll(ac.getIntPorts());
			for (ExternalPort p : ac.getExtPorts()) {
				result.add(p.getIfport());
			}
			result.addAll(ac.getStrSAPs());
			for (ServiceImplementation svc : ac.getServiceImplementations()) {
				result.add(svc.getSpp());
			}
			
			ac = ac.getBase();
		}
		
		return result;
	}
	
	public static ActorClass getActorClass(StateGraphItem item) {
		EObject parent = item;
		while (parent!=null) {
			parent = parent.eContainer();
			if (parent instanceof ActorClass)
				return (ActorClass) parent;
		}
		assert(false): "data structure broken";
		return null;
	}
	
	public static ActorClass getActorClass(EObject obj) {
		EObject parent = obj;
		while (parent!=null) {
			parent = parent.eContainer();
			if (parent instanceof ActorClass)
				return (ActorClass) parent;
		}
		return null;
	}
	
	/**
	 * first container of type {@link ProtocolClass}
	 * @param obj
	 * @return ActorClass container
	 */
	public static ProtocolClass getProtocolClass(EObject obj) {
		EObject ctx = obj.eContainer();
		while (!(ctx instanceof ProtocolClass) && ctx.eContainer()!=null)
			ctx = ctx.eContainer();
		if (ctx instanceof ProtocolClass)
			return (ProtocolClass) ctx;
		
		return null;
	}
	
	public static boolean isAnnotationPresent(ActorClass ac, String name) {
		return isAnnotationPresent(ac.getAnnotations(), name);
	}
	
	public static boolean isAnnotationPresent(List<Annotation> annotations, String name) {
		for (Annotation annotation : annotations) {
			if (annotation.getName().equals(name))
				return true;
		}
		return false;
	}
	
	public static List<KeyValue> getAttributes(ActorClass ac, String name) {
		return getAttributes(ac.getAnnotations(), name);
	}
	
	public static List<KeyValue> getAttributes(List<Annotation> annotations, String name) {
		for (Annotation annotation : annotations) {
			if (annotation.getName().equals(name))
				return annotation.getAttributes();
		}
		return Collections.emptyList();
	}
	
	public static boolean isAttributePresent(ActorClass ac, String name, String key) {
		return isAttributePresent(ac.getAnnotations(), name, key);
	}
	
	public static boolean isAttributePresent(List<Annotation> annotations, String name, String key) {
		List<KeyValue> attributes = getAttributes(annotations, name);
		for (KeyValue attrib : attributes) {
			if (attrib.getKey().equals(key))
				return true;
		}
		return false;
	}
	
	public static String getAttribute(ActorClass ac, String name, String key) {
		return getAttribute(ac.getAnnotations(), name, key);
	}
	
	public static String getAttribute(List<Annotation> annotations, String name, String key) {
		List<KeyValue> attributes = getAttributes(annotations, name);
		for (KeyValue attrib : attributes) {
			if (attrib.getKey().equals(key))
				return attrib.getValue();
		}
		return "";
	}
	
	public static boolean isAttributePresent(Annotation annotation, String key) {
		for (KeyValue attrib : annotation.getAttributes()) {
			if (attrib.getKey().equals(key))
				return true;
		}
		return false;
	}
	
	public static String getAttribute(Annotation annotation, String key) {
		for (KeyValue attrib : annotation.getAttributes()) {
			if (attrib.getKey().equals(key))
				return attrib.getValue();
		}
		return "";
	}
	
	public static boolean hasFlatStateMachine(ActorClass ac) {
		if (ac.getStateMachine()==null)
			return false;

		if (!ac.getStateMachine().getTrPoints().isEmpty())
			return false;
		
		for (State st : ac.getStateMachine().getStates()) {
			if (hasDirectSubStructure(st))
				return false;
		}
		
		return true;
	}
	
	public static List<Message> getMessageList(InterfaceItem item, boolean outgoing) {
		ProtocolClass protocol = null;
		if (item instanceof Port) {
			protocol = ((Port) item).getProtocol();
			if (((Port) item).isConjugated())
				outgoing = !outgoing;
		}
		else if (item instanceof SAPRef) {
			outgoing = !outgoing;
			protocol = ((SAPRef)item).getProtocol();
		}
		else if (item instanceof SPPRef) {
			protocol = ((SPPRef)item).getProtocol();
		}
		else {
			assert(false): "unexpected sub type";
			return null;
		}
		
		return outgoing? protocol.getOutgoingMessages():protocol.getIncomingMessages();
	}
	
	public static PortClass getPortClass(InterfaceItem item) {
		ProtocolClass protocol = null;
		boolean conjugated = false;
		if (item instanceof Port) {
			protocol = ((Port) item).getProtocol();
			conjugated = ((Port) item).isConjugated();
		}
		else if (item instanceof SAPRef) {
			protocol = ((SAPRef)item).getProtocol();
			conjugated = true;
		}
		else if (item instanceof SPPRef) {
			protocol = ((SPPRef)item).getProtocol();
		}
		else {
			assert(false): "unexpected sub type";
			return null;
		}
		
		return conjugated? protocol.getConjugate():protocol.getRegular();
	}

	public static String getSignature(Operation op) {
		/* TODO TS: create complete signature including return type and ref */
		String signature = "";
		for (VarDecl arg : op.getArguments()) {
			if (signature.isEmpty())
				signature = arg.getName()+": "+arg.getRefType().getType().getName();
			else
				signature += ", "+arg.getName()+": "+arg.getRefType().getType().getName();
		}
		signature = "("+signature+")";
		return signature;
	}

	public static String getArguments(Operation op) {
		String signature = "";
		for (VarDecl arg : op.getArguments()) {
			if (signature.isEmpty())
				signature = arg.getName();
			else
				signature += ", "+arg.getName();
		}
		signature = "("+signature+")";
		return signature;
	}
	
}
