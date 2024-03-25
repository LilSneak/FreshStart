package M6_Sort;



public class StudentList {

	public static void main(String[] args) {
		
		System.out.println("Program is for a max of 10 Students\n");
		Student s[] = new Student[10];
		
		//Creates Objects and adds user input for each student
		for(int i = 0; i < s.length; i++) {
			s[i] = new Student();
		}
		for(int i = 0; i < s.length; i++) {
			s[i].setStudent();
		}
		
		//Prints List Unsorted
		System.out.println("\nUnsorted List: ");
		for(int i = 0; i < s.length; i++) {
			System.out.println((i+1) + ": " + s[i].getStudent());
		}
		
		//Prints Sorted List
		System.out.println("\nList Sorted by Roll Number: ");
		MySelectionSort Sort = new MySelectionSort();
		Sort.sortStudents(s);
		for(int i = 0; i < s.length; i++) {
			System.out.println((i+1) + ": " + s[i].getStudent());
		}
	}

}
