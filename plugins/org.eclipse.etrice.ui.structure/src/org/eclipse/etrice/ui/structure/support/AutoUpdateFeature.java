package org.eclipse.etrice.ui.structure.support;

import java.util.ArrayList;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;

/**
 * @author Henrik Rentz-Reichert - initial contribution and API
 *
 */
public class AutoUpdateFeature extends AbstractUpdateFeature {

	public AutoUpdateFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		return true;
	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {
		return Reason.createFalseReason();
	}

	@Override
	public boolean update(IUpdateContext context) {
		boolean doneChanges = updateConnections(getDiagram());
		
		if (updateIfNeeded(getDiagram()))
			doneChanges = true;
		
		if (doneChanges)
			return true;

		return false;
	}

	/**
	 * This just removes dangling connections (bindings and layer connections).
	 * New ones are added by the structure class support.
	 * 
	 * @param diagram
	 * @return
	 */
	private boolean updateConnections(Diagram diagram) {
		boolean doneChanges = false;

		ArrayList<Connection> connections = new ArrayList<Connection>(diagram.getConnections());
		for (Connection conn : connections) {
			UpdateContext context = new UpdateContext(conn);
			IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(context);
			if (updateFeature.canUpdate(context))
				if (updateFeature.updateNeeded(context).toBoolean())
					if (updateFeature.update(context))
						doneChanges = true;
		}
		return doneChanges;
	}

	/**
	 * @param diagram
	 * @return
	 */
	private boolean updateIfNeeded(ContainerShape container) {
		boolean doneChanges = false;
		
		// first recursion because ref ports might be needed for bindings
		// we need to make a copy since children might be removed
		ArrayList<Shape> children = new ArrayList<Shape>(container.getChildren());
		for (Shape child : children) {
			if (child instanceof ContainerShape)
				if (updateIfNeeded((ContainerShape) child))
					doneChanges = true;
		}
		
		UpdateContext context = new UpdateContext(container);
		IUpdateFeature updateFeature = getFeatureProvider().getUpdateFeature(context);
		if (updateFeature.canUpdate(context))
			if (updateFeature.updateNeeded(context).toBoolean())
				if (updateFeature.update(context))
					doneChanges = true;
		
		return doneChanges;
	}

}
