/*
 * Address.h
 *
 *  Created on: 06.06.2012
 *      Author: karlitsc
 */

#ifndef ADDRESS_H_
#define ADDRESS_H_

#include <string>

namespace etRuntime {

class Address {
public:
	explicit Address(int nodeID=0, int threadID=0, int objectID=0);
	Address(const Address & right);
	Address & operator = (const Address& right);
	bool operator< (const Address& right) const;
	~Address();

	std::string toString();
	std::string toID();

	Address createInc(int i);
	bool isValid() const {
		return (m_nodeID != 0) || (m_threadID != 0) || (m_objectID != 0);
	};

	int m_nodeID;
	int m_threadID;
	int m_objectID;

private:
};

} /* namespace etRuntime */
#endif /* ADDRESS_H_ */


