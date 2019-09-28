package inner.classes.anonymous;

public class AnonymousInterfaceDemo
{
	public static void main(String[] args)
	{
		Runnable r = new Runnable(){
			@Override
			public void run() {
				for(int i = 0; i < 5; i++)
				{
					System.out.println("Child Thread");
				}
			}
		};
		
		Thread t = new Thread(r);
		t.start();
		
		for(int i = 0; i < 5; i++)
		{
			System.out.println("Main Thread");
		}
	}
}
/*      For A-I-C inside a method's argument combine statements 17, 18 and then substitute variable r i.e.
 		new Thread(r).start(); ==>
 		
 		new Thread(new Runnable(){
			@Override
			public void run()
			{
				for(int i = 0; i < 5; i++)
				{
					System.out.println("Child Thread");
				}
			}
		}).start();
 */
