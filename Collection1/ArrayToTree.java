/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 *
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class ArrayToTree {
	 public TreeNode sortedArrayToBST(int[] nums) {
	        return sortedArrayToBST(nums,0,nums.length);
	    }

	private TreeNode sortedArrayToBST(int[] nums, int beginIndex, int endIndex) {
		if(beginIndex == endIndex) {
			return null;
		}
		int mid = (beginIndex + endIndex) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums,beginIndex,mid);
		root.right = sortedArrayToBST(nums,mid + 1,endIndex);
		return root;
	}
}
