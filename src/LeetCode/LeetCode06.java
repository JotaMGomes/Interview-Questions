package LeetCode;

public class LeetCode06 {

	public static void main(String[] args) {
		
		Solution06i vSolution = new Solution06i();
		
		ListNode vHead = new ListNode(1);
		ListNode vAux = vHead.next;

		vAux.next = new ListNode(2);
		vAux = vHead.next;
		vAux.next = new ListNode(3);
		vAux = vAux.next;
		vAux.next = new ListNode(4);
		vAux = vAux.next;
		vAux.next = new ListNode(5);
		
		
		
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
 
class Solution06i {
    public ListNode reverseList(ListNode head) {
    	
    	if(head == null)
    		return null;
    	
    	ListNode vAux1 = head;
    	ListNode vReturn = new ListNode(head.val);
    	
    	while(vAux1.next != null) {
    		ListNode vAux2 = new ListNode(vAux1.next.val);
    		vAux2.next = vReturn;
    		vReturn = vAux2;
    	}
    	
        return vReturn;
    }
}