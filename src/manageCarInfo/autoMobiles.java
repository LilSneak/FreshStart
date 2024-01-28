package manageCarInfo;

import java.util.Scanner;
import java.util.ArrayList;

public class autoMobiles {
	Scanner scnr = new Scanner(System.in);
	ArrayList<String> autoMake = new ArrayList<String>();
	ArrayList<String> autoModel = new ArrayList<String>();
	ArrayList<String> autoColor = new ArrayList<String>();
	ArrayList<String> autoYear = new ArrayList<String>();
	
	public void addVehicle(String carMake, String carModel, String carColor, String carYear) {
		autoMake.add(carMake);
		autoModel.add(carModel);
		autoColor.add(carColor);
		autoYear.add(carYear);
	}
	
	int carFoundAt;
	
	public void displayVehicle(String carMake) {
		for(int i = 0; i < autoMake.size(); ++i) {
			if(autoMake.get(i).equalsIgnoreCase(carMake)) {
				int carFoundAt = i;
				System.out.println(autoMake.get(i) + " " + autoModel.get(i) + " " + autoColor.get(i) + " " + autoYear.get(i));
			}
		}
		System.out.println("All Cars found");
	}
}
