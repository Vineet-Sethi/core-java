package collections.utilities;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSortDemo {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		int[]  a = {10, 5, 20, 11, 6};
		
		
		System.out.print("Primitive array before sorting ");
		for(int a1: a)
			System.out.print(a1 + " ");
		
		System.out.println(" ");
		
		Arrays.sort(a);
		System.out.print("Primitive array after sorting  ");
		for(int a1: a)
			System.out.print(a1 + " ");
		
		System.out.println(" ");
		
		/*-------------------------------------*/
		
		String[]  s	 = {"A", "Z", "B"};
		System.out.println("Object array before sorting");
		for(String s1: s)
			System.out.println(s1);
		
		Arrays.sort(s);
		System.out.println("Object array after sorting");
		for(String s1: s)
			System.out.println(s1);
		
		Arrays.sort(s, new MyStringComparator());
		System.out.println("Object array after sorting by Comparator");
		for(String s1: s)
			System.out.println(s1);
		
	}

}
class MyStringComparator implements Comparator
{
	@Override
	public int compare(Object arg0, Object arg1) {
		String s1 = (String) arg0;
		String s2 = (String) arg1;
		return s2.compareTo(s1);
	}
}

