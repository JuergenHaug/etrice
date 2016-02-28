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

#ifndef MESSAGESEQUEUE_H_
#define MESSAGESEQUEUE_H_

#include "common/messaging/RTObject.h"
#include "common/messaging/Message.h"
#include "etDatatypes.h"
#include <string>

namespace etRuntime {

class MessageSeQueue: public RTObject {
public:
	MessageSeQueue(IRTObject* parent, const std::string& name);
	virtual ~MessageSeQueue();

	void push(Message* msg);
	const Message* pop();

	long getSize() const {
		return m_size;
	}
	Message* getFirst() const {
		return m_first;
	}
	Message* getLast() const {
		return m_last;
	}
	etBool isNotEmpty() const {
		return m_last != 0;
	}
	long getHightWaterMark() const {
		return m_highWaterMark;
	}

private:
	Message* m_first;
	Message* m_last;
	long m_highWaterMark;
	long m_size;

	MessageSeQueue();
	MessageSeQueue(MessageSeQueue const&);
	void operator=(MessageSeQueue const&);

};

} /* namespace etRuntime */
#endif /* MESSAGESEQUEUE_H_ */
