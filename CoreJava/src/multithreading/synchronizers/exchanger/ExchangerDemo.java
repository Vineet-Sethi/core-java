package multithreading.synchronizers.exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerDemo {
	
	public static void main(String[] args) 
	{
		Exchanger<List<Integer>> exchanger = new Exchanger<List<Integer>>();
		
		ProducerX prod1 = new ProducerX(exchanger);
		ProducerY prod2 = new ProducerY(exchanger);
		
		prod1.start();
		prod2.start();
	}
	

}
