package concurrency.threadgroup;

/*
      system <-------- main <--------- FirstGroup <--------- SecondGroup
 */
public class ThreadGroupBasics 
{
	public static void main(String[] args) 
	{
		System.out.println(Thread.currentThread().getThreadGroup().getName());             //main
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getName()); //system
		
		ThreadGroup g1 = new ThreadGroup("FirstGroup");
		ThreadGroup g2 = new ThreadGroup(g1, "SecondGroup");
		
		System.out.println(g1.getName());
		System.out.println(g2.getName());
		System.out.println(g1.getParent().getName());     
		System.out.println(g2.getParent().getName());  
		
		/*----------------------------------------*/
		
		ThreadGroup tg = new ThreadGroup("tg");
		Thread t1 = new Thread(tg, "Thread1");
		Thread t2 = new Thread(tg, "Thread2");
		
		tg.setMaxPriority(3);
		Thread t3 = new Thread(tg, "Thread3"); 
		
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		System.out.println(t3.getPriority());
	}

}
