import java.util.HashMap;
//CouponCollectorProblem
public class  Main{
	public static void main(String[] args) {
		int limit = Integer.parseInt(args[0]);
		System.out.println("Result: " + couponCollectorProblem(limit));
		System.out.println("Expected: " + (harmonic(limit) * limit));
	}

	public static double couponCollectorProblem(int limit) {
		HashMap<Integer, Integer> randomNumbers = new HashMap<>();
		int randomNumber = StdRandom.uniform(limit);
		double cnt = 0;

		while(randomNumbers.size() < limit) {
			cnt++;
			if(randomNumbers.get(randomNumber) == null) {
				randomNumbers.put(randomNumber, 1);
			}
			randomNumber = StdRandom.uniform(0, limit);
		}
		return cnt;
	}

	public static double harmonic(int limit) {
		double result = 0;

		for(double i = 1.0; i < limit; i++) {
			result += 1/i;
		}
		return result;
	}
}