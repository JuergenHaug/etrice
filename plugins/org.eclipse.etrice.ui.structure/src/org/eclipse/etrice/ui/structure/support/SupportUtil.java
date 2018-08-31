/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package org.eclipse.etrice.ui.structure.support;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.RefSAPoint;
import org.eclipse.etrice.core.room.RelaySAPoint;
import org.eclipse.etrice.core.room.SAPoint;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.SPPoint;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.room.util.RoomNewNamingUtil;
import org.eclipse.etrice.core.ui.RoomUiModule;
import org.eclipse.etrice.core.validation.ValidationUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * description
 *
 * @author Henrik Rentz-Reichert initial contribution and API
 *
 */
public class SupportUtil {

	public static final String SEP = "#";
	
	private static SupportUtil instance = null;
	
	
	/**
	 * @return the instance
	 */
	public static SupportUtil getInstance() {
		if (instance==null) {
			Injector injector = RoomUiModule.getInjector();
	        instance = injector.getInstance(SupportUtil.class);
		}
		return instance;
	}
	
	@Inject
	private RoomHelpers roomHelpers;
	@Inject
	private ValidationUtil validationUtil;
	@Inject
	private RoomNameProvider roomNameProvider;
	@Inject
	private RoomNewNamingUtil roomUtil;

	/**
	 * @return the roomHelpers
	 */
	public RoomHelpers getRoomHelpers() {
		return roomHelpers;
	}

	/**
	 * @return the validationUtil
	 */
	public ValidationUtil getValidationUtil() {
		return validationUtil;
	}
	
	/**
	 * @return the roomUtil
	 */
	public RoomNewNamingUtil getRoomUtil() {
		return roomUtil;
	}

	/**
	 * @return the roomNameProvider
	 */
	public RoomNameProvider getRoomNameProvider() {
		return roomNameProvider;
	}
	
	public EObject getOwnObject(EObject obj, ResourceSet rs) {
		URI uri = EcoreUtil.getURI(obj);
		EObject own = rs.getEObject(uri, true);
		assert(own!=null): "own object must exist";
		return own;
	}
	
	public ContainerShape addItem(EObject obj, int x, int y, ContainerShape container, IFeatureProvider fp) {
		return addItem(obj, x, y, container, null, fp);
	}
	
	public ContainerShape addItem(EObject obj, int x, int y, ContainerShape container, Map<String,Anchor> ifitem2anchor, IFeatureProvider fp) {
		AddContext addContext = new AddContext();

		addContext.setNewObject(obj);
		addContext.setTargetContainer(container);
		addContext.setX(x);
		addContext.setY(y);
		ContainerShape newShape = (ContainerShape) fp.addIfPossible(addContext);
		assert(newShape!=null): "shape creation must succeed";
		
		if (ifitem2anchor!=null) {
			if (obj instanceof ActorContainerRef)
				getAnchors((ActorContainerRef)obj, newShape, ifitem2anchor);
			else if (obj instanceof InterfaceItem) {
				assert(!newShape.getAnchors().isEmpty()): "interface item must have an anchor";
				ifitem2anchor.put(SEP+((InterfaceItem)obj).getName(), newShape.getAnchors().get(0));
			}
		}
		
		return newShape;
	}

	public void getAnchors(ActorContainerRef acr, PictogramElement refShape,
			final Map<String, Anchor> ifitem2anchor) {
		
		if (refShape instanceof ContainerShape) {
			ifitem2anchor.put(acr.getName()+SEP, ((ContainerShape)refShape).getAnchors().get(0));
			for (Shape child : ((ContainerShape) refShape).getChildren()) {
				if (child instanceof ContainerShape) {
					ContainerShape childShape = (ContainerShape) child;
					if (!childShape.getAnchors().isEmpty()) {
						if (!childShape.getLink().getBusinessObjects().isEmpty()) {
							EObject obj = childShape.getLink().getBusinessObjects().get(0);
							if (obj instanceof Port) {
								ifitem2anchor.put(acr.getName()+SEP+((Port)obj).getName(), childShape.getAnchors().get(0));
							}
							if (obj instanceof SPP) {
								ifitem2anchor.put(acr.getName()+SEP+((SPP)obj).getName(), childShape.getAnchors().get(0));
							}
						}
					}
				}
			}
		}
	}
	
	public void addRefItem(ActorContainerRef obj, ContainerShape acShape, int x, int y, IFeatureProvider featureProvider, final Map<String, Anchor> ifitem2anchor) {
		AddContext addContext = new AddContext();
		addContext.setNewObject(obj);
		addContext.setTargetContainer(acShape);
		addContext.setX(x);
		addContext.setY(y);
		
		ContainerShape refShape = (ContainerShape) featureProvider.addIfPossible(addContext);
		
		getAnchors(obj, refShape, ifitem2anchor);
	}

