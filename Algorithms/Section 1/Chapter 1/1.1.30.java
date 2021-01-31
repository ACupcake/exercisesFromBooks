public class Main {
	public static void main(String[] args) {
		boolean[][] a = relativelyPrimeArray(5);

		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}

	}

	public static int gcd(int p, int q) {
		if (q == 0) return p;
		int r = p % q;
		return gcd(q, r);
	}

	public static boolean[][] relativelyPrimeArray(int N) {
		boolean[][] a = new boolean[N][N];

		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
			{
				a[i][j] = false;
				if(gcd(i, j) == 1)
				{
					a[i][j] = true;
				}
			}

		return a;
	}

}