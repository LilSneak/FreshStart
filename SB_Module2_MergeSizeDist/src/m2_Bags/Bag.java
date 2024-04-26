package m2_Bags;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Bag<T>{
	
		//count variable is used to count the frequency of an element in the ArrayList
	private int count;
		//Using an Arraylist due to its ability to keep expanding its size as elements are added
	private ArrayList<T> bag;
	
	public Bag() {//Constructor method to initialize the bag with no finite size
		bag = new ArrayList<T>();
	}
	
	public void add(T newItem) { //Adding a new item to the bag
		bag.add(newItem);
	}
	
	public Boolean remove(T item) {//Removing a certain item
		for(int i = 0; i < bag.size(); i ++) {//Iterating through bag
			if(bag.get(i)== item) {//Seeing if the current element matches the target item
				bag.remove(i);
				
				return true;//Returns true that an occurrence of the item was found. And breaks the for loop 
			}
		}
		return false;// item was not successfully removed
	}
	
	public int size() {//Shows how many items are in the bag
		return bag.size();
	}
	
	public int count(T searchItem) {//gets the frequency of a certain item
		count = 0;//variable is set to 0
		
		for(int i = 0; i < bag.size(); i ++) {//Iterating through bag
			if(bag.get(i) == searchItem) {//Seeing if the current element matches the target item
				count++;//Increases when target is found
			}
		}
		return count;//frequency is then returned.
	}
	public Boolean contains(T anItem) {
		for(int i = 0; i < bag.size(); i ++) {//Iterating through bag
			if(bag.get(i) == anItem) {//Seeing if the current element matches the target item
				return true;//confirms that item is in bag, ends loop, and returns a true value.
			}
		}
		return false;//item was not found
	}
	private Boolean isEmpty() {//Checking if the bag is empty
		if(size() > 0) {//Uses the bag's size to return a boolean value
			return false; 
		}
		return true;
	}
	
	public void printBag() {//Print out the contents of the bag
		if(isEmpty() == false) {//Uses the isEmpty method to determine if there is anything in the bag to print
			for(int i = 0; i < bag.size(); i ++) {//Iterating through bag
				System.out.print(bag.get(i) + " ");//Prints out the current element
			}
			System.out.println("");
		}
		else {
			System.out.println("Bag is Empty");//Prints out a statement to let user know the bag is empty
		}
	}
	public void merge(Bag<T> newBag) {
		for(T item: newBag.bag) {
			bag.add(item);
		}
	}
	public Bag<T> distinct() {
		Bag<T> distinctOnly = new Bag<T>();
		
		Set<T> unique = new HashSet<T>();
		
		for(T item: bag) {
			if(unique.add(item) == true) {
				distinctOnly.add(item);
			}
		}
		return distinctOnly;
	}



	public static void main(String[] args) {
		
		Bag<String> colorBag1 = new Bag<String>();//Creating an instance of the bag class passing in type String
		//Adding several colors to my bag of colors
		colorBag1.add("Green");
		colorBag1.add("Red");
		colorBag1.add("Orange");
		colorBag1.add("Blue");
		colorBag1.add("Red");
		colorBag1.add("Blue");
		colorBag1.add("Green");
		colorBag1.add("Blue");
		colorBag1.add("Green");
		colorBag1.add("Green");
		
		Bag<String> colorBag2 = new Bag<String>();//Creating an instance of the bag class passing in type String
		//Adding several colors to my bag of colors
		colorBag2.add("Purple");
		colorBag2.add("Purple");
		colorBag2.add("Purple");
		colorBag2.add("Pink");
		colorBag2.add("Yellow");
		colorBag2.add("Green");
		
		//Printing out bag1 contents
		System.out.println("Bag One Contains the following colors:");
		colorBag1.printBag();
		//Printing out the bag size
		System.out.println("Bag One Size: " + colorBag1.size()+ "\n");
		
		//Printing out bag2 contents
		System.out.println("Bag Two Contains the following colors:");
		colorBag2.printBag();
		//Printing out bag2 size
		System.out.println("Bag Two Size: " + colorBag2.size()+ "\n");
		System.out.println("");
		
		//Method call to merge bag1 and ba2
		colorBag1.merge(colorBag2);
		System.out.println("Bag One and Two Merged Together:");
		//Printing out merged bag
		colorBag1.printBag();
		System.out.println("");
		
		//Method called to find the distinct variables of the merged bag and then print the returned value which is a another bag
		System.out.println("Merged List with only distinct colors:");
		colorBag1.distinct().printBag();
		
	}

}
