package gradeStatistics;

public class  ProgramMain{

	public static void main(String[] args) {
		
		System.out.println("Enter 10 grades (separated by a space) and press ENTER when done: ");
		
		AverageMiniMaxi getNums = new AverageMiniMaxi();
		getNums.AvgMaxMin();//Calling method to get average, minimum, and maximum numbers
	

	}
}