import javax.swing.plaf.synth.SynthScrollBarUI;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指由字母组成，但不包含任何空格的字符串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/length-of-last-word
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 *
 */
public class LastWord {
	public static int lengthOfLastWord(String s) {
		s = s.trim();
		if(s.length() == 0) return 0;
		int i = s.length() - 1,num = 0;
		while(i >= 0 && s.charAt(i) != ' ') {
			num ++;
			i--;
		}
		return num;
	}
	
	public static void main(String[] args) {
		String str = "a ";
		System.out.println(lengthOfLastWord(str));
	}
}
