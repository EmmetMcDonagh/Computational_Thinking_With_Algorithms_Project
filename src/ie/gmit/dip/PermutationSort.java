
package ie.gmit.dip;

import java.util.Random;

//Java class for the execution of Permutation/Bogo Sort

public class PermutationSort {
	public static void main(String[] args) {

		// Random array to be sorted here
		Random array = new Random();//Create Object for Random Predefined class


		int[] figure = new int[1000]; // alternated and run 10 times manually

		System.out.print("Random Numbers Generated:");
		for (int d = 0; d < figure.length; d++) {
			int RandomNumbers = array.nextInt(figure.length) + 1;
			figure[d] = RandomNumbers;
			System.out.print(" " + RandomNumbers);// Printing Random Numbers
			// Prining on the console random numbers
		}

		long startTime = System.nanoTime();

		PermutationSort now = new PermutationSort();
		System.out.println(" ");
		now.display1D(figure);

		now.permutationsort(figure);

		System.out.println(" ");
		System.out.print("Sorted Array: ");
		now.display1D(figure);

		long endTime = System.nanoTime();
		long elapsed = endTime - startTime;
		double timeMillis = elapsed / 1000000.0;
		System.out.print("\nSorted In: " + timeMillis + " " + "ms");
		System.out.print("\n");
	}

	void permutationsort(int[] figure) {//createa randomised permutation of an the user input array
		int shuffle = 1;
		for (; !isSorted(figure); shuffle++)
			mix(figure);
		// Boast
		System.out.println("This took " + shuffle + " shuffles of components in the array list.");
	}

	void mix(int[] number) {
		int i = number.length - 1;
		while (i > 0)
			exchange(number, i--, (int) (Math.random() * i));
	}

	void exchange(int[] number, int i, int j) {// switching 2 elements of the array
		int temp = number[i];
		number[i] = number[j];
		number[j] = temp;
	}

	boolean isSorted(int[] number) { //to verify if the array is sorted or not

		for (int i = 1; i < number.length; i++)
			if (number[i] < number[i - 1])
				return false;
		return true;
	}

	void display1D(int[] number) {
		for (int i = 0; i < number.length; i++)
			System.out.print(number[i] + " ");
		System.out.println(" ");
	}

}