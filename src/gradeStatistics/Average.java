package gradeStatistics;

public class Average {

	float average = 0;
	float total = 0;
	
	ArrayManage array = new ArrayManage();
	int amount = array.numberOFInput();
	
	public float AverageGrade() {
		for (int i = 0; i < amount; i++) {
			float x = array.grades[i];
			total = total + x;
		}
		average = total/amount;
		return average;
	}
}
