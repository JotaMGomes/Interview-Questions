package Codechef;
//https://www.codechef.com/problems/TEST
//Jose Luiz Mattos Gomes

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
		
		// loop while vInput != 42
		while(vInput!=42) {

			// read stdin
			vInput = scn1.nextInt();
			
			// test if vInput = 42
			if(vInput!=42){
				
				// if not, print integer
	            System.out.println(vInput);
	        }
		}
		
		// close scanner
		scn1.close();
	}
}