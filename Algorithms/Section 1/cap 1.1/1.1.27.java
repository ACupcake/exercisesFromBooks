public class Main
{
	public static void main(String[] args) {
		System.out.println("binomial: " + binomial(4, 6, 0.3));
		System.out.println("bi2: " + binomial2(4, 6, 0.3));
	}
	
	static int conta = 0;
	
	public static double binomial(int N, int k, double p) {
	    System.out.println(conta);
	    conta++;
	    if ((N == 0) || (k < 0)) return 1.0;
	    return (1.0 - p)*binomial(N-1, k, p) + p*binomial(N-1, k-1, p);
    }

    public static double binomial2(int N, int k, double p) {
        int nCont = 0;
        int kCont = 0;
        double[] vec = new double[100];
        vec[0] = 1;
        
        while(nCont != N && kCont != k) {
            if(nCont > 0)
                vec[nCont] = (1 - p)*vec[nCont - 1] + p*vec[nCont - 1];
            else
                vec[nCont] = (1 - p)*vec[nCont] + p*vec[nCont];
            
            nCont++;
        }
	    
    	return vec[nCont - 1];
    }

    /* Assuming that array starts filled with -1 */
    public static double binomial3(int N, int k, double p, double[][] array) {
		if(N == 0 && k == 0)
			return 1.0;
		else if ((N < 0) || (k < 0))
			return 0.0;
		else if(array[N][k] == -1)
			array[N][k] = (1.0 - p)*binomial(N-1, k, p) + p*binomial(N-1, k-1, p);
    	
    	return array[N][k];
    }
}
