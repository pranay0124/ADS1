import java.util.*;
class Stock implements Comparable<Stock> {
	private String stockname;
	private float stockchange;
	Stock(String name, float change) {
		this.stockname = name;
		this.stockchange = change;
	}
	public String getstockname() {
		return this.stockname;
	}
	public float getstockchange() {
		return this.stockchange;
	}
	public int compareTo(Stock other) {
		if (this.stockchange > other.stockchange) {
			return 1;
		}
		if (this.stockchange < other.stockchange) {
			return -1;
		}
		if (this.stockname.compareTo(other.stockname) > 0) {
			return 1;
		}
		if (this.stockname.compareTo(other.stockname) < 0) {
			return -1;
		}
		return 0;
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		int p = 0;
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
			for (StockData s1 : minpq) {
				System.out.println(s1);
				System.out.println("---------------");
			}
			for (StockData s2 : maxpq) {
				System.out.println(s2);
				System.out.println("---------------");
			}

			p++;
		}

	}
}