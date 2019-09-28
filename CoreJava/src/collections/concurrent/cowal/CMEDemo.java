package collections.concurrent.cowal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
//No CME thrown by COWAL
public class CMEDemo extends Thread{
	
	//public static ArrayList l = new ArrayList();
	public static CopyOnWriteArrayList l = new CopyOnWriteArrayList();
	
	@Override
	public void run() {
		try{
			Thread.sleep(2000);
		}
		catch(InterruptedException e){}
		
		l.add("C");
		System.out.println("Child Thread Updating List");
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		l.add("A");
		l.add("B");
		
		CMEDemo myThread = new CMEDemo();
		myThread.start();
		
		Iterator itr = l.iterator();
		while(itr.hasNext())
		{
			String s1 = (String)itr.next();
			System.out.println("Main Thread iterating List and current object is " + s1);
			Thread.sleep(3000);
		}
		System.out.println(l);
	}
}
