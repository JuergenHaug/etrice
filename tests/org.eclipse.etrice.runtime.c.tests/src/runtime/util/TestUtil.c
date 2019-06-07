/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#include "TestUtil.h"

#include "etUnit/etUnit.h"

#include "RandomGenerator.h"

#ifdef ET_FLOAT64

static void TestRandomGenerator (etInt16 id) {
	RandomGenerator rand;
	int i;
	double result, sum, average;

	sum = average = 0;
	RandomGenerator_init(&rand, 0.321, -1, 1);
	for (i=0; i<1000; i++){
		result = RandomGenerator_getNext(&rand);
		EXPECT_RANGE_FLOAT64(id, "random [-1,+1]", -1., +1., result); /* check for range */
		sum += result;
	}
	average = sum / (etFloat64)i;
	EXPECT_RANGE_FLOAT64(id, "average [-1,+1]", -0.1, 0.1, average); /* check for quality */

	sum = average = 0;
	RandomGenerator_init(&rand, 0.321, -500., 1000.);
	for (i=0; i<1000; i++){
		result = RandomGenerator_getNext(&rand);
		EXPECT_RANGE_FLOAT64(id, "random [-500,+1000]", -500., +1000., result); /* check for range */
		sum += result;
	}
	average = sum / (etFloat64)i;
	EXPECT_RANGE_FLOAT64(id, "average [-500,+1000]", 230., 270., average); /* check for quality */


}

#endif

void TestUtil_runSuite(void){
	etUnit_openTestSuite("org.eclipse.etrice.runtime.c.tests.TestUtil");

#ifdef ET_FLOAT64
	ADD_TESTCASE(TestRandomGenerator);
#endif

	etUnit_closeTestSuite();
}


