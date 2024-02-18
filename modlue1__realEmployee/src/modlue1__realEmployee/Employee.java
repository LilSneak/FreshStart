package modlue1__realEmployee;

import java.util.ArrayList;


public class Employee {
	String firstName;
	String lastName;
	String info;
	String Employee;
	int employeeID;
	double salary;
	
	ArrayList <String> Employees = new ArrayList <String>();
	
	//default and parameterized methods
	public void Employee(){
		firstName = "None";
		lastName = "None";
		employeeID = 0;
		salary = 0;
	}
	public double Employee(String Name1, String Name2, int iD, double salary1) {
		firstName = Name1;
		lastName = Name2;
		employeeID = iD;
		salary = salary1;
		
		return salary;
	}
	//Setters for employee info
	
	//Getters for employee info
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public double getSalary() {
		return salary;
	}

	//Printing Methods
	public String EmployeeSummary() {
		info = "\nName: " + getFirstName() + " " + getLastName() + "\n\tID# " + getEmployeeID() + "\n\tSalary: " + getSalary();
		
		return info;
	}
	public void allEmployees() {
		try {
			if(Employees.size() == 0) {
				throw new Exception("No Employees on roster"); //Empty List.
			}
			for(int i = 0; i < Employees.size(); ++i) {
				System.out.println("\nEmployee " + (i + 1) + ":" + Employees.get(i));
			}
		
		}catch (Exception a) {
			System.out.println(a.getMessage());
			System.out.println("Add employees to List.");
		
		}
	}
	public int addEmployee(String Employee) {
		Employees.add(Employee);
		int listSize = Employees.size();
		return listSize;
	}
	

}
