package modlue1__realEmployee;

public class Tester {

	public static void main(String[] args) {
		
		Manager M = new Manager();
		Employee E = new Employee();
		
		System.out.println("Testing Started");
		
		assert(M.Manager("Arts") == "Arts") : "Assertion M.Manager(\"Arts\") == Arts failed";
		assert(M.Manager("9100") == "2000") : "Assertion M.Manager(\"9100\") == \"9100\" failed";//intentional fail
		
		assert(E.Employee(null, null, 0, 0) == 0) : "Assertion checking salary E.Employee(null, null, 0, 0) failed";
		assert(E.Employee(null, null, 0, 40000) == 0) : "Assertion checking salary E.Employee(null, null, 0, 40000) failed";//intentional fail
		
		assert(E.addEmployee("Bob") > 0 ) : "Assertion E.addEmployee(\"Bob\") > 0 failed";
		assert(E.addEmployee("Sam") > 0 ) : "Assertion E.addEmployee(\"Sam\") > 0 failed";
		
		System.out.println("Test Ended");
	}
	
}
