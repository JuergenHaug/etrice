package org.eclipse.etrice.integration.HandlerTest;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;


import org.eclipse.etrice.integration.HandlerTest.TestProtocol.*;

//--------------------- begin user code
		import org.eclipse.etrice.integration.tests.helpers.*;
		import org.eclipse.etrice.runtime.java.messaging.RTServices;
	//--------------------- end user code


public class HandlerUser extends ActorClassBase {

	//--------------------- begin user code
			private CRC16Generator crcGen = new CRC16Generator();
		//--------------------- end user code
	
	//--------------------- ports
	protected TestProtocolPort TestPort1 = null;
	//--------------------- saps
	//--------------------- services

	//--------------------- interface item IDs
	protected static final int IFITEM_TestPort1 = 1;
	
	//--------------------- attributes
	protected int counter;
	//--------------------- operations

	//--------------------- construction
	public HandlerUser(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("HandlerUser");
		
		// initialize attributes

		// own ports
		TestPort1 = new TestProtocolPort(this, "TestPort1", IFITEM_TestPort1, 0, port_addr[IFITEM_TestPort1][0], peer_addr[IFITEM_TestPort1][0]); 
		// own saps
		// own service implementations
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
		destroyUser();
	}	

	//******************************************
	// START of generated code for FSM
	//******************************************
	
	// State IDs for FSM
	protected static final int STATE_state0 = 2;
	protected static final int STATE_state0_state1 = 3;
	protected static final int STATE_state0_state1_state7 = 4;
	protected static final int STATE_state0_state2 = 5;
	protected static final int STATE_testOk = 6;
	protected static final int STATE_testFalse = 7;
	protected static final int STATE_state1 = 8;
		protected static final String stateStrings[] = {"<no state>","<top>","state0",
			"state0_state1",
			"state0_state1_state7",
			"state0_state2",
			"testOk",
			"testFalse",
			"state1"
			};
	
	// history
	// TODOHRR: history defined in ActorClassBase, init in constructor
	//		history = new int[5];
	//		for (int i = 0; i < history.length; i++) {
	//			history[i] = NO_STATE;
	//		}
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	// transition chains
	protected static final int CHAIN_TRANS_INITIAL_TO__state0_tp2 = 1;
	protected static final int CHAIN_TRANS_state0_TO_cp1_BY_msg1TestPort1 = 2;
	protected static final int CHAIN_TRANS_tp0_TO_state0_BY_msg1TestPort1 = 3;
	protected static final int CHAIN_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr0 = 4;
	protected static final int CHAIN_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr6 = 5;
	protected static final int CHAIN_TRANS_tp1_TO_cp0_BY_msg6TestPort1 = 6;
	protected static final int CHAIN_TRANS_tp1_TO_tp1_BY_msg1TestPort1_tr1 = 7;
	protected static final int CHAIN_TRANS_tp1_TO_tp1_BY_msg2TestPort1_tr5 = 8;
	protected static final int CHAIN_state0_TRANS_INITIAL_TO__state2 = 9;
	protected static final int CHAIN_state0_TRANS_state1_TO_state1_BY_msg1TestPort1_tr6 = 10;
	protected static final int CHAIN_state0_TRANS_state1_TO_state2_BY_msg5TestPort1 = 11;
	protected static final int CHAIN_state0_TRANS_state2_TO_state2_BY_msg1TestPort1_tr3 = 12;
	protected static final int CHAIN_state0_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr5 = 13;
	protected static final int CHAIN_state0_TRANS_tp0_TO_tp0_BY_msg3TestPort1_tr1 = 14;
	protected static final int CHAIN_state0_TRANS_tp1_TO_state1_BY_msg2TestPort1 = 15;
	protected static final int CHAIN_state0_TRANS_tp1_TO_state2_BY_msg2TestPort1 = 16;
	protected static final int CHAIN_state0_TRANS_tp1_TO_tp1_BY_msg4TestPort1_tr2 = 17;
	protected static final int CHAIN_state0_state1_TRANS_INITIAL_TO__state7 = 18;
	
