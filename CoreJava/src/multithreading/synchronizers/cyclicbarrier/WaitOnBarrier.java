package multithreading.synchronizers.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class WaitOnBarrier extends Thread {
	
	private CyclicBarrier barrier;
	private static Random random = new Random();
	
	public WaitOnBarrier(CyclicBarrier barrier)
	{
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		
		try 
		{
			int time = random.nextInt(15) + 1;
			System.out.println(Thread.currentThread().getName() + " will take " + time + " secs to complete...");
			Thread.sleep(time * 1000);
			System.out.println(Thread.currentThread().getName() + " completed its task and waiting at the barrier...");
			barrier.await();
			System.out.println(Thread.currentThread().getName() + " crossed the barrier...");
			
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
