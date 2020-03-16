/*
	throw
		Usually when an exception occurs an exception object is automatically created and handed-over to the JVM. But java allows the programmer
		to create an exception object explicitly and hand-it over to the JVM manually by using the throw keyword. This is useful for customized
		exceptions or user defined exceptions as exceptions defined in java might not be sufficient to handle all business use cases. Hence
				 			 
	      		System.out.print(10/0); OR
	           	throw new ArithmeticException("/ by zero") will give the exact same output.
	           	
	     Syntax: throw e;    1. If e is null you will get NPE and not the exception you intended to.  
	                         2. e must be a Throwable type else you get compile time error incompatible types found xxx; required: Throwable. Also if
	                            e is a checked exception the compiler treats it as a regular checked exception being thrown and would expect you to
	                            handle it with try-catch else you will get compile time error as below. 
	                            	Unreported Exception:xxx must be caught or declared to be thrown.
	                            Unchecked ones would compile fine. Also it is recommended to use throw for unchecked user-defined exceptions.
	                         3. No statements can be written after 'throw e;' and you get a compile time error 'unreachable code' if you do so. 
	                         4. throw can be used to convert one exception type into another exception type by using it within a catch block.
	                         	 
		                         	 eg   catch(ArithmeticException e) {                //catch ArithmeticException but throw NullPointerException
		                         	 			throw new NullPointerException();
		                         		  }

     throws
     	In the case of checked exceptions the compiler forces us to handle the exception via try-catch. In case we do not comply we get compile
     	time exception as
     		Unreported Exception xxx must be caught or declared to be thrown.
     		
     		eg: Thread.sleep(1000); //Unreported Exception:java.lang.InterruptedException must be caught or declared to be thrown.
     		
     		throws <ExceptionName> //1. Expects a Throwable type else you get compile time error incompatible types found xxx; required: Throwable.
     							   //2. Can be used with methods and constructors.
     	                           //3. throws for unchecked exceptions ??? Not compu lsory

     	Hence we can delay handling the exception by using throws when defining the method. However it then becomes the responsibility of the caller 
     	method to handle the exception. But again at the caller method we can again use throws and so on and we can actually propagate the exception
     	all the way to the main method. And this way it becomes the responsibility of java's default exception handler to handle the exception. But 
     	it is recommended to handle the exception using try-catch rather than passing it around.
     	
     Exception Handling Java 1.7
     	1. try with resources : Until java 1.6 we are required to explicitly close resources that we opened as part of try in the finally block.
     	   However as of Java 1.7 we can use a different try signature and then the finally block is no longer needed. This reduces length and
     	   complexity of code.
     	   
     	   				try(BufferredReader br = new BufferredReader(new FileReader("input.txt"))){
     	   				     br = new ...    //is not allowed. try resources are final.
     	   				} 
     	   
    	   The try method accepts all Autoclosable resources. Java 1.7 introduced a new Autoclosable interface that has just 1 method - close().
    	   All I/O network and DB related resources already implement Autoclosable and a programmer just needs to be aware of those and use them.
     	   				
     	  This also makes it possible to have a try block alone without any catch/finally block as the finally block work is being taken care
     	  implicitly. Next if you need to open multiple resources as part of your try block you can do so by separating them with a ; Lastly all
     	  try resource variables are implicitly final and as such you cant reassign them within try block otherwise you will get compile time error.
     	  
      2. multi-catch blocks. Many a times in Java 1.6 we used to write same handling logic for different exceptions eg simply e.printStackTrace().
         But for every exception type we were writing seperate catch block with the same logic. In java 1.7 you can write a common catch block for
         different exception by separating them with |.
         
         	catch(ArithmeticException | NullPointerException)
         	{
         		e.printStackTrace();
         	}
         	
         	Note: The exceptions in multi catch block must not have child-parent relationship otherwise compiler will not know which exception is 
         	actually raised eg catch(ArithmeticException | Exception) and we will get compile time error as
         		CE: Alternatives in a multi-catch statement cannot be related by subclassing
         		
      Exception Examples
      	ArrayIndexOutOfBoundsException		arr[-10]  or arr[<int value more than arr length>]	
      	NullPointerException                               
      	ClassCastException                  Generics use case    
      	IllegalArgumentException            myThread.setPriority(15)        1 < Thread Priority <= 10              
      	IllegalStateException               myThread.start() called twice
      	NumberFormatException               Integer.parseInt('ten')   // string is not properly formatted
      	
      	StackOverflowError
      	NoClassDefFoundError
      	AssertionError                      Assert(x > 10)       //if assertion fails
      	ExceptionInInitializerError         Raised when exception occurs while executing static var assignments or static blocks  
*/