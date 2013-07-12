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

package org.eclipse.etrice.core.genmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedRefinedState;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class TestCodeInheritance extends TestInstanceModelBuilderBase {
	
	private Root root;
	private HashMap<EClass, ArrayList<EObject>> baseInstances;
	private HashMap<EClass, ArrayList<EObject>> derivedInstances;
	private ExpandedActorClass base;
	private ExpandedActorClass derived;

	@Before
	public void setUp() {
		prepare();
		
		root = buildInstanceModel("code_inheritance.room");
		base = getActor("Base");
		derived = getActor("Deriv");
		baseInstances = collectInstances(base);
		derivedInstances = collectInstances(derived);
	}

	private ExpandedActorClass getActor(String name) {
		for (ExpandedActorClass xpac : root.getXpActorClasses()) {
			if (xpac.getActorClass().getName().equals(name))
				return xpac;
		}
		return null;
	}
	
	private State getState(ExpandedActorClass xpac, String name) {
		for (State s : xpac.getStateMachine().getStates()) {
			if (s.getName().equals(name))
				return s;
		}
		return null;
	}
	
	@Test
	public void testNumbers() {
		assertEquals("number of states", 6, baseInstances.get(RoomPackage.eINSTANCE.getSimpleState()).size());
		assertNull("number of choice points", baseInstances.get(RoomPackage.eINSTANCE.getChoicePoint()));
		assertNull("number of transition points", baseInstances.get(RoomPackage.eINSTANCE.getTransitionPoint()));
		assertNull("number of entry points", baseInstances.get(RoomPackage.eINSTANCE.getEntryPoint()));
		assertNull("number of exit points", baseInstances.get(RoomPackage.eINSTANCE.getExitPoint()));
		assertEquals("number of initial transitions", 3, baseInstances.get(RoomPackage.eINSTANCE.getInitialTransition()).size());
		assertEquals("number of triggered transitions", 3, baseInstances.get(RoomPackage.eINSTANCE.getTriggeredTransition()).size());
		assertNull("number of continuation transitions", baseInstances.get(RoomPackage.eINSTANCE.getContinuationTransition()));
		assertNull("number of branch transitions", baseInstances.get(RoomPackage.eINSTANCE.getCPBranchTransition()));

		assertEquals("number of states", 4, derivedInstances.get(RoomPackage.eINSTANCE.getSimpleState()).size());
		assertEquals("number of states", 3, derivedInstances.get(ETriceGenPackage.eINSTANCE.getExpandedRefinedState()).size());
		assertNull("number of choice points", derivedInstances.get(RoomPackage.eINSTANCE.getChoicePoint()));
		assertNull("number of transition points", derivedInstances.get(RoomPackage.eINSTANCE.getTransitionPoint()));
		assertNull("number of entry points", derivedInstances.get(RoomPackage.eINSTANCE.getEntryPoint()));
		assertNull("number of exit points", derivedInstances.get(RoomPackage.eINSTANCE.getExitPoint()));
		assertEquals("number of initial transitions", 4, derivedInstances.get(RoomPackage.eINSTANCE.getInitialTransition()).size());
		assertEquals("number of triggered transitions", 3, derivedInstances.get(RoomPackage.eINSTANCE.getTriggeredTransition()).size());
		assertNull("number of continuation transitions", derivedInstances.get(RoomPackage.eINSTANCE.getContinuationTransition()));
		assertNull("number of branch transitions", derivedInstances.get(RoomPackage.eINSTANCE.getCPBranchTransition()));
	}
	
	@Test
	public void testActionCodes() {
		State s = getState(derived, "BaseEntryExit");
		assertTrue("is ExpandedRefinedState", s instanceof ExpandedRefinedState);
		ExpandedRefinedState rs = (ExpandedRefinedState) s;
		assertEquals("entry code", "// derived entry\n", RoomHelpers.getDetailCode(rs.getEntryCode()));
		assertNull("exit code", rs.getExitCode());
		assertEquals("inherited entry", "// base entry\n", RoomHelpers.getDetailCode(rs.getInheritedEntry()));
		assertEquals("inherited exit", "// base exit\n", RoomHelpers.getDetailCode(rs.getInheritedExit()));
		
		s = getState(derived, "Base");
		assertTrue("is ExpandedRefinedState", s instanceof ExpandedRefinedState);
		rs = (ExpandedRefinedState) s;
		assertNull("entry code", rs.getEntryCode());
		assertEquals("exit code", "// derived exit\n", RoomHelpers.getDetailCode(rs.getExitCode()));
		assertEquals("inherited entry", "", RoomHelpers.getDetailCode(rs.getInheritedEntry()));
		assertEquals("inherited exit", "", RoomHelpers.getDetailCode(rs.getInheritedExit()));
		
		s = getState(derived, "BaseSub");
		assertTrue("is ExpandedRefinedState", s instanceof ExpandedRefinedState);
		rs = (ExpandedRefinedState) s;
		assertEquals("entry code", "// derived entry\n", RoomHelpers.getDetailCode(rs.getEntryCode()));
		assertNull("exit code", rs.getExitCode());
		assertEquals("inherited entry", "", RoomHelpers.getDetailCode(rs.getInheritedEntry()));
		assertEquals("inherited exit", "", RoomHelpers.getDetailCode(rs.getInheritedExit()));
	}

}
