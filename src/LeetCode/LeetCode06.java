package LeetCode;
// https://leetcode.com/problems/reverse-linked-list/
// Jose Luiz Mattos Gomes


public class LeetCode06 {

	public static void main(String[] args) {
		
		Solution06i vSolution = new Solution06i();
		
		ListNode vHead = new ListNode(1);
		
		ListNode vPointer = new ListNode(2);
		vHead.next = vPointer;
		vPointer = vHead.next;
		
		ListNode vNewNode = new ListNode(3);
		vPointer.next = vNewNode;
		vPointer = vNewNode;

		vNewNode = new ListNode(4);
		vPointer.next = vNewNode;
		vPointer = vNewNode;
		
		vNewNode = new ListNode(5);
		vPointer.next = vNewNode;
		vPointer = vNewNode;
		
		printList(vHead);
		printList(vSolution.reverseList(vHead));
		
		Solution06r vSolutionR = new Solution06r();
		printList(vSolutionR.reverseList(vHead));
			
	}
	
	private static void printList(ListNode head) {
		
		ListNode vAux = head;
		while(vAux!=null) {
			System.out.print(vAux.val);
			System.out.print("->");
			vAux = vAux.next;
		}
		System.out.println("NULL");
	}

}

/**
 * Definition for singly-linked list.
 */
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 
// iteratively
class Solution06i {
    public ListNode reverseList(ListNode head) {
    	
    	// test if list is null
    	if(head == null)
    		return null;
    	
    	// crate a new node and point it to head
    	ListNode vPointer = null;
    	vPointer = head;
    	
    	// create a new list that will be the returning list
    	// point first node to head
    	ListNode vReturn = new ListNode(head.val);
    	
    	// create temporary node
    	ListNode vAux = null;
    	
    	// interact through input list
    	while(vPointer.next != null) {
    		
    		// update pointer to next node
    		vPointer = vPointer.next;

    		// set temporary node to head of returning list
    		vAux = vReturn;
    		
    		// create new head for returning list and point next node
    		//   to old head (temporary node)
    		vReturn = new ListNode(vPointer.val);
    		vReturn.next = vAux;
    	}
    	
    	// return reversed list
        return vReturn;
    }
}

// recursively
class Solution06r {
	
	// declare null node as returning list
	ListNode vReturn = null;
	
	public ListNode reverseList(ListNode head) {	
		
		// test if head is null
		if(head == null)
			
			// return list
			return vReturn;
		
		// create new node and point it to actual returning head
		ListNode vAux = null;
		vAux = vReturn;
		
		// create new head for returning list and point it to aux node
		vReturn = new ListNode(head.val);
		vReturn.next = vAux;
		
		// call function recursively with next node
		return reverseList(head.next);
	}
	 

}