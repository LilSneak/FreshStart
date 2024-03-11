package modlue1__realEmployee;

public class Manager extends Employee{
	
	String department;
	String managerInfo;

	
	public void Manager() {
		department = "Not a manager";
	}
	public String Manager(String department) {
		this.department = department;
		return department;
	}
	private String getDepartment() {
		return department;
	}
	
	@Override
	public String EmployeeSummary(){
		managerInfo = "\tDepartment they manage: " + getDepartment();
		System.out.println(managerInfo);
		
		return managerInfo;
	}
	

}
