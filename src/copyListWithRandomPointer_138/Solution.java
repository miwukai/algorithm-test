package copyListWithRandomPointer_138;

import model.RandomNode;

public class Solution {
	public RandomNode copyRandomList(RandomNode head) {

		if(head == null) return null;

		RandomNode tempNode = head;

		while (tempNode != null) {
			RandomNode rn = new RandomNode(tempNode.val);

			rn.next = tempNode.next;

			tempNode.next = rn;

			tempNode = rn.next;
		}

		tempNode = head;

		while (tempNode != null) {
            if(tempNode.random != null){
                tempNode.next.random = tempNode.random.next;
            } else {
                tempNode.next.random = null;
            }
			

			tempNode = tempNode.next.next;
		}

		RandomNode result = head.next;

		tempNode = head;

		while (tempNode != null) {
            
            RandomNode no = tempNode.next.next;
            
            if(tempNode.next.next != null){
                tempNode.next.next = tempNode.next.next.next;
            }else{
                tempNode.next.next = null;
            }
            
            tempNode.next = no;

			tempNode = no;

		}

		return result;
	}

}
