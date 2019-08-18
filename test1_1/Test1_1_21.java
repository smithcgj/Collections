package test1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Test1_1_21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(StdIn.hasNextLine()) {
			String name=StdIn.readString();
			int m=StdIn.readInt();
			int n=StdIn.readInt();
			StdOut.printf("%s|%d|%d|%0.3f", name,m,n,(m*1.0)/n);
		}
	}

}
