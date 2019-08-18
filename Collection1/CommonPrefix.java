
public class CommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		String str = "";
		boolean isSame = true;
		if(strs.length <= 0) return str;
		String min = strs[0];
		for(int j = 0;j< strs.length ;j++)
			if(min.length() > strs[j].length())
				min = strs[j];
		for(int i = 0; i< min.length();i++) {
			for(int j = 0;j< strs.length - 1;j++) {
				if(strs[j].charAt(i) != strs[j + 1].charAt(i)) {
					isSame = false;
					break;
				}
			}
			if(isSame) {
				str += strs[0].charAt(i);
			}else {
				break;
			}
		}
		return str;
	}
	public static void main(String[] args) {
		String[] strings = {"aa","a"};
		System.out.println(longestCommonPrefix(strings));
	}
}
