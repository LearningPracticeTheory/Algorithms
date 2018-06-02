/*质数算法，最大公约数是 1, 除 1 外*/

public class PrimeNums {
	public static void main(String args[]) {
		primeNums(4);
	}
	
	private static void primeNums(int n) {
		boolean p[][] = new boolean[n][n];
		for(int i = 2; i < n; i++) {
			for(int j = i; j < n; j++) {
				if(primeNum(i, j) == true) {
					p[i][j] = p[j][i] = true;
				}
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(p[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	private static boolean primeNum(int i, int j) { //point
		int r = i % j;
		while(r != 0) {
			r = i % j;
			i = j;
			j = r;
		}
		if(i == 1) {
			return true;
		}
		return false;
	}
	
}
