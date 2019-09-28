/*
     Two threads can communicate with each other with wait() and notify() method. 
     The thread which is expecting to receive an update is waiting immediately after calling the wait method.
     The thread which is responsible to update will call the update method. Then the waiting thread will get that notification and resume execution
     with updated values.
     
     	public final void wait() throws InterruptedException
     	public final native void wait(long ms) throws InterruptedException
     	public final void wait(long ms, int ns) throws InterruptedException
     	
     	public final void notify()
     	public final void notifyAll()
     
     	1. Why wait notify and notifyAll are in object class?
     		Wait notify and notifyAll are methods for inter-thread communication. Why do threads need to communicate? Well they need to communicate
     		to establish the order in which they must execute. But why do we need an order as multithreading was meant to execute multiple threads
     		simultaneously and improve performance. Although this is true but threads need to communicate when they are accessing/updating the same
            instance to avoid data inconsistency problem. Hence "the reason" for communication is because of the object the threads share and need
            to synchronize. Now if these methods were in the thread class a notifier thread would need to know "what all threads" are waiting for 
            "this particular object" in question out of the million threads that might be present in your application. The notifier would also need 
            to have the references of these threads and notify these threads probably one by one. The question is how would we provide such information 
            to the notifier threads.
            
            Hence if these methods are in the object class the notifier thread could simply call notify on this objects instance and all waiting 
            threads can get activated to execute. Hence the object becomes a "point of communication" for these threads and it makes sense for threads
            to communicate via this object as 'this object is the actual context' that binds waiting and notifying threads.
            
     	2. Why wait notify and notifyAll need to be called from synchronized context?
     		The answer lies in the fact that threads needs to communicate when they are accessing/updating the same object instance to avoid data 
     		inconsistency problem. Hence when one thread tries to read an object it acquires the lock on that object before being granted access
     		This makes sure no other updating/notifier thread is trying to modify the object while it is being read. In case the thread does not 
     		find what it is looking for it can wait() at the object by releasing the lock. Since the lock is released a notifier/updater thread
     		can enter the same lock, perform its update logic and notify the waiting thread and release the lock. Hence we see that lock is an 
     		essential tool for streamlining updation and data access between multiple threads. And hence these method must be called from 
     		synchronized context.
     		
     		A bigger problem could arise if the thread that is supposed to wait reads the un-updated value of the shared object instance, enters
     		the if statement defining the wait call, and just before it is about to call wait the control is transferred to the notifier thread. 
     		Now the notifier thread will update the object instance and call notify. Now since the first thread has still not called wait it will 
     		miss this update. Secondly it still thinks that the object instance value is an older one since it has already entered the if block and 
     		then it will call wait. So if no more notifier threads are there and the first thread has clearly missed the previous/last notification 
     		it will stay in waiting state indefinitely creating a deadlock.
     		
     		
     	3. Why does notify does not release the lock immediately?
     		This is because the notifier thread might need to perform some more activities after the notify call before actually releasing the lock.
   
     notify vs notifyAll(): If multiple threads are waiting and another calls notify then one of the waiting threads will be notified. Exactly 
     which thread will be notified can't be predicted as it depends on JVM and the remaining threads will have to wait further notifications.
     If multiple threads are waiting we can call notifyAll threads simultaneously. Although all threads have been notified still only thread will
     resume execution as it has to again get the lock before proceeding and there is only 1 lock per object.
     
     Also wait and notify work as per the object they are called upon. If there 100 waiting threads in an application and 60 of them have called
     wait() on some x object as x.wait(), then at a later stage calling x.notifyAll() will notify only these 60 waiting threads. The remaining 40
     threads will be notified only when notifyAll() is called on the object on which these 40 threads called wait() previously.
     
     Deadlock - If 2 threads are waiting for each other forever then such type of infinite waiting is called deadlock. The synchronization keyword
     is responsible for deadlock and as such we have to take care while using it. There are no resolution techniques for deadlock which means if
     a deadlock occurs our program will get stuck infinitely. Hence we have to prevent deadlock from happening in the first place.
     
     Starvation: Deadlock is infinite waiting that never ends however starvation is waiting that ends after a long time. For eg if an application 
     has 1 lac threads and all threads have priority 10 except 1 thread which has priority1 then this thread has to bear a long wait until it
     finally gets a chance to execute and hence this a starved thread.
     
     Daemon threads: Daemon threads are threads executing in the background. Eg Garbage collector Signal Dispatcher AttachListener etc. The main 
     purpose of the daemon threads is to provide support non-daemon aka normal threads. For eg if our java application becomes low on memory the 
     JVM can run GC to clear up unused objects to provide more memory for our application threads.
     
     	1. Usually daemon threads have low priority however we can increase the priority based on our requirement.
     	2. We can check daemon nature of a thread by isDaemon() method
     	3. We can set daemon nature of a thread by setDaemon() method. However this can be done only before starting the thread.
     	4. Main thread is by default non-daemon and we cannot change its daemon nature as it is already started by JVM at the beginning itself.
     	5. Threads created within main will inherit daemon nature from main. In case you need to set any thread as daemon within main you need
     	   to set it explicitly before starting. 
     	6. Daemon threads die immediately after non-daemon threads of a program complete execution irrespective of their position. Hence if you 
     	   created a child thread and have set its nature as daemon then if the main thread dies then the child thread will also die even if it is
     	   in the middle of execution.
     	   
     methods like stop(), suspend(), resume() are deprecated and not recommended to use.
     
     Green Thread Model - A multithreading model in which threads are managed without taking support of the underlying OS. Very few operating 
     systems like Sun solaris have Green thread model on them - deprecated.
     Native OS Model - A multithreading model in which threads are managed by taking support of the underlying OS. Eg windows based OS have native
     OS model on them.
*/