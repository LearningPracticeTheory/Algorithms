/**
 * Use Debug to deal with the problem
 */

import java.util.Random;

public class BinarySearch {
	
	public static Random r = new Random();
	public static final int N = 100 + r.nextInt(500);
	/*
	public static void main(String args[]) {
//		int a[] = {1, 2, 4, 5, 7, 6, 8, 9, 0, 3};
		
//		Date date = new Date();
//		long t1 = date.getTime();
		
		int a[] = new int[N];
		int key = r.nextInt(500);
		int foundIndex;
		
		long startTime = System.currentTimeMillis();
		long st = System.nanoTime();
		
		for(int i = 0; i < N; i++) {
			a[i] = r.nextInt(500);
		}
		
		Arrays.sort(a);
		
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
		System.out.println("\nkey = " + key);
		
		foundIndex = search(a, key, 0, a.length - 1);
		found(foundIndex, key, a);
		
		long endTime = System.currentTimeMillis();
		long et = System.nanoTime();
		
		System.out.println(endTime - startTime + " ms");
		System.out.println(et - st + " ns");
		
		foundIndex = search(a, key);
		found(foundIndex, key, a);
		
	}
	*/
	public int search(int a[], int key) { //use index
		int start = 0;
		int end = a.length - 1;
		int mid;
		while(start <= end) { //using while to replace recursion
			mid = start + (end - start) / 2;
			if(key > a[mid]) {
				start = mid + 1;
			} else if(key < a[mid]) {
				end = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	public int search(int a[], int key, int start, int end) {
		int mid = start + (end - start) / 2; //cannot just start + a.length / 2
//System.out.println(mid);

		if(start > end || key > a[a.length - 1] || key < a[0]) {
			return -1;
		}

		if(key > a[mid]) {
			return search(a, key, mid + 1, end); //must return for each if-else
		} else if(key < a[mid]) {
			return search(a, key, start, mid - 1);
		} else {
			return mid;
		}
	}
	
	public static void found(int foundIndex, int key, int a[]) {
		if(foundIndex != -1) {
			System.out.println("FOUND = " + a[foundIndex]);
		} else {
			System.out.println("Not such element " + key + " in array");
		}
	}
	
}
