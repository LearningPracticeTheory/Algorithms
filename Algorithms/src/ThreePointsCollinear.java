
public class ThreePointsCollinear {
	
	public static void main(String args[]) {
		int a[][] = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 0}}; //(x, y)
		ThreePointsCollinear tpc = new ThreePointsCollinear();
		System.out.println(tpc.threePointsCheck(a));
	}
	
	public int threePointsCheck(int a[][]) {
		int count = 0;
		for(int i = 0; i < a[0].length; i++) {
			for(int j = i+1; j < a[0].length; j++) {
				for(int k = j+1; k < a[0].length; k++) {
					int left = (a[0][k]-a[0][i])*(a[1][j]-a[1][i]);
					int right = (a[0][j]-a[0][i])*(a[1][k]-a[1][i]);
					if(left == right) {
						count++;
					}
				}
			}
		}
		return count;
	}
	
}
