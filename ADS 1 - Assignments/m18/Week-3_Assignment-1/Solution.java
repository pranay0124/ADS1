import java.util.*;
class StockData implements Comparable<StockData> {
	private String sname;
	private float schange;
	StockData(String name, float change) {
		this.sname = name;
		this.schange = change;
	}
	public String getsname() {
		return this.sname;
	}
	public float getschange() {
		return this.schange;
	}
	public int compareTo(StockData other) {
		if (this.schange > other.schange) {
			return 1;
		}
		if (this.schange < other.schange) {
			return -1;
		}
		if (this.sname.compareTo(other.sname) > 0) {
			return 1;
		}
		if (this.sname.compareTo(other.sname) < 0) {
			return -1;
		}
		return 0;
	}
	public String toString() {
		String str = "";
		str = str + this.sname + " " + this.schange;
		return str;
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		int p = 0;
		BinarySearchST<String, Float> best = new  BinarySearchST<>();
		BinarySearchST<String, Float> worst = new BinarySearchST<>();
		while (p < 6) {
			int count = 0;
			MinPQ<StockData> minpq = new MinPQ<>();
			MaxPQ<StockData> maxpq = new MaxPQ<>();
			while (count < n) {
				String[] tokens = scan.nextLine().split(",");
				StockData stockobj = new StockData(tokens[0], Float.parseFloat(tokens[1]));
				minpq.insert(stockobj);
				maxpq.insert(stockobj);
				count++;
			}

			for (int i = 0; i < 5; i++) {
				StockData maxbest = maxpq.delMax();
				System.out.println(maxbest);
				best.put(maxbest.getsname(), maxbest.getschange());
			}
			for (int j = 0; j < 5; j++) {
				StockData minworst = minpq.delMin();
				System.out.println(minworst);
				worst.put(minworst.getsname(), minworst.getschange());
			}
			p++;
		}

	}
}