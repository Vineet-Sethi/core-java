package collections.queue;

import java.util.TreeSet;

public class NavigableSetDemo {
	public static void main(String[] args) {
		
		TreeSet<Integer> t = new TreeSet<Integer>();
		t.add(1000);
		t.add(2000);
		t.add(3000);
		t.add(4000);
		t.add(5000);
		System.out.println(t);
		System.out.println("ceiling: " + t.ceiling(2000));  //t.ceiling(1500) works as well
		System.out.println("higher: " + t.higher(2000));
		System.out.println("floor " + t.floor(3000));
		System.out.println("lower " + t.lower(3000));
		System.out.println("pollFirst " + t.pollFirst());
		System.out.println("pollLast " + t.pollLast());
		System.out.println("descendingSet " + t.descendingSet());
		System.out.println(t);
		
	}
}
