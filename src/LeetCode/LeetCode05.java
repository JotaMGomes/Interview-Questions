package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode05 {

	public static void main(String[] args) {
		
		Solution05 vSolution = new Solution05();
		
		System.out.println(vSolution.fizzBuzz(15));
		System.out.println(vSolution.fizzBuzz(0));
		System.out.println(vSolution.fizzBuzz(75));

	}

}


class Solution05 {
    public List<String> fizzBuzz(int n) {
    	
    	// define return list
        List<String> vReturn = new ArrayList<String>();
        
        // interact from 1 to n
        for(Integer index=1; index <= n; index++) {
        	
        	// define empty string
        	String vAux = "";
        	
        	// test if is multiple of 3
        	if(index%3==0) { vAux += "Fizz"; }
        	
        	// test if is multiple of 5
        	if(index%5==0) { vAux += "Buzz"; }
        	
        	// if not multiple of 3 or 5 then add integer as string
        	if(vAux.isEmpty()) { vAux += index.toString(); }
        	
        	// add to return list
        	vReturn.add(vAux);
        }
        
        // return final list
        return vReturn;
     }
}