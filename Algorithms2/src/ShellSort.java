
public class ShellSort extends Sort {

	private static final int DIVIDE = 2; //first sort DIVIDE = 3 ERROR; the last h == 2;
	
	public static void sort(int array[], boolean flag) {
		type = flag;
		if(type) {
			bc = new BarChart(array.length, array.length);
			isCompares = new boolean[array.length];
		}
		
		int j;
		
		for(int h = array.length/DIVIDE; h > 0; h /= DIVIDE) {
			for(int i = h; i < array.length; i++) {
				int tmp = array[i];
				for(j = i; j >= h && array[j-h] > tmp; j -= h) {
					array[j] = array[j-h]; //one-way assignment optimization
					if(type) {
						isCompares[j] = true;
					}
				}
				array[j] = tmp;
				if(type) {
					isCompares[j] = true;
				}
				compareDraw(array);
			}
		}
	}
	
	public static void sort1(int array[], boolean flag) {
		type = flag;
		if(type) {
			bc = new BarChart(array.length, array.length);
			isCompares = new boolean[array.length];
		}
		
		int h = 1;
		int N = array.length;
		while(h < N/3) {
			h = h*3+1; //that's why we need +1; make sure the last h == 1;
		}
		while(h >= 1) {
			/*
			 * inner InsertionSort
			 */
			for(int i = h; i < N; i++) { 
				for(int j = i; j >= h && array[j] < array[j-h]; j -= h) {
					swap(array, j, j-h);
					if(type) {
						isCompares[j] = isCompares[j-h] = true;
					}
				}
				
				compareDraw(array);
			}
			h /= 3;
		}
	}
	
}
