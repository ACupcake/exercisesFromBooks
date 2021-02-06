public class Main{
	public static void main(String[] args) {
	    int N = 5;
	    if(N < 0)
	        System.out.println("invalid value");
	    else
    		System.out.println(Math.log(factorial(N)));
	}

	public static int factorial(int N) {
		if(N == 1 || N == 0) return 1;
		return N * factorial(N-1);
	}
}