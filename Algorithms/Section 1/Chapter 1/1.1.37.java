public class Main {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int M = Integer.parseInt(args[1]);

		int[] array = new int[M];
		int[][] savedValues = new int[M][M];
		inicializeArray(array);

		for(int i = 0 ; i < N; i++) {
			shuffle(array);

			for(int j = 0; j < M; j++)
				savedValues[array[j]][j]++;
			inicializeArray(array);
		}

		for(int i = 0 ; i < M; i++) {
			for(int j = 0 ; j < M; j++) {
				StdOut.printf("%d ", savedValues[i][j]);
			}
			StdOut.println();
		}
	}

	public static void inicializeArray(int[] array) {
		for(int i = 0; i < array.length; i++)
			array[i] = i;
	}

	public static void shuffle(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = 0 + StdRandom.uniform(n-i);     // between i and n-1
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
	
}