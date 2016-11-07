/**
 * @author generated by eTrice
 *
 * Source File of ProtocolClass RTSystemServicesProtocol
 *
 */

#include "RTSystemServicesProtocol.h"

#include "common/debugging/DebuggingService.h"
#include "common/debugging/MSCFunctionObject.h"
#include "common/messaging/AbstractMessageReceiver.h"
#include "common/messaging/Address.h"
#include "common/messaging/Message.h"
#include "common/modelbase/IEventReceiver.h"
#include <iterator>
#include <vector>

using namespace etRuntime;



/* message names as strings for debugging (generate MSC) */
const std::string RTSystemServicesProtocol::s_messageStrings[] = {"MIN",  "executeInitialTransition","startDebugging","stopDebugging","MAX"};

const std::string& RTSystemServicesProtocol::getMessageString(int msg_id) {
	if ((MSG_MIN < msg_id ) && ( msg_id < MSG_MAX )) {
		return s_messageStrings[msg_id];
	} else {
		// id out of range
		static const std::string errorMsg = "Message ID out of range";
		return errorMsg;
	}
}

//------------------------------------------------------------------------------------------------------------
// port class
//------------------------------------------------------------------------------------------------------------

RTSystemServicesProtocolPort::RTSystemServicesProtocolPort(IInterfaceItemOwner* actor, const std::string& name, int localId)
	: PortBase(actor, name, localId, 0)
{
}

RTSystemServicesProtocolPort::RTSystemServicesProtocolPort(IInterfaceItemOwner* actor, const std::string& name, int localId, int idx)
	: PortBase(actor, name, localId, idx)
{
}

void RTSystemServicesProtocolPort::destroy() {
	DebuggingService::getInstance().removePortInstance(*this);
	PortBase::destroy();
}

void RTSystemServicesProtocolPort::receive(const Message* msg) {
	// TODO JH further
	if (! RTSystemServicesProtocol::isValidIncomingEvtID(msg->getEvtId())) {
		std::cout << "unknown" << std::endl;
	}

	DebuggingService::getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), RTSystemServicesProtocol::getMessageString(msg->getEvtId()));

	getActor()->receiveEvent(this, msg->getEvtId(),	msg->getData());
}


// sent messages

//------------------------------------------------------------------------------------------------------------
// replicated port class
//------------------------------------------------------------------------------------------------------------
RTSystemServicesProtocolReplPort::RTSystemServicesProtocolReplPort(IInterfaceItemOwner* actor, const std::string& name, int localId) :
		ReplicatedPortBase(actor, name, localId)
{
}

// outgoing messages
//------------------------------------------------------------------------------------------------------------
// conjugated port class
//------------------------------------------------------------------------------------------------------------

RTSystemServicesProtocolConjPort::RTSystemServicesProtocolConjPort(IInterfaceItemOwner* actor, const std::string& name, int localId)
	: PortBase(actor, name, localId, 0)
{
}

RTSystemServicesProtocolConjPort::RTSystemServicesProtocolConjPort(IInterfaceItemOwner* actor, const std::string& name, int localId, int idx)
	: PortBase(actor, name, localId, idx)
{
}

void RTSystemServicesProtocolConjPort::destroy() {
	DebuggingService::getInstance().removePortInstance(*this);
	PortBase::destroy();
}

void RTSystemServicesProtocolConjPort::receive(const Message* msg) {
	// TODO JH further
	if (! RTSystemServicesProtocol::isValidOutgoingEvtID(msg->getEvtId())) {
		std::cout << "unknown" << std::endl;
	}

	DebuggingService::getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), RTSystemServicesProtocol::getMessageString(msg->getEvtId()));

	getActor()->receiveEvent(this, msg->getEvtId(),	msg->getData());
}


// sent messages
void RTSystemServicesProtocolConjPort::executeInitialTransition() {
	DebuggingService::getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(),
		RTSystemServicesProtocol::getMessageString(RTSystemServicesProtocol::IN_executeInitialTransition));
	if (getPeerAddress().isValid()){
		getPeerMsgReceiver()->receive(new Message(getPeerAddress(), RTSystemServicesProtocol::IN_executeInitialTransition));
	}
}
void RTSystemServicesProtocolConjPort::startDebugging() {
	DebuggingService::getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(),
		RTSystemServicesProtocol::getMessageString(RTSystemServicesProtocol::IN_startDebugging));
	if (getPeerAddress().isValid()){
		getPeerMsgReceiver()->receive(new Message(getPeerAddress(), RTSystemServicesProtocol::IN_startDebugging));
	}
}
void RTSystemServicesProtocolConjPort::stopDebugging() {
	DebuggingService::getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(),
		RTSystemServicesProtocol::getMessageString(RTSystemServicesProtocol::IN_stopDebugging));
	if (getPeerAddress().isValid()){
		getPeerMsgReceiver()->receive(new Message(getPeerAddress(), RTSystemServicesProtocol::IN_stopDebugging));
	}
}

//------------------------------------------------------------------------------------------------------------
// conjugated replicated port class
//------------------------------------------------------------------------------------------------------------
RTSystemServicesProtocolConjReplPort::RTSystemServicesProtocolConjReplPort(IInterfaceItemOwner* actor, const std::string& name, int localId) :
		ReplicatedPortBase(actor, name, localId)
{
}

// incoming messages
void RTSystemServicesProtocolConjReplPort::executeInitialTransition(){
	for (std::vector<etRuntime::InterfaceItemBase*>::iterator it = getItems().begin(); it != getItems().end(); ++it) {
		(dynamic_cast<RTSystemServicesProtocolConjPort*>(*it))->executeInitialTransition();
	}
}
void RTSystemServicesProtocolConjReplPort::startDebugging(){
	for (std::vector<etRuntime::InterfaceItemBase*>::iterator it = getItems().begin(); it != getItems().end(); ++it) {
		(dynamic_cast<RTSystemServicesProtocolConjPort*>(*it))->startDebugging();
	}
}
void RTSystemServicesProtocolConjReplPort::stopDebugging(){
	for (std::vector<etRuntime::InterfaceItemBase*>::iterator it = getItems().begin(); it != getItems().end(); ++it) {
		(dynamic_cast<RTSystemServicesProtocolConjPort*>(*it))->stopDebugging();
	}
}

