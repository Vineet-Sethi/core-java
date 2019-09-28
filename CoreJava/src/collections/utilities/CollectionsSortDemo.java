package collections.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsSortDemo 
{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) 
	{
		ArrayList l = new ArrayList();
		l.add("Z");
		l.add("A");
		l.add("K");
		l.add("L");
		
		listNaturalSorting(l);
		listCustomSorting(l);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void listNaturalSorting(List l) 
	{
		//l.add(new Integer(10));  //-- CCE when sorted
		//l.addAll(null);          //-- NPE when sorted
		
		System.out.println("Before Sorting:" + l);
		Collections.sort(l);
		System.out.println("After Sorting:" + l);
	}

	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	private static void listCustomSorting(List l) 
	{
		//l.add(new Integer(10));  //-- CCE when sorted
		//l.addAll(null);          //-- NPE when sorted
		
		System.out.println("Before Sorting:" + l);
		Collections.sort(l, new MyComparator());
		System.out.println("After Sorting:" + l);
	}
}

@SuppressWarnings("rawtypes")
class MyComparator implements Comparator
{
	@Override
	public int compare(Object arg0, Object arg1) {
		String s1 = (String) arg0;
		String s2 = (String) arg1;
		return s2.compareTo(s1);
	}
}
