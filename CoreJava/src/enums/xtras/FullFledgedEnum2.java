package enums.xtras;

public class FullFledgedEnum2 {
	
	enum Color {
		BLUE, GREEN, RED{
						public void info(){
							System.out.println("Dangerous color " + this);
						}
					};
		
		public void info(){
			System.out.println("Universal color " + this);
		}
	}
	
	public static void main(String[] args) {
		
		Color[] c = Color.values();
		for(Color col: c)
			col.info();
 	}
}

/*
 * Note: Since enum constants are objects of type enum - normal java methods apply on them too like
 * Beer.KF.equals(Beer.RC)
 * Beer.KF.ordinal() < Beer.RC.ordinal()
 * Beer.KF.hashCode() < Beer.RC.hashCode()
 *
 */
