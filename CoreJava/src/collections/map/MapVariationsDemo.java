package collections.map;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.WeakHashMap;

public class MapVariationsDemo {
	public static void main(String[] args) throws InterruptedException {
		
		//linkedHashMapDemo();
		//identityHashMapDemo();
		weakHashMapDemo();
		
	}

	private static void weakHashMapDemo() throws InterruptedException {
		
		HashMap m= new HashMap();     //Temp object will not be eligible for GC if associated with HashMap. Hence O/P = {temp=Durga} both times
		//WeakHashMap m= new WeakHashMap();//Temp will be garbage collected as GC will dominate WeakHashMap
		Temp t = new Temp();
		m.put(t, "Durga");
		System.out.println(m);
		t = null;
		System.gc();
		Thread.sleep(5000);
		System.out.println(m);
	}

	private static void linkedHashMapDemo() {
		
		LinkedHashMap m = new LinkedHashMap();  //Maintains insertion order although its a Map
		m.put("chiranjeevi", 700);
		m.put("balaiah", 800);
		m.put("venkatesh", 200);
		m.put("nagarjuna", 500);
		
		System.out.println(m);
	}

	private static void identityHashMapDemo() {
		
		//HashMap m2= new HashMap();       //Will have only 1 entry {10=Kalyan}
		IdentityHashMap m2= new IdentityHashMap();
		Integer I1 = new Integer(10);      //I1 & I2 are duplicate keys because I1.equals(I2) returns true.
		Integer I2 = new Integer(10);
		m2.put(I1, "Pavan");
		m2.put(I2, "Kalyan");
		System.out.println(m2);
	}
}


class Temp {
	
	public String toString()
	{
		return "Temp";
	}
	
	@Override
	protected void finalize() throws Throwable 
	{
		System.out.println("Finalize method called");
	}
}