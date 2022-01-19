package lowestCommonAncestor_236;

public class Solution {
	
	TreeNode lca;
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		return lowestCommonAncestorRec(root,p,q);
		
	}
	
	public TreeNode lowestCommonAncestorRec(TreeNode root, TreeNode p, TreeNode q) {

		if(lca != null) return null;
		
		if(root == null || root.equals(p) || root.equals(q)) return root;
		
		TreeNode left = lowestCommonAncestorRec(root.left, p, q);
		
		TreeNode right = lowestCommonAncestorRec(root.right, p, q);
		
		if(left != null && right != null) {
			lca = root;
			return lca;
		}
		
		return left == null ? right : left;
		
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
