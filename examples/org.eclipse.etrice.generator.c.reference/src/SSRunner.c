/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#include <stdio.h>
#include "../src-gen/cGenRef/DataClass1.h"
#include "RUnit.h"
#include "RMessage.h"
#include "test/TestMessage.h"
#include "test/TestRMessageQueue.h"
#include "test/TestRMessageService.h"



void runTestCases(void);

int main(void){
	runTestCases();
	return 0;
}

void testDataClassDeepCopy(void){
	RUnit_openTestSuite("testGeneratedDataClass");
	RUnit_openTestCase("testDataClassDeepCopy");


	DataClass1 d, e;
	d.Attr1 = 123;
	d.ComplexAttr.Attr1 = 456;
	d.ComplexAttr.Attr2 = 789.123;
	d.ComplexAttr.Attr3 = 789;
	d.Attr3 = 321.123;

	DataClass1_deepCopy(&d,&e);

	EXPECT_EQUAL_INT32("Attr1", 123, e.Attr1);
	EXPECT_EQUAL_INT32("ComplexAttr.Attr1", 456, e.ComplexAttr.Attr1);
	EXPECT_EQUAL_FLOAT32("ComplexAttr.Attr2", 789.123, e.ComplexAttr.Attr2, 0.001);
	EXPECT_EQUAL_INT32("ComplexAttr.Attr3", 789, e.ComplexAttr.Attr3);
	EXPECT_EQUAL_FLOAT32("Attr3", 321.123, e.Attr3, 0.0001);

	EXPECT_EQUAL_INT32("Operation DataClass1_MultiplyWithAttr1", 246, DataClass1_MultiplyWithAttr1(&d, 2));
	EXPECT_EQUAL_FLOAT32("Operation DataClass1_MultiplyWithAttr3", 642.246, DataClass1_MultiplyWithAttr3(&d, 2), 0.0001);

	RUnit_closeTestCase();
	RUnit_closeTestSuite();
}

void runTestCases(void){
	RUnit_open("tmp/testlog","TestMessageService");

	testDataClassDeepCopy();
	TestMessage_runSuite();
	TestMessageQueue_runSuite();
	TestRMessageService_runSuite();

	RUnit_close();
}

