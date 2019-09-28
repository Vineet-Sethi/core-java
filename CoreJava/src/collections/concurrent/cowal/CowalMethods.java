package collections.concurrent.cowal;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class CowalMethods {
	
	public static void main(String[] args) {
		ArrayList l = new ArrayList();
		l.add("A");
		l.add("B");
		
		CopyOnWriteArrayList l1 = new CopyOnWriteArrayList();
		l1.addIfAbsent("A");
		l1.addIfAbsent("C");
		
		l1.addAll(l);
		
		ArrayList l2 = new ArrayList();
		l2.add("A");
		l2.add("E");
		
		l1.addAllAbsent(l2);          //basically add all absent(in l1) from l2 => add extras from l2
		System.out.println(l1);
	}
}
