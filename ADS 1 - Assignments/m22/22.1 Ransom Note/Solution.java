import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] sizes = scan.nextLine().split(" ");
		SeparateChainingHashST<String, Integer> inputHash = new SeparateChainingHashST<>(Integer.parseInt(sizes[0]));
		String[] tokens = scan.nextLine().split(" ");
		for (int i = 0; i < tokens.length; i++) {
			if (inputHash.contains(tokens[i])) {
				inputHash.put(tokens[i], inputHash.get(tokens[i]) + 1);
			} else {
				inputHash.put(tokens[i], 1);
			}
		}
		String[] tokens1 = scan.nextLine().split(" ");
		int count = tokens1.length;
		// System.out.println(count + "before");
		for (int j = 0; j < tokens1.length; j++) {
			if (inputHash.contains(tokens1[j])) {
				inputHash.delete(tokens1[j]);
				count--;
			}
		}
		// System.out.println(count + "after");
		if (count <= 0) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}