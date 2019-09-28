package concurrency.executors;

/*
	In Java it's always been easy to run a method or piece of code asynchronously that is if you have a main method which has a main thread, then 
	you can run your tasks in a separate thread very easily using a code similar to this.
*/
public class ThreadPoolConcept {
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Task());
		thread.start();
		
		System.out.println(Thread.currentThread().getName() + " is executing task...");
	}
	
	/*
	  To extend the above concept if you want to create and execute 10 tasks asynchronously in parallel then you can create threads in a for loop
	  pass instances of the Task class. Hence we have 10 threads, each executing a different runnable task for us.
	  
			public static void main(String[] args) 
			{
				for(int i = 0; i < 10; i++)
				{
					Thread thread = new Thread(new Task());
					thread.start();
				}
				System.out.println(Thread.currentThread().getName() + " is executing task...");
			}
			
	  Creating a thread is an expensive operation in itself as in java 1 Java Thread = 1 OS thread. Hence it is not advisable to create a large
	  number of threads like a 1000 threads. Hence we can have a fixed number of small threads created upfront say 10 threads and call it a pool.
	  We can now submit even a thousand tasks to these 10 threads. Every thread will take up a task finish it and be ready to take another task.
      So in essence 1 thread is used repeatedly and performs more number of tasks and hence the number of threads reduce.
    */
}

class Task implements Runnable
{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is executing task...");
	}
}
	
