package Interceptor;

import java.util.Date;

public class InfoLogContext {
	
	private Date startTime;
	
	public InfoLogContext(Date startTime) {
	
		this.startTime = startTime;
		
	}
	
	public Date getStartTime() {
		return startTime;
	}
}