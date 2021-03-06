/**
 * @author generated by eTrice
 *
 * Source File of ProtocolClass PTestControl
 * 
 */

#include "PTestControl.h"
#include "debugging/etMSCLogger.h"
#include "PTestControl_Utils.h"


/*--------------------- port methods */

void PTestControlPort_done(const PTestControlPort* self, bool data__et) {
	ET_MSC_LOGGER_SYNC_ENTRY("PTestControlPort", "done")
		etPort_sendMessage(self, PTestControl_OUT_done, sizeof(bool), &data__et);
		ET_MSC_LOGGER_ASYNC_OUT(self->myInstName, "done", self->peerInstName)
	ET_MSC_LOGGER_SYNC_EXIT
}

void PTestControlReplPort_done_broadcast(const PTestControlReplPort* self, bool data__et) {
	int i;
	ET_MSC_LOGGER_SYNC_ENTRY("PTestControlReplPort", "done")
	for (i=0; i<((etReplPort*)self)->size; ++i) {
		etPort_sendMessage((&((etReplPort*)self)->ports[i].port), PTestControl_OUT_done, sizeof(bool), &data__et);
		ET_MSC_LOGGER_ASYNC_OUT(((etReplPort*)self)->ports[i].port.myInstName, "done", ((etReplPort*)self)->ports[i].port.peerInstName)
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void PTestControlReplPort_done(const PTestControlReplPort* self, int idx__et, bool data__et) {
	ET_MSC_LOGGER_SYNC_ENTRY("PTestControlReplPort", "done")
	if (0<=idx__et && idx__et<((etReplPort*)self)->size) {
		etPort_sendMessage((&((etReplPort*)self)->ports[idx__et].port), PTestControl_OUT_done, sizeof(bool), &data__et);
		ET_MSC_LOGGER_ASYNC_OUT(((etReplPort*)self)->ports[idx__et].port.myInstName, "done", ((etReplPort*)self)->ports[idx__et].port.peerInstName)
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

etInt32 PTestControlReplPort_getReplication(const PTestControlReplPort* self) {
	return ((etReplPort*)self)->size;
}



void PTestControlConjPort_start(const PTestControlConjPort* self) {
	ET_MSC_LOGGER_SYNC_ENTRY("PTestControlConjPort", "start")
		etPort_sendMessage(self, PTestControl_IN_start, 0, NULL);
		ET_MSC_LOGGER_ASYNC_OUT(self->myInstName, "start", self->peerInstName)
	ET_MSC_LOGGER_SYNC_EXIT
}

void PTestControlConjReplPort_start_broadcast(const PTestControlConjReplPort* self) {
	int i;
	ET_MSC_LOGGER_SYNC_ENTRY("PTestControlConjReplPort", "start")
	for (i=0; i<((etReplPort*)self)->size; ++i) {
		etPort_sendMessage((&((etReplPort*)self)->ports[i].port), PTestControl_IN_start, 0, NULL);
		ET_MSC_LOGGER_ASYNC_OUT(((etReplPort*)self)->ports[i].port.myInstName, "start", ((etReplPort*)self)->ports[i].port.peerInstName)
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void PTestControlConjReplPort_start(const PTestControlConjReplPort* self, int idx__et) {
	ET_MSC_LOGGER_SYNC_ENTRY("PTestControlConjReplPort", "start")
	if (0<=idx__et && idx__et<((etReplPort*)self)->size) {
		etPort_sendMessage((&((etReplPort*)self)->ports[idx__et].port), PTestControl_IN_start, 0, NULL);
		ET_MSC_LOGGER_ASYNC_OUT(((etReplPort*)self)->ports[idx__et].port.myInstName, "start", ((etReplPort*)self)->ports[idx__et].port.peerInstName)
	}
	ET_MSC_LOGGER_SYNC_EXIT
}


void PTestControlConjPort_abort(const PTestControlConjPort* self) {
	ET_MSC_LOGGER_SYNC_ENTRY("PTestControlConjPort", "abort")
		etPort_sendMessage(self, PTestControl_IN_abort, 0, NULL);
		ET_MSC_LOGGER_ASYNC_OUT(self->myInstName, "abort", self->peerInstName)
	ET_MSC_LOGGER_SYNC_EXIT
}

void PTestControlConjReplPort_abort_broadcast(const PTestControlConjReplPort* self) {
	int i;
	ET_MSC_LOGGER_SYNC_ENTRY("PTestControlConjReplPort", "abort")
	for (i=0; i<((etReplPort*)self)->size; ++i) {
		etPort_sendMessage((&((etReplPort*)self)->ports[i].port), PTestControl_IN_abort, 0, NULL);
		ET_MSC_LOGGER_ASYNC_OUT(((etReplPort*)self)->ports[i].port.myInstName, "abort", ((etReplPort*)self)->ports[i].port.peerInstName)
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void PTestControlConjReplPort_abort(const PTestControlConjReplPort* self, int idx__et) {
	ET_MSC_LOGGER_SYNC_ENTRY("PTestControlConjReplPort", "abort")
	if (0<=idx__et && idx__et<((etReplPort*)self)->size) {
		etPort_sendMessage((&((etReplPort*)self)->ports[idx__et].port), PTestControl_IN_abort, 0, NULL);
		ET_MSC_LOGGER_ASYNC_OUT(((etReplPort*)self)->ports[idx__et].port.myInstName, "abort", ((etReplPort*)self)->ports[idx__et].port.peerInstName)
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

etInt32 PTestControlConjReplPort_getReplication(const PTestControlConjReplPort* self) {
	return ((etReplPort*)self)->size;
}



/*--------------------- debug helpers */

/* message names as strings for debugging (generate MSC) */
static const char* const PTestControl_messageStrings[] = {"MIN", "done","start", "abort", "MAX"};

const char* PTestControl_getMessageString(int msg_id) {
	if (msg_id<PTestControl_MSG_MIN || msg_id>PTestControl_MSG_MAX+1){
		/* id out of range */
		return "Message ID out of range";
	}
	else{
		return PTestControl_messageStrings[msg_id];
	}
}
