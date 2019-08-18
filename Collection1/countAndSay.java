
public class countAndSay {
	public static String cAd(int n) {
		return countHelper("1",n);
	}

	private static String countHelper(String string, int n) {
		if(n == 1) return string;
		else {
			//求下一个数
			StringBuilder stringBuilder = new StringBuilder();
			int i = 0;
			//一直读数
			while(i < string.length()) {
				int count = 1;
				//如果一直是同一个数
				while(i < string.length() - 1 && string.charAt(i) == string.charAt(i + 1)) {
					count++;
					i++;
				}
				//下个数更新
				stringBuilder.append(Integer.toString(count)+string.charAt(i)); 
				i++;
			}
			string = stringBuilder.toString();
		}
		return countHelper(string, n - 1);
	}
	public static void main(String[] args) {
		System.out.println(cAd(3));
	}
}
