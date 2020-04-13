package LeetCode;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/ 
// Jose Luiz Mattos Gomes

public class LeetCode15 {

	public static void main(String[] args) {
		Solution15 vSolution = new Solution15();

		int[] vInput1 = {7,1,5,3,6,4};
		System.out.println(vSolution.maxProfit(vInput1));
		
		int[] vInput2 = {};
		System.out.println(vSolution.maxProfit(vInput2));
		
		int[] vInput3 = {3,2,6,1,3};
		System.out.println(vSolution.maxProfit(vInput3));

		System.out.println("===");
		Solution15b vSolutionb = new Solution15b();
		System.out.println(vSolutionb.maxProfit(vInput1));
		System.out.println(vSolutionb.maxProfit(vInput2));
		System.out.println(vSolutionb.maxProfit(vInput3));
		
	}
}

class Solution15 {
    public int maxProfit(int[] prices) {
    
    	// initialize var to keep max profit
    	int vResult = 0;
    	
    	// interact through prices elements
    	for(int i=0;i<prices.length-1;i++){
    		
    		// interact througn prices from i+1 element
    		for(int j=i+1;j<prices.length;j++) {
    			if(prices[j]-prices[i]>vResult)
    				// if prices[j] - prices[i] > max then store new value
    				vResult = prices[j]-prices[i];
    		}
    	}
    	
    	// return max profit
    	return vResult;
    }	
}

class Solution15b {
	public int maxProfit(int[] prices) {
		
		// define minPrice as max int possible
		int minPrice = Integer.MAX_VALUE;
		
		// define vProfit as min possible 0
		int vProfit = 0;
		
		// interact through prices
		for(int i=0;i<prices.length;i++) {
			
			// test if current element is smaller than minPrice
			if(prices[i] < minPrice)
				// update minPrice
				minPrice = prices[i];
			// test if profit is higher than vProfit
			else if(prices[i] - minPrice > vProfit)
				// update vProfit
				vProfit = prices[i] - minPrice;
		}
		
		// return vProfit as maxProfit found
		return vProfit;
	}
}