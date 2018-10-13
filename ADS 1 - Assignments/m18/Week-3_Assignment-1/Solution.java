import java.util.*;
class StockData implements Comparable<StockData> {
	private String sname;
	private double schange;
	StockData(String name, double change) {
		this.sname = name;
		this.schange = change;
	}
	public String getsname() {
		return this.sname;
	}
	public double getschange() {
		return this.schange;
	}
	public int compareTo(StockData that) {
		if (this.schange < that.schange) return -1;
		if (this.schange > that.schange) return 1;
		if (this.sname.compareTo(that.sname) > 0) return 1;
		if (this.sname.compareTo(that.sname) < 0) return -1;
		return 0;
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
			int count = n;
			MinPQ<StockData> minpq = new MinPQ<>();
			MaxPQ<StockData> maxpq = new MaxPQ<>();
			while (count > 0) {
				String[] tokens = scan.nextLine().split(",");
				StockData stockobj = new StockData(tokens[0], Double.parseDouble(tokens[1]));
				minpq.insert(stockobj);
				maxpq.insert(stockobj);
				count--;
			}

			for (int i = 0; i < 5; i++) {
				StockData mbest = maxpq.delMax();
				// if(best.contains(mbest.getsname())) {
				// 	best.put(mbest.getsname(), mbest.get(mbest.getsname()) + 1);
				// } else {
				// 	best.put(mbest.getsname(), 1);
				// }
				System.out.println(mbest.getsname() + " " + mbest.getschange());
			}
			System.out.println();
			for (int j = 0; j < 5; j++) {
				StockData mworst = minpq.delMin();
				// if(worst.contains(mworst.getsname())) {
				// 	worst.put(mworst.getsname(), mworst.get(mworst.getsname()) + 1);
				// } else {
				// 	worst.put(mworst.getsname(), 1);
				// }
				System.out.println(mworst.getsname() + " " + mworst.getschange());
			}
			System.out.println();
			p++;
		}

	}
}