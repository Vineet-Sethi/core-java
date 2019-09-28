package oops.concepts;

public class ThisDemo {

	public static void main(String[] args) 
	{
		Person p1 = new Person("Ajay", 29);
		Person p2 = new Person("Ajeet", 27);
		
		p1.describePerson();
		System.out.println(p1.hashCode());
		
		p2.describePerson();
		System.out.println(p2.hashCode());
	}
}

class Person
{
	 public String name;
	 public int age;
	 
	 public Person(String name, int age)
	 {
		this.name = name;
		this.age = age;
	 } 
	 
	 public void describePerson() 
	 {
		 System.out.println("current Object " + this);
		 System.out.println("current Object age field " + this.age);
		 System.out.println(name + " has age "  + age + " years");
	 }
}


