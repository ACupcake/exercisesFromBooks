import java.util.Arrays;

public class Main{

	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		int mid;

		while (lo <= hi)
		{
		   mid = lo + (hi - lo) / 2;
		   if		(key < a[mid]) hi = mid - 1;
		   else if	(key > a[mid]) lo = mid + 1;
		   else {
				while(mid > 0 && a[mid] == a[mid - 1])
					mid--;
				return mid;
		   }
		}

		return -1;
	}

	public static int count(int key, int[] a) {
		int firstElement = rank(key, a);
		int pos = firstElement;
		
		if(pos == -1)
			return -1;

		while(pos < a.length - 1 && a[pos] == a[pos + 1])
			pos++;

		return pos + 1 - firstElement;
	}

	public static void main(String[] args) {
		int[] whitelist = In.readInts(args[0]);

		Arrays.sort(whitelist);

		while (!StdIn.isEmpty())
		{
			int key = StdIn.readInt();
			if (rank(key, whitelist) == -1){
			   	StdOut.println(key);
			} else {
				StdOut.println("elements: " + count(key, whitelist));
			}
		}
	}
}