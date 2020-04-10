package LeetCode;
// https://leetcode.com/problems/two-sum/

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode01 {

	public static void main(String[] args) {

		Solution01 vSolution = new Solution01();
		
		int vNums01[] = new int[]{2, 7, 11, 15};
		int vTarget01 = 9;
		System.out.println(Arrays.toString(vSolution.twoSum(vNums01, vTarget01)));
		
		int vNums02[] = new int[]{2, 7, 11, 15};
		int vTarget02 = 26;
		System.out.println(Arrays.toString(vSolution.twoSum(vNums02, vTarget02)));
		
		int vNums03[] = new int[]{};
		int vTarget03 = 0;
		System.out.println(Arrays.toString(vSolution.twoSum(vNums03, vTarget03)));
	}
}

/*
 * tests:
 * 
 */

class Solution01 {
	
    public int[] twoSum(int[] nums, int target) {
    	
    	// result array
    	int vResult[] = new int[]{0,0};
        
    	// hashmap to store tested values
    	HashMap<Integer, Integer> hmNums = new HashMap<Integer, Integer>();
    	
    	// interact through input array
    	for(int index=0; index < nums.length; index++) {
    		
    		// store remainder value
    		int remainder = target - nums[index];
    		
    		// test if remainder value is already on my hashmap
    		if (hmNums.containsKey(remainder)) {
    			
    			// store found values
    			vResult[1] = index;
    			vResult[0] = hmNums.get(remainder);
    			
    			// return found values
    			return vResult;
    		} else {
    			
    			// store value and index into hashmap
    			hmNums.put(nums[index], index);
    		}
    	}
    	
    	// no valued indexes were found
    	throw new IllegalArgumentException("There is no possible solution.");
    }
}


