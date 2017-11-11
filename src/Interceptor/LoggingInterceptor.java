package Interceptor;

public class LoggingInterceptor implements Interceptor {
	
	public void onDatabaseRequest(InfoLogContext context){
		
		System.out.println("onDatabaseRequest method called [Interceptor]");
		
		//Do Something (Print Time to Command Line/Text File, Must incorporate the context object passed)
		
		//System.out.println("Stats updated at time: " + context.getStartTime());	This is the sample FantasyFootball Implementation
	
	}
	
	public void onDatabaseReply(InfoLogContext context){
	
		System.out.println("onDatabaseReply method called [Interceptor]");
		
		//Date endTime = new Date();												This is the sample FantasyFootball Implementation
		//long diff = endTime.getTime() - context.getStartTime().getTime();			This is the sample FantasyFootball Implementation
		//System.out.println("Post - Took " + diff + " milliseconds to complete");	This is the sample FantasyFootball Implementation
		
	}
}