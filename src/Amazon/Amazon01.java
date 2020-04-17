package Amazon;
// Jose Luiz Mattos Gomes

import java.util.ArrayList;
import java.util.List;

public class Amazon01 {

	public static void main(String[] args) {
		Solution01 vSolution = new Solution01();

		int[] vStates = new int[]{1,0,0,0,0,1,0,0};
		vSolution.cellCompete(vStates, 1);
		
		System.out.println("----");
		vStates = new int[]{1,1,1,0,1,1,1,1};
		vSolution.cellCompete(vStates, 2);
	}
}


class Solution01 {
	public List<Integer> cellCompete(int[] states, int days){
		
        // start input validation
        if (states.length != 8) {
            throw new IllegalArgumentException("Wrong number of cells.");
        }
        
        if (days < 0) {
            throw new IllegalArgumentException("Number of days must be greater or equal to 0.");
        }
        
        for (int i : states) {
            if(!(i==0 || i==1))
                throw new IllegalArgumentException("Cells must be 0 or 1.");
        }
        // end input validation
        
		// print initial state
        System.out.print("Input : ");
		printStates(states);

    	// define aux variable
    	int[] stD1 = {0,0,0,0,0,0,0,0};

        // loop through days
        for(int i=1; i < days+1; i++){
            
            // loop through Cells
            for(int j=0; j < 8; j++){
                
                // first cell
                if(j==0){
                    if (states[1]!=0){
                        stD1[j]=1;
                    }
                // last cell
                } else if (j==7) {
                    if (states[6]!=0){
                        stD1[j]=1;
                    }  
                // the other cells
                } else if (states[j-1] != states[j+1]) {
                    stD1[j]=1;
                }
            }
            
            // update states
            for (int j=0; j< 8; j++) {
                states[j] = stD1[j];
            }
                        
        }
        
        // define variable to return
		List<Integer> vResult = new ArrayList<Integer>();
		
		// put final array on a list
        for (int i=0; i< 8; i++) {
            vResult.add(states[i]);
        }
        
		// print initial state
        System.out.print("Output: ");
		printStates(states);
        
        // return final List
        return vResult;		
	}
	
	// print current house states
	private void printStates(int[] states) {
		for (int j=0; j< 8; j++) {
            System.out.print(states[j]);
        }
        System.out.println("");
	}
}