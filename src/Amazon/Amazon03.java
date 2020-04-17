package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Amazon03 {

	public static void main(String[] args) {
		
		Solution03 vSolution = new Solution03();
		
		int rows = 5;
		int columns = 4;
		
		List<List<Integer>> grid = Arrays.asList(
				Arrays.asList(1,1,0,0),
				Arrays.asList(0,0,1,0),
				Arrays.asList(0,0,0,0),
				Arrays.asList(1,0,1,1),
				Arrays.asList(1,1,1,1)
               );
		System.out.println(vSolution.findNumClusters(grid, rows, columns));
		
	    grid = Arrays.asList(
				Arrays.asList(0,0,0,0),
				Arrays.asList(0,0,0,0),
				Arrays.asList(0,0,0,0),
				Arrays.asList(0,0,0,0),
				Arrays.asList(0,0,0,0)
				);	
		System.out.println("==========");
		System.out.println(vSolution.findNumClusters(grid, rows, columns));	


		grid = Arrays.asList(
				Arrays.asList(1,1,1,1),
				Arrays.asList(1,1,1,1),
				Arrays.asList(1,1,1,1),
				Arrays.asList(1,1,1,1),
				Arrays.asList(1,1,1,1)
				);	
		System.out.println("==========");
		System.out.println(vSolution.findNumClusters(grid, rows, columns));

	}

}

class Solution03 {
	
	// define grid N*M for calculations
	private ArrayList<ArrayList<Integer>> gridClust;
	
	public int findNumClusters(List<List<Integer>> grid, int rows, int columns) {
		
		// initialize gridClust;
		gridClust = new ArrayList<ArrayList<Integer>>();
		
		// initialize numClust to 0 || number of clusters
		int numClust = 0;
		
		// create grid with 0 values 
		createGridClust(rows, columns);
		
		// loop through rows 
		for(int r=0; r< rows; r++) {
			
			// loop through columns 
			for(int c=0; c<columns;c++) {
				
				// if it is an 1, and is not part of a cluster yet
				if(grid.get(r).get(c)==1 && gridClust.get(r).get(c)==0) {
					
					// update numClust and update gridClust 
					numClust ++; 
					updateGridCluster(grid, r, c, numClust, rows, columns);
				}
			}
		}
		
		// return number of clusters
		return numClust;
	}
	
	// create empty cluster N*M
	private void createGridClust(int rows, int columns){
		
		// loop through rows
		for(int r=0; r< rows; r++) {
			
			// create empty array
			ArrayList<Integer> alC = new ArrayList<Integer>();
			
			// loop through columns
			for(int c=0; c<columns;c++) {
				
				// add new column
				alC.add(0);
			}
			
			// add new row
			gridClust.add(alC);
		}
	}
	
	
	// recursive function to update cluster
	private void updateGridCluster(final List<List<Integer>> grid, final int r, final int c, final int numClust, final int rows, final int columns) {
		
		//System.out.println(String.valueOf(r) + "|" + String.valueOf(c) + "|" + String.valueOf(numClust));
		
		// update gridCluster (r,c) with numClust
		gridClust.get(r).set(c, numClust);
		
		// test right cell
		if (c<columns-1 && grid.get(r).get(c+1)==1 && gridClust.get(r).get(c+1)==0) {
			updateGridCluster(grid, r, c+1, numClust, rows, columns);
		}
		
		// test left cell
		if (c>0 && grid.get(r).get(c-1)==1 && gridClust.get(r).get(c-1)==0) {
			updateGridCluster(grid, r, c-1, numClust, rows, columns);
		}
		
		// test bottom cell
		if (r<rows-1 && grid.get(r+1).get(c)==1 && gridClust.get(r+1).get(c)==0) {
			updateGridCluster(grid, r+1, c, numClust, rows, columns);
		}
		
		// test up cell
		if (r>0 && grid.get(r-1).get(c)==1 && gridClust.get(r-1).get(c)==0) {
			updateGridCluster(grid, r-1, c, numClust, rows, columns);
		}
	}	
}