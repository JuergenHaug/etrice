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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.common.base.KeyValue;
import org.eclipse.etrice.core.common.base.util.BaseHelpers;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorInstanceMapping;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.ChoicepointTerminal;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefPath;
import org.eclipse.etrice.core.room.RefSegment;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.etrice.core.room.RefinedTransition;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.SimpleState;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.StateGraphNode;
import org.eclipse.etrice.core.room.StateTerminal;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubStateTrPointTerminal;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.TrPointTerminal;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.TransitionTerminal;
import org.eclipse.etrice.core.room.Trigger;

import com.google.common.base.Function;

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
public class RoomHelpers extends BaseHelpers {
	
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
			ac = ac.getBase();
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
				ac = ac.getBase();
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
	 * Returns whether a {@link State} has sub structure.
	 * That means either of
	 * <ul>
	 * <li>the state has a non-empty sub graph</li>
	 * <li>the state is a RefinedState and its target state has sub structure</li>
	 * <li>a RefinedState of a sub ActorClass pointing to this state has sub structure</li>
	 * </ul>
	 * 
	 * @param state the {@link State}
	 * @param ac the containing {@link ActorClass} (which might be a sub class of the
	 * 		ActorClass containing the State in the containment hierarchy) 
	 * 
	 * @return whether a {@link State} has sub structure
	 */
	public boolean hasSubStructure(State state, ActorClass ac) {
		if (hasDirectSubStructure(state))
			return true;
		
		if (state instanceof RefinedState) {
			State target = ((RefinedState) state).getTarget();
			while (target!=null) {
				if (hasDirectSubStructure(target))
					return true;
				if (target instanceof RefinedState)
					target = ((RefinedState) target).getTarget();
				else
					break;
			}
		}
		
		if (ac.getStateMachine()!=null) {
			for (State s : getAllStatesRecursive(ac.getStateMachine())) {
				State predecessor = s;
				while (predecessor instanceof RefinedState) {
					predecessor = ((RefinedState) predecessor).getTarget();
					if (predecessor==state) {
						// we have a chain from s -> state
						// check this chain
						predecessor = s;
						while (predecessor instanceof RefinedState) {
							if (hasDirectSubStructure(predecessor))
								return true;
							predecessor = ((RefinedState) s).getTarget();
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
	
	/**
	 * Returns whether a {@link State} has direct sub structure.
	 * This is equivalent with having a non-empty sub graph.
	 * 
	 * @param s the {@link State}
	 * 
	 * @return whether a {@link State} has direct sub structure
	 */
	public boolean hasDirectSubStructure(State s) {
		return !isEmpty(s.getSubgraph());
	}

	/**
	 * Returns whether an {@link ActorClass} has a non-empty {@link StateGraph}.
	 * 
	 * @param ac the {@link ActorClass}
	 * 
	 * @return whether an {@link ActorClass} has a non-empty {@link StateGraph}
	 */
	public boolean hasNonEmptyStateMachine(ActorClass ac) {
		return !isEmpty(ac.getStateMachine());
	}
	
	public boolean isEmpty(StateGraph sg) {
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
		if (!sg.getRefinedTransitions().isEmpty())
			return false;
		
		return true;
	}
	
	/**
	 * @param s a {@link State}
	 * @return <code>true</code> if the state resides in the top level (i.e.
	 * directly in the actor's state machine)
	 */
	public boolean isTopLevel(StateGraphNode s) {
		return !(s.eContainer().eContainer() instanceof State);
	}
	
	/**
	 * @param s a {@link State}
	 * @return <code>true</code> if the state has no sub-graph
	 */
	public boolean isLeaf(State s) {
		return s.getSubgraph()==null;
	}
	
	/**
	 * @param state a {@link State}
	 * @return a list of all leaf states recursively
	 */
	public List<State> getLeafStateList(State state) {
		return getLeafStateList(state.getSubgraph());
	}
	
	/**
	 * @param sg a {@link StateGraph}
	 * @return a list of all leaf states recursively
	 */
	public List<State> getLeafStateList(StateGraph sg) {
		ArrayList<State> res = new ArrayList<State>();
		
		if (sg!=null) {
			TreeIterator<EObject> it = sg.eAllContents();
			while (it.hasNext()) {
				EObject obj = it.next();
				if ((obj instanceof State) && isLeaf((State) obj))
					res.add((State) obj);
			}
		}
		
		return res;
	}
	
	/**
	 * @param sg a {@link StateGraph}
	 * @return a list of all states recursively
	 */
	public List<State> getStateList(StateGraph sg) {
		ArrayList<State> res = new ArrayList<State>();
		
		if (sg!=null) {
			TreeIterator<EObject> it = sg.eAllContents();
			while (it.hasNext()) {
				EObject obj = it.next();
				if (obj instanceof State)
					res.add((State) obj);
			}
		}
		
		return res;
	}
	
	/**
	 * @param sg a {@link StateGraph}
	 * @return a list of all base states recursively
	 */
	public List<State> getBaseStateList(StateGraph sg) {
		ArrayList<State> res = new ArrayList<State>();
		
		if (sg!=null) {
			TreeIterator<EObject> it = sg.eAllContents();
			while (it.hasNext()) {
				EObject obj = it.next();
				if (obj instanceof SimpleState)
					res.add((State) obj);
			}
		}
		
		return res;
	}
	
	/**
	 * @param ac an {@link ActorClass} 
	 * @return all base states of the actor class
	 */
	public List<State> getAllBaseStates(ActorClass ac) {
		return getBaseStateList(ac.getStateMachine());
	}
	
	/**
	 * @param s a {@link State}
	 * @return the parent state of s if there is such. If the state is on
	 * the top level then <code>null</code> is returned
	 */
	public State getParentState(StateGraphNode s) {
		if (isTopLevel(s))
			return null;
		else
			return (State) s.eContainer().eContainer();
	}

	/**
	 * Returns the {@link RefinedState} in the derived state machine of the {@link ActorClass}
	 * which is (indirectly) targeting the state.
	 * 
	 * @param state the {@link State}
	 * @param ac the {@link ActorClass}
	 * 
	 * @return the {@link RefinedState} in the derived state machine of the {@link ActorClass}
	 * which is (indirectly) targeting the state
	 */
	public State getTargettingState(State state, ActorClass ac) {
		State targetting = state;
		for (State s : getAllStatesRecursive(ac.getStateMachine())) {
			State predecessor = s;
			while (predecessor instanceof RefinedState) {
				predecessor = ((RefinedState) predecessor).getTarget();
				if (predecessor==state)
					targetting = s;
			}
		}
		return targetting;
	}
	
	/**
	 * Returns <code>true</code> if the {@link DetailCode} is null or empty.
	 * 
	 * @param dc the {@link DetailCode}
	 * @return <code>true</code> if the {@link DetailCode} is null or empty.
	 */
	public boolean hasDetailCode(DetailCode dc) {
		if (dc==null)
			return false;
		
		for (String cmd : dc.getLines()) {
			if (!cmd.isEmpty())
				return true;
		}

		return false;
	}

	/**
	 * @param trig a {@link Trigger}
	 * @return <code>true</code> if a guard condition is defined for this trigger
	 */
	public boolean hasGuard(Trigger trig) {
		return trig.getGuard()!=null && hasDetailCode(trig.getGuard().getGuard());
	}
	
	/**
	 * Returns <code>true</code> if the entry code of a {@link State} is empty.
	 * 
	 * @param s the {@link State}
	 * @param includeInherited if <code>true</code> also parent states are considered
	 * 
	 * @return <code>true</code> if the entry code of a {@link State} is empty
	 */
	public boolean hasEntryCode(State s, boolean includeInherited) {
		return hasDetailCode(s, includeInherited, RoomPackage.Literals.STATE__ENTRY_CODE);
	}

	/**
	 * Returns <code>true</code> if the exit code of a {@link State} is empty.
	 * 
	 * @param s the {@link State}
	 * @param includeInherited if <code>true</code> also parent states are considered
	 * 
	 * @return <code>true</code> if the exit code of a {@link State} is empty
	 */
	public boolean hasExitCode(State s, boolean includeInherited) {
		return hasDetailCode(s, includeInherited, RoomPackage.Literals.STATE__EXIT_CODE);
	}

	/**
	 * Returns <code>true</code> if the do code of a {@link State} is empty.
	 * 
	 * @param s the {@link State}
	 * @param includeInherited if <code>true</code> also parent states are considered
	 * 
	 * @return <code>true</code> if the do code of a {@link State} is empty
	 */
	public boolean hasDoCode(State s, boolean includeInherited) {
		return hasDetailCode(s, includeInherited, RoomPackage.Literals.STATE__DO_CODE);
	}
	
	private boolean hasDetailCode(State s, boolean includeInherited, EReference feature) {
		DetailCode dc = (DetailCode) s.eGet(feature);
		if (hasDetailCode(dc))
			return true;
		
		if (includeInherited && s instanceof RefinedState)
			return !getInheritedCode((RefinedState) s, feature, true /* order doesn't matter here */).getLines().isEmpty();
		
		return false;
	}

	/**
	 * Returns the {@link DetailCode} as String with a newline character after each command.
	 * 
	 * @param code a {@link DetailCode}
	 * 
	 * @return  the {@link DetailCode} as String with a newline character after each command.
	 */
	public String getDetailCode(DetailCode code) {
		if (code==null || code.getLines().isEmpty())
			return "";
		
		StringBuilder result = new StringBuilder();
		for (String cmd : code.getLines()) {
			result.append(cmd + "\n");
		}
		return result.toString();
	}

	/**
	 * Returns a concatenation of inherited entry codes as {@link DetailCode}.
	 * The codes are ordered base class to sub class.
	 * 
	 * @param rs {@link RefinedState}
	 * 
	 * @return a concatenation of inherited entry codes as {@link DetailCode}
	 */
	public DetailCode getInheritedEntryCode(RefinedState rs) {
		return getInheritedCode(rs, RoomPackage.Literals.STATE__ENTRY_CODE, true);
	}

	/**
	 * Returns a concatenation of inherited exit codes as {@link DetailCode}.
	 * The codes are ordered sub class to base class.
	 * 
	 * @param rs {@link RefinedState}
	 * 
	 * @return a concatenation of inherited exit codes as {@link DetailCode}
	 */
	public DetailCode getInheritedExitCode(RefinedState rs) {
		return getInheritedCode(rs, RoomPackage.Literals.STATE__EXIT_CODE, false);
	}

	/**
	 * Returns a concatenation of inherited do codes as {@link DetailCode}.
	 * The codes are ordered base class to sub class.
	 * 
	 * @param rs {@link RefinedState}
	 * 
	 * @return a concatenation of inherited do codes as {@link DetailCode}
	 */
	public DetailCode getInheritedDoCode(RefinedState rs) {
		return getInheritedCode(rs, RoomPackage.Literals.STATE__DO_CODE, true);
	}
	
	/**
	 * @param rs
	 * @param code
	 * @return
	 */
	private DetailCode getInheritedCode(RefinedState rs, EReference code, boolean addFront) {
		DetailCode result = RoomFactory.eINSTANCE.createDetailCode();
		State s = rs.getTarget();
		while (s!=null) {
			DetailCode dc = (DetailCode) s.eGet(code);
			if (dc!=null) {
				if (addFront)
					result.getLines().addAll(0, dc.getLines());
				else
					result.getLines().addAll(dc.getLines());
				
			}
			if (s instanceof RefinedState)
				s = ((RefinedState) s).getTarget();
			else
				break;
		}
		return result;
	}

	/**
	 * The default resolution mechanism will return a SimpleState.
	 * This method searches for RefinedStates targeting the simple state.
	 * 
	 * @param sg the context for the search
	 * @param state the target state
	 * 
	 * @return a refined state targeting state or state itself
	 */
	public State getRefinedStateFor(StateGraph sg, State state) {
		// first we look for RefinedStates in the current context
		for (State s : sg.getStates()) {
			if (s instanceof RefinedState && s.getName().equals(state.getName())) {
				return s;
			}
		}
		
		// then we check whether our container has a base state/class
		if (sg.eContainer() instanceof State) {
			if (sg.eContainer() instanceof RefinedState) {
				return getRefinedStateFor(((RefinedState)sg.eContainer()).getTarget().getSubgraph(), state);
			}
		}
		else if (sg.eContainer() instanceof ActorClass) {
			ActorClass ac = (ActorClass) sg.eContainer();
			if (ac.getBase()!=null && ac.getBase().getStateMachine()!=null)
				return getRefinedStateFor(ac.getBase().getStateMachine(), state);
		}
		
		// nothing found, return original state
		return state;
	}

	/**
	 * Returns whether a {@link Trigger} contains a guard.
	 * 
	 * @param trig {@link Trigger}
	 * 
	 * @return whether a {@link Trigger} contains a guard
	 */
	public boolean isGuarded(Trigger trig) {
		return trig.getGuard()!=null && hasDetailCode(trig.getGuard().getGuard());
	}

	/**
	 * Returns the destination {@link StateGraphNode} of a {@link TransitionTerminal}.
	 * 
	 * @param tt the transition terminal
	 * 
	 * @return the destination {@link StateGraphNode} of a {@link TransitionTerminal}
	 */
	public StateGraphNode getNode(TransitionTerminal tt) {
		if (tt instanceof StateTerminal)
			return ((StateTerminal)tt).getState();
		else if (tt instanceof TrPointTerminal)
			return ((TrPointTerminal)tt).getTrPoint();
		else if (tt instanceof SubStateTrPointTerminal)
			return ((SubStateTrPointTerminal)tt).getTrPoint();
		else if (tt instanceof ChoicepointTerminal)
			return ((ChoicepointTerminal)tt).getCp();
		
		return null;
	}

	/**
	 * Returns all {@link State}s of a {@link StateGraph} including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return all {@link State}s of a {@link StateGraph} including parent state graphs recursively
	 */
	public List<State> getAllStates(StateGraph sg) {
		return getAllStateGraphItems(sg, RoomPackage.eINSTANCE.getStateGraph_States(), false);
	}

	/**
	 * Returns all {@link State}s of a {@link StateGraph} including parent state graphs recursively
	 * and descend also into sub graphs.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return all {@link State}s of a {@link StateGraph} including parent state graphs recursively
	 */
	public List<State> getAllStatesRecursive(StateGraph sg) {
		return getAllStateGraphItems(sg, RoomPackage.eINSTANCE.getStateGraph_States(), true);
	}

	/**
	 * Returns all {@link TrPoint}s of a {@link StateGraph} including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return all {@link TrPoint}s of a {@link StateGraph} including parent state graphs recursively
	 */
	public List<TrPoint> getAllTrPoints(StateGraph sg) {
		return getAllStateGraphItems(sg, RoomPackage.eINSTANCE.getStateGraph_TrPoints(), false);
	}

	/**
	 * Returns all {@link TrPoint}s of a {@link StateGraph} including parent state graphs recursively
	 * and descend also into sub graphs.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return all {@link TrPoint}s of a {@link StateGraph} including parent state graphs recursively
	 */
	public List<TrPoint> getAllTrPointsRecursive(StateGraph sg) {
		return getAllStateGraphItems(sg, RoomPackage.eINSTANCE.getStateGraph_TrPoints(), true);
	}

	/**
	 * Returns all {@link ChoicePoint}s of a {@link StateGraph} including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return all {@link ChoicePoint}s of a {@link StateGraph} including parent state graphs recursively
	 */
	public List<ChoicePoint> getAllChoicePoints(StateGraph sg) {
		return getAllStateGraphItems(sg, RoomPackage.eINSTANCE.getStateGraph_ChPoints(), false);
	}

	/**
	 * Returns all {@link Transition}s of a {@link StateGraph} including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return all {@link Transition}s of a {@link StateGraph} including parent state graphs recursively
	 */
	public List<Transition> getAllTransitions(StateGraph sg) {
		return getAllStateGraphItems(sg, RoomPackage.eINSTANCE.getStateGraph_Transitions(), false);
	}

	/**
	 * Returns all {@link Transition}s of a {@link StateGraph} including parent state graphs recursively
	 * and descend also into sub graphs.

	 * @param sg the {@link StateGraph}
	 * 
	 * @return all {@link Transition}s of a {@link StateGraph} including parent state graphs recursively
	 */
	public List<Transition> getAllTransitionsRecursive(StateGraph sg) {
		return getAllStateGraphItems(sg, RoomPackage.eINSTANCE.getStateGraph_Transitions(), true);
	}
	
	@SuppressWarnings("unchecked")
	private <T extends StateGraphItem> List<T> getAllStateGraphItems(StateGraph sg, EReference feature, boolean recurse) {
		ArrayList<T> result = new ArrayList<T>();
		
		while (sg!=null) {
			Object items = sg.eGet(feature);
			if (items instanceof List<?>)
				result.addAll((List<? extends T>) items);
			
			if (recurse) {
				for (State s : sg.getStates()) {
					if (s.getSubgraph()!=null) {
						List<T> subItems = getAllStateGraphItems(s.getSubgraph(), feature, recurse);
						result.addAll(subItems);
					}
				}
			}
			
			if (sg.eContainer() instanceof RefinedState) {
				sg = ((RefinedState)sg.eContainer()).getTarget().getSubgraph();
			}
			else if (sg.eContainer() instanceof ActorClass) {
				ActorClass base = ((ActorClass)sg.eContainer()).getBase();
				sg = base!=null? base.getStateMachine():null;
			}
			else {
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * Returns a complete list of all names used by the {@link StateGraphItem}s of a {@link StateGraph}
	 * including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return a complete list of all names used by the {@link StateGraphItem}s of a {@link StateGraph}
	 * including parent state graphs recursively
	 * 
	 * @see org.eclipse.etrice.core.room.util.RoomHelpers#getAllNames(StateGraph, StateGraphItem)
	 * 	getAllNames(StateGraph, StateGraphItem)
	 */
	public Set<String> getAllNames(StateGraph sg) {
		return getAllNames(sg, null);
	}
	
	/**
	 * Returns a complete list of all names used by the {@link StateGraphItem}s of a {@link StateGraph}
	 * including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * @param skip a {@link StateGraphItem} to be skipped
	 * 
	 * @return a complete list of all names used by the {@link StateGraphItem}s of a {@link StateGraph}
	 * including parent state graphs recursively
	 */
	public Set<String> getAllNames(StateGraph sg, StateGraphItem skip) {
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
				sg = ((RefinedState)sg.eContainer()).getTarget().getSubgraph();
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
	
	/**
	 * Returns a complete list of all names used by the {@link State}s of a {@link StateGraph}
	 * including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return a complete list of all names used by the {@link State}s of a {@link StateGraph}
	 * including parent state graphs recursively
	 * 
	 * @see org.eclipse.etrice.core.room.util.RoomHelpers#getAllStateNames(StateGraph, State)
	 * 	getAllStateNames(StateGraph, State)
	 */
	public Set<String> getAllStateNames(StateGraph sg) {
		return getAllNames(sg, null, RoomPackage.eINSTANCE.getStateGraph_States());
	}

	/**
	 * Returns a complete list of all names used by the {@link State}s of a {@link StateGraph}
	 * including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * @param skip a {@link State} to be skipped
	 * 
	 * @return a complete list of all names used by the {@link State}s of a {@link StateGraph}
	 * including parent state graphs recursively
	 */
	public Set<String> getAllStateNames(StateGraph sg, State skip) {
		return getAllNames(sg, skip, RoomPackage.eINSTANCE.getStateGraph_States());
	}
	
	/**
	 * Returns a complete list of all names used by the {@link TrPoint}s of a {@link StateGraph}
	 * including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return a complete list of all names used by the {@link TrPoint}s of a {@link StateGraph}
	 * including parent state graphs recursively
	 * 
	 * @see org.eclipse.etrice.core.room.util.RoomHelpers#getAllTrPointNames(StateGraph, TrPoint)
	 * 	getAllStateNames(StateGraph, TrPoint)
	 */
	public Set<String> getAllTrPointNames(StateGraph sg) {
		return getAllNames(sg, null, RoomPackage.eINSTANCE.getStateGraph_TrPoints());
	}
	
	/**
	 * Returns a complete list of all names used by the {@link TrPoint}s of a {@link StateGraph}
	 * including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * @param skip a {@link TrPoint} to be skipped
	 * 
	 * @return a complete list of all names used by the {@link TrPoint}s of a {@link StateGraph}
	 * including parent state graphs recursively
	 */
	public Set<String> getAllTrPointNames(StateGraph sg, TrPoint skip) {
		return getAllNames(sg, skip, RoomPackage.eINSTANCE.getStateGraph_TrPoints());
	}
	
	/**
	 * Returns a complete list of all names used by the {@link ChoicePoint}s of a {@link StateGraph}
	 * including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return a complete list of all names used by the {@link ChoicePoint}s of a {@link StateGraph}
	 * including parent state graphs recursively
	 * 
	 * @see org.eclipse.etrice.core.room.util.RoomHelpers#getAllChoicePointNames(StateGraph, ChoicePoint)
	 * 	getAllChoicePointNames(StateGraph, ChoicePoint)
	 */
	public Set<String> getAllChoicePointNames(StateGraph sg) {
		return getAllNames(sg, null, RoomPackage.eINSTANCE.getStateGraph_ChPoints());
	}
	
	/**
	 * Returns a complete list of all names used by the {@link ChoicePoint}s of a {@link StateGraph}
	 * including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * @param skip a {@link ChoicePoint} to be skipped
	 * 
	 * @return a complete list of all names used by the {@link ChoicePoint}s of a {@link StateGraph}
	 * including parent state graphs recursively
	 */
	public Set<String> getAllChoicePointNames(StateGraph sg, ChoicePoint skip) {
		return getAllNames(sg, skip, RoomPackage.eINSTANCE.getStateGraph_ChPoints());
	}
	
	/**
	 * Returns a complete list of all names used by the {@link Transition}s of a {@link StateGraph}
	 * including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return a complete list of all names used by the {@link Transition}s of a {@link StateGraph}
	 * including parent state graphs recursively
	 * 
	 * @see org.eclipse.etrice.core.room.util.RoomHelpers#getAllTransitionNames(StateGraph, Transition)
	 * 	getAllTransitionNames(StateGraph, Transition)
	 */
	public Set<String> getAllTransitionNames(StateGraph sg) {
		return getAllNames(sg, null, RoomPackage.eINSTANCE.getStateGraph_Transitions());
	}
	
	/**
	 * Returns a complete list of all names used by the {@link Transition}s of a {@link StateGraph}
	 * including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * @param skip a {@link Transition} to be skipped
	 * 
	 * @return a complete list of all names used by the {@link Transition}s of a {@link StateGraph}
	 * including parent state graphs recursively
	 */
	public Set<String> getAllTransitionNames(StateGraph sg, Transition skip) {
		return getAllNames(sg, skip, RoomPackage.eINSTANCE.getStateGraph_Transitions());
	}
	
	private <T extends StateGraphItem> Set<String> getAllNames(StateGraph sg, T skip, EReference feature) {
		List<T> items = getAllStateGraphItems(sg, feature, false);
		
		HashSet<String> names = new HashSet<String>();
		for (T item : items) {
			if (item!=skip)
				names.add(item.getName());
		}
		
		return names;
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
			
			ac = ac.getBase();
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
			
			ac = ac.getBase();
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
			ac = ac.getBase();
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
			ac = ac.getBase();
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
			
			ac = ac.getBase();
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
				curr = curr.getBase();
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
						MessageFromIf mif = RoomFactory.eINSTANCE.createMessageFromIf();
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
		ac = ac.getBase();
		while (ac!=null) {
			if (hasNonEmptyStateMachine(ac))
				break;
			
			List<InterfaceItem> items = getInterfaceItems(ac);
			for (InterfaceItem item : items) {
				if (item.getGeneralProtocol() instanceof ProtocolClass) {
					ProtocolClass pc = (ProtocolClass) item.getGeneralProtocol();
					if (pc.getCommType()==CommunicationType.EVENT_DRIVEN) {
						for (Message msg : getIncoming(item)) {
							MessageFromIf mif = RoomFactory.eINSTANCE.createMessageFromIf();
							mif.setMessage(msg);
							mif.setFrom(item);
							result.add(mif);
						}
					}
				}
			}
			
			ac = ac.getBase();
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
							MessageFromIf mif = RoomFactory.eINSTANCE.createMessageFromIf();
							mif.setMessage(msg);
							mif.setFrom(item);
							result.add(mif);
						}
					}
				}
			}
			
			ac = ac.getBase();
		}
		
		return result;
	}

	/**
	 * @param ac the actor class to check
	 * @return {@code true} if the class hierarchy is circular (i.e. a base class refers to one of its sub classes)
	 */
	public boolean isCircularClassHierarchy(ActorClass ac) {
		HashSet<ActorClass> classes = new HashSet<ActorClass>();
		classes.add(ac);
		
		while (ac.getBase()!=null) {
			ac = ac.getBase();
			if (classes.contains(ac))
				return true;
			
			classes.add(ac);
		}
		
		return false;
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
			
			ac = ac.getBase();
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
			
			ac = ac.getBase();
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
				while((base = base.getBase()) != null)
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
			
			ac = ac.getBase();
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
			
			ac = ac.getBase();
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
	 * Checks whether the state machine of an {@link ActorClass} is flat
	 * in the sense that no state has a non-empty sub graph
	 * 
	 * @param ac the actor class
	 * 
	 * @return <code>true</code> if the state machine is flat
	 */
	public boolean hasFlatStateMachine(ActorClass ac) {
		if (isEmpty(ac.getStateMachine()))
			return false;

		if (!ac.getStateMachine().getTrPoints().isEmpty())
			return false;
		
		for (State st : ac.getStateMachine().getStates()) {
			if (hasDirectSubStructure(st))
				return false;
		}
		
		return true;
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
	 * return the {@link SimpleState} of a {@link State}
	 * @param s
	 * @return the state itself if a SimpleState or the base state for a {@link RefinedState}
	 */
	public SimpleState getBaseState(State s) {
		if (s instanceof SimpleState)
			return (SimpleState) s;
		else if (s instanceof RefinedState)
			return getBaseState(((RefinedState) s).getTarget());
		else
			return null;
	}

	/**
	 * Returns a list of target states of a {@link RefinedState} recursively.
	 * 
	 * @param rs the refined state
	 * 
	 * @return a list of target states of a {@link RefinedState} recursively
	 */
	public List<State> getReferencedStatesRecursively(RefinedState rs) {
		ArrayList<State> result = new ArrayList<State>();
		
		State target = rs.getTarget();
		result.add(target);
		
		if (target instanceof RefinedState) {
			List<State> refs = getReferencedStatesRecursively((RefinedState) target);
			result.addAll(refs);
		}
		
		return result;
	}
	
	/**
	 * Checks whether a {@link RefinedState} references a state recursively.
	 * 
	 * @param rs the refined state
	 * @param referenced the potential target state
	 * 
	 * @return <code>true</code> if a state is referenced recursively by a refined state
	 */
	public boolean referencesStateRecursively(RefinedState rs, State referenced) {
		State target = rs.getTarget();
		if (target==referenced)
			return true;
		
		if (target instanceof SimpleState)
			return false;
		
		if (target instanceof RefinedState)
			return referencesStateRecursively((RefinedState) target, referenced);
		
		assert(false): "unexpected sub type";
		return false;
	}

	/**
	 * This highly specialized method is for <b>internal use only</b>.<br/><br/>
	 * 
	 * All refined states of the state machine of an actor class (without inherited states)
	 * are checked if they are semantically nested in another state of the same state machine.
	 * 
	 * @param ac the actor class
	 * @param nameProvider a function that returns the full path of a refined state
	 * 
	 * @return a map of refined states to potential parent refined states
	 */
	public Map<RefinedState, RefinedState> getRefinedStatesToRelocate(ActorClass ac, Function<RefinedState, String> nameProvider) {
		
		// collect RefinedStates and some information
		ArrayList<RefinedState> refinedStates = new ArrayList<RefinedState>();
		ArrayList<String> paths = new ArrayList<String>();
		HashMap<String, RefinedState> path2rs = new HashMap<String, RefinedState>();
		TreeIterator<EObject> it = ac.getStateMachine().eAllContents();
		while (it.hasNext()) {
			EObject obj = it.next();
			if (obj instanceof RefinedState) {
				refinedStates.add((RefinedState) obj);
				String path = nameProvider.apply((RefinedState) obj);
				paths.add(path);
				path2rs.put(path, (RefinedState) obj);
			}
		}
		
		// we sort the paths to have paths with same beginning in descending length
		java.util.Collections.sort(paths, java.util.Collections.reverseOrder());
		
		// find the best matching context
		HashMap<RefinedState, RefinedState> rs2parent = new HashMap<RefinedState, RefinedState>();
		for (RefinedState rs : refinedStates) {
			String fullPath = nameProvider.apply(rs);
			for (String path : paths) {
				if (!fullPath.equals(path) && fullPath.startsWith(path) && fullPath.charAt(path.length())==RoomNameProvider.PATH_SEP.charAt(0)) {
					RefinedState parent = path2rs.get(path);
					if (!(parent.getSubgraph()!=null && parent.getSubgraph().getStates().contains(rs)))
						rs2parent.put(rs, parent);
					break;
				}
			}
		}
		return rs2parent;
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
		return getBaseCode(state, RoomPackage.Literals.STATE__ENTRY_CODE);
	}

	/**
	 * Returns the recursive base class exit code of a {@link RefinedState} as string.
	 * 
	 * @param state the state
	 * 
	 * @return the recursive base class exit code of a {@link RefinedState} as string
	 */
	public String getBaseExitCode(RefinedState state) {
		return getBaseCode(state, RoomPackage.Literals.STATE__EXIT_CODE);
	}

	/**
	 * Returns the recursive base class do code of a {@link RefinedState} as string.
	 * 
	 * @param state the state
	 * 
	 * @return the recursive base class do code of a {@link RefinedState} as string
	 */
	public String getBaseDoCode(RefinedState state) {
		return getBaseCode(state, RoomPackage.Literals.STATE__DO_CODE);
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
			ac = ac.getBase();
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
			
			ac = ac.getBase();
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
			
			ac1 = ac1.getBase();
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
