/**
 * 
 * 给定一个二叉树，找出其最小深度。
	最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class MInTreeDeepth {
	 public int minDepth(TreeNode root) {
			if(root == null) return 0;
	        return minDeep(root,1);
	    }

	private int minDeep(TreeNode root, int i) {
		if(root.left ==null && root.right == null)
			return i;
		if(root.left != null && root.right ==null) {
			i++;
			return minDeep(root.left, i);
		}
		if(root.left == null && root.right != null) {
			i++;
			return minDeep(root.right,i);
		}
		if(root.left != null && root.right != null) {
			i++;
			return Math.min(minDeep(root.left, i), minDeep(root.right, i));
		}
		return 0;
	}
}
