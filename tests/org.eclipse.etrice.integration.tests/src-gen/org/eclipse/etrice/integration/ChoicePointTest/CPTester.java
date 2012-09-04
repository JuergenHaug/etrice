package org.eclipse.etrice.integration.ChoicePointTest;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;


import org.eclipse.etrice.integration.ChoicePointTest.TestProtocol.*;



public class CPTester extends ActorClassBase {

	
	
	//--------------------- ports
	protected TestProtocolConjPort TestPort1 = null;
	
	//--------------------- saps
	
	//--------------------- services

	//--------------------- interface item IDs
	public static final int IFITEM_TestPort1 = 1;

		
	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public CPTester(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("CPTester");
		
		// initialize attributes

		// own ports
		TestPort1 = new TestProtocolConjPort(this, "TestPort1", IFITEM_TestPort1, 0, port_addr[IFITEM_TestPort1][0], peer_addr[IFITEM_TestPort1][0]); 
		
		// own saps
		
		// own service implementations
	}

	
	//--------------------- attribute setters and getters
	
	
	//--------------------- port getters
	public TestProtocolConjPort getTestPort1 (){
		return this.TestPort1;
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
	public static final int STATE_state0 = 2;
	
	/* transition chains */
	public static final int CHAIN_TRANS_INITIAL_TO__state0 = 1;
	
	/* triggers */
	public static final int POLLING = 0;
	
	// state names
	protected static final String stateStrings[] = {"<no state>","<top>","state0"
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
	
	/* Action Codes */
	protected void action_TRANS_INITIAL_TO__state0() {
		TestPort1.msg1();
		System.out.println("msg1 sent ");
		
		TestPort1.msg1();
		System.out.println("msg1 sent ");
		
		TestPort1.msg1();
		System.out.println("msg1 sent ");
		
		TestPort1.msg1();
		System.out.println("msg1 sent ");
		
		TestPort1.msg1();
		System.out.println("msg1 sent ");
		
		TestPort1.msg1();
		System.out.println("msg1 sent ");
	}
	
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
				case STATE_state0:
					this.history[STATE_TOP] = STATE_state0;
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
			case CHAIN_TRANS_INITIAL_TO__state0:
			{
				action_TRANS_INITIAL_TO__state0();
				return STATE_state0;
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
				case STATE_state0:
					// in leaf state: return state id
					return STATE_state0;
				case STATE_TOP:
					state = this.history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__state0;
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
				case STATE_state0:
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
