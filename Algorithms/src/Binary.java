
public class Binary {
	public static void main(String args[]) {
		int N = 10;
		String s = ""; //can not null
		for(int n = N; n > 0; n /= 2) {
//			s += (n % 2); //inverted sequence
			s = (n % 2) + s; 
		}
		System.out.println(s);
		System.out.println(Integer.toBinaryString(N));
	}
}
