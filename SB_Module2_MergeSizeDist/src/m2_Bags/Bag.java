package m2_Bags;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//UPDATED CODE!!!! WITH CORRECTIONS AND FEEDBACK
//I implemented feedback by using a HashMap instead of an ArrayList implementation. As a result my code has the ability to perform better.
//Also used the equals method instead of comparing the quality of an element (==). 

public class Bag<T>{
	
	private int count;
	
	private int values = 0;
	private HashMap<Integer, T> mergedBag;
	//private ArrayList<T> bag;
	private HashMap<Integer, T> bag;
	
	public Bag() {//Constructor method to initialize the bag with no finite size
		bag = new HashMap<>();
	}
	
	public void add(T newItem) { //Adding a new item to the bag
		bag.put(values, newItem);
		values++;
	}
	
	public void remove(T item) {//Removing a certain item
		
				bag.remove(item);
			
	}
	
	public int size() {//Shows how many items are in the bag
		return bag.size();
	}
	
	public int count(T searchItem) {//gets the frequency of a certain item
		count = 0;//variable is set to 0
		
		for(T item: bag.values()){//int i = 0; i < bag.size(); i ++) {//Iterating through bag
			if(bag.get(item).equals(searchItem)) {//Seeing if the current element matches the target item. (UPDATED TO IMPLEMENT THE EQUALS METHOD)!!!
				count++;//Increases when target is found
			}
		}
		return count;//frequency is then returned.
	}
	
	public Boolean contains(T anItem) {
		
		if(bag.containsValue(anItem)) {//Seeing if the current element matches the target item. (UPDATED TO IMPLEMENT THE EQUALS METHOD)!!!
				return true;//confirms that item is in bag, ends loop, and returns a true value.
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
			
				System.out.print(bag.values());//Prints out the current element
		}
		else {
			System.out.println("Bag is Empty");//Prints out a statement to let user know the bag is empty
		}
	}
	public HashMap<Integer, T> merge(HashMap<Integer, T> bag2) {
		Bag<T> temp = new Bag<T>();
		
		bag2.putAll(temp.bag);
		
		for(T item: bag.values()){//int i = 0; i < bag.size(); i ++) {//Iterating through bag
			temp.add(item);
		}
		values = 55;//used to randomize keys.
		for(T item: bag2.values()){//int i = 0; i < bag.size(); i ++) {//Iterating through bag
			temp.add(item);
		}
		mergedBag = temp.bag;
		return temp.bag;
	}
	
	public Bag<T> distinct() {
		Bag<T> distinctOnly = new Bag<T>();
		
		Set<T> unique = new HashSet<T>();
		
		for(T item: mergedBag.values()) {
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
		System.out.println("Bag One and Two Merged Together:" + colorBag1.merge(colorBag2.bag));
		
		//Printing out merged bag
		
		System.out.println("");
		
		//Method called to find the distinct variables of the merged bag and then print the returned value which is a another bag
		System.out.println("Merged List with only distinct colors:");
		colorBag1.distinct().printBag();
		
	}

}
