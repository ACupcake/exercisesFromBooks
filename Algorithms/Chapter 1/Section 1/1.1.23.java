import java.util.Arrays;

public class Main
{
    public static int rank(int key, int[] a)
    {   // Array must be sorted.
        int lo  = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else                   return mid;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        boolean outputWhitelist = false;
        int key = -1;

        while (!StdIn.isEmpty())
        {   // Read key, print if not in whitelist.
            String input = StdIn.readString();

            if(input.equals("+"))
            {
                outputWhitelist = true;
                StdOut.println("[+]Outputting elements in whitelist");
            }
            else if(input.equals("-")) {
                outputWhitelist = false;
                StdOut.println("[+]Outputting elements not in whitelist");
            }
            else
            {
                key = Integer.parseInt(input); 

                if(outputWhitelist == true)
                {
                    if (rank(key, whitelist) > 0)
                    {
                        StdOut.println(key);
                    }
                }
                else if(outputWhitelist == false)
                {
                    if (rank(key, whitelist) < 0)
                    {
                        StdOut.println(key);
                    }
                }
            }
        }
    }
}