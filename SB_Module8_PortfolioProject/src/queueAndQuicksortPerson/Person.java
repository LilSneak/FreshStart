package queueAndQuicksortPerson;

import java.util.Random;
import java.util.Scanner;



public class Person {
	Scanner scnr = new Scanner(System.in);
	
	private String firstName;
	private String lastName;
	private int age;
	
	Person people[];

	public Person(){
		firstName = "Unknown";
		lastName = "Unknown";
		age = 0;
	}
	
	public void setPerson() {
		
		System.out.println("\nEnter the first name, last name, and age of Person ");
		
		this.firstName = scnr.next();
		this.lastName = scnr.next();
		this.age = scnr.nextInt();
	
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	
	public String getInfo() {
		
		
		String personInfo = "\nFirst Name: " + getFirstName() + "\nLast Name: " + getLastName() + "\nAge: " + getAge();
		
		return personInfo;
	}

	public class Queue <T>{

		
		T[] Queue;//Generic array created
		int front = 0;//"front" created to keep track of front of queue
		int back = 0;//"back" used to keep track of back of queue
		private int capacity = 0;
		
		public Queue() {//Default of size 10
			capacity = 10;
			
			Queue = (T[]) new Object[capacity];
		}
		public Queue(int c) {//Queue sized to a specific integer
			capacity = c;
			
			Queue = (T[]) new Object[capacity];
		}
		
		public int getSize() {//used to get the current queue size
			return back;
		}
		
		public boolean isEmpty() {//checks to see if queue is empty
			try {
				if(front == back) {
					throw new Exception("Queue is Empty");
				}
				else {
					return false;
				}
			}catch(Exception a){
				System.out.println(a);
				System.out.println("Add elements to queue and try again");
			}
			return true;
			
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
		public void settingQueue(int capacity) {
			people = new Person[2];
			for(int i = 0; i < capacity; i++) {
				people[i] = new Person();
			}
			for(int i = 0; i < capacity; i++) {
			
				people[i].setPerson();
			}
			
			for(Person p: people) {
				String info = p.getInfo();
				enqueue((T) info);
			}
		}
		public void print() {//Prints out the queue
			
			if(isEmpty()) {
				return;
			}
			
			for(int i = front; i < back; i++) {
				System.out.println(Queue[i]);
			}
			System.out.println();

		}
		
		public T[] getQueue() {
			return Queue;
		}
		
		public T getFront() {//returns the front of the queue
			if(isEmpty()) {
				return null;
			}
			
			return Queue[front];
		}
		
		public T getBack() {
			if(isEmpty()) {
				return null;
			}
			
			return Queue[back];
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
		
	public void sortByName() {
		nameQuicksort(people, Queue, 0, people.length -1);
	}

	public void nameQuicksort(Person[] array, T[] queue, int lowIndex, int highIndex) {//QuickSort method for lastName
		
		if(lowIndex >= highIndex) {//if the array to be sorted has only one element no need to sort and end to recursion
			return;
		}
		
		//Lines 102-104 are to choose a random pivot point and then swap the pivot to be at the highIndex.
		int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
		String pivot = array[pivotIndex].getLastName(); //((Person) Queue[pivotIndex]).getLastName();
		swap(queue, pivotIndex, highIndex);
		
		int leftPointer = partition(array, queue, lowIndex, highIndex, pivot);//method for comparing the values to determine when to partition
		swap(queue, leftPointer, highIndex);
		
		nameQuicksort(array, queue, lowIndex, leftPointer -1);
		nameQuicksort(array, queue, leftPointer + 1, highIndex);
	}

	private int partition(Person[] array, T[] queue, int lowIndex, int highIndex, String pivot) {//method for comparing the values to determine when to partition
		int leftPointer = lowIndex; //left side of array
		int rightPointer = highIndex;//right side of array
		
		while(leftPointer < rightPointer) {//Once the right and left pointer meet then the loop will end
			
			//will keep looping until value is > pivot or when leftPointer passes the rightPointer
			while(array[leftPointer].getLastName().compareToIgnoreCase(pivot) <= 0  && leftPointer < rightPointer) {
				leftPointer++;
			}
			//will keep looping until value is < pivot or rightPointer passes leftPointer
			while(array[rightPointer].getLastName().compareToIgnoreCase(pivot) >= 0  && leftPointer < rightPointer) {
				rightPointer--;
			}
			
			swap(queue, leftPointer, rightPointer);
			
		}
		return leftPointer;
	}

	private void swap(T[] queue, int index1, int index2) {
		T temp = queue[index1];
		queue[index1] = queue[index2];
		queue[index2] = temp;
	}
	
	public void sortByAge() {
		ageQuicksort(people, Queue, 0, people.length -1);
	}
public void ageQuicksort(Person[] array, T[] queue, int lowIndex, int highIndex) {//QuickSort method for lastName
		
		if(lowIndex >= highIndex) {//if the array to be sorted has only one element no need to sort and end to recursion
			return;
		}
		
		//Lines 102-104 are to choose a random pivot point and then swap the pivot to be at the highIndex.
		int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
		int pivot = array[pivotIndex].getAge(); //((Person) Queue[pivotIndex]).getLastName();
		swap(queue, pivotIndex, highIndex);
		
		int leftPointer = agePartition(array, queue, lowIndex, highIndex, pivot);//method for comparing the values to determine when to partition
		swap(queue, leftPointer, highIndex);
		
		ageQuicksort(array, queue, lowIndex, leftPointer -1);
		ageQuicksort(array, queue, leftPointer + 1, highIndex);
	}
	private int agePartition(Person[] array, T[] queue, int lowIndex, int highIndex, int pivot) {//method for comparing the values to determine when to partition
	int leftPointer1 = lowIndex; //left side of array
	int rightPointer1 = highIndex;//right side of array
	
	while(leftPointer1 < rightPointer1) {//Once the right and left pointer meet then the loop will end
		
		//will keep looping until value is > pivot or when leftPointer passes the rightPointer
		while(array[leftPointer1].getAge() <= pivot  && leftPointer1 < rightPointer1) {
			leftPointer1++;
		}
		//will keep looping until value is < pivot or rightPointer passes leftPointer
		while(array[rightPointer1].getAge() >= pivot && leftPointer1 < rightPointer1) {
			rightPointer1--;
		}
		
		swap(queue, leftPointer1, rightPointer1);
		
	}
	return leftPointer1;
}

	}

	


}
