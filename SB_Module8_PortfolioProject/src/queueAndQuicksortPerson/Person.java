package queueAndQuicksortPerson;

import java.util.Random;
import java.util.Scanner;

import queueAndQuicksortPerson.Person.Queue;



public class Person {
	Scanner scnr = new Scanner(System.in);
	
	//variables to store person data
	private String firstName;
	private String lastName;
	private int age;
	
	//Person object array to store and access the person details
	private Person people[];

	public Person(){
		firstName = "Unknown";
		lastName = "Unknown";
		age = 0;
	}
	public void setPerson(int numPerson) {//Setting values based on user input
		
		System.out.println("\nEnter the first name, last name, and age of Person #" + numPerson);
		
		this.firstName = scnr.next();
		this.lastName = scnr.next();
		this.age = scnr.nextInt();
	
	}
	public String getFirstName() {//retrieving a person's first name
		return firstName;
	}
	public String getLastName() {//retrieving a person's last name
		return lastName;
	}
	public int getAge() {//retrieving a person's age
		return age;
	}
	public String getInfo() {// returns a string of all the person's information organized.
		String personInfo = "\nFirst Name: " + getFirstName() + "\nLast Name: " + getLastName() + "\nAge: " + getAge();
		
		return personInfo;
	}

	public class Queue <T>{//nested class since it is used in extension of person and easier to access person data in order to sort

		
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
		
		public void settingQueue(int capacity) {//used to add person objects to a Person[] that can be accessed to compare age and names of a person. 
			//Also adds a person's info to the Queue 
			people = new Person[capacity];
			for(int i = 0; i < capacity; i++) {
				people[i] = new Person();
			}
			for(int i = 0; i < capacity; i++) {
			
				people[i].setPerson(i+1);
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
		
		public T getFront() {//returns the front of the queue
			if(isEmpty()) {
				return null;
			}
			
			return Queue[front];
		}
		
		public T getBack() {//returns the back of the queue
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
		
		public void sortByName() {//easy call for sorting algorithm and pass correct parameters to the nameQuicksort
			nameQuicksort(people, Queue, 0, people.length -1);
		}

		public void nameQuicksort(Person[] array, T[] queue, int lowIndex, int highIndex) {//QuickSort method for lastName
		
			if(lowIndex >= highIndex) {//if the array to be sorted has only one element no need to sort and end to recursion
				return;
			}
		
			//Lines 102-104 are to choose a random pivot point and then swap the pivot to be at the highIndex.
			int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
			String pivot = array[pivotIndex].getLastName(); 
			swap(array, queue, pivotIndex, highIndex);
		
			int leftPointer = namePartition(array, queue, lowIndex, highIndex, pivot);//method for comparing the values to determine when to partition
			swap(array, queue, leftPointer, highIndex);
		
			nameQuicksort(array, queue, lowIndex, leftPointer -1);//Recursive calls to continue sorting right and left of pivot until base case is reached
			nameQuicksort(array, queue, leftPointer + 1, highIndex);
		}

		//Person array is used for actual value comparisons for sorting and then sorting is done to the queue of people based off the corresponding index
		public int namePartition(Person[] array, T[] queue, int lowIndex, int highIndex, String pivot) {//method for comparing the values to determine when to partition
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
			
			swap(array, queue, leftPointer, rightPointer);
			
			}
		return leftPointer;
		}

		public void swap(Person[] array, T[] queue, int index1, int index2) {//method used to swap elements
			T temp = queue[index1];
			queue[index1] = queue[index2];
			queue[index2] = temp;
			
			Person temp1 = array[index1];
			array[index1] = array[index2];
			array[index2]= temp1;
		}	
	
		public void sortByAge() {//easy call for sorting algorithm and pass correct parameters to the ageQuicksort
			ageQuicksort(people, Queue, 0, people.length -1);
		}
		
		public void ageQuicksort(Person[] array, T[] queue, int lowIndex, int highIndex) {//QuickSort method for lastName
		
			if(lowIndex >= highIndex) {//if the array to be sorted has only one element no need to sort and end to recursion
				return;
			}
		
			//Lines 234-236 are to choose a random pivot point and then swap the pivot to be at the highIndex.
			int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
			int pivot = array[pivotIndex].getAge(); 
			swap(array, queue, pivotIndex, highIndex);
		
			int leftPointer = agePartition(array, queue, lowIndex, highIndex, pivot);//method for comparing the values to determine when to partition
			swap(array, queue, leftPointer, highIndex);
		
			ageQuicksort(array, queue, lowIndex, leftPointer -1);//Recursive calls to continue sorting right and left of pivot until base case is reached
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
		
				swap(array, queue, leftPointer1, rightPointer1);
		
			}
			return leftPointer1;
		}

	}
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Person person = new Person();
		
		Person.Queue<String> list = person.new Queue<String>();
		
		System.out.println("How many people would you like to add to your queue to be sorted?");
		int numPeople = scnr.nextInt();
		
		System.out.println("Enter the names of " + numPeople + " people to add to the list. \nThe format to add a person's info as follows: "
				+ "First Name -> Last Name -> Age \n(Separate by a single space)");
		
		
		list.settingQueue(numPeople);//Setting the capacity of queue to 5
			
			
		System.out.println("The Queue of people unsorted:");
		list.print();//Displaying queue unsorted
		System.out.println("-------------------------");
		
		System.out.println("The Queue of people sorted by last name:");
		list.sortByName();//Sorting queue by last name
		list.print();//Displaying queue sorted by last name
		System.out.println("-------------------------");
		
		System.out.println("The Queue of people sorted by age:");
		list.sortByAge();//Sorting queue by age
		list.print();//Displaying Queue sorted by age
		System.out.println("-------------------------");
		System.out.println("Program ended.");
		scnr.close();
	}	

}
