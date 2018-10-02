/**
 * @author : Pranay Kumar Y.
 * Date : 2nd October,2018.
 */
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for insertion sort.
 */
class InsertionSort {
	/**
	 * { Function which gives the greater boolean }.
	 *
	 * Complexity :
	 * 				Best Case : O(1)
	 * 				Average Case : O(1)
	 * 				Worst Case : O(1)
	 *
	 * @param      u     { parameter_description }
	 * @param      v     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	boolean greater(final TeamData u, final TeamData v) {
		return u.compareTo(v) == 1;
	}

	/**
	 * { function for exchange }.
	 *
	 *Complexity :
	 *				Best Case : O(1)
	 * 				Average Case : O(1)
	 * 				Worst Case : O(1)
	 * @param      a     { parameter_description }
	 * @param      i     { parameter_description }
	 * @param      j     { parameter_description }
	 */
	void exch(final TeamData[] a, final int i, final int j) {
		TeamData temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}

	/**
	 * { function for sorting elements }.
	 * { here we used Insertion sorting method }.
	 *
	 * Complexity :
	 * 				Best Case : O(n)
	 * 				Average Case : O(n^2)
	 * 				Worst Case : O(n^2)
	 * @param      array  The array
	 */
	void sort(final TeamData[] array) {
		int n = array.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0; j--) {
				if (greater(array[j], array[j - 1])) {
					exch(array, j, j - 1);
				} else {
					break;
				}
			}
		}
		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i].getTeamname() + ",");
		}
		System.out.print(array[array.length - 1].getTeamname());
	}
}


/**
 * Class for team data.
 */
class TeamData implements Comparable<TeamData> {
	private String teamname;
	private int wins;
	private int losses;
	private int draws;
	/**
	 * Constructs the object.
	 *
	 * @param      teamname  The teamname
	 * @param      wins      The wins
	 * @param      losses    The losses
	 * @param      draws     The draws
	 */
	TeamData(String name, int win, int loss, int draw) {
		this.teamname = name;
		this.wins = win;
		this.losses = loss;
		this.draws = draw;
	}
	/**
	 * Gets the teamname.
	 *
	 * @return     The teamname.
	 */
	public String getTeamname() {
		return teamname;
	}
	// public int getWins() {
	// 	return wins;
	// }
	// public int getLosses() {
	// 	return losses;
	// }
	// public int getDraws() {
	// 	return draws;
	// }

	/**
	 * { function for comparing }
	 *
	 * @param      that  The that
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int compareTo(final TeamData that) {
		if (this.wins > that.wins) {
			return 1;
		}
		if (this.wins < that.wins) {
			return -1;
		}
		if (this.losses > that.losses) {
			return -1;
		}
		if (this.losses < that.losses) {
			return 1;
		}
		if (this.draws > that.draws) {
			return 1;
		}
		if (this.draws < that.draws) {
			return -1;
		}
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
	private Solution() {
		//Zero Parameter Constructor
	}
	/**
	 * { Main Function }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		TeamData[] data = new TeamData[10];
		int count = 0;
		InsertionSort sortobj = new InsertionSort();
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			TeamData team = new TeamData(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[2 + 1]));
			data[count] = team;
			count++;
		}
		data = Arrays.copyOf(data, count);
		sortobj.sort(data);
	}
}
