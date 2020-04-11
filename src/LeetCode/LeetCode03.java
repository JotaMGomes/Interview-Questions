package LeetCode;
// https://leetcode.com/problems/single-number/
// Jose Luiz Mattos Gomes

import java.util.Arrays;

// https://leetcode.com/problems/single-number/

public class LeetCode03 {

	public static void main(String[] args) {

		/*
		 * Solution03 vSolution = new Solution03();
		 * 
		 * int s01[] = new int[]{2,2,1};
		 * System.out.println(vSolution.singleNumber(s01));
		 * 
		 * int s02[] = new int[]{4,1,2,1,2};
		 * System.out.println(vSolution.singleNumber(s02));
		 * 
		 * int s03[] = new int[]{}; System.out.println(vSolution.singleNumber(s03));
		 * 
		 * int s04[] = new int[]{1,2,1,2};
		 * System.out.println(vSolution.singleNumber(s04));
		 */
		
		
		Solution03b vSolutionb = new Solution03b();
		
		int s01b[] = new int[]{2,2,1};
		System.out.println(vSolutionb.singleNumber(s01b));
		
		int s02b[] = new int[]{4,1,2,1,2};
		System.out.println(vSolutionb.singleNumber(s02b));
		
		int s03b[] = new int[]{};
		System.out.println(vSolutionb.singleNumber(s03b));
		
		int s04b[] = new int[]{1,2,1,2};
		System.out.println(vSolutionb.singleNumber(s04b));		

	}

}

/*
 * tests:
 * 1. empty input array
 */

class Solution03 {
    public int singleNumber(int[] nums) {
    	
    	// empty array
    	if(nums.length ==0)
    		throw new IllegalArgumentException("Empty input array.");
        
        // interact through input array
        int index = 0;
        while(index < nums.length) {
        	
        	// flag to indicate if a pair was found
        	boolean foundPair = false;
        	
        	// interact through input array from index+1 to end
        	for(int pointer=index+1;pointer<nums.length; pointer++) {
        		
        		// if found pair
        		if(nums[pointer]==nums[index]) {
        			
        			// if not next position (index + 1)
        			//    then change nums[pointer] with nums[index+1]
        			// so pairs stay together
        			if(pointer!=index+1) {
        				int auxNum = nums[index+1];
        				nums[index+1] = nums[pointer];
        				nums[pointer] = auxNum;
        			}
        			
        			// increment 2 to the index
    				index = index + 2;
    				
    				// indicate that a pair was found
    				foundPair = true;
    				
    				// exit the loop
    				break;
        		}
        	}
        	
        	
        	// a pair was not found, return value
        	if(!foundPair) {
        		return nums[index];
        	}
        }
        
        // there is no single value
        throw new IllegalArgumentException("There is not possible solution.");
    }
}


class Solution03b {
    public int singleNumber(int[] nums) {
    	
    	// empty array
    	if(nums.length==0)
    		throw new IllegalArgumentException("Empty input array.");
    	
    	// sort the array
    	Arrays.sort(nums);
    	
    	// interact through the array until length-1 position
    	int index=0;
    	while(index < nums.length-1) {
    		
    		// as the array is sorted, the pairs must be together
    		if(nums[index]!=nums[index+1]) {
    			// pair is not in the next pos, so this is a single value
    			return nums[index];
    		}
    		
    		// update index to skip current pair
    		index = index +2;
    	}
    	
    	// the last position is the single one
    	if(index==nums.length-1)
    		return nums[index];
    	
    	// there is no single value
    	throw new IllegalArgumentException("There is no possible solution"); 	
    }
}


