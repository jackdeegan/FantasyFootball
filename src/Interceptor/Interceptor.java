package Interceptor;

public interface Interceptor {
	
	public void onDatabaseRequest(InfoLogContext context);		//A client might start a timer to measure latency. [PostMarshalOutRequest] [Reader]
	public void onDatabaseReply(InfoLogContext context);		//The reply has just arrived. A client may be interested in stopping a timer 
																//that measures latency. [PreMarshalInReply] [Reader]

}

//To Determine the Context Object Semantics:
//If an interception point belongs to a reader set, determine what information should be provided.

//An interceptor defines a generic interface that a concrete framework uses to invoke concrete interceptors
//via dispatchers when interception points are triggered.
