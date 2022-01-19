package BinaryTreeZigzagLevelOrderTraversal_103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import model.TreeNode;

public class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> li = new ArrayList<List<Integer>>();

		if (root == null) {
			return li;
		}

		Queue<TreeNode> qu = new LinkedList<TreeNode>();

		Stack<Integer> st = new Stack<Integer>();

	    qu.add(root);

		int direction = 1;

		while (qu.size() != 0) {

			List<Integer> tempLi = new ArrayList<Integer>();

			int size = qu.size();

			for (int i = 0; i < size; i++) {

				TreeNode currentNode = qu.poll();

				if (currentNode.left != null)
					qu.add(currentNode.left);

				if (currentNode.right != null)
					qu.add(currentNode.right);

				if (direction == 1) {
					tempLi.add(currentNode.val);
				} else {
					st.add(currentNode.val);
				}
			}
			
			while(st.size() != 0) {
				tempLi.add(st.pop());
			}

			li.add(tempLi);
			
			direction *= -1;
		}

		return li;

    }
}
