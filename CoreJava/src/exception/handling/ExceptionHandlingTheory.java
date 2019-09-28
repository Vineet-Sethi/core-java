/*
	Throwable class acts as the root for java exception hierarchy.
	
	Exception: Any unwanted/unexpected event that disturbs the normal flow of execution of a program is called as exception. 
	
			   For eg. if our programming requirement is to read data from a file at a remote server and at runtime the remote file is not found
			   then we get a FileNotFoundException. Similarly while reading data from a DB we might get an SQL exception.
	           
	Exception Handling: It is highly recommended to handle the exception and exception handling does not mean to repair the exception. 
			   The main objectives of exception handling are
			   1. Provide an alternative way so that the program continues executing: Hence if remote file is not found use local file for the
			      time being and log some message to the user informing about it.
			   2. Graceful termination of program: While reading data from a DB if SQL exception occurs it would be good to close all opened DB
			      connections before terminating the program.
	
	Stack: Every thread in java has its own stack. Local variables, object references and method calls pertaining to a thread are stored on the
	       stack. Each entry in the stack is called as a stack frame or activation record. So whenever a thread calls a method an entry is 
	       pushed at the top of the stack. And whenever the method returns the entry is removed. So if we have 3 nested functions where-in f1 
	       calls f2 which in turn calls f3 then we would have f3 on top of the stack followed by f2 and then f1. After all method calls complete
	       the stack will be empty. This is the normal functioning of the stack ie wihout any exception.
	       
	       In case a method throws an exception it is its responsibility to create an exception object with the following info and hand it over
	       to the JVM. The info is
	       		Name of the exception
	       		Description of the exception
	       		Location at which it occured:  Stack trace.
	       		
	       Next the JVM will check if the method which created the exception object contains any exception handling code. If it does then the 
	       handling code will be executed. If it doesn't then that method is terminated abnormally, the corresponding stack entry is removed by
	       the JVM which then identifies the caller of the method. If the caller method also does not contain any exception handling code then
	       even the caller is terminated abnormally with the  corresponding stack entry removed. 
	       
	       This process continues until the main method is reached and if the main method also doesn't handle the exception then the main method 
	       is also terminated abnormally, stack entries removed and the JVM now hand-overs the responsibility of exception handling to the default 
	       Exception Handler which is a part of the JVM.
	       
	       The Default Exception Handler prints the following into to the console and terminates the program abnormally. 
	       
	       			Exception in Thread XXX Name of Exception: Description
	       					Stack Trace
	       					
	 Exception vs Error:
	 	Exception: These unwanted/unexpected conditions occur within the program and most of the times these are recoverable and thats why we 
	 	have the concept of exception handling. For eg if our programming requirement is to read data from a file at a remote server and runtime
	    the remote file is not found we can use use local file for the time being.
	    
	    Error: These are conditions outside the purview of our program and caused by lack of system resources. Errors are irrecoverable Eg if
	    an OutOfMemory occurs being a programmer all we can do is ask the system admin to allocate sufficient memory for our program to run.
	 	
	 Checked vs Unchecked Exception
	    The name checked exception comes from the way exceptions are actually handled in java. In certain situations like trying to read a file
	    from the system the compiler sees a possibility of exception to be thrown and forces the programmer to write exception handling mechanism.
	    Hence all such exceptions are checked exceptions. Eg FileNotFoundException, InterruptedException etc.
	    
	    Unchecked exception are usually hard to catch during coding/compile where even the programmer could not foresee that 
	    the exception could have been thrown there. Eg NullPointerException, Arithmetic Exception.
	    
	    Whether it is checked or unchecked all exceptions occur at runtime only and there is no chance of any exception occurring at compile-time.
	    
     Fully Checked vs Partially Checked
	    An exception is said to be fully checked if and only if all its child classes and the exception itself is checked. Even if one of its
	    child exception class is unchecked then the exception is a partially checked exception. 
	    
	 Hierarchy Diagram: Refer pdf.
	    RuntimeException and its child classes AND Error and its classes are unchecked and all others are checked exceptions
	 
	 Customized Exception Handling
		 We can use try-catch block to handle exception. Not using them would them would result in abnormal termination of our program. When we
		 use a try-catch then
			 1. If an exception is thrown within the try block the control jumps immediately to the "matching catch block". Hence a try block can 
			    have multiple catch blocks and depending upon the type of exception thrown the corresponding catch block will be executed.
			    Also as handling exceptions varies from exception to exception it is therefore recommended to use multiple catch blocks. Only using
			    a single catch block catching all exceptions as with catch(Exception e){ } is a bad programming practice.
			 2. The statements after the line of code where exception occurred are not executed. Hence length of try block should be as less as possible
			 3. If the catch block does not match the type of exception being thrown - abnormal termination
			 4. If an exception is raised within "catch" block or any statement after try catch - abnormal termination.
			 5. If no exception is thrown then catch block is not executed.
			 6. Within a try-catch block if there is no chance of throwing a particular exception and still if we write a corresponding catch block
			    then we get a compile time error as 
			        Exception xxx is never thrown in the body of the corresponding try block. 
			    ***** This rule is only applicable to fully checked exceptions
	     
	     Note: When we use multiple catch blocks then first we should catch more specific exception followed by generic one otherwise we get an 
	           exception saying 
	            	Exception XXX has already been caught.
	           We get the same exception if we write 2 catch blocks for the same exception.
	           
	 Throwable class defines defines 3 methods
	 	1. e.getMessage()      - prints exception description
	 	2. e.toString()        - prints name of exception: exception description
	 	3. e.printStackTrace() - prints name of exception: exception description & stack trace
	 	
	 final : keyword used with class, method or variable.
	 finally{} : Always used with try-catch to perform clean up activities like closing the resources opened within try. It is always executed 
	          whether exception was raised or not or if the raised exceptions were handled or not as the intention is performing clean up for 
	          try resources.
	 finalize(): It is a method used to perform clean up activities related to object just before it is being garbage collected by the GC. 
	 
	 Combinations
	     1. try{}catch{}finally{} - Note: Parentheses are needed even for single t-c-f statements.
	     2. try{}finally{}
	     3. try{}catch{ try{}catch{} } - Nested t-c is ok
*/