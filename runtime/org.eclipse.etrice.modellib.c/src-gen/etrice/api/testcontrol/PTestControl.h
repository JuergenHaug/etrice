/**
 * @author generated by eTrice
 *
 * Header File of ProtocolClass PTestControl
 * 
 */

#ifndef _ETRICE_API_TESTCONTROL_PTESTCONTROL_H_
#define _ETRICE_API_TESTCONTROL_PTESTCONTROL_H_

#include "etDatatypes.h"
#include "modelbase/etPort.h"


/* include all referenced room classes */


/* message IDs */
enum PTestControl_msg_ids {
	PTestControl_MSG_MIN = 0,
	PTestControl_OUT_done = 1,
	PTestControl_IN_start = 2,
	PTestControl_IN_abort = 3,
	PTestControl_MSG_MAX = 4
};

/*--------------------- port structs and methods */
typedef etPort PTestControlPort;
typedef etReplPort PTestControlReplPort;


void PTestControlPort_done(const PTestControlPort* self, bool data);
void PTestControlReplPort_done_broadcast(const PTestControlReplPort* self, bool data);
void PTestControlReplPort_done(const PTestControlReplPort* self, int idx, bool data);


etInt32 PTestControlReplPort_getReplication(const PTestControlReplPort* self);
typedef etPort PTestControlConjPort;
typedef etReplPort PTestControlConjReplPort;


void PTestControlConjPort_start(const PTestControlConjPort* self);
void PTestControlConjReplPort_start_broadcast(const PTestControlConjReplPort* self);
void PTestControlConjReplPort_start(const PTestControlConjReplPort* self, int idx);
void PTestControlConjPort_abort(const PTestControlConjPort* self);
void PTestControlConjReplPort_abort_broadcast(const PTestControlConjReplPort* self);
void PTestControlConjReplPort_abort(const PTestControlConjReplPort* self, int idx);


etInt32 PTestControlConjReplPort_getReplication(const PTestControlConjReplPort* self);

/*--------------------- debug helpers */

/* get message string for message id */
const char* PTestControl_getMessageString(int msg_id);


#endif /* _ETRICE_API_TESTCONTROL_PTESTCONTROL_H_ */

