public class Main {
    public static void main(String[] args) {
        long[] array = new long[100]; /*better use double?*/

        for (int N = 0; N < 100; N++) {
            array[N] = F(N, array);
            System.out.println(N + " " + array[N]);
        }
    }

    private static long F(int N, long[] array) {
        if(N == 0)
            return 0;
        else if(N == 1)
            return 1;
        else
            return array[N-1] + array[N-2];
    }
}