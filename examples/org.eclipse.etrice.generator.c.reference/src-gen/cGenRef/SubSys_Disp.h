/**
 * @author generated by eTrice
 *
 * Dispatcher File of SubSystemClass SubSys
 * - one generated dispatcher for each MessageService (Thread)
 */

#include "etMessageReceiver.h"
#include "etLogger.h"
#include "etMSCLogger.h"

void MsgDispatcher_Thread1_receiveMessage(const etMessage* msg){
	ET_MSC_LOGGER_SYNC_ENTRY("MsgDispatcher_Thread1", "receiveMessage")
	switch(msg->address){
	
		/* interface items of /SubSys/Receiver */
		case 102:
			etPort_receive(&_SubSys_Receiver_const.dataIn, msg);
			break;
		/* interface items of /SubSys/Sender */
		case 104:
			etPort_receive(&_SubSys_Sender_const.dataOut, msg);
			break;

		default:
			etLogger_logErrorF("MessageService_Thread1_ReceiveMessage: address %d does not exist ", msg->address);
			break;
	}
	ET_MSC_LOGGER_SYNC_EXIT
}
