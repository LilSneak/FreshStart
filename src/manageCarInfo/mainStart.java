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
		Boolean addMore = true;
		String isDone;
		do {
			System.out.println("What would you like to do? Enter one of the following options: Add, Remove, Display, and Update (case-sensitive). Or enter Complete to stop program.");
			String optionSelect = scnr.next();
			if (optionSelect.equalsIgnoreCase("Complete")) {
				break;
			}
			else {
				switch(optionSelect) {
					case("Add"):
						do {
							System.out.println("Enter car information in the following order: make, model, color, and year. Only separated by a space.");
							newMake = scnr.next();
							newModel = scnr.next();
							newColor = scnr.next();
							newYear = scnr.next();
				
							autoMobile1.addVehicle(newMake, newModel, newColor, newYear);
					
							System.out.println("If you have no more vehicles to add type DONE. Otherwise type continue with prompts.");
							isDone = scnr.next();
							if (isDone.equalsIgnoreCase("done")) {
								break;
							}
						} while (addMore = true);
			
						System.out.println("Adding Complete.");
						break;
					case("Display"):
						if(autoMobile1.autoMake.size()>0) {
							System.out.println("Enter what make of car you wwant to see information for.");
							newMake = scnr.next();
					
							autoMobile1.displayVehicle(newMake);
						}
						else {
							System.out.println("No cars to display");
						}
					break;
					default:
						System.out.println("Invalid option.");
				}
			}
		} while(addMore = true);
			//PRINT Statement to text operation of method.
		scnr.close();
	}

}
