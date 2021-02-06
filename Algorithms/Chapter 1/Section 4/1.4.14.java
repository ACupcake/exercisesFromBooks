import java.util.Arrays;

public class Main {
	//O(N^4)
	public static int bruteForce4Sum(int[] arr) {
		int size = arr.length;
		int cnt = 0;

		for (int i = 0; i < size; i++ ) {
			for (int j = i+1; j < size; j++ ) {
				for (int k = j+1; k < size; k++ ) {
					for (int l = k+1; l < size; l++ ) {
						if(arr[i] + arr[j] + arr[k] + arr[l] == 0) {
							cnt++;
						}
					}
				}
			}
		}
		return cnt;
	}

	//O(n³*log(n))
	public static int faster4Sum(int[] arr) {
		int size = arr.length;
		int cnt = 0;

		//O(n*log(n))
		Arrays.sort(arr);

		//O(n³*log(n))
		for (int i = 1; i < size; i++ ) {
			for (int j = i+1; j < size; j++ ) {
				for (int k = j+1; k < size; k++ ) {
					if(binarySearch(arr, -(arr[i]+arr[j]+arr[k]), 0, i-1)) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	public static boolean binarySearch(int[] arr, int key, int lo, int hi) {
		while(lo <= hi) {
			int mid = (lo + hi) / 2;

			if(arr[mid] > key) hi = mid - 1;
			else if (arr[mid] < key) lo = mid + 1;
			else return true;
		}
		return false;
	}



}