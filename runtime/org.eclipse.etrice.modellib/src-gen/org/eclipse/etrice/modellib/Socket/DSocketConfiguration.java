package org.eclipse.etrice.modellib.Socket;




public class DSocketConfiguration {
	
	
	//--------------------- attributes
	protected String serverName = "";
	protected int portNumber = 0;
	protected int protocol = 0;
	protected boolean checkCookie = false;
	protected int mode = 0;
	
	//--------------------- attribute setters and getters
	public void setServerName (String serverName) {
		 this.serverName = serverName;
	}
	public String getServerName () {
		return this.serverName;
	}
	public void setPortNumber (int portNumber) {
		 this.portNumber = portNumber;
	}
	public int getPortNumber () {
		return this.portNumber;
	}
	public void setProtocol (int protocol) {
		 this.protocol = protocol;
	}
	public int getProtocol () {
		return this.protocol;
	}
	public void setCheckCookie (boolean checkCookie) {
		 this.checkCookie = checkCookie;
	}
	public boolean getCheckCookie () {
		return this.checkCookie;
	}
	public void setMode (int mode) {
		 this.mode = mode;
	}
	public int getMode () {
		return this.mode;
	}
	
	//--------------------- operations
	
	// default constructor
	public DSocketConfiguration() {
		super();
		// initialize attributes
		serverName = "";
		portNumber = 0;
		protocol = 0;
		checkCookie = false;
		mode = 0;
	}
	
	// constructor using fields
	public DSocketConfiguration(String serverName, int portNumber, int protocol, boolean checkCookie, int mode) {
		super();
		this.serverName = serverName;
		this.portNumber = portNumber;
		this.protocol = protocol;
		this.checkCookie = checkCookie;
		this.mode = mode;
	}
	
	// deep copy
	public DSocketConfiguration deepCopy() {
		DSocketConfiguration copy = new DSocketConfiguration();
		copy.serverName = serverName;
		copy.portNumber = portNumber;
		copy.protocol = protocol;
		copy.checkCookie = checkCookie;
		copy.mode = mode;
		return copy;
	}
};
