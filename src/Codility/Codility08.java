package Codility;
// https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
// Jose Luiz Mattos Gomes

import java.util.Arrays;

public class Codility08 {

	public static void main(String[] args) {
		Solution08 vSolution = new Solution08();
		
		int[] vA = new int[]{-3,1,2,2,-2,5,6};
		System.out.println(vSolution.solution(vA));
		
		vA = new int[]{-5,5,-5,4};
		System.out.println(vSolution.solution(vA));

	}

}


class Solution08 {
    public int solution(int[] A) {
        // write your code in Java SE 8
    	
    	Arrays.parallelSort(A);
    	
    	int maxNum = Integer.MIN_VALUE;
    	int vAux = 0;
    	int vMaxVal = A[A.length-1];
    	
    	for(int i=0;i<A.length-2;i++) {
    		if(A[i] * vMaxVal * vMaxVal > maxNum)
	    		for(int j=i+1;j<A.length-1;j++) {
	    			if(A[i] * A[j] * vMaxVal > maxNum)
		    			for(int k=j+1;k<A.length;k++) {
		    				vAux = A[i] * A[j] * A[k];
		    				if (vAux > maxNum)
		    					maxNum = vAux;
		    			}
	    		}
    	}
    	
    	return maxNum;
    }
}