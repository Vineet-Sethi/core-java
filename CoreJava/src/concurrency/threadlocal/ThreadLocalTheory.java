/*
	A threadlocal is an object associated with every thread and maintains value for that thread. A thread can access/edit/remove this value
	in whatever code the thread executes. A thread can only access its own threadlocal variables and not of other threads. Once a thread completes
	its execution the threadlocal variables are eligible for GC.
	
		Constructor
			ThreadLocal tl = new ThreadLocal();
		
		Methods
			Object initialValue() Object get() void set(Object newValue)  //get and set are obvious. initialValue returns null by default if not overridden
			void remove() 
*/