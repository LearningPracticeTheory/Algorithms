import java.util.Random;

public class Test {
	
	Random r = new Random(1); //r.setSeed(1);
	
	public static void main(String args[]) {
		Test test = new Test();
		test.execute();
		test.curveGraphTest();
//		test.indirectSort();
	}
	
	public static final int T = 700; //time == height
	public static final int N = 500; //numbers == width
//	public static final int MULTIPLE = 50; //MergeSort.merge Test
//	public static final int MULTIPLE = 80; //InsertionSort & SelectionSort Test
	public static final int MULTIPLE = 1000; //ShellSort & MergeSort & QuickSort Test
	public static final int NUMS = N*MULTIPLE;
	public static final int INCREASE = MULTIPLE;
	public static final int RANGE = 10000;
	
	public void curveGraphTest() {
		int array[];
		long count = 0L;
		CurveGraph cg = new CurveGraph(N, T);
		
		for(int i = INCREASE; i < NUMS; i += INCREASE) {
			array = new int[i];
			count = System.currentTimeMillis();
			for(int k = 0; k < i; k++) {
				array[k] = r.nextInt(RANGE);
			}
//			InsertionSort.sort0(array);
//			SelectionSort.sort0(array);
//			ShellSort.sort0(array); //faster than MergeSort
//			MergeSort.sort(array, false);
//			MergeSort.sort1(array, false);
//			MergeSort.sort2(array, false);
//			MergeSort.sort3(array);
//			QuickSort.sort(array, false);
//			QuickSort.sort2(array, false);
			QuickSort.sort1(array, false);
			count = System.currentTimeMillis() - count;
System.out.print(count + " ");
			cg.draw(i/MULTIPLE, (int)count);
		}
	}
	
	public void execute() {
		int array[] = new int[20];
//		int array[] = new int[50];
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(array.length-1);
//			array[i] = i; //the pivot is minimum/maximum will throw Exception
		}
		long started = System.currentTimeMillis();
//		InsertionSort.sort(array); //9.732
//		SelectionSort.sort(array); //6.695
//		ShellSort.sort(array);
//		MergeSort.sort(array, true);
//		MergeSort.sort1(array, true);
//		MergeSort.sort2(array, true);
//		QuickSort.sort(array, true);
//		QuickSort.sort2(array, true);
		QuickSort.sort1(array, true);
		System.out.println("runTime:" + (System.currentTimeMillis()-started)/1000.0 + "s");
	}
	
	public void indirectSort() {
		int array[] = new int[10];
		System.out.print("orignal: ");
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(array.length-1);
			System.out.print(array[i] + " ");
		}
		System.out.println();
		int permanent[] = MergeSort.sort3(array);
		System.out.print("permanent: ");
		for(int i = 0; i < permanent.length; i++) {
			System.out.print(permanent[i] + " ");
		}
		System.out.println();
		System.out.print("sorted: ");
		for(int i = 0; i < permanent.length; i++) {
			System.out.print(array[permanent[i]] + " ");
		}
		System.out.println();
	}
	
}
