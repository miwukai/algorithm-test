package mergeKSortedLists_23;

import java.util.PriorityQueue;

import model.ListNode;

public class Solution {
	public ListNode mergeKLists(ListNode[] lists) {

		ListNode l1 = new ListNode(0);

		ListNode l2 = l1;

		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);

		for (ListNode node : lists) {
			if (node != null) {
				pq.add(node);
			}
		}

		while (!pq.isEmpty()) {
			ListNode n = pq.poll();
			
			l2.next = n;

			l2 = l2.next;

			if (n.next != null) {
				pq.add(n.next);
			}
		}

		return l1.next;

	}
}
