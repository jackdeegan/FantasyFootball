package Interceptor;

public interface Interceptor {
	
	public void onDatabaseRequest(InfoLogContext context);		//Request sent to Database, start a timer to measure latency.
	public void onDatabaseReply(InfoLogContext context);		//Reply returned from Database, timer is stopped.

}