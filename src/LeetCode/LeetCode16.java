package LeetCode;
// https://leetcode.com/problems/arranging-coins/
// Jose Luiz Mattos Gomes
public class LeetCode16 {

	public static void main(String[] args) {
		Solution16 vSolution = new Solution16();
		
		System.out.println(vSolution.arrangeCoins(5));
		System.out.println("==========");
		System.out.println(vSolution.arrangeCoins(8));
		System.out.println("==========");
		System.out.println(vSolution.arrangeCoins(0));
		System.out.println("==========");
		System.out.println(vSolution.arrangeCoins(2147483647));

	}

}

class Solution16 {
	public int arrangeCoins(int n) {
		
		// zero or negative numbers, return 0
		if(n<1)
			return 0;
		
		// initialize variables
		long acc = 0;       // accumulator
		long counter = 0;   // counter
		
		// loop while accumulator <= n
		while (acc <= n) {
			counter++;      // increment counter
			acc+=counter;   // update accumulator
		}
		
		// return counter minus 1
        return (int)counter-1;
    }
}