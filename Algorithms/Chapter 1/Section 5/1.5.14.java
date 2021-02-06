public class Main {
	private int[] id; // parent link (site indexed)
	private int[] height;
	private int count; // number of components

	public Main(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) id[i] = i;
		height = new int[N];
		for (int i = 0; i < N; i++) height[i] = 1;
	}
	
	public int count() {
		return count;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	private int find(int p)
	{ // Follow links to find a root. 
		while (p != id[p]){
			cnt++;
			p = id[p];
		}
		return p;
	}

	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);

		if (i == j) return;

		// Make smaller root point to larger one.
		if (height[i] < height[j]) {
			id[i] = j;
			if(height[j] < height[i] + 1)
				height[j] = height[i] + 1;
		} else {
			id[j] = i;
			if(height[i] < height[j] + 1)
				height[i] = height[j] + 1;
		}
		count--;
	}
}