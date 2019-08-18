
public class Palindrome {
	public static boolean isPalindrome(int x) {
		if(x < 0)
			return false;
		int[] nums = new int [32];
		int i = 0;
		for(;x >= 10;i++) {
			nums[i] = x % 10;
			x /= 10;
		}
		nums[i] = x;
		for(int j=0; j<=i;j++) {
			if(nums[j] != nums[i-j])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(isPalindrome(1000000001));
	}
}
