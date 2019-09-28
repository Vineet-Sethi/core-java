package multithreading.interthread.communication;
           
/*
 	                                                                   		If waiting thread got notified
 	                                                                   				If time expired
 	                                                                   				If interrupted
 		                       		If waiting thread got lock                                              obj.wait()/wait(1000)/wait(1000,100)
	MyThread t = new MyThread();       		             <------- Waiting to get lock <-------- Waiting <---------                     
			New/Born -------------------> Ready/Runnable ---------------------------------------------------------> Running -------------------------> Dead
						  t.start()                             If TS allocates processor                 When run() completes
 	
 	
*/


public class WaitNotifyDemo 
{
	public static void main(String[] args) throws InterruptedException
	{
		Calculate calc = new Calculate();
		MyThread notifier = new MyThread(calc);
		notifier.start();
		
		synchronized(calc)
		{
			System.out.println("Main thread waiting for calculation to complete");
			if(calc.getTotal() == 0)
				calc.wait();
			
			System.out.println("Main thread notified");
			System.out.println(calc.getTotal());
		}
	}
}

class Calculate
{
	private int total = 0; 
	
	public void calculate() 
	{
		for(int i = 1; i < 100; i++) 
		{
			total = total + i;
		}
	}
	
	public int getTotal() 
	{
		return total;
	}
}

class MyThread extends Thread 
{
	private Calculate calc; 
	
	public MyThread(Calculate calc)
	{
		this.calc = calc;
	}
	
	@Override
	public void run() 
	{
		synchronized(calc) 
		{
			System.out.println("Child thread starts calculation");
			calc.calculate();
			System.out.println("Child thread notifying");
			calc.notify();
		}
	}
}
