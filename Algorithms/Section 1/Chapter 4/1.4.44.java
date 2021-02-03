import java.util.HashMap;

public class BirthdayProblem {
	public static void main(String[] args) {
		int limit = Integer.parseInt(args[0]);
		System.out.println("Result: " + birthdayProblem(limit));
		System.out.println("Expected: " + Math.sqrt(Math.PI * limit / 2));
	}

	public static double birthdayProblem(int limit) {
		HashMap<Integer, Integer> randomNumbers = new HashMap<>();
		int randomNumber = StdRandom.uniform(limit);
		double cnt = 0;

		while(randomNumbers.get(randomNumber) == null) {
			randomNumbers.put(randomNumber, 1);
			randomNumber = StdRandom.uniform(limit);
			cnt++;
		}
		return cnt;
	}
}