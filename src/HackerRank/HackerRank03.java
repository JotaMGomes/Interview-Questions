package HackerRank;

import java.util.ArrayList;

// https://www.hackerrank.com/challenges/java-1d-array/problem
// Jose Luiz Mattos Gomes

public class HackerRank03 {

	public static void main(String[] args) {
		Solution03 vSolution = new Solution03();
		int[] game;
		
	    game = new int[]{0,0,0,0,0};
		System.out.println(vSolution.canWin(3, game) ? "YES" : "NO");
		System.out.println("=====");
		
		game = new int[]{0,0,0,1,1,1};
		System.out.println(vSolution.canWin(5, game) ? "YES" : "NO");
		System.out.println("=====");
		
		game = new int[]{0,0,1,1,1,0};
		System.out.println(vSolution.canWin(3, game) ? "YES" : "NO");
		System.out.println("=====");
		
		game = new int[]{0,1,0};
		System.out.println(vSolution.canWin(1, game) ? "YES" : "NO");
		System.out.println("=====");
		
		
		game = new int[]{0,0};System.out.println(vSolution.canWin(0, game) ? "YES" : "NO");


	}

}

class Solution03 {
	
	private ArrayList<Integer> visited;
	private int[] vGame;
	private int vLeap;
	private boolean vEnd;
	
	private boolean canMove(int pos) {
		
		if (vEnd)
			return true;
		
		if (visited.contains(pos))
			return false;
		
		visited.add(pos);
		
		boolean vReturn = true;
		
		if(vGame[pos]==1)
			return false;
		
		if(vLeap>0 && pos+vLeap >= vGame.length) {
			vEnd = true;
			return true;
		}
		
		if(vLeap>0 && vGame[pos+vLeap]==0)
			vReturn = canMove(pos+vLeap);
		else
			vReturn = false;
		
		if (!vReturn) 
			if(pos+1 < vGame.length) 
				vReturn = canMove(pos+1);
			else {
				vEnd = true;
				return true;
			}
		
		
		if (!vReturn)
			if(pos>0)
				vReturn = canMove(pos-1);
			else
				return false;
		
		return vReturn;
	}
	
    public boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
		
    	visited = new ArrayList<Integer>();
		vGame = game;
		vLeap = leap;
		vEnd = false;
		
		if(game.length==1)
			return true;
		
    	return canMove(0);
    }
}