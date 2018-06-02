import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class ArrayLocalMinElement {
	
	int arr[] = {1, 3, -2, 4, 6, 2, 7, -9, 10};
	
	public static void main(String args[]) {
		new ArrayLocalMinElement();
	}
	
	ArrayLocalMinElement() {
		System.out.print("normal find ");
		normalFind(arr);
		
		System.out.print("recursive find ");
		findMinRecursive(1, arr.length-2);
		
		System.out.print("\nforkjoin find ");
		ForkJoinPool fjp = new ForkJoinPool();
		fjp.submit(new FindMinTask(0, arr.length-1));
		try {
			fjp.awaitTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		fjp.shutdown();
	}
	
	void normalFind(int arr[]) {
		for(int i = 1; i < arr.length-1; i++) {
			if(arr[i] < arr[i-1] && arr[i] < arr[i+1]) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}
	
	private void findMinRecursive(int start, int end) {
		if(start != end) {
			int middle = (start+end)/2;
			findMinRecursive(start, middle);
			findMinRecursive(middle+1, end);
		} else if(arr[start] < arr[start-1] && arr[start] < arr[start+1]) {
			System.out.print(arr[start] + " ");
		}
	}
	
//like: binaryTree && Recursive Class	
	private class FindMinTask extends RecursiveAction { //abstract Class

		private static final long serialVersionUID = 1L;
		private int end;
		private int start;
		
		FindMinTask(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		protected void compute() {
			if(start != end) {
				int middle = (start+end)/2;
				FindMinTask left = new FindMinTask(start, middle);
				FindMinTask right = new FindMinTask(middle+1, end);
				left.fork(); //并行执行
				right.fork();
			} else if(start != 0 && end != arr.length-1) {
				if(arr[start] < arr[start-1] && arr[start] < arr[start+1]) {
					System.out.print(arr[start] + " ");
				}
			}
		}
		
	}
	
}
	