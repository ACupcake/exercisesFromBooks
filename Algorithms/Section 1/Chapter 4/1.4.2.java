import java.math.BigInteger;

public class ThreeSum {

    private ThreeSum() { }

    public static void printAll(int[] a) {
        int n = a.length;
        
        BigInteger bigInt;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    bigInt = BigInteger.valueOf(a[i]);
                    bigInt = BigInteger.add(BigInteger.valueOf(a[j]));
                    bigInt = BigInteger.add(BigInteger.valueOf(a[k]));
                    if (bigInt.intValue() == 0) {
                        StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                    }
                    bigInt = 0;
                    /* Since the max in a[n] is Integer.MAX_VALUE
                     * we can divide each a[] by two and sum
                     * up the values to see if their values are
                     * equal to -a[k]/2.
                     **/ 
                    // int plusOne = 0;
                    // //check if both are odd and sum 1
                    // if(a[i] % 2 != 0 && a[j] % 2 != 0) {
                    //     plusOne = 1;
                    // }
                    // if (a[i]/2 + a[j]/2 + plusOne == -a[k]/2) {
                    //     StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                    // }
                    
                    /* We also can verify if a[i] + a[j] return
                     * a overflow, if it is true we do not need
                     * to verify if they sum up to a[k] since
                     * the max value in a[k] is Integer.MAX_VALUE.
                     **/
                }
            }
        }
    } 

    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    } 

    public static void main(String[] args)  { 
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
    } 
} 
