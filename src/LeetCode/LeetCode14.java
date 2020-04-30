package LeetCode;

import java.util.LinkedList;

// https://leetcode.com/problems/valid-parentheses/
// Jose Luiz Mattos Gomes

public class LeetCode14 {

	public static void main(String[] args) {
		Solution14 vSolution = new Solution14();

		System.out.println(vSolution.isValid("()"));
		System.out.println(vSolution.isValid("()[]{}"));
		System.out.println(vSolution.isValid("(]"));
		System.out.println(vSolution.isValid("([)]"));
		System.out.println(vSolution.isValid("{[]}"));
		System.out.println(vSolution.isValid("}"));

	}

}

class Solution14 {
    public boolean isValid(String s) {
    	
    	// return true if s is empty
    	if(s.isEmpty())
    		return true;
    	
    	// define stack
    	LinkedList<Character> vStack = new LinkedList<Character>();
    	
    	// interact through chars of s
    	for(int i=0; i<s.length(); i++) {
    		
    		// push of pop elements to the stack
    		switch (s.charAt(i)) {
    		// close symbols, do pop
    		case ')':
    			if (vStack.isEmpty() || vStack.pop() != '(')
    				// stack is empty or type of brackets do not match 
    				return false;
    			break;
    		case ']':
    			if (vStack.isEmpty() || vStack.pop() != '[')
    				// stack is empty or type of brackets do not match
    				return false;
    			break;
    		case '}':
    			if (vStack.isEmpty() || vStack.pop() != '{')
    				// stack is empty or type of brackets do not match
    				return false;
    			break;
    		// opens symbols, do push    			
    		default:
    			vStack.push(s.charAt(i));
    			break;
    		}
    	}
    	
    	// stack must be empty to return true value
    	return vStack.isEmpty();
    }
}