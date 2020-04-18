package Codechef;
//https://www.codechef.com/problems/TEST
//Jose Luiz Mattos Gomes

import java.util.ArrayList;
import java.util.Scanner;

public class Codechef01 {

	public static void main(String[] args) {
		Solution01 vSolution = new Solution01();
		vSolution.readUntil42();
	}

}

class Solution01 {
	public void readUntil42() {
		
		// define scanner to read from keyboard
		Scanner scn1 = new Scanner(System.in);
		
		// define integer variable
		int vInput = 0;
		
		// define list to store numbers
		ArrayList<Integer> vList = new ArrayList();
		
		// loop while vInput != 42
		while(vInput!=42) {
			
				// read from keyboard
				vInput = scn1.nextInt();
				
				// test input data
				//   input are integers of one or two digit
				if(Math.abs(vInput) < 100) {
					vList.add(vInput);
				}		

		}
		
		for(Integer i: vList) {
			System.out.println(i);
		}
		
		// close scanner
		scn1.close();
	}
}