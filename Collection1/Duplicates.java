
public class Duplicates {
	public static int removeDuplicate(int[] nums) {
		int len = nums.length;
		int j = 0;
		for(int i = 1; i < len; i++)
			if(nums[i] != nums[j])
				nums[++j] = nums[i];
		return j + 1;
	}
	public static void main(String[] args) {
		int[] nums = {1,1,2};
		System.out.println(removeDuplicate(nums));
		System.out.println(Print(nums));
	}
	public static String Print(int[] nums) {
		// TODO Auto-generated method stub
		String str = "[";
		for(int i =0; i < nums.length-1;i++) {
			str += nums[i]+",";
		}
		str += nums[nums.length - 1] +  "]";
		return str;
	}
}
