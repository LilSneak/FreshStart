package manageCarInfo;

import java.util.Scanner;

public class mainStart {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		autoMobiles autoMobile1 = new autoMobiles();
		
		String newModel;
		String newMake;
		String newColor;
		int newYear;
		int newMileage;
		String isDone;
		String updateWhat;
		int carNum;
		String updateString;
		int updateInteger;
		char printToFile;
		int optionSelect2;
		
		try {
		do {
			System.out.println("What would you like to do? Enter one of the option numbers: \n 1. Add \n 2. Remove \n 3. Inventory \n 4. Display \n 5. Update \n Or enter \"Complete\" to stop program.");
			String optionSelect = scnr.next();
			if (optionSelect.equalsIgnoreCase("Complete")) {
				System.out.println("Would you like to save inventory in a text file? Enter Y or N");
				printToFile = scnr.next().charAt(0);
				if(printToFile == 'Y') {
					System.out.println("Name the file: ");
					String fileName = scnr.next();
					autoMobile1.saveToFile(fileName);
					break;
				}
				else if(printToFile == 'N') {
					break;
				}
			}
			else {
				switch(optionSelect) {
					case("1"):
						do {
							System.out.println("Enter car information in the following order: make, model, color, year, and mileage. Only separated by a space.");
							newMake = scnr.next();
							newModel = scnr.next();
							newColor = scnr.next();
							newYear = scnr.nextInt();
							newMileage = scnr.nextInt();
				
							autoMobile1.autoMobiles(newMake, newModel, newColor, newYear, newMileage);
					
							System.out.println("If you have no more vehicles to add type \"done\". Otherwise click any key to continue with prompts.");
							isDone = scnr.next();
							if (isDone.equalsIgnoreCase("done")) {
								break;
							}
						} while (true);
			
						System.out.println("Adding Complete.");
					break;
					case("2"):
						if(autoMobile1.autoMake.size()>0) {
							System.out.println("Enter car list number you want to remove");
							carNum = scnr.nextInt();
							
							autoMobile1.removeVehicle(carNum);
						}
						else {
							System.out.println("No cars to remove.");
						}
					break;
					case("3"):
						if(autoMobile1.autoMake.size()>0) {
							
							autoMobile1.getInventory();
						}
						else {
							System.out.println("No cars in inventory");
						}
					break;
					case("5"):
						try {
						do {
								if(autoMobile1.autoMake.size()>0) {
									throw new Exception("No vehicles in inventory"); //This is wrong
								}
								System.out.println("Enter car list number you want to update.");
								carNum = scnr.nextInt();
								if (carNum > autoMobile1.autoMake.size()) {
									throw new Exception("Out of bounds of inventory");
								}
								System.out.println("Select what group of options you want 1 or 2. \n\t1: Make, Model, and Color\n\t2: Year and Mileage");
								
								optionSelect2 = scnr.nextInt();
									if (optionSelect2 == 1) {
										System.out.println("Enter what you want to update. Options are: \"Make\", \"Model\", or \"Color\" (case-sensitive)");
										updateWhat = scnr.next();
										System.out.println("Enter your new input");
										updateString = scnr.next();
										
										autoMobile1.updateVehicleString(carNum, updateWhat, updateString);
									}
									else if(optionSelect2 == 2) {
										System.out.println("Enter what ou want to update: \"Year\" or \"Mileage\" ");
										updateWhat = scnr.next();
										System.out.println("Enter your new input");
										updateInteger= scnr.nextInt();
										
										autoMobile1.updateVehicleInteger(carNum, updateWhat, updateInteger);
									}
									else {
										throw new Exception("Invalid option.");
									}
								
								
								System.out.println("If you are done updating vehicles type DONE. Otherwise click any key to continue with prompts.");
								isDone = scnr.next();
								if (isDone.equalsIgnoreCase("done")) {
									break;
								}
							
						} while(true);
						}catch(Exception e) {
							System.out.println(e.getMessage());
							System.out.println("Can't enter update process");
						}
					break;
						
				}
			}
		} while(true);
		
		}catch(Exception excpt) {
			System.out.println(excpt.getMessage());
			System.out.println("Cannot start the inventory program. Program Terminated");
		}
		scnr.close();
	}

}
