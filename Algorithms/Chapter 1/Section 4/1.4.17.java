public class Main {
	public static double[] farthestPair(double[] arr) {
		double[] maximumPair = new double[2];
		double max = arr[1];
		double min = arr[0];

		for(int i = 2; i < arr.length; i++) {
			if(arr[i] > max)
				max = arr[i];
			if(arr[i] < min)
				min = arr[i];
		}

		maximumPair[0] = min;
		maximumPair[1] = max;
		return maximumPair;
	}
}