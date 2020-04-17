package Amazon;
// Jose Luiz Mattos Gomes

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Amazon04 {

	public static void main(String[] args) {
		
		Solution04 vSolution = new Solution04();
		
		int rows = 4;
		int columns = 5;
	
		List<List<Integer>> grid = Arrays.asList(
			Arrays.asList(0,1,1,0,1),
			Arrays.asList(0,1,0,1,0),
			Arrays.asList(0,0,0,0,1),
			Arrays.asList(0,1,0,0,0)
	       );
		System.out.println(vSolution.updateServerGrid(grid, rows, columns));

		grid = Arrays.asList(
			Arrays.asList(1,1,1,1,1),
			Arrays.asList(1,1,1,1,1),
			Arrays.asList(1,1,1,1,1),
			Arrays.asList(1,1,1,1,1)
	       );
		System.out.println("==========");
		System.out.println(vSolution.updateServerGrid(grid, rows, columns));
		
		grid = Arrays.asList(
			Arrays.asList(0,0,0,0,0),
			Arrays.asList(0,0,0,0,0),
			Arrays.asList(0,0,0,0,0),
			Arrays.asList(0,0,0,0,0)
	       );	
		System.out.println("==========");
		System.out.println(vSolution.updateServerGrid(grid, rows, columns));
		
		
		grid = Arrays.asList(
				Arrays.asList(1,0,0,0,0),
				Arrays.asList(0,0,0,0,0),
				Arrays.asList(0,0,0,0,0),
				Arrays.asList(0,0,0,0,0)
		       );	
			System.out.println("==========");
			System.out.println(vSolution.updateServerGrid(grid, rows, columns));

	}

}


class Solution04 {
			
	public int updateServerGrid(List<List<Integer>> grid, int rows, int columns) {
		
		// initialize numHours with 0
		int numHours = 0;
		
		// create array to store 0s
		ArrayList<Integer[]> listZeros = new ArrayList<Integer[]>();
		
		// initialize array with all 0s of the grid
		createListZeros(listZeros, grid, rows, columns);
		
		// test if there is at least one 1
		if (listZeros.size() == rows * columns)
			return -1;
		
		// loop while exists 0s
		while (listZeros.size()>0) {
			
			// update number of hours
			numHours++;
			
			// new list to store 0s to update to 1
			ArrayList<Integer> listZeroToOne = new ArrayList<Integer>();
			
			// loop through list of zeros
			for(int p=0;p<listZeros.size();p++) {
				
				Integer[] posRC = new Integer[2];
				posRC[0] = listZeros.get(p)[0];
				posRC[1] = listZeros.get(p)[1];
				
				// test right
				if (posRC[1] < columns -1 && grid.get(posRC[0]).get(posRC[1]+1)==1) {
					listZeroToOne.add(p);
					continue;
				}
				
				// test left
				if (posRC[1] > 0 && grid.get(posRC[0]).get(posRC[1]-1)==1) {
					listZeroToOne.add(p);
					continue;
				}
				
				// test bottom
				if (posRC[0] < rows -1 && grid.get(posRC[0]+1).get(posRC[1])==1) {
					listZeroToOne.add(p);
					continue;
				}
				
				// test top
				if (posRC[0] > 0 && grid.get(posRC[0]-1).get(posRC[1])==1) {
					listZeroToOne.add(p);
					continue;
				}
			}
			
			// loop through list of updated servers
			for(int p=listZeroToOne.size()-1;p>=0;p--) {
				
				Integer[] posRC = new Integer[2];
				posRC[0] = listZeros.get(listZeroToOne.get(p))[0];
				posRC[1] = listZeros.get(listZeroToOne.get(p))[1];
				
				// update grid
				grid.get(posRC[0]).set(posRC[1],1);
				
				int index = listZeroToOne.get(p);
				listZeros.remove(index);
			}
			
//			System.out.println(grid);
//			System.out.println("====");
			
		}
		
		return numHours;
	}
	
	private void createListZeros(ArrayList<Integer[]> listZeros, List<List<Integer>> grid, int rows, int columns) {
			
		// loop through rows
		for(int r=0; r< rows; r++) {
			
			// loop through columns
			for(int c=0; c<columns;c++) {
				
				// add new pair
				if (grid.get(r).get(c)==0) {
					Integer[] myPair = new Integer[2];
					myPair[0]=r;
					myPair[1]=c;
					listZeros.add(myPair);
				}	
			}
		}
	}	
}