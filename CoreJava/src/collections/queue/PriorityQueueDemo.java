package collections.queue;

import java.util.Comparator;
import java.util.PriorityQueue;


public class PriorityQueueDemo {
	public static void main(String[] args) {
		
		basicQueueDemo();
		comparatorQueueDemo();
		
	}

	private static void comparatorQueueDemo() {
		
		PriorityQueue q = new PriorityQueue(15, new MyComparator());
		q.offer("A");
		q.offer("Z");
		q.offer("L");
		q.offer("B");
		System.out.println(q);		
	}

	private static void basicQueueDemo() {
		PriorityQueue q = new PriorityQueue();
		
		System.out.println(q.peek());
		//System.out.println(q.element());  // RE:NSEE
		
		for(int i = 0; i <= 10; i++ )
		{
			q.offer(i);
		}
		
		System.out.println(q);
		System.out.println(q.poll());
		System.out.println(q);   //Note: Some platforms wont provide proper support for ThreadPriorities and PriorityQueues.
	}
}

class MyComparator implements Comparator
{
	@Override
	public int compare(Object arg0, Object arg1) {
		String s1 = (String) arg0;
		String s2 = (String) arg1;
		return s2.compareTo(s1);
	}
}