package Interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

import DAL.AccessInterceptorLog;
import DAL.DatabaseService;

public class LoggingInterceptor implements Interceptor {
	
	private DatabaseService interceptorLogDB = new AccessInterceptorLog();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS");
	
	public void onDatabaseRequest(InfoLogContext context){
		
		System.out.println("onDatabaseRequest method called [Interceptor]");
		interceptorLogDB.addData("Database Request Time: " + sdf.format(context.getDatabaseRequestTime()));
	
	}
	
	public void onDatabaseReply(InfoLogContext context){
	
		System.out.println("onDatabaseReply method called [Interceptor]");
		Date databaseReplyTime = new Date();		//Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT 
		interceptorLogDB.addData("Database Reply Time = " + sdf.format(databaseReplyTime));
		long latency = databaseReplyTime.getTime() - context.getDatabaseRequestTime().getTime();
		interceptorLogDB.addData("----------------------------------------------\nTime between Database Request and "
								 													+ "Reply = " + latency + " milliseconds\n\n");

	}
}