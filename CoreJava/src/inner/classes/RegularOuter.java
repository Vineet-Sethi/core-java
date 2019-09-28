package inner.classes;

/*  ***IMP*** The key point to note in accessing inner class code is the existence of an outer class instance!! */
// Accessing Inner class code from static/instance area of outer
public class RegularOuter 
{
	public class Inner
	{
		public void m1()
		{
			System.out.println("Inner class code");
		}
	}
	
	public static void main(String[] args)     //Put the same main method code in another class to access inner class code from outside of outer class
	{
		RegularOuter outer = new RegularOuter();
		RegularOuter.Inner inner = outer.new Inner();
		inner.m1();
		
		//Alternative syntax
		new RegularOuter().new Inner().m1();
	}
	
	/*public void m2()
	{
		Inner i = new Inner();   //Possible as to access m2 there is already an instance of RegularOuter
		i.m1();
	}*/
}
