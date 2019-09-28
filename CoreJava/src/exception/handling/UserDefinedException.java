package exception.handling;
/*
    1. It is highly recommended to define customized or user defined exceptions as unchecked - ie we have to extend RuntimeException but
       not Exception.
    2. throw keyword is best suitable for customized or user defined exceptions but not for prede-fined exceptions.
 */
public class UserDefinedException {
	
	public static void main(String[] args) 
	{
		int age = Integer.parseInt(args[0]);
		
		if(age < 18) {
			throw new TooYoungException("You are too young to join our organization");
		}
		else if(age > 60){
			throw new TooOldException("You are too old to join our organization");
		}
		else {
			System.out.println("Lets meet for an interview!");
		}
	}
}

class TooYoungException extends RuntimeException
{
	public TooYoungException(String message)
	{
		super(message);
	}
}

class TooOldException extends RuntimeException
{
	public TooOldException(String message)
	{
		super(message);
	}
	
}

