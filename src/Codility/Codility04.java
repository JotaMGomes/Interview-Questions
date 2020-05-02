package Codility;
// https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
// Jose Luiz Mattos Gomes

public class Codility04 {

	public static void main(String[] args) {
		
		Solution04 vSolution = new Solution04();
		
		int[] vA = new int[]{3,1,2,4,3};
		System.out.println(vSolution.solution(vA));
		
		vA = new int[]{0,0};
		System.out.println(vSolution.solution(vA));
		
		vA = new int[]{-1000,1000};
		System.out.println(vSolution.solution(vA));
		
		vA = new int[]{1,2,3};
		System.out.println(vSolution.solution(vA));

	}

}

class Solution04 {
    public int solution(int[] A) {
        // write your code in Java SE 8
    	int vMinDiff = Integer.MAX_VALUE;
    	
    	int vAcc1 = 0;
    	for(int i=0; i< A.length ;i++) {
    		vAcc1 += A[i];
    	}
    	
    	int vAcc2 = 0;
    	for(int i=0; i< A.length-1 ;i++) {
    		vAcc2 += A[i];
    		if (Math.abs(vAcc2 - (vAcc1 - vAcc2)) < vMinDiff)
    		{
    			vMinDiff = Math.abs(vAcc2 - (vAcc1 - vAcc2));
    		}
    	}
    	
    	return vMinDiff;
    }
}