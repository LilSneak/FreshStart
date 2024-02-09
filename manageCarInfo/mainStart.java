package manageCarInfo;

import java.util.Scanner;

public class mainStart {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		autoMobiles autoMobile1 = new autoMobiles();
		
		String newModel;
		String newMake;
		String newColor;
		String newYear;
		String isDone;
		String updateWhat;
		int carNum;
		String updateInfo;
		
		do {
			System.out.println("What would you like to do? Enter one of the option numbers: \n 1. Add \n 2. Remove \n 3. Inventory \n 4. Display \n 5. Update \n Or enter \"Complete\" to stop program.");
			String optionSelect = scnr.next();
			if (optionSelect.equalsIgnoreCase("Complete")) {
				break;
			}
			else {
				switch(optionSelect) {
					case("1"):
						do {
							System.out.println("Enter car information in the following order: make, model, color, and year. Only separated by a space.");
							newMake = scnr.next();
							newModel = scnr.next();
							newColor = scnr.next();
							newYear = scnr.next();
				
							autoMobile1.addVehicle(newMake, newModel, newColor, newYear);
					
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
					case("4"):
						if(autoMobile1.autoMake.size()>0) {
							System.out.println("Enter car list number you only want displayed.");
							carNum = scnr.nextInt();
					
							autoMobile1.displayVehicle(carNum);
						}
						else {
							System.out.println("No car to display");
						}
					break;
					case("5"):
						do {
							if(autoMobile1.autoMake.size()>0) {
								System.out.println("Enter car list number you want to update.");
								carNum = scnr.nextInt();
								
								System.out.println("Enter what you want to update. Options are: \"Make\", \"Model\", \"Color\", and \"Year\" (case-sensitive)");
								updateWhat = scnr.next();
								System.out.println("Enter what your new input");
								updateInfo = scnr.next();
								
								autoMobile1.updateVehicle(carNum, updateWhat, updateInfo);
								
								System.out.println("If you are done updating vehicles type DONE. Otherwise click any key to continue with prompts.");
								isDone = scnr.next();
								if (isDone.equalsIgnoreCase("done")) {
									break;
								}
							}
							else {
								System.out.println("No cars to update");
								break;
							}
						} while(true);
					break;
			
				}
			}
		} while(true);
	
		scnr.close();
	}

}
