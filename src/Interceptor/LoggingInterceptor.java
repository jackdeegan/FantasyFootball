package Interceptor;

import java.util.Date;

public class LoggingInterceptor implements ServerReplyInterceptor{
	@Override
	public void preRemoteReply(ServerReplyContext context) {
		System.out.println("Stats updated at time: " + context.getStartTime());
	}
	
	@Override
	public void postRemoteReply(ServerReplyContext context) {
		Date endTime = new Date();
		long diff = endTime.getTime() - context.getStartTime().getTime();
		
		System.out.println("Post - Took " + diff + "milliseconds to complete.");
	}
}