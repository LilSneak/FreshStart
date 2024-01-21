package monthlyYearlyTemperatures;

public class ManageYearlyData {
	int maxTemp = 0;
	int currentTemp = 0;
	int total = 0;
	
	public void YearlyInfo() {
		
		System.out.println("Temperature Averages for each month in the year:");
		System.out.println();
		ManageMonthData getArrays = new ManageMonthData();
		
		int minTemp = getArrays.TempMonthly[0];// getting value for first temperature value
		String maxMonth = null;
		String minMonth = null;
		
		for(int i = 0; i < getArrays.months.length; i++) {
			System.out.println("\t" + getArrays.months[i] + ": " + getArrays.TempMonthly[i] + " degrees Ferenheit");
			currentTemp = getArrays.TempMonthly[i];
			
			if(currentTemp > maxTemp) {// maximum temperature
				maxTemp = currentTemp;
				maxMonth = getArrays.months[i];
			}
			if (currentTemp < minTemp) {//minimum temperature
				minTemp = currentTemp;
				minMonth = getArrays.months[i];
			}
			total = total + currentTemp;//for average yearly temperature
		}
		System.out.println();
		System.out.println("Warmest Monthly Temperature: " + maxTemp + " degrees Ferenheit " + "in the month of " + maxMonth);
		System.out.println("Coldest Monthly Temperature: " + minTemp + " degrees Ferenheit " + "in the month of " + minMonth);
		System.out.println("Yearly average Temperature for Seattle: " + total/12 + " degrees Ferenheit");
	}
}