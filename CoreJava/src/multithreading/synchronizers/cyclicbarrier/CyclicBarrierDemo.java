package multithreading.synchronizers.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	public static void main(String[] args) {
		
		/*
		    A cyclic barrier allows you to create threads that wait at the barrier until the last or the longest time taking thread arrives.
		    Hence if a task can be broken into multiple threads then at the barrier the result of the tasks performed by barrier threads can 
		    be combine to arrive at the final result.
		*/
		CyclicBarrier barrier  = new CyclicBarrier(4);
		
		
		/*
			A cyclic barrier also allows you to execute an action when the barrier breaks when used with the following constructor
			Runnable barrierAction = () -> System.out.println("We are ready.");
			CyclicBarrier barrier2  = new CyclicBarrier(4, barrierAction);
		*/
		
		for(int i = 0; i < 4; i++)
		{
			WaitOnBarrier waitThread = new WaitOnBarrier(barrier);
			waitThread.start();
		}
	}
}
