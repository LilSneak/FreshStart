package queueAndQuicksortPerson;

import java.util.Random;
import java.util.Scanner;

import queueAndQuicksortPerson.Person.Queue;

public class programStart {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Person person = new Person();
		
		Person.Queue<String> list = person.new Queue<String>();
		
		//Queue<String> printableQueue = new Queue<String>();
		//Queue<String> lastNames = new Queue<String>();
		//Queue<Integer> ages = new Queue<Integer>();
		System.out.println("Enter the names of 5 people to add to the list. \nThe format to add a person's info as follows: "
				+ "First Name -> Last Name -> Age \n(Separate by a single space)");
		
			//lastNames.enqueue(person.getLastName());
			//ages.enqueue(person.getAge());
			list.settingQueue(2);
			
			//printableQueue.enqueue(person.getInfo());
		
		list.print();
		
		list.sortByName();
		list.print();
		list.sortByAge();
		
		list.print();
		//System.out.println("List of People: ");
		//printableQueue.print();
		
		//nameQuicksort(lastNames.Queue, lastNames.front, lastNames.back);
	
		//lastNames.print();	
	}	
}	
	
//public static void nameQuicksort(String[] array, int lowIndex, int highIndex) {//QuickSort method for lastName
	
	//if(lowIndex >= highIndex) {//if the array to be sorted has only one element no need to sort and end to recursion
		//return;
	//}
	
	//Lines 102-104 are to choose a random pivot point and then swap the pivot to be at the highIndex.
	//int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
	//String pivot = array[pivotIndex]; //((Person) Queue[pivotIndex]).getLastName();
	//swap(array, pivotIndex, highIndex);
	
	//int leftPointer = partition( array, lowIndex, highIndex, pivot);//method for comparing the values to determine when to partition
//	swap(array, leftPointer, highIndex);
	
	//nameQuicksort(array, lowIndex, leftPointer -1);
	//nameQuicksort(array, leftPointer + 1, highIndex);
//}//

//private static void swap(String[] array, int pivotIndex, int highIndex) {
	// TODO Auto-generated method stub
	
//}
