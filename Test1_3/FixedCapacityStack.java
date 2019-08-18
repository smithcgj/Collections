package Test1_3;

import java.util.Iterator;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStack<Item> {
	private Item a [];//stack entries
	private int N;//size
	public FixedCapacityStack(int cap) {
		// TODO Auto-generated constructor stub
		a=(Item[])new Object[cap];
	}
	public boolean isEmpty() {
		return N==0;
	}
	public int size() {
		return N;
	}
	public void push(Item item) {
		if(N==a.length) reSize(2*a.length);
		a[N++]=item;
	}
	public Item pop() {
		Item item = a[--N];
		a[N]=null;// 避免对象游离
		if(N>0&&N==a.length/4)
			reSize(a.length/2);
		return item;
	}
	private void reSize(int Max) {
		Item [] temp=(Item [])new Object [Max];
		for(int i=0;i<N;i++)
			temp[i]=a[i];
		a=temp;
	}
	public static void main(String[] args) {
		FixedCapacityStack<String> fcs=new FixedCapacityStack<>(100);
		String [] aStrings=new String [] {"to","be","br","-","to"};
		for (String item : aStrings) {
			if(!item.equals("-"))
				fcs.push(item);
			else if (!fcs.isEmpty()) {
				StdOut.print(fcs.pop()+" ");
			}
		}
		StdOut.println("("+fcs.size()+" left on stack)");
	}
	private class ReserveArrayIterator implements Iterator<Item>
	{
		private int i=N;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i>0;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return a[--i];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			Iterator.super.remove();
		}
		
	}
}
