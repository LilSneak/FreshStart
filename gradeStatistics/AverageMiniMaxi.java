package gradeStatistics;

public class AverageMiniMaxi {
	float maximum = 0;
	float currentNum = 0;
	float total = 0;
        

	
	 public float AvgMaxMin() {//using array to get maximum, minimum and average values and then printing them
		 
		 ArrayManage getArray = new ArrayManage();
		 int amount = getArray.numberOFInput(); //getting the array length. This also gets method to use the input data
		 float minimum = getArray.grades[0];
		 
		 for(int i = 0; i < amount; i++) {
			 currentNum = getArray.grades[i];// array from ArrayMAnage Class
			 
			 if (currentNum > maximum) {// for max value
				 maximum = currentNum;
			 }
			 if (currentNum < minimum) {//for min value
				 minimum = currentNum;
			 }
			 total = total + currentNum;// getting total for the average calculation
		 }
		 System.out.println("Maximum Grade: " + maximum);
		 System.out.println("Minimum Grade: " + minimum);
		 System.out.println("Grade Average: " + total/amount);
		 return maximum;
	 }
	
}
