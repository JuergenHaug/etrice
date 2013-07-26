/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.RTObject;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class ReplicatedInterfaceItemBase extends RTObject implements IReplicatedInterfaceItem, IInterfaceItemOwner {

	private int localId;
	private ArrayList<InterfaceItemBase> items = new ArrayList<InterfaceItemBase>();
	private LinkedList<Integer> releasedIndices = new LinkedList<Integer>();

	/**
	 * @param owner
	 * @param name
	 * @param localId
	 */
	protected ReplicatedInterfaceItemBase(IInterfaceItemOwner owner, String name, int localId) {
		super(owner, name);
		
		this.localId = localId;
		
		List<String> peerPaths = getParent().getPeersForPath(getInstancePath());
		if (peerPaths!=null) {
			for (String path : peerPaths) {
				IRTObject object = getObject(path);
				InterfaceItemBase peer = null;
				if (object instanceof InterfaceItemBase) {
					peer = ((InterfaceItemBase) object);
				}
				else if (object instanceof IReplicatedInterfaceItem) {
					peer = ((IReplicatedInterfaceItem) object).createSubInterfaceItem();
				}
				if (peer!=null) {
					InterfaceItemBase item = createSubInterfaceItem();
					item.connectWith(peer);
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.runtime.java.modelbase.IReplicatedInterfaceItem#createSubInterfaceItem()
	 */
	@Override
	public InterfaceItemBase createSubInterfaceItem() {
		InterfaceItemBase item = createInterfaceItem(this, getName()+items.size(), localId, getFreeIndex());
		items.add(item);
		return item;
	}
	
	public void removeItem(InterfaceItemBase item) {
		assert(item.getParent()==this): "is own child";
		releasedIndices.push(item.getIdx());
		items.remove(item);
	}
	
	private int getFreeIndex() {
		if (releasedIndices.isEmpty())
			return items.size();
		else
			return releasedIndices.pop();
	}
	
	public InterfaceItemBase getInterfaceItem(int idx) {
		for (InterfaceItemBase item : items) {
			if (item.getIdx()==idx)
				return item;
		}
		
		return null;
	}
	
	public int getNInterfaceItems() {
		return items.size();
	}
	
	public int getLocalId() {
		return localId;
	}
	
	@Override
	public IEventReceiver getEventReceiver() {
		return (IEventReceiver) getParent();
	}
	
	@Override
	public IReplicatedInterfaceItem getSystemPort() {
		return ((IInterfaceItemOwner)getParent()).getSystemPort();
	}
	
	protected ArrayList<InterfaceItemBase> getItems() {
		return items;
	}
	
	protected abstract InterfaceItemBase createInterfaceItem(IInterfaceItemOwner rcv, String name, int lid, int idx);
}
