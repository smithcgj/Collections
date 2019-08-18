
public class Reverse {
	public static int reverse(int x) {
		boolean flag =true;
		if(x < 0) {
			flag = false;
			x = 0 - x;
		}
		int [] nums = new int [32];
		int i=0;
		long num = 0;
		for(;x>=10;i++) {
			nums[i] = x % 10;
			x /= 10;
		}
		nums[i] = x;
		for(int j = 0;j <= i;j++) {
			num = nums[j]+num*10;
		}
		if(!flag) num = 0 - num;
		if(num > Integer.MAX_VALUE||num < Integer.MIN_VALUE){
			return 0;
		}else {
			return (int)num;
		}
	}
		
	public static void main(String[] args) {
		System.out.println(reverse(436436255));
	}
}
