package Test1_3;

import java.util.*;


public class BagList<Item> implements Iterable<Item> {
	private class Node
	{
		Item item;
		Node next;
	}
	private Node frist;//头结点
	private int N;
	public boolean isEmply() {
		return frist==null;
	}
	public int  size() {
		return N;
	}
	public void add(Item item) {
		Node oldfirst=frist;
		frist=new Node();
		frist.item=item;
		frist.next=oldfirst;
		N++;
	}
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		private Node current=frist;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item=current.item;
			current=current.next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			Iterator.super.remove();
		}
		
	}
}
