package concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		for(int i = 0; i < 50; i++)
		{
			executor.submit(new FTPTask());
		}
		
		executor.shutdown();
	}
}

class FTPTask implements Runnable {

	@Override
	public void run() 
	{
		System.out.println("Thread Name:" + Thread.currentThread().getName());
	}
}

/*
	Ideal Pool Size - Depends on the type of tasks
	
	Now it might seem like to execute a thousand tasks in parallel we can create a pool of thousand threads. However if your tasks are CPU 
	intensive like complex algos or kryptographic functions they will require a lot of CPU time. And if your CPU has lets say 4 cores which is the
	case usually then it can run max 4 threads at a time. Hence having too many threads will not make a difference as the CPU will schedule threads
	in a time-splitting fashion ie it will allocate some time to 1 thread, bump it off even if its not finished and then allocate CPU to another.
	Hence if tasks are CPU intensive the ideal pool size is the no of cores in your CPU. This can be known by
	
	 	int coreCount = Runtime.getRuntime.availableProcessors();  
	 	//Note: If your CPU is running other applications then your java app might not get all the cores in your CPU. hence availableProcessors
	 	//might not be 4 everytime.
	 	
	Next if your tasks are I/O intensive ie your task is requesting data from a DB or calling an http URL then after these calls are made the 
	threads will wait for the OS to get a response. Since threads move to waiting state hence you can have more number of threads in the pool 
	than your CPU core count. The exact number will depend on the rate of task submission and average task wait time. Too many threads will
	increase memory consumption too.
	 
*/
