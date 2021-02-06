public class Main {

	public static void main(String[] args) {
		int p = StdIn.readInt();
		int q = StdIn.readInt();
		gcd(p, q);
	}

	public static int gcd(int p, int q) {
		StdOut.println(p + " " + q);

		if (q == 0) return p;
		return gcd(q, p % q);
	}

}