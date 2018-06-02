import java.util.Arrays;
import java.util.Random;

public class NumsWithoutRepeat {
	
	public static Random r = new Random();
	
	public static void main(String args[]) {
/*使用逐一添加的方式实现删除重复元素*/
		System.out.println("first one:");
		randomNumWithoutRepeat(1 + r.nextInt(50));
/*从原有数组中删除重复元素*/
		System.out.println("second one:");
		arrayWithoutRepeat(2 + r.nextInt(50));
	}
	
	public static void randomNumWithoutRepeat(int n) {
		int m = n / 2;
		int a[] = new int[m];
		int t;
		boolean flag;
		
		for(int i = 0; i < m; i++) {
			t = r.nextInt(n);
			flag = true;
			for(int j = 0; j < a.length; j++) {
				if(t == a[j]) {
					i--;
					flag = false;
					break;
				}
			}
			if(flag) {
				a[i] = t;
			}
		}
		
		Arrays.sort(a);
		
		for(int i = 0; i < m; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void arrayWithoutRepeat(int n) {
		int a[] = new int[n];
		int t[] = new int[n];
		int tmp, count = 1;
		boolean flag;
		for(int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(n / 2);
		}
		Arrays.sort(a);
		for(int tt : a) {
			System.out.print(tt + " ");
		}
		System.out.println();
		t[0] = a[0];
		for(int i = 0; i < a.length; i++) {
			tmp = a[i];
			flag = true;
			for(int j = 0; j < t.length; j++) {
				if(tmp == t[j]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				t[count] = tmp;
				count++;
			}
		}
		for(int i = 0; i < t.length; i++) {
			if(i != 0 && t[i] == 0) {
				break; //遇到后面第一个为0的直接截断
			}
			System.out.print(t[i] + " ");				
		}
	}
	
}
