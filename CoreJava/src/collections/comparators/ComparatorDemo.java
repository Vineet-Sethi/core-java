package collections.comparators;

import java.util.Comparator;
import java.util.TreeSet;

/*
   Program to insert String objects into the TreeSet where all elements should be inserted according to reverse alphabetical order.
   
   Note: Instead of string objects if we add StringBuffer objects to the TreeSet we should remember that StringBuffer does not implement compareTo
   method hence there is no default or natural sorting order for StringBuffer. Hence we need to write a comparator and pass it while instantiating
   the TreeSet otherwise we will get ClassCastException as the JVM will treat the added objects as heterogeneous or non-comparable.
   
   If we are depending on default natural sorting order compulsory objects should be homogeneous and comparable otherwise we will get runtime
   exception saying ClassCastException. Also if we are defining our own sorting by writing a comparator then objects need not be comparable
   and homogeneous ie we can add heterogeneous and non comparable objects also.
   
*/
public class ComparatorDemo implements Comparator {

	@Override
	public int compare(Object arg0, Object arg1) {
		
		String s1  = (String)arg0;
		String s2  = (String)arg1;
		
		return s2.compareTo(s1);
		//return -s1.compareTo(s2);
	}
	
	public static void main(String[] args) {
		
		//TreeSet mySet = new TreeSet();    //DNSO
		TreeSet mySet = new TreeSet(new ComparatorDemo());
		mySet.add("Suresh");
		mySet.add("Amit");
		mySet.add("Siddharth");
		mySet.add("Aakash");
		mySet.add("Lakshaya");
		
		System.out.println(mySet);
		
		/*
		   TreeSet mySet1 = new TreeSet();
		   mySet1.add(new StringBuffer("ABC"));
		   mySet1.add(new StringBuffer("AA"));
		   
		   System.out.println(mySet1);
		 */
	}
}
