import java.util.Arrays;

//brute: ~0.700s
//binary not sorted (sorted in exec): ~0.775s
//binary sorted (sorted before exec): 


public class Main {
	public static void main(String[] args) {
		int[] a = In.readInts(args[0]);
		int key = Integer.parseInt(args[1]);
		
		//StdOut.println("Brute force:");
		//StdOut.println(bruteForceSearch(a, key));

		StdOut.println("Binary search:");
		StdOut.println(binarySearch(a, key));
	}
	
	public static int bruteForceSearch(int a[], int key) {
		for (int i = 0; i < a.length; i++)
			if (a[i] == key) return key;
		return -1;
	}

	public static int rank(int key, int[] a)
	{  // Array must be sorted.

		int lo  = 0;
		int hi = a.length - 1;
		while (lo <= hi)
		{  // Key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2;
			if	(key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else	return mid;
		}
		return -1;
	}

	public static int binarySearch(int[] whitelist, int key)
	{
		Arrays.sort(whitelist);
		if (whitelist[rank(key, whitelist)] == key)
			return key;
		return -1;
	}
}