package binaryTreeMaximumPathSum_124;

import model.TreeNode;

public class Solution {
	
	Integer result ;

	public int maxPathSum(TreeNode root) {
		
	    result = root.val;
				
		maxSum(root);

		return result;

	}

	public Integer maxSum(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		int maxSum = root.val;

		if (root.left == null && root.right == null) {
			
			if(result < maxSum) result = maxSum;   
			
			return maxSum;
		}

		Integer leftSum = maxSum(root.left);

		Integer rightSum = maxSum(root.right);
		
		Integer maxLeftSum = root.val;
		
		Integer maxRightSum = root.val;

		if (leftSum != null && leftSum >= 0) {
			maxSum += leftSum;
			
			maxLeftSum += leftSum;
		}

		if (rightSum != null && rightSum >= 0) {
			maxSum += rightSum;
			
			maxRightSum += rightSum;
		}
		
		if(result < maxSum) result = maxSum;   
		
		return maxLeftSum > maxRightSum ? maxLeftSum : maxRightSum;
	}

}
