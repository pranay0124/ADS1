/**
 * @author : Pranay Kumar Y.
 */
import java.util.*;
/**
 * Class for stock data.
 */
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
/**
 * Class for solution.
 */
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		int p = 0;
		BinarySearchST<String, Integer> best = new  BinarySearchST<>();
		BinarySearchST<String, Integer> worst = new BinarySearchST<>();
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
				// if (best.contains(mbest.getsname())) {
				// 	best.put(mbest.getsname(), mbest.get(mbest.getsname()) + 1);
				// } else {
				// 	best.put(mbest.getsname(), 1);
				// }
				System.out.println(mbest.getsname() + " " + mbest.getschange());
			}
			System.out.println();
			for (int j = 0; j < 5; j++) {
				StockData mworst = minpq.delMin();
				// if (worst.contains(mworst.getsname())) {
				// 	worst.put(mworst.getsname(), mworst.get(mworst.getsname()) + 1);
				// } else {
				// 	worst.put(mworst.getsname(), 1);
				// }
				System.out.println(mworst.getsname() + " " + mworst.getschange());
			}
			System.out.println();
			p++;
		}
		// int n1 = Integer.parseInt(scan.nextLine());
		// while (n1 > 0) {
		// 	String[] tokens = scan.nextLine().split(",");
		// 	switch (tokens[0]) {
		// 	case "get" :
		// 		if (tokens[1].equals("maxST")) {
		// 			if (maxpq.contains(tokens[2])) {
		// 				System.out.println(maxpq.get(tokens[2]));
		// 			} else {
		// 				System.out.println("0");
		// 			}

		// 		} else {
		// 			if (minpq.contains(tokens[2])) {
		// 				System.out.println(minpq.get(tokens[2]));
		// 			} else {
		// 				System.out.println("0");
		// 			}
		// 		}

		// 		break;
		// 	case "intersection" :
		// 		int maxpqSize = maxpq.size();
		// 		int minpqSize = minpq.size();
		// 		if (minpqSize > maxpqSize) {
		// 			for (String each : minpq.keys()) {
		// 				if (maxpq.contains(each)) {
		// 					System.out.println(each);
		// 				}
		// 			}
		// 		} else {
		// 			for (String each : maxpq.keys()) {
		// 				if (minpq.contains(each)) {
		// 					System.out.println(each);
		// 				}
		// 			}
		// 		}
		// 		break;
		// 	}
		// }
	}
}