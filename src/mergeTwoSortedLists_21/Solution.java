package mergeTwoSortedLists_21;

import model.ListNode;

public class Solution {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode l3 = new ListNode(0);

		ListNode l4 = l3;

		while (l1 != null || l2 != null) {

			if ((l1 != null && l2 == null) || (l1 != null && l2 != null && l1.val <= l2.val)) {
				l4.next = new ListNode(l1.val);
				l4 = l4.next;
				l1 = l1.next;
			} else if ((l1 == null && l2 != null) || (l1 != null && l2 != null && l1.val > l2.val)) {
				l4.next = new ListNode(l2.val);
				l4 = l4.next;
				l2 = l2.next;
			}
		}

		return l3.next;

	}
}
