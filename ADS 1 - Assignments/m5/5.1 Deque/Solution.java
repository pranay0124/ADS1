import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Deque<Integer> queue = new Deque<>();
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			switch (tokens[0]) {
			case "pushRight":
				queue.pushRight(Integer.parseInt(tokens[1]));
				break;
			case "pushLeft":
				queue.pushLeft(Integer.parseInt(tokens[1]));
				break;
			case "popRight":
				queue.popRight();
				break;
			case "popLeft":
				queue.popLeft();
				break;
			case "size":
				System.out.println(queue.getSize());
				break;
			default :
			}
		}

	}
}
