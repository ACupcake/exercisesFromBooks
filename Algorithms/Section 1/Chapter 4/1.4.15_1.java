import java.util.Arrays;

public class Main {
  public static int twoSumFaster(int[] a)
  { // Count pairs that sum to 0.
    Arrays.sort(a); //array sort is not considered in analysis

    int N = a.length;
    int cnt = 0;
    int indexEnd = N - 1;
    int multiply = 1;

    for (int indexBegin = 0; indexBegin < indexEnd; indexBegin++) {
        if(a[indexBegin+1] == a[indexBegin]) {
            multiply += 1;
        } else {
            int countExtra = 0;
            //walk backwards counting repeated numbers equal to -a[indexBegin]
            while(indexEnd >= 0 && a[indexEnd] >= -a[indexBegin]) {
                if(a[indexEnd] == -(a[indexBegin]))
                    countExtra += 1;
                indexEnd--;
            }

            cnt += multiply * countExtra;
            multiply = 1;
        }
    }

    if(multiply > 1)
        cnt+= (multiply*(multiply - 1))/2;

    return cnt;
  }
  public static void main(String[] args) {
      int[] a = In.readInts(args[0]);
      StdOut.println(count(a));
  }
}