package multithreading.synchronizers.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;

public class WaitOnPhaser extends Thread {
	
	private Phaser phaser;
	private static Random random = new Random();
	
	public WaitOnPhaser(Phaser phaser)
	{
		this.phaser = phaser;
	}
	
	@Override
	public void run() {
		
		try 
		{
			int time = random.nextInt(10) + 1;
			System.out.println(Thread.currentThread().getName() + " will take " + time + " secs to initialize...");
			Thread.sleep(time * 1000);
			System.out.println(Thread.currentThread().getName() + " initialized.. Waiting for others to complete...");
			phaser.arriveAndAwaitAdvance();
			System.out.println(Thread.currentThread().getName() + " Started...");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
