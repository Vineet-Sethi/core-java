package multithreading.interthread.communication;

public class DaemonThreadsDemo
{
	public static void main(String[] args)
	{
		System.out.println(Thread.currentThread().isDaemon());
		//  Thread.currentThread().setDaemon(true);             //throws IllegalThreadStateException
		
		MyThread2 t = new MyThread2();
		System.out.println(t.isDaemon());
		t.setDaemon(true);  
		System.out.println(t.isDaemon());
		t.start();
		
		System.out.println("end of main method");
	}
}

class MyThread2 extends Thread 
{
	@Override
	public void run() {
		for(int i = 0; i < 10; i++)
		{
			System.out.println("Child Thread");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
