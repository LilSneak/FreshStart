package gradeStatistics;

import java.util.Scanner;

public class ArrayManage {
	Scanner scnr = new Scanner(System.in);
	
	float[] grades = new float[10];
	
	public int numberOFInput() {//inputting user input data into an array
		
		for(int i = 0; i < grades.length; i++) {
			grades[i] = scnr.nextFloat();
		}
		int inputAmount = grades.length;
		
		return inputAmount;
	}
	
}
