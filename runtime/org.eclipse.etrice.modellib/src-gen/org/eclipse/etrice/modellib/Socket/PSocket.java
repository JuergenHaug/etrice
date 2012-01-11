package org.eclipse.etrice.modellib.Socket;

import java.util.ArrayList;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.*;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;



public class PSocket {
	// message IDs
	// TODO: separate class for message IDs: class MSG{public static volatile int MSG_MIN = 0; ...} -> better structure
	// error if msgID <= MSG_MIN
	public static final int MSG_MIN = 0;   
	//IDs for outgoing messages
	public static final int OUT_connected = 1;
	public static final int OUT_disconnected = 2;
	public static final int OUT_receivedData = 3;
	public static final int OUT_sentData = 4;
	public static final int OUT_error = 5;
	//IDs for incoming messages
	public static final int IN_connect = 6;
	public static final int IN_disconnect = 7;
	public static final int IN_sendData = 8;
	//error if msgID >= MSG_MAX
	public static final int MSG_MAX = 9;  


	private static String messageStrings[] = {"MIN", "connected","disconnected","receivedData","sentData","error", "connect","disconnect","sendData","MAX"};

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
	static public class PSocketPort extends PortBase {
		// constructors
		public PSocketPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			super(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PSocketPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
		public void connected ()
		{
			if (messageStrings[ OUT_connected] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_connected]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_connected));
				}
		public void disconnected ()
		{
			if (messageStrings[ OUT_disconnected] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_disconnected]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_disconnected));
				}
		public void receivedData ()
		{
			if (messageStrings[ OUT_receivedData] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_receivedData]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_receivedData));
				}
		public void sentData ()
		{
			if (messageStrings[ OUT_sentData] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_sentData]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_sentData));
				}
		public void error ()
		{
			if (messageStrings[ OUT_error] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_error]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), OUT_error));
				}
	}
	
	// replicated port class
	static public class PSocketPortRepl {
		private ArrayList<PSocketPort> ports;
		private int replication;
	
		public PSocketPortRepl(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr.length;
			ports = new ArrayList<PSocket.PSocketPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PSocketPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PSocketPort get(int i) {
			return ports.get(i);
		}
		
		// outgoing messages
		public void connected ()
		{
			for (int i=0; i<replication; ++i) {
				ports.get(i).connected()
				;
			}
		}
		public void disconnected ()
		{
			for (int i=0; i<replication; ++i) {
				ports.get(i).disconnected()
				;
			}
		}
		public void receivedData ()
		{
			for (int i=0; i<replication; ++i) {
				ports.get(i).receivedData()
				;
			}
		}
		public void sentData ()
		{
			for (int i=0; i<replication; ++i) {
				ports.get(i).sentData()
				;
			}
		}
		public void error ()
		{
			for (int i=0; i<replication; ++i) {
				ports.get(i).error()
				;
			}
		}
	}
	
	
	// port class
	static public class PSocketConjPort extends PortBase {
		// constructors
		public PSocketConjPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			super(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PSocketConjPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
		public void connect (DSocketConfiguration config)
		{
			if (messageStrings[ IN_connect] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_connect]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_connect, config.deepCopy()));
		}
		public void disconnect ()
		{
			if (messageStrings[ IN_disconnect] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_disconnect]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_disconnect));
				}
		public void sendData (DSocketData data)
		{
			if (messageStrings[ IN_sendData] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_sendData]);
			}
			if (getPeerAddress()!=null)
				getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), IN_sendData, data.deepCopy()));
		}
	}
	
	// replicated port class
	static public class PSocketConjPortRepl {
		private ArrayList<PSocketConjPort> ports;
		private int replication;
	
		public PSocketConjPortRepl(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr.length;
			ports = new ArrayList<PSocket.PSocketConjPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PSocketConjPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PSocketConjPort get(int i) {
			return ports.get(i);
		}
		
		// incoming messages
		public void connect (DSocketConfiguration config)
		{
			for (int i=0; i<replication; ++i) {
				ports.get(i).connect( config)
				;
			}
		}
		public void disconnect ()
		{
			for (int i=0; i<replication; ++i) {
				ports.get(i).disconnect()
				;
			}
		}
		public void sendData (DSocketData data)
		{
			for (int i=0; i<replication; ++i) {
				ports.get(i).sendData( data)
				;
			}
		}
	}
	
}
