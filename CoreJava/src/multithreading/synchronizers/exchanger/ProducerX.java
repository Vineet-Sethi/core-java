package multithreading.synchronizers.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ProducerX extends Thread{
	
	private Exchanger<List<Integer>> exchanger;
	private List<Integer> numbers = new ArrayList<Integer>();
	
	public ProducerX(Exchanger<List<Integer>> exchanger)
	{
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		try 
		{
			fillNumbers();
			System.out.println("ProducerX produced " + numbers);
			Thread.sleep(3000);
			List<Integer> recv = exchanger.exchange(numbers);
			System.out.println("ProducerX received " + recv);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void fillNumbers() {
		for(int i = 0; i < 3; i++) {
			numbers.add(i);
		}
	}
}
