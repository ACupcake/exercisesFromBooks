import java.util.Arrays;

public class BinarySearch
{
	public static int rank(int key, int[] a, Counter keysCounter)
	{ // Array must be sorted.
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi)
		{ // Key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else 					 return mid;
			keysCounter.increment();
		}
		return - 1;
	}
	public static void main(String[] args)
	{
		int[] whitelist = In.readInts(args[0]);
		int listSize = 1000;
		Counter keysCounter = new Counter("Keys Examined", listSize);
		Arrays.sort(whitelist);

		while (!StdIn.isEmpty())
		{ // Read key, print if not in whitelist.
			int key = StdIn.readInt();
			if (rank(key, whitelist, keysCounter) < 0)
				StdOut.println(key);
		}

		System.out.println(keysCounter);
	}
}