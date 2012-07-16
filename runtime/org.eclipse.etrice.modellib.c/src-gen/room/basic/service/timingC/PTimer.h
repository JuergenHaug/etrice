/**
 * @author generated by eTrice
 *
 * Header File of ProtocolClass PTimer
 * 
 */

#ifndef _PTIMER_H_
#define _PTIMER_H_

#include "etDatatypes.h"
#include "modelbase/etPort.h"

/*--------------------- begin user code ---------------------*/
	
			#define ET_TIMER_RUNNING	0x01
			#define ET_TIMER_PERIODIC	0x02
/*--------------------- end user code ---------------------*/



/* message IDs */
enum PTimer_msg_ids {
	PTimer_MSG_MIN = 0,
	PTimer_OUT_timeout = 1,
	PTimer_IN_startTimer = 2,
	PTimer_IN_startTimeout = 3,
	PTimer_IN_kill = 4,
	PTimer_MSG_MAX = 5
};

/*--------------------- port structs and methods */
		typedef etPort PTimerPort;
		typedef etReplPort PTimerReplPort;
		
			
		void PTimerPort_timeout(const PTimerPort* self);
		void PTimerReplPort_timeout_broadcast(const PTimerReplPort* self);
		void PTimerReplPort_timeout(const PTimerReplPort* self, int idx);
			
		
etInt32 PTimerReplPort_getReplication(const PTimerReplPort* self);
		typedef etPort PTimerConjPort;
		typedef etReplPort PTimerConjReplPort;
		
/* variable part of PortClass (RAM) */
typedef struct PTimerConjPort_var PTimerConjPort_var; 
struct PTimerConjPort_var {
	/*--------------------- attributes ---------------------*/
	int8 status;
	};
			
		void PTimerConjPort_startTimer(const PTimerConjPort* self, uint32 data);
		void PTimerConjReplPort_startTimer_broadcast(const PTimerConjReplPort* self, uint32 data);
		void PTimerConjReplPort_startTimer(const PTimerConjReplPort* self, int idx, uint32 data);
		void PTimerConjPort_startTimeout(const PTimerConjPort* self, uint32 data);
		void PTimerConjReplPort_startTimeout_broadcast(const PTimerConjReplPort* self, uint32 data);
		void PTimerConjReplPort_startTimeout(const PTimerConjReplPort* self, int idx, uint32 data);
		void PTimerConjPort_kill(const PTimerConjPort* self);
		void PTimerConjReplPort_kill_broadcast(const PTimerConjReplPort* self);
		void PTimerConjReplPort_kill(const PTimerConjReplPort* self, int idx);
			
		/*--------------------- operations ---------------------*/
		/*--------------------- operations ---------------------*/
		
void PTimerConjPort_timeout_receiveHandler(PTimerConjPort* self, const etMessage* msg, void * actor, etActorReceiveMessage receiveMessageFunc);
etInt32 PTimerConjReplPort_getReplication(const PTimerConjReplPort* self);

/*--------------------- debug helpers */

/* get message string for message id */
const char* PTimer_getMessageString(int msg_id);

/*--------------------- begin user code ---------------------*/
	//uc2		
/*--------------------- end user code ---------------------*/

#endif /* _PTIMER_H_ */

