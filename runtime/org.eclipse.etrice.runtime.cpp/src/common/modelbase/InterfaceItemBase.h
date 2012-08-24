/*
 * InterfaceItemBaase.h
 *
 *  Created on: 06.06.2012
 *      Author: karlitsc
 */

#ifndef INTERFACEITEMBASE_H_
#define INTERFACEITEMBASE_H_

#include "common/messaging/Address.h"
#include "common/messaging/IMessageReceiver.h"
#include "common/modelbase/IEventReceiver.h"
#include "common/messaging/AbstractMessageReceiver.h"
#include <string>

namespace etRuntime {
class IEventReceiver;


class InterfaceItemBase : public AbstractMessageReceiver{
public:
	InterfaceItemBase (const IEventReceiver& actor, std::string name, int localId, int idx, Address ownAddress, Address peerAddress);
	virtual ~InterfaceItemBase();

	int getIdx() const  { return m_idx; } ;
	IEventReceiver* getActor() {	return static_cast<IEventReceiver*>(getParent()); };
	int getLocalId() {return m_localId; };

	void setMsgReceiver(IMessageReceiver& msgReceiver) {	m_ownMsgReceiver = &msgReceiver; };

protected:
	IMessageReceiver* getMsgReceiver() const{ return m_ownMsgReceiver; };
	IMessageReceiver* getPeerMsgReceiver() const { return m_peerMsgReceiver;	};
	Address getPeerAddress() const { return m_peerAddress; };

private:
	InterfaceItemBase();

	int m_idx;
	int m_localId;

	Address m_peerAddress;
	IMessageReceiver* m_ownMsgReceiver;
	IMessageReceiver* m_peerMsgReceiver;
};

} /* namespace etRuntime */
#endif /* INTERFACEITEMBASE_H_ */
