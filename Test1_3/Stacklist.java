package Test1_3;

import edu.princeton.cs.algs4.StdOut;

public class Stacklist<Item> {
	private	class Node
	{
		Item item;
		Node next;
	}
	private Node frist;//栈顶
	private int N;//元素数量
	public boolean isEmply() {
		return frist==null;
	}
	public int  size() {
		return N;
	}
	public void push(Item item) {
		Node oldfirst=frist;
		frist=new Node();
		frist.item=item;
		frist.next=oldfirst;
		N++;
	}
	public Item pop() {
		Item item=frist.item;
		frist=frist.next;
		N--;
		return item;
	}
	public static void main(String[] args) {
		boolean b;
		Stacklist<String> s=new Stacklist<String>();
		String [] str=new String[] {"[","(",")","]","[","]"};
		for (String item : str) {
			if(!item.equals("-"))
				s.push(item);
			else if(!s.isEmply())
				StdOut.println("pop "+s.pop());
		}
		StdOut.println("("+s.size()+" left on stack)");
		
		}
	
}
