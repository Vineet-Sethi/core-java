package multithreading.pause.execution;
/*
 	A thread can interrupt another sleeping thread. However:
 		If the other thread is not sleeping then the interrupt call will wait until the other thread enters into sleeping state and interrupt it 
 		as soon as it enters sleep.
 		If the other thread never enters the sleeping state then the interrupt call will get wasted and this is the only case when interrupt call 
 		is wasted.
 	
*/
public class InterruptThreadDemo2 {
	public static void main(String[] args) 
	{
		InterruptedSleepingThread t = new InterruptedSleepingThread();
		t.start();

		t.interrupt();
		
		System.out.println("End of main thread");
	}
}

class InterruptedSleepingThread extends Thread
{
	@Override
	public void run() {
		
		for(int i = 0; i < 1000; i ++) 
		{
			System.out.println("I am not sleeping");
		}
		
		System.out.println("I am now entering sleeping state");
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			System.out.println("And I got interrupted");
		}
	}
}