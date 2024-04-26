package billCalculations;

import java.util.Scanner;

public class Bills {
		Scanner scnr = new Scanner(System.in);
		
		public double[] userBills = new double[4];
		
		
		double averageWeek;
		double averageMonth;
		
		public void setBillsToList() {
			for(int i = 0; i < userBills.length; ++i) {
				userBills[i] = scnr.nextDouble();
			}
		}
		
		public double calculateWeek() {
			
			averageWeek = (userBills[0] + userBills[1] +  userBills[2] +  userBills[3]) / 4;
			
			return averageWeek;
		 }
		
		public double calculateMonth() {

			averageMonth = (userBills[0] + userBills[1] +  userBills[2] +  userBills[3]);
			
			return averageMonth;
		}

		
		

	}
