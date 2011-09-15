package PedLightsController;

import java.util.ArrayList;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.modelbase.*;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;



public class PedControlProtocol {
	// message IDs
	// TODO: separate class for message IDs: class MSG{public static volatile int MSG_MIN = 0; ...} -> better structure
	// error if msgID <= MSG_MIN
	public static final int MSG_MIN = 0;   
	//IDs for outgoing messages
	public static final int OUT_setCarLights = 1;
	public static final int OUT_setPedLights = 2;
	//IDs for incoming messages
	public static final int IN_start = 3;
	//error if msgID >= MSG_MAX
	public static final int MSG_MAX = 4;  


	private static String messageStrings[] = {"MIN", "setCarLights","setPedLights", "start","MAX"};

	public String getMessageString(int msg_id) {
		if (msg_id<0 || msg_id>MSG_MAX+1){
			// id out of range
			return "Message ID out of range";
		}
		else{
			return messageStrings[msg_id];
		}
	}

	
	// port class
	static public class PedControlProtocolPort extends PortBase {
		// constructors
		public PedControlProtocolPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			super(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PedControlProtocolPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
		public void setCarLights (int state)
		{
			if (messageStrings[ OUT_setCarLights] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_setCarLights]);
			}
			if (getPeerAddress()!=null)
			getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), OUT_setCarLights, state));
		}
		public void setPedLights (int state)
		{
			if (messageStrings[ OUT_setPedLights] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[OUT_setPedLights]);
			}
			if (getPeerAddress()!=null)
			getPeerMsgReceiver().receive(new EventWithDataMessage(getPeerAddress(), OUT_setPedLights, state));
		}
	}
	
	// replicated port class
	static public class PedControlProtocolPortRepl {
		private ArrayList<PedControlProtocolPort> ports;
		private int replication;
	
		public PedControlProtocolPortRepl(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr.length;
			ports = new ArrayList<PedControlProtocol.PedControlProtocolPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PedControlProtocolPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PedControlProtocolPort get(int i) {
			return ports.get(i);
		}
		
		// outgoing messages
		public void setCarLights (int state)
		{
			for (int i=0; i<replication; ++i) {
				ports.get(i).setCarLights( state)
				;
			}
		}
		public void setPedLights (int state)
		{
			for (int i=0; i<replication; ++i) {
				ports.get(i).setPedLights( state)
				;
			}
		}
	}
	
	// interface for port class
	public interface IPedControlProtocolPort{
		// incoming messages
		 public void start ()
		;
	}
	
	// port class
	static public class PedControlProtocolConjPort extends PortBase {
		// constructors
		public PedControlProtocolConjPort(IEventReceiver actor, String name, int localId, Address addr, Address peerAddress) {
			super(actor, name, localId, 0, addr, peerAddress);
			DebuggingService.getInstance().addPortInstance(this);
		}
		public PedControlProtocolConjPort(IEventReceiver actor, String name, int localId, int idx, Address addr, Address peerAddress) {
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
		public void start ()
		{
			if (messageStrings[ IN_start] != "timerTick"){
				// TODOTS: model switch for activation
			DebuggingService.getInstance().addMessageAsyncOut(getAddress(), getPeerAddress(), messageStrings[IN_start]);
			}
			if (getPeerAddress()!=null)
			getPeerMsgReceiver().receive(new EventMessage(getPeerAddress(), IN_start));
			}
	}
	
	// replicated port class
	static public class PedControlProtocolConjPortRepl {
		private ArrayList<PedControlProtocolConjPort> ports;
		private int replication;
	
		public PedControlProtocolConjPortRepl(IEventReceiver actor, String name, int localId, Address[] addr,
				Address[] peerAddress) {
			replication = addr.length;
			ports = new ArrayList<PedControlProtocol.PedControlProtocolConjPort>(replication);
			for (int i=0; i<replication; ++i) {
				ports.add(new PedControlProtocolConjPort(
						actor, name+i, localId, i, addr[i], peerAddress[i]));
			}
		}
		
		public int getReplication() {
			return replication;
		}
		
		public int getIndexOf(InterfaceItemBase ifitem){
				return ifitem.getIdx();
			}
		
		public PedControlProtocolConjPort get(int i) {
			return ports.get(i);
		}
		
		// incoming messages
		public void start ()
		{
			for (int i=0; i<replication; ++i) {
				ports.get(i).start()
				;
			}
		}
	}
	
	// interface for port class
	public interface IPedControlProtocolConjPort{
		// outgoing messages
		 public void setCarLights (int state)
		;
	 public void setPedLights (int state)
		;
	}
}
