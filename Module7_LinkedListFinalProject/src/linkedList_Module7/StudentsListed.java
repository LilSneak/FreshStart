package linkedList_Module7;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentsListed {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Students ss = new Students(null, null, 0.0);
		UserInput input = new UserInput();
		
		input.userStudents();
		
		System.out.println("Students in list will now be sorted by their first name and saved to a file named \"List of Students\"");
		
		ss.sortStudents(input.studentLinkedList);
		ss.saveToFile(input.studentLinkedList);
	}
}
