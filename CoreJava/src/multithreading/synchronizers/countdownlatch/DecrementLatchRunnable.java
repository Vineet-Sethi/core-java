package multithreading.synchronizers.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class DecrementLatchRunnable implements Runnable{

	private CountDownLatch latch;
	
	public DecrementLatchRunnable(CountDownLatch latch)
	{
		this.latch = latch;
	}
	
	@Override
	public synchronized void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
		System.out.println(Thread.currentThread().getName() + " decrements latch. Latch Count is now " + latch.getCount());
	}
}
