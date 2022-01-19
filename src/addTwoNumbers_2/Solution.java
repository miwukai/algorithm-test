package addTwoNumbers_2;

public class Solution {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode p = l1;
		
		ListNode q = l2;
		
		ListNode h = new ListNode(0);
		
		ListNode k = h;
		
		int carry = 0;
		
		while (p!=null || q!=null || carry != 0) {
			
			int s = (p!=null?p.val:0) + (q!=null?q.val:0) + carry;
			
			k.next = new ListNode(s%10);
			
			carry = s/10;
			
			p = p!=null?p.next:null;
			
			q = q!=null?q.next:null;
			
			k = k.next;
			
		}

		return h.next;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		ListNode l1 = s.new ListNode(0);
		
		ListNode l2 = s.new ListNode(7);
		
		l2.next = s.new ListNode(3);
		
		ListNode n = s.addTwoNumbers(l1,l2);
		
	}
}
