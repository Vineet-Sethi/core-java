package multithreading.synchronizers.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	public static void main(String[] args) {

		Semaphore sem = new Semaphore(3);
		Connection conn = new Connection();

		for (int i = 0; i < 5; i++) {
			ManageConnections connections = new ManageConnections(sem, conn);
			connections.start();
		}
	}
}
