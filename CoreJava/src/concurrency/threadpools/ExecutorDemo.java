package concurrency.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
   The executor internally uses a blocking queue and in that queue it keeps storing all the tasks that you have submitted.
   Also all threads in the pool will perform the same two steps - Fetch the next task from the queue and execute it. Now since all threads 
   attempt to take the task from the queue at the same time that is concurrently, the queue should be able to handle concurrent operations. So 
   you want a queue which is thread safe and hence a third pool uses blocking queue internally. 
*/
public class ExecutorDemo {
	
	public static void main(String[] args) 
	{
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		PrintJob[] jobs = { new PrintJob("JOB 1"),
				new PrintJob("JOB 2"),
				new PrintJob("JOB 3"),
				new PrintJob("JOB 4"),
				new PrintJob("JOB 5"),
				new PrintJob("JOB 6")};
		
		for(PrintJob job: jobs)
		{
			service.submit(job);
		}
		
		service.shutdown();
		
		System.out.println(Thread.currentThread().getName() + "thread is finished");
	}
}

class PrintJob implements Runnable
{
	String name;
	
	public PrintJob(String name)
	{
		this.name = name;
	}

	@Override
	public void run() 
	{
		System.out.println(name + "... started by " + Thread.currentThread().getName());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(name + "... completed by " + Thread.currentThread().getName());
	}
}

