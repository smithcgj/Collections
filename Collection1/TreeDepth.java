/**
 * 
 * 给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点。
 *
 */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class TreeDepth {
	 public static int maxDepth(TreeNode root) {
		 if(root == null) return 0;
	        return  deepMax(root,1);
	    }

	private static  int deepMax(TreeNode root, int i) {
		if(root.left ==null && root.right == null)
			return i;
		if(root.left != null && root.right ==null) {
			i++;
			return deepMax(root.left, i);
		}
		if(root.left == null && root.right != null) {
			i++;
			return deepMax(root.right,i);
		}
		if(root.left != null && root.right != null) {
			i++;
			return Math.max(deepMax(root.left, i), deepMax(root.right, i));
		}
		return 0;
		
	}
}
