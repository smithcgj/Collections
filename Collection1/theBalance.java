/**
 * 
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 */
public class theBalance {
	boolean res = true;
	 public boolean isBalanced(TreeNode root) {
		 helper(root);
		 return res;
	 }
	private int helper(TreeNode root) {
		if(root == null) return 0;
		int right = helper(root.right) + 1;
		int left = helper(root.left) + 1;
		if(Math.abs(left -right) > 1) res = false;
		return Math.max(right, left);
	}
	 
}
