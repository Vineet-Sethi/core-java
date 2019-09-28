package inner.classes;

/*
  Without existing one type of object if there is no chance of existing another type of object then we should go for inner classes. Eg
  Also the relation between inner and outer class is not Is-A but Has-A(Composition/Aggregation)
  
  class University 			class Car				interface Map
  {							{						{
  	  class Department		     class Engine;			interface Entry
  }							}						}
 1
*/

// The codes for first 2 examples below compiles giving Outer.class & Outer$Inner.class
public class Outer 			     //Invoking javac Outer.java or javac Outer$Inner.java results in NoSuchMethodError:main
{
	public class Inner                   
	{                     
		
	}
}

/*public class Outer             //javac Outer.java results in printing "Outer class main method"
  {                              //javac Outer$Inner.java results in NoSuchMethodError:main
	public class Inner    
	{
		
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Outer class main method");
	}
}*/


/*public class Outer             //Compilation fails: We cant have static declarations inside Inner classes as they always talk about instance related terminology.
  {
	public class Inner
	{
		public static void main(String[] args) 
		{
		
		}
	}
}*/