/**
 * @author generated by eTrice
 *
 * Instance File of SubSystemClass SubSys
 * - instantiation of all actor instances and port instances
 * - configuration of data and connection of ports
 */

#include "platform/etMemory.h"

/* include all used ActorClasses */
#include "Receiver.h"
#include "Sender.h"

/* include all used ProtcolClasses */
#include "CommunicationProtocol.h"


/* instantiation of message services */
/* PhysicalThread1 */
// TODO: generate sizes
static uint8 msgBuffer_PhysicalThread1[MESSAGE_POOL_MAX*MESSAGE_BLOCK_SIZE];
static etMessageService msgService_PhysicalThread1;

/* PhysicalThread2 */
static uint8 msgBuffer_PhysicalThread2[MESSAGE_POOL_MAX*MESSAGE_BLOCK_SIZE];
static etMessageService msgService_PhysicalThread2;

/* declarations of all ActorClass instances (const and variable structs) */

/* forward declaration of variable actor structs */
static Sender _SubSys_Sender;
static Receiver _SubSys_Receiver;

/* forward declaration of variable port structs */		


/* instance _SubSys_Sender */
static const Sender_const _SubSys_Sender_const = {
	/* Ports: {varData, msgService, peerAddress, localId} */
	{0,&msgService_PhysicalThread2, 104, 1} /* Port dataOut */
	
	/* data receive ports */
};
static Sender _SubSys_Sender = {
	&_SubSys_Sender_const,
	
	/* data send ports */
	
	/* attributes */
	
	/* state and history are initialized in init fuction */
};

/* instance _SubSys_Receiver */
static const Receiver_const _SubSys_Receiver_const = {
	/* Ports: {varData, msgService, peerAddress, localId} */
	{0,&msgService_PhysicalThread1, 102, 1} /* Port dataIn */
	
	/* data receive ports */
};
static Receiver _SubSys_Receiver = {
	&_SubSys_Receiver_const,
	
	/* data send ports */
	
	/* attributes */
	{
		0,
		{
			0,
			0,
			0
		},
		0
	}
	,	/* attr1 */
	
	/* state and history are initialized in init fuction */
};

