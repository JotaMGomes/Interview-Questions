package LeetCode;
// https://leetcode.com/problems/reverse-integer/
// Jose Luiz Mattos Gomes

public class LeetCode07 {

	public static void main(String[] args) {

		Solution07 vSolution = new Solution07();
		
		System.out.println(vSolution.reverse(123));
		System.out.println(vSolution.reverse(-123));
		System.out.println(vSolution.reverse(21));
		System.out.println(vSolution.reverse(1563847412));
		
		
		Solution07b vSolutionb = new Solution07b();
		
		System.out.println(vSolutionb.reverse(123));
		System.out.println(vSolutionb.reverse(-123));
		System.out.println(vSolutionb.reverse(21));
		System.out.println(vSolutionb.reverse(1563847412));
		

	}

}

class Solution07 {
    public int reverse(int x) {

		// define vReturn variable
    	int vReturn = 0 ;
    	
    	// interact through numbers
    	while (Math.abs(x) > 0) {
    		
    		// test int boundaries
    		if (Math.abs(vReturn)*10d + x%10 > (Integer.MAX_VALUE)*1.0d)
    			return 0;
    		
    		
    		vReturn = vReturn*10 + x%10;
    		x=x/10;
    	}
    	
    	
    	// return reversed number
    	return vReturn;
     
    }
}


class Solution07b {
    public int reverse(int x) {

		// define vReturn variable
    	long y = Math.abs(x), vReturn = 0;
    	
    	// interact through numbers
    	while (y > 0) {
    		vReturn = vReturn*10 + y%10;
    		y=y/10;
    	}
    	
		// test int boundaries
		if (vReturn > Integer.MAX_VALUE)
			return 0;
    	
    	// return reversed number
		if (x<0)
			vReturn *= -1;
		
    	return (int)vReturn;
     
    }
}
