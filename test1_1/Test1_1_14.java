package test1_1;

import edu.princeton.cs.algs4.*;

public class Test1_1_14 {
//	public static int searchInArray(int []a,int b) {
//		int sum=0;
//		for(int i=0;i<a.length;i++)
//			if(b==a[i])
//				sum++;
//		return sum;
//	}
//	private static int [] histogram(int a[],int M) {
//		int [] arr=new int [M];
//		for(int i=0;i<M;i++)
//			arr[i]=searchInArray(a, i);
//		return arr;
//	}
	private static int Myrow(int n,int i) {
		int m=n;
		if(i==0)
			return 1;
		for(int j=0;j<i-1;j++)
			n*=m;
		return n;
	}
	private static int lg(int N) {
		for(int i=0;i<N;i++)
			if(Myrow(2, i)<=N&&Myrow(2, i+1)>N)
				return i;
		return 0;
	}
	public static void main(String[] args) {
//		int [] a=new int [] {1,2,3,3,2,1,2,3,0,0};
//		int [] b=histogram(a, 4);
//		for (int i : b) {
//			System.out.print(i+" ");
//		}
		StdOut.print(lg(9));
	}
}
