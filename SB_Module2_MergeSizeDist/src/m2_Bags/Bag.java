package m2_Bags;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Bag{
	
		//count variable is used to count the frequency of an element in the ArrayList
	private int count;
		//Using an Arraylist due to its ability to keep expanding its size as elements are added
	private ArrayList<String> bag;
	
	public Bag() {//Constructor method to initialize the bag with no finite size
		bag = new ArrayList<String>();
	}
	
	public void add(String newItem) { //Adding a new item to the bag
		bag.add(newItem);
	}
	
	public Boolean remove(String item) {//Removing a certain item
		for(int i = 0; i < bag.size(); i ++) {//Iterating through bag
			if(bag.get(i).equalsIgnoreCase(item)) {//Seeing if the current element matches the target item
				bag.remove(i);
				
				return true;//Returns true that an occurrence of the item was found. And breaks the for loop 
			}
		}
		return false;// item was not successfully removed
	}
	
	public int size() {//Shows how many items are in the bag
		return bag.size();
	}
	
	public int count(String searchItem) {//gets the frequency of a certain item
		count = 0;//variable is set to 0
		
		for(int i = 0; i < bag.size(); i ++) {//Iterating through bag
			if(bag.get(i).equalsIgnoreCase(searchItem)) {//Seeing if the current element matches the target item
				count++;//Increases when target is found
			}
		}
		return count;//frequency is then returned.
	}
	public Boolean contains(String anItem) {
		for(int i = 0; i < bag.size(); i ++) {//Iterating through bag
			if(bag.get(i).equalsIgnoreCase(anItem)) {//Seeing if the current element matches the target item
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
	public void merge(Bag newBag) {
		for(String item: newBag.bag) {
			bag.add(item);
		}
	}
	public Bag distinct() {
		Bag distinctOnly = new Bag();
		
		Set<String> unique = new HashSet<String>();
		
		for(String item: bag) {
			if(unique.add(item) == true) {
				distinctOnly.add(item);
			}
		}
		return distinctOnly;
	}
}
