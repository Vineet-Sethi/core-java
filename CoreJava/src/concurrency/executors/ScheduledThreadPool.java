package concurrency.executors;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
	ScheduledThreadPool
	
	The STP is used to schedule tasks. For this it has a delay queue. So if you submit multiple tasks to the STP with varying delays the tasks will
	be stored in the increasing order of delays assigned to them. So for example if one task is scheduled to run after 10 seconds while another one
	is scheduled to run after 2 minutes the first task with 10 secs delay will be stored at the top. 
	Also you can schedule tasks at a fixed rate say 30 secs in which case tasks will run every 30 secs.
	We can also schedule task to run after a fixed delay in which case it will wait for a specified time after the previous instance has finished.
	
	 	ExecutorService executor = Executors.newScheduledThreadPool(10);
 	
*/
public class ScheduledThreadPool
{
	public static void main(String[] args) 
	{
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
		
		System.out.println(new Date());  
		//executor.schedule(new STPTask("Simple schedule 5"), 5, TimeUnit.SECONDS);
		
		//executor.scheduleAtFixedRate(new STPTask("----> Rate 3"), 0, 3, TimeUnit.SECONDS);
		//executor.scheduleAtFixedRate(new STPTask("====> Rate 5"), 0, 5, TimeUnit.SECONDS);
		
		executor.scheduleWithFixedDelay(new STPTask("----> First Delay 2"), 0, 2, TimeUnit.SECONDS);
		executor.scheduleWithFixedDelay(new STPTask("====> Second Delay 5"), 0, 5, TimeUnit.SECONDS);
		
		//executor.shutdown();
	}
}

class STPTask implements Runnable 
{
	private String taskName;
	
	public STPTask(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public void run() 
	{
		System.out.println(new Date() + " Task " + taskName + " " + Thread.currentThread().getName());
	}
}
