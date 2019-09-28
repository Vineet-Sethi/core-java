package enums.xtras;

public class FullFledgedEnum {
	
	enum Beer{
		
		KF(70), FO(80), RC(90), KO;
		public int price;
		
		Beer(int price){
			this.price = price;
		}
		
		Beer(){
			this.price = 65;
		}
		
		public int getPrice(){
			return price;
		}
	}
	
	public static void main(String[] args) {
		
		Beer[] b = Beer.values();
		for(Beer beer : b)
			System.out.println(beer + "price: " + beer.getPrice());
	}

}
