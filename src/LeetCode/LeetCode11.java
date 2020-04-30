package LeetCode;

import java.util.Arrays;

// https://leetcode.com/problems/rotate-array/
// Jose Luiz Mattos Gomes

public class LeetCode11 {

	public static void main(String[] args) {

		Solution11 vSolution = new Solution11();
		int[] data = {1,2,3,4,5,6,7};
		vSolution.rotate(data, 3);
		System.out.println(Arrays.toString(data));

	}

}

class Solution11 {
    public void rotate(int[] nums, int k) {
    	
    	// guarantee that k is between 0 and nums.length
    	k = k % nums.length;
    	
    	// if k is zero than no rotation is needed
    	if(k==0)
    		return;
        
    	// create left array copy
    	int[] left = Arrays.copyOfRange(nums,nums.length-k, nums.length);
    	
    	// create right array copy
    	int[] right = Arrays.copyOfRange(nums,0,nums.length-k);
    	
    	// update final array
    	System.arraycopy(left, 0, nums, 0, left.length);
    	System.arraycopy(right, 0, nums,left.length,right.length);
    	
    }
}
