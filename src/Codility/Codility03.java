package Codility;
// https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
// Jose Luiz Mattos Gomes

public class Codility03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution03 vSolution = new Solution03();
		
		System.out.println(vSolution.solution(10, 85, 30));

	}

}

class Solution03 {
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
    	
    	int numJumps = (Y - X) / D;
    	if ((Y - X) % D > 0)
    		numJumps++;
    	
    	return numJumps;
    }
}