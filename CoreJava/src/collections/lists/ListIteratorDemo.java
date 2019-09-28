package collections.lists;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;

public class ListIteratorDemo {
	
	public static void main(String[] args) {
		
		LinkedList l = new LinkedList();
		l.add("balakrishna");
		l.add("venki");
		l.add("chiru");
		l.add("nag");
		System.out.println(l);
		
		ListIterator ltr = l.listIterator();
		while(ltr.hasNext()){

			String s = (String)ltr.next();
			
			if(s.equals("Venki"))
			{
				ltr.remove();
			}
			else if(s.equals("nag"))
			{
				ltr.add("chaitu");
			}
			else if(s.equals("chiru"))
			{
				ltr.set("charan");
			}
		}
		System.out.println(l);
	}
}
