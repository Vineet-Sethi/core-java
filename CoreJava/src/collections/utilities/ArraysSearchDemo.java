package collections.utilities;

import java.util.Arrays;

public class ArraysSearchDemo {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		int[] a = {10, 5, 20, 11, 6};
		Arrays.sort(a);
		System.out.println(Arrays.binarySearch(a, 6));
		System.out.println(Arrays.binarySearch(a, 14));
		
		String[] s = {"A", "Z", "B"};
		Arrays.sort(s);
		System.out.println(Arrays.binarySearch(s, "Z")); //2
		System.out.println(Arrays.binarySearch(s, "S")); //-3
		
		Arrays.sort(s, new MyStringComparator());
		System.out.println(Arrays.binarySearch(s, "Z", new MyStringComparator()));  //0
		System.out.println(Arrays.binarySearch(s, "S", new MyStringComparator()));  //-2
		System.out.println(Arrays.binarySearch(s, "N"));                            //unpredictable
		
	}
}
