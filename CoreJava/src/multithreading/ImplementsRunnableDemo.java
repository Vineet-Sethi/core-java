package multithreading;
/*
					<----------------------------------------- MyRunnable
		Runnable(I) <----------- Thread(C) <------------------ MyThread
          run();                  run() { } //empty Impl
          		            	  start(){  //calls run()
          		            	     ...
          		            	     ...
          		            	  }
*/
public class ImplementsRunnableDemo {
	
	public static void main(String[] args) {
		
		MyRunnable r = new MyRunnable();
		
		Thread t = new Thread(r);
		t.start();
		
		for(int i = 0; i < 10; i ++) 
		{
			System.out.println("Main Thread");
		}
	}
}

class MyRunnable implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 10; i ++) {
			System.out.println("Child Thread");
		}
	}
	
}
