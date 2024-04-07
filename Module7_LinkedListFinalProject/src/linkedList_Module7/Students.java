package linkedList_Module7;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Students {
	private String name;
	private String address;
	private double gpa;
	
	Students(String Name, String Address, double GPA){
		name = Name;
		address = Address;
		gpa = GPA;
		
		System.out.println("New student succesfully added to list");
	}
	
	private String getName() {
		return name;
	}
	private String getAddress() {
		return address;
	}
	private double getGpa() {
		return gpa;
	}
	
	public void sortStudents(List<Students> list){
		int min;
		Students temp = new Students(null, null, 0.0);
		
		for(int i = 0; i < list.size()-1; i++) {
			min = i;
			
			for(int j= i + 1; j < list.size(); j++) {
				if(list.get(j).name.compareTo(list.get(min).name) < 0) {
					min = j;
				}
			}
			if(min != i) { //swap
				temp = list.get(i);
				list.set(i, list.get(min));
				list.set(min, temp);
			}
		}
	}
	
	public void printList(List<Students> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println("Student # " + (i+1));
			System.out.println("\tName: " + list.get(i).getName() + "\n\tAddress: " + list.get(i).getAddress() + "\n\tGPA: " + list.get(i).getGpa() +"\n");
			
		}
	}
	public void saveToFile(List<Students> list) {//prints inventory to file
		try {
			PrintWriter outputStream = new PrintWriter("List of Students");
			for(int i = 0; i < list.size(); i++) {
				outputStream.println("Student # " + (i+1));
				outputStream.println("\tName: " + list.get(i).getName() + "\n\tAddress: " + list.get(i).getAddress() + "\n\tGPA: " + list.get(i).getGpa() +"\n");
			}
			
			outputStream.close();
			System.out.println("\n\tSuccessful Save to file: \"List of Students\" ");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
