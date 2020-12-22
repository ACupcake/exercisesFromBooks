public class Main {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		Point2D[] pointArr = new Point2D[N];

		for(int i = 0; i < N; i++) {
			Point2D point = new Point2D(StdRandom.uniform(), StdRandom.uniform());
			point.draw();
			pointArr[i] = point;
		}

		if(N > 1)
			double minDistance = pointArr[0].distanceTo(pointArr[1]);
		else
			double minDistance = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				double distance = pointArr[i].distanceTo(pointArr[j]);
				if(distance < minDistance)
					minDistance = distance;
			}
		}

		StdOut.println("Distance between closest pair: " + minDistance);
	}
}