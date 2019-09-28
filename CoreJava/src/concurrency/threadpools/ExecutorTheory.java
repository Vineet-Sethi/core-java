/*
     Executor Framework(1.5)
     Creating a new thread everytime is tedious, hence we can create a thread pool upfront so that threads are available and ready to our job
     whenever the need arises. Thread pool framework is also known as executor framework.
     
     Callables & Futures
     	In the case of runnable jobs the thread wont return anything after the job is completed. In case a thread is required to return some 
     	result after execution we can use Callables. Callable has the method
     			public Object call() throws Exception
     			
     	Hence a user can implement a callable and return any type he wants to as it returns an Object. The executor returns an object of type 
     	Future which actually wraps the result returned by the callable.  
     	
     	Note: If run method throws any exception we are forced to handle it then and  there itself using try-catch. We cannot use throws clause
     	with run as the run signature in Runnable interface doesn't throw any exception.
*/
