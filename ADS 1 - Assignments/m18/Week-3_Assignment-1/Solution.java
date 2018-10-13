/**
 * @author : Pranay Kumar Y.
 */
import java.util.*;
/**
 * Class for stock data.
 */
class StockData implements Comparable<StockData> {
	/**
	 * { variable for stock name }.
	 */
	private String sname;
	/**
	 * { variable for stock percentage change }.
	 */
	private double schange;
	/**
	 * Constructs the object.
	 *
	 * @param      name    The name
	 * @param      change  The change
	 */
	StockData(final String name, final double change) {
		this.sname = name;
		this.schange = change;
	}
	/**
	 * { gets the name }.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String getsname() {
		return this.sname;
	}
	/**
	 * { gets the change }.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public double getschange() {
		return this.schange;
	}
	/**
	 * { function_description }
	 *
	 * @param      that  The that
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int compareTo(final StockData that) {
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
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() { }
	/**
	 * Main Function
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
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
				if (best.contains(mbest.getsname())) {
					best.put(mbest.getsname(), best.get(mbest.getsname()) + 1);
				} else {
					best.put(mbest.getsname(), 1);
				}
				System.out.println(mbest.getsname() + " " + mbest.getschange());
			}
			System.out.println();
			for (int j = 0; j < 5; j++) {
				StockData mworst = minpq.delMin();
				if (worst.contains(mworst.getsname())) {
					worst.put(mworst.getsname(), worst.get(mworst.getsname()) + 1);
				} else {
					worst.put(mworst.getsname(), 1);
				}
				System.out.println(mworst.getsname() + " " + mworst.getschange());
			}
			System.out.println();
			p++;
		}
		int n1 = Integer.parseInt(scan.nextLine());
		while (n1 > 0) {
			String[] tokens = scan.nextLine().split(",");
			switch (tokens[0]) {
			case "get" :
				if (tokens[1].equals("maxST")) {
					if (best.contains(tokens[2])) {
						System.out.println(best.get(tokens[2]));
					} else {
						System.out.println("0");
					}

				} else {
					if (worst.contains(tokens[2])) {
						System.out.println(worst.get(tokens[2]));
					} else {
						System.out.println("0");
					}
				}

				break;
			case "intersection" :
				int bestSize = best.size();
				int worstSize = worst.size();
				if (worstSize > bestSize) {
					for (String each : worst.keys()) {
						if (best.contains(each)) {
							System.out.println(each);
						}
					}
				} else {
					for (String each : best.keys()) {
						if (worst.contains(each)) {
							System.out.println(each);
						}
					}
				}
				break;
			}
			n1--;
		}
	}
}
