package PedLightsController;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;





public class PedLightsTop extends ActorClassBase {

	
	
	//--------------------- ports
	
	//--------------------- saps
	
	//--------------------- services

	//--------------------- interface item IDs

	/*--------------------- attributes ---------------------*/
	/*--------------------- operations ---------------------*/

	//--------------------- construction
	public PedLightsTop(IRTObject parent, String name) {
		super(parent, name);
		setClassName("PedLightsTop");
		
		// initialize attributes

		// own ports
		
		// own saps
		
		// own service implementations
	}

	
	//--------------------- attribute setters and getters
	
	
	//--------------------- port getters

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

	//--------------------- no state machine
	@Override
	public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data) {
	handleSystemEvent(ifitem, evt, data);
	}
	
	@Override
	public void executeInitTransition(){
	}
};