	public void addInterfaceItem(InterfaceItem item, ContainerShape acShape, int x, int y, IFeatureProvider featureProvider, final Map<String, Anchor> ifitem2anchor) {
		AddContext addContext = new AddContext();
		addContext.setNewObject(item);
		addContext.setTargetContainer(acShape);
		addContext.setX(x);
		addContext.setY(y);
		
		ContainerShape pe = (ContainerShape) featureProvider.addIfPossible(addContext);
		assert(!pe.getAnchors().isEmpty()): "interface item should have an anchor";
		ifitem2anchor.put(SEP+item.getName(), pe.getAnchors().get(0));
	}

	public void addBinding(Binding bind, IFeatureProvider featureProvider,
			final Map<String, Anchor> ifitem2anchor) {
		String ep1 = getName(bind.getEndpoint1());
		String ep2 = getName(bind.getEndpoint2());
		Anchor a1 = ifitem2anchor.get(ep1);
		Anchor a2 = ifitem2anchor.get(ep2);
		assert(a1!=null && a2!=null): "ports for binding must be present";
		
		AddConnectionContext context = new AddConnectionContext(a1, a2);
		context.setNewObject(bind);
		featureProvider.addIfPossible(context);
	}

	public void addLayerConnection(LayerConnection lc, IFeatureProvider featureProvider,
			final Map<String, Anchor> ifitem2anchor) {
		String ep1 = getName(lc.getFrom());
		String ep2 = getName(lc.getTo());
		Anchor a1 = ifitem2anchor.get(ep1);
		Anchor a2 = ifitem2anchor.get(ep2);
		assert(a1!=null && a2!=null): "spps for layer connection must be present";
		
		AddConnectionContext context = new AddConnectionContext(a1, a2);
		context.setNewObject(lc);
		featureProvider.addIfPossible(context);
	}

	public void addInterfaceItems(List<? extends InterfaceItem> items, int y, ContainerShape acShape, int width,
			IFeatureProvider fp,
			final Map<String, Anchor> ifitem2anchor) {
		
		int n = items.size();
		int delta = width/(n+1);
		int pos = delta;
		for (InterfaceItem item : items) {
			addInterfaceItem(item, acShape, pos+StructureClassSupport.MARGIN, y, fp, ifitem2anchor);
			pos += delta;
		}
	}
	
	public void addRefItems(List<? extends ActorContainerRef> actorRefs,
			ContainerShape acShape, int width,
			IFeatureProvider fp, final Map<String, Anchor> ifitem2anchor) {
		int ncols = width/ActorContainerRefSupport.DEFAULT_SIZE_X;
		int nrows = actorRefs.size()/ncols;
		int gap = (width-(ncols*ActorContainerRefSupport.DEFAULT_SIZE_X))/(ncols+1);
		int delta = gap+ActorContainerRefSupport.DEFAULT_SIZE_X;
		int x0 = gap+ActorContainerRefSupport.DEFAULT_SIZE_X/2;
		int y0 = ActorContainerRefSupport.DEFAULT_SIZE_Y*5/2;
		int i = 0;
		for (ActorContainerRef ar : actorRefs) {
			int row = i/ncols;
			int col = i%ncols;
			if (row>=nrows) {
				int nc = actorRefs.size()%ncols;
				gap = (width-(nc*ActorContainerRefSupport.DEFAULT_SIZE_X))/(nc+1);
				delta = gap+ActorContainerRefSupport.DEFAULT_SIZE_X;
				x0 = gap+ActorContainerRefSupport.DEFAULT_SIZE_X/2;
			}
			int x = x0+delta*col;
			int y = y0+(ActorContainerRefSupport.MARGIN+ActorContainerRefSupport.DEFAULT_SIZE_Y)*row;
			addRefItem(ar, acShape, x+StructureClassSupport.MARGIN, y+StructureClassSupport.MARGIN, fp, ifitem2anchor);
			++i;
		}
	}

	public String getName(BindingEndPoint ep) {
		String ar = ep.getActorRef()==null? "":ep.getActorRef().getName();
		String p = ep.getPort().getName();
		return ar+SEP+p;
	}

	public String getName(SAPoint sapt) {
		if (sapt instanceof RelaySAPoint) {
			return SEP+((RelaySAPoint)sapt).getRelay().getName();
		}
		else if (sapt instanceof RefSAPoint) {
			RefSAPoint rpt = (RefSAPoint) sapt;
			return rpt.getRef().getName()+SEP;
		}
		assert(false): "unexpected sub type";
		return null;
	}

