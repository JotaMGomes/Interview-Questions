package Codility;

import java.util.HashSet;
import java.util.Iterator;

public class Test03 {

	public static void main(String[] args) {
		
		SolutionT3 vSolution = new SolutionT3();
		
		int[] vA = new int[]{3, 4, 5, 3, 7};
		System.out.println(vSolution.solution(vA));
		
		vA = new int[]{1, 2, 3, 4};
		System.out.println(vSolution.solution(vA));
		
		vA = new int[]{1, 3, 1, 2};
		System.out.println(vSolution.solution(vA));
		
		vA = new int[]{4, 4, 4, 5, 3};
		System.out.println(vSolution.solution(vA));

	}

}


class SolutionT3 {
    public int solution(int[] A) {
    	
    	// declare int variable to store result
    	int vReturn = 0;
    	
    	// define HashSet to store possible trees to remove
    	HashSet<Integer> treesToRemove = new HashSet<Integer>();
    	
    	// loop through array
    	int i=0;
    	while (i<A.length-2) {
    		
    		// the main idea is to compare trees 3 by 3
    		if (!test3(A, i, i+1, i+2)) {
    			// found an error
    			
    			// store the 3 possible trees that can be removed
    			treesToRemove.add(i);
    			treesToRemove.add(i+1);
    			treesToRemove.add(i+2);
    			
    			if (treesToRemove.size() > 3)
    				// more than 1 tree need to be removed
    				return -1;
    		}
    		i++;
    	}
    	
    	if (treesToRemove.isEmpty())
    		// no removal is needed
    		return 0;
    	
    	// remove trees
    	// test 3 possible trees to be removed
    	Iterator<Integer> it = treesToRemove.iterator();
        while(it.hasNext()){
        	
        	// find pointer of the tree to test
        	i = it.next();
    		
        	// flag boolean to true
    		boolean canRemove = true;
    		
    		// test if can remove the thee
    		if(i-3>=0)
    			canRemove = canRemove && test3(A, i-3, i-2, i-1);
    		
    		if(i-2>=0 && i+1<A.length)
    			canRemove = canRemove && test3(A, i-2, i-1, i+1);
    		
    		if(i-1>=0 && i+2<A.length)
    			canRemove = canRemove && test3(A, i-1, i+1, i+2);
    		
    		if(i+3<A.length)
    			canRemove = canRemove && test3(A, i+1, i+2, i+3);	
    		
    		// if OK, than add as possible tree to be removed
    		if (canRemove)
    			vReturn++;
    	}
    
        // return the number of trees to remove, or -1 it it has no possible solution.
    	return (vReturn > 0 ? vReturn : -1);
    }
    
    /**
     * Test if sequence of 3 trees is aesthetically pleasing
     * @param A   : Vector with tree sizes
     * @param i1  : index of tree 1  X..
     * @param i2  : index of tree 2  .X.
     * @param i3  : index of tree 3  ..X
     * @return    : true if aesthetically pleasing
     */
    private boolean test3 (int[] A, int i1, int i2, int i3) {

    	// return if sequence of 3 trees is aesthetically pleasing
    	return ((A[i1]>A[i2] && A[i2]<A[i3]) || (A[i1]<A[i2] && A[i2]>A[i3]));
    }
}


//  my first wrong approach
//
//class SolutionT3 {
//    public int solution(int[] A) {
//        // write your code in Java SE 8
//    	
//    	if (A.length < 2)
//    		return 0;
//    	
//    	if (A.length == 2)
//    		if(A[0]==A[1])
//    			return 1;
//    		else
//    			return 0;
//    	
//    	boolean isUp = A[0]<A[1];
//    	
//    	int vReturn = 0;
//    	
//    	for(int j=1;j<A.length;j++) {
//    		
//    		isUp = A[0]<A[1];
//    		boolean isOk = true;
//	    	for(int i=1;i<A.length;i++) {
//	    		
//	    		if (j==i)
//	    			continue;
//	    		
//	    		if (isUp) {
//	    			if(A[i-1]>A[i]) {
//	    				isUp = false;
//	    			}
//	    			else {
//	    				isOk = false;
//	    				break;
//	    			}
//	    		} else {
//	    			if(A[i-1]<A[i]) {
//	    				isUp = false;
//	    			}
//	    			else {
//	    				isOk = false;
//	    				break;
//	    			}
//	    		}
//	    	}
//	    	if (isOk)
//	    		vReturn ++;
//	    		
//    	}
//    	return vReturn;
//    }
//
//}