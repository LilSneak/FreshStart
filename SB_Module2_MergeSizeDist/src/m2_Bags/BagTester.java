package m2_Bags;

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
		
		Bag newBagOfColors = new Bag();
		newBagOfColors.add("Purple");
		newBagOfColors.add("Purple");
		newBagOfColors.add("Purple");
		newBagOfColors.add("Pink");
		newBagOfColors.add("Yellow");
		newBagOfColors.add("Green");
		
		//Printing out the bag contents
		System.out.println("Bag One Contains the following colors:");
		bagOfColors.printBag();
		System.out.println("Bag One Size: " + bagOfColors.size()+ "\n");
		
		System.out.println("Bag Two Contains the following colors:");
		newBagOfColors.printBag();
		System.out.println("Bag Two Size: " + newBagOfColors.size()+ "\n");
		
		System.out.println("");
		bagOfColors.merge(newBagOfColors);
		System.out.println("Bag One and Two Merged Together:");
		bagOfColors.printBag();
		System.out.println("");
		
		System.out.println("Merged List with only distinct colors:");
		bagOfColors.distinct().printBag();
		
		
		
	}

}
