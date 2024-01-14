package gradeStatistics;

import java.util.Scanner;
public class  ProgramMain{

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Enter up to 10 grades: ");
	
		ArrayManage putInputs = new ArrayManage();
		
		if (putInputs.numberOFInput() > 0) {
			System.out.println(putInputs.numberOFInput());
		}
	
		Average averaging = new Average();
		
		
	
		System.out.println("average " + averaging.AverageGrade());
		
		
		
		
	
		
		
		scnr.close();
	}
	
	
}