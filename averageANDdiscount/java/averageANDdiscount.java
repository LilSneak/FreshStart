package averageANDdiscount.java;

import java.util.Scanner;
public class averageANDdiscount {

	public static void main(String[] args) {

			Scanner scnr = new Scanner(System.in);
			
			Bills got = new Bills();
			
			System.out.println("Enter the cost of weekly groceries for the past 4 weeks. Separate the different week totals by a space.");
		
				got.userBills[0] = scnr.nextDouble();
				got.userBills[1] = scnr.nextDouble();
				got.userBills[2] = scnr.nextDouble();
				got.userBills[3] = scnr.nextDouble();
		 //Looping to input bills into array

		 double discount = 0;
			
			if (got.userBills[3] > 0) {
				
			System.out.println("How much is coupon discount? (Enter percentage as a decimal): ");
					discount = scnr.nextDouble();
			}	//getting discount # from input
			
			double aWeek = got.calculateWeek();
			double aMonth = got.calculateMonth();
			if (discount > 0) {
			
				System.out.println("You spent a weekly average of $ " + aWeek);
			
			
				System.out.println("You spent a monthly average of $ " + aMonth);
			}
			double couponMonth = aMonth - (aMonth * discount);
			double couponWeek = aWeek - (aWeek * discount);
			System.out.println("You would have spent a weekly average of $ " + couponWeek + " if coupon was used");
			System.out.println("You would have spent a monthly average of $ " + couponMonth+ " if coupon was used");
		//getting values for weekly and monthly average 

					
			scnr.close();

	}

}