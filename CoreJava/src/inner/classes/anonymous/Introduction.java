package inner.classes.anonymous;

/*
 1. Anonymous-Inner-Class can either extend a class OR implement an interface at a time. This is unlike a regular java class which can extend 
 	a class and simultaneously implement one or more interfaces.
 2. We can't write any constructors for A-I-C as it does not have a name
 3. A-I-C are needed for instant(one-time) use.
*/
public class Introduction {
	
	public static void main(String[] args) 
	{
		Popcorn p = new Popcorn();

		Popcorn p1 = new Popcorn(){          //A-I-C
			public void taste()
			{
				System.out.println("Spicy");
			}
		};
		
		Popcorn p2 = new Popcorn(){          //A-I-C
			public void taste()
			{
				System.out.println("Sweet");
			}
		};
		
		p.taste();
		p1.taste();
		p2.taste();
		
		System.out.println(p.getClass().getName());
		System.out.println(p1.getClass().getName());
		System.out.println(p2.getClass().getName());
	}
}
