public class Main {
	public static void main(String[] args) {
		int[] array1 = {1, 2, 3, 4, -1, -2, -3};
        int[] array2 = {1, 5, 4, 3, 2, 0};
        int[] array3 = {2, 4, 8, 16, 32, 1};
        int[] array4 = {2, 4, 8, 16, 32};
        int[] array5 = {2, 1};
        int[] array6 = {9};

        int indexOfElement1 = bitonicSearch(array1, -1);
        int indexOfElement2 = bitonicSearch(array2, 5);
        int indexOfElement3 = bitonicSearch(array3, 2);
        int indexOfElement4 = bitonicSearch(array3, 99);
        int indexOfElement5 = bitonicSearch(array4, 32);
        int indexOfElement6 = bitonicSearch(array5, 1);
        int indexOfElement7 = bitonicSearch(array6, 9);

        System.out.println("Index of element: " + indexOfElement1 + " Expected: 4");
        System.out.println("Index of element: " + indexOfElement2 + " Expected: 1");
        System.out.println("Index of element: " + indexOfElement3 + " Expected: 0");
        System.out.println("Index of element: " + indexOfElement4 + " Expected: -1");
        System.out.println("Index of element: " + indexOfElement5 + " Expected: 4");
        System.out.println("Index of element: " + indexOfElement6 + " Expected: 1");
        System.out.println("Index of element: " + indexOfElement7 + " Expected: 0");
	}

	public static int bitonicSearch(int[] arr, int key) {
		int maximumIndex = binarySearchMax(arr);

		int index = keyIsInArrayInOrder(arr, key, 0, maximumIndex);
		if(index != -1 && arr[index] == key)
			return index;

		index = keyIsInArrayBackwards(arr, key, maximumIndex+1, arr.length - 1);
		if(index != -1 && arr[index] == key)
			return index;

		return -1;
	}

	public static int keyIsInArrayInOrder(int[] arr, int key, int min, int max) {
		while(min <= max) {
			int mid = (max + min) / 2;
			if(arr[mid] > key) max = mid - 1;
			else if(arr[mid] < key) min = mid + 1;
			else return mid;
		}
		return -1;
	}

	public static int keyIsInArrayBackwards(int[] arr, int key, int min, int max) {
		while(min <= max) {
			int mid = (max + min) / 2;
			if(arr[mid] > key) min = mid + 1;
			else if(arr[mid] < key) max = mid - 1;
			else return mid;
		}
		return -1;
	}

	public static int binarySearchMax(int[] arr) {
		int min = 0;
		int max = arr.length;
		int key = arr[0];
		int indexKey = 0;
		int mid = (max + min) / 2;

		while(min <= max) {
			mid = (max + min) / 2;
			if(arr[mid] > key) {
				key = arr[mid];
				indexKey = mid;
			}

			if (mid < max-1 && arr[mid+1] > arr[mid]) {
				min = mid + 1;
			}
			else {
				max = mid - 1;
			}
		}
		return indexKey;
	}
}