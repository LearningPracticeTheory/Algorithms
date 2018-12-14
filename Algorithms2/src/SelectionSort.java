
public class SelectionSort extends Sort {

	
	public static void sort0(int array[]) {
//		bc = new BarChart(array.length, array.length);
		for(int i = 0; i < array.length; i++) {
			int k = i;
			for(int j = i+1; j < array.length; j++) {
				if(array[k] > array[j]) {
					k = j;
				}
			}
			if(k != i) {
				swap(array, i, k);
//				bc.draw(array);
			}
		}
	}
	
	
	public static void sort(int array[]) {
		bc = new BarChart(array.length, array.length);
		isCompares = new boolean[array.length];
		for(int i = 0; i < array.length; i++) {
			int k = i;
			
			for(int j = i+1; j < array.length; j++) {
				if(array[k] > array[j]) {
					k = j;
				}
				if(!isCompares[j]) {
					isCompares[j] = true;
				}
			}
			
			if(k != i) {
				swap(array, i, k);
				if(!isCompares[i]) {
					isCompares[i] = true;
				}
			}
			
			bc.draw(array, isCompares);
			
			for(int j = 0; j < isCompares.length; j++) { 
				isCompares[j] = false;
			}
			
		}
	}
	
}
