package concurrency.threadpools;

import java.util.Date;

public class WorkerThread implements Runnable {
	
	public void run() {
		System.out.println(new Date() + " Executing task");
	}
}
