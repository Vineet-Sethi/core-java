package multithreading.synchronizers.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ProducerY extends Thread{
	
	private Exchanger<List<Integer>> exchanger;
	private List<Integer> numbers2 = new ArrayList<Integer>();
	
	public ProducerY(Exchanger<List<Integer>> exchanger)
	{
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		try 
		{
			fillOtherNumbers();
			System.out.println("ProducerY produced " + numbers2);
			Thread.sleep(6000);
			List<Integer> recv = exchanger.exchange(numbers2);
			System.out.println("ProducerY received " + recv);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void fillOtherNumbers() {
		for(int i = 40; i < 48; i++) {
			numbers2.add(i);
		}
	}
}
