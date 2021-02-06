/* -Binary search with duplicates-
 * https://algs4.cs.princeton.edu/14analysis
 * New question found in the site, the original was confusing
 */

public class Main {
	public static void main(String[] args) {
        int[] array = {-4, -1, 1, 2, 2, 2, 2, 2, 2, 2, 4, 5};

        //First rank tests
        int firstRankElement1 = minKeyIndexBinarySearch(array, -4);
        int firstRankElement2 = minKeyIndexBinarySearch(array, -8);
        int firstRankElement3 = minKeyIndexBinarySearch(array, 5);
        int firstRankElement4 = minKeyIndexBinarySearch(array, 2);

        StdOut.println("First index of element -4: " + firstRankElement1 + " Expected: 0");
        StdOut.println("First index of element -8: " + firstRankElement2 + " Expected: -1");
        StdOut.println("First index of element 5: " + firstRankElement3 + " Expected: 11");
        StdOut.println("First index of element 2: " + firstRankElement4 + " Expected: 3");

        //Last rank tests
        int firstRankElement5 = maxKeyIndexBinarySearch(array, -4);
        int firstRankElement6 = maxKeyIndexBinarySearch(array, -8);
        int firstRankElement7 = maxKeyIndexBinarySearch(array, 5);
        int firstRankElement8 = maxKeyIndexBinarySearch(array, 2);

        StdOut.println("Last index of element -4: " + firstRankElement5 + " Expected: 0");
        StdOut.println("Last index of element -8: " + firstRankElement6 + " Expected: -1");
        StdOut.println("Last index of element 5: " + firstRankElement7 + " Expected: 11");
        StdOut.println("Last index of element 2: " + firstRankElement8 + " Expected: 9");
	}

	public static int minKeyIndexBinarySearch(int arr[], int key) {
		int min = 0;
		int max = arr.length - 1;
		int mid = (max + min) / 2;

		while(min <= max) {
			mid = (max + min) / 2;
			if(arr[mid] >= key) max = mid - 1;
			else min = mid + 1;
		}
		if(arr[mid] != key)
			return -1;
		return mid;
	}

	public static int maxKeyIndexBinarySearch(int arr[], int key) {
		int min = 0;
		int max = arr.length - 1;
		int mid = (max + min) / 2;

		while(min <= max) {
			mid = (max + min) / 2;
			if(arr[mid] <= key) min = mid + 1;
			else if(arr[mid] > key) max = mid - 1;
		
			if(mid == 0)
				break;
		}
		if(arr[mid] != key)
			return -1;
		return mid;
	}
}