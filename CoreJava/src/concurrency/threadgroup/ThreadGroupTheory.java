/*
     ThreadGroup: We can group threads in our application into a single unit which is called as thread group. In fact every thread in java belongs
     to some group anyways including even the main thread. The main advantage of thread grouping is that we can perform common operations quite 
     easily for eg we can set a low priority for all our printing threads or assign high priority to all Producer/Consumer threads.
     
     We have the System thread group which acts as the root for all other thread groups. Every thread group is a child of the System thread 
     group either directly or indirectly. The System thread has threads like; Finalizer, Signal Dispatcher, AttachListener, ReferenceHandler. 
     The Main thread group contains the main thread. Whenever we create threads inside main without assigning them to any group they belong to main
     group.
     
     									   java.lang
                Object <----------------- ThreadGroup
     
     Constructors
     	ThreadGroup g = new ThreadGroup(String name);                            //Parent of this group is the parent of currently executing thread
     	ThreadGroup g = new ThreadGroup(ThreadGroup parentGroup String name);    //Parent of this group is the one specified in constructor.
     	
     Methods
        String getName() ThreadGroup getParent()
     	int getMaxPriority() void setMaxPriority()
     	boolean isDaemon() void setDaemon()
     	list()
     	int activeCount() activeGroupCount()
     	int enumerate(Thread[] t) int enumerate(ThreadGroup[] t)
     	void interrupt() void destroy()
*/
