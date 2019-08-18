/**
 * 
 *给定一个二叉树，返回其节点值自底向上的层次遍历。 
 *（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 */
import java.util.*;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class LevelBottom {
	
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        levelOrderBottom(root,res,0);
	        Collections.reverse(res);
	        return res;
	    }

	private List<List<Integer>> levelOrderBottom(TreeNode root, List<List<Integer>> res, int height) {
		if(root == null) return null;
		if(res.size() <= height) res.add(new ArrayList<Integer>());
		
		res.get(height).add(root.val);
		height++;
		levelOrderBottom(root.left, res, height);
		levelOrderBottom(root.right, res, height );
		
		return res;
	}
}
