/*
 * ActorClassBase.cpp
 *
 *  Created on: 29.08.2012
 *      Author: karlitsc
 */

#include "ActorClassBase.h"

namespace etRuntime {

ActorClassBase::ActorClassBase(IRTObject* parent, std::string name, Address ownAddr, Address systemPortPeerAddr)
	: 	EventReceiver(parent, name),
		IMessageReceiver(),
		m_state(),
		m_RTSystemPort(0),
		m_className("noname"),
		m_ownAddr(ownAddr),
		m_ownMsgsvc(RTServices::getInstance().getMsgSvcCtrl().getMsgSvc(ownAddr.m_threadID)) {

	// own ports
	m_RTSystemPort = new RTSystemServicesProtocol::RTSystemServicesProtocolPort(*this, this, "RTSystemPort", 0, 0, ownAddr,
		systemPortPeerAddr);
}

ActorClassBase::~ActorClassBase() {
	delete m_RTSystemPort;
	m_RTSystemPort = 0;
}

bool ActorClassBase::handleSystemEvent(InterfaceItemBase ifitem, int evt, void* generic_data) {
	if (ifitem.getLocalId() != 0) {
		return false;
	}

	switch (evt) {
	case RTSystemServicesProtocol::Events::IN_executeInitialTransition:
		executeInitTransition();
		break;
	case RTSystemServicesProtocol::Events::IN_startDebugging:
		break;
	case RTSystemServicesProtocol::Events::IN_stopDebugging:
		break;
	}
	return true;
}

std::string ActorClassBase::toString() {
	return "ActorClass(className=" + m_className + ", instancePath=" + getInstancePath() + ")";
}

} /* namespace etRuntime */
