
package ie.gmit.dip;

import java.util.Random;

//Java class for the execution of Bubble Sort
import java.util.*;

public class BubbleSort {

	public static void main(String[] args) {

		Random array = new Random(); // Create Object for Random Predefined class

		int[] number = new int[100]; // alternated and run 100 times manually

		System.out.print("Random Numbers Generated:");
		for (int d = 0; d < number.length; d++) {
			int RandomNumbers = array.nextInt(1000) + 1;
			number[d] = RandomNumbers;
			System.out.print(" " + RandomNumbers);
		}
		/* Prints the array */
		System.out.print("\nSorted Numbers in Array List:" + (Arrays.toString(BubbleSortMethod(number))));

	}

	public static int[] BubbleSortMethod(int[] arraylist) {// Define method BubbleSort() to implement Bubble sort of an
															// array of
		// integers.
		int temp;
		long startTime = System.nanoTime();

		for (int i = 0; i < arraylist.length - 1; i++) {// Outer Loop variable
			for (int k = 1; k < arraylist.length - i - 1; k++) {// Inner Loop variable
				if (arraylist[k - 1] > arraylist[k]) {
					temp = arraylist[k - 1];
					arraylist[k - 1] = arraylist[k];
					arraylist[k] = temp;
				}
			}
		}
		long endTime = System.nanoTime();
		long elapsed = endTime - startTime;
		double timeMillis = elapsed / 1000000.0;
		System.out.print("\nSorted In: " + timeMillis + " " + "ms");

		return arraylist; // Returns array- same array list but is ordered

	}

}