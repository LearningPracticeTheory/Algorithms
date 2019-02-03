
public class QuickSort extends Sort {

	public static void sort(int array[], boolean flag) {
		type = flag;
		if(type) {
			bc = new BarChart(array.length, array.length);
			isCompares = new boolean[array.length];
		}
		sort(array, 0, array.length-1);
	}

	private static void sort(int[] array, int start, int end) {
		if(start >= end) return;
		int index = partition(array, start, end);
		sort(array, start, index-1);
		sort(array, index+1, end);
	}

	private static int partition(int[] array, int start, int end) {
		int i = start, j = end+1;
		int pivot = array[start];
		while(true) {
			
			while(array[++i] < pivot) if(i == end) break;
			while(pivot < array[--j]) if(j == start) break;
			/* ERROR
			while(array[++i] < pivot) { }
			while(pivot < array[--j]) { }
			*/
			if(i >= j) break;
			swap(array, i, j);
			
			compareDraw(array, i, j);
		}
		swap(array, start, j);
		return j;
	}
	
	/*
	 * 3-way divide
	 */
	public static void sort1(int array[], boolean flag) {
		type = flag;
		if(type) {
			bc = new BarChart(array.length, array.length);
			isCompares = new boolean[array.length];
		}
		sort1(array, 0, array.length-1);
	}

	private static void sort1(int[] array, int start, int end) {
		if(end <= start) {
			return;
		}
		int i = start, index = start+1, j = end;
		int pivot = array[start];
		while(index <= j) {
			if(pivot > array[index]) {
				compareDraw(array, i, index);
				swap(array, i++, index++);
			} else if(pivot < array[index]) {
				swap(array, index, j--);
				compareDraw(array, j, index);
			} else {
				index++;
			}
		} //array[start, i-1] < pivot == array[i, j] < array[j+1, end]
		sort1(array, start, i-1);
		sort1(array, j+1, end);
	}
	
	private static final int CUT_OFF = 10;
	
	/*
	 * median & insertionSort
	 */
	public static void sort2(int array[], boolean flag) {
		type = flag;
		if(type) {
			bc = new BarChart(array.length, array.length);
			isCompares = new boolean[array.length];
		}
		sort2(array, 0, array.length-1);
	}
	
	private static void sort2(int[] array, int start, int end) {
		if(end-start <= CUT_OFF) {
			insertionSort(array, start, end);
		} else {
			int pivot = median3(array, start, end);
			int i = start, j = end-1;
			while(true) {
				while(array[++i] < pivot) { }
				while(array[--j] > pivot) { } 
				if(i >= j) break;
				swap(array, i, j);
				compareDraw(array, i, j);
			}
			swap(array, i, end-1);
			compareDraw(array, i, end-1);
			
			sort2(array, start, i-1);
			sort2(array, i+1, end);
		}
	}

	private static int median3(int array[], int start, int end) {
		int middle = (start+end)/2;
		if(array[end] < array[middle]) {
			swap(array, end, middle);
		}
		if(array[end] < array[start]) {
			swap(array, end, start);
		}
		if(array[middle] < array[start]) {
			swap(array,start, middle);
		}
		swap(array, middle, end-1);
		return array[end-1];
	}
	
	private static void insertionSort(int array[], int start, int end) {
		int j = 0;
		for(int i = start+1; i <= end; i++) {
			int tmp = array[i];
			for(j = i-1; j >= start; j--) {
				if(array[j] > tmp) {
					array[j+1] = array[j];
					if(type) {
						isCompares[j+1] = true;
					}
				} else {
					break;
				}
			}
			array[j+1] = tmp;
			if(type) {
				isCompares[j+1] = true;
			}
			compareDraw(array);
		}
	}
	
}
