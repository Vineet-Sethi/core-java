package collections.comparators;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Employee e1 = (Employee)o1;
		Employee e2 = (Employee)o2;
		
		String name1 = e1.name;
		String name2 = e2.name;
		
		return name1.compareTo(name2);
	}

}
