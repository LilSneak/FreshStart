package modlue1__realEmployee;

import java.util.ArrayList;


public class Employee {
	protected String firstName;
	protected String lastName;
	protected int employeeID;
	protected double salary;
	private ArrayList <String> Employees = new ArrayList <String>();
	
	//default and parameterized methods
	public void Employee(){
		firstName = "None";
		lastName = "None";
		employeeID = 0;
		salary = 0;
	}
	public void Employee(String firstName, String lastName, int employeeID, double salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeID = employeeID;
		this.salary = salary;
	}
	//Setters for employee info
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
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
	public double salary() {
		return salary;
	}

	//Printing Methods
	public void EmployeeSummary() {
		System.out.println("\nName: " + firstName + " " + lastName + "\n\tID# " + employeeID + "\n\tSalary: " + salary);
	}
	public void allEmployees() {
		try {
			if(Employees.size() == 0) {
				throw new Exception("No Employees on roster"); //Empty List.
			}
			for(int i = 0; i < Employees.size(); ++i) {
				System.out.println("Employee" + (i + 1) + ": \n" + Employees.get(i));
			}
		
		}catch (Exception a) {
			System.out.println(a.getMessage());
			System.out.println("Add employees to List.");
		
		}
	}
	

}
