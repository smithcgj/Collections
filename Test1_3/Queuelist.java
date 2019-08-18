package Test1_3;

import edu.princeton.cs.algs4.StdOut;

public class Queuelist<Item> {
	private class Node
	{
		Item item;
		Node next;
	}
	private Node frist;//头指针
	private Node last;//尾指针
	private int N;//队列的大小
	public boolean isEmply() {
		return frist==null;
	}
	public int size() {
		return N;
	}
	public void enQueue(Item item) {
		//在队尾添加元素
		Node oldlast=last;
		last =new Node();
		last.item=item;
		last.next=null;
		if(isEmply()) frist=last;
		else oldlast.next=last;
		N++;
	}
	public Item reQueue() {
		//在表头删除元素
		Node oldfrist=frist;
		frist=frist.next;
		if(isEmply()) last=null;
		N--;
		return oldfrist.item;
	}
	public static void main(String[] args) {
		Queuelist<String> ql=new Queuelist<>();
		String [] str=new String[] {"one","two","-","three","four"};
		for (String string : str) {
			if(!string.equals("-"))
				ql.enQueue(string);
			else if(!ql.isEmply())
				StdOut.print(ql.reQueue()+" ");
		}
		StdOut.println("("+ql.size()+" left on queue)");
	}
}
