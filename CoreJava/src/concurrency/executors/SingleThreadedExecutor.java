package concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
	 The STE is exactly the same as FTP but it has a thread size of 1. This type is thread pool is needed when you want your tasks to be executed
	 sequentially ie you want task1 to be completed before task2. This is not possible with FTP as there are multiple threads executing the tasks
	 simultaneously and as such the order of tasks completion is unknown.
	 Also if while executing any task the pool thread gets killed the STE will create a new thread and ensure that there is a thread in the pool at
	 any given time.
	  
 */
public class SingleThreadedExecutor 
{
	public static void main(String[] args) 
	{
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		for(int i = 0; i < 10; i++)
		{
			executor.submit(new STETask());
		}
	}
}

class STETask implements Runnable 
{
	@Override
	public void run() 
	{
		System.out.println("Thread Name:" + Thread.currentThread().getName());
	}
}
