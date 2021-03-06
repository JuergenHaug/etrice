/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 *
 *******************************************************************************/

#ifndef SRC_MESSAGING_MESSAGESEQUEUETEST_H_
#define SRC_MESSAGING_MESSAGESEQUEUETEST_H_

#include "util/etTestSuite.h"

class MessageSeQueueTest: public etTestSuite {
public:
	MessageSeQueueTest(void) :
			etTestSuite("org.eclipse.etrice.runtime.cpp.tests.MessageSeQueueTest") {
	}

protected:
	void testConstructors(void);
	void testGetters(void);
	void testPushPop(void);

	virtual void runAllTestCases(void);
};

#endif /* SRC_MESSAGING_MESSAGESEQUEUETEST_H_ */
