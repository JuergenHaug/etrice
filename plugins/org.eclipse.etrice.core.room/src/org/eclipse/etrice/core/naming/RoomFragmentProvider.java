/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.naming;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ComposedSwitch;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.common.base.AnnotationType;
import org.eclipse.etrice.core.common.base.BasePackage;
import org.eclipse.etrice.core.common.base.util.BaseSwitch;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.CompoundProtocolClass;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.NonInitialTransition;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.RefSAPoint;
import org.eclipse.etrice.core.room.RefinedTransition;
import org.eclipse.etrice.core.room.RelaySAPoint;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SAPoint;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.SPPoint;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubProtocol;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.util.RoomSwitch;
import org.eclipse.xtext.resource.IFragmentProvider;


public class RoomFragmentProvider implements IFragmentProvider {

	private class RoomPathProvider extends RoomSwitch<String> {

		@Override
		public String caseRoomClass(RoomClass rc) {
			return rc.getName();
		}
		
		@Override
		public String casePort(Port port) {
			return doSwitch(port.eContainer())+SEP+port.getName();
		}
		
		@Override
		public String caseSPP(SPP spp) {
			return doSwitch(spp.eContainer())+SEP+spp.getName();
		}
		
		@Override
		public String caseActorContainerRef(ActorContainerRef acr) {
			return doSwitch(acr.eContainer())+SEP+acr.getName();
		}
		
		@Override
		public String caseBinding(Binding bi) {
			return doSwitch(bi.eContainer())+SEP
			+caseBindingEndPointShort(bi.getEndpoint1())+BIND_SEP
			+caseBindingEndPointShort(bi.getEndpoint2());
		}
		
		private String caseBindingEndPointShort(BindingEndPoint ep) {
			String loc = ep.getActorRef()==null? LOCAL:ep.getActorRef().getName();
			if (ep.getSub()!=null)
				return ep.getPort().getName()+EP_SEP+loc+SUB_SEP+ep.getSub().getName();
			else
				return ep.getPort().getName()+EP_SEP+loc;
		}
		
		@Override
		public String caseLayerConnection(LayerConnection bi) {
			return doSwitch(bi.eContainer())+SEP
			+caseSAPointShort(bi.getFrom())+CONN_SEP
			+caseSPPointShort(bi.getTo());
		}
		
		private String caseSAPointShort(SAPoint sapt) {
			if (sapt==null)
				return "null";
			if (sapt instanceof RefSAPoint)
				return ((RefSAPoint) sapt).getRef().getName();
			else if (sapt instanceof RelaySAPoint)
				return ((RelaySAPoint) sapt).getRelay().getName();
			
			assert(false): "unexpectd sub type";
			return null;
		}
		
		private String caseSPPointShort(SPPoint sppt) {
			return sppt.getRef().getName()+EP_SEP+sppt.getService().getName();
		}
		
		@Override
		public String caseState(State s) {
			// going up two steps in the containment hierarchy either hits another state or a RoomClass
			return doSwitch(s.eContainer().eContainer())+SEP+s.getName();
		}
		
		@Override
		public String caseTrPoint(TrPoint trp) {
			// going up two steps in the containment hierarchy either hits a state or a RoomClass
			return doSwitch(trp.eContainer().eContainer())+SEP+trp.getName();
		}
		
		@Override
		public String caseChoicePoint(ChoicePoint cp) {
			// going up two steps in the containment hierarchy either hits a state or a RoomClass
			return doSwitch(cp.eContainer().eContainer())+SEP+cp.getName();
		}
		
		@Override
		public String caseInitialTransition(InitialTransition t) {
			// going up two steps in the containment hierarchy either hits a state or a RoomClass
			return doSwitch(t.eContainer().eContainer())+SEP+INIT_TRANS;
		}
		
		@Override
		public String caseNonInitialTransition(NonInitialTransition t) {
			// the transition name is optional in the ROOM DSL but will be automatically assigned
			// by the Behavior Editor
			
			// going up two steps in the containment hierarchy either hits a state or a RoomClass
			return doSwitch(t.eContainer().eContainer())+SEP+t.getName();
		}
		
