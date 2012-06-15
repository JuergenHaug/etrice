package org.eclipse.etrice.integration.ConfigTest;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;


import org.eclipse.etrice.integration.ConfigTest.ProtocolForConfig.*;

/*--------------------- begin user code ---------------------*/
	import org.eclipse.etrice.runtime.java.messaging.RTServices;
/*--------------------- end user code ---------------------*/


public class Testee extends ActorClassBase {

	
	//--------------------- ports
	protected ProtocolForConfigPort port1 = null;
	
	//--------------------- saps
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_port1 = 1;
		
	/*--------------------- attributes ---------------------*/
	boolean bool1;
	boolean bool2;
	boolean bool3;
	int int1;
	int int2;
	int int3;
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public Testee(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("Testee");
		
		// initialize attributes
		bool1 = true;
		bool2 = false;
		bool3 = false;
		int1 = 100;
		int2 = 210;
		int3 = 310;

		// own ports
		port1 = new ProtocolForConfigPort(this, "port1", IFITEM_port1, 0, port_addr[IFITEM_port1][0], peer_addr[IFITEM_port1][0]); 
		
		// own saps
		
		// own service implementations
	}
	//--------------------- attributes getter and setter
	//--------------------- attribute setters and getters
	public void setBool1 (boolean bool1) {
		 this.bool1 = bool1;
	}
	public boolean getBool1 () {
		return this.bool1;
	}
	public void setBool2 (boolean bool2) {
		 this.bool2 = bool2;
	}
	public boolean getBool2 () {
		return this.bool2;
	}
	public void setBool3 (boolean bool3) {
		 this.bool3 = bool3;
	}
	public boolean getBool3 () {
		return this.bool3;
	}
	public void setInt1 (int int1) {
		 this.int1 = int1;
	}
	public int getInt1 () {
		return this.int1;
	}
	public void setInt2 (int int2) {
		 this.int2 = int2;
	}
	public int getInt2 () {
		return this.int2;
	}
	public void setInt3 (int int3) {
		 this.int3 = int3;
	}
	public int getInt3 () {
		return this.int3;
	}

	//--------------------- lifecycle functions
	public void init(){
		initUser();
	}

	public void start(){
		startUser();
	}

	public void stop(){
		stopUser();
	}
	
	public void destroy(){
	}

	
	/* state IDs */
	public static final int STATE_Done = 2;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__Done = 1;
	
	/* triggers */
	public static final int POLLING = 0;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","Done"
	};
	
	// history
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE};
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			System.out.println(getInstancePath() + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	/* Entry and Exit Codes */
	protected void entry_Done() {
		if (bool1 != true || bool2 != false || bool3 != true ){
			RTServices.getInstance().getSubSystem().testFinished(1);
		}
		else if (int1 != 100 || int2 != 210 || int3 != 301){
			RTServices.getInstance().getSubSystem().testFinished(2);
		}
		else {
			RTServices.getInstance().getSubSystem().testFinished(0);
		}
	}
	
	/* Action Codes */
	
	/**
	 * calls exit codes while exiting from the current state to one of its
	 * parent states while remembering the history
	 * @param current - the current state
	 * @param to - the final parent state
	 * @param handler - entry and exit codes are called only if not handler (for handler TransitionPoints)
	 */
	private void exitTo(int current, int to, boolean handler) {
		while (current!=to) {
			switch (current) {
				case STATE_Done:
					this.history[STATE_TOP] = STATE_Done;
					current = STATE_TOP;
					break;
			}
		}
	}
	
	/**
	 * calls action, entry and exit codes along a transition chain. The generic data are cast to typed data
	 * matching the trigger of this chain. The ID of the final state is returned
	 * @param chain - the chain ID
	 * @param generic_data - the generic data pointer
	 * @return the ID of the final state
	 */
	private int executeTransitionChain(int chain, InterfaceItemBase ifitem, Object generic_data) {
		switch (chain) {
			case CHAIN_TRANS_INITIAL_TO__Done:
			{
				return STATE_Done;
			}
		}
		return NO_STATE;
	}
	
	/**
	 * calls entry codes while entering a state's history. The ID of the final leaf state is returned
	 * @param state - the state which is entered
	 * @param handler - entry code is executed if not handler
	 * @return - the ID of the final leaf state
	 */
	private int enterHistory(int state, boolean handler, boolean skip_entry) {
		while (true) {
			switch (state) {
				case STATE_Done:
					if (!(skip_entry || handler)) entry_Done();
					// in leaf state: return state id
					return STATE_Done;
				case STATE_TOP:
					state = this.history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__Done;
		int next = executeTransitionChain(chain, null, null);
		next = enterHistory(next, false, false);
		setState(next);
	}
	
	/* receiveEvent contains the main implementation of the FSM */
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data) {
		int trigger = ifitem.getLocalId() + EVT_SHIFT*evt;
		int chain = NOT_CAUGHT;
		int catching_state = NO_STATE;
		boolean is_handler = false;
		boolean skip_entry = false;
		
		if (!handleSystemEvent(ifitem, evt, generic_data)) {
			switch (this.state) {
				case STATE_Done:
					break;
			}
		}
		if (chain != NOT_CAUGHT) {
			exitTo(this.state, catching_state, is_handler);
			int next = executeTransitionChain(chain, ifitem, generic_data);
			next = enterHistory(next, is_handler, skip_entry);
			setState(next);
		}
	}
		 
	//******************************************
	// END of generated code for FSM
	//******************************************
};
