package sortMSD;

import java.util.Arrays;

public class TestClass {

	public static void main(String[] args) {
		
		testRadixSort(new int[] {3, 1, 2, 9, 8, 15});
		testRadixSort(new int[] {345, 11, 98, 9, 1, 212});
	}
	public static void testRadixSort(int[] tester) {
		System.out.println("Original: " + Arrays.toString(tester));
		radixSort sorter = new radixSort();
		sorter.applySort(tester);
		
		System.out.println("Sorted: " + Arrays.toString(tester) + "\n");
	}

}
