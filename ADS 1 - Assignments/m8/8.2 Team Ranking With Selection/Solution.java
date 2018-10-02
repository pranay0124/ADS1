import java.util.*;
class SelectionSort {
	boolean greater(TeamData u, TeamData v) {
		return u.compareTo(v) == 1;
	}

	void exch(TeamData[] a, int i, int j) {
		TeamData temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}

	void Sort(TeamData[] array) {
		int n = array.length;
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (greater(array[j], array[min])) {
					min = j;
				}
			}
			exch(array, i, min);
		}
		for (int i = 0; i < array.length - 1; i++) {
			System.out.println(array[i].teamname + ",");
		}
		System.out.println(array[array.length - 1].teamname);
	}
}

class TeamData implements Comparable<TeamData> {
	String teamname;
	int wins;
	int losses;
	int draws;
	TeamData(String teamname, int wins, int losses, int draws) {
		this.teamname = teamname;
		this.wins = wins;
		this.losses = losses;
		this.draws = draws;
	}
	// public String getTeamname() {
	// 	return teamname;
	// }
	// public int getWins() {
	// 	return wins;
	// }
	// public int getLosses() {
	// 	return losses;
	// }
	// public int getDraws() {
	// 	return draws;
	// }
	public int compareTo(TeamData that) {
		if (this.wins > that.wins) return 1;
		if (this.wins < that.wins) return -1;
		if (this.losses > that.losses) return -1;
		if (this.losses < that.losses) return 1;
		if (this.draws > that.draws) return 1;
		if (this.draws < that.draws) return -1;
		return 0;
	}
}

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TeamData[] data = new TeamData[10];
		int count = 0;
		SelectionSort sortobj = new SelectionSort();
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			TeamData team = new TeamData(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[2 + 1]));
			data[count] = team;
			count++;
		}
		data = Arrays.copyOf(data, count);
		sortobj.Sort(data);
	}
}
