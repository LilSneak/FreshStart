package sortMSD;

public class radixSort {
	
	public void applySort(int [] array) {
		
		if(array == null || array.length == 0) {
			return;
		}
		
		int maxValue = array[0];
		
		for(int value:array) {
			maxValue = Math.max(maxValue, value);
		}
		
		int place = 1;
		
		while(maxValue / place > 0) {
			countingSort(array, place);
			place *= 10;
		}
	}
	
	private void countingSort(int [] array, int digitPlace) {
		int[] output = new int[array.length];
		
		int[] count = new int[10];
		
		for(int i = 0; i < array.length; i++) {
			int digit = (array[i] / digitPlace)% 10;
			count[digit]++;
		}
		
		for(int i = 1; i <10; i++) {
			count [i] += count[i-1];
		}
		
		for(int i = array.length - 1; i >= 0; i--) {
			int digit = (array[i] / digitPlace ) % 10;
			output[count[digit]-1]=array[i];
			count[digit]--;
		}
		
		System.arraycopy(output, 0, array, 0, array.length);
	}
	
}
