package multithreading.pause.execution;
/*
    If a thread calls join on another thread then it is basically asking/offering the other thread to execute and will itself wait. Hence
    		t2.join() in the execution path of t1 will cause t1 to wait until t2 completes.
     
    public final void join() throws IE;
	public final void join(long ms) throws IE;
	public final void join(long ms, int ns) throws IE;
	
	              (if t2 completes / time expires / t1 interrupted)                 t2.join() / t2.join(1000) / t2.join(1000, 100)  		 
	MyThread t1 = new MyThread();       		            <---------- Waiting ------------                        
			New/Born ---------------------> Ready/Runnable  --------------------------------> Running -------------------------> Dead
						  t1.start()                             If TS allocates processor                 When run() completes
*/
public class JoinMethod {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " starts execution");
		
		JoinedThread t = new JoinedThread();
		t.start();
		
		System.out.println(Thread.currentThread().getName() + " calls join");
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("End of " + Thread.currentThread().getName() + " thread");
		
	}
}

class JoinedThread extends Thread{
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i ++) {
			System.out.println("Child Thread");
		}
	}
}
