package PracticeQueue;

public class Queue<T> {
	
	private T[] Queue;//Generic array created
	private int front = 0;//"front" created to keep track of front of queue
	private int back = 0;//"back" used to keep track of back of queue
	private int capacity = 0;
	
	public Queue() {//Default of size 10
		Queue = (T[]) new Object[10];
	}
	public Queue(int c) {//Queue sized to a specific integer
		capacity = c;
		
		Queue = (T[]) new Object[capacity];
	}
	
	public int getSize() {//used to get the current queue size
		return back;
	}
	
	public boolean isEmpty() {//checks to see if queue is empty
		return front == back;
	}
	
	public void enqueue(T newItem) {//adds a new item to the back of queue
		try {
			if (capacity == back) {//checks if queue is full
				throw new Exception("Queue is full");
			}
			else {
				Queue[back] = newItem;
				
				back++; //increases size of queue
			}
		}catch(Exception a){
			System.out.println(a);
			System.out.println("Add elements to queue and try again");
		}
	}
	
	public void print() {//Prints out the queue.
		try {
			if(isEmpty()) {
				throw new Exception("Queue is Empty");
			}
			System.out.println("Queue: ");
			
			for(int i = front; i < back; i++) {
				System.out.print(Queue[i] + " ");
			}
			System.out.println();
		}catch(Exception b) {
			System.out.println(b);
			System.out.println("Add elements to queue and try again");
		}
	}
	public T getFront() {//returns the front of the queue
		if(isEmpty()) {
			return null;
		}
		
		return Queue[front];
	}
	
	public T dequeue() {//removes element at front of queue
		if(isEmpty()) {
			return null;
		}
		else {
			T removedFront = getFront();
			for(int i = 0; i < back - 1; i++) {//iterates through queue and moves the elements up one.
				Queue[i] = Queue[i+1];
				
				
			}
			if(back < capacity) {//changes the back of the queue value if queue isn't full
				Queue[back] = null;
				
				back--;
			}
			return removedFront;
		}
		
	}
	public static void main(String[] args) {
		Queue<String> waitingList = new Queue(5);
		
		waitingList.enqueue("Sam");
		waitingList.enqueue("Rick");
		waitingList.enqueue("James");
		waitingList.enqueue("John");
		
		waitingList.print();
		System.out.println("Removing " + waitingList.dequeue() + " from queue\n");
		
		waitingList.print();
		System.out.println("Size of Queue: "+ waitingList.getSize());
		System.out.println("\nFirst up on the Queue: "+ waitingList.getFront());
	}

}
