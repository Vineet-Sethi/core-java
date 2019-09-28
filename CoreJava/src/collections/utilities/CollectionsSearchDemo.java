package collections.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsSearchDemo {
	public static void main(String[] args) 
	{
		//searchDemo();
		customizedSearchDemo();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void customizedSearchDemo() {
		ArrayList l = new ArrayList();
		l.add(15);
		l.add(0);
		l.add(20);
		l.add(10);
		l.add(5);
		
		System.out.println(l);
		Collections.sort(l, new MyIntComparator());
		System.out.println(l);
		
		System.out.println(Collections.binarySearch(l, 10, new MyIntComparator()));
		System.out.println(Collections.binarySearch(l, 13, new MyIntComparator()));
		System.out.println(Collections.binarySearch(l, 6)); // unpredictable
		//System.out.println(Collections.binarySearch(l, 17, new MyIntComparator())); // -2
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void searchDemo() 
	{
		ArrayList l = new ArrayList();
		l.add("Z");
		l.add("A");
		l.add("M");
		l.add("K");
		l.add("a");
		
		System.out.println(l);
		Collections.sort(l);
		System.out.println(l);
		
		System.out.println(Collections.binarySearch(l, "Z"));
		System.out.println(Collections.binarySearch(l, "b"));
	}
}

class MyIntComparator implements Comparator
{

	@Override
	public int compare(Object arg0, Object arg1) {
		Integer i1 = (Integer)arg0;
		Integer i2 = (Integer)arg1;
		
		return i2.compareTo(i1);
	}
}
