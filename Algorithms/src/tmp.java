import java.util.Random;
import java.util.Stack;

public class tmp {
	public static void main(String args[]) {
		/*
		int sum = 0;
		for(int i = 1; i < 1000; i++) {
			for(int j = 0; j < i; j ++) {
				sum++;
			}
		}
		System.out.println(sum);
		sum = (1 + 1000) * 500;
		System.out.println(sum);
		*/
//二进制		
		/*
		int N = 100;
		String s = "";
		for(int i = N; i > 0; i /= 2) {
			s = (i % 2) + s;
		}
		System.out.println(s);
		System.out.println(Integer.toBinaryString(N));
		*/
//行列转置
		/*
		int a[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----");
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				System.out.print(a[j][i] + " "); //only switch i and j
			}
			System.out.println();
		}
		*/
//recursion test 1
//		System.out.println(e(4));
//fibonacci
		/*
		for(int i = 0; i < 40; i++) {
			System.out.println(i + " = " + fibonacci(i));
		}
		*/
//最大公约数
//		System.out.println(max(64, 16));
/*回文*/
		/*
		System.out.println("hannah is palindrome: " + isPalindrome("hannah"));
		System.out.println("Hannah is palindrome: " + isPalindrome("Hannah"));
		*/
/*文件名 + 扩展名*/
		//fileNameExtension("Temp.java");
/*递归逆序*/	
		//System.out.println(reverse("ABCDE"));
/*自制Exception*/	
/*		
		try {
			execute("A");
		} catch(MyException e) {
			e.printStackTrace();
		}
*/
		new tmp();
	}
	
	tmp() {
/*栈实现十进制 --> 二进制*/
//		transferFromTenToTwo(10);
/*		
		MyQueue<Integer> queue = new MyQueue<>();
		queue.add(0);queue.add(1);queue.add(2);queue.add(3);queue.add(4);
		reverseQueue(queue);
*/		
/*秒表实现*/
//		stopwatchTest();
/*随机数第一个重复值所需随机数 数量*/		
//		randomNumRepeat();
/*填满区间的随机数所需随机数 数量*/		
		randomNumFullArray();
	}
	
	public void randomNumRepeat() {
		Random r = new Random();
		int size = r.nextInt(1000);
		int tmp = r.nextInt(size);
		int count = 0;
		Stack<Integer> s = new Stack<>();
		System.out.println("The size of bound = " + size);
		while(!s.contains(tmp = r.nextInt(size))) {
			s.push(tmp);
			count++;
		}
		System.out.println("theory count = " + Math.sqrt(3.14*size/2));
		System.out.println("real count = " + count);
	}
	
	public void randomNumFullArray() {
		Random r = new Random();
		int size = r.nextInt(1000);
		int tmp = r.nextInt(size);
		int count = 0;
		int leftNum = size;
//		Integer integers[] = new Integer[size];
		boolean array[] = new boolean[size];
		System.out.println("The size of bound = " + size);
		while(leftNum > 0) {
			count++;
			if(array[tmp] == false) {
				array[tmp] = true;
				leftNum--;
			} else {
				tmp = r.nextInt(size);
			}
		}
		System.out.println("theory count = " + size*Math.log(size));
		System.out.println("real count = " + count);
	}
	
	public void stopwatchTest() {
		Stopwatch sw = new Stopwatch();
		int sum = 0;
		for(int i = 0; i < 1000; i++) {
			for(int j = 0; j < i; j++) {
				sum += j;
			}
		}
		System.out.println("elapse time = " + sw.elapseTime() + " s");
	}
	
	public void reverseQueue(MyQueue<Integer> queue) {
		Stack<Integer> stack = new Stack<>();
		while(!queue.isEmpty()) {
			stack.push(queue.poll());
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
	}
	
	public void transferFromTenToTwo(int N) {
		MyStack<Integer> stack = new MyStack<>();
		while(N > 0) {
			stack.push(N%2);
			N /= 2;
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		System.out.println();
	}
	
	public static String e(int n) {
		if(n <= 0) {
			return "";
		} else {
			return e(n - 3) + n + e(n - 2) + n;
		}
	}
	
	public static long fibonacci(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static int max(int n, int m) {
		int r = n % m;
		while(r != 0) {
			n = m;
			m = r;
			r = n % m;
//			System.out.println(2 % 4); //as well
		}
		return m;
	}
/*折半查找法*/	
	public static boolean isPalindrome(String str) {
		char c[] = str.toCharArray();
		boolean flag = true;
		for(int i = 0; i < c.length / 2; i++) { //ignoreCase
			if(c[i] != c[str.length()-1-i]) { //point
				flag = false;
			}
		}
		return flag;
	}
	
	private static void fileNameExtension(String file) {
		int dot = file.indexOf(".");
		String name = file.substring(0, dot);
		String extension = file.substring(dot + 1, file.length());
		System.out.println("file Name: " + name);
		System.out.println("file extension: " + extension);
	}
	
	public static String reverse(String s) {
		int n = s.length();
		if(n <= 1) {
			return s;
		}
		String a = s.substring(0, n/2);
		String b = s.substring(n/2, n);
		return reverse(b) + reverse(a);//逆序
//		return binarySwift(a) + binarySwift(b);//正序
	}
	
	public static void execute(String s) throws MyException {
		if(s.equals("A")) {
			throw new MyException("s.equals(A)");
		}
	}
	
}

class MyException extends Exception {
	private static final long serialVersionUID = 1L;
	MyException(String s) {
		super(s);
	}
}