package Amazon;
// Jose Luiz Mattos Gomes

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
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
			
		System.out.println("==========");
		System.out.println("==========");
		System.out.println("==========");
		
		Solution04_a vSolution_a = new Solution04_a();
		grid = Arrays.asList(
				Arrays.asList(0,1,1,0,1),
				Arrays.asList(0,1,0,1,0),
				Arrays.asList(0,0,0,0,1),
				Arrays.asList(0,1,0,0,0)
		       );
		System.out.println(vSolution_a.updateServerGrid_a(grid, rows, columns));
		
		grid = Arrays.asList(
				Arrays.asList(1,1,1,1,1),
				Arrays.asList(1,1,1,1,1),
				Arrays.asList(1,1,1,1,1),
				Arrays.asList(1,1,1,1,1)
		       );
		System.out.println("==========");
		System.out.println(vSolution_a.updateServerGrid_a(grid, rows, columns));
		
		grid = Arrays.asList(
			Arrays.asList(0,0,0,0,0),
			Arrays.asList(0,0,0,0,0),
			Arrays.asList(0,0,0,0,0),
			Arrays.asList(0,0,0,0,0)
	       );	
		System.out.println("==========");
		System.out.println(vSolution_a.updateServerGrid_a(grid, rows, columns));
		
		
		grid = Arrays.asList(
				Arrays.asList(1,0,0,0,0),
				Arrays.asList(0,0,0,0,0),
				Arrays.asList(0,0,0,0,0),
				Arrays.asList(0,0,0,0,0)
		       );	
		System.out.println("==========");
		System.out.println(vSolution_a.updateServerGrid_a(grid, rows, columns));
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


class Solution04_a {
	
	public int updateServerGrid_a(List<List<Integer>> grid, int rows, int columns) {
		
		// create a HashSet to store the indexes of zeros in the grid
		HashSet<String> listZeros = new HashSet<String>();
		
		// initialize return variable numHours with 0
		int numHours = 0;
		
		// flag to identify if at least one zero was found
		boolean myFlag = false;
		
		// loop through rows
		for(int r=0;r<rows;r++) {
			// loop through columns
			for(int c=0;c<columns;c++) {
				if(grid.get(r).get(c)==0) {
					// found a zero
					myFlag=true;
					if(!((c<columns-1 && grid.get(r).get(c+1)==1) || 
						 (c>0         && grid.get(r).get(c-1)==1) ||
						 (r<rows-1    && grid.get(r+1).get(c)==1) ||
						 (r>0         && grid.get(r-1).get(c)==1))
				      )
					{
						// keep key to delete from 
						listZeros.add(r+"#"+c);
					}
				}
			}
		}
		
		if(!myFlag)
			// all servers already have the file
			return 0;
		
		// update number of hours
		numHours++;
		
		// loop while there are zeros on the list
		while (listZeros.size()>0) {

			// list of keys to be removed from listZeros from each iteration
			ArrayList<String> listUpdate = new ArrayList<String>(); 
			
			// loop through all indexes of 0s
			Iterator<String> i=listZeros.iterator();
			while(i.hasNext()) {
			
				// transform key into row and column
				String[] strKey = i.next().split("#");
				Integer r = Integer.parseInt(strKey[0]);
				Integer c = Integer.parseInt(strKey[1]);
				
				// test if there all possible neighbors are on the the listZeros
				if((c<columns-1 && !listZeros.contains(r+"#"+(c+1))) ||
				   (c>0         && !listZeros.contains(r+"#"+(c-1))) ||
				   (r<rows-1    && !listZeros.contains((r+1)+"#"+c)) ||
				   (r>0         && !listZeros.contains((r-1)+"#"+c))
				  ) {
					// not all neighbors are 0s, so we can update this server
					// add this index to the list of indexes to be removed from HashSet
					listUpdate.add(r+"#"+c);
				} 
			}
			
			if(listUpdate.size()==0)
				// no possible solution
				return -1;
			
			// remove keys from list of zeros
			for(String strKey : listUpdate) {
				listZeros.remove(strKey);
			}
			
			// add an hour
			numHours++;
		}
		
		// return number of hours
		return numHours;
	}
}




