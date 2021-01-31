public class Main
{
	public static void main(String[] args)
	{
		double[] diceSum = new double[13];
		int diceThrows = 50_000_000; //N must be > ~50 000 000

		for (int i = 0; i < diceThrows; i++)
			diceSum[StdRandom.uniform(1, 7) + StdRandom.uniform(1, 7)]++;

		for (int i = 2; i <= 12; i++)
			diceSum[i] /= diceThrows;

		for (int i = 1; i <= 12; i++)
			StdOut.printf("%d: %f\n", i, diceSum[i]);

	}
}
