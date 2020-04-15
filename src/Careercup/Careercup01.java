package Careercup;
// https://www.careercup.com/question?id=21263687
// Jose Luiz Mattos Gomes

public class Careercup01 {

	public static void main(String[] args) {
		Solution01 vSolution = new Solution01();

		int[] vInput1 = {6,1,5,6,6,4};
		vSolution.countElements(vInput1);
		System.out.println("===");
		
		int[] vInput2 = {1,1,1};
		vSolution.countElements(vInput2);
		System.out.println("===");
		
		int[] vInput3 = {3,3,3};
		vSolution.countElements(vInput3);
	}

}


class Solution01 {
	 public void countElements(int[] vElement) {
		 
		 // define array to store result
		 int[] vResult = new int[vElement.length];
		 
		 // interact through input array to identify elements
		 for(int i=0; i<vElement.length;i++) {
			 
			 // store 
			 vResult[vElement[i]-1]+=1;
		 }
		 
		 // print final array
		 for(int i=0; i<vResult.length;i++) {
			 System.out.println("Elem: "+ (i+1) + " Count: " + vResult[i]);
		 }

	 }
}