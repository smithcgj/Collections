/**
 * 
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plus-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class ThePlus {
	public static int[] plusOne(int[] digits) {
		digits[digits.length - 1] += 1;
		int i = digits.length - 2;
		while(i >= 0) {
			if(digits[i + 1] == 10)
				digits[i]++;
			i--;
		}
		if(digits[0] == 10) {
			int[] tar = new int[digits.length + 1];
			tar[0] = 1;
			return tar;
		}
		for(int j = 1;j < digits.length;j++)
			if(digits[j] == 10)
				digits[j] = 0;
		return digits;
		
	}
	public static void main(String[] args) {
		int[] arr = new int[] {9,9,8};
		System.out.println(printArr(plusOne(arr)));
	}
	public static String printArr(int[] nums) {
		String str = "[";
		int i = 0;
		for(; i< nums.length - 1; i++)
			str += nums[i] + ",";
		str += nums[i] + "]";
		return str;
	}
}
