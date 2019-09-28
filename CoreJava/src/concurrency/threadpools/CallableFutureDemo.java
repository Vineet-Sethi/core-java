package concurrency.threadpools;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureDemo 
{
	public static void main(String[] args) throws Exception
	{
		CalculateSum[] jobs = { new CalculateSum(10),
							    new CalculateSum(20),
							    new CalculateSum(30),
							    new CalculateSum(40),
							    new CalculateSum(50),
							    new CalculateSum(60)
							  };	
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(CalculateSum job : jobs)
		{
			Future f = executor.submit(job);
			System.out.println(f.get());
		}
		
		executor.shutdown();
	}
}

class CalculateSum implements Callable
{
	int num;
	
	public CalculateSum(int num)
	{
		this.num = num;
	}
	
	@Override
	public Object call() throws Exception 
	{
		System.out.print(Thread.currentThread().getName() + " is responsible to find sum of first " + num + " numbers: ");
		
		int sum = 0;
		for(int i = 1; i <= num; i++)
		{
			sum  = sum + i;
		}
		
		Thread.sleep(3000);
		return sum;
	}
}
