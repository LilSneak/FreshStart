package modlue1__realEmployee;

import java.util.ArrayList;


public class Employee {
	private String firstName;
	private String lastName;
	private String info;
	private String Employee;
	private int employeeID;
	private double salary;
	
	private ArrayList <String> Employees = new ArrayList <String>();
	
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
	private String getFirstName() {
		return firstName;
	}
	private String getLastName() {
		return lastName;
	}
	private int getEmployeeID() {
		return employeeID;
	}
	private double getSalary() {
		return salary;
	}

	//Printing Methods
	public String EmployeeSummary() {
		info = "\nName: " + getFirstName() + " " + getLastName() + "\n\tID# " + getEmployeeID() + "\n\tSalary: " + getSalary();
		System.out.println(info);
		
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
