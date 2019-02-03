
public abstract class Sort {
	
	public static BarChart bc = null;
	public static boolean isCompares[] = null;
	public static boolean type; //true Bar; false Curve

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
	
	public static void compareDraw(int array[]) {
		if(type) {
			bc.draw(array, isCompares);
			for(int k = 0; k < isCompares.length; k++) {
				isCompares[k] = false;
			}
		}
	}
	
	public static void compareDraw(int array[], int index) {
		if(type) {
			isCompares[index] = true;
			bc.draw(array, isCompares);
			for(int k = 0; k < isCompares.length; k++) {
				isCompares[k] = false;
			}
		}
	}
	
	public static void compareDraw(int array[], int index1, int index2) {
		if(type) {
			isCompares[index1] = isCompares[index2] = true;
			bc.draw(array, isCompares);
			for(int k = 0; k < isCompares.length; k++) {
				isCompares[k] = false;
			}
		}
	}
	
}