	public String getName(SPPoint sppt) {
		return sppt.getRef().getName()+SEP+sppt.getService().getName();
	}

	public List<InterfaceItem> getInterfaceItems(ContainerShape shape, IFeatureProvider fp) {
		return getInterfaceItems(shape, fp, null);
	}
	
	public List<InterfaceItem> getInterfaceItems(ContainerShape shape, IFeatureProvider fp, Map<String, Anchor> ifitem2anchor) {
		List<InterfaceItem> items = new ArrayList<InterfaceItem>();
		for (Shape ch : shape.getChildren()) {
			Object bo = fp.getBusinessObjectForPictogramElement(ch);
			if (bo instanceof InterfaceItem) {
				items.add((InterfaceItem)bo);
				if (ifitem2anchor!=null)
					ifitem2anchor.put(SEP+((InterfaceItem)bo).getName(), ch.getAnchors().get(0));
			}
		}
		return items;
	}
	
	public List<ActorContainerRef> getRefs(ContainerShape shape, IFeatureProvider fp) {
		return getRefs(shape, fp, null);
	}
	
	public List<ActorContainerRef> getRefs(ContainerShape shape, IFeatureProvider fp, Map<String, Anchor> ifitem2anchor) {
		List<ActorContainerRef> refs = new ArrayList<ActorContainerRef>();
		for (Shape ch : shape.getChildren()) {
			Object bo = fp.getBusinessObjectForPictogramElement(ch);
			if (bo instanceof ActorContainerRef) {
				refs.add((ActorContainerRef)bo);
				if (ifitem2anchor!=null)
					getAnchors((ActorContainerRef)bo, ch, ifitem2anchor);
			}
		}
		return refs;
	}

	public List<Binding> getBindings(Diagram diag, IFeatureProvider fp) {
		List<Binding> bindings = new ArrayList<Binding>();
		
		for (Connection conn : diag.getConnections()) {
			Object bo = fp.getBusinessObjectForPictogramElement(conn);
			if (bo instanceof Binding)
				bindings.add((Binding)bo);
		}
		return bindings;
	}

	public List<LayerConnection> getConnections(Diagram diag, IFeatureProvider fp) {
		List<LayerConnection> bindings = new ArrayList<LayerConnection>();
		
		for (Connection conn : diag.getConnections()) {
			Object bo = fp.getBusinessObjectForPictogramElement(conn);
			if (bo instanceof LayerConnection)
				bindings.add((LayerConnection)bo);
		}
		return bindings;
	}
	
	public StructureClass getParent(ICreateConnectionContext context, IFeatureProvider fp) {
		ContainerShape shape = (ContainerShape) context.getSourcePictogramElement().eContainer();
		return getParent(shape, fp);
	}
	
	public StructureClass getParent(ContainerShape shape, IFeatureProvider fp) {
		if(shape == null)
			return null;
		
		Object bo = fp.getBusinessObjectForPictogramElement(shape);
		if (bo instanceof StructureClass)
			return (StructureClass) bo;
		
		shape = (ContainerShape) shape.eContainer();
		bo = fp.getBusinessObjectForPictogramElement(shape);
		if (bo instanceof StructureClass)
			return (StructureClass) bo;
		
		return null;
	}

	public Port getPort(Anchor anchor, IFeatureProvider fp) {
		if (anchor != null) {
			Object obj = fp.getBusinessObjectForPictogramElement(anchor.getParent());
			if (obj instanceof Port) {
				return (Port) obj;
			}
		}
		return null;
	}

	public SPP getSPP(Anchor anchor, IFeatureProvider fp) {
		if (anchor != null) {
			Object obj = fp.getBusinessObjectForPictogramElement(anchor.getParent());
			if (obj instanceof SPP) {
				return (SPP) obj;
			}
		}
		return null;
	}
	
	public ActorContainerRef getRef(Anchor anchor, IFeatureProvider fp) {
		if (anchor != null) {
			ContainerShape shape = (ContainerShape) anchor.getParent().eContainer();
			Object bo = fp.getBusinessObjectForPictogramElement(shape);
			if (bo instanceof ActorContainerRef)
				return (ActorContainerRef) bo;
			shape = (ContainerShape) anchor.getParent();
			bo = fp.getBusinessObjectForPictogramElement(shape);
			if (bo instanceof ActorContainerRef)
				return (ActorContainerRef) bo;
		}				
		return null;
	}
}
