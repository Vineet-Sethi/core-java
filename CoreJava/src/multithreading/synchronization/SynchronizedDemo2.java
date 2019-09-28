package multithreading.synchronization;
/*
    Once a thread has acquired a lock on a synchronized method of an object even other synchronized methods of the same object are inaccessible
    to other threads.
 */
public class SynchronizedDemo2 
{
	public static void main(String[] args) 
	{
		//Display disp2 = new Display();
		Display1 disp = new Display1();
		Thread t1 = new MyThread1(disp);
		Thread t2 = new MyThread2(disp);
		
		t1.start();
		t2.start();
	}
}

class MyThread1 extends Thread 
{
	public Display1 display;
	
	public MyThread1(Display1 d) 
	{
		this.display = d;
	}
	
	@Override
	public void run() 
	{
	    display.displayN();
	}
}

class MyThread2 extends Thread 
{
	public Display1 display;
	
	public MyThread2(Display1 d) 
	{
		this.display = d;
	}
	
	@Override
	public void run() 
	{
		display.displayC();
	}
}

class Display1
{
	public synchronized void displayN() 
	{
		for(int i = 0; i <= 10; i++ )
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
	
	public synchronized void displayC() 
	{
		for(int i = 65; i < 75; i++ )
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println((char)i);
		}
	}
}
