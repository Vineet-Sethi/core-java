package multithreading;

/*
		priority --------> JVM(5)
		         --------> programmer (1 - 10)  //IllegalArgumentException otherwise
		         
		        priorities 1,5,10 have enums
		         
		getPriority(), setPriority(int) signatures are regular getter setter signatures except that they are final.
 */
public class ThreadPriority {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(7);
		System.out.println(Thread.currentThread().getPriority());
		
		PriorityThread t = new PriorityThread();  // thread priority is inherited at object creation time. So priority is unaffected if later
		                                          // main thread priority gets changed
		System.out.println(t.getPriority());
		
		t.setPriority(10);
		t.start();
		
		for(int i = 0; i < 10; i ++) 
		{
			System.out.println("Main Thread");
		}
	}
}

class PriorityThread extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 10; i ++) {
			System.out.println("Child Thread");
		}
	}
}