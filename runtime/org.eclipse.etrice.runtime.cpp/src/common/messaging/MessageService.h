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

#ifndef MESSAGESERVICE_H_
#define MESSAGESERVICE_H_

#include "common/messaging/AbstractMessageService.h"

#include "common/messaging/IMessageService.h"
#include "common/messaging/Message.h"
#include "etDatatypes.h"
#include "osal/etMutex.h"
#include "osal/etSema.h"
#include "osal/etThread.h"
#include "osal/etTimer.h"
#include <string>

namespace etRuntime {

class MessageService: public AbstractMessageService {

public:

	enum ExecMode {
		POLLED, BLOCKED, MIXED
	};

	MessageService(IRTObject* parent, IMessageService::ExecMode mode, int node, int thread, const std::string& name, int priority = 0);
	MessageService(IRTObject* parent, IMessageService::ExecMode mode, etTime interval, int node, int thread, const std::string& name, int priority = 0);
	virtual ~MessageService();

	void run();

	virtual void start();
	virtual void terminate();

	virtual Address getFreeAddress();

	virtual void freeAddress(const Address& addr);

	virtual void addMessageReceiver(IMessageReceiver& receiver);
	virtual void removeMessageReceiver(IMessageReceiver& receiver);

	virtual void addPollingMessageReceiver(IMessageReceiver& receiver);
	virtual void removePollingMessageReceiver(IMessageReceiver& receiver);
	virtual void receive(const Message* msg);

protected:

	long getLastMessageTimestamp() const {
		return m_lastMessageTimestamp;
	}

	void pollingTask();

private:
	// static functions for c calls
	static void run(void* self) {
		static_cast<MessageService*>(self)->run();
	}

	static void pollingTask(void* self) {
		static_cast<MessageService*>(self)->pollingTask();
	}

	etBool m_running;
	IMessageService::ExecMode m_execMode;
	long m_lastMessageTimestamp;
	Message m_pollingMessage;

	etMutex m_mutex;
	etSema m_executionSemaphore;
	etThread m_thread;
	etTimer m_timer;

	void MessageService_init(etTime interval, int priority); // common ctor

	MessageService();
	MessageService(MessageService const&);
	MessageService& operator=(MessageService const&);
};

} /* namespace etRuntime */
#endif /* MESSAGESERVICE_H_ */
