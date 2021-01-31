public class Main {
	public static void main(String[] args) {
		double[] x = {1, 2, 3};
		double[] y = {4, 5, 6};

		double[][] a = {{1,2,3}, {4,5,6}, {7,8,9}};
		double[][] b = {{9,8,7}, {6,5,4}, {3,2,1}};

		double[] c;
		double[][] d;

		StdOut.println("Dot Product: ");
		StdOut.println(Matrix.dot(x, y));
		StdOut.println();

		StdOut.println("Matrix Product:");
		d = Matrix.mult(a, b);
		for(double[] i: d) {
			for(double j: i)
				StdOut.print(j + " ");
			StdOut.println();
		}
		StdOut.println();

		StdOut.println("Transpose Matrix:");
		d = Matrix.transpose(a);
		for(double[] i: d) {
			for(double j: i)
				StdOut.print(j + " ");
			StdOut.println();
		}
		StdOut.println();

		StdOut.println("Matrix-Vector Product:");
		c = Matrix.mult(a,x);
		for(double i: c)
			StdOut.print(i + " ");
		StdOut.println();
		StdOut.println();


		StdOut.println("Vector-Matrix Product:");
		c = Matrix.mult(y,b);
		for(double i: c)
			StdOut.print(i + " ");
	}

}

public class Matrix {
    public static double dot(double[] x, double[] y) {
        double product = 0;

        for(int i = 0; i < x.length; i++)
            product += x[i] * y[i];

        return product;

    }

    public static double[][] transpose(double[][] a) {
        for(int i = 0; i < Math.ceil(a.length); i++)
            for(int j = i; j < Math.ceil(a[i].length); j++) {
                double temp;
                temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        return a; 
    }

    public static double[][] mult(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
        int cLine = 0;

        for(int k = 0; k < a.length; k++)
            for(int i = 0; i < a.length; i++)
                for(int j = 0; j < b[k].length; j++)
                    c[i][k] += a[i][j] * b[j][k];


        return c;
    }

    public static double[] mult(double[][] a, double[] x) {
        double[] c = new double[a.length];

        for(int i = 0; i < a.length; i++)
            for(int j = 0; j < x.length; j++)
                c[i] += a[i][j] * x[j];

        return c;
    }


    public static double[] mult(double[] x, double[][] a) {
        double[] c = new double[a.length];

        for(int j = 0; j < x.length; j++)
            for(int i = 0; i < a.length; i++)
                c[j] += x[i] * a[i][j];

        return c;
    }
}