		@Override
		public String caseRefinedTransition(RefinedTransition t) {
			// the transition name is optional in the ROOM DSL but will be automatically assigned
			// by the Behavior Editor
			
			// going up two steps in the containment hierarchy either hits a state or a RoomClass
			return doSwitch(t.eContainer().eContainer())+SEP+t.getTarget().getName();
		}
		
		@Override
		public String caseStateGraph(StateGraph sg) {
			// going up one step in the containment hierarchy either hits a state or a RoomClass
			return doSwitch(sg.eContainer())+SEP+STATE_GRAPH;
		}
	}
	
	private class BasePathProvider extends BaseSwitch<String> {
		/* (non-Javadoc)
		 * @see org.eclipse.etrice.core.common.base.util.BaseSwitch#caseAnnotationType(org.eclipse.etrice.core.common.base.AnnotationType)
		 */
		@Override
		public String caseAnnotationType(AnnotationType object) {
			return object.getName();
		}
	}
	
	private class PathProvider extends ComposedSwitch<String> {
		public PathProvider() {
			this.addSwitch(new BasePathProvider());
			this.addSwitch(new RoomPathProvider());
		}
	}
	
	private static final char SEP = '$';
	private static final char BIND_SEP = '-';
	private static final char SUB_SEP = '/';
	private static final char CONN_SEP = '-';
	private static final String INIT_TRANS = "initial";
	private static final String STATE_GRAPH = "sg";
	private static final char EP_SEP = '!';
	private static final String LOCAL = ".";
	private static final char TYPE_SEP = ':';

	private PathProvider pathProvider = new PathProvider();
	
	@Override
	public String getFragment(EObject obj, Fallback fallback) {
		String path = pathProvider.doSwitch(obj);
		if (path!=null)
			return obj.eClass().getName()+TYPE_SEP+path;
		
		return fallback.getFragment(obj);
	}

	@Override
	public EObject getEObject(Resource resource, String fragment,
			Fallback fallback) {

		if (!resource.getContents().isEmpty()) {
			RoomModel model = (RoomModel) resource.getContents().get(0);
			EObject result = getEObject(model, fragment);
			if (result!=null)
				return result;
		}
		
		return fallback.getEObject(fragment);
	}

	public static boolean isActorClass(String fragment) {
		if (fragment.startsWith(RoomPackage.eINSTANCE.getActorClass().getName()))
			return true;
		
		return false;
	}

	public static boolean isStructureClass(String fragment) {
		if (fragment.startsWith(RoomPackage.eINSTANCE.getActorClass().getName()))
			return true;
		if (fragment.startsWith(RoomPackage.eINSTANCE.getSubSystemClass().getName()))
			return true;
		if (fragment.startsWith(RoomPackage.eINSTANCE.getLogicalSystem().getName()))
			return true;
		
		return false;
	}

	public static boolean isStructureClass(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		if (uri!=null && uri.fragment()!=null) {
			return isStructureClass(uri.fragment());
		}
		return false;
	}
	
	public static boolean isPort(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		return uri!=null && uri.fragment()!=null && uri.fragment().startsWith(RoomPackage.eINSTANCE.getPort().getName());
	}

	public static boolean isSPP(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		return uri!=null && uri.fragment()!=null && uri.fragment().startsWith(RoomPackage.eINSTANCE.getSPP().getName());
	}

	public static boolean isBinding(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		return uri!=null && uri.fragment()!=null && uri.fragment().startsWith(RoomPackage.eINSTANCE.getBinding().getName());
	}

	public static boolean isLayerConnection(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		return uri!=null && uri.fragment()!=null && uri.fragment().startsWith(RoomPackage.eINSTANCE.getLayerConnection().getName());
	}

	public static boolean isRef(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		if (uri!=null && uri.fragment()!=null) {
			if (uri.fragment().startsWith(RoomPackage.eINSTANCE.getActorContainerRef().getName()))
				return true;
			if (uri.fragment().startsWith(RoomPackage.eINSTANCE.getActorRef().getName()))
				return true;
		}
		return false;
	}

