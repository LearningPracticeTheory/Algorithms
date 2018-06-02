
public class CommonElements {
	public static void main(String args[]) {
		new CommonElements();
	}
	
	CommonElements() {
//		int a[][] = {{2, 4, 5, 8}, {1, 4, 7, 8}};
//		int a[][] = {{2, 4, 5, 8, 8}, {1, 4, 7, 8, 8}}; //repeat
//		int a[][] = {{0, 2, 4, 5, 8, 8}, {0, 1, 4, 7, 8, 8}}; //0 not match
		int a[][] = {{-1, 0, 2, 4, 5, 8, 8}, {-1, 0, 0, 1, 4, 7, 8, 8}};
		commonMatch(a[0], a[1]);
		System.out.println();
		commonMatchBinarySearch(a[0], a[1]);
	} 
	
	public void commonMatch(int x[], int y[]) {
		int t = 0;
		int old = 0; //repeat number
		boolean isFirst = true;
		for(int i = 0; i < x.length; i++) {
			for(int j = t; j < y.length; j++) {
				if(x[i] == y[j]) { //match
					if(isFirst && x[i] == 0) {
						System.out.print(x[i] + " ");
						isFirst = false;
					} else if(x[i] != old) {
						System.out.print(x[i] + " ");
						old = x[i];
						t = j+1; //next index
						if(isFirst) {
							isFirst = false;
						}
						break;
					}
				}
			}
		}
	}
	
	public void commonMatchBinarySearch(int x[], int y[]) {
		BinarySearch bs = new BinarySearch();
		int t = 0;
		int old = 0;
		boolean isFirst = true;
		for(int i = 0; i < x.length; i++) {
			int index = bs.search(y, x[i], t, y.length);
			if(index >= 0) {
				if(isFirst && y[index] == 0) {
					System.out.print(y[index] + " ");
					isFirst = false;
				} else if(y[index] != old) {
					System.out.print(y[index] + " ");
					old = y[index];
					t = index;
					if(isFirst) {
						isFirst = false;
					}
				}
			}
		}
	}
	
}
