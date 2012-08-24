/*
 * IRTObject.h
 *
 *  Created on: 16.08.2012
 *      Author: karlitsc
 */

#ifndef IRTOBJECT_H_
#define IRTOBJECT_H_

#include <string>

namespace etRuntime {

class IRTObject {

public:
	static const char PATH_DELIM = '/';
	static const char PATHNAME_DELIM = '_';
	static const std::string NO_NAME;

	std::string getInstancePath();
	std::string getInstancePathName();
};

}

#endif /* IRTOBJECT_H_ */
