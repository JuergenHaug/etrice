/**
 * @author generated by eTrice
 *
 * Header File of ActorClass SequentialTestExecutor
 *
 */

#ifndef _ROOM_BASIC_TEST_SEQUENTIALTESTEXECUTOR_H_
#define _ROOM_BASIC_TEST_SEQUENTIALTESTEXECUTOR_H_

#include "etDatatypes.h"
#include "messaging/etMessage.h"

#include "room/basic/test/PTestControl.h"


typedef struct SequentialTestExecutor SequentialTestExecutor;

/* const part of ActorClass (ROM) */
typedef struct SequentialTestExecutor_const {
	const char* instName;

	/* simple ports */

	/* data receive ports */

	/* saps */

	/* replicated ports */
	const etReplPort control;

	/* services */
} SequentialTestExecutor_const;


/* constant for state machine data */
#define SEQUENTIALTESTEXECUTOR_HISTORY_SIZE 2

/* variable part of ActorClass (RAM) */
struct SequentialTestExecutor {
	const SequentialTestExecutor_const* const constData;

	/* data send ports */

	/*--------------------- attributes ---------------------*/
	 int16 next;


	/* state machine variables */
	etInt16 state;
	etInt16 history[SEQUENTIALTESTEXECUTOR_HISTORY_SIZE];
};

void SequentialTestExecutor_init(SequentialTestExecutor* self);

void SequentialTestExecutor_receiveMessage(void* self, const void* ifitem, const etMessage* msg);


/*--------------------- user constructor/destructor ---------------------*/

/*--------------------- operations ---------------------*/


#endif /* _ROOM_BASIC_TEST_SEQUENTIALTESTEXECUTOR_H_ */

