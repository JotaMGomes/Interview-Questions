package LeetCode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/count-primes/
// Jose Luiz Mattos Gomes

public class LeetCode09 {

	public static void main(String[] args) {

		Solution09 vSolution = new Solution09();
		
		System.out.println(vSolution.countPrimes(499979));
		System.out.println(vSolution.countPrimes(3));
		System.out.println(vSolution.countPrimes(10));
		System.out.println(vSolution.countPrimes(99));
		
		
		Solution09b vSolutionb = new Solution09b();
		
		System.out.println(vSolutionb.countPrimes(499979));
		System.out.println(vSolutionb.countPrimes(3));
		System.out.println(vSolutionb.countPrimes(10));
		System.out.println(vSolutionb.countPrimes(99));

	}

}

class Solution09 {
    public int countPrimes(int n) {
       
    	List<Integer> vPrime = new ArrayList<Integer>();
    	
    	// test if number is less than 2
    	if (n<=2)
    		return 0;
    	
    	//System.out.print("2 ");
    	
    	// test only odd numbers starting from 3
    	int j = 3;
    	
    	// interact from 1 to n
    	outerloop:
    	while (j<n) {
    		
    		// interact from all prime numbers found until now
    		for(int vNum: vPrime) {
    			if(j % vNum == 0){
    				// not a prime number, continue to next odd number (outerloop)
    				j +=2;
    				continue outerloop;
    			}
    		}
    		
    		// new prime number, add to HashSet
    		vPrime.add(j);
    		//System.out.println(j + " ");
    		
    		// continue to next odd number
    		j+=2;
    		
    	}
    	
    	//System.out.println();
    	// 2 is as a prime number, so sum 1 to the size of vPrime
    	return vPrime.size()+1;
    }
}

class Solution09b {
    public int countPrimes(int n) {
    	
    	/*
    	   When a number is not a prime, this number can be factored into two factors namely a and b 
    	   i.e. number = a * b. 
    	   If both a and b were greater than the square root of n, a * b would be greater than n.
    	 */
    	
    	
    	// List to store prime numbers
        List<Integer> vPrime = new ArrayList<Integer>();
    	
    	// test if number is less than 2
    	if (n<=2)
    		return 0;
    	
    	// add 2 as a prime number
    	//System.out.println(2);
    	vPrime.add(2);
    	
    	// interact from 3 to n, step 2
        for (int i = 3; i < n; i+=2) {
        	
        	// test if i is prime
            if (isPrime(i)) {
            	
            	//System.out.println(i);
            	// add i to primeNumbers list
            	vPrime.add(i);
            } 
        }
        
        //System.out.println("***");
        // return list size
    	return vPrime.size();
    }
    
    // Test if number is prime
    private static boolean isPrime(int number) {
    	
    	// interact from 3 to square root of number
        for (int i = 3; i*i <= number; i++) {
        	
        	// if the remainder is zero than is not prime
            if (number % i == 0) {
            	
            	// not a prime number
                return false;
            }
        }
        
        // is a prime number
        return true;
    }
}