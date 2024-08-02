package syncMultiThreading;
import java.util.concurrent.atomic.AtomicInteger;


public class MultiThreading extends Thread {
	
	private static AtomicInteger counter;
	
	
	public void run() {
		
		try {
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
		
		MultiThreading countUp = new MultiThreading();
		MultiThreading countDown = new MultiThreading();

		countUp.start();
		countUp.join();
	
		
		countDown.start();
		countDown.join();
		
		
	}

}
