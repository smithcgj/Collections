/**
 * 
 * 斐波那契数
 *
 */
public class Fibonacci {

	//取模的数
	private int mod = 100007;
	
	//计算第n个斐波那契数
	public int nth(int n) {
		if(n == 1 || n ==2) {
			return 1;
		}
		//保留上两个数
		int lastOne = 1;
		int lastTwo = 1;
		//结果变量
		int result = 0;
		//计数变量
		int count = 2;
		//循环计算
		while (count < n) {
			//斐波那契公式
			result = (lastOne + lastTwo) % mod;
			count++;
			//上两个数的更迭
			lastTwo = lastOne;
			lastOne = result;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		int result = fibonacci.nth(100000);
		System.out.println(result);
	}
}
