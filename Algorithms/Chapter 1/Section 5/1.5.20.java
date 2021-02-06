public class DynamicGrowth {
	private int[] id;
	private int[] sz;
	private int count;
	private int siteSize;

	public DynamicGrowth() {
		id = new int[1];
		sz = new int[1];
		count = 1;
		siteSize = 0;
		// for(int i = 0; i < 1; i++)
			id[0] = 0;
		// for(int i = 0; i < sz.length; i++) {
            sz[0] = 1;
	}

	public int newSite() {
		if(siteSize == id.length) {
			resz(2 * id.length);
		} else if(id.length > 1 && siteSize == id.length / 4) {
			resz(id.length / 2);
		}

		count++;
		siteSize++;

		return siteSize - 1;
	}

	public void resz(int newSize) {
		int[] newID = new int[newSize];
		int[] newSZ = new int[newSize];

		for (int i = 0; i < siteSize; i++) {
			newID[i] = id[i];
			newSZ[i] = sz[i];
		}

		for (int i = siteSize; i < newSize; i++) {
			newID[i] = i;
			newSZ[i] = 1;
		}

		id = newID;
		sz = newSZ;
	}

	public void union(int p, int q) {
		int pID = find(p);
		int qID = find(q);
	
		if(pID == qID) return;

		int idToUpdate;
		int newID;

        if (sz[pID] < sz[qID]) {
            idToUpdate = pID;
            newID = qID;
        } else {
            idToUpdate = qID;
            newID = pID;
        }

		for(int i = 0; i < id.length; i++)
			if (id[i] == idToUpdate)
				id[i] = newID;

		sz[newID] += sz[idToUpdate];

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