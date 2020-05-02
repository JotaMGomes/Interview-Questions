package Codility;
// https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
// Jose Luiz Mattos Gomes

public class Codility02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution02 vSolution = new Solution02();
		
		System.out.println(9 + " " + vSolution.solution(9));
		System.out.println(529 + " " + vSolution.solution(529));
		System.out.println(20 + " " + vSolution.solution(20));
		System.out.println(15 + " " + vSolution.solution(15));
		System.out.println(32 + " " + vSolution.solution(32));
		System.out.println((Integer.MAX_VALUE-2)+ " " + vSolution.solution(Integer.MAX_VALUE-2));
	}

}

class Solution02 {
    public int solution(int N) {
        // write your code in Java SE 8
    	
    	// string variable to store value in binary format
    	String vBinVal = Integer.toBinaryString(N);
    	//System.out.println(vBinVal);
    	
    	// variable to store max sequence
    	int maxSeq = 0;
    	
    	// define counter
    	int vCounter = 0;
    	
    	// interact through vBinVal chars
    	for(int i=0; i<vBinVal.length(); i++) {
    		if(vBinVal.charAt(i)=='1') {
    			// found a '1'
    			if (vCounter > maxSeq)
    				// update maxSeq if counter is higher than maxSql
    				maxSeq = vCounter;
    			
    			// reset counter
    			vCounter = 0;
    		} else {
    			// found a '0', update counter
    			vCounter++;
    		}
    	}
    	
    	// return max sequence found
    	return maxSeq;
    }
}
