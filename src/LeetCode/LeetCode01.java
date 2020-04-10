package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode01 {

	public static void main(String[] args) {

		int vNums01[] = new int[]{2, 7, 11, 15};
		int vTarget01 = 9;
		
		Solution vSolution = new Solution();
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
 * >> twoSum[] is empty
 * 
 */

class Solution {
	
    public int[] twoSum(int[] nums, int target) {
    	
    	int vResult[] = new int[]{0,0};
        
    	HashMap<Integer, Integer> hmNums = new HashMap<Integer, Integer>();
    	
    	for(int index=0; index < nums.length; index++) {
    		int remainder = target - nums[index];
    		if (hmNums.containsKey(remainder)) {
    			vResult[1] = index;
    			vResult[0] = hmNums.get(remainder);
    			return vResult;
    		} else {
    			hmNums.put(nums[index], index);
    		}
    	}
    	throw new IllegalArgumentException("There is no possible solution.");
    }
}


