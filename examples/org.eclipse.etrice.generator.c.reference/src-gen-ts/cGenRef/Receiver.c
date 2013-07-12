/**
 * @author generated by eTrice
 *
 * Source File of ActorClass Receiver
 * 
 */

#include "Receiver.h"

#include "modelbase/etActor.h"
#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"
#include "etUnit/etUnit.h"
#include "platform/etMemory.h"

#include "CommunicationProtocol.h"


/* interface item IDs */
enum interface_items {
	IFITEM_dataIn = 1
};


/* state IDs */
enum state_ids {
	NO_STATE = 0,
	STATE_TOP = 1,
	STATE_Idle = 2,
	STATE_DataReceived = 3
};

static char* state_names[] = {
		"NO_STATE", "TOP", "Idle", "DataReceived"
};

/* transition chains */
enum chain_ids {
	CHAIN_TRANS_INITIAL_TO__Idle = 1,
	CHAIN_TRANS_tr0_FROM_Idle_TO_DataReceived_BY_sendDatadataIn = 2
};

/* triggers */
enum triggers {
	POLLING = 0,
	TRIG_dataIn__sendData = IFITEM_dataIn + EVT_SHIFT*CommunicationProtocol_IN_sendData
};


static void setState(Receiver* self, int new_state) {
	etLogger_logInfoF("Receiver: setState: new state=%d", new_state);
	ET_MSC_LOGGER_CHANGE_STATE("Receiver", state_names[new_state]);
	self->state = new_state;
}

/* Entry and Exit Codes */

/* Action Codes */
static void action_TRANS_tr0_FROM_Idle_TO_DataReceived_BY_sendDatadataIn(Receiver* self, InterfaceItemBase *ifitem) {
	CommunicationProtocolPort_receivedData(&self->constData->dataIn) /* ORIG: dataIn.receivedData() */;
}

/**
 * calls exit codes while exiting from the current state to one of its
 * parent states while remembering the history
 * @param current - the current state
 * @param to - the final parent state
 * @param handler - entry and exit codes are called only if not handler (for handler TransitionPoints)
 */
static void exitTo(Receiver* self, int current, int to, boolean handler) {
	while (current!=to) {
		switch (current) {
			case STATE_Idle:
				self->history[STATE_TOP] = STATE_Idle;
				current = STATE_TOP;
				break;
			case STATE_DataReceived:
				self->history[STATE_TOP] = STATE_DataReceived;
				current = STATE_TOP;
				break;
		}
	}
}

/**
 * calls action, entry and exit codes along a transition chain. The generic data are cast to typed data
 * matching the trigger of this chain. The ID of the final state is returned
 * @param chain - the chain ID
 * @param generic_data - the generic data pointer
 * @return the ID of the final state
 */
static int executeTransitionChain(Receiver* self, int chain, InterfaceItemBase *ifitem, void* generic_data) {
	switch (chain) {
		case CHAIN_TRANS_INITIAL_TO__Idle:
		{
			return STATE_Idle;
		}
		case CHAIN_TRANS_tr0_FROM_Idle_TO_DataReceived_BY_sendDatadataIn:
		{
			action_TRANS_tr0_FROM_Idle_TO_DataReceived_BY_sendDatadataIn(self, ifitem);
			return STATE_DataReceived;
		}
	}
	return NO_STATE;
}

/**
 * calls entry codes while entering a state's history. The ID of the final leaf state is returned
 * @param state - the state which is entered
 * @param handler - entry code is executed if not handler
 * @return - the ID of the final leaf state
 */
static int enterHistory(Receiver* self, int state, boolean handler, boolean skip_entry) {
	while (TRUE) {
		switch (state) {
			case STATE_Idle:
				// in leaf state: return state id
				return STATE_Idle;
			case STATE_DataReceived:
				// in leaf state: return state id
				return STATE_DataReceived;
			case STATE_TOP:
				state = self->history[STATE_TOP];
				break;
		}
		skip_entry = FALSE;
	}
	//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
}

static void executeInitTransition(Receiver* self) {
	int chain = CHAIN_TRANS_INITIAL_TO__Idle;
	int next = executeTransitionChain(self, chain, NULL, NULL);
	next = enterHistory(self, next, FALSE, FALSE);
	setState(self, next);
}

/* receiveEvent contains the main implementation of the FSM */
static void receiveEvent(Receiver* self, InterfaceItemBase *ifitem, int evt, void* generic_data) {
	int trigger = ifitem->localId + EVT_SHIFT*evt;
	int chain = NOT_CAUGHT;
	int catching_state = NO_STATE;
	boolean is_handler = FALSE;
	boolean skip_entry = FALSE;
	ET_MSC_LOGGER_SYNC_ENTRY("Receiver", "receiveEvent")
	
	if (!handleSystemEvent(ifitem, evt, generic_data)) {
		switch (self->state) {
			case STATE_Idle:
				switch(trigger) {
					case TRIG_dataIn__sendData:
						{
							chain = CHAIN_TRANS_tr0_FROM_Idle_TO_DataReceived_BY_sendDatadataIn;
							catching_state = STATE_TOP;
						}
					break;
				}
				break;
			case STATE_DataReceived:
				break;
		}
	}
	if (chain != NOT_CAUGHT) {
		exitTo(self, self->state, catching_state, is_handler);
		int next = executeTransitionChain(self, chain, ifitem, generic_data);
		next = enterHistory(self, next, is_handler, skip_entry);
		setState(self, next);
	}
	ET_MSC_LOGGER_SYNC_EXIT
}
	 
//******************************************
// END of generated code for FSM
//******************************************

void Receiver_init(Receiver* self){
	ET_MSC_LOGGER_SYNC_ENTRY("Receiver", "init")
	self->state = STATE_TOP;
	{
		int i;
		for (i=0; i<RECEIVER_HISTORY_SIZE; ++i)
			self->history[i] = NO_STATE;
	}
	executeInitTransition(self);
	ET_MSC_LOGGER_SYNC_EXIT
}


void Receiver_receiveMessage(void* self, void* ifitem, const etMessage* msg){
	ET_MSC_LOGGER_SYNC_ENTRY("Receiver", "receiveMessage")
	
	receiveEvent(self, (etPort*)ifitem, msg->evtID, (void*)(((char*)msg)+MEM_CEIL(sizeof(etMessage))));
	
	ET_MSC_LOGGER_SYNC_EXIT
}


/*--------------------- operations ---------------------*/

