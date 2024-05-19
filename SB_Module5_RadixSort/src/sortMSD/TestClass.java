package sortMSD;

import java.util.Arrays;

public class TestClass {

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
