/**
 * 
 * 给定一个二叉树，检查它是否是镜像对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class SymmetricTree {
	public static boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		if(root.left == null && root.right == null)
			return true;
		if(root.left == null && root.right != null ||root.left != null && root.right == null )
			return false;
		return mirSymmeric(root.right,root.left);
        
    }

	private static  boolean mirSymmeric(TreeNode rightTree, TreeNode leftTree) {
		if (rightTree.val != leftTree.val) return false;
		if(rightTree.left != null && leftTree.right == null ||rightTree.left == null && leftTree.right != null)
			return false;
		if(rightTree.right != null && leftTree.left ==null || rightTree.right == null && leftTree.left !=null)
			return false;
		if(rightTree.left ==null && rightTree.right == null &&leftTree.left ==null && leftTree.right == null)
			return true;
		if(rightTree.left ==null && rightTree.right != null)
			return mirSymmeric(rightTree.right, leftTree.left);
		if(rightTree.left !=null && rightTree.right == null)
			return mirSymmeric(rightTree.left, leftTree.right);
		return mirSymmeric(rightTree.left, leftTree.right) && mirSymmeric(rightTree.right, leftTree.left);
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(3);
		System.out.println(isSymmetric(root));
	}
}
