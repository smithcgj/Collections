

/**
 * 给定一个整数数组 nums ，
 * 找到一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 *
 */
public class MinArray {
	public static int maxSubArray(int[] nums) {
		int i = 0,num = 0,max = nums[0];
		
		while(i < nums.length) {
			num += nums[i];
			if(num < nums[i]) {
				num = nums[i];
			}
			if(num >= max && num >=nums[i]) {
				max = num;
			}
			else if(num >= max && num < nums[i]) {
				max = nums[i];
				num = nums[i];
			}
			i++;
		}
		return max;
	}
	public static void main(String[] args) {
		int[] arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(arr));
	}
}
