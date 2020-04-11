package LeetCode;

import java.util.HashMap;

// https://leetcode.com/problems/roman-to-integer/
// Jose Luiz Mattos Gomes

public class LeetCode08 {

	public static void main(String[] args) {
		Solution08 vSolution = new Solution08();
		
		System.out.println(vSolution.romanToInt("III"));
		System.out.println(vSolution.romanToInt("IV"));
		System.out.println(vSolution.romanToInt("IX"));
		System.out.println(vSolution.romanToInt("LVIII"));
		System.out.println(vSolution.romanToInt("MCMXCIV"));
		System.out.println(vSolution.romanToInt("y"));

	}

}

class Solution08 {
    public int romanToInt(String s) {
    	
    	// define hashmap to store conversion rates
    	HashMap <Character, Integer> rate = new HashMap<Character, Integer>();
    	rate.put('I',1);
    	rate.put('V',5);
    	rate.put('X',10);
    	rate.put('L',50);
    	rate.put('C',100);
    	rate.put('D',500);
    	rate.put('M',1000);
    	
    	// define accumulator
    	int vReturn = 0;
    	
    	// interact through string chars
    	int i = 0;
    	while(i<s.length()) {
    		
    		// define aux variable to store next value
    		int auxValue = 0;
    		
    		// get next value
    		auxValue = rate.containsKey(s.charAt(i)) ? rate.get(s.charAt(i)) : 0;
    		if (auxValue==0)
    			// invalid Roman number
    			return 0;
    		
    		// test next value
    		if(i<s.length()-1) {
    			
    			// if next value is less than current value,
    			//    subtract current value from last value
    			if (auxValue < rate.get(s.charAt(i+1))){
    				auxValue = rate.get(s.charAt(i+1)) - auxValue;
    				i++;
    			}
    		}
    		
    		// update accumulator
    		vReturn += auxValue;
    		i++;
    	}
        
    	// return accumulator
    	return vReturn;
    }
}