	public static boolean isState(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		if (uri!=null && uri.fragment()!=null) {
			if (uri.fragment().startsWith("BaseState"))
				return true;
			if (uri.fragment().startsWith(RoomPackage.eINSTANCE.getSimpleState().getName()))
				return true;
			if (uri.fragment().startsWith(RoomPackage.eINSTANCE.getRefinedState().getName()))
				return true;
		}
		return false;
	}

	public static boolean isTrPoint(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		if (uri!=null && uri.fragment()!=null) {
			if (uri.fragment().startsWith(RoomPackage.eINSTANCE.getTransitionPoint().getName()))
				return true;
			if (uri.fragment().startsWith(RoomPackage.eINSTANCE.getEntryPoint().getName()))
				return true;
			if (uri.fragment().startsWith(RoomPackage.eINSTANCE.getExitPoint().getName()))
				return true;
		}
		return false;
	}

	public static boolean isChoicePoint(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		return uri!=null && uri.fragment()!=null && uri.fragment().startsWith(RoomPackage.eINSTANCE.getChoicePoint().getName());
	}

	public static boolean isStateGraph(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		return uri!=null && uri.fragment()!=null && uri.fragment().startsWith(RoomPackage.eINSTANCE.getStateGraph().getName());
	}

	public static boolean isTransition(EObject obj) {
		URI uri = EcoreUtil.getURI(obj);
		if (uri!=null && uri.fragment()!=null) {
			if (uri.fragment().startsWith(RoomPackage.eINSTANCE.getInitialTransition().getName()))
				return true;
			if (uri.fragment().startsWith(RoomPackage.eINSTANCE.getContinuationTransition().getName()))
				return true;
			if (uri.fragment().startsWith(RoomPackage.eINSTANCE.getCPBranchTransition().getName()))
				return true;
			if (uri.fragment().startsWith(RoomPackage.eINSTANCE.getTriggeredTransition().getName()))
				return true;
			if (uri.fragment().startsWith(RoomPackage.eINSTANCE.getRefinedTransition().getName()))
				return true;
		}
		return false;
	}
	
