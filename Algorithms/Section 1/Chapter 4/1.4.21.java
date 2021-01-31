import java.util.Arrays;
public class StaticSETofInts {
  private int[] a;
  private int[] distinctA;
  
  public StaticSETofInts(int[] keys, int R) {
    a = new int[keys.length];
    for (int i = 0; i < keys.length; i++)
    	a[i] = keys[i]; // defensive copy      
    Arrays.sort(a);

    distinctA = new int[R];
    for (int i = 0, int j = 0; i < keys.length; i++) {
		if(i == 0)
	    	distinctA[j++] = a[i];
    	else if(i > 0 && a[i] != a[i-1])
	    	distinctA[j++] = a[i];
    }
  }
  public boolean contains(int key) {
    return rank(key) != -1;
  }
  private int rank(int key)
  { // Binary search. 
    int lo = 0;
    int hi = distinctA.length - 1;
    while (lo <= hi)
    { // Key is in a[lo..hi] or not present. 
      int mid = lo + (hi - lo) / 2;
      if (key < distinctA[mid]) hi = mid - 1;
      else if (key > distinctA[mid]) lo = mid + 1;
      else return mid;
    }
    return - 1;
  }