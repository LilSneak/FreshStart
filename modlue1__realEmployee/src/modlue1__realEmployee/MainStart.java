package modlue1__realEmployee;

import java.util.Scanner;


public class MainStart {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		
		Employee E1 = new Employee();
		Manager p1 = new Manager();
		
		String fName;
		String lName;
		String department;
		int iD;
		double eSalary;
		char isManager;
		char viewEmployees;
		

		System.out.print("Input the Employee information in the following order: First Name, Last Name, Employee Id, and Salary");
			fName = scnr.next();
			lName = scnr.next();
			iD = scnr.nextInt();
			eSalary = scnr.nextDouble();
			
			E1.Employee(fName, lName, iD, eSalary);
			
			System.out.println("\nIs this employee a manager? Y or N");
			isManager = scnr.next().charAt(0);
		
		if (isManager == 'Y') {
			System.out.println("What department do they manage?");
				department = scnr.next();
				p1.Manager(department);
			System.out.print("Displaying new employee information");
				p1.EmployeeSummary();
			
		}
		
		else if (isManager == 'N') {//add values for lowercase
			p1.Manager();
			System.out.print("Displaying new employee information");
				E1.EmployeeSummary();
		}
		System.out.println("\nDo you want to view all employees? Y or N");
		viewEmployees = scnr.next().charAt(0);
		
		if (viewEmployees == 'Y') {
			System.out.println("Displaying all employees");
				//call the all employees when arraylist add method is added again
		}
		
		else if (viewEmployees == 'N') {
			System.out.print("Program Terminated");
		
		}
		scnr.close();

	}

}
