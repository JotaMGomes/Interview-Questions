package Codility;

import java.util.HashSet;

// https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
// Jose Luiz Mattos Gomes

public class Codility07 {

	public static void main(String[] args) {
		Solution07 vSolution = new Solution07();
		
		int[] vA = new int[]{4,1,3,2};
		System.out.println(vSolution.solution(vA));
		
		vA = new int[]{4,1,3};
		System.out.println(vSolution.solution(vA));
		
		vA = new int[]{4,1,3,2,2};
		System.out.println(vSolution.solution(vA));
		
		vA = new int[]{1};
		System.out.println(vSolution.solution(vA));

	}

}


class Solution07 {
    public int solution(int[] A) {
        
    	// create hashSet to verify values
    	HashSet<Integer> vHS = new HashSet<Integer>();
    	
    	// store array size
    	int vN = A.length;
    	
    	// insert all values to vHS
    	for(int i=0;i<vN;i++) {
    		vHS.add(i+1);
    	}
    	
    	// interact through Array
    	for(int i=0;i<vN;i++) {
    		
    		// remove item
    		vHS.remove(A[i]);
    		if (vHS.size()!=vN-(i+1))
    			
    			// if size has not changed, then return 0 (duplicated value, or unexpected value) 
    			return 0;
    	}
    	
    	// if vHS is not empty then return 0 otherwise return 1
    	return vHS.size()==0 ? 1 : 0;
    }
}