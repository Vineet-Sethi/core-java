package enums.xtras;

public enum Fish {         
	STAR, GOLD, SALMON;    //Enum constants should be in the first line and the semi-colon becomes mandatory(even with zero enum constants)
                           //when enums have xtra stuff
                           	
	private Fish(){        //Java enums can have constructors too. Note: Constructor is private, cant call directly
		System.out.println("Fish Constructor");
	}
	
	
	
	
	
	/*public static void main(String[] args)   //Java enums can have methods(concrete, not abstract) as well including main method!
	{         
		//Fish f = Fish.STAR;   //No effect, fish constructor called anyways as enum has to be loaded to execute main method
		System.out.println("Fish enum main Method");
	}*/
}
