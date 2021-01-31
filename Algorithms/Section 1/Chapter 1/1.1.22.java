public class Main {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
		rank(0, a);
	}
    
	public static int rank(int key, int[] a) {  
		return rank(key, a, 0, a.length - 1, 1);
	}

	public static int rank(int key, int[] a, int lo, int hi, int depth) {
		for(int i = 0; i < depth; i++)
		    System.out.print(" ");
		System.out.printf("lo:%d - ", lo);
		System.out.printf("hi:%d\n", hi);
		// Index of key in a[], if present, is not smaller than lo
		//									and not larger than hi.
		if (lo > hi) return -1;
		int mid = lo + (hi - lo) / 2;
		if(key < a[mid]) 	   return rank(key, a, lo, mid - 1, depth + 1);
		else if (key > a[mid]) return rank(key, a, mid + 1, hi, depth + 1);
		else 				   return mid;
	}

}