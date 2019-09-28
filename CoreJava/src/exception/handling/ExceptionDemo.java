package exception.handling;

/*
	In a program even if a single method terminates abnormally then it is abnormal termination. 
	If all methods terminate normally only then it is normal termination. 
 */

public class ExceptionDemo 
{
	public static void main(String[] args) 
	{
		doStuff();
		System.out.println("End of main");  // Not executed
	}

	private static void doStuff() 
	{
		doMoreStuff();
	}

	private static void doMoreStuff() 
	{
		System.out.println(10/0);
	}
}

