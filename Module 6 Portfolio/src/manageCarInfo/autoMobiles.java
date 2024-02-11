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
 	
	public void autoMobiles() {
		make = "None";
		model = "None";
		color = "None";
		year = 0;
		mileage = 0;
		carNum = 0;
		
		printCar(carNum, make, model, color, year, mileage);
	
	}
	
		
	public int autoMobiles(String carMake, String carModel, String carColor, int carYear, int carMileage) {
		autoMake.add(carMake);
		autoModel.add(carModel);
		autoColor.add(carColor);
		autoYear.add(carYear);
		autoMileage.add(carMileage);
		
		numOfCars = autoMake.size();
		return numOfCars;
	}
	
		
	public void getInventory() {
		try {
			numOfCars = 0;
			if(autoMake.size() == 0) {
				throw new Exception("No vehicles in inventory"); //This is wrong
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
			System.out.println("Select Add option to add to inventory.");
			System.out.println();
		}
	}
	private String printCar(int carNum, String carMake, String carModel, String carColor, int carYear, int carMileage)
	{
		formattedCarPrint = "Car " + (carNum + 1) + ": \n\t Make: " + carMake +" \n\t Model: " + carModel +
				"\n\t Color: " + carColor + "\n\t Year: " + carYear + "\n\t Mileage: " + carMileage;
		
		System.out.println(formattedCarPrint);
		return formattedCarPrint;
	}
	
	
		public String updateVehicleInteger(int whichCar, String whatUpdate) {
			carNum = whichCar - 1;
			try {
				switch(whatUpdate){
					case("Year"):
						System.out.println("Enter your new input");
						updateInteger = scnr.nextInt();
						autoYear.set(carNum, updateInteger);
					break;
					case("Mileage"):
						System.out.println("Enter your new input");
						updateInteger = scnr.nextInt();
						autoMileage.set(carNum, updateInteger);
					break;
					default:
						throw new Exception("Invalid update request. Reminder: options are case-sensitive");
				}
			}catch(Exception excpt) {
				System.out.println(excpt.getMessage());	
				System.out.println("Can not complete update request.");
			}
			isDone = "Update Complete!";
			return isDone;
		}
		
	public String updateVehicleString(int whichCar, String whatUpdate) {
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
				
				default:
					throw new Exception("Invalid update request. Reminder: options are case-sensitive");
			}
		} catch (Exception excpt) {
			System.out.println(excpt.getMessage());	
			System.out.println("Can not complete update request.");
		}
		isDone = "Update Completed";
		return isDone;
	}
	
	public int removeVehicle(int whichCar) {
		carNum = whichCar - 1;
		try {
			autoMake.remove(carNum);
			autoModel.remove(carNum);
			autoColor.remove(carNum);
			autoYear.remove(carNum);
			autoMileage.remove(carNum);
		
		System.out.println("Removal Complete.");
				
		numOfCars = autoMake.size();	
		
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("No Car is available by that List number.");
		}
		return numOfCars;
	}
	
	private void printCarsTotal(int numOfCars) {
		this.numOfCars = numOfCars;
		System.out.println("Total Number of Cars Now: " + this.numOfCars);
	}
	
	public String saveToFile(String fileName) {
		this.fileName = fileName;
		try {
			PrintWriter outputStream = new PrintWriter(this.fileName);
		
			for(int i = 0; i < autoMake.size(); ++i) {
				make = autoMake.get(i);
				model = autoModel.get(i);
				color = autoColor.get(i);
				year = autoYear.get(i);
				mileage = autoMileage.get(i);
				carNum = i;
			
				outputStream.println(printCar(carNum, make, model, color, year, mileage));
			}
			outputStream.close();
			isDone = "\n\tSuccessful Save to file: " + this.fileName;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return isDone;
	}
}
	

