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
	
	// declare class variables
	
	// keep track of visited indexes
	private ArrayList<Integer> visited;
	
	// game array
	private int[] vGame;
	
	// leap
	private int vLeap;
	
	// flag to signal that the game finished OK
	private boolean vEnd;
	
	/**
	 * recursive method to decide if move is OK
	 * @param pos : index of the position to analyze
	 * @return    : true if move is OK, false if not
	 */
	private boolean canMove(int pos) {
		
		// if there is a solution found then return true
		if (vEnd)
			return true;
		
		// if position already visited then return false
		if (visited.contains(pos))
			return false;
		
		// keep track of all indexes visited
		visited.add(pos);
		
		// local variable to flag if the movement is OK or not
		boolean vReturn = true;
		
		// if position == 1 then invalid move
		if(vGame[pos]==1)
			return false;
		
		// test if a possible leap move wins the game
		if(vLeap>0 && pos+vLeap >= vGame.length) {
			vEnd = true;
			return true;
		}
		
		// test a leap movement
		if(vLeap>0 && vGame[pos+vLeap]==0)
			vReturn = canMove(pos+vLeap);
		else
			vReturn = false;
		
		// test one movement right
		if (!vReturn) 
			if(pos+1 < vGame.length) 
				vReturn = canMove(pos+1);
			else {
				// signal that the game has a winner
				vEnd = true;
				return true;
			}
		
		// test one movement left
		if (!vReturn)
			if(pos>0)
				vReturn = canMove(pos-1);
			else
				return false;
		
		// return if movement is OK
		return vReturn;
	}
	
    public boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
		
    	// update class variables
    	visited = new ArrayList<Integer>();
		vGame = game;
		vLeap = leap;
		vEnd = false;
		
		// call recursive method
    	return canMove(0);
    }
}