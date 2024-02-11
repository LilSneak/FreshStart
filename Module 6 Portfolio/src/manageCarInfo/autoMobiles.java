package manageCarInfo;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class autoMobiles {
	private String make;
	private String model;
	private String color;
	private int year;
	private int mileage;
	private int carNum;
	private int numOfCars;
	private String isDone = "Process Not Complete!";
	private String fileName;
	private String formattedCarPrint;
	private String updateString;
	private int updateInteger;
	
	Scanner scnr = new Scanner(System.in);
	ArrayList<String> autoMake = new ArrayList<String>();
	ArrayList<String> autoModel = new ArrayList<String>();
	ArrayList<String> autoColor = new ArrayList<String>();
	ArrayList<Integer> autoYear = new ArrayList<Integer>();
	ArrayList<Integer> autoMileage = new ArrayList<Integer>();
 	
	public void autoMobiles() {//default for when an empty inventory is trying to save
		make = "None";
		model = "None";
		color = "None";
		year = 0;
		mileage = 0;
		carNum = 0;
	}
	
		
	public int autoMobiles(String carMake, String carModel, String carColor, int carYear, int carMileage) {//adding car attributes to arrayLists
		try {
			if(carYear > 2025 || carYear < 1900) {
				throw new Exception("Year of car is invalid.");
			}
			if(carMileage <= 0 || carMileage > 500000) {
				throw new Exception("Mileage is invalid.");
			}
			autoMake.add(carMake);
			autoModel.add(carModel);
			autoColor.add(carColor);
			autoYear.add(carYear);
			autoMileage.add(carMileage);
		
			numOfCars = autoMake.size();
			System.out.println("Adding Complete.\n");
		
		}catch(Exception a) {
			System.out.println(a.getLocalizedMessage());
			System.out.println("Could not add vehicle. Try again.\n");
		}
		return numOfCars;
	}
	
		
	public void getInventory() {//This loops through arrayLists for printing
		try {
			numOfCars = 0;
			if(autoMake.size() == 0) {
				throw new Exception("No vehicles in inventory"); //Empty inventory.
			}
			for(int i = 0; i < autoMake.size(); ++i) {
				make = autoMake.get(i);
				model = autoModel.get(i);
				color = autoColor.get(i);
				year = autoYear.get(i);
				mileage = autoMileage.get(i);
			
				carNum = i;
				printCar(carNum, make, model, color, year, mileage);
			
				numOfCars++;
			}
		
			printCarsTotal(numOfCars);
		}catch (Exception a) {
			System.out.println(a.getMessage());
			System.out.println("Select Add option to add to inventory.\n");
		
		}
	}
	
	private String printCar(int carNum, String carMake, String carModel, String carColor, int carYear, int carMileage){//Prints cars with attributes in formatted way
		formattedCarPrint = "\nCar " + (carNum + 1) + ": \n\t Make: " + carMake +" \n\t Model: " + carModel +
				"\n\t Color: " + carColor + "\n\t Year: " + carYear + "\n\t Mileage: " + carMileage;
		
		System.out.println(formattedCarPrint);
		return formattedCarPrint;
	}
	
	
		public String updateVehicleInteger(int whichCar, String whatUpdate) {//Update a specific vehicle's year or mileage
			isDone = "Process Not Complete!";
			carNum = whichCar - 1;
			try {
				if(carNum < 0 || carNum >= autoMake.size()-1) {//Making sure chosen car is within list size
					throw new Exception("No Car is available by that List number.\n");
				}
				switch(whatUpdate){//Choose between the 2 integer arraylist
					case("Year"):
						System.out.println("Enter your new input");
					
						updateInteger = scnr.nextInt();
						if(updateInteger > 2025 || updateInteger < 1900) {//Makes sure year is a valid or reasonable one
							throw new Exception("Year of car is invalid.");
						}
						
						autoYear.set(carNum, updateInteger);
						isDone = "Update Complete!";
					break;
					case("Mileage"):
						System.out.println("Enter your new input");
					
						updateInteger = scnr.nextInt();
						if(updateInteger <= 0 || updateInteger > 500000) {//Makes sure mileage is valid or reasonable
							throw new Exception("Mileage is invalid.");
						}
						
						autoMileage.set(carNum, updateInteger);
						isDone = "Update Complete!";
					break;
					default:
						throw new Exception("Invalid update request. Reminder: options are case-sensitive");
				}
			}catch(Exception excpt) {
				System.out.println(excpt.getMessage());	
				System.out.println("Can not complete update request.");
			}
			return isDone;
		}
		
	public String updateVehicleString(int whichCar, String whatUpdate) {//Update a specific vehicle's make, model, or color
		isDone = "Process Not Complete!";
		carNum = whichCar - 1;
		
		try {
			switch(whatUpdate){
		
				case ("Make"):
					System.out.println("Enter your new input");
					updateString = scnr.next();
					autoMake.set(carNum, updateString);
				break;
			
				case("Model"):
					System.out.println("Enter your new input");
					updateString = scnr.next();
					autoModel.set(carNum, updateString);
				break;
			
				case("Color"):
					System.out.println("Enter your new input");
					updateString = scnr.next();
					autoColor.set(carNum, updateString);
				break;
				
				default://IF Make, Model, or Color isn't entered then its not a valid input
					throw new Exception("Invalid update request. Reminder: options are case-sensitive");
			}
			
			isDone = "Update Completed";
		} catch (Exception excpt) {
			System.out.println(excpt.getMessage());	
		}
		return isDone;
	}
	
	public int removeVehicle(int whichCar) {//removes a specific vehicle from list
		carNum = whichCar - 1;
		try {
			if(carNum < 0 || carNum >= autoMake.size()-1) {//Checks if there are any cars in inventory
				throw new Exception("No Car is available by that List number.\n");
			}
			autoMake.remove(carNum);
			autoModel.remove(carNum);
			autoColor.remove(carNum);
			autoYear.remove(carNum);
			autoMileage.remove(carNum);
		
		System.out.println("Removal Complete.\n");
		numOfCars = autoMake.size();	
		} catch(Exception b) {
			System.out.println(b.getLocalizedMessage());
		}
		return numOfCars;
	}
	
	private void printCarsTotal(int numOfCars) {//Gives total number of cars in inventory
		this.numOfCars = numOfCars;
		System.out.println("Total Number of Cars Now: " + this.numOfCars + "\n");
	}
	
	public String saveToFile(String fileName) {//prints inventory to file
		isDone = "Process Not Complete!";
		this.fileName = fileName;
		try {
			PrintWriter outputStream = new PrintWriter(this.fileName);
			if (autoMake.size() == 0) {//if inventory is empty
				autoMobiles();//running default method to print to file.
				outputStream.println(printCar(carNum, make, model, color, year, mileage));
					System.out.print("No cars in inventory. Printing default meassge to your file.");
			}
			else {
				for(int i = 0; i < autoMake.size(); ++i) {
					make = autoMake.get(i);
					model = autoModel.get(i);
					color = autoColor.get(i);
					year = autoYear.get(i);
					mileage = autoMileage.get(i);
					carNum = i;
			
					outputStream.println(printCar(carNum, make, model, color, year, mileage));
				}
			}
			outputStream.close();
			isDone = "\n\tSuccessful Save to file: " + this.fileName;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return isDone;
	}
}
	

