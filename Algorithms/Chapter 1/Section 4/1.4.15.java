import java.util.Arrays;

public class Main {
  public static int faster3Sum(int[] a)
  { // Count pairs that sum to 0.
    Arrays.sort(a); //array sort is not considered in analysis

    int N = a.length;
    int cnt = 0;

    for (int i = 0; i < N; i++) {
        int indexEnd = N - 1;
        int repeat;
        for (int j = i+1; j < N && a[j] <= 0; j++) {
            repeat = 0;
            
            //walk while a[indexEnd] is bigger that the sum
            while(a[indexEnd] > -(a[i] + a[j]))
                indexEnd--;

            //walk while a[indexEnd] is equal to the sum
            while(indexEnd > j && -(a[i] + a[j]) == a[indexEnd]) {
                repeat++;
                indexEnd--;
            }

            //add new triple found and check if it has duplicate
            if(j == i+1 || a[j] != a[j-1]){
                cnt += repeat;
                int k = 1;
                while(repeat - k > 0 && j+k < N && a[j] == a[j + k]) {
                    cnt += repeat - k;
                    k++;
                }
            }
        }
    }

    return cnt;
  }
}