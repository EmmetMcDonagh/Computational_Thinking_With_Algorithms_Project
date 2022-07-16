
package ie.gmit.dip;

import java.util.Random;

public class MergeSort {

	// Driver method
	public static void main(String[] args) {

		// TODO code application logic here
		Random numbers = new Random();

		int[] arraylist = new int[100]; // programmed and run 100 times manually

		System.out.print("Random Numbers Generated:");
		for (int d = 0; d < arraylist.length; d++) {
			int RandomNumbers = numbers.nextInt(arraylist.length) + 1;
			arraylist[d] = RandomNumbers;
			System.out.print(" " + RandomNumbers); // Printing Random Numbers
			// Prining on the console random numbers
		}

		System.out.println("Given ArrayList");// Printing input array on the console start
		printArray(arraylist);

		long startTime = System.nanoTime();

		MergeSort ms = new MergeSort();
		ms.sort(arraylist, 0, arraylist.length - 1);// Calling Merge sort main logic

		System.out.println("\nSorted array list");
		printArray(arraylist);

		long endTime = System.nanoTime();
		long elapsed = endTime - startTime;
		double timeMillis = elapsed / 1000000.0;
		System.out.print("\nSorted In: " + timeMillis + " " + "ms");
		System.out.print("\n"); // Prining on the console random numbers

	}

	// Merges two subarrays of arraylist[].

	void merge(int arraylist[], int LeftSubArray, int MiddleIndex, int RightSubArray) {//// Compare elements at First
																						//// and Second,
		// and move smaller element at Merged array
		// Calculate the length of the two subarrays to be merged together
		int n1 = MiddleIndex - LeftSubArray + 1;
		int n2 = RightSubArray - MiddleIndex;

		/* Generate temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arraylist[LeftSubArray + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arraylist[MiddleIndex + 1 + j];

		/* Merge the temp arrays together */

		// Initial indexes of first and second subarrays
		int i = 0, p = 0;

		// Initial index of merged subarry array list
		int k = LeftSubArray;
		while (i < n1 && p < n2) {
			if (L[i] <= R[p]) {
				arraylist[k] = L[i];
				i++;
			} else {
				arraylist[k] = R[p];
				p++;
			}
			k++;
		}

		/* Copy remaining components of LeftSubArray[] if any */
		while (i < n1) {
			arraylist[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining components of RightSubArray[] if any */
		while (p < n2) {
			arraylist[k] = R[p];
			p++;
			k++;
		}
	}

	// Main function that sorts the arr[LeftSubArray..RightSubArray] using the
	// method
	// merge()
	void sort(int number[], int LeftSubArray, int RightSubArray) {
		if (LeftSubArray < RightSubArray) {
			// get the mid index of the array list

			int MiddleIndex = (LeftSubArray + RightSubArray) / 2;

			// Sort first and second halves of the array list
			// Sort the left subarray

			sort(number, LeftSubArray, MiddleIndex);
			sort(number, MiddleIndex + 1, RightSubArray);

			// Merge the sorted halves
			merge(number, LeftSubArray, MiddleIndex, RightSubArray);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arraylist[]) {
		int n = arraylist.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arraylist[i] + " ");
		System.out.println();
	}

}