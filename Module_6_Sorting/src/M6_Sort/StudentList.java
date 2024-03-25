package M6_Sort;



public class StudentList {

	public static void main(String[] args) {
		
		
		Student s[] = new Student[10];
		
		for(int i = 0; i < s.length; i++) {
			s[i] = new Student();
		}
		for(int i = 0; i < s.length; i++) {
			s[i].setStudent();
		}
		
		System.out.println("\nUnsorted List: ");
		for(int i = 0; i < s.length; i++) {
			System.out.println((i+1) + ": " + s[i].getStudent());
		}
		
		System.out.println("\nSorted List: ");
		MySelectionSort Sort = new MySelectionSort();
		Sort.sortStudents(s);
		for(int i = 0; i < s.length; i++) {
			System.out.println((i+1) + ": " + s[i].getStudent());
		}
	}

}
