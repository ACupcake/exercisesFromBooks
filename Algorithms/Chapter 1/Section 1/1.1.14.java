public class Main{
	public static void main(String[] args) {
		System.out.println(lg(38));
	}

	public static int lg(int N) {
		int twoPow = 1;
		int result = 0;

		while(twoPow < N) {
			twoPow *= 2;
			result++;
		}

		return result;
	}
}