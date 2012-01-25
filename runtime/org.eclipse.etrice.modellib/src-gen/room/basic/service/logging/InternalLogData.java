package room.basic.service.logging;




public class InternalLogData {
	
	
	//--------------------- attributes
	protected String userString;
	protected String sender;
	protected long timeStamp;
	
	//--------------------- attribute setters and getters
	public void setUserString (String userString) {
		 this.userString = userString;
	}
	public String getUserString () {
		return this.userString;
	}
	public void setSender (String sender) {
		 this.sender = sender;
	}
	public String getSender () {
		return this.sender;
	}
	public void setTimeStamp (long timeStamp) {
		 this.timeStamp = timeStamp;
	}
	public long getTimeStamp () {
		return this.timeStamp;
	}
	
	//--------------------- operations
	
	// default constructor
	public InternalLogData() {
		super();
		// initialize attributes
		userString = "";
		sender = "";
		timeStamp = 0;
	}
	
	// constructor using fields
	public InternalLogData(String userString, String sender, long timeStamp) {
		super();
		this.userString = userString;
		this.sender = sender;
		this.timeStamp = timeStamp;
	}
	
	// deep copy
	public InternalLogData deepCopy() {
		InternalLogData copy = new InternalLogData();
		copy.userString = userString;
		copy.sender = sender;
		copy.timeStamp = timeStamp;
		return copy;
	}
};
