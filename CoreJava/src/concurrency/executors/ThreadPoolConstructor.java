/*
	To create thread pools we were calling static methods on the Executors class like
		ExecutorService executor = Executors.newFixedThreadPool(10);
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		ExecutorService executor = Executors.newCachedThreadPool();
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
		
	These static methods internally call the ThreadPoolExecutor constructor which contains different parameters depending on the type of 
	thread pool being instantiated. For eg calling
	
	Executors.newFixedThreadPool(10); internally calls
	
	public ThreadPoolExecutor(int corePoolSize,                   //Initial or base size of the pool. Pool size never goes below the corePoolSize             
							  int maxPoolSize,                    //unless you set allowCoreThreadTimeOut to true.
							  long keepAliveTime,                 //Time after which idle threads can be terminated if there no tasks             
							  TimeUnit unit,
							  BlockingQueue<Runnable> workQueue,  
							  ThreadFactory threadFactory,        //ThreadFactory to create more threads when needed
							  RejectedExecutionHandler handler)   //Callback mechanism when pool is unable to accept tasks submitted by the programmer.
		
	FTP
		corePoolSize  - constructor argument passed              
    	maxPoolSize   = corePoolSize               
		keepAliveTime - NA
		workQueue     - LinkedBlockingQueue. As threads are limited hence unlimited queue to store tasks. An ArrayBQ is limited in size while the 
		                LBQ can keep growing in size. Since Q can never become full new threads are never created.
		 				
	STE
		corePoolSize  - 1               
    	maxPoolSize   = 1               
		keepAliveTime - NA
		workQueue     - LinkedBlockingQueue. As threads are limited hence unlimited queue to store tasks. Since Q can never become full new threads
		 				are never created.
		 				
	CTP
		corePoolSize  - 0              
    	maxPoolSize   = Integer.MAX_VALUE               
		keepAliveTime - 60 secs
		workQueue     - SynchrousQueue. Threads are unlimited hence no need to store tasks. An SQ stores just 1 task.
    
    ScTP
		corePoolSize  - constructor argument passed               
    	maxPoolSize   = Integer.MAX_VALUE               
		keepAliveTime - 60 secs
		workQueue     - DelayedWorkQueue. Special queue that deals with schedules/time delays.
		
	RejectedExecutionHandler
		Lets say we have a thread pool with a bounded queue type like an ArrayBlockingQueue. Lets also assume that the array size is 100 and there
		are 10 threads in the pool. Consider a situation where all your 10 threads are busy executing 10 tasks and your queue is also full with
		100 tasks. So in total we have 110 tasks and now if a useer submits another task the pool has no choice but to reject it. Now the way the
		pool rejects a task is determined by certain Rejection Policies as below
			abort 				- pool throws a RejectedExecutionException(Runtime Exception)
			discard				- pool rejects the task silently i.e no notification is given to the user.
			discardOldestPolicy - accept the latest task and delete the oldest task in the queue. silently ??
			callerRunsPolicy    - return back the task to the caller ie the main thread wherein the main thread will have no choice but to execute
			                      the task. This is kind of a feedback mechanism that will slow down the main thread as it has to execute the task

    You can catch the RejectedExecutionException by wrapping the execute call in a try-catch
    	try{
    		service.execute(new Task());
    	}
    	catch(RejectedExecutionException e){
    		System.err.println("task rejected " + e.getMessage());
    	}
    	
    You can also pass a custom rejection handler to the ThreadPoolExecutor as
    	ThreadPoolExecutor(corePoolSize: 20,                                
						   maxPoolSize: 100,                   
						   keepAliveTime: 120,                          
						   TimeUnit.SECONDS,
						   new ArrayBlockingQueue<> (capacity: 300)
						   new CustomRejectionHandler());
						   
	So when your pool rejects a task it will call the rejectedExecutionHandler method of your CustomRejectionHandler as below
	
		private static class CustomRejectionHandler implements RejectedExecutionHandler
		{
			@override
			public void rejectedExecutionHandler(Runnable r, ThreadPoolExecutor executor)
			{
				//logging / operations to perform on rejection	
			}
		}
		
	Lifecycle Methods
		service.shutdown(); 
			It only initiates the shutdown and does not shutdown the pool immediately. This is because there might be pending tasks present in 
			the queue or tasks currently under execution by the pool threads. However once shutdown is called no further tasks will be accepted 
			and an attempt to call service.execute(new Task()) will throw RejectedExecutionException.
							 
			You can check if the shutdown is 'initiated' by calling the isShutdown() method or if the shutdown is 'complete' by calling 
			.isTerminated() method.
							 
		service.awaitTermination(10, TimeUnit.SECONDS);
			It blocks until all submitted tasks are executed ie tasks under execution + tasks in queue OR until the timeout specified.
		 												 
		List<Runnable> runnables = service.shutdownNow();
			It also initiates shutdown like service.shutdown() however it only waits until tasks under execution by pool threads are completed.
			The tasks in queue are returned as a list of Runnable and you can log them or do whatever as per the requirement.
		 
*/
