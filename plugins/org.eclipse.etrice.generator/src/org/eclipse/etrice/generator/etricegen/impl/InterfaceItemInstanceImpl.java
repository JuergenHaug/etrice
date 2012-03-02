/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.etrice.generator.etricegen.impl;


import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.generator.etricegen.ETriceGenPackage;
import org.eclipse.etrice.generator.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.generator.etricegen.PortInstance;
import org.eclipse.etrice.generator.etricegen.PortKind;
import org.eclipse.etrice.generator.etricegen.SAPInstance;
import org.eclipse.etrice.generator.etricegen.ServiceImplInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Item Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.etrice.generator.etricegen.impl.InterfaceItemInstanceImpl#getPeers <em>Peers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceItemInstanceImpl extends InstanceBaseImpl implements InterfaceItemInstance {
	/**
	 * The cached value of the '{@link #getPeers() <em>Peers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeers()
	 * @generated
	 * @ordered
	 */
	protected EList<InterfaceItemInstance> peers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceItemInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ETriceGenPackage.Literals.INTERFACE_ITEM_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InterfaceItemInstance> getPeers() {
		if (peers == null) {
			peers = new EObjectResolvingEList<InterfaceItemInstance>(InterfaceItemInstance.class, this, ETriceGenPackage.INTERFACE_ITEM_INSTANCE__PEERS);
		}
		return peers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isReplicated() {
		if (this instanceof PortInstance) {
			PortInstance pi = (PortInstance) this;
			if (pi.getKind()==PortKind.RELAY)
				return false;
			
			return pi.getPort().getMultiplicity()!=1;
		}
		else if (this instanceof SAPInstance)
			return false;
		else if (this instanceof ServiceImplInstance)
			return true;
		
		assert(false): "unexpected sub class";
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSimple() {
		if (this instanceof PortInstance)
			if (((PortInstance) this).getKind()==PortKind.RELAY)
				return false;
		
		return !isReplicated();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isRelay() {
		if (this instanceof PortInstance)
			if (((PortInstance) this).getKind()==PortKind.RELAY)
				return true;

		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public InterfaceItem getInterfaceItem() {
		if (this instanceof PortInstance)
			return ((PortInstance) this).getPort();
		else if (this instanceof SAPInstance)
			return ((SAPInstance)this).getSap();
		else if (this instanceof ServiceImplInstance)
			return ((ServiceImplInstance)this).getSvcImpl().getSpp();
		
		assert(false): "unexpected sub class";
		return null;
	}

	public int getNObjIDs() {
		int n = getPeers().size();
		if (n==0)
			n = 1;
		return n;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ETriceGenPackage.INTERFACE_ITEM_INSTANCE__PEERS:
				return getPeers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ETriceGenPackage.INTERFACE_ITEM_INSTANCE__PEERS:
				getPeers().clear();
				getPeers().addAll((Collection<? extends InterfaceItemInstance>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ETriceGenPackage.INTERFACE_ITEM_INSTANCE__PEERS:
				getPeers().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ETriceGenPackage.INTERFACE_ITEM_INSTANCE__PEERS:
				return peers != null && !peers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InterfaceItemInstanceImpl
