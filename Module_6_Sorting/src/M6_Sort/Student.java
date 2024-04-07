package M6_Sort;

import java.util.Scanner;

public class Student {
	Scanner scnr = new Scanner(System.in);
	
	String name;
	String rollNo;
	String address;
	
	public void setStudent() {
		System.out.println("Enter new student's name, roll number, and address. Seperate each with \"ENTER\" so"
				+ " each item is on its own line ");
		name = scnr.nextLine();
		rollNo = scnr.nextLine();
		address = scnr.nextLine();
		
	}
	public String getStudent() {//used to print
		return "Name: " + name + "\n\tRoll# " + rollNo + "\n\tAddress: " + address;
	}

}