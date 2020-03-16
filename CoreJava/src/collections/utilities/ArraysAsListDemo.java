package collections.utilities;

import java.util.Arrays;
import java.util.List;

public class ArraysAsListDemo {
	public static void main(String[] args) {
		String[] s = {"A", "Z", "B"};
		List<String> l = Arrays.asList("A","Z","B");
		System.out.println(l);
		
		s[0] = "K";
		System.out.println(l);
		
		l.set(1, "L");
		for(String s1: l)
			System.out.println(s1);
		
		//l.add("durga");
		//l.remove(2);
		//l.set(1, new Integer(10));
	}
}
