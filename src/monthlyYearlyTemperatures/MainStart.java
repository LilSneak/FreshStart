package monthlyYearlyTemperatures;

import java.util.Scanner;

public class MainStart {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("The following program is based on the location of Seattle, Wa");
		System.out.print("Enter month name to get it's average temperature:");
		
		ManageMonthData getMonthInfo = new ManageMonthData();
		getMonthInfo.findMonth();//Calling findMonth Method
		
		System.out.println();
		System.out.println("For temperature averages for the whole year enter \"year\".");
		String wantYear = scnr.next();//Getting user input to continue program
		
		ManageYearlyData getYearly = new ManageYearlyData();
		
		if(wantYear.equalsIgnoreCase("year")) {
			getYearly.YearlyInfo();// checking for user input to run YearlyInfo Method
		}
		scnr.close();
	}
}