	// triggers for FSM
	protected static final int TRIG_TestPort1__msg1 = IFITEM_TestPort1 + EVT_SHIFT*TestProtocol.IN_msg1;
	protected static final int TRIG_TestPort1__msg2 = IFITEM_TestPort1 + EVT_SHIFT*TestProtocol.IN_msg2;
	protected static final int TRIG_TestPort1__msg3 = IFITEM_TestPort1 + EVT_SHIFT*TestProtocol.IN_msg3;
	protected static final int TRIG_TestPort1__msg4 = IFITEM_TestPort1 + EVT_SHIFT*TestProtocol.IN_msg4;
	protected static final int TRIG_TestPort1__msg5 = IFITEM_TestPort1 + EVT_SHIFT*TestProtocol.IN_msg5;
	protected static final int TRIG_TestPort1__msg6 = IFITEM_TestPort1 + EVT_SHIFT*TestProtocol.IN_msg6;
	
	// receiveEvent contains the main implementation of the FSM
	@Override
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object generic_data) {
		int trigger = ifitem.getLocalId() + EVT_SHIFT*evt;
		int chain = NOT_CAUGHT;
		int catching_state = NO_STATE;
		boolean is_handler = false;
		boolean skip_entry = false;
		
		if (!handleSystemEvent(ifitem, evt, generic_data)) {
			switch (state) {
				case STATE_state0_state1_state7:
					switch(trigger) {
					case TRIG_TestPort1__msg5:
						{
							chain = CHAIN_state0_TRANS_state1_TO_state2_BY_msg5TestPort1;
							catching_state = STATE_state0;
						}
					break;
					case TRIG_TestPort1__msg1:
						{ int p1 = (Integer) generic_data;
							if (p1==8
							)
						{
							chain = CHAIN_state0_TRANS_state1_TO_state1_BY_msg1TestPort1_tr6;
							catching_state = STATE_state0;
						} else 
							if (p1==5
							)
						{
							chain = CHAIN_state0_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr5;
							catching_state = STATE_state0;
							is_handler = true;
							skip_entry = true;
						} else 
							if (p1==4
							)
						{
							chain = CHAIN_TRANS_state0_TO_cp1_BY_msg1TestPort1;
							catching_state = STATE_TOP;
						} else 
							if (p1==7
							)
						{
							chain = CHAIN_TRANS_tp0_TO_state0_BY_msg1TestPort1;
							catching_state = STATE_TOP;
							is_handler = true;
						} else 
							if (p1==12
							)
						{
							chain = CHAIN_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr6;
							catching_state = STATE_TOP;
							is_handler = true;
							skip_entry = true;
						} else 
							if (p1==3
							)
						{
							chain = CHAIN_TRANS_tp1_TO_tp1_BY_msg1TestPort1_tr1;
							catching_state = STATE_TOP;
							skip_entry = true;
						} else 
						{
							chain = CHAIN_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr0;
							catching_state = STATE_TOP;
							is_handler = true;
							skip_entry = true;
						}
						}
					break;
					case TRIG_TestPort1__msg3:
						{
							chain = CHAIN_state0_TRANS_tp0_TO_tp0_BY_msg3TestPort1_tr1;
							catching_state = STATE_state0;
							is_handler = true;
							skip_entry = true;
						}
					break;
					case TRIG_TestPort1__msg4:
						{
							chain = CHAIN_state0_TRANS_tp1_TO_tp1_BY_msg4TestPort1_tr2;
							catching_state = STATE_state0;
							skip_entry = true;
						}
					break;
					case TRIG_TestPort1__msg2:
						{ int p1 = (Integer) generic_data;
							if (p1==5
							)
						{
							chain = CHAIN_state0_TRANS_tp1_TO_state1_BY_msg2TestPort1;
							catching_state = STATE_state0;
						} else 
							if (p1==6
							)
						{
							chain = CHAIN_state0_TRANS_tp1_TO_state2_BY_msg2TestPort1;
							catching_state = STATE_state0;
						} else 
							if (p1==4
							)
						{
							chain = CHAIN_TRANS_tp1_TO_tp1_BY_msg2TestPort1_tr5;
							catching_state = STATE_TOP;
							skip_entry = true;
						}
						}
					break;
					case TRIG_TestPort1__msg6:
						{
							chain = CHAIN_TRANS_tp1_TO_cp0_BY_msg6TestPort1;
							catching_state = STATE_TOP;
						}
					break;
					}
					break;
				case STATE_state0_state2:
					switch(trigger) {
					case TRIG_TestPort1__msg1:
						{
							chain = CHAIN_state0_TRANS_state2_TO_state2_BY_msg1TestPort1_tr3;
							catching_state = STATE_state0;
						}
					break;
					case TRIG_TestPort1__msg3:
						{
							chain = CHAIN_state0_TRANS_tp0_TO_tp0_BY_msg3TestPort1_tr1;
							catching_state = STATE_state0;
							is_handler = true;
							skip_entry = true;
						}
					break;
					case TRIG_TestPort1__msg4:
						{
							chain = CHAIN_state0_TRANS_tp1_TO_tp1_BY_msg4TestPort1_tr2;
							catching_state = STATE_state0;
							skip_entry = true;
						}
					break;
					case TRIG_TestPort1__msg2:
						{ int p1 = (Integer) generic_data;
							if (p1==5
							)
						{
							chain = CHAIN_state0_TRANS_tp1_TO_state1_BY_msg2TestPort1;
							catching_state = STATE_state0;
						} else 
							if (p1==6
							)
						{
							chain = CHAIN_state0_TRANS_tp1_TO_state2_BY_msg2TestPort1;
							catching_state = STATE_state0;
						} else 
							if (p1==4
							)
						{
							chain = CHAIN_TRANS_tp1_TO_tp1_BY_msg2TestPort1_tr5;
							catching_state = STATE_TOP;
							skip_entry = true;
						}
						}
					break;
					case TRIG_TestPort1__msg6:
						{
							chain = CHAIN_TRANS_tp1_TO_cp0_BY_msg6TestPort1;
							catching_state = STATE_TOP;
						}
					break;
					}
					break;
				case STATE_testOk:
					switch(trigger) {
					case TRIG_TestPort1__msg1:
						{ int p1 = (Integer) generic_data;
							if (p1==7
							)
						{
							chain = CHAIN_TRANS_tp0_TO_state0_BY_msg1TestPort1;
							catching_state = STATE_TOP;
							is_handler = true;
						} else 
							if (p1==12
							)
						{
							chain = CHAIN_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr6;
							catching_state = STATE_TOP;
							is_handler = true;
							skip_entry = true;
						} else 
							if (p1==3
							)
						{
							chain = CHAIN_TRANS_tp1_TO_tp1_BY_msg1TestPort1_tr1;
							catching_state = STATE_TOP;
							skip_entry = true;
						} else 
						{
							chain = CHAIN_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr0;
							catching_state = STATE_TOP;
							is_handler = true;
							skip_entry = true;
						}
						}
					break;
					case TRIG_TestPort1__msg2:
						{ int p1 = (Integer) generic_data;
							if (p1==4
							)
						{
							chain = CHAIN_TRANS_tp1_TO_tp1_BY_msg2TestPort1_tr5;
							catching_state = STATE_TOP;
							skip_entry = true;
						}
						}
					break;
					case TRIG_TestPort1__msg6:
						{
							chain = CHAIN_TRANS_tp1_TO_cp0_BY_msg6TestPort1;
							catching_state = STATE_TOP;
						}
					break;
					}
					break;
				case STATE_testFalse:
					switch(trigger) {
					case TRIG_TestPort1__msg1:
						{ int p1 = (Integer) generic_data;
							if (p1==7
							)
						{
							chain = CHAIN_TRANS_tp0_TO_state0_BY_msg1TestPort1;
							catching_state = STATE_TOP;
							is_handler = true;
						} else 
							if (p1==12
							)
						{
							chain = CHAIN_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr6;
							catching_state = STATE_TOP;
							is_handler = true;
							skip_entry = true;
						} else 
							if (p1==3
							)
						{
							chain = CHAIN_TRANS_tp1_TO_tp1_BY_msg1TestPort1_tr1;
							catching_state = STATE_TOP;
							skip_entry = true;
						} else 
						{
							chain = CHAIN_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr0;
							catching_state = STATE_TOP;
							is_handler = true;
							skip_entry = true;
						}
						}
					break;
					case TRIG_TestPort1__msg2:
						{ int p1 = (Integer) generic_data;
							if (p1==4
							)
						{
							chain = CHAIN_TRANS_tp1_TO_tp1_BY_msg2TestPort1_tr5;
							catching_state = STATE_TOP;
							skip_entry = true;
						}
						}
					break;
					case TRIG_TestPort1__msg6:
						{
							chain = CHAIN_TRANS_tp1_TO_cp0_BY_msg6TestPort1;
							catching_state = STATE_TOP;
						}
					break;
					}
					break;
				case STATE_state1:
					switch(trigger) {
					case TRIG_TestPort1__msg1:
						{ int p1 = (Integer) generic_data;
							if (p1==7
							)
						{
							chain = CHAIN_TRANS_tp0_TO_state0_BY_msg1TestPort1;
							catching_state = STATE_TOP;
							is_handler = true;
						} else 
							if (p1==12
							)
						{
							chain = CHAIN_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr6;
							catching_state = STATE_TOP;
							is_handler = true;
							skip_entry = true;
						} else 
							if (p1==3
							)
						{
							chain = CHAIN_TRANS_tp1_TO_tp1_BY_msg1TestPort1_tr1;
							catching_state = STATE_TOP;
							skip_entry = true;
						} else 
						{
							chain = CHAIN_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr0;
							catching_state = STATE_TOP;
							is_handler = true;
							skip_entry = true;
						}
						}
					break;
					case TRIG_TestPort1__msg2:
						{ int p1 = (Integer) generic_data;
							if (p1==4
							)
						{
							chain = CHAIN_TRANS_tp1_TO_tp1_BY_msg2TestPort1_tr5;
							catching_state = STATE_TOP;
							skip_entry = true;
						}
						}
					break;
					case TRIG_TestPort1__msg6:
						{
							chain = CHAIN_TRANS_tp1_TO_cp0_BY_msg6TestPort1;
							catching_state = STATE_TOP;
						}
					break;
					}
					break;
			}
		}
		if (chain != NOT_CAUGHT) {
			exitTo(state, catching_state, is_handler);
			int next = executeTransitionChain(chain, ifitem, generic_data);
			next = enterHistory(next, is_handler, skip_entry);
			setState(next);
		}
	}
	
	private void setState(int new_state) {
		DebuggingService.getInstance().addActorState(this,stateStrings[new_state]);
		if (stateStrings[new_state]!="Idle") {
			// TODOTS: model switch for activation
			System.out.println(getInstancePath() + " -> " + stateStrings[new_state]);
		}	
		this.state = new_state;
	}
	
	@Override
	public void executeInitTransition() {
		int chain = CHAIN_TRANS_INITIAL_TO__state0_tp2;
		int next = executeTransitionChain(chain, null, null);
		next = enterHistory(next, false, false);
		setState(next);
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
					if (!handler) exit_state0();
					history[STATE_TOP] = STATE_state0;
					current = STATE_TOP;
					break;
				case STATE_state0_state1:
					if (!handler) exit_state0_state1();
					history[STATE_state0] = STATE_state0_state1;
					current = STATE_state0;
					break;
				case STATE_state0_state1_state7:
					if (!handler) exit_state0_state1_state7();
					history[STATE_state0_state1] = STATE_state0_state1_state7;
					current = STATE_state0_state1;
					break;
				case STATE_state0_state2:
					if (!handler) exit_state0_state2();
					history[STATE_state0] = STATE_state0_state2;
					current = STATE_state0;
					break;
				case STATE_testOk:
					history[STATE_TOP] = STATE_testOk;
					current = STATE_TOP;
					break;
				case STATE_testFalse:
					history[STATE_TOP] = STATE_testFalse;
					current = STATE_TOP;
					break;
				case STATE_state1:
					if (!handler) exit_state1();
					history[STATE_TOP] = STATE_state1;
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
			case CHAIN_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr0:
			{
				int p1 = (Integer) generic_data;
				action_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr0(ifitem, p1);
				return STATE_TOP;
			}
			case CHAIN_TRANS_tp1_TO_tp1_BY_msg1TestPort1_tr1:
			{
				int p1 = (Integer) generic_data;
				action_TRANS_tp1_TO_tp1_BY_msg1TestPort1_tr1(ifitem, p1);
				return STATE_TOP;
			}
			case CHAIN_TRANS_INITIAL_TO__state0_tp2:
			{
				action_TRANS_INITIAL_TO__state0_tp2();
				entry_state0();
				action_state0_TRANS_tp2_TO_state0_state1_tp0(ifitem);
				entry_state0_state1();
				action_state0_state1_TRANS_tp0_TO_state7(ifitem);
				return STATE_state0_state1_state7;
			}
			case CHAIN_TRANS_state0_TO_cp1_BY_msg1TestPort1:
			{
				int p1 = (Integer) generic_data;
				action_TRANS_state0_TO_cp1_BY_msg1TestPort1(ifitem, p1);
				if (p1!=4
				) {
				action_TRANS_cp1_TO_state0_COND_tr10(ifitem, p1);
				return STATE_state0;}
				else {
				action_TRANS_cp1_TO_state1(ifitem, p1);
				return STATE_state1;}
			}
			case CHAIN_TRANS_tp1_TO_tp1_BY_msg2TestPort1_tr5:
			{
				int p1 = (Integer) generic_data;
				action_TRANS_tp1_TO_tp1_BY_msg2TestPort1_tr5(ifitem, p1);
				return STATE_TOP;
			}
			case CHAIN_TRANS_tp0_TO_state0_BY_msg1TestPort1:
			{
				int p1 = (Integer) generic_data;
				action_TRANS_tp0_TO_state0_BY_msg1TestPort1(ifitem, p1);
				return STATE_state0;
			}
			case CHAIN_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr6:
			{
				int p1 = (Integer) generic_data;
				action_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr6(ifitem, p1);
				return STATE_TOP;
			}
			case CHAIN_TRANS_tp1_TO_cp0_BY_msg6TestPort1:
			{
				int p1 = (Integer) generic_data;
				action_TRANS_tp1_TO_cp0_BY_msg6TestPort1(ifitem, p1);
				if (crcGen.getCrc()==7268
				) {
				action_TRANS_cp0_TO_testOk_COND_tr3(ifitem, p1);
				return STATE_testOk;}
				else {
				action_TRANS_cp0_TO_testFalse(ifitem, p1);
				return STATE_testFalse;}
			}
			case CHAIN_state0_TRANS_state1_TO_state2_BY_msg5TestPort1:
			{
				int p1 = (Integer) generic_data;
				return STATE_state0_state2;
			}
			case CHAIN_state0_TRANS_tp0_TO_tp0_BY_msg3TestPort1_tr1:
			{
				action_state0_TRANS_tp0_TO_tp0_BY_msg3TestPort1_tr1(ifitem);
				return STATE_state0;
			}
			case CHAIN_state0_TRANS_tp1_TO_tp1_BY_msg4TestPort1_tr2:
			{
				action_state0_TRANS_tp1_TO_tp1_BY_msg4TestPort1_tr2(ifitem);
				return STATE_state0;
			}
			case CHAIN_state0_TRANS_state2_TO_state2_BY_msg1TestPort1_tr3:
			{
				int p1 = (Integer) generic_data;
				action_state0_TRANS_state2_TO_state2_BY_msg1TestPort1_tr3(ifitem, p1);
				return STATE_state0_state2;
			}
			case CHAIN_state0_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr5:
			{
				int p1 = (Integer) generic_data;
				action_state0_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr5(ifitem, p1);
				return STATE_state0;
			}
			case CHAIN_state0_TRANS_INITIAL_TO__state2:
			{
				action_state0_TRANS_INITIAL_TO__state2();
				return STATE_state0_state2;
			}
			case CHAIN_state0_TRANS_state1_TO_state1_BY_msg1TestPort1_tr6:
			{
				int p1 = (Integer) generic_data;
				action_state0_TRANS_state1_TO_state1_BY_msg1TestPort1_tr6(ifitem, p1);
				return STATE_state0_state1;
			}
			case CHAIN_state0_TRANS_tp1_TO_state1_BY_msg2TestPort1:
			{
				int p1 = (Integer) generic_data;
				action_state0_TRANS_tp1_TO_state1_BY_msg2TestPort1(ifitem, p1);
				return STATE_state0_state1;
			}
			case CHAIN_state0_TRANS_tp1_TO_state2_BY_msg2TestPort1:
			{
				int p1 = (Integer) generic_data;
				action_state0_TRANS_tp1_TO_state2_BY_msg2TestPort1(ifitem, p1);
				return STATE_state0_state2;
			}
			case CHAIN_state0_state1_TRANS_INITIAL_TO__state7:
			{
				action_state0_state1_TRANS_INITIAL_TO__state7();
				return STATE_state0_state1_state7;
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
					if (!(skip_entry || handler)) entry_state0();
					// state has a sub graph
					// with init transition
					if (history[STATE_state0]==NO_STATE) {
						state = executeTransitionChain(CHAIN_TRANS_INITIAL_TO__state0_tp2, null, null);
					}
					else {
						state = history[STATE_state0];
					}
					break;
				case STATE_state0_state1:
					if (!(skip_entry || handler)) entry_state0_state1();
					// state has a sub graph
					// with init transition
					if (history[STATE_state0_state1]==NO_STATE) {
						state = executeTransitionChain(CHAIN_TRANS_INITIAL_TO__state0_tp2, null, null);
					}
					else {
						state = history[STATE_state0_state1];
					}
					break;
				case STATE_state0_state1_state7:
					if (!(skip_entry || handler)) entry_state0_state1_state7();
					// in leaf state: return state id
					return STATE_state0_state1_state7;
				case STATE_state0_state2:
					if (!(skip_entry || handler)) entry_state0_state2();
					// in leaf state: return state id
					return STATE_state0_state2;
				case STATE_testOk:
					// in leaf state: return state id
					return STATE_testOk;
				case STATE_testFalse:
					// in leaf state: return state id
					return STATE_testFalse;
				case STATE_state1:
					if (!(skip_entry || handler)) entry_state1();
					// in leaf state: return state id
					return STATE_state1;
				case STATE_TOP:
					state = history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	//*** Entry and Exit Codes
	protected void entry_state0() {
		System.out.println("state 0 entry action");
		crcGen.update(13);
		}
	protected void exit_state0() {
		System.out.println("state 0 exit action");
		crcGen.update(14);
		}
	protected void entry_state0_state1() {
		System.out.println("state 0/1 entry action");
		crcGen.update(16);
		}
	protected void exit_state0_state1() {
		System.out.println("state 0/1 exit action");
		crcGen.update(17);
		}
	protected void entry_state0_state1_state7() {
		System.out.println("state 0/1/7 entry action");
		crcGen.update(23);
		}
	protected void exit_state0_state1_state7() {
		System.out.println("state 0/1/7 exit action");
		crcGen.update(24);
		}
	protected void entry_state0_state2() {
		System.out.println("state 0/2 entry action");
		crcGen.update(18);
		}
	protected void exit_state0_state2() {
		System.out.println("state 0/2 exit action");
		crcGen.update(19);
		}
	protected void entry_state1() {
		System.out.println("state 1 entry action");
		crcGen.update(111);
		}
	protected void exit_state1() {
		System.out.println("state 1 exit action");
		crcGen.update(112);
		}
	
	//*** Action Codes
	protected void action_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr0(InterfaceItemBase ifitem, int p1) {
		System.out.println("top level handler action no guard ");
		crcGen.update(11);
		}
	protected void action_TRANS_tp1_TO_tp1_BY_msg1TestPort1_tr1(InterfaceItemBase ifitem, int p1) {
		System.out.println("top level self transition action P1=>3");
		crcGen.update(12);
		}
	protected void action_TRANS_INITIAL_TO__state0_tp2() {
		System.out.println("top level initial transition");
		crcGen.update(10);
		}
	protected void action_TRANS_cp0_TO_testFalse(InterfaceItemBase ifitem, int p1) {
		System.out.println("Test false");
		RTServices.getInstance().getSubSystem().testFinished(1);
		}
	protected void action_TRANS_cp0_TO_testOk_COND_tr3(InterfaceItemBase ifitem, int p1) {
		System.out.println("Test ok");
		RTServices.getInstance().getSubSystem().testFinished(0);
		}
	protected void action_TRANS_state0_TO_cp1_BY_msg1TestPort1(InterfaceItemBase ifitem, int p1) {
		System.out.println("tr9 transition action");
		crcGen.update(114);
		}
	protected void action_TRANS_tp1_TO_tp1_BY_msg2TestPort1_tr5(InterfaceItemBase ifitem, int p1) {
		System.out.println("top level self transition action P1=>4");
		crcGen.update(50);
		}
	protected void action_TRANS_tp0_TO_state0_BY_msg1TestPort1(InterfaceItemBase ifitem, int p1) {
		System.out.println("top level handler action p1=>7 ");
		crcGen.update(70);
		}
	protected void action_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr6(InterfaceItemBase ifitem, int p1) {
		System.out.println("top level handler action p1=>12 ");
		crcGen.update(110);
		}
	protected void action_TRANS_cp1_TO_state1(InterfaceItemBase ifitem, int p1) {
		System.out.println("tr8 transition action");
		crcGen.update(113);
		}
	protected void action_TRANS_cp1_TO_state0_COND_tr10(InterfaceItemBase ifitem, int p1) {
		System.out.println("tr4 transition action");
		crcGen.update(115);
		}
	protected void action_TRANS_tp1_TO_cp0_BY_msg6TestPort1(InterfaceItemBase ifitem, int p1) {
		System.out.println("tp1 transition to choice action");
		crcGen.update(117);
		System.out.printf("CRC: %d \n", crcGen.getCrc());
		}
	protected void action_state0_TRANS_tp0_TO_tp0_BY_msg3TestPort1_tr1(InterfaceItemBase ifitem) {
		System.out.println("state 0 handler action no guard");
		crcGen.update(20);
		}
	protected void action_state0_TRANS_tp1_TO_tp1_BY_msg4TestPort1_tr2(InterfaceItemBase ifitem) {
		System.out.println("state 0 tp1 self transition action");
		crcGen.update(21);
		}
	protected void action_state0_TRANS_state2_TO_state2_BY_msg1TestPort1_tr3(InterfaceItemBase ifitem, int p1) {
		System.out.println("state 0/2 self transition action");
		crcGen.update(25);
		}
	protected void action_state0_TRANS_tp2_TO_state0_state1_tp0(InterfaceItemBase ifitem) {
		System.out.println("state 0 tp2 transition action");
		crcGen.update(15);
		}
	protected void action_state0_TRANS_tp0_TO_tp0_BY_msg1TestPort1_tr5(InterfaceItemBase ifitem, int p1) {
		System.out.println("state 0 handler action P1 => 5");
		crcGen.update(52);
		}
	protected void action_state0_TRANS_INITIAL_TO__state2() {
		System.out.println("state 0 initial transition");
		crcGen.update(53);
		}
	protected void action_state0_TRANS_state1_TO_state1_BY_msg1TestPort1_tr6(InterfaceItemBase ifitem, int p1) {
		System.out.println("state 0/1 self transition");
		crcGen.update(54);
		}
	protected void action_state0_TRANS_tp1_TO_state1_BY_msg2TestPort1(InterfaceItemBase ifitem, int p1) {
		System.out.println("state 0 tp1 p1=>5");
		crcGen.update(120);
		}
	protected void action_state0_TRANS_tp1_TO_state2_BY_msg2TestPort1(InterfaceItemBase ifitem, int p1) {
		System.out.println("state 0 tp1 action P1 => 6");
		crcGen.update(121);
		}
	protected void action_state0_state1_TRANS_tp0_TO_state7(InterfaceItemBase ifitem) {
		System.out.println("state 0/1 transition entry action");
		crcGen.update(22);
		}
	protected void action_state0_state1_TRANS_INITIAL_TO__state7() {
		System.out.println("state 0/1 initial transition");
		crcGen.update(121);
		}
		 
	//******************************************
	// END of generated code for FSM
	//******************************************
};
