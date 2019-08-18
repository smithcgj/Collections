package Test1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack;
		stack=new Stack<Integer>();
		while(!StdIn.isEmpty())
			stack.push(StdIn.readInt());
		for ( Integer i : stack) {
			StdOut.print(i+" ");
		}
	}

}
