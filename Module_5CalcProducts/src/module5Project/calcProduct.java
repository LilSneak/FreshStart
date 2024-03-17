package module5Project;

import java.util.Scanner;

public class calcProduct {
	
	public static int productOfNums(int[] array, int n) {
		
		if(n <= 0) {
			return 1;
		}
		else {
			return productOfNums(array, n-1) * array[n-1];
		}
	}
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int[] arrayNums = new int[5];
	
		do {
			System.out.println("To start PRODUCT program enter any key. Or enter \"Done\" to end program");
			
			String userInput = scnr.next();
				if (userInput.equalsIgnoreCase("Done")) {
					break;
				}
				else {
					System.out.println("Enter 5 numbers you want the product of");

					for (int i = 0; i < 5; i++) {
						arrayNums[i] = scnr.nextInt();
					}
					
					System.out.println("\nProduct of all 5 numbers: " + productOfNums(arrayNums, arrayNums.length)+ "\n");
				}
		}while(true);
		scnr.close();
	}
}
