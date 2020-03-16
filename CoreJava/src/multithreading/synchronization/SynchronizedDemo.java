package multithreading.synchronization;

/*
    Note: synchronized keyword works if multiple threads are operating on the same object instance. This is because every object has its own
    copy of the class variables and it makes sense to preserve the state of that object in a multi-threaded scenario and avoid the data inconsistency
    issue.
    
    Hence in the below program if we pass 2 different instances to the 2 threads we will get mixed output as threads will run simultaneously and
    not one by one. This is because thread  t1 will acquire lock of object1 and executes its wish method while thread t2 will simultaneously acquire 
    lock of object2 and executes object2's wish method.
 */
public class SynchronizedDemo 
{
	public static void main(String[] args) 
	{
		Display disp2 = new Display();
		Display disp = new Display();
		Thread t1 = new MyThread(disp ,"StudentA");
		Thread t2 = new MyThread(disp2 ,"StudentB");
		
		t1.start();
		t2.start();
	}
}

class MyThread extends Thread 
{
	public Display display;
	public String name;
	
	public MyThread(Display d, String name) 
	{
		this.display = d;
		this.name = name;
	}
	
	@Override
	public void run() 
	{
	    display.wish(name);
	}
}

class Display
{
	public synchronized void wish(String name) 
	{
		for(int i = 0; i < 5; i++) 
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Welcome to multithreading " + name);
		}
	}
}
