package test1_1;

import edu.princeton.cs.algs4.StdOut;

public class Test1_1_13 {
	private static void printArray(int [][]a) {
		int m=a[0].length;
		int n=a.length;
		StdOut.print("\t");
		for(int i=1;i<m+1;i++)
			StdOut.print(i+"\t");
		StdOut.println();
		StdOut.print("\t");
		for(int i=1;i<m+1;i++)
			StdOut.print("--\t");
		StdOut.println();
		for(int i=0;i<n;i++) {
			StdOut.print(i+1+"|\t");
			for(int j=0;j<m;j++)
				StdOut.print(a[i][j]+"\t");
			System.out.println();
		}
	}
	private static int [][] invertArray(int [][]a) {
		int m=a[0].length;
		int n=a.length;
		int [][]b=new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				b[i][j]=a[j][i];
		return b;
	}
	public static void main(String[] args) {
		int [][]a=new int [5][4];
		for(int i=0;i<5;i++)
			for(int j=0;j<4;j++)
				a[i][j]=i+j;
		printArray(a);
		StdOut.print("--------------\n");
		printArray(invertArray(a));
	}
}
