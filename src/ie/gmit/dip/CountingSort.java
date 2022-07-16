
package ie.gmit.dip;

import java.util.Random;
import java.util.Arrays;

public class CountingSort {

	// Driver method
	public static void main(String[] args) {

		// TODO code application logic here
		Random array = new Random();

		// Input & Key l (range for ‘Counting Sort’ algorithm)

		int[] number = new int[10000]; // alternated and run 10 times manually

		System.out.print("Random Numbers Generated:");
		for (int d = 0; d < number.length; d++) {
			int RandomG = array.nextInt(number.length) + 1; // Range must match key k
			number[d] = RandomG;
			System.out.print(" " + RandomG);
		}
		int l = number.length;

		long startTime = System.nanoTime();

		// sorting array using Counting Sort
		countingSort(number, l);
		System.out.println(Arrays.toString(number));

		long endTime = System.nanoTime();
		long elapsed = endTime - startTime;
		double timeMillis = elapsed / 1000000.0;
		System.out.print("\nSorted In: " + timeMillis + " " + "ms");
		System.out.print("\n");

	}

	public static void countingSort(int[] number, int k) {
		int counter[] = new int[k + 1]; // // declare an array named count_number with size equal to range
		for (int i : number) { 
			counter[i]++;
		}

		// sort array
		// iterate through the array/list and count the number of occurrence of each number
		int sorted = 0;
		for (int i = 0; i < counter.length; i++) {
			while (0 < counter[i]) {
				number[sorted++] = i;
				counter[i]--;
			}
		}
	}
}
