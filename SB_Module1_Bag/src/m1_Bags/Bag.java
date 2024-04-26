package m1_Bags;


import java.util.HashMap;

public class Bag<T>{
	//UPDATED. Get old version from git or uploaded assignment WARNINGGGGG DELETE LATER
		
	private int count;//count variable is used to count the frequency of a value
	private int key; //used to create key's as an item is added to bag
	
		
	private HashMap<Integer, T> bag;
	
	public Bag() {//Constructor method to initialize the bag with no finite size
		bag = new HashMap<>();
	}
	
	public void add(T newItem) { //Adding a new item to the bag
		bag.put(key, newItem);
		key++;
	}
	
	public Boolean remove(T item) {//Removing a certain item
		if(contains(item)) {
			bag.values().remove(item);
			return true;//Returns true that item was found and deleted.
		}

		return false;// item was not successfully removed
	}
	
	private int getBagSize() {//Shows how many items are in the bag
		return bag.size();
	}
	
	public int count(T searchItem) {//gets the frequency of a certain item
		count = 0;//variable is set to 0
		
		for(T searchable: bag.values()) {//Iterating through bag
			if(searchable == searchItem) {//Seeing if the current element matches the target item
				count++;//Increases when target is found
			}
		}
		return count;//frequency is then returned.
	}
	public Boolean contains(T anItem) {
		for(T item: bag.values()) {//Iterating through bag
			if(item == anItem) {//Seeing if the current element matches the target item
				return true;//confirms that item is in bag, ends loop, and returns a true value.
			}
		}
		return false;//item was not found
	}
	private Boolean isEmpty() {//Checking if the bag is empty
		if(getBagSize() > 0) {//Uses the bag's size to return a boolean value
			return false; 
		}
		return true;
	}
	
	public void printBag() {//Print out the contents of the bag
		if(isEmpty() == false) {//Uses the isEmpty method to determine if there is anything in the bag to print
			for(T item: bag.values()) {//Iterating through bag
				System.out.print(item + " ");//Prints out the current element
			}
			System.out.println("");
		}
		else {
			System.out.println("Bag is Empty");//Prints out a statement to let user know the bag is empty
		}
	}
	
	
}
