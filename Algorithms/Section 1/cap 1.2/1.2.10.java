public class VisualCounter {
	private final int maxOperations;
	private final int maxCount;
	private int count;
	private int operations;

	public VisualCounter(int N, int max) {
		StdDraw.setXscale(0, N + 1);
        StdDraw.setYscale(-(max + 3), max + 3);
		StdDraw.setPenRadius(.01);

		maxOperations = N;
		maxCount = max;
	}

	public void increment() {
		if(count < maxCount && operations < maxOperations){
			count++;
			operations++;
		}
			StdDraw.point(operations, count);
	}

	public void decrement() {
		if(count > 0 && operations < maxOperations){
			count--;
			operations++;
		}
			StdDraw.point(operations, count);
	}

	public static void main(String[] args) {
		Main visualCnt = new Main(10, 10);
		
		visualCnt.decrement();
		visualCnt.increment();
		visualCnt.increment();
		visualCnt.increment();
		visualCnt.increment();
		visualCnt.decrement();
		visualCnt.decrement();
		visualCnt.decrement();
		visualCnt.decrement();
	}
}