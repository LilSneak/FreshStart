package billCalculations;

import java.util.Scanner;

public class mainDiscount {

		public static void main(String[] args) {

				Scanner scnr = new Scanner(System.in);
				
				Bills got = new Bills();
				
				System.out.println("Enter the cost of weekly groceries for the past 4 weeks. Separate the different week totals by a space.");
			
				got.setBillsToList();
				
			 //assigning each input to the array in class "Bills"

			 double discount = 0;
				
				if (got.userBills[3] > 0) { // only after 4 bill totals are entered will this line print
					
				System.out.println("How much is coupon discount? (Enter percentage as a decimal): ");
						discount = scnr.nextDouble();
				}	//getting discount # from input
				
				double aWeek = got.calculateWeek();
				double aMonth = got.calculateMonth();
				//getting weekly and monthly averages from methods in "Bills" class.
				
				double couponMonth = aMonth - (aMonth * discount);
				double couponWeek = aWeek - (aWeek * discount);
				//getting averages with discount applied
				
				if (discount > 0) { //only after discount is received from user will these lines print
				
					System.out.printf("You spent a weekly average of $%.2f\n", aWeek);
					System.out.printf("You spent a monthly average of $%.2f\n", aMonth);
					
					System.out.printf("You would have spent a weekly average of $%.2f if coupon was used\n", couponWeek);
					System.out.printf("You would have spent a monthly average of $%.2f if coupon was used\n", couponMonth);
				}

				scnr.close();

		}

	}
