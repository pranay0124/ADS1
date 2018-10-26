import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		LinearProbingHashST<String, Integer> hashTable = new LinearProbingHashST<>();
		while(scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			switch (tokens[0]) {
			case "put":
				hashTable.put(tokens[1], Integer.parseInt(tokens[2]));
				break;
			case "get":
				System.out.println(hashTable.get(tokens[1]));
				break;
			case "delete":
				hashTable.delete(tokens[1]);
				break;
			case "display":
				hashTable.display();
				break;
			default:
				break;
			}
		}
	}
}
