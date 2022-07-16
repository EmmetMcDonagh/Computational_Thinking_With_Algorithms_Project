package ie.gmit.dip;

import java.util.Random;
import java.util.*;
//Java class for the execution of Insertion Sort

public class InsertionSort {

	public static void main(String[] args) {

		Random array = new Random();

		int[] arraylist = new int[10000]; // alternated and run 100 times manually

		System.out.print("Random Numbers Generated:");
		for (int d = 0; d < arraylist.length; d++) {
			int RandomNumbers = array.nextInt(arraylist.length) + 1;
			arraylist[d] = RandomNumbers;
			System.out.print(" " + RandomNumbers);// Printing Random Numbers
			// Prining on the console random numbers
		}

		System.out.print("\nSorted Numbers in ArrayList:" + (Arrays.toString(InsertSort(arraylist))));

	}

	public static int[] InsertSort(int[] arraylist) {

		long startTime = System.nanoTime();

		for (int i = 1; i < arraylist.length; i++) {
			int number = arraylist[i];
			int k = i - 1;

			/*
			 * Move the components of arraylist[index[0]..i-1], that have a greater value
			 * than key, to one position ahead of their present position in the arraylist
			 */
			while (k >= 0 && arraylist[k] > number) {
				arraylist[k + 1] = arraylist[k];
				k = k - 1;
			}
			arraylist[k + 1] = number;
		}

		long endTime = System.nanoTime();
		long elapsed = endTime - startTime;
		double timeMillis = elapsed / 1000000.0;
		System.out.print("\nSorted In: " + timeMillis + " " + "ms");

		return arraylist;
	}
}