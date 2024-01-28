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
	String uodateWhat;
	
	public void displayVehicle(String carMake) {
		for(int i = 0; i < autoMake.size(); ++i) {
			if(autoMake.get(i).equalsIgnoreCase(carMake)) {
				System.out.println(autoMake.get(i) + " " + autoModel.get(i) + " " + autoColor.get(i) + " " + autoYear.get(i));
				System.out.println("All Cars found");
				break;
			}
		}
	}
	
	public void updateVehicle(String carMake, String carModel, String carColor, String carYear) {
		for(int i = 0; i < autoMake.size(); ++i) {
			if(autoMake.get(i).equalsIgnoreCase(carMake)) {
				autoMake.set(i, carMake);
				autoModel.set(i, carModel);
				autoColor.set(i, carColor);
				autoYear.set(i, carYear);
				System.out.println("Update Complete.");
			}
		}

	}
}
