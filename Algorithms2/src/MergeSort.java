
public class MergeSort extends Sort {

	private static boolean type; //true Bar; false Curve
	private static final int RANGE = 10;
	
	/*
	 * recursive divide all the time
	 */
	public static void sort(int array[], boolean flag) {
		type = flag;
		if(type) {
			bc = new BarChart(array.length, array.length);
			isCompares = new boolean[array.length];
		}
		sort(array, 0, array.length-1);
	}
	
	private static void sort(int array[], int start, int end) {
		if(start >= end) {
			return;
		}
//		int middle = start + (end - start)/2;
		int middle = (start + end)/2;
		sort(array, start, middle);
		sort(array, middle+1, end);
		merge(array, start, middle, end);
	}
	
	/*
	 * sub-array.length < RANGE -> insertionSort
	 */
	public static void sort1(int array[], boolean flag) {
		type = flag;
		if(type) {
			bc = new BarChart(array.length, array.length);
			isCompares = new boolean[array.length];
		}
		sort1(array, 0, array.length-1);
	}
	
	private static void sort1(int array[], int start, int end) {
		if(start >= end) {
			return;
		}
		int middle = (start + end)/2;
		int range = end-start;
		if(range < RANGE) {
			insertionSort(array, start, end); //inner Sort, also see in Shell & Quick
		} else {
			sort1(array, start, middle);
			sort1(array, middle+1, end);
		}
		merge(array, start, middle, end);
	}
	
	/*
	 * one-way assignment
	 */
	private static void insertionSort(int array[], int start, int end) {
		int j = 0;
		if(start >= end) {
			return;
		}
		for(int i = start+1; i <= end; i++) { //start & end are indexes of array, end != length
			int tmp = array[i];
			for(j = i; j > start; j--) {
				if(array[j-1] > tmp) {
					array[j] = array[j-1];
				} else {
					break;
				}
			}
			array[j] = tmp;
		}
	}
	
	/*
	 * merge from bottom to top, NO divide
	 */
	public static void sort2(int array[], boolean flag) {
		int N = array.length;
		
		type = flag;
		if(type) {
			bc = new BarChart(array.length, array.length);
			isCompares = new boolean[array.length];
		}
		
		for(int size = 1; size < N; size += size) {
			for(int start = 0; start < N-size; start += (2*size)) {
				merge(array, start, start+size-1, Math.min(N-1, start+2*size-1));
			}
		}
	}

	//tmpArray.length == array.length which is wasting memory
	/*
	private static void merge(int array[], int start, int middle, int end) {
		int i = start, j = middle+1;
		int tmpArray[] = new int[array.length]; //same size
		
		for(int index = start; index <= end; index++) {
			tmpArray[index] = array[index];
		}
		
		for(int index = start; index <= end; index++) {
			if(i > middle) {
				array[index] = tmpArray[j++];
			} else if(j > end) {
				array[index] = tmpArray[i++];
			} else if(tmpArray[i] < tmpArray[j]) {
				array[index] = tmpArray[i++];
			} else {
				array[index] = tmpArray[j++];
			}
			
			if(type) {
				isCompares[index] = true;
			}
		}
		
		if(type) {	
			bc.draw(array, isCompares);
			for(int k = 0; k < isCompares.length; k++) {
				isCompares[k] = false;
			}
		}
	}
	*/
	
	/*
	 * end-start+1 is the exactly length that tmpArray need
	 */
	private static void merge(int array[], int start, int middle, int end) {
		
		/*
		 * left & right side are already sorted, if left.last <= right.first
		 * which means array[start, end] is already sorted
		 */
		if(array[middle] <= array[middle+1]) {
			return;
		}
		
		int i = 0, m = middle-start, j = m+1, k = 0;
		int tmpArray[] = new int[end-start+1];
		
		for(int index = start; index <= end; index++) {
			tmpArray[k++] = array[index];
		}
		
		for(int index = start; index <= end; index++) {
			if(i > m) {
				array[index] = tmpArray[j++];
			} else if(j >= tmpArray.length) {
				array[index] = tmpArray[i++];
			} else if(tmpArray[i] < tmpArray[j]) {
				array[index] = tmpArray[i++];
			} else {
				array[index] = tmpArray[j++];
			}
			
			if(type) {
				isCompares[index] = true;
			}
		}
		
		if(type) {	
			bc.draw(array, isCompares);
			for(int index = 0; index < isCompares.length; index++) {
				isCompares[index] = false;
			}
		}
	}
	
}
