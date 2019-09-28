package multithreading.pause.execution;
/*
	public static native void sleep(long ms) throws InterruptedException;
	public static native void sleep(long ms, int ns) throws InterruptedException;
	
	                              (if sleep time expires/interrupted)               Thread.sleep(1000)/Thread.sleep(1000, 100)  		 
	MyThread t = new MyThread();       		                <---------- Sleeping -----------                        
			New/Born ---------------------> Ready/Runnable  --------------------------------> Running -------------------------> Dead
						  t.start()                             If TS allocates processor                 When run() completes
*/
public class SleepMethod {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Slide Rotator loop
		for(int i = 1; i <= 10; i ++) 
		{
			System.out.println("Slide " + i);
			Thread.sleep(3000);
		}
	}
}
