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

	private Node head, tail;

	void push(int n) {
		Node newhead = head;
		while (newhead != null && newhead.next != null) {
			newhead = newhead.next;
		}
		newhead.next = new Node(n);
	}

	int pop() {
		int data = tail.data;
		Node newhead = head;
		while (newhead.next != tail) {
			newhead = newhead.next;
		}
		newhead.next = null;
		return data;
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
		System.out.println(list);
	}
}