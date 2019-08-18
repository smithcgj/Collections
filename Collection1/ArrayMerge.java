/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:


	初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
	你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class ArrayMerge {
	public static int[] merge(int[]nums1,int m,int[] nums2,int n) {
		if(m == 0) nums1 = nums2;
		else {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m;j++) {
					if(nums1[j] <= nums2[i] && nums1[j + 1] > nums2[i]) {
						int k = m ;
						for( ; k > j + 1; k--) {
							nums1[k] = nums1[k -1];
						}
						nums1[k] = nums2[i];
						m++;
						break;
					}
				}
				if(nums2[i] >= nums1[m - 1]) {
					nums1[m] = nums2[i];
					m++;
				}
					
			}
		}
		
		return nums1;
	}
	public static void main(String[] args) {
		int[] nums1 = new int[] {0};
		int[] nums2 = new int[] {1};
		System.out.println(printArr(merge(nums1, 0, nums2, 1)));
	}
	private static String printArr(int[] arr) {
		StringBuilder stb = new StringBuilder();
		stb.append("[");
		int i = 0;
		for (; i < arr.length - 1; i++) {
			stb.append(arr[i] + ",");
		}
		stb.append(arr[i] + "]");
		return stb.toString();
	}
}
