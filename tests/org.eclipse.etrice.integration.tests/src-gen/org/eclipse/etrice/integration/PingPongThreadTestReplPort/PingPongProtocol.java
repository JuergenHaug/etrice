package org.eclipse.etrice.integration.PingPongThreadTestReplPort;

import java.util.ArrayList;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.*;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;



public class PingPongProtocol {
	// message IDs
	// TODO: separate class for message IDs: class MSG{public static volatile int MSG_MIN = 0; ...} -> better structure
	// error if msgID <= MSG_MIN
	public static final int MSG_MIN = 0;   
	//IDs for outgoing messages
	public static final int OUT_pong = 1;
	//IDs for incoming messages
	public static final int IN_ping = 2;
	//error if msgID >= MSG_MAX
	public static final int MSG_MAX = 3;  


	private static String messageStrings[] = {"MIN", "pong", "ping","MAX"};

	public String getMessageString(int msg_id) {
		if (msg_id<MSG_MIN || msg_id>MSG_MAX+1){
			// id out of range
			return "Message ID out of range";
		}
		else{
			return messageStrings[msg_id];
		}
	}

	
	// port class
	static public class PingPongProtocolPort extends PortBase {
		// constructors
		public PingPongProtocolPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			super(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PingPongProtocolPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
			super(actor, name, localId, idx, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
	
		@Override
		public void receive(Message m) {
				if (!(m instanceof EventMessage))
					return;
				EventMessage msg = (EventMessage) m;
				if (msg.getEvtId() <= 0 || msg.getEvtId() >= MSG_MAX)
					System.out.println("unknown");
				else {
					if (messageStrings[msg.getEvtId()] != "timerTick"){
						// TODOTS: model switch for activation
						DebuggingService.getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), messageStrings[msg.getEvtId()]);
					}
						if (msg instanceof EventWithDataMessage)
							getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());
						else
							getActor().receiveEvent(this, msg.getEvtId(), null);
				}
		}
	
		
		// sent messages
		public void pong ()
		{
			if (messageStrings[ OUT_pong] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_pong]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_pong));
				}
	}
	
	// replicated port class
	static public class PingPongProtocolPortRepl {
		private ArrayList<PingPongProtocolPort> ports;
		private int replication;
	
		public PingPongProtocolPortRepl(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr.length;
			ports = new ArrayList<PingPongProtocol.PingPongProtocolPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PingPongProtocolPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PingPongProtocolPort get(int i) {
			return ports.get(i);
		}
		
		// outgoing messages
		public void pong ()
		{
			for (int i=0; i<replication; ++i) {
				ports.get(i).pong()
				;
			}
		}
	}
	
	
	// port class
	static public class PingPongProtocolConjPort extends PortBase {
		// constructors
		public PingPongProtocolConjPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			super(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PingPongProtocolConjPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
			super(actor, name, localId, idx, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
	
		@Override
		public void receive(Message m) {
				if (!(m instanceof EventMessage))
					return;
				EventMessage msg = (EventMessage) m;
				if (msg.getEvtId() <= 0 || msg.getEvtId() >= MSG_MAX)
					System.out.println("unknown");
				else {
					if (messageStrings[msg.getEvtId()] != "timerTick"){
						// TODOTS: model switch for activation
						DebuggingService.getInstance().addMessageAsyncIn(getPeerAddress(), getAddress(), messageStrings[msg.getEvtId()]);
					}
						if (msg instanceof EventWithDataMessage)
							getActor().receiveEvent(this, msg.getEvtId(), ((EventWithDataMessage)msg).getData());
						else
							getActor().receiveEvent(this, msg.getEvtId(), null);
				}
		}
	
		
		// sent messages
		public void ping ()
		{
			if (messageStrings[ IN_ping] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_ping]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_ping));
				}
	}
	
	// replicated port class
	static public class PingPongProtocolConjPortRepl {
		private ArrayList<PingPongProtocolConjPort> ports;
		private int replication;
	
		public PingPongProtocolConjPortRepl(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr.length;
			ports = new ArrayList<PingPongProtocol.PingPongProtocolConjPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PingPongProtocolConjPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PingPongProtocolConjPort get(int i) {
			return ports.get(i);
		}
		
		// incoming messages
		public void ping ()
		{
			for (int i=0; i<replication; ++i) {
				ports.get(i).ping()
				;
			}
		}
	}
	
}
