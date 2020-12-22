public class Accumulator
{	
	private double m;
	private double s;
	private int N;
	
	public void addDataValue(double x)
	{
		N++;
		s = s + 1.0 * (N-1) / N * (x - m) * (x - m);
		m = m + (x - m) / N;
	}
	
	public double mean()
	{	return m;	}
	
	public double var()
	{	return s / (N - 1);	}
	
	public double stddev()
	{	return Math.sqrt(this.var());	}
	
	public static void main(String...args) {
		Accumulator accumulatorTest = new Accumulator();
		accumulatorTest.addDataValue(1);
		accumulatorTest.addDataValue(2);
		accumulatorTest.addDataValue(3);
		accumulatorTest.addDataValue(4);
		
		StdOut.println(accumulatorTest.mean()); //mean = 2.5
		StdOut.println(accumulatorTest.var()); //variance = 1.666..
		StdOut.println(accumulatorTest.stddev()); //standard deviation = 1.2909944
	}

