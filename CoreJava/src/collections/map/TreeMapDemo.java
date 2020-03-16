 package collections.map;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapDemo {
	 public static void main(String[] args) {
		 
		 treeMapNaturalSorting();
		 treeMapCustomizedSorting();
	}

	private static void treeMapNaturalSorting() {
		
		TreeMap m = new TreeMap();   //DNSO
		 m.put(100, "ZZZ");
		 m.put(103, "XXX");
		 m.put(101, "YYY");
		 m.put(104, 106);         //values can be heterogeneous
		 
		 //m.put("FFFF", "XXX");  //CCE With DNSO keys should be homogeneous
		 //m.put(null, "XXX");    //NPE
		 
		 System.out.println(m);
	}
	
	private static void treeMapCustomizedSorting() {
		
		TreeMap m = new TreeMap(new MyComparator());   // customized sorting

		 m.put("XXX", 10);
		 m.put("AAA", 20);
		 m.put("ZZZ", 30);
		 m.put("LLL", 40);
		 
		 System.out.println(m);
	}
}

class MyComparator implements Comparator
{
	@Override
	public int compare(Object arg0, Object arg1) {
		
		String s1 = (String)arg0;
		String s2 = (String)arg1;
		
		return s2.compareTo(s1);
	}
}

