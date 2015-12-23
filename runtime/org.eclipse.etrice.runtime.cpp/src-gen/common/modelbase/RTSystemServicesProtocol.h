/**
 * @author generated by eTrice
 *
 * Header File of ProtocolClass RTSystemServicesProtocol
 *
 */

#ifndef _RTSYSTEMSERVICESPROTOCOL_H_
#define _RTSYSTEMSERVICESPROTOCOL_H_

#include <common/modelbase/InterfaceItemBase.h>
#include <common/modelbase/PortBase.h>
#include <common/modelbase/ReplicatedInterfaceItemBase.h>
#include <common/modelbase/ReplicatedPortBase.h>
#include <etDatatypes.h>
#include <string>



class RTSystemServicesProtocol {
   public:
		/* message IDs */
		typedef enum {
			MSG_MIN = 0,
			IN_executeInitialTransition = 1,
			IN_startDebugging = 2,
			IN_stopDebugging = 3,
			MSG_MAX = 4
		} msg_ids;


		static bool isValidEvtID(int evtId) {
			return ((MSG_MIN < evtId) && (evtId < MSG_MAX));
		}
		static bool isValidOutgoingEvtID(int evtId) {
			return ((MSG_MIN < evtId) && (evtId < IN_executeInitialTransition));
		}
		static bool isValidIncomingEvtID(int evtId) {
			return ((IN_executeInitialTransition <= evtId) && (evtId < MSG_MAX));
		}
		static const std::string& getMessageString(int msg_id);

	private:
		static const std::string s_messageStrings[];


};

//------------------------------------------------------------------------------------------------------------
// port class
//------------------------------------------------------------------------------------------------------------
class RTSystemServicesProtocolPort : public etRuntime::PortBase {
   public:
	 RTSystemServicesProtocolPort(etRuntime::IInterfaceItemOwner* actor, const std::string& name, int localId);
	 RTSystemServicesProtocolPort(etRuntime::IInterfaceItemOwner* actor, const std::string& name, int localId, int idx);

	virtual void destroy();

	 virtual void receive(const etRuntime::Message* m);


	 // sent messages
};

//------------------------------------------------------------------------------------------------------------
// replicated port class
//------------------------------------------------------------------------------------------------------------
class RTSystemServicesProtocolReplPort : public etRuntime::ReplicatedPortBase {

	public:
		RTSystemServicesProtocolReplPort(etRuntime::IInterfaceItemOwner* actor, const std::string& name, int localId);

		int getReplication() const { return getNInterfaceItems(); }
		int getIndexOf(const etRuntime::InterfaceItemBase& ifitem) const { return ifitem.getIdx(); }
		RTSystemServicesProtocolPort& get(int idx) const { return *dynamic_cast<RTSystemServicesProtocolPort*>(getInterfaceItem(idx)); }

		// outgoing messages

	protected:
		virtual etRuntime::InterfaceItemBase* createInterfaceItem(etRuntime::IInterfaceItemOwner* rcv, const std::string& name, int lid, int idx) {
			return new RTSystemServicesProtocolPort(rcv, name, lid, idx);
		}

};
//------------------------------------------------------------------------------------------------------------
// conjugated port class
//------------------------------------------------------------------------------------------------------------
class RTSystemServicesProtocolConjPort : public etRuntime::PortBase {
   public:
	 RTSystemServicesProtocolConjPort(etRuntime::IInterfaceItemOwner* actor, const std::string& name, int localId);
	 RTSystemServicesProtocolConjPort(etRuntime::IInterfaceItemOwner* actor, const std::string& name, int localId, int idx);

	virtual void destroy();

	 virtual void receive(const etRuntime::Message* m);


	 // sent messages
	public: void executeInitialTransition();
	public: void startDebugging();
	public: void stopDebugging();
};

//------------------------------------------------------------------------------------------------------------
// conjugated replicated port class
//------------------------------------------------------------------------------------------------------------
class RTSystemServicesProtocolConjReplPort : public etRuntime::ReplicatedPortBase {

	public:
		RTSystemServicesProtocolConjReplPort(etRuntime::IInterfaceItemOwner* actor, const std::string& name, int localId);

		int getReplication() const { return getNInterfaceItems(); }
		int getIndexOf(const etRuntime::InterfaceItemBase& ifitem) const { return ifitem.getIdx(); }
		RTSystemServicesProtocolConjPort& get(int idx) const { return *dynamic_cast<RTSystemServicesProtocolConjPort*>(getInterfaceItem(idx)); }

		// incoming messages
		public: void executeInitialTransition();
		public: void startDebugging();
		public: void stopDebugging();

	protected:
		virtual etRuntime::InterfaceItemBase* createInterfaceItem(etRuntime::IInterfaceItemOwner* rcv, const std::string& name, int lid, int idx) {
			return new RTSystemServicesProtocolConjPort(rcv, name, lid, idx);
		}

};
#endif /* _RTSYSTEMSERVICESPROTOCOL_H_ */
