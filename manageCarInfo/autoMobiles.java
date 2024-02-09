package manageCarInfo;

import java.util.Scanner;
import java.util.ArrayList;

public class autoMobiles {
	private String make;
	private String model;
	private String color;
	private String year;
	private int carNum;
	private int numOfCars;
	
	Scanner scnr = new Scanner(System.in);
	ArrayList<String> autoMake = new ArrayList<String>();
	ArrayList<String> autoModel = new ArrayList<String>();
	ArrayList<String> autoColor = new ArrayList<String>();
	ArrayList<String> autoYear = new ArrayList<String>();
	
	public void autoMobiles() {
		make = "None";
		model = "None";
		color = "None";
		year = "None";
		carNum = 0;
		
		printCar(carNum, make, model, color, year);
	
	}
	
		
	public void addVehicle(String carMake, String carModel, String carColor, String carYear) {
		autoMake.add(carMake);
		autoModel.add(carModel);
		autoColor.add(carColor);
		autoYear.add(carYear);
		
	}
	public void getInventory() {
		numOfCars = 0;
		for(int i = 0; i < autoMake.size(); ++i) {
			make = autoMake.get(i);
			model = autoModel.get(i);
			color = autoColor.get(i);
			year = autoYear.get(i);
			carNum = i;
			printCar(carNum, make, model, color, year);
			
			numOfCars++;
		}
		System.out.println("All Cars Displayed.");
		printCarsTotal(numOfCars);
	}
	private void printCar(int carNum, String carMake, String carModel, String carColor, String carYear) {
		System.out.println("Car " + (carNum + 1) + ":");
		System.out.println("\t Make: " + carMake);
		System.out.println("\t Model: " + carModel);
		System.out.println("\t Color: " + carColor);
		System.out.println("\t Year: " + carYear);
	}
	
	public void displayVehicle(int whichCar) {
		carNum = whichCar - 1;
		if(carNum >= 0 && carNum < autoMake.size()) {
			make = autoMake.get(carNum);
			model = autoModel.get(carNum);
			color = autoColor.get(carNum);
			year = autoYear.get(carNum);
				
			printCar(carNum, make, model, color, year);
			
			System.out.println("Car found");
		}
		else {
			System.out.println("Car not found on list.");
		}
	}
	
	public void updateVehicle(int whichCar, String whatUpdate, String update) {
		carNum = whichCar - 1;
		switch(whatUpdate){
		
			case ("Make"):
				autoMake.set(carNum, update);
			break;
			
			case("Model"):
				autoModel.set(carNum, update);
			break;
			
			case("Color"):
				autoColor.set(carNum, update);
			break;
			
			case("Year"):
				autoYear.set(carNum, update);
			break;
		}
		System.out.println("Update Complete.");
	}
	
	public void removeVehicle(int whichCar) {
		carNum = whichCar - 1;
		
		autoMake.remove(carNum);
		autoModel.remove(carNum);
		autoColor.remove(carNum);
		autoYear.remove(carNum);
		System.out.println("Removal Complete.");
				
		numOfCars = autoMake.size();	
		printCarsTotal(numOfCars);
	}
	private void printCarsTotal(int numOfCars) {
		this.numOfCars = numOfCars;
		System.out.println("Total Number of Cars Now: " + this.numOfCars);
	}
}
	

