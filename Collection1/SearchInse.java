
public class SearchInse {
	public int searchInsert(int[] nums,int target) {
		int index = 0;
		int i = 0;
		for(;i < nums.length; i++) {
			if(nums[i] > target)
				break;
		}
		if(i == nums.length) {
			index = nums.length;
		}else {
			index = i - 1;
		}
			
		return index;
	}
}
