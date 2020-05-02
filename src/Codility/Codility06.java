package Codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

// https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
// Jose Luiz Mattos Gomes

public class Codility06 {

	public static void main(String[] args) {
		
		
	Solution06 vSolution = new Solution06();
	
	int[] vA = new int[]{3,4,4,6,1,4,4};
	System.out.println(Arrays.toString(vSolution.solution(5, vA)));
	
	System.out.println("=====");
	
	Solution06b vSolutionb = new Solution06b();
	vA = new int[]{3,4,4,6,1,4,4};
	System.out.println(Arrays.toString(vSolutionb.solution(5, vA)));
	
	}

}

class Solution06 {
    public int[] solution(int N, int[] A) {
    	
    	HashMap<Integer,Integer> vMap = new HashMap<Integer, Integer>();
    	for(int i=1;i<=N;i++) {
    		vMap.put(i, 0);
    	}
    	int maxCount = 0;
    	
    	for(int i=0;i<A.length;i++) {
    		if(A[i]>N) {
    			for(int j=1;j<=N;j++) {
    				vMap.replace(j, maxCount);
				}
    		} else {
    			vMap.replace(A[i], vMap.get(A[i])+1);
    			if(vMap.get(A[i]) > maxCount) {
    				maxCount = vMap.get(A[i]);
    			}
    		}
    	}
    	
    	int[] vResult = new int[N];
    	for(int i=1;i<=N;i++) {
    		vResult[i-1]=vMap.get(i);
    	}
    	return vResult;
    }
}

class Solution06b {
    public int[] solution(int N, int[] A) {
    	//3,4,4,6,1,4,4
    	HashSet<Integer> vHS = new HashSet<Integer>();
    	int[] vResult = new int[N];

    	int maxCount = 0;
    	int lastUpdate = 0;
    	
    	for(int i=0;i<A.length;i++) {
    		if(A[i]>N) {
    			Iterator<Integer> it=vHS.iterator();
    			while(it.hasNext()) {
    				vResult[it.next()]=maxCount;
				}
    			vHS.clear();
    			lastUpdate = maxCount;
    		} else {
    			if(vResult[A[i]-1]==0)
    				vResult[A[i]-1] = lastUpdate;
    			vResult[A[i]-1]=vResult[A[i]-1]+1;
    			vHS.add(A[i]-1);
    			if (vResult[A[i]-1] > maxCount)
    				maxCount = vResult[A[i]-1];
    		}
    	}
    	
    	for(int i=0;i<N;i++) {
    		if (vResult[i]==0)
    			vResult[i] = lastUpdate;
    	}
    	
    	return vResult;
    }
}