import java.util.Scanner;
import java.util.LinkedList;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] tokens = scan.nextLine().split(" ");
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < tokens.length; i++) {
			if (!("+*-/").contains(tokens[i])) {
				list.add(Integer.parseInt(tokens[i]));
			} else {
				switch (tokens[i]) {
				case "+" :
					int a = list.remove();
					int b = list.remove();
					list.add(a + b);
					break;

				case "-" :
					a = list.remove();
					b = list.remove();
					list.add(a - b);
					break;

				case "*" :
					a = list.remove();
					b = list.remove();
					list.add(a * b);
					break;

				case "/" :
					a = list.remove();
					b = list.remove();
					list.add(a / b);
					break;
				}
			}
			System.out.println(list.get(0));
		}
	}
}