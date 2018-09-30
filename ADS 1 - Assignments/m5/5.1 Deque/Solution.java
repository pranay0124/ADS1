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
				// case "pushLeft":
				// queue.pushLeft(Integer.parseInt(tokens[1]));
				// break;
			// case "popRight":
			// 	queue.popRight();
			// 	break;
			// case "popLeft":
			// 	queue.popLeft();
			// 	break;
			case "size":
				System.out.println(queue.getSize());
				break;
			default :
			}
		}

	}
}
class Deque<Item> {
	Node first = null;
	Node last = null;
	int size = 0;
	class Node {
		Item data;
		Node next;
		Node(Item data) {
			this.data = data;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	public void pushRight(Item element) {
		Node oldleft = last;
		last = new Node(element);
		if (isEmpty()) {
			first = last;
			last.next = null;
			size++;
			printList();
			return;
		}
		last.next = null;
		oldleft.next = last;
		size++;
		printList();
	}

	public void printList() {
		if (size == 0) {
			System.out.println("[]");
			return;
		}
		Node tnode = first;
		String s = "";
		while (tnode != null) {
			s += tnode.data + ",";
			tnode = tnode.next;
		}
		String[] str = s.split(",");
		String pr = "[";
		for(int i = 0;i<size-1;i++) {
			pr += str[i] + ", ";
		}
		pr += str[size-1] + "]";
		System.out.println(pr);
	}
}