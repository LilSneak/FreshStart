package monthlyYearlyTemperatures;

import java.util.Scanner;

public class ManageMonthData {
	Scanner scnr = new Scanner(System.in);
	
	String [] months = {"January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December"};
	
	int[] TempMonthly = {48, 48, 54, 59, 66, 71, 78, 79, 71, 60, 52, 46};
	
	int counter = 0;// to determine index of the month user chose.
	
	public int findMonth() {
		String userMonth = scnr.next();
		
		for(String monthName : months) {
			if (monthName.equalsIgnoreCase(userMonth)) {
				System.out.print("For " + monthName);
				break;//stopping loop when month i array matches what the user chose
			}
			counter++;
		}
		
		System.out.println(" the average temperature is " + TempMonthly[counter] + " degrees Farenheit.");
		return counter;
	}
}
