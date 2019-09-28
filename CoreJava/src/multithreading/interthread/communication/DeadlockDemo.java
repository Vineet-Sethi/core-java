package multithreading.interthread.communication;

public class DeadlockDemo 
{
	public static void main(String[] args) 
	{
		String objA = new String("ObjectA");  
		String objB = new String("ObjectB");  
		
		ThreadA ta = new ThreadA(objA, objB);
		ThreadB tb = new ThreadB(objA, objB);
		
		ta.start();
		tb.start();
	}
}

class ThreadA extends Thread
{
	public String objA;
	public String objB;
	
	public ThreadA (String objA, String objB) 
	{
		this.objA = objA;
		this.objB = objB;
	}
	
	public void run() 
	{
		synchronized (this.objA) 
		{
			System.out.println("Thread A has locked resource objA");

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (this.objB) {
				System.out.println("Thread A has locked resource objB");
			}
		}
	}
}

class ThreadB extends Thread
{
	public String objA;
	public String objB;
	
	public ThreadB (String objA, String objB) 
	{
		this.objA = objA;
		this.objB = objB;
	}
	
	public void run() 
	{
		synchronized (this.objB) 
		{
			System.out.println("Thread B has locked resource objB");

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (this.objA) {
				System.out.println("Thread B has locked resource objA");
			}
		}
	}
}
