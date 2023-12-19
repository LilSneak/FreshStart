import java.util.Scanner;

public class PersonInfo {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		String firstName;
		String lastName;
		String userAddress;
		String userCity;
		String userZipcode;
		
		System.out.println("Please input information in the following order, each on their own line: First Name, Last Name, Street Address, City (In 'City, State' format), and zip code.");
		
		firstName = scnr.nextLine();
		lastName = scnr.nextLine();
		userAddress = scnr.nextLine();
		userCity = scnr.nextLine();
		userZipcode = scnr.nextLine();
		
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Address: " + userAddress);
		System.out.println("         " + userCity);
		System.out.println("         " + userZipcode);
		
		
		scnr.close();
		//End of Program
		
	}

}
