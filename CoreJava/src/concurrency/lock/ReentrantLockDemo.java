package concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo
{
	public static void main(String[] args) 
	{
		Display d = new Display();
		MyThread t1 = new MyThread(d, "Student1");
		MyThread t2 = new MyThread(d, "Student2");
		
		t1.start();
		t2.start();
	}
}

class Display
{
	//ReentrantLock l = new ReentrantLock();    
	
	public synchronized void wish(String name)  //Reentrant lock or synchronized will work the same
	{
		//l.lock();
		for(int i = 0; i < 5; i++)
		{
			System.out.print("Good Morning ");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(name);
		}
		//l.unlock();
	}
}

class MyThread extends Thread
{
	public Display d;
	public String name;
	
	public MyThread(Display d, String name)
	{
		this.d = d;
		this.name = name;
	}
	
	@Override
	public void run() 
	{
		d.wish(name);
	}
}