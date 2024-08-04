package syncMultiThreading;
import java.util.concurrent.atomic.AtomicInteger;


public class MultiThreading extends Thread {
	
	private static AtomicInteger counter;//Using an atomic integer since it handles concurrent access to variable with synchronization.
	
	
	public void run() {//Run method so that method is what is ran when class objects are created
		
		try {//Exception handling if the counter is not at 0 or 20
			if(counter.get() == 0) {
				System.out.print("Counting Up: " + counter + " ");
				do {
					counter.incrementAndGet();
					System.out.print(counter + " ");
				}while(counter.get() < 20);
			}
			else if(counter.get() == 20) {
				System.out.print("\nCounting Down: ");
				do {
					System.out.print(counter + " ");
					counter.decrementAndGet();
				}while(counter.get() >= 0);
			}
			else {
				throw new Exception ("Counter is in the wrong position. Variable inappropriately modified");
			}
		}catch(Exception a) {
			System.out.print(a);
		}
	
	}
	
	public static void main(String[] args) throws InterruptedException {
		counter = new AtomicInteger(0);
		
		//creating class objects to create threads
		MultiThreading countUp = new MultiThreading();
		MultiThreading countDown = new MultiThreading();

		//Starting the threads and then joining them so that the threads have to wait for current thread to fully execute before the other starts
		countUp.start();
		countUp.join();
	
		countDown.start();
		countDown.join();
		
		
	}

}
