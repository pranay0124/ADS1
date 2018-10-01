import java.util.Scanner;
class Steque {
	Node head = null;
	Node tail = null;
	int size = 0;
	class Node {
		int data;
		Node next;
		Node() {}
		Node(int data) {
			this.data = data;
		}
	}
	boolean isEmpty() {
		return size == 0;
	}
	int getsize() {
		return size;
	}
	/**/
	void pushLeft(int element) {
		Node oldright = head;
		head = new Node(element);
		if (isEmpty()) {
			tail = head;
			size++;
			printList();
			return;
		}
		head.next = oldright;
		size++;
		printList();
	}
	/**/
	int popLeft() {
		if (size == 0) {
			System.out.println("Steque is empty.");
			return -1;
		}
		int removedData = head.data;
		if (isEmpty()) {
			return -1;
		}
		head = head.next;
		size--;
		printList();
		return removedData;
	}
	/**/
	void pushRight(int element) {
		Node oldtail = tail;
		tail = new Node(element);
		if (isEmpty()) {
			head = tail;
			tail.next = null;
			size++;
			printList();
			return;
		}
		tail.next = null;
		oldtail.next = tail;
		size++;
		printList();
	}
	/**/
	void printList() {
		Node tnode = head;
		String str = "";
		while (tnode != null) {
			str += tnode.data + ",";
			tnode = tnode.next;
		}
		String[] s = str.split(",");
		String finalstr = "";
		for (int i = 0; i < size - 1; i++) {
			finalstr += s[i] + ", ";
		}
		finalstr += s[size];
		System.out.println(finalstr);
	}
}

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcases = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < testcases; i++) {
			Steque queue = new Steque();
			while (scan.hasNext()) {
				String line = scan.nextLine();
				if (!line.isEmpty()) {
					String[] tokens = line.split(" ");
					switch (tokens[0]) {
					case "push":
						queue.pushLeft(Integer.parseInt(tokens[1]));
						break;
					case "pop":
						queue.popLeft();
						break;
					case "enqueue":
						queue.pushRight(Integer.parseInt(tokens[1]));
						break;
					default:
					}
				} else {
					System.out.println();
					break;
				}

			}
		}
	}
}