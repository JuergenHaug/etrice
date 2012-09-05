/*
 * IMessageReceiver.h
 *
 *  Created on: 08.06.2012
 *      Author: karlitsc
 */

#ifndef IMESSAGERECEIVER_H_
#define IMESSAGERECEIVER_H_

#include "common/messaging/Address.h"
#include "common/messaging/Message.h"
#include "common/messaging/IRTObject.h"

namespace etRuntime {

class IMessageReceiver{
public:
	IMessageReceiver();
	virtual ~IMessageReceiver();

	virtual void receive(Message* msg);
	virtual Address getAddress();
	virtual bool isMsgService() { return false;};

};

} /* namespace etRuntime */
#endif /* IMESSAGERECEIVER_H_ */
