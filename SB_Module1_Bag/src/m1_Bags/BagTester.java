package m1_Bags;

public class BagTester {

	public static void main(String[] args) {
		Bag bagOfColors = new Bag();//Creating an instance of the bag class
		
		//Adding several colors to my bag of colors
		bagOfColors.add("Green");
		bagOfColors.add("Red");
		bagOfColors.add("Orange");
		bagOfColors.add("Blue");
		bagOfColors.add("Red");
		bagOfColors.add("Blue");
		bagOfColors.add("Green");
		bagOfColors.add("Blue");
		bagOfColors.add("Green");
		bagOfColors.add("Green");
		
		//Printing out the bag contents
		System.out.println("Bag Contains the following colors: ");
		bagOfColors.printBag();
		
		//Testing the contains method
		System.out.println("\nIs the color Red in the bag? " + bagOfColors.contains("Red"));
		System.out.println("Is the color Orange in the bag? " + bagOfColors.contains("orange"));
		System.out.println("Is the color Yellow in the bag? " + bagOfColors.contains("Yellow"));
		System.out.println("Is the color pink in the bag?  " + bagOfColors.contains("Pink"));
		
		//Testing the count method
		System.out.println("\nHow many Reds are in the bag? " + bagOfColors.count("Red"));
		System.out.println("How many Purples are in the bag? " + bagOfColors.count("Purples"));
		System.out.println("How many Greens are in the bag? " + bagOfColors.count("green"));
		System.out.println("How many Blues are in the bag? " + bagOfColors.count("Blue"));
		
		//Testing the remove method
		System.out.println("\nWas the removal of \"Orange\" succesful? " + bagOfColors.remove("Orange"));
		System.out.println("Was the removal of \"White\" succesful? " + bagOfColors.remove("White"));
		
		//Printing out the bag contents
		System.out.println("\nBag Contains the following colors: ");
		bagOfColors.printBag();
		
		//Testing the contains method after removal method
		System.out.println("\nIs the color Orange in the bag? " + bagOfColors.contains("Orange"));
		
		//Testing the count method after removal method
		System.out.println("\nHow many Oranges are in the bag? " + bagOfColors.count("Orange"));
		
		
	}

}
