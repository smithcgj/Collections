package Sort;

public class Insertion {
	public static void Sort(Comparable [] a) {
		int N=a.length;
		for(int i=1;i<N;i++) {
			for(int j=i;j>0&&(a[j].compareTo(a[j-1])<0);j--) {
				exch(a, j, j-1);
			}
		}
	}
	private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
	public static void main(String[] args) {
		Integer a[] =new  Integer[] {5,3,4,36,37,31,22};
		for (Integer string : a) {
			System.out.print(string+" ");
		}
		System.out.println();
		Sort(a);
		for (Integer string : a) {
			System.out.print(string+" ");
		}
	}
}
