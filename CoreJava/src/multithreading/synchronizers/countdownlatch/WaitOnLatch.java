package multithreading.synchronizers.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class WaitOnLatch extends Thread {
	
	private CountDownLatch latch;
	
	public WaitOnLatch(CountDownLatch latch)
	{
		this.latch = latch;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " waiting on latch...");
		try {
			latch.await();
			System.out.println("Wait for " + Thread.currentThread().getName() + " is over!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