	private EObject getEObject(RoomModel model, String fragment) {
		int begin = 0;
		int end = fragment.indexOf(TYPE_SEP);
		if (end<0)
			return null;
		String type = fragment.substring(begin, end);

		begin = end+1;
		end = fragment.indexOf(SEP, begin);
		if (end<0)
			end = fragment.length();
		String className = fragment.substring(begin, end);
		
		if(type.equals(BasePackage.eINSTANCE.getAnnotationType().getName())) {
			return getAnnotationType(model, className);
		}
		
		RoomClass rc = getRoomClass(model, className);
		if (type.equals(RoomPackage.eINSTANCE.getDataClass().getName())) {
			return rc;
		}
		else if (type.equals(RoomPackage.eINSTANCE.getPrimitiveType().getName())) {
			return rc;
		}
		else if (type.equals(RoomPackage.eINSTANCE.getExternalType().getName())) {
			return rc;
		}
		else if (type.equals(RoomPackage.eINSTANCE.getProtocolClass().getName())) {
			return rc;
		}
		else if (type.equals(RoomPackage.eINSTANCE.getCompoundProtocolClass().getName())) {
			return rc;
		}
		else if (type.equals(RoomPackage.eINSTANCE.getActorClass().getName())) {
			return rc;
		}
		else if (type.equals(RoomPackage.eINSTANCE.getSubSystemClass().getName())) {
			return rc;
		}
		else if (type.equals(RoomPackage.eINSTANCE.getLogicalSystem().getName())) {
			return rc;
		}
		
		if (end<fragment.length()) {
			String remainder = fragment.substring(end+1, fragment.length());
			
			if (type.equals(RoomPackage.eINSTANCE.getPort().getName())) {
				return getPort(rc, remainder);
			}
			else if (type.equals(RoomPackage.eINSTANCE.getSPP().getName())) {
				return getSPP(rc, remainder);
			}
			else if (type.equals(RoomPackage.eINSTANCE.getSubSystemRef().getName())
					|| type.equals(RoomPackage.eINSTANCE.getActorRef().getName())) {
				return getActorContainerRef(rc, remainder);
			}
			else if (type.equals(RoomPackage.eINSTANCE.getBinding().getName())) {
				return getBinding(rc, remainder);
			}
			else if (type.equals(RoomPackage.eINSTANCE.getLayerConnection().getName())) {
				return getLayerConnection(rc, remainder);
			}
			else if (type.equals("BaseState")
					|| type.equals(RoomPackage.eINSTANCE.getSimpleState().getName())
					|| type.equals(RoomPackage.eINSTANCE.getRefinedState().getName())) {
				return getState(rc, remainder);
			}
			else if (type.equals(RoomPackage.eINSTANCE.getTransitionPoint().getName())
					|| type.equals(RoomPackage.eINSTANCE.getEntryPoint().getName())
					|| type.equals(RoomPackage.eINSTANCE.getExitPoint().getName())) {
				return getTrPoint(rc, remainder);
			}
			else if (type.equals(RoomPackage.eINSTANCE.getChoicePoint().getName())) {
				return getChoicePoint(rc, remainder);
			}
			else if (type.equals(RoomPackage.eINSTANCE.getInitialTransition().getName())) {
				return getInitialTransition(rc, remainder);
			}
			else if (type.equals(RoomPackage.eINSTANCE.getRefinedTransition().getName())) {
				return getRefinedTransition(rc, remainder);
			}
			else if (type.equals(RoomPackage.eINSTANCE.getContinuationTransition().getName())
					|| type.equals(RoomPackage.eINSTANCE.getCPBranchTransition().getName())
					|| type.equals(RoomPackage.eINSTANCE.getTriggeredTransition().getName())
					|| type.equals(RoomPackage.eINSTANCE.getGuardedTransition().getName())) {
				return getTransition(rc, remainder);
			}
			else if (type.equals(RoomPackage.eINSTANCE.getStateGraph().getName())
					|| type.equals("StateMachine")) {
				return getStateGraph(rc, remainder);
			}
		}
		
		return null;
	}

	private Transition getTransition(RoomClass rc, String remainder) {
		StateGraph sg = getStateGraph(rc, remainder);
		
		int begin = remainder.lastIndexOf(SEP);
		if (begin<0)
			begin = 0;
		else
			++begin;
		
		String name = remainder.substring(begin, remainder.length());
		for (Transition t : sg.getTransitions()) {
			if (t.getName().equals(name)) {
				return t;
			}
		}

		return null;
	}

	private InitialTransition getInitialTransition(RoomClass rc, String remainder) {
		StateGraph sg = getStateGraph(rc, remainder);
		
		int begin = remainder.lastIndexOf(SEP);
		if (begin<0)
			begin = 0;
		else
			++begin;
		
		String name = remainder.substring(begin, remainder.length());
		if (name.equals(INIT_TRANS)) {
			for (Transition t : sg.getTransitions()) {
				if (t instanceof InitialTransition)
					return (InitialTransition) t;
			}
		}
		
		return null;
	}

	private RefinedTransition getRefinedTransition(RoomClass rc, String remainder) {
		StateGraph sg = getStateGraph(rc, remainder);
		
		int begin = remainder.lastIndexOf(SEP);
		if (begin<0)
			begin = 0;
		else
			++begin;
		
		String name = remainder.substring(begin, remainder.length());
		for (RefinedTransition t : sg.getRefinedTransitions()) {
			if (t.getTarget().getName().equals(name))
				return t;
		}
		
		return null;
	}

	private ChoicePoint getChoicePoint(RoomClass rc, String remainder) {
		StateGraph sg = getStateGraph(rc, remainder);
		
		int begin = remainder.lastIndexOf(SEP);
		if (begin<0)
			begin = 0;
		else
			++begin;
		
		String name = remainder.substring(begin, remainder.length());
		for (ChoicePoint cp : sg.getChPoints()) {
			if (cp.getName().equals(name)) {
				return cp;
			}
		}

		return null;
	}

