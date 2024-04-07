package linkedList_Module7;

import java.util.LinkedList;
import java.util.Scanner;

public class UserInput {
	
	LinkedList<Students> studentLinkedList = new LinkedList<>();
	
	public void userStudents() {
	
		
		String sName = null;
		String sAddress = null;
		String sGPA = null;
		char option = 'n';
		
		System.out.println("\nTo begin add a new student's name, address, and gpa(0 - 4.0) when prompted.");
		do {
		try {
			Scanner scnr = new Scanner(System.in);
			
			System.out.println("Enter the students name: ");
				String input = scnr.nextLine();
				if(input.contains(" ")) {
					sName = input;
				}
				else {
					throw new Exception("Student name should include first and last name.");
				}
				
			System.out.println("Enter the student's address: ");
				sAddress = scnr.nextLine();
		
			System.out.println("Enter the student's GPA (with 2 decimal places)");
				sGPA = scnr.next();
		
			int i = sGPA.lastIndexOf('.');
			
			if(i != -1 && sGPA.substring(i+1).length() == 2) {
				Double.parseDouble(sGPA);
				if(Double.parseDouble(sGPA) > 4.0) {
					throw new Exception("Invalid GPA input. Reminder: input should be between 0.00-4.08");
				}
			}
			else {
				throw new Exception("Invalid GPA input. Reminder: Must include 2 decimal places.");
			}
			
			studentLinkedList.add(new Students(sName, sAddress, Double.parseDouble(sGPA)));
		
			System.out.println("Enter \"y\" to enter another student or enter any other key to exit the adding process");
			option = scnr.next().charAt(0);
			
			if(option == 'y' || option == 'Y') {
				System.out.println("Will start process to add another student");
			}
			else {
				break;
			}
		}catch(Exception excpt) {
			System.out.println(excpt.getMessage());
			System.out.println("\nWill restart process. Previous Student info not saved!");
		}
		}while (true);

	}
}
