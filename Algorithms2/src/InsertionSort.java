
public class InsertionSort extends Sort {

	public static void sort(int array[], boolean flag) {
		type = flag;
		if(type) {
			bc = new BarChart(array.length, array.length);
			isCompares = new boolean[array.length];
		}

		for (int i = 1; i < array.length; i++) { 

			for (int j = i; j > 0; j--) { //冒泡内外层错位
				if (array[j - 1] > array[j]) {
					swap(array, j, j - 1);
					if(type) {
						isCompares[j - 1] = isCompares[j] = true;
					}
				}
			}

			compareDraw(array); //外层循环作为 draw的标志，isMoves 复位
		}
	}

}