	private TrPoint getTrPoint(RoomClass rc, String remainder) {
		StateGraph sg = getStateGraph(rc, remainder);
		
		int begin = remainder.lastIndexOf(SEP);
		if (begin<0)
			begin = 0;
		else
			++begin;
		
		String name = remainder.substring(begin, remainder.length());
		for (TrPoint tp : sg.getTrPoints()) {
			if (tp.getName().equals(name)) {
				return tp;
			}
		}

		return null;
	}

	private State getState(RoomClass rc, String remainder) {
		StateGraph sg = getStateGraph(rc, remainder);
		
		int begin = remainder.lastIndexOf(SEP);
		if (begin<0)
			begin = 0;
		else
			++begin;
		
		String name = remainder.substring(begin, remainder.length());
		for (State s : sg.getStates()) {
			if (s.getName().equals(name)) {
				return s;
			}
		}

		return null;
	}

	private StateGraph getStateGraph(RoomClass rc, String remainder) {
		if (rc instanceof ActorClass) {
			StateGraph sg = ((ActorClass) rc).getStateMachine();
			if (sg==null) {
				((ActorClass) rc).setStateMachine(RoomFactory.eINSTANCE.createStateGraph());
				sg = ((ActorClass) rc).getStateMachine();
			}
			int begin = 0;
			int end = remainder.indexOf(SEP);
			while (end>=0) {
				String name = remainder.substring(begin, end);
				boolean found = false;
				for (State s : sg.getStates()) {
					if (s.getName().equals(name)) {
						sg = s.getSubgraph();
						found = true;
						break;
					}
				}
				if (!found)
					return null;
				
				begin = end+1;
				end = remainder.indexOf(SEP, begin);
			}
			
			return sg;
		}

		return null;
	}

	private EObject getBinding(RoomClass rc, String name) {
		int pos = name.indexOf(BIND_SEP);
		if (pos<0)
			return null;
		
		if (rc instanceof StructureClass) {
			String ep1name = name.substring(0, pos);
			String ep2name = name.substring(pos+1, name.length());
			StructureClass sc = (StructureClass) rc;
			BindingEndPoint ep1 = getEndpoint(sc, ep1name);
			BindingEndPoint ep2 = getEndpoint(sc, ep2name);
			for (Binding bi : sc.getBindings()) {
				if (isEP(bi.getEndpoint1(),ep1) && isEP(bi.getEndpoint2(),ep2))
					return bi;
				if (isEP(bi.getEndpoint1(),ep2) && isEP(bi.getEndpoint2(),ep1))
					return bi;
			}
		}
		return null;
	}

	private boolean isEP(BindingEndPoint a, BindingEndPoint b) {
		if (a.getPort().getName().equals(b.getPort().getName())) {
			if (a.getSub()==null && b.getSub()!=null)
				return false;
			if (a.getSub()!=null && b.getSub()==null)
				return false;
			if (a.getSub()!=null && b.getSub()!=null)
				if (!a.getSub().getName().equals(b.getSub().getName()))
					return false;
			if (a.getActorRef()==null && b.getActorRef()==null)
				return true;
			if (a.getActorRef()!=null && b.getActorRef()!=null)
				if (a.getActorRef().getName().equals(b.getActorRef().getName()))
					return true;
		}
		return false;
	}
	
	private BindingEndPoint getEndpoint(StructureClass sc, String name) {
		int pos = name.indexOf(EP_SEP);
		if (pos<0)
			return null;
		
		String portName = name.substring(0, pos);
		String refName = name.substring(pos+1);
		String sub = null;
		int subIdx = refName.indexOf(SUB_SEP);
		if (subIdx>=0) {
			sub = refName.substring(subIdx+1);
			refName = refName.substring(0, subIdx);
		}
		ActorContainerRef ar = null;
		if (!refName.equals(LOCAL))
			ar = getActorContainerRef(sc, refName);
		if (ar!=null) {
			if (ar instanceof ActorRef)
				sc = ((ActorRef) ar).getType();
			else if (ar instanceof SubSystemRef)
				sc = ((SubSystemRef) ar).getType();
		}
		Port port = getPort(sc, portName);
		BindingEndPoint ep = RoomFactory.eINSTANCE.createBindingEndPoint();
		ep.setPort(port);
		ep.setActorRef(ar);
		if (subIdx>=0)
			ep.setSub(getSubProtocol(sub, port));
		return ep;
	}

