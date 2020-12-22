public class Main {
	public static void main(String[] args) {
        int[] a = {0, 1, 2, 3};
		
		int[] b = histogram(a, 4);

		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
	
	}

	public static int[] histogram(int[] a, int M) {
		int[] list = new int[M];

		for(int i = 0; i < M; i++) {
			if(a[i] < M)
				list[a[i]]++;
		}

		return list;
	}
}