
public class ShellSort extends Sort {

	public static void sort0(int array[]) {
		int j;
		for(int h = array.length/3; h > 0; h /= 3) {
			for(int i = h; i < array.length; i++) {
				int tmp = array[i];
				for(j = i; j >= h && array[j] < array[j-h]; j -= h) {
//					swap(array, j, j-h); //one-way assignment optimization
					array[j] = array[j-h];
				}
				array[j] = tmp;
			}
		}
	}
	
	public static void sort(int array[]) {
		
		bc = new BarChart(array.length, array.length);
		isCompares = new boolean[array.length];
		
		int h = 1;
		int N = array.length;
		while(h < N/3) {
			h = h*3+1;
		}
		while(h >= 1) {
			/*
			 * inner InsertionSort
			 */
			for(int i = h; i < N; i++) { 
				for(int j = i; j >= h && array[j] < array[j-h]; j -= h) {
					swap(array, j, j-h);
					isCompares[j] = isCompares[j-h] = true;
				}
				
				bc.draw(array, isCompares);
				for(int j = 0; j < isCompares.length; j++) {
					isCompares[j] = false;
				}
			}
			h /= 3;
		}
	}
	
}
