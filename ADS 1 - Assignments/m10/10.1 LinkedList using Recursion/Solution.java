/**
 * @author : Pranay Kumar Y.
 * Date : 4th October,2018.
 */
import java.util.Scanner;
/**
 * Class for linkedlist.
 */
class Linkedlist {
	Node head = null;
	Node test;
	Node prev;
	Node temp;
	int size = 0;
	class Node {
		int nodedata;
		Node next;
		Node(int data) {
			this.nodedata = data;
		}
	}
	void insertAt(int index, int inputdata) throws Exception {
		if (index > size || index < 0) {
			throw new Exception("Can't insert at this position.");
			// return;
		}
		if (index == 1) {
			Node newnode = new Node(inputdata);
			newnode.next = test.next;
			test.next = newnode;
			test = head;
			size++;
			return;
		}
		if (index == 0) {
			Node newnode = new Node(inputdata);
			newnode.next = test;
			head = newnode;
			test =  head;
			size++;
			return;
		}
		test = test.next;
		index--;
		insertAt(index, inputdata);
	}
	void reverse() throws Exception {
		if (size == 0) {
			throw new Exception("No elements to reverse.");
		}
		if (test.next == null) {
			head = test;
			head.next = prev;
			test = head;
			prev = null;
			return;
		}
		temp = test;
		test = test.next;
		temp.next = prev;
		prev = temp;
		reverse();
	}
	void print() {
		String str = "";
		Node newtest = head;
		while (newtest.next != null) {
			str = str + newtest.nodedata + ", ";
			newtest = newtest.next;
		}
		str = str + newtest.nodedata;
		System.out.println(str);
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Linkedlist linked = new Linkedlist();
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
			case "insertAt":
				try {
					linked.insertAt(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
					linked.print();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;
			case "reverse":
				try {
					linked.reverse();
					linked.print();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
			    break;	
			}
		}
	}
}