	private SubProtocol getSubProtocol(String sub, Port port) {
		if (port==null)
			return null;
		
		if (port.getProtocol() instanceof CompoundProtocolClass) {
			CompoundProtocolClass cpc = (CompoundProtocolClass) port.getProtocol();
			for (SubProtocol sp : cpc.getSubProtocols()) {
				if (sp.getName().equals(sub))
					return sp;
			}
		}
		
		return null;
	}

	private EObject getLayerConnection(RoomClass rc, String name) {
		int pos = name.indexOf(CONN_SEP);
		if (pos<0)
			return null;
		
		if (rc instanceof StructureClass) {
			String saptname = name.substring(0, pos);
			String spptname = name.substring(pos+1, name.length());
			StructureClass sc = (StructureClass) rc;
			SAPoint sapt = getSAPoint(sc, saptname);
			SPPoint sppt = getSPPoint(sc, spptname);
			for (LayerConnection bi : sc.getConnections()) {
				if (isSAPoint(bi.getFrom(),sapt) && isSPPoint(bi.getTo(),sppt))
					return bi;
			}
		}
		return null;
	}

	private SPPoint getSPPoint(StructureClass sc, String name) {
		int pos = name.indexOf(EP_SEP);
		if (pos<0)
			return null;
		String refName = name.substring(0, pos);
		String sppName = name.substring(pos+1, name.length());

		if (sc instanceof ActorContainerClass) {
			for (ActorRef ar : ((ActorContainerClass) sc).getActorRefs()) {
				if (ar.getName().equals(refName)) {
					for (SPP spp : ar.getType().getServiceProvisionPoints())
						if (spp.getName().equals(sppName)) {
							SPPoint sppt = RoomFactory.eINSTANCE.createSPPoint();
							sppt.setRef(ar);
							sppt.setService(spp);
							return sppt;
						}
				}
			}
		}
		else if (sc instanceof LogicalSystem) {
			for (SubSystemRef ssr : ((LogicalSystem) sc).getSubSystems()) {
				if (ssr.getName().equals(refName)) {
					for (SPP spp: ssr.getType().getServiceProvisionPoints())
						if (spp.getName().equals(sppName)) {
							SPPoint sppt = RoomFactory.eINSTANCE.createSPPoint();
							sppt.setRef(ssr);
							sppt.setService(spp);
							return sppt;
						}
				}
			}
		}
		
		return null;
	}

	private SAPoint getSAPoint(StructureClass sc, String name) {
		SAPoint sapt = getRelaySAPoint(sc, name);
		if (sapt!=null)
			return sapt;
		return getRefSAPoint(sc, name);
	}

	private SAPoint getRefSAPoint(StructureClass sc, String name) {
		if (sc instanceof ActorContainerClass) {
			for (ActorRef ar : ((ActorContainerClass)sc).getActorRefs()) {
				if (ar.getName().equals(name)) {
					RefSAPoint sapt = RoomFactory.eINSTANCE.createRefSAPoint();
					sapt.setRef(ar);
					return sapt;
				}
			}
		}
		if (sc instanceof LogicalSystem) {
			for (SubSystemRef ssr : ((LogicalSystem) sc).getSubSystems()) {
				if (ssr.getName().equals(name)) {
					RefSAPoint sapt = RoomFactory.eINSTANCE.createRefSAPoint();
					sapt.setRef(ssr);
					return sapt;
				}
			}
		}
		return null;
	}

	private SAPoint getRelaySAPoint(StructureClass sc, String name) {
		if (sc instanceof ActorContainerClass) {
			for (SPP spp : ((ActorContainerClass) sc).getServiceProvisionPoints()) {
				if (spp.getName().equals(name)) {
					RelaySAPoint sapt = RoomFactory.eINSTANCE.createRelaySAPoint();
					sapt.setRelay(spp);
					return sapt;
				}
			}
		}
		return null;
	}
	
