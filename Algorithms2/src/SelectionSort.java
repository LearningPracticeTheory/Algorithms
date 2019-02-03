
public class SelectionSort extends Sort {
	
	public static void sort(int array[], boolean flag) {
		type = flag;
		if(type) {
			bc = new BarChart(array.length, array.length);
			isCompares = new boolean[array.length];
		}
		
		for(int i = 0; i < array.length; i++) {
			int k = i;
			
			for(int j = i+1; j < array.length; j++) {
				if(array[k] > array[j]) {
					k = j;
				}
				if(type) {
					isCompares[j] = true;
				}
			}
			
			if(k != i) {
				swap(array, i, k);
				if(type) {
					isCompares[i] = true;
				}
			}
			
			compareDraw(array);
		}
	}
	
}
