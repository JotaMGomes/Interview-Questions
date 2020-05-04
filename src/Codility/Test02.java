package Codility;

public class Test02 {

	public static void main(String[] args) {
		
		SolutionT2 vSolution = new SolutionT2();
		
//		System.out.println(vSolution.solution(670));
//		System.out.println(vSolution.solution(5260));
//		System.out.println(vSolution.solution(50));
//		System.out.println(vSolution.solution(-999));
//		System.out.println(vSolution.solution(0));
//		System.out.println(vSolution.solution(-5999));
//		System.out.println(vSolution.solution(-1));
//		System.out.println(vSolution.solution(1));
		
		
		System.out.println(vSolution.solutionB(670));
		System.out.println(vSolution.solutionB(5260));
		System.out.println(vSolution.solutionB(50));
		System.out.println(vSolution.solutionB(-999));
		System.out.println(vSolution.solutionB(999));
		System.out.println(vSolution.solutionB(0));
		System.out.println(vSolution.solutionB(-5999));
		System.out.println(vSolution.solutionB(-1));
		System.out.println(vSolution.solutionB(1));
		System.out.println(vSolution.solutionB(88221));
		System.out.println(vSolution.solutionB(-161));
		System.out.println(vSolution.solutionB(-151));
	}

}


class SolutionT2 {
	
   	public int solution(int N) {
        String strVal = Integer.toString(Math.abs(N));
    	int len = strVal.length();
    	int vResult = 0;
    	int signal = N >=0 ? 1 : -1;
    	
    	int firstN = Integer.parseInt(""+strVal.charAt(0));
    	
    	if (N>=0) {
    		if (firstN<=5) {
    			vResult = (int) (5 * Math.pow(10,len) + N);
    		} else {
    			vResult = N * 10 + 5;
    		}
    	} else {
    		if (firstN<=5) {
    			vResult = Math.abs(N) * 10 + 5;
    		} else {
    			vResult = (int) (5 * Math.pow(10,len) + Math.abs(N));
    		}	
    	}
    	
    	return signal * vResult;
    }
   	
   	
   	public int solutionB(int N) {
   		
   		// transform the integer N into a String (remove the sign)
        String strVal = Integer.toString(Math.abs(N));
        
        // define String to store the resulted number as a string
        String strResult = "";
        
        // store the length of N
    	int len = strVal.length();
    	
    	// store the signal of N
    	int signal = (N >=0 ? 1 : -1);
    	
    	// loop through the String strVal
    	int i;
    	for (i=0; i<len;i++) {
    		
    		// store in valNum the value of the position of strVal.charAt(i)
    		int valNum = Integer.parseInt(""+strVal.charAt(i));
    		
    		if (N>=0) {
    			// N is positive
    			
        		if (valNum<=5) {
        			// mount the returning string if found a digit the is <= 5
        			strResult = strVal.substring(0, i) + "5" +  strVal.substring(i, len);
        			break;
        		}
    		} else {
    			// N is negative
    			
    			if (valNum>5) {
    				// mount the returning string if found a digit the is > 5
        			strResult = strVal.substring(0, i) + "5" +  strVal.substring(i, len);
        			break;
    			}
    		}
    		
    	}
    	
    	// test if it is the last position
    	if (i==len) {
    		strResult = strVal + "5";
    	}
    	
    	// store result as an integer
    	return  signal * Integer.parseInt(strResult);
    	
    }
}