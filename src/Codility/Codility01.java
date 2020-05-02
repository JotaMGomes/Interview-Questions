package Codility;
// https://app.codility.com/demo/take-sample-test/
// Jose Luiz Mattos Gomes

import java.util.Arrays;
import java.util.HashSet;

public class Codility01 {

	public static void main(String[] args) {
		Solution01 vSolution = new Solution01();
		
		int[] vA = new int[]{1,3,6,4,1,2};
		System.out.println(vSolution.solution(vA));
		
		vA = new int[]{1,2,3};
		System.out.println(vSolution.solution(vA));
		
		vA = new int[]{2};
		System.out.println(vSolution.solution(vA));
		
		vA = new int[]{-2, -3};
		System.out.println(vSolution.solution(vA));
		
		System.out.println("==========================");
		
		Solution01b s2 = new Solution01b();
		vA = new int[]{1,3,6,4,1,2};
		System.out.println(s2.solution(vA));
		
		vA = new int[]{1,2,3};
		System.out.println(s2.solution(vA));
		
		vA = new int[]{2};
		System.out.println(s2.solution(vA));
		
		vA = new int[]{-2, -3};
		System.out.println(s2.solution(vA));

	}

}


class Solution01 {
    public int solution(int[] A) {
        // write your code in Java SE 8
    	
    	// store size of the array
        int vN = A.length;
        
        // sort the array      
        Arrays.sort(A);
        
        // find position where number >= 0
        int i = 0;
        while (i<vN && A[i]<1) {
        	i++;
        }
        
        // test 1
        if(i == vN || A[i]>1)
        	return 1;

        // test next number starting from 2
        int vMin = 2;

        // loop through array
        while (i<vN) {
        	
        	if(A[i]==vMin) {
        		// if found the searched number, increment vMin
        		vMin++;
        	} else if (A[i]>vMin) {
        		// next number is higher then searched one. Return vMin
        		return vMin;
        	}

        	// increment counter
        	i++;
        }
        
        // all array is searched, return size of the array + 1
        return vMin;
    }
}


class Solution01b {
    public int solution(int[] A) {
        // write your code in Java SE 8
    	
    	// store size of the array
        HashSet<Integer> vSet = new HashSet<Integer>(); 
        
        // find position where number >= 0
        for(int n : A) {
        	vSet.add(n);
        }
        
        // test sequence 
        // if number is not on vSet, exit loop
        int i;
        for(i=1; i < Integer.MAX_VALUE; i++) {
        	if(!vSet.contains(i))
        		break;
        }
        
        // return the minor number found
        return i;
    }
}
