package multithreading.synchronizers.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo 
{
	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(3);
		for(int i = 0; i < 3; i++)
		{
			WaitOnLatch waitThread = new WaitOnLatch(latch);
			waitThread.start();
		}
		
		DecrementLatchRunnable decrementRunnable = new DecrementLatchRunnable(latch);
		
		for(int i = 0; i < 3; i++)
		{
			Thread myThread = new Thread(decrementRunnable);
			myThread.start();
		}
	}
}
