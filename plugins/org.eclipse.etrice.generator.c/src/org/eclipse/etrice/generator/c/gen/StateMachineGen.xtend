/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.c.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.generator.etricegen.ExpandedActorClass
import org.eclipse.etrice.generator.extensions.RoomExtensions
import org.eclipse.etrice.generator.generic.GenericStateMachineGenerator

@Singleton
class StateMachineGen extends GenericStateMachineGenerator {
	
	@Inject extension RoomExtensions
	
	def genDataMembers(ExpandedActorClass xpac, ActorClass ac) {'''
		/* state machine variables */
		etInt16 state;
		etInt16 history[�xpac.allLeafStates.size+1/* TODO: can save one entry if NO_STATE=-1 but influences Java */�];
	'''}
	
	def genInitialization(ExpandedActorClass xpac, ActorClass ac) {'''
		self->state = STATE_TOP;
		{
			int i;
			for (i=0; i<�xpac.allLeafStates.size�; ++i)
				self->history[i] = NO_STATE;
		}
		executeInitTransition(self);
	'''}
	
	override genExtra(ExpandedActorClass xpac, ActorClass ac) {'''

		�langExt.accessLevelPrivate�void setState(�ac.name�* self, int new_state) {
			self->state = new_state;
		}
	'''
	}
}
