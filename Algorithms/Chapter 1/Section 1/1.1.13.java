public class Main {
	public static void main(String[] args) {
		int[][] matrix = {{1,2}, {3,4}};
		printTranspose(matrix);
	}

	public static void printTranspose(int[][] matrix) {
	    
		for(int i = 0; i < matrix[0].length; i++) {
			for(int j = 0; j < matrix.length; j++)
				System.out.print(matrix[j][i] + " ");
			System.out.println();
		}
		
	}
}