package multithreading.pause.execution;
/*
 	public void interrupt();
 	
 	A thread can interrupt "another sleeping thread" by calling the interrupt method on the other threads reference variable.
*/
public class InterruptThreadDemo {
	public static void main(String[] args) 
	{
		InterruptedThread t = new InterruptedThread();
		t.start();

		t.interrupt();
		
		System.out.println("End of main thread");
	}
}

class InterruptedThread extends Thread
{
	@Override
	public void run() {
		
		for(int i = 0; i < 10; i ++) 
		{
			System.out.println("I am lazy thread " + i);
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
				System.out.println("I got interrupted");
			}
		}
	}
}