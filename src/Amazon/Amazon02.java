package Amazon;
// Jose Luiz Mattos Gomes

import java.util.Arrays;

public class Amazon02 {

	public static void main(String[] args) {
		Solutuion02 vSolution = new Solutuion02();
		
		int[] vIn = new int[]{2,4,6,8,10};
		System.out.println(vSolution.generalizedGCD(5, vIn));
		
		vIn = new int[]{33,66,99};
		System.out.println("----");
		System.out.println(vSolution.generalizedGCD(3, vIn));

	}

}

class Solutuion02 {
	public int generalizedGCD(int num, int[] arr) {
		
		// start input validation
		if (num != arr.length) {
			throw new IllegalArgumentException("Size of the array is different than "+ String.valueOf(num));
		}
		
		for(int j=0;j<arr.length;j++) {
			if(arr[j] <= 0) {
				throw new IllegalArgumentException("Not all numbers are positive.");
			}
		}
		// end input validation
		
		// algorithm 
		
		// get smaller number
		Arrays.parallelSort(arr);
		int vSmallNumber = arr[0];
		
		// test numbers from vSmallNumber to 1;
		for (int i=vSmallNumber; i>0; i--) {
			
			// auxiliary flag
			boolean allOk = true;
			
			// go through all elements
			for(int j=0;j<arr.length;j++) {
				
				// if it has a remainder, then skip to next number 
				if (arr[j] % i != 0) {
					allOk = false;
					break;
				}
			}
			
			// if all remainders are zero, i is the GCDs
			if (allOk) {
				return i;
			}
		}
		
		// all possible values were tested. Return 1. 
		return 1;
	}
}