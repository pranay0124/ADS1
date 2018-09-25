// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = Integer.parseInt(scan.nextLine());
		Percolation p = new Percolation(size);
		while (scan.hasNext()) {
			p.open(scan.nextInt(), scan.nextInt());
		}
		System.out.println(p.percolates());
	}
}

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