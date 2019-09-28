package collections.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
	
	public static void main(String[] args) {
		
		HashMap m = new HashMap();
		m.put("chiranjeevi", 700);
		m.put("balaiah", 800);
		m.put("venkatesh", 200);
		m.put("nagarjuna", 500);
		
		System.out.println(m);
		
		System.out.println(m.put("chiranjeevi", 1000));
		
		Set s = m.keySet();
		Set s1 = m.entrySet();
		Collection c = m.values();
		
		System.out.println(s);
		System.out.println(c);
		System.out.println(s1);
		
		Iterator itr = s1.iterator();
		while(itr.hasNext())
		{
			Map.Entry e = (Map.Entry)itr.next();
			System.out.println(e.getKey() + "----" + e.getValue());
			
			if(e.getKey().equals("nagarjuna"))
				e.setValue(10000);
		}
		System.out.println(m);
	}
}
