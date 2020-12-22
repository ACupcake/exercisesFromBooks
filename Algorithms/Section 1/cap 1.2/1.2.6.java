public class Main{
	public static boolean isCircularRotation(String a, String b) {
		return (b+b).indexOf(a) != -1;
		//other solution
		//return s.length() == t.length() && (s+s).contains(t);
	}

	public static void main(String[] args) {
		String a = "ACTGACG";
		String b = "TGACGAC";

		System.out.println(isCircularRotation(a, b));
	}
}