/**
 * 
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
输入为非空字符串且只包含数字 1 和 0。
 *
 */
public class BinaryAdd {
	public static String addinary(String a,String b) {
		StringBuilder stringBuilder = new StringBuilder();
		int aIndex = a.length() - 1;
		int bIndex = b.length() - 1;
		int carry = 0;
		while(aIndex >= 0 || bIndex >= 0 || carry > 0) {
			carry += (aIndex >=0)? a.charAt(aIndex--) - '0' : 0;
			carry += (bIndex >=0)? b.charAt(bIndex--) - '0' : 0;
			stringBuilder.append(carry % 2);
			carry /= 2;
		}
		return stringBuilder.reverse().toString();
	}
}
