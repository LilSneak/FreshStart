package averageANDdiscount.java;


public class Bills {
	 
	averageANDdiscount mainClass = new averageANDdiscount();
	
	public double[] userBills = new double[4];
	
	
	double averageWeek;
	double averageMonth;
	
	public double calculateWeek() {
		
		averageWeek = (userBills[0] + userBills[1] +  userBills[2] +  userBills[3]) / 4;
		
		return averageWeek;
	 }
	
	public double calculateMonth() {

		averageMonth = (userBills[0] + userBills[1] +  userBills[2] +  userBills[3]);
		
		return averageMonth;
	}

	
	

}