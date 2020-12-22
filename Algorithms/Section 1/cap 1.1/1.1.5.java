public class Main {
	/* main test */
	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);

		if(isFraction(x, y))
			System.out.print("true");
		else
			System.out.print("false");
	}

	/* code fragment */
	public static boolean isFraction(double x, double y) {
		return (0 < x && x < 1 && 0 < y && y < 1);
	}
}