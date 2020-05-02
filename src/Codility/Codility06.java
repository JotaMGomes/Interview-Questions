package Codility;
// https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
// Jose Luiz Mattos Gomes
import java.util.Arrays;

public class Codility06 {

	public static void main(String[] args) {
		
		
	Solution06 vSolution = new Solution06();
	
	int[] vA = new int[]{3,4,4,6,1,4,4};
	System.out.println(Arrays.toString(vSolution.solution(5, vA)));
	
	}

}

class Solution06 {
    public int[] solution(int N, int[] A) {
    	
    	// define array to return
    	int[] vResult = new int[N];
    	
    	// variable to keep max count
    	int maxCount = 0;
    	
    	// variable to keep last updated value
    	int lastUpdate = 0;
    	
    	// auxiliary variable to reduce arrays searches
    	int vAux = 0;
    	
    	// interact through input array
    	for(int i=0;i<A.length;i++) {
    		
    		// if values is higher than N, update lastUpdate variable to current max count
    		if(A[i]>N) {
    			lastUpdate = maxCount;
    		} else {
    			// store current value from vResult as base value
    			vAux = vResult[A[i]-1];
    			
    			// if value is less than lastUpdate, then lastUpdate is now the base value
    			if (vAux < lastUpdate)
    				vAux = lastUpdate;
    			
    			// increment value
    			vAux++;
    			
    			// store value in result array
    			vResult[A[i]-1] = vAux;
    			
    			// if value is higher then maxCount, update it
    			if(vAux > maxCount) {
    				maxCount = vAux;
    			}
    		}
    	}
    	
    	// update result array
    	for(int i=0;i<N;i++) {
    		if (vResult[i] < lastUpdate)
    			vResult[i] = lastUpdate;
    	}
    	
    	// return result array
    	return vResult;
    }
}
