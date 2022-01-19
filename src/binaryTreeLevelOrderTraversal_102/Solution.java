package binaryTreeLevelOrderTraversal_102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.TreeNode;

public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> li = new ArrayList<List<Integer>>();

		if (root == null) {
			return li;
		}

		Queue<TreeNode> qu = new LinkedList<TreeNode>();

		qu.add(root);

		while (qu.size() != 0) {

			List<Integer> tempLi = new ArrayList<Integer>();

			int size = qu.size();

			for (int i = 0; i < size; i++) {

				TreeNode currentNode = qu.poll();

				tempLi.add(currentNode.val);

				if (currentNode.left != null)
					qu.add(currentNode.left);

				if (currentNode.right != null)
					qu.add(currentNode.right);

			}

			li.add(tempLi);

		}

		return li;

	}
}
