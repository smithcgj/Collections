package Sort;

public class Merges {
	public static  void merge(Comparable[] a,Comparable [] aux,int lo,int mid,int hi) {
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++)//将a[lo..hi]复制到aux[lo..hi]
			aux[k]=a[k];
		for(int k=lo;k<hi+1;k++)
			if(i>mid)
				a[k]=aux[j++];
			else if(j>hi) 
				a[k]=aux[i++];
			else if(aux[j].compareTo(aux[i])<0)
				a[k]=aux[j++];
			else 
				a[k]=aux[i++];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String [] test=new String[] {"E","E","G","M","R","A",
					"C","E","R","T"};
			String [] contain=new String[test.length];
			for (String string : test) {
				System.out.print(string + " ");
			}
			System.out.println();
			merge(test, contain, 0, test.length/2, test.length-1);
			for (String string : test) {
				System.out.print(string + " ");
			}
			System.out.println();
	}

}
