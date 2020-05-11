package HackerRank;
// https://www.hackerrank.com/challenges/2d-array/problem
// Jose Luiz Mattos Gomes

public class HackerRank01 {

	public static void main(String[] args) {
		
		Solution01 vSolution = new Solution01();
		
		int[][] arr = new int[][]
				{{1,1,1,0,0,0},
			     {0,1,0,0,0,0},
			     {1,1,1,0,0,0},
			     {0,0,2,4,4,0},
			     {0,0,0,2,0,0},
			     {0,0,1,2,4,0},
				};
		
		System.out.println(vSolution.hourglassSum(arr));
		System.out.println("============");
		
		arr = new int[][]
				{{-1,-1, 0,-9,-2,-2},
			     {-2,-1,-6,-8,-2,-5},
			     {-1,-1,-1,-2,-3,-4},
			     {-1,-9,-2,-4,-4,-5},
			     {-7,-3,-3,-2,-9,-9},
			     {-1,-3,-1,-2,-4,-5},
				};
				
		System.out.println(vSolution.hourglassSum(arr));
	}

}

class Solution01 {

    // Complete the hourglassSum function below.
    public int hourglassSum(int[][] arr) {
    	
    	// define result variable as min possible value
    	int vResult = Integer.MIN_VALUE;
    	
    	// loop through lines
    	for(int i=0; i < arr.length-2; i++) {
    		// loop through columns
    		for(int j=0; j < arr[i].length-2; j++) {
    			
    			// auxiliary variable to store sum
    			int vSum = 0;
    			
    			// sum hourglass
    			for(int k=0;k<3;k++) {
    				//System.out.println(i + " " + j + " " + k);
    				vSum += arr[i][j+k] + arr[i+2][j+k];
    			}
    			vSum += arr[i+1][j+1];
    			
    			// keep max value
    			if(vSum>vResult)
        			vResult = vSum;
    		}
    	}
    	
    	// return max hourglass sum
    	return vResult;
    }
}
