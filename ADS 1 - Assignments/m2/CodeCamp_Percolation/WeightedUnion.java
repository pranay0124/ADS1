class WeightedUnion {
	private int[] array;
	private int[] size;

	WeightedUnion(int n) {
		array = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = i;
			size[i] = 1;
		}
	}

	public int find(int p) {
		while (p != array[p]) {
			p = array[p];
		}
		return p;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public void union(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		if (connected(p, q)) {
			return;
		}
		if (size[pID] < size[qID]) {
			array[pID] = qID;
			size[qID] += size[pID];
		} else {
			array[qID] = pID;
			size[pID] += size[qID];
		}
	}
}