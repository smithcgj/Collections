/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
	说明: 叶子节点是指没有子节点的节点。
 *
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class PathNum {
public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) 
        	return false;
        sum = sum - root.val;
        if(root.left == null && root.right == null)
        	return (sum == 0);
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
