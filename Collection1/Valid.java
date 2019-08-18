
public class Valid {
	public static boolean isValid(String s) {
		int index = -1;
		char[] tar = new char[s.length()];
		for(int i =0;i<s.length();i++) {
			if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[') {
				index++;
				tar[index] = s.charAt(i);
				continue;
			}
			if(s.charAt(i) ==')') {
				if(index < 0) return false;
				if(tar[index] == '(')
					index--;
				else return false;
				continue;
			}
			if(s.charAt(i) =='}') {
				if(index < 0) return false;
				if(tar[index] == '{') 
					index--;
				else return false;
				continue;
			}
			if(s.charAt(i) ==']') {
				if(index < 0) return false;
				if(tar[index] == '[')
					index--;
				else return false;
				continue;
			}
		}
		return index <0;
	}
	public static void main(String[] args) {
		String str = "(])()";
		System.out.println(isValid(str));
	}
}
