package multithreading.pause.execution;

/*
	public static native void yield();
	                                                        		Thread.yield()
	MyThread t = new MyThread();       		                <-------------------------------                        
    		New/Born ---------------------> Ready/Runnable  --------------------------------> Running -------------------------> Dead
  							t.start()                          If TS allocates processor                 When run() completes
*/
public class YieldMethod {
	
	public static void main(String[] args) {
		
		YieldControlThread t = new YieldControlThread();
		t.start();
		
		for(int i = 0; i < 10; i ++) 
		{
			System.out.println("Main Thread");
		}
	}
}

class YieldControlThread extends Thread {
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i ++) {
			System.out.println("YieldControl Thread");
			Thread.yield();
		}
	}
}