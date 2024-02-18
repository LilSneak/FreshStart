package modlue1__realEmployee;

public class Manager extends Employee{
	
	String department;
	
	
	public void Manager() {
		department = "Not a manager";
	}
	public void Manager(String department) {
		this.department = department;
	}
	public String getDepartment() {
		return department;
	}
	
	@Override
	public void EmployeeSummary(){
		super.EmployeeSummary();
		System.out.println("\n\t\tDepartment they manage: " + department);
		
	}
}
