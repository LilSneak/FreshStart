package gradeStatistics;

public class Average {

	float average = 0;
	float total = 0;
	
	
	public float AverageGrade() {
		ArrayManage array = new ArrayManage();
		int amount = array.numberOFInput();
		
		for (int i = 0; i < amount; i++) {
			float x = array.grades[i];
			total = total + x;
		}
		average = total/amount;
		System.out.println("inside average: " + average);
		
		return average;
	}
}
