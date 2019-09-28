/*
	Data inconsistency problem
		In a multi-threaded environment there is always a chance of data inconsistency problem. For eg in case of bank account transactions if
		2 people who have access to the same bank account and are trying to withdraw money at the same time, the bank application will function
		properly if after one person has withdrawn the money and the balance is updated, only then the second transaction can be initiated. In
		case both transactions happen simultaneously without synchronization both threads will read the same balance value and will proceed for
		deduction post withdrawal. Hence after both threads have completed the transaction we can't predict the output as it will depend which
		thread completed at last.
		
		We can solve the above problem by using the synchronized keyword. It is a keyword used with methods and blocks and not with classes or
		variables. With synchronized keyword threads will access methods or code blocks one by one and this will solve the data inconsistency
		problem. However when one thread is accessing a block/method other threads are waiting hence synchronized keyword reduces performance.
		Therefore if there is no specific requirement then it is not recommended to use synchronized keyword.
		
		Internally synchronization is implemented by using locks. Every object in java has a unique lock and to gain access to a synchronized 
		section a thread has to acquire the lock. Once the lock is acquired it can execute the method and then release it on completing execution.
		During this time all other threads need to wait till a thread is holding the lock. Acquiring and releasing of lock is taken care by the
		JVM and the programmer is not responsible for it. 
		
		Please note that once a thread has acquired a lock on any synchronized method of an object even other synchronized methods of the same 
		object are inaccessible to other threads. This is important to preserve object state. However other non-synchronized methods are still
		accessible and threads can access them. Hence based on this we can divide an object containing 2 areas - one synchronized area and the 
		other non-synchronized area. A class designer must write update/edit/delete etc operations in synchronized section to preserve object 
		state while reading operations can be coded in non-synchronized areas. Thus although java provides synchronization to avoid data inconsistency
		problem it is upto the programmer to use it judiciously to actually solve the inconsistency problem.
		
				Eg Reservation System - Seat availability read operations in non synchronized area
				                        Seat booking write operations in synchronized area
    
		Similar to lock of objects we have class level locks in java. There is only 1 class level lock for the class as compared to one lock per
		object for object locks. If a thread wants to execute a static synchronized method it needs to acquire a class level lock. After the lock
		is acquired the thread can execute the method and the lock will be released when the execution completes. When one thread is executing a
		static synchronized all other static synchronized methods are locked for other threads. All this is very similar to object locking. However 
		objects locks and class level locks are quite independent. This means that if all static methods are locked owing to one thread executing
		a static synchronized method, other threads can though access synchronized "instance" methods or "normal" instance methods.
		
		Note: Lock concept applicable for object types and class types but not for primitives.
		      
		Synchronized block
			If very few lines of the code require synchronization it is not advisable to lock entire method. Instead we can lock the block of code
			requiring synchronization using synchronized keyword. This improves performance as threads can enter the method and execute all code
			upto the synchronized block before waiting.
			
			synchronized(this) { ... } - to obtain lock of current object
			synchronized(objRef) { ... } - to obtain lock of another object
			synchronized(Display.class) { ... } - to obtain class level lock - static synchronization
		
		A single thread can acquire multiple locks but of course from different objects as there is only 1 lock per object.
			class X 
			{
			     public synchronized void m1()
			     {    // here thread has lock of object X
			          Y y = new Y();
			          synchronized(y)
			          {    // here thread has lock of object X, Y
			                Z z = new Z();
					        synchronized(z)
					        {    // here thread has lock of object X, Y & Z
					              
					        }
			          }
			     }
			}
*/