/**
 * @author : Pranay Kumar Y.
 * Date : 4th October,2018.
 */
import java.util.Scanner;
/**
 * Class for linkedlist.
 */
class Linkedlist {
	/**
	 * { var for head node }.
	 */
	private Node head = null;
	/**
	 * { var for test node }.
	 */
	private Node test;
	/**
	 * { var for previous node }.
	 */
	private Node prev;
	/**
	 * { var for temp node }.
	 */
	private Node temp;
	/**
	 * { var for size }.
	 */
	private int size = 0;

	/**
	 * Class for node.
	 */
	class Node {
		int nodedata;
		Node next;
		/**
		 * Constructs the object.
		 *
		 * @param      data  The data
		 */
		Node(int data) {
			this.nodedata = data;
		}
	}
	/**
	 * { function for inserting element at specific index }.
	 *
	 * @param      index      The index
	 * @param      inputdata  The inputdata
	 *
	 * @throws     Exception  { exception_description }
	 */
	void insertAt(final int index, final int inputdata) throws Exception {
		int in = index;
		if (in > size || in < 0) {
			throw new Exception("Can't insert at this position.");
			// return;
		}
		if (in == 1) {
			Node newnode = new Node(inputdata);
			newnode.next = test.next;
			test.next = newnode;
			test = head;
			size++;
			return;
		}
		if (in == 0) {
			Node newnode = new Node(inputdata);
			newnode.next = test;
			head = newnode;
			test =  head;
			size++;
			return;
		}
		test = test.next;
		in--;
		insertAt(in, inputdata);
	}
	/**
	 * { function for reverse }.
	 *
	 * @throws     Exception  { exception_description }
	 */
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
	/**
	 * { function for printing }.
	 */
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

/**
 * Class for solution.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//Zero parameter constructor.
	}
	/**
	 * { main function }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
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
