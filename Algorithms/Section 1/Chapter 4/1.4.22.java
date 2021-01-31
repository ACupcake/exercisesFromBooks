public class Main {
	public static int binarySearchAddNSub(int[] arr, int key) {
		int min = 0;
		int max = arr.length - 1;
		int temp;

		int previousFib = 0;
		int actualFib = 1;
		//compute max
		while(actualFib < arr.length - 1) {
			temp = actualFib;
			actualFib += previousFib;
			previousFib = temp;
		}

		while(min <= max) {
			while(previousFib > 0 && actualFib >= max - min) {
				temp = previousFib;
				previousFib = actualFib - previousFib;
				actualFib = temp;
			}

			temp = min + previousFib;

			if(arr[temp] > key) max = temp - 1;
			if(arr[temp] < key) min = temp + 1;
			else {System.out.println(); return temp;}
		}
		return -1;
	}
}