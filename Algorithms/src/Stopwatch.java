
public class Stopwatch {
	
	private long start;
	
	Stopwatch() {
		start = System.currentTimeMillis();
	}
	
	public double elapseTime() {
		long end = System.currentTimeMillis();
/*		
		System.out.println(end - start);
		System.out.println((end - start)/1000); //long/int -> long/long => long
		System.out.println((end - start)/1000.0); //long/double -> double/double => double
*/		
		return (end - start) / 1000.0; //import of .0
	}
	
}
