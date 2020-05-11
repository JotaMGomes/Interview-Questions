package HackerRank;
// https://www.hackerrank.com/challenges/array-left-rotation/problem
// Jose Luiz Mattos Gomes

import java.util.Arrays;

public class HackerRank02 {

	public static void main(String[] args) {
		Solution02 vSolution = new Solution02();
		int[] data = new int[]{1,2,3,4,5};
		vSolution.rotateLeft(data, 4);
		//System.out.println(Arrays.toString(data));

	}

}

class Solution02 {
    public void rotateLeft(int[] nums, int k) {
    	
    	// guarantee that k is between 0 and nums.length
    	k = k % nums.length;
    	
    	// if k is zero than no rotation is needed
    	if(k==0)
    		return;
        
    	// create left array copy
    	int[] left = Arrays.copyOfRange(nums, k, nums.length);
    	
    	// create right array copy
    	int[] right = Arrays.copyOfRange(nums, 0, k);
    	
    	// update final array
    	System.arraycopy(left, 0, nums, 0, left.length);
    	System.arraycopy(right, 0, nums, left.length, right.length);
    	
    	for(int j : nums) {
    		System.out.print(j + " ");
    	}
    	
    }
}