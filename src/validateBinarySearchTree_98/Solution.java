package validateBinarySearchTree_98;

import model.TreeNode;

public class Solution {
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;

		return isValid(root.left, -2147483649L, Long.valueOf(root.val))
				&& isValid(root.right, Long.valueOf(root.val), 2147483648L);
	}

	boolean isValid(TreeNode root, Long min, Long max) {

		if (root == null)
			return true;

		boolean result = root.val > min && root.val < max;

		min = Math.min(min, root.val);

		max = Math.max(max, root.val);

		if (result)
			result = isValid(root.left, min, Long.valueOf(root.val))
					&& isValid(root.right, Long.valueOf(root.val), max);

		return result;
	}

}
