package Codility;

public class Test01 {

	public static void main(String[] args) {
		
		SolutionT1 vSolution = new SolutionT1();

        System.out.println(vSolution.solution(""));
        System.out.println(vSolution.solution("b"));
        System.out.println(vSolution.solution("ab"));
        System.out.println(vSolution.solution("aabb"));
        System.out.println(vSolution.solution("aabab"));
        System.out.println(vSolution.solution("bb"));
        System.out.println(vSolution.solution("bba"));
        System.out.println(vSolution.solution("ba"));
	}

}


class SolutionT1 {
    public boolean solution(String S) {

    	// if String is empty, return true
    	if(S.length()==0)
    		return true;
    	
    	// define chr as 'a'
    	char chr = 'a';
    	
    	// define boolean changed as false
    	boolean changed = false;
    	
    	// if first char is a 'b' then flag changed to true and change chr to 'b'
    	if (S.charAt(0)=='b') {
    		changed = true;
			chr = 'b';
    	}
    	
    	// loop through array S 
    	for(int i=1; i<S.length(); i++) {
    		
    		if(S.charAt(i)!=chr) {
    		// char is different than last char
    			if (changed)
    				// there is already a change so, return false
    				return false;
    			
    			// flag changed to true
    			changed = true;
    			
    			// set new expected char
    			chr = 'b';
    		}
    	}
    	
    	// return true
    	return true;
    }
}