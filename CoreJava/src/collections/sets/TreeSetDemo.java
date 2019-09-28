package collections.sets;

import java.util.TreeSet;

public class TreeSetDemo {
	
	public static void main(String[] args)
	{
		TreeSet t = new TreeSet();
		t.add("A");
		t.add("a");
		t.add("B");
		t.add("Z");
		t.add("L");
		
		//t.add(new Integer(10)); //CCE
		//t.add(null);            //NPE - null can only be added on an empty TreeSet. 
		//t.add("Z");             //But in that case too if we add second element we will get NPE. Hence null can be the first and only element in a TreeSet
		                          //Note: null is not allowed to be added in an empty set too from Java 1.7. Hence null not applicable for 1.7 TreeSet
		
		System.out.println(t);
		
		//StringBufferSet(); //CCE: As StringBuffer class does not implement Comparable interface we don't have any default or natural sorting 
		                     //order to depend on and hence the exception. String class and all wrapper classes implement Comparable interface
		                     //When a class does not implement Comparable its objects are not comparable with each other and its objects are
		                     //treated as heterogeneous
		
		System.out.println("A".compareTo("Z"));
		System.out.println("Z".compareTo("K"));
		System.out.println("A".compareTo("A"));
		System.out.println("A".compareTo(null));
	}
	
	public static void StringBufferSet(){
		
		TreeSet t = new TreeSet();    //Default Natural Sorting Order
		t.add(new StringBuffer("A"));
		t.add(new StringBuffer("Z"));
		t.add(new StringBuffer("L"));
		t.add(new StringBuffer("B"));
		
		System.out.println(t);
		
	
		
	}

}
