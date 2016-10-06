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

#include "common/debugging/MSCFilter.h"
#include "etStdDatatypes.h"
#include <list>
#include <string>

namespace etRuntime {

MSCFilter::MSCFilter() :
		filterList() {
}

void MSCFilter::addFilter(FilterItem filter) {
	filterList.push_back(filter);
}

etBool MSCFilter::applyTo(const std::string& text) {
	if (filterList.empty())
		return true; // no filters -> all messages will be logged
	std::list<FilterItem>::iterator it = filterList.begin();
	for (; it != filterList.end(); ++it) {
		if (text.compare((*it).filter) == 0)
			return !(*it).exclude;
	}
	return false;
}

std::string MSCFilter::reduceString(const std::string& string) {
//	if (filterList.size() == 1)
//		//TODO: filtering with regular expression
//		// return string.replaceFirst(filterList.front().filter, "");
//		return string;
//	else
		return string;
}

} /* namespace etRuntime */

