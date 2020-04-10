package LeetCode;
// https://leetcode.com/problems/reverse-string/

public class LeetCode02 {

	public static void main(String[] args) {

		Solution02 vSolution = new Solution02();
		
		char s01[] = new char[]{'h','e','l','l','o'};
		vSolution.reverseString(s01);
		System.out.println(s01);
		
		char s02[] = new char[]{'H','a','n','n','a','h'};
		vSolution.reverseString(s02);
		System.out.println(s02);

	}

}

/*
 * tests:
 * 
 */

class Solution02 {
	
    public void reverseString(char[] s) {
    	
    	// interact through half of input array
    	for(int index=0; index < s.length/2; index++) {
    		
    		// change s[index] char with s[s.length-(index+1)]
    		char numAux = s[index];
    		s[index] = s[s.length-(index+1)];
    		s[s.length-(index+1)] = numAux;
    	}
    }
}