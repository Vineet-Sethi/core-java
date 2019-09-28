package concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
	CachedThreadPool
	
	In a FTP we have fixed no of threads say 10 and a BlockingQueue internally to hold your runnable tasks. Now each thread in your pool will
	fetch task from this queue and execute it. 
	
	The cached thread pool however is quite opposite. There is NO BQ to hold your tasks and you don't specify the number of threads either. The CTP
	has something called as a synchronous queue that holds exactly 1 task at a time. It then searches if any thread is already there in the pool
	and free to take up this task. If present the thread is allocated the current task, if not it creates a new thread and adds it to the pool. So 
	if you have a lot of tasks the pool will create multiple threads and allocate tasks to them. And once threads start becoming free further incoming
	tasks will be given to already created threads. This way no of threads are optimized. If no more incoming tasks are there and if free threads
	are idle for more than 60 seconds the pool starts terminating those threads and your pool size starts decreasing. Hence your pool size increases
	in the beginning and shrinks towards the end.
	
		ExecutorService executor = Executors.newCachedThreadPool();   //The CTP is useful when you have a large number of short-lived tasks.

*/
public class CachedThreadPool {
	public static void main(String[] args) 
	{
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i = 0; i < 100; i++)
		{
			executor.submit(new CTPTask());
		}
		
		executor.shutdown();
	}
}

class CTPTask implements Runnable
{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is executing task...");
	}
}
