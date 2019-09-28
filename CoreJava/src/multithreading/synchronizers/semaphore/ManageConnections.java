package multithreading.synchronizers.semaphore;

import java.util.concurrent.Semaphore;

public class ManageConnections extends Thread {
	
	private Semaphore semaphore;
	private Connection connection;
	
	public ManageConnections(Semaphore semaphore, Connection connection)
	{
		this.semaphore = semaphore;
		this.connection = connection;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " waiting for connection...");
			Thread.sleep(5000);
			
			semaphore.acquire();
			connection.createConnection();
		    Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		finally {
			connection.releaseConnection();
			semaphore.release();
		}
	}
}
