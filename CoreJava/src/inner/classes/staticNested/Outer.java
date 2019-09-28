package inner.classes.staticNested;

/*
  ***IMP*** "BEING STATIC" the Static-Nested-Classes
 1. Can access only static members of outer class.
 2. Can have static declarations including the main method.
 3. Are not strongly associated with Outer class. Hence you can instantiate them without instantiating Outer class
 */
public class Outer {
	
	int i = 5;
	static int j = 10;
	
	static class Nested
	{
		public void m1()
		{
			//System.out.println(i);               //Can't access non-static members of Outer
			System.out.println(j);
		}
		
		public static void main(String[] args)     //Can be invoked using java Outer$Nested 
		{
			System.out.println("StaticNested class main method");
		}
	}
	
	public static void main(String[] args)         //Instantiate without instantiating Outer
	{
		Nested nested1 = new Nested();             //From within Outer class
		nested1.m1();
		
		Outer.Nested nested = new Outer.Nested(); //From outside of Outer class
		nested.m1();
	}
}
