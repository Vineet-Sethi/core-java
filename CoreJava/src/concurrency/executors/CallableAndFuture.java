package concurrency.executors;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFuture {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		for(int i = 0; i < 5; i++)
		{
			Future<Integer> future = executor.submit(new CnFTask());
			
			try {
				Integer result = future.get();   //blocking call
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		executor.shutdown();
	}
}

class CnFTask implements Callable<Integer> {

	@Override
	public Integer call() throws Exception
	{
		Thread.sleep(3000);
		return new Random().nextInt();
	}
}

/*
	The runnable tasks that we were submitting earlier did not return any value. What if the tasks executing in the pool needed to return some 
	value. In that case we need to create a Callable. A Callable like a Runnable has only 1 method call. The pool methods
		execute - accepts only runnables
		submit - accepts both callables and runnables.
		
	The callable is generically parameterized for the call to return the type of the object we are interested in. The submit method returns a 
	Future is a placeholder for the value which will arrive sometime in the future. It wraps the value returned by the call method. To actually
	get the value you call the get method which is a blocking method. Hence at the get call you need to wait until the call method completes.
		
	Note
		Future<Integer> future = executor.submit(new CnFTask());
		This pool immediately returns a Future object however the value only arrives when the call method has finished. So your main thread is 
		free to perform other tasks.
		
	Since the get call is blocking you can use an overloaded get method in which you specify the maximum time you are willing to wait for the
	method to complete. And if the get call is not complete by then you throw a TimeoutException which is a checked exception.
		try {
				Integer result = future.get();   //blocking call
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) { 
				System.out.println("Couldn't complete task before timeout!");
			}
			
		future.cancel(boolean mayInterruptIfRunning)
			Tell the pool that you are not interested in running the task anymore. This gives 2 possibilities.
			1. If the task has not yet started running and is still in the queue then the task is cancelled.
			2. If the task has started running in some thread then cancel will have no effect. You can only try to interrupt the thread which is
			   running your task by using the mayInterruptIfRunning flag which will try to interrupt the thread.
			   
	    future.isCancelled() - returns if the task was cancelled.
	    future.isDone() - returns if the task is completed. Note that this returns true even if the task is comleted with exceptions as pools dont
	                      re-run tasks in case of exceptions thrown while executing them.
	 
*/