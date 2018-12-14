
public abstract class Sort {
	
	public static BarChart bc = null;
	public static boolean isCompares[] = null; 

	public static void swap(int array[], int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static boolean isSorted(int array[]) {
		for(int i = 1; i < array.length; i++) {
			if(array[i] < array[i-1]) {
				return false;
			}
		}
		return true;
	}
	
}
