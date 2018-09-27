import java.util.Scanner;
// import java.util.LinkedList;
class LinkedList {
	class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
		}
	}

	private Node first = null;

	void push(int n) {
		Node newnode = new Node(n);
		newnode.next = first;
		first = newnode;
	}

	int pop() {
		int item = first.data;
		first = first.next;
		return item;
	}

	void printList() {
		Node newnode = first;
		while(newnode != null) {
			System.out.println(newnode.data + " ");
			newnode = newnode.next;
		}
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] tokens = scan.nextLine().split(" ");
		LinkedList list = new LinkedList();
		for (int i = 0; i < tokens.length; i++) {
			if (!("+*-/").contains(tokens[i])) {
				list.push(Integer.parseInt(tokens[i]));
			} else {
				switch (tokens[i]) {
				case "+" :
					int a = list.pop();
					int b = list.pop();
					list.push(a + b);
					break;

				case "-" :
					a = list.pop();
					b = list.pop();
					list.push(a - b);
					break;

				case "*" :
					a = list.pop();
					b = list.pop();
					list.push(a * b);
					break;

				case "/" :
					a = list.pop();
					b = list.pop();
					list.push(a / b);
					break;
				}
			}
		}
		list.printList();
	}
}