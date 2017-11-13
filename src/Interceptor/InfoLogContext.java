package Interceptor;

import java.util.Date;

public class InfoLogContext {
	
	private Date databaseRequestTime;
	
	public InfoLogContext(Date databaseRequestTime) {
	
		this.databaseRequestTime = databaseRequestTime;
		
	}
	
	public Date getDatabaseRequestTime() {
		return databaseRequestTime;
	}
}