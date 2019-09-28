package concurrency.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemo 
{
	public static void main(String[] args) 
	{
		MyTryThread t1 = new MyTryThread("FirstThread");
		MyTryThread t2 = new MyTryThread("SecondThread");
		
		t1.start();
		t2.start();
	}
}

class MyTryThread extends Thread
{
	public static ReentrantLock l = new ReentrantLock();
	
	public MyTryThread(String name)
	{
		super(name);
	}
	
	@Override
	public void run() 
	{
		do
		{
			try {
				if(l.tryLock(5000, TimeUnit.MILLISECONDS))
				{
					System.out.println(Thread.currentThread().getName() + "..... got lock and doing work.");
					Thread.sleep(15000);
					l.unlock();
					System.out.println(Thread.currentThread().getName() + "..... releases lock.");
					break;
				}
				else
				{
					System.out.println(Thread.currentThread().getName() + "..... unable to get lock. Will try again.");
				}
			}
			catch(Exception e) {}
		}
		while(true);
	}
}
