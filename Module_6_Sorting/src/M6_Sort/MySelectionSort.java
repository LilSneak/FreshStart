package M6_Sort;

import java.lang.reflect.Array;

public class MySelectionSort {
	
	StudentList list = new StudentList();
	
	public void sortStudents(Student ss[]){
		int min;
		Student temp = new Student();
		for(int i = 0; i < ss.length-1; i++) {
			min = i;
			
			for(int j= i + 1; j < ss.length; j++) {
				if(ss[j].rollNo.compareTo(ss[min].rollNo) < 0) {
					min = j;
				}
			}
			if(min != i) {
				temp = ss[i];
				ss[i] = ss[min];
				ss[min] = temp;
			}
		}
	}

}
