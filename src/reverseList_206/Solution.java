package reverseList_206;

import model.ListNode;

public class Solution {

	public ListNode reverseList(ListNode head) {
		
		if(head == null) return head;
		
		ListNode prev = null;
		
		ListNode present = head;
		
		ListNode next = head.next;
		
		while(present != null) {
			present.next = prev;
			
			prev = present;
			
			present = next;
			
			if(next != null) next = next.next;
		}
		
		return prev;
	}

}
