package enums;

public class Switch {  //since 1.5
	
	public static void main(String[] args) {
		
		Beer beer = Beer.KF;
		System.out.println(beer);

		switch(beer)
		{
			case KF: System.out.println("Kingfisher");
			break;
			
			case FO: System.out.println("Foster");
			break;
			
			case KO: System.out.println("Knock Out");
			break;
			
			case RC: System.out.println("Royal Challenge");
			break;
			
			//case ABC: System.out.println("Some other brand");  Should be whats already there in the declared enum
		}
		
		fewMethods();
	}

	private static void fewMethods() {   //ordinal(index) and values
		
		Beer[] b = Beer.values();
		for(Beer bee : b){
			System.out.println(bee.ordinal() + "..." + bee);
		}
	}
}
