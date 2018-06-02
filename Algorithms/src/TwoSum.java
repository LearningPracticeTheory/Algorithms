import java.util.Arrays;

public class TwoSum {
	
	int a[] = {1, 2, 5, 7, 0, -1, -3, -5, -7, -9}; //default no repeat
	
	public static void main(String args[]) {
		new TwoSum();
	}
	
	TwoSum() {
		System.out.println(doubleFor(a));
		System.out.println(useBinarySearch(a));
		System.out.println(threeNumSum(a));
	}
	
	public int doubleFor(int a[]) {
		int count = 0;
		for(int i = 0; i < a.length; i++) {
			for(int j = i+1; j < a.length; j++) {
				if(a[i] == -a[j]) {
					count++;
				}
			}
		}
		return count;
	}
	
	public int useBinarySearch(int a[]) {
		int count = 0;
		Arrays.sort(a);
		BinarySearch bs = new BinarySearch();
		for(int i = 0; i < a.length; i++) {
//			if(bs.search(a, -a[i]) != -1) {
			if(bs.search(a, -a[i]) > i) { //without repeat search
				count++;
			}
		}
		return count;
	}
	
	public int threeNumSum(int a[]) {
		int count = 0;
		Arrays.sort(a);
		BinarySearch bs = new BinarySearch();
		for(int i = 0; i < a.length; i++) {
			for(int j = i+1; j < a.length; j++) {
				if(bs.search(a, -a[i]-a[j]) > j) {
					count++;
				}
			}
		}
		return count;
	}

}
