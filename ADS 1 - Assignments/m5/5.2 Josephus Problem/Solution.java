import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String testcases = scan.nextLine();
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			int person = Integer.parseInt(tokens[0]);
			int gap = Integer.parseInt(tokens[1]);
			Deque<Integer> queue = new Deque<>();
			createCircle(queue, person);
			queue.josephus(person, gap);
		}
	}
	public static void createCircle(Deque<Integer> queue, int person) {
		for (int i = 0; i < person; i++) {
			queue.push(i);
		}
	}
}
