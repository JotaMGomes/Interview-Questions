package Codility;

import java.util.HashMap;

// https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
// Jose Luiz Mattos Gomes

public class Codility09 {

	public static void main(String[] args) {
		Solution09 vSolution = new Solution09();
		
		int[] vA = new int[]{4,2,2,5,1,5,8};
		System.out.println(vSolution.solution(vA));
		
		vA = new int[]{-3, -5, -8, -4, -10};
		System.out.println(vSolution.solution(vA));
		
		System.out.println("=====");
		Solution09b vSolutionb = new Solution09b();
		
		vA = new int[]{4,2,2,5,1,5,8};
		System.out.println(vSolutionb.solution(vA));
		
		vA = new int[]{-3, -5, -8, -4, -10};
		System.out.println(vSolutionb.solution(vA));
	
	}

}


class Solution09 {
    public int solution(int[] A) {

    	HashMap<String, Double> vSubTotal = new HashMap<String, Double>();
    	
    	int vASize = A.length;
    	int vStart=0;
    	int vEnd = 1;
    	int vResult = 0;
    	double vAux = 0;
    	double vAux1 = 0;
    	double vMinimal = Integer.MAX_VALUE;
    	
    	// store initial values
    	for(int i=0;i<vASize;i++) {
    		vSubTotal.put(Integer.toString(i) + Integer.toString(i),A[i]*1.0);
    	}
    
    	// loop to calculate all values
    	for(int i=2;i<=vASize;i++) {
    		for(int j=0;j<=vASize-i;j++ ) {
    			vStart = j;
    			vEnd = j + i -1;
    			vAux = vSubTotal.get(Integer.toString(vStart) + Integer.toString(vEnd-1)) + A[vEnd];
    			vSubTotal.remove(Integer.toString(vStart) + Integer.toString(vEnd-1));
    			vAux1 = vAux/i;
    			if(vAux1 < vMinimal) {
    				vMinimal = vAux1 ;
    				vResult = j;
    			}
    			vSubTotal.put(Integer.toString(vStart) + Integer.toString(vEnd), vAux);
    		}
    		
    	}	
    	
    	return vResult;
    }
}


/*
 * https://www.martinkysel.com/codility-minavgtwoslice-solution/
 * 
 * Every slice must be of size two or three. 
 * Slices of bigger sizes are created from such smaller slices. 
 * Therefore should any bigger slice have an optimal value, all sub-slices must be the same, for this case to hold true. 
 * Should this not be true, one of the sub-slices must be the optimal slice. 
 * The others being bigger. 
 * Therefore we check all possible slices of size 2/3 and return the smallest one. 
 * The first such slice is the correct one, do not use <= !
 */

class Solution09b {
    public int solution(int[] A) {
    	
    	//main idea: will find min average by checking only 2 and 3 contiguous elements at a time
        int sum2, sum3 = 0;
        double minAverage = Double.MAX_VALUE;
        double currentAverage2 = Double.MAX_VALUE;
        double currentAverage3 = Double.MAX_VALUE;
        int minAverageSliceIndex = 0; //for size 2 arrays, this will always be true

        //if array is > 2 elements
        for(int i=0; i<A.length-2; i++) {
        	
          // 2 contiguous elements
          sum2 = A[i] + A[i+1];
          currentAverage2 = sum2 / 2.0d;
          if(currentAverage2 < minAverage) {
            minAverage = currentAverage2;
            minAverageSliceIndex = i;
          }

          // 3 contiguous elements
          sum3 = sum2 + A[i+2];
          currentAverage3 = sum3 / 3.0d;
          if(currentAverage3 < minAverage) {
            minAverage = currentAverage3;
            minAverageSliceIndex = i;
          }
        }

        //check last 2 contiguous elements from the end - they won't otherwise be checked because
        //when checking 2 and 3 contiguous elements at a time, will stop checking 3 elements from the end
        currentAverage2 = (A[A.length-2] + A[A.length-1]) / 2.0d;
        if(currentAverage2 < minAverage) {
          minAverage = currentAverage2;
          minAverageSliceIndex = A.length-2;
        }
       
        return minAverageSliceIndex;
    }
}