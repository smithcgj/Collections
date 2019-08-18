package test1_1;

public class Test1_1_20 {
	private static double  logE(int N) {
		if(N==1)
			return Math.log(1);
		else {
			return Math.log(N)+logE(N-1);
		}
	}
}
