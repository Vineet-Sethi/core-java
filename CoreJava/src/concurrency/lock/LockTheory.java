/*
	Problems with traditional synchronization - synchronized keyword
		No flexibility to try for a lock without waiting
		No way to specify the maximum waiting time for a thread to acquire a lock
		No API to list down waiting threads for a lock.
		After a thread releases a lock we have no control on which waiting thread will get the lock
		
	Lock interface: Similar to synchronized keyword + extra implementations
		Methods
			void lock(): Exactly same behaviour as synchronized keyword - Acquire lock immediately if available else wait until receiving
			boolean trylock(): Better than synchronized - Acquire lock immediately if available and return true else move ahead without waiting
			                   at all. boolean tryLock(long time, TimeUnit unit) does the same but it waits for the specified time before moving
			                   ahead in case lock is not available
		    lockInterruptibly(): Acquires lock immediately if available and waits if not. While waiting if the thread gets interrupted then the
		                         thread wont get the lock.
		    void unlock(): To release the acquired lock. To call this method the thread must be the owner of the lock otherwise we will get
		                   IllegalMonitorStateException.
		                   
     Reentrant Lock
     	Implementation class of Lock. A thread can acquire the same lock multiple times without any issue. Internally reentrant lock increments
     	thread's personal lock count whenever the thread calls the lock() method and decrements this count whenever unlock() is called by the
     	same thread. And the lock will be released when the count reaches 0.
     	
     	 Constructors
     	 	ReentrantLock l = new ReentrantLock();
     	 	ReentrantLock l = new ReentrantLock(boolean fairness);  //fairness defines if FCFS policy is applied or not. If true then the
     	 	                                                        //waiting thread will get access(First Come First Serve). false by default.
         
         Methods: In addition to lock interface methods Reentrant Lock has
         	// true if any thread holds this lock and false otherwise
         	boolean isLocked() boolean isHeldByCurrentThread() Thread getOwner()  
         	int getHoldCount() boolean isFair()
         	boolean hasQueuedThreads() int getQueueLength() Collection getQueuedThreads()
*/