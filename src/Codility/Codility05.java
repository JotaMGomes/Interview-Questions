package Codility;

import java.util.HashSet;

// https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
// Jose Luiz Mattos Gomes
public class Codility05 {

	public static void main(String[] args) {

		Solution05 vSolution = new Solution05();
		
		int[] vA = new int[]{1,3,1,4,2,3,5,4};
		System.out.println(vSolution.solution(5, vA));
		
		vA = new int[]{1,3,1,4,2,3,5,4};
		System.out.println(vSolution.solution(9, vA));
		
		vA = new int[]{1};
		System.out.println(vSolution.solution(1, vA));
	}

}

class Solution05 {
    public int solution(int X, int[] A) {
        
    	HashSet<Integer> vHS = new HashSet<Integer>();
    	
    	for(int i=1; i<=X; i++) {
    		vHS.add(i);
    	}
    	
    	int i=0;
    	while(i<A.length) {
    		vHS.remove(A[i]);
    		if (vHS.size()==0)
    			return(i);
    		i++;
    	}

    	return -1;
    }
}
