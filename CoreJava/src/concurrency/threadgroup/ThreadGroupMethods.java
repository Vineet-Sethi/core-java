package concurrency.threadgroup;

public class ThreadGroupMethods 
{
	public static void main(String[] args) throws InterruptedException
	{
		MyThread t0 = new MyThread();
		System.out.println(t0.getThreadGroup().getName());

		ThreadGroup pg = new ThreadGroup("ParentGroup");
		ThreadGroup cg = new ThreadGroup(pg, "ChildGroup");
		
		MyThread t1 = new MyThread(pg, "Thread1");
		MyThread t2 = new MyThread(pg, "Thread2");
		t1.start();
		t2.start();
		
		System.out.println(pg.activeCount());
		System.out.println(pg.activeGroupCount());
		pg.list();
		
		Thread.sleep(5000);
		System.out.println(pg.activeCount());
		System.out.println(pg.activeGroupCount());
		pg.list();
	}
}

class MyThread extends Thread
{
	public MyThread() 
	{
		
	}
	
	public MyThread(ThreadGroup g, String gname) 
	{
		super(g, gname);
	}
	
	public void run() 
	{
		System.out.println("ChildThread");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
