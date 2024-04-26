package M2_Sample;


public class sampleArray {

	public static void main(String[] args) {
		
		String[] colors = {"Green", "Blue", "Grey", "Yellow"};//Initializing the size and adding values to the list.
		
			colors[3] = "Black"; //This command changes the value already assigned.
		
		for(int i=0; i < colors.length; i++) {//this loop shows how you can access each element at its specific index
			System.out.println(colors[i]);//Printing out the element from the current index integer
		}
		
		System.out.println("");
		//Example initializing the size of the array and assigning elements to the list later.
		
		String[] colors2 = new String[5];//Setting the array's capacity to 5.
			colors2[0] = "Purple";//Assigning values to the available spaces.
			colors2[1] = "Pink";
			colors2[4] = "Red";
		
		for(String color: colors2) {//using a for each loop
			System.out.println(color); //printing the variable that has the current element assigned to it.
		}
	}

}
