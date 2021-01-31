import java.util.Arrays;

public class StaticSETofInts {
  private int[] a;

  public StaticSETofInts(int[] keys) {
    a = new int[keys.length];
    for (int i = 0; i < keys.length; i++)
        a[i] = keys[i]; // defensive copy
    Arrays.sort(a);
  }

  public boolean contains(int key) {
    return rank(key) != -1;
  }

  private int rank(int key)
  { // Binary search.
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi)
    { // Key is in a[lo..hi] or not present.
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) hi = mid - 1;
      else if (key > a[mid]) lo = mid + 1;
      else return mid;
    }
    return - 1;
  }

  public int rankMinMax(int key, boolean rankMin) {
  	int index = -1;
    int lo = 0;
    int hi = a.length - 1;

    while (lo <= hi)
    { // Key is in a[lo..hi] or not present.
      int mid = lo + (hi - lo) / 2;

      if(rankMin) {
      	if (key <= a[mid]) hi = mid - 1;
      	else if (key >= a[mid]) lo = mid + 1;
      } else {
      	if (key >= a[mid]) lo = mid + 1;
      	else if (key <= a[mid]) hi = mid - 1;
      }

	    if(a[mid] == key) {
		    if(index == -1)
		      index = mid;
		    else if(mid < index)
		      index = mid;
	    }
    }
    return index;
  }

  public int howMany(int key) {
    int minIndex = rankMinMax(key, true);
    int maxIndex = rankMinMax(key, false);

    if(maxIndex != -1 && maxIndex < a.length - 1)
	    maxIndex += 1;
    if(minIndex != -1 && minIndex > 0)
	    minIndex -= 1;

    return maxIndex - minIndex;
  }
}