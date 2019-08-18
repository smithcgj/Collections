package test1_1;


import edu.princeton.cs.algs4.StdOut;

public class Test1_12 {
//	private static void isDecimals(double x,double y) {//1.1.5
//		System.out.println(0<x&&0<y&&x<1&&y<1);
//	}
//	private static void a() {//1.1.7.a
//		double t=9.0;
//		while (Math.abs(t-9.0/t)>.001) {
//			t=(9.0/t+t)/2.0;
//			
//		}
//		StdOut.printf("%.5f\n", t);
//	}
//	private static void b() {//1.1.7.b
//		int sum=0;
//		for(int i=1;i<1000;i++)
//			for(int j=0;j<i;j++)
//				sum++;
//		StdOut.println(sum);
//	}
//	private static void c() {//1.1.7.c
//		int sum=0;
//		for(int i=1;i<1000;i*=2)
//			for(int j=0;j<1000;j++)
//				sum++;
//		StdOut.println(sum);
//	}
	private static char printBoolFormat(boolean a) {
		if(a==false)
			return ' ';
		else {
			return '*';
		}
	}
	private static void printBoolArray(boolean [][]a) {//1.1.11
		int m=a[0].length;
		int n=a.length;
		StdOut.print("\t");
		for(int i=1;i<m+1;i++)
			StdOut.print(i+"\t");
			StdOut.println();
		for(int i=0;i<n;i++) {
			StdOut.print(i+1+"\t");
			for(int j=0;j<m;j++)
				StdOut.print(printBoolFormat(a[i][j])+"\t");
			System.out.println();
		}
			
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println((0+15)/2);
//		System.out.println(2.0e-6*10000000.1);
//		System.out.println(true&&false ||true&&false);//1.1.1
//		Object tObject=(1+2.236)/2;
//		System.out.println(tObject.getClass().toString());
//		tObject=1+2+3+4.0;
//		System.out.println(tObject.getClass().toString());
//		tObject=4.1>=4;
//		System.out.println(tObject.getClass().toString());
//		tObject=1+2+"3";
//		System.out.println(tObject.getClass().toString());//1.1.2
//		isDecimals(-0.2, 0.3);
//		int f=0;
//		int g=1;
//		for(int i=0;i<=15;i++)
//		{
//			StdOut.println(f);
//			f=f+g;
//			g=f-g;
//		}//1.1.6
//		a();
//		b();
//		c();
		boolean a[][]=new boolean [5][10];
		for (int i = 0; i < a.length; i+=2) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j]=true;
			}
		}
		printBoolArray(a);
	}

}
