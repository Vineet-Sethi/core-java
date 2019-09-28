package collections.sets;

import java.util.Comparator;
import java.util.TreeSet;

/*
   Write a program to insert Integer objects into the TreeSet where the sorting order is descending order. 
   
   Note: If we don't pass the comparator object as in the commented line 16 then internally JVM will call compareTo method which is meant for
   default natural sorting order. In this case the output is [0, 5, 10, 15, 20]
   On the other hand if we comparator object then JVM will call the compare method which is meant for customized sorting. In this case output
   is [20, 15, 10, 5, 0].
*/

public class TreeSetDemo2 {
	
	public static void main(String[] args) {
		
		//TreeSet t = new TreeSet();
		TreeSet t = new TreeSet(new MyComparator());
		
		t.add(10);
		t.add(0);
		t.add(15);
		t.add(5);
		t.add(20);
		t.add(20);
		
		System.out.println(t);
	}
}

class MyComparator implements Comparator{

	@Override
	public int compare(Object num1, Object num2) {
		
		Integer I1 = (Integer)num1;
		Integer I2 = (Integer)num2;
		
		if(I1 < I2)
			return 1;
		else if(I1 > I2)
			return -1;
		else 
			return 0;
	}
	
}
