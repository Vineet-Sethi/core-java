package multithreading;

// getName, setName("") signatures are regular getter setter signatures except that they are final.
public class ThreadNaming {
	
	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName());
		 
		ChildThread t = new ChildThread();
		System.out.println(t.getName());
		t.start();
		
		Thread.currentThread().setName("ABC");
		System.out.println(Thread.currentThread().getName());
		
	}
}

class ChildThread extends Thread {
	
	@Override
	public void run() {
		 System.out.println("Run method executed by " + Thread.currentThread().getName());
	} 
	
}
