package multithreading;

public class ExtendsThreadDemo {
	public static void main(String[] args)
	{
		MyThread t = new MyThread();  // Just a new thread object is created & not an actual thread
		
		t.start();                    // creates new thread, registers it with TS, invokes its run method
		                              // calling t.start() multiple times will throw IllegalThreadStateException 
		                              // calling t.run() directly won't create new thread, t.start() does.
		 							  // TS is unpredictable		
		
		for(int i = 0; i < 10; i ++) 
		{
			System.out.println("Main Thread");
		}
	}
}

class MyThread extends Thread {
	
	@Override
	public void run()           // empty implementation in Thread class, hence must override run. Otherwise what's the point
	{                           // run can be overloaded but t.start() will always call no-arg run
		for(int i = 0; i < 10; i ++) {
			System.out.println("Child Thread");
		}
	}
	
	/*@Override
	public void start()     // overloading start will make it useless but calling super.start() is possible and will restore all functions     
	{        
	     super.start()
	}*/
}
