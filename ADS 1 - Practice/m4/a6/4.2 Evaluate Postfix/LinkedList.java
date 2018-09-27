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
