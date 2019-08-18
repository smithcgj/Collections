package Sort;

public class Selection {
	public static void Sort(Comparable [] a) {
		int N=a.length;
		for(int i=0;i<N;i++) {
			int min=i;
			for(int j=i+1;j<N;j++)
				if(a[j].compareTo(a[min])<0)
					min=j;
			exch(a, i, min);
		}
	}
	private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
	public static void main(String[] args) {
		String a[] =new String[]{"a","c","z","j","i","e"};
		for (String string : a) {
			System.out.print(string+" ");
		}
		System.out.println();
		Sort(a);
		for (String string : a) {
			System.out.print(string+" ");
		}
	}
}
