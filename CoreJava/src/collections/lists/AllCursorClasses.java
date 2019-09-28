package collections.lists;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class AllCursorClasses {
	
	public static void main(String[] args) {
		Vector v = new Vector();
		Enumeration e = v.elements();
		Iterator myItr = v.iterator();
		ListIterator myLtr = v.listIterator();
		 
		System.out.println(e.getClass().getName());
		System.out.println(myItr.getClass().getName());
		System.out.println(myLtr.getClass().getName());
	}

}
