package gradeStatistics;

public class AvgMinMax {
	float minimum = 0;
	float maximum = 0;
	float currentNum = 0;
	
	ArrayManage getArray = new ArrayManage();
	
	int amount = getArray.numberOFInput();
        
	float copyArray[] = getArray.grades.clone();
	
	 public float Max() {
		 
		 for(int i = 0; i < amount; i++) {
			 currentNum = copyArray[i];
			 
			 if (currentNum > maximum) {
				 maximum = currentNum;
			 }
		 }
		 return maximum;
	 }
	 
	 public float Min() {
		 
		 for(int i = 0; i < amount; i++) {
			currentNum = copyArray[i];
			
			if (currentNum < minimum) {
			 minimum = currentNum;
			}
		 }
		 return minimum;
	 }
}
