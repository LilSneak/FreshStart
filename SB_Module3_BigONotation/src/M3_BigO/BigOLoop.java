package M3_BigO;

public class BigOLoop {
	
	public static String searchAnArray(int array[], int searchedInt) {
		String isFound = "Integer 2 is not within the array of unique integers";
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == searchedInt) {
				isFound = "Integer 2 is within the array of unique integers";
				return isFound;
			}
		}
		
		return isFound;
	}
	
	public static void main(String[] args) {
		
		
		int uniqueArray[] = { 3, 6, 5, 1, 4};
		int number = 2;
		
		System.out.println(searchAnArray(uniqueArray, number));
		
		
	}
}
