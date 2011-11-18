package PedLightsController;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;

import room.basic.service.timing.*;

import room.basic.service.timing.PTimeout.*;
import PedLightsController.PedControlProtocol.*;

//--------------------- begin user code
		import org.eclipse.etrice.tutorials.PedLightGUI.*;
	//--------------------- end user code


public class Controller extends ActorClassBase {

	
	//--------------------- ports
	protected PedControlProtocolPort ControlPort = null;
	//--------------------- saps
	protected PTimeoutConjPort timer = null;
	//--------------------- services

	//--------------------- interface item IDs
	protected static final int IFITEM_ControlPort = 1;
	protected static final int IFITEM_timer = 2;
	
	//--------------------- attributes
	//--------------------- operations

	//--------------------- construction
	public Controller(IRTObject parent, String name, Address[][] port_addr, Address[][] peer_addr){
		super(parent, name, port_addr[0][0], peer_addr[0][0]);
		setClassName("Controller");
		
		// initialize attributes

		// own ports
		ControlPort = new PedControlProtocolPort(this, "ControlPort", IFITEM_ControlPort, 0, port_addr[IFITEM_ControlPort][0], peer_addr[IFITEM_ControlPort][0]); 
		// own saps
		timer = new PTimeoutConjPort(this, "timer", IFITEM_timer, 0, port_addr[IFITEM_timer][0], peer_addr[IFITEM_timer][0]); 
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
	protected static final int STATE_off = 2;
	protected static final int STATE_carsGreen = 3;
	protected static final int STATE_carsYellow = 4;
	protected static final int STATE_carsRed = 5;
	protected static final int STATE_carsYellowRed = 6;
	protected static final int STATE_carsGreen2 = 7;
		protected static final String stateStrings[] = {"<no state>","<top>","off",
			"carsGreen",
			"carsYellow",
			"carsRed",
			"carsYellowRed",
			"carsGreen2"
			};
	
	// history
	// TODOHRR: history defined in ActorClassBase, init in constructor
	//		history = new int[5];
	//		for (int i = 0; i < history.length; i++) {
	//			history[i] = NO_STATE;
	//		}
	protected int history[] = {NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE,NO_STATE};
	
	// transition chains
	protected static final int CHAIN_TRANS_INITIAL_TO__off = 1;
	protected static final int CHAIN_TRANS_carsGreen2_TO_off_BY_timeoutTicktimer = 2;
	protected static final int CHAIN_TRANS_carsGreen_TO_carsYellow_BY_timeoutTicktimer = 3;
	protected static final int CHAIN_TRANS_carsRed_TO_carsYellowRed_BY_timeoutTicktimer = 4;
	protected static final int CHAIN_TRANS_carsYellowRed_TO_carsGreen2_BY_timeoutTicktimer = 5;
	protected static final int CHAIN_TRANS_carsYellow_TO_carsRed_BY_timeoutTicktimer = 6;
	protected static final int CHAIN_TRANS_off_TO_carsGreen_BY_startControlPort = 7;
	
	// triggers for FSM
	protected static final int TRIG_ControlPort__start = IFITEM_ControlPort + EVT_SHIFT*PedControlProtocol.IN_start;
	protected static final int TRIG_timer__timeoutTick = IFITEM_timer + EVT_SHIFT*PTimeout.OUT_timeoutTick;
	
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
				case STATE_off:
					switch(trigger) {
					case TRIG_ControlPort__start:
						{
							chain = CHAIN_TRANS_off_TO_carsGreen_BY_startControlPort;
							catching_state = STATE_TOP;
						}
					break;
					}
					break;
				case STATE_carsGreen:
					switch(trigger) {
					case TRIG_timer__timeoutTick:
						{
							chain = CHAIN_TRANS_carsGreen_TO_carsYellow_BY_timeoutTicktimer;
							catching_state = STATE_TOP;
						}
					break;
					}
					break;
				case STATE_carsYellow:
					switch(trigger) {
					case TRIG_timer__timeoutTick:
						{
							chain = CHAIN_TRANS_carsYellow_TO_carsRed_BY_timeoutTicktimer;
							catching_state = STATE_TOP;
						}
					break;
					}
					break;
				case STATE_carsRed:
					switch(trigger) {
					case TRIG_timer__timeoutTick:
						{
							chain = CHAIN_TRANS_carsRed_TO_carsYellowRed_BY_timeoutTicktimer;
							catching_state = STATE_TOP;
						}
					break;
					}
					break;
				case STATE_carsYellowRed:
					switch(trigger) {
					case TRIG_timer__timeoutTick:
						{
							chain = CHAIN_TRANS_carsYellowRed_TO_carsGreen2_BY_timeoutTicktimer;
							catching_state = STATE_TOP;
						}
					break;
					}
					break;
				case STATE_carsGreen2:
					switch(trigger) {
					case TRIG_timer__timeoutTick:
						{
							chain = CHAIN_TRANS_carsGreen2_TO_off_BY_timeoutTicktimer;
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
		int chain = CHAIN_TRANS_INITIAL_TO__off;
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
				case STATE_off:
					history[STATE_TOP] = STATE_off;
					current = STATE_TOP;
					break;
				case STATE_carsGreen:
					history[STATE_TOP] = STATE_carsGreen;
					current = STATE_TOP;
					break;
				case STATE_carsYellow:
					history[STATE_TOP] = STATE_carsYellow;
					current = STATE_TOP;
					break;
				case STATE_carsRed:
					history[STATE_TOP] = STATE_carsRed;
					current = STATE_TOP;
					break;
				case STATE_carsYellowRed:
					history[STATE_TOP] = STATE_carsYellowRed;
					current = STATE_TOP;
					break;
				case STATE_carsGreen2:
					history[STATE_TOP] = STATE_carsGreen2;
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
			case CHAIN_TRANS_INITIAL_TO__off:
			{
				return STATE_off;
			}
			case CHAIN_TRANS_off_TO_carsGreen_BY_startControlPort:
			{
				action_TRANS_off_TO_carsGreen_BY_startControlPort(ifitem);
				return STATE_carsGreen;
			}
			case CHAIN_TRANS_carsGreen_TO_carsYellow_BY_timeoutTicktimer:
			{
				action_TRANS_carsGreen_TO_carsYellow_BY_timeoutTicktimer(ifitem);
				return STATE_carsYellow;
			}
			case CHAIN_TRANS_carsYellow_TO_carsRed_BY_timeoutTicktimer:
			{
				action_TRANS_carsYellow_TO_carsRed_BY_timeoutTicktimer(ifitem);
				return STATE_carsRed;
			}
			case CHAIN_TRANS_carsRed_TO_carsYellowRed_BY_timeoutTicktimer:
			{
				action_TRANS_carsRed_TO_carsYellowRed_BY_timeoutTicktimer(ifitem);
				return STATE_carsYellowRed;
			}
			case CHAIN_TRANS_carsYellowRed_TO_carsGreen2_BY_timeoutTicktimer:
			{
				action_TRANS_carsYellowRed_TO_carsGreen2_BY_timeoutTicktimer(ifitem);
				return STATE_carsGreen2;
			}
			case CHAIN_TRANS_carsGreen2_TO_off_BY_timeoutTicktimer:
			{
				action_TRANS_carsGreen2_TO_off_BY_timeoutTicktimer(ifitem);
				return STATE_off;
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
				case STATE_off:
					// in leaf state: return state id
					return STATE_off;
				case STATE_carsGreen:
					// in leaf state: return state id
					return STATE_carsGreen;
				case STATE_carsYellow:
					// in leaf state: return state id
					return STATE_carsYellow;
				case STATE_carsRed:
					// in leaf state: return state id
					return STATE_carsRed;
				case STATE_carsYellowRed:
					// in leaf state: return state id
					return STATE_carsYellowRed;
				case STATE_carsGreen2:
					// in leaf state: return state id
					return STATE_carsGreen2;
				case STATE_TOP:
					state = history[STATE_TOP];
					break;
			}
			skip_entry = false;
		}
		//return NO_STATE; // required by CDT but detected as unreachable by JDT because of while (true)
	}
	
	//*** Entry and Exit Codes
	
	//*** Action Codes
	protected void action_TRANS_off_TO_carsGreen_BY_startControlPort(InterfaceItemBase ifitem) {
		timer.Start(700);
		ControlPort.setCarLights(TrafficLight3.GREEN);
		ControlPort.setPedLights(TrafficLight2.RED);
	}
	protected void action_TRANS_carsGreen_TO_carsYellow_BY_timeoutTicktimer(InterfaceItemBase ifitem) {
		timer.Start(700);
		ControlPort.setCarLights(TrafficLight3.YELLOW);
		ControlPort.setPedLights(TrafficLight2.RED);
	}
	protected void action_TRANS_carsYellow_TO_carsRed_BY_timeoutTicktimer(InterfaceItemBase ifitem) {
		timer.Start(1500);
		ControlPort.setCarLights(TrafficLight3.RED);
		ControlPort.setPedLights(TrafficLight2.GREEN);
	}
	protected void action_TRANS_carsRed_TO_carsYellowRed_BY_timeoutTicktimer(InterfaceItemBase ifitem) {
		timer.Start(700);
		ControlPort.setCarLights(TrafficLight3.YELLOW_RED);
		ControlPort.setPedLights(TrafficLight2.RED);
	}
	protected void action_TRANS_carsYellowRed_TO_carsGreen2_BY_timeoutTicktimer(InterfaceItemBase ifitem) {
		timer.Start(700);
		ControlPort.setCarLights(TrafficLight3.GREEN);
		ControlPort.setPedLights(TrafficLight2.RED);
	}
	protected void action_TRANS_carsGreen2_TO_off_BY_timeoutTicktimer(InterfaceItemBase ifitem) {
		ControlPort.setCarLights(TrafficLight3.OFF);
		ControlPort.setPedLights(TrafficLight2.OFF);
	}
		 
	//******************************************
	// END of generated code for FSM
	//******************************************
};
