package org.eclipse.etrice.examples.dynamicactors1;

import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
import org.eclipse.etrice.runtime.java.modelbase.IEventReceiver;
import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBroker;
import org.eclipse.etrice.runtime.java.modelbase.ReplicatedOptionalActorInterfaceBase;

class OptionalReplicatedInterface extends ReplicatedOptionalActorInterfaceBase {
	//--------------------- brokers for ports on the interface
	protected InterfaceItemBroker p0 = null;

	//--------------------- interface item IDs
	public static final int IFITEM_p0 = 1;
	
	//--------------------- construction
	public OptionalReplicatedInterface (IEventReceiver parent, String name) {
		super(parent, name, "Optional");
		
		p0 = new InterfaceItemBroker(this, "p0", IFITEM_p0);
	}
	
	@Override
	public int createOptionalActor(String actorClass, int thread) {
		DebuggingService.getInstance().addMessageActorCreate(this, actorClass);
		return super.createOptionalActor(actorClass, thread);
	}
	
	@Override
	public boolean destroyOptionalActor(int idx) {
		DebuggingService.getInstance().addMessageActorDestroy(this);
		return super.destroyOptionalActor(idx);
	}
}
