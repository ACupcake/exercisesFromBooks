public class WeightedQuickFindUF {
	private int[] id;
	private int[] sz;
	private int count;

	public QuickFindUF(int N) {
		id = new int[N];
		sz = new int[N];
		count = N;

		for(int i = 0; i < N; i++)
			id[i] = i;
		for(int i = 0; i < sz.length; i++) {
            sz[i] = 1;
	}

//https://github.com/reneargento/algorithms-sedgewick-wayne/blob/master/src/chapter1/section5/Exercise11.java
	public void union(int p, int q) {
		int pID = find(p);
		int qID = find(q);
	
		if(pID == qID) return;

		int idToUpdate;
		int newID;

        if (size[pID] < size[qID]) {
            idToUpdate = pID;
            newID = qID;
        } else {
            idToUpdate = qID;
            newID = pID;
        }

		for(int i = 0; i < id.length; i++)
			if (id[i] == idToUpdate)
				id[i] = newID;

		size[newID] += size[idToUpdate];

		count--;
	}

	public int find(int p) {
		return id[p];
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int count() {
		return count;
	}
}