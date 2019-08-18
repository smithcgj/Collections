package chapter2;

import edu.princeton.cs.algs4.*;
public class TopM {
	public static void main(String[] args) {
		//打印输入流的最大的M行
		int M=Integer.parseInt(args[0]);
		MinPQ<Transaction> pq=new MinPQ<Transaction>(M+1);
		while(StdIn.hasNextLine()) {
			//为下一行输入创建一个元素并放入优先队列
			pq.insert(new Transaction(StdIn.readLine()));
			if(pq.size()>M)
				pq.delMin();//如果队列中存在M+1个元素，就删除最小的元素
		}//最大的元素都在队列里面
		Stack<Transaction> stack=new Stack<>();
		while(!pq.isEmpty()) stack.push(pq.delMin());
		for (Transaction t : stack) {
			StdOut.println(t);
		}
	}
}
