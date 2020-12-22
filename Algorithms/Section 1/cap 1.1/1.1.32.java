public class Main {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		double l = Double.parseDouble(args[1]);
		double r = Double.parseDouble(args[2]);
		double[] histogram = new double[N];

		double intervals = (r - l) /  N;

		//while(!StdIn.isEmpty()) {
		//	histogram[StdIn.readInt()]++;
		//}

		for (int i = 0; i < N; i++)
			histogram[i] = StdRandom.random(); 

		for (int i = 0; i < N; i++) {
			double x = 1.0 * i / N;
			double y = histogram[i] / 2.0;
			double rw = 0.5 / N;
			double rh = histogram[i] / 2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}

	}
}