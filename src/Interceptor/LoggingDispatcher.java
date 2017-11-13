package Interceptor;

import java.util.ArrayList;
import java.util.List;

public class LoggingDispatcher {
	
	List<Interceptor> listOfInterceptors = new ArrayList<Interceptor>();
	
	public void register(Interceptor anInterceptor) {
		
		listOfInterceptors.add(anInterceptor);
	
	}
	
	public void remove(Interceptor anInterceptor) {
	
		listOfInterceptors.remove(anInterceptor);
	
	}
	
	public void onDatabaseRequest(InfoLogContext context) {
	
		for (Interceptor anInterceptor : listOfInterceptors)
			anInterceptor.onDatabaseRequest(context);
	
	}
	
	public void onDatabaseReply(InfoLogContext context) {
	
		for (Interceptor anInterceptor : listOfInterceptors)
			anInterceptor.onDatabaseReply(context);
	
	}
}