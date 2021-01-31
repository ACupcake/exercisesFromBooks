public class Main {
	//log(n)
	public static int localMinimum(int[] arr) {
		if(arr.length == 1)
			return arr[0];
		return binarySearch(arr);
	}

	public static int binarySearch(int[] arr) {
		int min = 0;
		int max = arr.length - 1;
		int mid;

		while(min <= max) {
			mid = (min + max) / 2;

			if(mid == 0 && arr[mid] < arr[mid+1])
			{
				return arr[mid];
			}
			else if(mid == arr.length - 1 && arr[mid] < arr[mid-1])
			{
				return arr[mid];
			}
			else if(mid > 0 && mid < arr.length - 1 && arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1])
			{
				return arr[mid];
			}
			else if(mid > 0 && arr[mid] > arr[mid - 1])
			{
				max = mid - 1;
			} 
			else
			{
				min = mid + 1;
			}

		}
		return -1;
	}

}






/*
public class Main {
	//O(2*log(n))
	public static int localMinimum(int[] arr) {
		if(arr.length == 1)
			return arr[0];
		int rightResult = binarySearch(arr, false);
		if(rightResult == -1)
			return binarySearch(arr, true);
		return rightResult;
	}

	public static int binarySearch(int[] arr, boolean leftSearch) {
		int min = 0;
		int max = arr.length - 1;
		int mid;

		while(min <= max) {
			mid = (min + max) / 2;
			if(mid == 0)
			{
				if(arr[mid] < arr[mid+1])
					return arr[mid];
			}
			else if(arr[mid] < arr[mid-1])
			{
				if(mid == arr.length-1)
					return arr[mid];
			}
			else if(arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1])
			{
				return arr[mid];
			}

			if(leftSearch)
				max = mid - 1;
			else
				min = mid + 1;
		}
		return -1;
	}

}
*/