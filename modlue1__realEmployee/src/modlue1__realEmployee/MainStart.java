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
		String idLength;
		String personInfo;
		int iD;
		double eSalary;
		char isManager;
		char viewEmployees;
		char addMore;
		
		do {
			System.out.print("Input the Employee information in the following order: First Name, Last Name, Employee Id, and Salary");
				fName = scnr.next();
				lName = scnr.next();
				iD = scnr.nextInt();
				eSalary = scnr.nextDouble();
			
				
				E1.Employee(fName, lName, iD, eSalary);
	
				System.out.println("\nIs this employee a manager? Y or N");
				
				isManager = scnr.next().charAt(0);
				try {
					if (isManager == 'Y' || isManager == 'y') {
						System.out.println("What department do they manage?");
							department = scnr.next();
							p1.Manager(department);
							//p1.getDepartment(); //getting rid of this to simplify coding
							System.out.print("Displaying new employee information");

							personInfo = E1.EmployeeSummary() + "\n" + p1.EmployeeSummary();
							E1.addEmployee(personInfo);
					}
		
					else if (isManager == 'N' || isManager == 'n') {//add values for lowercase
						p1.Manager();
						System.out.print("Displaying new employee information");
	
						personInfo = E1.EmployeeSummary() + "\n" + p1.EmployeeSummary();
						E1.addEmployee(personInfo);
					}
					else {
						throw new Exception("Invalid Option selected");
					}

					//Asking to add more employees
					System.out.println("Would you like to add another employee Y or N?");
					addMore = scnr.next().charAt(0);
					if (addMore == 'Y' || addMore == 'y') {
						System.out.println("Will continue program.\n");
					}
		
					else if (addMore == 'N' || addMore == 'n') {
						System.out.print("Okay");
						break;
					}
					else {
						throw new Exception("Invalid Option Selected.");
					}
				} catch(Exception b) {
					System.out.println(b.getMessage());
				}
			
				}while(true);
		//Asking to view all employees
				do {
					try {
						System.out.println("\nDo you want to view all employees? Y or N");
						viewEmployees = scnr.next().charAt(0);
	
						if (viewEmployees == 'Y' || viewEmployees == 'y') {
							System.out.println("Displaying all employees \n");
							System.out.println("Program Ended");
							E1.allEmployees();
							break;
						}

						else if (viewEmployees == 'N' || viewEmployees == 'n') {
							System.out.println("Program Ended");
							break;
						}
						else {
							throw new Exception("Invalid Option Selected.");
						}
					}catch(Exception b) {
						System.out.println("Will prompt user again.");
					}
				}while(true);
		scnr.close();
	}

	
}

