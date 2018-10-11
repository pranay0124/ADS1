import java.util.*;


class Book {
	String name;
	String author;
	double price;
	Book() { }
	Book(String name, String author, Double price) {
		this.name = name;
		this.author = author;
		this.price = price;
	}
	String getName() {
		return name;
	}
	// public int compareTo(Book other) {
	// 	return this.name.compareTo(other.name);
	// }
}

class BinarySearchTree<Key extends Comparable<Key>, Value> {
	class Node {
		Book key;
		Value value;
		Node left;
		Node right;
		Node(Book key, Value value) {
			this.key = key;
			this.value = value;
		}
	}
	Node root;
	BinarySearchTree() { }
	void put(Book key, Value value) {
		root = put(root, key, value);
	}
	Node put(Node root, Book key, Value value) {
		if (root == null) {
			return new Node(key, value);
		}
		int cmp = key.getName().compareTo(root.key.getName());
		if (cmp > 0) {
			root.right = put(root.right, key, value);
		} else if (cmp < 0) {
			root.left = put(root.left, key, value);
		} else {
			root.value = value;
		}
		return root;
	}
	String get(Book key) {
		Node x = root;
		int cmp = key.getName().compareTo(root.key.getName());
		System.out.println(cmp + "see me");
		if (cmp > 0) {
			root = root.right;
		} else if (cmp < 0) {
			root = root.left;
		} else {
			String str = String.valueOf(root.value);
			return str;
		}
		return null;
	}

}
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BinarySearchTree bt = new BinarySearchTree();
		Book book = new Book();
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(",");
			switch (tokens[0]) {
			case "get" :
				book = new Book(tokens[1], tokens[2], Double.parseDouble(tokens[3]));
				System.out.println(bt.get(book));
				break;
			case "put" :
				book = new Book(tokens[1], tokens[2], Double.parseDouble(tokens[3]));
				bt.put(book, tokens[4]);
				break;
			}
		}
	}
}