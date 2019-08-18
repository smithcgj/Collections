/**
 * 
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。
 *
 */
public class TheClimb {
	public static int climbStair(int n) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		int a = 1;
		int b = 2;
		int temp = 0;
		for(int i= 3 ; i<= n;i++) {
			temp = a + b;
			a = b;
			b = temp;
		}
		return temp;
	}
}
