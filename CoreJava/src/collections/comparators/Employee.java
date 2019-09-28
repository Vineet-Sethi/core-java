package collections.comparators;

public class Employee implements Comparable<Employee> {
	
	String name;
	int eId;
	
	public Employee(String name, int eId) {
		this.name = name;
		this.eId = eId;
	}
	
	public String toString()
	{
		return name + "--" + eId;
	}

	@Override
	public int compareTo(Employee e) {
		
		int eId1 = this.eId;
		int eId2 = e.eId;
		
		if(eId1 < eId2)
			return -1;
		if(eId1 > eId2)
			return 1;
		else 
			return 0;
	}
}
