package collections.comparators;

import java.util.Comparator;
import java.util.TreeSet;

/*
   Program to insert String and StringBuffer objects into the TreeSet where sorting order is increasing length order.
   If two objects have the same length then consider their alphabetical order.
   
 */
public class HeterogeneousComparatorDemo implements Comparator {

	@Override
	public int compare(Object arg0, Object arg1) {
		
		String s1  = arg0.toString();
		String s2  = arg1.toString();
		
		int l1 = s1.length();
		int l2 = s2.length();
		
		if(l1 < l2)
			return -1;
		else if(l1 > l2)
			return 1;
		else
			s1.compareTo(s2);
		
		return s2.compareTo(s1);
		//return -s1.compareTo(s2);
	}
	
	public static void main(String[] args) {
		
		TreeSet mySet = new TreeSet(new HeterogeneousComparatorDemo());
		mySet.add("A");
		mySet.add(new StringBuffer("ABC"));
		mySet.add(new StringBuffer("AA"));
		mySet.add("XX");
		mySet.add("ABCD");
		mySet.add("A");
		
		System.out.println(mySet);
	}
}
