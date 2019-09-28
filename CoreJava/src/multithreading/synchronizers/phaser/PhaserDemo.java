package multithreading.synchronizers.phaser;

import java.util.concurrent.Phaser;

public class PhaserDemo {
	public static void main(String[] args) {
		/*
			A phaser is very similar to a cyclic barrier with the exception that we are not bound to define the number of parties that
			will synchronize on it during instantiation. This is taken care by the register method calls on the phaser.
		*/
		Phaser phaser  = new Phaser(1);
		
		for(int i = 0; i < 4; i++)
		{
			phaser.register();
			WaitOnPhaser waitThread = new WaitOnPhaser(phaser);
			waitThread.start();
		}
		
		phaser.arriveAndDeregister();
	}
}
