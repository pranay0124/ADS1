class Deque<Item> {
	Node first = null;
	Node last = null;
	int size = 0;
	String print = "";
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
	public void push(Item element) {
		Node oldleft = last;
		last = new Node(element);
		if (isEmpty()) {
			first = last;
			last.next = first;
			size++;
			return;
		}
		last.next = first;
		oldleft.next = last;
		size++;
	}
	public Item pop(Item person) {
		Item d = first.data;
		if (isEmpty()) {
			return null;
		}
		int s = 0;
		Node get = first;
		Node prev = null;
		while (s < size) {
			if (get.data == person) {
				if (first.data == person) {
					first = first.next;
					int g = 0;
					Node l = first;
					while (g < size - 2) {
						l = l.next;
						g++;
					}
					last = l;
					last.next = first;
				} else {
					prev.next = get.next;
				}

				size--;
				break;
			}
			prev = get;
			get = get.next;
			s++;
		}
		return d;
	}
	public void josephus(int person, int gap) {
		Node head = first;
		while (!isEmpty()) {
			int c = 0;
			while (c < gap - 1) {
				head = head.next;
				c++;
			}
			print += head.data+" ";
			pop(head.data);
			head = head.next;
		}
		print = print.trim();
		System.out.println(print);
	}
	public void printList() {
		Node n = first;
		Node tnode = first.next;
		String s = "";
		s += n.data + " ";
		while (tnode != first) {
			s += tnode.data + " ";
			tnode = tnode.next;
		}
		s = s.trim();
		System.out.println(s);
	}
}