package collections.lists;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListDemo {
	
	public static void main(String[] args) {
		
		LinkedList l = new LinkedList();
		l.add("Abc");
		l.add(10);
		l.add("Abc");
		l.add(null);
		System.out.println(l);
		
		l.set(0, "software");
		System.out.println(l);
		
		l.add(0, "learn");
		l.removeLast();
		l.addFirst("I");
		System.out.println(l);
	}
}
