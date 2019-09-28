package concurrency.threadgroup;

public class SystemGroupThreads 
{
	public static void main(String[] args) 
	{
		ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
		Thread[] ta = new Thread[system.activeCount()];
		system.enumerate(ta);
		
		for(Thread t: ta)
			System.out.println("Thread " +  t.getName() + " isDaemon " + t.isDaemon());
	}
}
