package concurrency.threadpools;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadScheduler {
	
	public static void main(String[] args) {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
		WorkerThread command = new WorkerThread();
		
		scheduledThreadPool.scheduleAtFixedRate(command, 0, 5, TimeUnit.SECONDS);
		//scheduledThreadPool.shutdown();
	}
}
