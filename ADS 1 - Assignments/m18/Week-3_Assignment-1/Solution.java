import java.util.*;
class StockData implements Comparable<StockData> {
	private String stockname;
	private double stockchange;
	StockData(String name, double change) {
		this.stockname = name;
		this.stockchange = change;
	}
	public String getstockname() {
		return this.stockname;
	}
	public double getstockchange() {
		return this.stockchange;
	}
	public int compareTo(StockData other) {
		if (this.stockchange > other.stockchange) {
			return 1;
		}
		if (this.stockchange < other.stockchange) {
			return -1;
		}
		return 0;
	}
	public String toString() {
		String str = "";
		str = str + this.stockname + this.stockchange;
		return str;
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int p = 0;
		while (p < 6) {
			int count = 0;
			MinPQ<StockData> minpq = new MinPQ<>();
			MaxPQ<StockData> maxpq = new MaxPQ<>();
			System.out.println("minpq" + "maxpq");
			while (count < n) {
				String[] tokens = scan.nextLine().split(",");
				StockData stockobj = new StockData(tokens[0], Double.parseDouble(tokens[1]));
				minpq.insert(stockobj);
				maxpq.insert(stockobj);
				count++;
			}
			for (StockData s1 : minpq) {
				System.out.println(s1 + "minpq");
			}
			for (StockData s2 : maxpq) {
				System.out.println(s2 + "maxpq");
			}

			p++;
		}

	}
}