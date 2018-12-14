
public class InsertionSort extends Sort {
	
	
	public static void sort0(int array[]) {
//		bc = new BarChart(array.length, array.length);
		for(int i = 1; i < array.length; i++) {
			for(int j = i; j > 0; j--) { //冒泡内外层错位
				if(array[j-1] > array[j]) {
					swap(array, j, j-1);
//					bc.draw(array);
				}
			}
		}
	}	
			

	public static void sort(int array[]) {
		bc = new BarChart(array.length, array.length);
		isCompares = new boolean[array.length];
		for(int i = 1; i < array.length; i++) {
			
			for(int j = i; j > 0; j--) {
				if(array[j-1] > array[j]) {
					swap(array, j, j-1);
					if(!isCompares[j-1]) {
						isCompares[j-1] = true;
					}
					if(!isCompares[j]) {
						isCompares[j] = true;
					}
				}
			}
			
			bc.draw(array, isCompares);
			for(int j = 0; j < isCompares.length; j++) { //外层循环作为 draw 的标志，isMoves 复位
				isCompares[j] = false;
			}
			
		}
	}			
	
}
