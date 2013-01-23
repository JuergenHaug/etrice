/*
 * DebuggingService.cpp
 *
 *  Created on: 06.06.2012
 *      Author: karlitsc
 */

#include "DebuggingService.h"
#include "common/modelbase/ActorClassBase.h"
#include <iostream>

namespace etRuntime {

DebuggingService* DebuggingService::s_instance = 0;

DebuggingService::DebuggingService()
: asyncLogger() ,
  syncLogger(),
  portInstances()
{
}

DebuggingService::~DebuggingService() {
}


void DebuggingService::addMessageAsyncOut(Address source, Address target,
		std::string msg) {
	asyncLogger.addMessageAsyncOut(portInstances.at(source)->getActorPath(),
								   portInstances.at(target)->getActorPath(), msg);
}

void DebuggingService::addMessageAsyncIn(Address source, Address target,
		std::string msg) {
	asyncLogger.addMessageAsyncIn(portInstances.at(source)->getActorPath(),
								  portInstances.at(target)->getActorPath(), msg);
}

void DebuggingService::addMessageSyncCall(Address source, Address target,
		std::string msg) {
	asyncLogger.addMessageSyncCall(portInstances.at(source)->getActorPath(),
								   portInstances.at(target)->getActorPath(), msg);
}

void DebuggingService::addMessageSyncReturn(Address source, Address target,
		std::string msg) {
	asyncLogger.addMessageSyncReturn(portInstances.at(source)->getActorPath(),
		                             portInstances.at(target)->getActorPath(), msg);
}

void DebuggingService::addActorState(const ActorClassBase& actor,
		std::string state) {
	asyncLogger.addActorState(actor.getInstancePath(), state);
}

void DebuggingService::addPortInstance(PortBase& port) {
	portInstances[port.getAddress()] = &port;
	std::cout << "adding " << port.getAddress().toID() << " " << &port << " " << port.getParent()->getInstancePathName()<< std::endl;
}

MSCLogger& DebuggingService::getSyncLogger() {
	return syncLogger;
}

MSCLogger& DebuggingService::getAsyncLogger() {
	return asyncLogger;
}


} /* namespace etRuntime */
