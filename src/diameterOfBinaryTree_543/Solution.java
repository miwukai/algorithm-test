package diameterOfBinaryTree_543;

import model.TreeNode;

public class Solution {
	
	int result = 0;
	
	public int diameterOfBinaryTree(TreeNode root) {
		if(root == null) return 0;
		
		int maxLeft = 0;
		
		int maxRight = 0;
		
		if(root.left != null) maxLeft = maxPath(root.left) + 1;
		
		if(root.right != null) maxRight = maxPath(root.right) + 1;
		
		result = Math.max(maxLeft+maxRight,result);
		
		return result;
	}
	
	int maxPath(TreeNode root) {
		int leftLength = 0;
		
		int rightLength = 0;
		
		if(root == null) return 0;
		
		if(root.left != null) leftLength = maxPath(root.left) + 1;
		
		if(root.right != null) rightLength = maxPath(root.right) + 1;
		
		result = Math.max(leftLength + rightLength,result);
		
		return Math.max(leftLength, rightLength);
		
	}
}
