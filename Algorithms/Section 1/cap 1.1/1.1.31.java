public class Main {
	public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
		double[][] points = new double[N][2];

		double angle = 360 / N;
		double angleMove = 0;
		int i = 0;

		while(angleMove < 360) {
			points[i][0] = 0.5 + 0.3 * Math.cos(Math.toRadians(angleMove));
			points[i][1] = 0.5 + 0.3 * Math.sin(Math.toRadians(angleMove));

			StdDraw.filledCircle(points[i][0], points[i][1], 0.005);
			angleMove += angle;
			i++;
		}

		//StdDraw.circle(0.5, 0.5, 0.3);
		StdDraw.setPenColor(StdDraw.GRAY);

		for(int j = 0; j < i; j++) {
			for(int k = j + 1; k < i; k++) {
				if(StdRandom.bernoulli(p)) {
					StdDraw.line(points[j][0], points[j][1], points[k][0], points[k][1]);
				}
			}
		}

	}
}