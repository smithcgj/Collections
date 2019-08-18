
public class TheRepeat {
	public  static  int removeElement(int[] nums, int val) {
		int len = nums.length;
		for(int i = 0;i < len; i++) {
			if(nums[i] == val) {
				for(int j = i; j < len - 1;j++)
					nums[j] = nums[j+1];
				len--;
				i--;
			}
		}
		return len;
	}
	public static void main(String[] args) {
		int[] nums = {2,2,3,3};
		int val = 3;
		System.out.println(removeElement(nums, val));
		System.out.println(Duplicates.Print(nums));
	}
}
