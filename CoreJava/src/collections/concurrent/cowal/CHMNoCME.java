package collections.concurrent.cowal;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CHMNoCME extends Thread
{
	//public static HashMap m = new HashMap(); //throws CME
	public static ConcurrentHashMap m = new ConcurrentHashMap();
	
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Child Thread Updating Map");
		m.put(103, "C");
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		m.put(101, "A");
		m.put(102, "B");
		
		CHMNoCME myThread = new CHMNoCME();
		myThread.start();
		
		Set s = m.keySet();
		Iterator itr = s.iterator();
		while(itr.hasNext())
		{
			Integer i1 = (Integer)itr.next();
			System.out.println("Main Thread iterating Map and current Entry is " + i1 + " " + m.get(i1));
			Thread.sleep(3000);
		}
		System.out.println(m);
	}

}
