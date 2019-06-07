/*******************************************************************************
 * Copyright (c) 2012 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

#ifndef MESSAGESERVICECONTROLLER_H_
#define MESSAGESERVICECONTROLLER_H_

#include "common/messaging/IMessageService.h"
#include "common/containers/Vector.h"
#include "osal/etMutex.h"
#include "osal/etSema.h"

namespace etRuntime {

class MessageServiceController {
public:
	MessageServiceController();
	virtual ~MessageServiceController() {}

	int getNewID();
	void freeID(int id);
	void addMsgSvc(IMessageService& msgSvc);
	void removeMsgSvc(IMessageService& msgSvc);
	IMessageService* getMsgSvc(int threadID);
	void start();
	void stop();
	void resetAll();

	/**
	 * waitTerminate waits blocking for all MessageServices to terminate
	 * ! not thread safe !
	 */
	void waitTerminate();

	void setMsgSvcTerminated(const IMessageService& msgSvc);

protected:
	void dumpThreads(String msg);

private:
	void terminate();

	typedef Vector<IMessageService*> MsgSvcList;

	MsgSvcList m_messageServices;
	Vector<int> m_freeIDs;
	etBool m_running;
	int m_nextFreeID;

	etMutex m_mutex;
	etSema m_terminateSema;
	MsgSvcList m_terminateServices;

	MessageServiceController(MessageServiceController const&);
	MessageServiceController& operator=(MessageServiceController const&);
};

} /* namespace etRuntime */
#endif /* MESSAGESERVICECONTROLLER_H_ */
