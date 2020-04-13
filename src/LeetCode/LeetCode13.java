package LeetCode;
// https://leetcode.com/problems/valid-palindrome/
// Jose Luiz Mattos Gomes

public class LeetCode13 {

	public static void main(String[] args) {
		Solution15 vSolution = new Solution15();
		System.out.println(vSolution.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(vSolution.isPalindrome("race a car"));
		System.out.println(vSolution.isPalindrome("0P0"));
		System.out.println(vSolution.isPalindrome("0P"));
		
		Solution15b vSolutionb = new Solution15b();
		System.out.println(vSolutionb.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(vSolutionb.isPalindrome("race a car"));
		System.out.println(vSolutionb.isPalindrome("0P0"));
		System.out.println(vSolutionb.isPalindrome("0P"));
	}

}

class Solution15 {
    public boolean isPalindrome(String s) {
     
    	// create string with valid chars
    	String validChars = "abcdefghijklmnopqrstuvwxyz0123456789";
    	
    	// create string with s converted to lowercase
    	StringBuilder strIn = new StringBuilder(s.toLowerCase());
    	
    	// interact through strIn to remove invalid chars 
    	int i=0;
    	while(i<strIn.length()) {
    		if(validChars.indexOf(strIn.charAt(i))<0) {
    			// not a valid char, so delete it from strIn
    			strIn.deleteCharAt(i);
    			continue;
    		}
    		i++;
    	}

    	// create string as a copy of strIn
    	StringBuilder strOut = new StringBuilder(strIn);
    	
    	// compare strIn and a reverse of strOut
    	return (strIn.toString().equals(strOut.reverse().toString()));
    }
}


class Solution15b {
    public boolean isPalindrome(String s) {
     
    	if(s != null && s.length() > 1){
            int left = 0, right = s.length()-1;
            while(left < right) {
                
            	if(Character.isWhitespace(s.charAt(left)) || !Character.isLetterOrDigit(s.charAt(left))){ 
                	left++; 
                	continue;
                }
               
                if(Character.isWhitespace(s.charAt(right)) || !Character.isLetterOrDigit(s.charAt(right))) { 
                	right--; 
                	continue;
                }
                
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) 
                	return false;
                
                left++; right--;
            }
        }
        return true;
    }
}