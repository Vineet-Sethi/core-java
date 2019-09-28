package multithreading.synchronizers.semaphore;

public class Connection {
	
	private int dbConnection = 0;
	
	public synchronized void createConnection() {
		dbConnection++;
		/*
		   Create connection code  
		 */
		System.out.println(Thread.currentThread().getName() + " created connection " + dbConnection);
	}
	
	public synchronized void releaseConnection() {
		dbConnection--;
		/*
		   Release connection code  
		 */
		System.out.println(Thread.currentThread().getName() + " released connection. ");
	}

}
