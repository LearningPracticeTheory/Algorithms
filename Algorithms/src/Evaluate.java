import java.util.Scanner;
import java.util.Stack;

public class Evaluate {
	public static void main(String args[]) {
		Stack<String> ops = new Stack<>();
		Stack<Double> vals = new Stack<>();
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) { //( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) + Enter && Ctrl + Z
				//( 1 + ( ( 2 + 3 * 2 ) * ( 4 * 5 ) ) ) //括号多于一个运算符
			String s = in.next();
			if(s.equals("(")) ;
			else if(s.equals("+")) ops.push(s);
			else if(s.equals("-")) ops.push(s);
			else if(s.equals("*")) ops.push(s);
			else if(s.equals("/")) ops.push(s);
			else if(s.equals("sqrt")) ops.push(s);
			else if(s.equals(")")) {
				String op = ops.pop();
				double v = vals.pop();//pop value once
				if(op.equals("+")) v = vals.pop() + v; //pop value again
				else if(op.equals("-")) v = vals.pop() - v;
				else if(op.equals("*")) v = vals.pop() * v;
				else if(op.equals("/")) v = vals.pop() / v;
				else if(op.equals("sqrt")) v = Math.sqrt(v);
				vals.push(v);
			}
			else vals.push(Double.parseDouble(s));
		}
		System.out.println(vals.pop()); //第一种输入，pop 的是最后一个元素，即整个表达式的结果
		/*//用于第二种输入的输出
		System.out.println(vals.pop());
		System.out.println(vals.pop());
		System.out.println(vals.pop());
		*/
//		System.out.println(ops.pop()); //no less );	
		in.close();
	}
}
