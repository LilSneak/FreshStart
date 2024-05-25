package M5MergeAlg;

public class MergeSort {
	
	private static void printArray(int[] array) {
		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	private static int [] mergeSort(int[] array) {
		
		if (array.length <= 1) {//if only 1 item in list. No need to sort
			return array;
		}
		
		int middle = array.length/2; //middle number of list
		int [] leftSide = new int [middle];//size of half of the array
		//Right Side size determination
		int [] rightSide;
			if (array.length % 2 == 0) { //if there is an even half of the array
				rightSide = new int [middle]; 
			}
			else {//if uneven will make the right side of the 1 extra amount of elements
				rightSide = new int[middle + 1];
			}
		//Splitting og array into the 2 subarrays
		for(int i = 0; i < middle; i++) {
			leftSide[i] = array[i];//Adding elements from beginning of loop to the middle
		}
		for(int j = 0; j < rightSide.length; j++) {
			rightSide[j] = array[middle + j];//Adding elements from middle to end of array
		}
		
		int [] sorted = new int[array.length];//Creating the sorted array
		leftSide = mergeSort(leftSide);//recursion to keep splitting the left side up in subarrays
		rightSide= mergeSort(rightSide);//recursion to keep splitting the right side up in subarrays
		
		sorted = merge(leftSide, rightSide);
		
		return sorted;
	}
	
	private static int[] merge(int [] leftSide, int [] rightSide) {
		int [] sorted = new int [leftSide.length + rightSide.length];
		
		//Pointers to help keep track of what element we are comparing in which array
		int leftPointer = 0;
		int rightPointer = 0;
		int sortedPointer = 0;
		
		while(leftPointer < leftSide.length || rightPointer < rightSide.length) {//If we haven't reached the end on EITHER subarrays
			
			if(leftPointer < leftSide.length && rightPointer < rightSide.length) {//If we haven't reached the end on BOTH subarrays
			
				if(leftSide[leftPointer] < rightSide[rightPointer]) {
					sorted[sortedPointer++] = leftSide[leftPointer++]; //increments after to move on to the next item
				}
				else {
					sorted[sortedPointer++] = rightSide[rightPointer++];
				}
			}
			else if(leftPointer < leftSide.length) {
				sorted[sortedPointer++] = leftSide[leftPointer++]; 
			}
			else if(rightPointer < rightSide.length) {
				sorted[sortedPointer++] = rightSide[rightPointer++];
			}
		}
		return sorted;
	}
	public static void main(String[] args) {
		
			int [] practiceArray = {5, 7, 9, 2, 4};
			System.out.println("Array unsorted: ");
			printArray(practiceArray);
			
			practiceArray = mergeSort(practiceArray);
			System.out.println("Array sorted: ");
			printArray(practiceArray);
	}

}
