/**
 * 
 *给定两个二叉树，编写一个函数来检验它们是否相同。
如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class SameTree {
	 public static boolean isSameTree(TreeNode p, TreeNode q) {
		  if(p ==null && q == null) return true;
          if(p ==null && q != null || p != null && q==null) return false;
          if(p.val != q.val) return false;
	        if(p.right == null && q.right != null || p.right != null && q.right == null)
	        	return false;
	        if(p.left == null && q.left != null || p.left != null && q.left == null)
	        	return false;
	        if(p.left !=null && p.right == null)
	        	return isSameTree(p.left,q.left);
	        if(p.left ==null && p.right != null)
	        	return isSameTree(p.right, q.right);
          if(p.left != null && p.right != null)
              return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
	        return p.val == q.val;
	    }
}
