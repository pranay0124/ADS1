class Percolation {
	static boolean[][] grid;
	int top = 0;
	int bottom;
	int size;
	int count;
	WeightedUnion wu;

	public Percolation(int n) {
		grid = new boolean[n][n];
		size = n;
		bottom = n * n + 1;
		wu = new WeightedUnion(n * n + 2);
	}

	public void open(int row, int column) {
		if (isOpen(row, column)) return;
		count++;
		grid[row - 1][column - 1] = true;
		if (row == 1) {
			wu.union(top, getIndex(row, column));
		}
		if (row == size) {
			wu.union(getIndex(row, column), bottom);
		}
		if (row > 1 && isOpen(row - 1, column)) {
			wu.union(getIndex(row, column), getIndex(row - 1, column));
		}
		if (row < size && isOpen(row + 1, column)) {
			wu.union(getIndex(row, column), getIndex(row + 1 , column));
		}
		if (column > 1 && isOpen(row, column - 1)) {
			wu.union(getIndex(row, column), getIndex(row, column - 1));
		}
		if (column < size && isOpen(row, column + 1)) {
			wu.union(getIndex(row, column), getIndex(row, column + 1));
		}
	}

	public boolean isOpen(int row, int column) {
		return grid[row - 1][column - 1];
	}

	public boolean isFull(int row, int column) {
		return wu.connected(top, getIndex(row, column));
	}

	boolean percolates() {
		return wu.connected(top, bottom);
	}

	private int getIndex(int row, int column) {
		return ((row - 1) * size) + column;
	}
}