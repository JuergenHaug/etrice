/*******************************************************************************
 * Copyright (c) 2012 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

#include "common/messaging/MessageDispatcher.h"
#include "common/messaging/MessageSeQueue.h"
#include "common/messaging/MessageService.h"
#include "common/messaging/MessageServiceController.h"
#include "common/messaging/RTServices.h"
#include "osal/etTime.h"
#include <string>

namespace etRuntime {


MessageService::MessageService(IRTObject* parent, IMessageService::ExecMode mode, int node, int thread, const std::string& name, int priority) :
		AbstractMessageService(parent, name, node, thread),
		m_running(false),
		m_execMode(mode),
		m_lastMessageTimestamp(0),
		m_pollingMessage(getMessageDispatcher().getAddress(), 0) {

	etTime interval;
	interval.sec = 0;
	interval.nSec = 0;
	MessageService_init(interval, priority);
}

MessageService::MessageService(IRTObject* parent, IMessageService::ExecMode mode, etTime interval, int node, int thread,
		const std::string& name, int priority) :
		AbstractMessageService(parent, name, node, thread),
		m_running(false),
		m_execMode(mode),
		m_lastMessageTimestamp(0),
		m_pollingMessage(getMessageDispatcher().getAddress(), 0) {

	MessageService_init(interval, priority);
}

void MessageService::MessageService_init(etTime interval, int priority) {

	/* init mutexes and semaphores */
	etMutex_construct(&m_mutex);
	etSema_construct(&m_executionSemaphore);

	/* init thread */
	etThread_construct(&m_thread, static_cast<etStacksize>(1024), static_cast<etPriority>(priority), (etThreadname)"MessageService",
			MessageService::run, static_cast<void *>(this));

	// check and set priority
//			assert priority >= Thread.MIN_PRIORITY : ("priority smaller than Thread.MIN_PRIORITY (1)");
//			assert priority <= Thread.MAX_PRIORITY : ("priority bigger than Thread.MAX_PRIORITY (10)");
//			this.setPriority(priority);

	if (m_execMode == IMessageService::POLLED || m_execMode == IMessageService::MIXED) {
		/* init timer */
		etTimer_construct(&m_timer, &interval, MessageService::pollingTask, static_cast<void *>(this));
	}
}

MessageService::~MessageService() {
	std::cout << "~MessageService" << std::endl;
	etMutex_destruct(&m_mutex);
	etSema_destruct(&m_executionSemaphore);
	etThread_destruct(&m_thread);
	if (m_execMode == IMessageService::POLLED || m_execMode == IMessageService::MIXED) {
		etTimer_destruct(&m_timer);
	}
}

void MessageService::start() {
	etThread_start(&m_thread);
	if (m_execMode == IMessageService::POLLED || m_execMode == IMessageService::MIXED) {
		etTimer_start(&m_timer);
	}
}

void MessageService::run() {
	m_running = true;
	while (m_running) {
		etMutex_enter(&m_mutex);
		const Message* msg = getMessageQueue().pop(); // get next Message from Queue
		etMutex_leave(&m_mutex);
		if (msg == 0) {
			// no message in queue -> wait till Thread is notified
			etSema_waitForWakeup(&m_executionSemaphore);
		} else {
			//TODO: set timestamp
			// m_lastMessageTimestamp = System.currentTimeMillis();
			getMessageDispatcher().receive(msg);
		}
	}

	RTServices::getInstance().getMsgSvcCtrl().setMsgSvcTerminated(*this);
}

void MessageService::receive(const Message* msg) {
	etMutex_enter(&m_mutex);
	AbstractMessageService::receive(msg);
	etSema_wakeup(&m_executionSemaphore);
	etMutex_leave(&m_mutex);
}

Address MessageService::getFreeAddress() {
	etMutex_enter(&m_mutex);
	Address address = AbstractMessageService::getFreeAddress();
	etMutex_leave(&m_mutex);

	return address;
}

void MessageService::freeAddress(const Address& addr) {
	etMutex_enter(&m_mutex);
	AbstractMessageService::freeAddress(addr);
	etMutex_leave(&m_mutex);
}

void MessageService::addMessageReceiver(IMessageReceiver& receiver) {
	etMutex_enter(&m_mutex);
	AbstractMessageService::addMessageReceiver(receiver);
	etMutex_leave(&m_mutex);
}

void MessageService::removeMessageReceiver(IMessageReceiver& receiver) {
	etMutex_enter(&m_mutex);
	AbstractMessageService::removeMessageReceiver(receiver);
	etMutex_leave(&m_mutex);
}

void MessageService::addPollingMessageReceiver(IMessageReceiver& receiver) {
	etMutex_enter(&m_mutex);
	AbstractMessageService::addPollingMessageReceiver(receiver);
	etMutex_leave(&m_mutex);
}

void MessageService::removePollingMessageReceiver(IMessageReceiver& receiver) {
	etMutex_enter(&m_mutex);
	AbstractMessageService::removePollingMessageReceiver(receiver);
	etMutex_leave(&m_mutex);
}

void MessageService::terminate() {
	if (m_execMode == IMessageService::POLLED || m_execMode == IMessageService::MIXED) {
		etTimer_stop(&m_timer);
	}
	if (m_running) {
		m_running = false;
		etSema_wakeup(&m_executionSemaphore);
	}

}

// called by osal timer, thread ?
void MessageService::pollingTask() {
	if (m_running) {
		receive(&m_pollingMessage);
	}
}

} /* namespace etRuntime */
