package LeetCode;
// https://leetcode.com/problems/sqrtx/
// Jose Luiz Mattos Gomes

public class LeetCode10 {

	public static void main(String[] args) {
		
		Solution10 vSolution = new Solution10();
		System.out.println(vSolution.mySqrt(4));
		System.out.println(vSolution.mySqrt(8));
		
		
		Solution10b vSolutionb = new Solution10b();
		System.out.println(vSolutionb.mySqrt(4));
		System.out.println(vSolutionb.mySqrt(8));
	}

}


class Solution10 {
    public int mySqrt(int x) {
    	// return math function
    	return (int)(Math.sqrt(x));
    }
}

class Solution10b {
    public int mySqrt(int x) {
    	// binary search

    	// define boundaries
    	long min = 1, max = x / 2, mid=0;

    	while (min <= max) {
    		mid = min + (max - min)/ 2;
    		if(mid*mid == x)
    			return (int)mid;
    		if(mid*mid < x)
    			min = mid + 1;
    		else
    			max = mid - 1;   		
    	}

    	return min*min<x ? (int)min : (int)max;
    }
}