	private boolean isSAPoint(SAPoint a, SAPoint b) {
		if (a instanceof RefSAPoint && b instanceof RefSAPoint) {
			return ((RefSAPoint)a).getRef().getName().equals(((RefSAPoint)b).getRef().getName());
		}
		else if (a instanceof RelaySAPoint && b instanceof RelaySAPoint) {
			return ((RelaySAPoint)a).getRelay().getName().equals(((RelaySAPoint)b).getRelay().getName());
		}
		return false;
	}

	private boolean isSPPoint(SPPoint a, SPPoint b) {
		if (!a.getRef().getName().equals(b.getRef().getName()))
			return false;
		
		if (!a.getService().getName().equals(b.getService().getName()))
			return false;
		
		return true;
	}
	
	private ActorContainerRef getActorContainerRef(RoomClass rc, String name) {
		if (rc instanceof ActorContainerClass) {
			for (ActorRef ar : ((ActorContainerClass) rc).getActorRefs()) {
				if (ar.getName().equals(name))
					return ar;
			}
			if (rc instanceof ActorClass)
				if (((ActorClass) rc).getBase()!=null)
					return getActorContainerRef(((ActorClass) rc).getBase(), name);
		}
		else if (rc instanceof LogicalSystem) {
			for (SubSystemRef ssr : ((LogicalSystem) rc).getSubSystems()) {
				if (ssr.getName().equals(name))
					return ssr;
			}
		}
		return null;
	}

	protected Port getPort(RoomClass rc, String name) {
		if (rc instanceof ActorClass) {
			for (Port p : ((ActorClass) rc).getInterfacePorts()) {
				if (p.getName().equals(name))
					return p;
			}
			for (Port p : ((ActorClass) rc).getInternalPorts()) {
				if (p.getName().equals(name))
					return p;
			}
			if (((ActorClass) rc).getBase()!=null)
				return getPort(((ActorClass) rc).getBase(), name);
		}
		else if (rc instanceof SubSystemClass) {
			for (Port p : ((SubSystemClass) rc).getRelayPorts()) {
				if (p.getName().equals(name))
					return p;
			}
		}
		return null;
	}

	protected SPP getSPP(RoomClass rc, String name) {
		if (rc instanceof ActorContainerClass) {
			for (SPP spp : ((ActorContainerClass) rc).getServiceProvisionPoints()) {
				if (spp.getName().equals(name))
					return spp;
			}
			if (rc instanceof ActorClass)
				if (((ActorClass)rc).getBase()!=null)
					return getSPP(((ActorClass)rc).getBase(), name);
		}
		return null;
	}
	
	protected AnnotationType getAnnotationType(RoomModel model, String name) {
		for(AnnotationType at : model.getAnnotationTypes()) {
			if(at.getName().equals(name)) {
				return at;
			}
		}
		return null;
	}
	
	private RoomClass getRoomClass(RoomModel model, String className) {
		for (DataClass dc : model.getDataClasses()) {
			if (dc.getName() != null && dc.getName().equals(className))
				return dc;
		}
		for (ExternalType et : model.getExternalTypes()) {
			if (et.getName() != null && et.getName().equals(className))
				return et;
		}
		for (PrimitiveType pt : model.getPrimitiveTypes()) {
			if (pt.getName() != null && pt.getName().equals(className))
				return pt;
		}
		for (GeneralProtocolClass pc : model.getProtocolClasses()) {
			if (pc.getName() != null && pc.getName().equals(className))
				return pc;
		}
		for (ActorClass ac : model.getActorClasses()) {
			if (ac.getName() != null && ac.getName().equals(className))
				return ac;
		}
		for (SubSystemClass ssc : model.getSubSystemClasses()) {
			if (ssc.getName() != null && ssc.getName().equals(className))
				return ssc;
		}
		for (LogicalSystem ls : model.getSystems()) {
			if (ls.getName() != null && ls.getName().equals(className))
				return ls;
		}
		return null;
	}

}
