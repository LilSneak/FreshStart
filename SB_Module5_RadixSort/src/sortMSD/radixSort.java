package sortMSD;

import java.util.Arrays;

public class radixSort {
	
	int place = 1;
	int maximum;
	
	public String startSort(int [] array) {
		try {
		if(array == null || array.length == 0) {//If array is empty
			throw new Exception ("Array has no inputs to sort through");
		}
		maximum = getMax(array);
		
		}catch(Exception a) {
			System.out.println(a);
		}
		return Arrays.toString(radixSorting(array, place));
	}
	
	private int getMax(int [] array) {//Method gets max value of array
		int maxValue = array[0];
		
		for(int value:array) {
			maxValue = Math.max(maxValue, value);
		}
		
		return maxValue;
	}
	
	private int[] radixSorting(int [] array, int digitPlace) {
	
		int[] output = new int[array.length];//Used to keep the numbers sorted by digit
		int[] count = new int[10];//Used for decimal system of 0-9 possible numbers
		
		
		if(maximum / digitPlace <= 0) {//Base Case for recursion
			return array;
		}
		else if (maximum / digitPlace > 0) {//Recursive case
			
			for(int i = 0; i < array.length; i++) {//loop gets how many times there is a digit at the digitPlace
				int digit = (array[i] / digitPlace)% 10;
				count[digit]++;
			}
			for(int i = 1; i <10; i++) {//loop adds all the counts together
				count [i] += count[i-1];
			}
			for(int i = array.length - 1; i >= 0; i--) {//Loops through array to add sorted numbers to output array
				int digit = (array[i] / digitPlace ) % 10;
				output[count[digit]-1]=array[i];
				count[digit]--;
			}
			System.arraycopy(output, 0, array, 0, array.length);//Copy output array to the input array
			
			radixSorting(array, digitPlace *= 10);// the *= 10 moves up the place by 10 to move to the next decimal place
			
		}
		return array;
		}
	
	//Testing
	public static void main(String[] args) {
		
		testRadixSort(new int[] {3, 1, 2, 9, 8, 15});
		testRadixSort(new int[] {345, 11, 98, 9, 1, 212});
		testRadixSort(new int[] {1, 2, 3, 4, 5});
		testRadixSort(new int[] {111, 465, 78, 9, 5, 590, 900, 3, 33, 278, 387});
		testRadixSort(new int[] {});
		testRadixSort(new int[] {1, 1, 1, 1, 1});
		
		//CT Required array of integers
		testRadixSort(new int [] {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94});
	}
	
	public static void testRadixSort(int[] tester) {
		System.out.println("Original: " + Arrays.toString(tester));
		
		radixSort sorter = new radixSort();
		
		System.out.println("Sorted: " + sorter.startSort(tester) + "\n");
	}

}
	
	

