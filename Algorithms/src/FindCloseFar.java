import java.util.Arrays;

public class FindCloseFar {
	
	public static void main(String args[]) {
		new FindCloseFar();
	}
	
	FindCloseFar() {
		int a[] = {-9, 4, 2, 7, 1, 6, 8};
		far(a);
		close(a);
		System.out.println();
		moreClose(a);
	}
	
	public void far(int a[]) {
		int max, min;
		max = min = a[0];
		for(int i = 1; i < a.length; i++) {
			if(max < a[i]) {
				max = a[i];
			} else if(min > a[i]) {
				min = a[i];
			}
		}
		System.out.println("far between " + max + " and " + min);
	}
	
	public void close(int a[]) {
		Arrays.sort(a);
		int close1=a[0], close2=a[1];
		int min = Math.abs(close1 - close2);
		for(int i = 1; i < a.length-1; i++) {
			if(a[i+1]-a[i] < min) {
				close2 = a[i+1];
				close1 = a[i];
				min = Math.abs(close2-close1);
			}
		}
		System.out.println("close between " + close1 + " and " + close2);
	}
	
	public void moreClose(int a[]) {
		MyStack<Integer> stack = new MyStack<>();
		Arrays.sort(a);
		stack.push(a[1]);
		stack.push(a[0]);
		int min = Math.abs(a[1] - a[0]);
		int countSameCouple = 1;
		for(int i = 1; i < a.length-1; i++) {
			if(a[i+1]-a[i] < min) {
				stack.push(a[i+1]);
				stack.push(a[i]);
				min = Math.abs(a[i+1]-a[i]);
				countSameCouple = 1;
			} else if(a[i+1]-a[i] == min) {
				stack.push(a[i+1]);
				stack.push(a[i]);
				min = Math.abs(a[i+1]-a[i]);
				countSameCouple++;
			}
		}
		while(countSameCouple-- > 0) {
			System.out.println("close between " + stack.pop() + " and " + stack.pop());
		}
	}
	
}
