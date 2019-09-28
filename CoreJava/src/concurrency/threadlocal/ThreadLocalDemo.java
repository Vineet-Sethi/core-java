package concurrency.threadlocal;

/*
     Whenever you create a thread
*/
class CustomerThread extends Thread
{
	static Integer custId = 0;
	private ThreadLocal tl;
	
	public CustomerThread(String name)
	{
		super(name);
		tl = new ThreadLocal() 
		{
			public Object initialValue() {
				return ++custId;
			}
		};
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " executing with customer id " + tl.get());
	}
}

public class ThreadLocalDemo 
{
	public static void main(String[] args) 
	{
		CustomerThread c1 = new CustomerThread("CustomerThread-1");
		CustomerThread c2 = new CustomerThread("CustomerThread-2");
		CustomerThread c3 = new CustomerThread("CustomerThread-3");
		CustomerThread c4 = new CustomerThread("CustomerThread-4");
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
	}
}
