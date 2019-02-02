
public class HeapSort extends Sort { //MaxHeap

	public static void sort(int array[], boolean flag) {
		type = flag;
		if(type) {
			bc = new BarChart(array.length, array.length);
			isCompares = new boolean[array.length];
		}
		sort(array);
	}
	
	private static void sort(int array[]) {
		for(int i = array.length/2-1; i >=0; i--) { //buildHeap
			sink(array, i, array.length);
		}
		for(int i = array.length-1; i > 0; i--) { //omit i == 0, which is the last time of loop
			swap(array, 0, i);
			compareDraw(array, 0, i);
			sink(array, 0, i);
		}
	}
	
	/*
	private static void sink(int array[], int hole, int length) { // 66ms
//		for(int child = hole*2+1; child < length; hole = child, child = child*2+1) {
		int child;
		for(; leftChild(hole) < length; hole = child) {
			child = leftChild(hole);
			if(child + 1 < length && array[child] < array[child+1]) {
				child++;
			}
			if(array[hole] < array[child]) {
				swap(array, hole, child);
				compareDraw(array, hole, child);
			} else {
				break;
			}
		}
	}
	*/
	
	/*
	 * one-way assignment optimization
	 */
	private static void sink(int array[], int hole, int length) { //65 ms
		int child;
		int tmp = array[hole];
		for(; leftChild(hole) < length; hole = child) {
			child = leftChild(hole);
			if(child + 1 < length && array[child] < array[child+1]) {
				child++;
			}
			if(tmp < array[child]) {
				array[hole] = array[child]; //one-way assignment
				compareDraw(array, hole, child);
			} else {
				break;
			}
		}
		array[hole] = tmp;
	}
	
	private static int leftChild(int index) {
		return index*2+1;
	}
	
}
