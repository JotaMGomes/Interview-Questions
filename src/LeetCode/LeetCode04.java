package LeetCode;
// https://leetcode.com/problems/maximum-depth-of-binary-tree/
// Jose Luiz Mattos Gomes
public class LeetCode04 {

	public static void main(String[] args) {
		
		Solution04 vSolution = new Solution04();
		
		TreeNode bt1 = new TreeNode(3);
		bt1.left = new TreeNode(9);
		bt1.right = new TreeNode(20);
		
		TreeNode aux = bt1.right;
		aux.left = new TreeNode(15);
		aux.right = new TreeNode(7);

		System.out.println(vSolution.maxDepth(bt1));
		
		//-----------------
		
//	     3
//	    / \
//	   9  20
//	     /  \
//	    15   7	
//     /  \	
//    12  16
//      \
//     	13	
	    
		TreeNode bt2 = new TreeNode(3);
		bt2.left = new TreeNode(9);
		bt2.right = new TreeNode(20);
		
		aux = bt2.right;
		aux.left = new TreeNode(15);
		aux.right = new TreeNode(7);
		
		aux = aux.left;
		aux.left = new TreeNode(12);
		aux.right = new TreeNode(16);	
		
		aux = aux.left;
		aux.right = new TreeNode(13);

		System.out.println(vSolution.maxDepth(bt2));
		
		//----
		
		TreeNode bt3 = null;
		System.out.println(vSolution.maxDepth(bt3));	
		
		//----
		
		TreeNode bt4 = new TreeNode(3);
		System.out.println(vSolution.maxDepth(bt4));
		
		/**
		 * tests with solution b		
		 */
		Solution04b vSolutionb = new Solution04b();
		
		System.out.println(vSolutionb.maxDepth(bt1));
		System.out.println(vSolutionb.maxDepth(bt2));
		System.out.println(vSolutionb.maxDepth(bt3));	
		System.out.println(vSolutionb.maxDepth(bt4));		
	}

}

/*
 * tests:
 * 1. if tree is null
 * 
 */


 // Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { 
    	val = x; 
    }
  }
 
class Solution04 {
	
	// define vResult to store maxDepth
	public int vResult;
  
	public int maxDepth(TreeNode root) {
		
		vResult = 1;
		
		// test if tree is null
		if(root==null)
			//throw new IllegalArgumentException("The tree is empty.");
			return 0;
    	
    	// call recursive function to interact through binary tree
		downTreeRecursive(root, vResult);
       
		// return maxDepth
    	return vResult;
    }
    
	/**
	 * resursive function to interact through binary tree 
	 * @param node: node
	 * @param step: current depth
	 */
    private void downTreeRecursive(TreeNode node, int step) {
    	
    	// if there is a leaf on the left, go down left
    	if(node.left != null){
    		downTreeRecursive(node.left, step+1);
    	}
    	
    	// if there is a leaf on the left, go down left
    	if(node.right != null){
    		downTreeRecursive(node.right, step+1);
    	}
    	
    	// test max depth
    	if (step > vResult) { 
    		
    		// update vResult value
    		vResult = step; 
    	};
    }
}



class Solution04b {
	
	public int maxDepth(TreeNode root) {
		
		if(root==null)
			// if it is a leaf, return 0
			return 0;
		else
			// add 1 and test left and right deep
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
