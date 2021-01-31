import java.util.Arrays;

public class Main {
	public static double[] closestPair(double[] arr) {
		double[] minimumPair = new double[2];
		double min;
		Arrays.sort(arr);

		//assuming the array always have size > 1
		min = Math.abs(arr[1] - arr[0]);
		minimumPair[0] = arr[0];
		minimumPair[1] = arr[1];

		for(int i = 1; i < arr.length; i++) {
			if(Math.abs(arr[i] - arr[i-1]) < min) {
				minimumPair[0] = arr[i-1];
				minimumPair[1] = arr[i];
				min = Math.abs(arr[i] - arr[i-1]);
			}
		}

		return minimumPair;
	}
}