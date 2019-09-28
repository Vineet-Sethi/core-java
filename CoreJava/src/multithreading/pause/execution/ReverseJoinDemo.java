package multithreading.pause.execution;

public class ReverseJoinDemo 
{
     public static void main(String[] args) throws InterruptedException {
		
    	 ReverseJoinThread.mt = Thread.currentThread();
    	 
    	 ReverseJoinThread t = new ReverseJoinThread();
    	 t.start();
    	 
    	 for(int i = 0; i < 10; i ++) {
 			System.out.println("Main Thread");
 			Thread.sleep(1000);
 		}
	}
}

class ReverseJoinThread extends Thread 
{
	public static Thread mt;
	
	@Override
	public void run() {
		
		try {
			mt.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < 10; i ++) {
			System.out.println("Child Thread");
		}
	}
}
