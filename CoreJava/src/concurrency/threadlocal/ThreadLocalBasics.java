package concurrency.threadlocal;

public class ThreadLocalBasics 
{
	public static void main(String[] args) 
	{
		ThreadLocal tl = new ThreadLocal() 
		{
			public Object initialValue()
			{
				return "abc";
			}
		};
		
		System.out.println(tl.get());  // returns abc. Would have returned null if initialValue wasn't overridden
		tl.set("test");
		System.out.println(tl.get());
		tl.remove();
		System.out.println(tl.get());  // abc
		
	}
}
