package Test1_3;


import edu.princeton.cs.algs4.*;

public class Evaluate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> ops=new Stack<String>();
		Stack<Double> val=new Stack<Double>();
		String [] str=new String[] {"(","1","+","(","(","2","+","3",")",
				"*","(","4","*","5",")",")",")"};//
		for (String s : str) 
		{
			switch (s) {
			case "(":break;
			case "+":
			case "-":
			case "*":
			case "/":
			case "sqrt": ops.push(s);break;
			case ")":
				String op=ops.pop();
				double v=val.pop();
				if(op.equals("+")) v=val.pop()+v;
				else if (op.equals("-")) v=val.pop()-v;
				else if(op.equals("*")) v=val.pop()*v;
				else if(op.equals("/")) v=val.pop()/v;
				else if(op.equals("sqrt")) 	v=Math.sqrt(v);
				val.push(v);break;
			default :val.push(Double.parseDouble(s));break;
			}
		}
		StdOut.print(val.pop());
	}

}
