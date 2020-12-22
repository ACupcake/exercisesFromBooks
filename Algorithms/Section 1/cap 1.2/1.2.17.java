public class Rational {
	private long numerator;
	private long denominator;

	public static void main(String[] args) {
		Rational a = new Rational(1, 2);
		Rational b = new Rational(3, 4);



		System.out.println(a.times(b));
	}
	public Rational(long numerator, long denominator) {
		assert denominator != 0 : "Zero division.";
		assert numerator < Integer.MAX_VALUE : "Overflow.";
		assert denominator < Integer.MAX_VALUE : "Overflow.";

		this.numerator = (long) numerator;
		this.denominator = (long) denominator;
	}
	public long numerator() {
		return numerator;
	}
	public long denominator() {
		return denominator;
	}
	public Rational plus(Rational b) {
		assert (this.numerator * b.denominator) + (b.numerator * this.denominator) < Integer.MAX_VALUE : "Overflow.";
		assert this.denominator * b.denominator < Integer.MAX_VALUE : "Overflow.";

		long cNumerator = (this.numerator * b.denominator) + (b.numerator * this.denominator);
		long cDenominator = this.denominator * b.denominator;
		long gcdC = gcd(cNumerator, cDenominator);
		cNumerator /= gcdC;
		cDenominator /= gcdC;

		Rational c = new Rational(cNumerator, cDenominator);
		return c;
	}
	public Rational minus(Rational b) {
		assert (this.numerator * b.denominator)  < Integer.MAX_VALUE : "Overflow.";
		assert (b.numerator * this.denominator)  < Integer.MAX_VALUE : "Overflow.";
		assert (this.denominator * b.denominator)  < Integer.MAX_VALUE : "Overflow.";
		assert (this.numerator * b.denominator) - (b.numerator * this.denominator)  > Integer.MIN_VALUE : "Overflow.";

		long cNumerator = (this.numerator * b.denominator) - (b.numerator * this.denominator);
		long cDenominator = this.denominator * b.denominator;
		long gcdC = gcd(cNumerator, cDenominator);
		cNumerator /= gcdC;
		cDenominator /= gcdC;

		Rational c = new Rational(cNumerator, cDenominator);
		return c;
	}
	public Rational times(Rational b) {
		assert (this.numerator * b.denominator)  < Integer.MAX_VALUE : "Overflow.";
		assert (this.denominator * b.denominator)  < Integer.MAX_VALUE : "Overflow.";

		long cNumerator = this.numerator * b.numerator;
		long cDenominator = this.denominator * b.denominator;
		long gcdC = gcd(cNumerator, cDenominator);
		cNumerator /= gcdC;
		cDenominator /= gcdC;

		Rational c = new Rational(cNumerator, cDenominator);
		return c;
	}
	public Rational divides(Rational b) {
		assert b.numerator != 0 : "Zero division.";
		assert (this.numerator * b.denominator)  < Integer.MAX_VALUE : "Overflow.";
		assert (this.denominator * b.numerator)  < Integer.MAX_VALUE : "Overflow.";

		long cNumerator = this.numerator * b.denominator;
		long cDenominator = this.denominator * b.numerator;
		long gcdC = gcd(cNumerator, cDenominator);
		cNumerator /= gcdC;
		cDenominator /= gcdC;

		Rational c = new Rational(cNumerator, cDenominator);
		return c;
	}
	public boolean equals(Rational that) {
		if(that == null)
			return false;
		if (this.getClass() != that.getClass())
			return false;
		if(this.numerator() == that.numerator())
			if(this.denominator() == that.denominator())
				return true;
		return false;
	}
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}
	private static long gcd(long p, long q)
	{
		if (q == 0) return p;
		long r = p % q;
		return gcd(q, r);
	}
}