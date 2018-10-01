/**
 * @author : Pranay Kumar Y.
 * date : 1st October,2018.
 */
import java.util.Scanner;
/**
 * Class for steque.
 */
final class Steque {
    /**
     * { starting node of list }.
     */
    private Node head = null;
    /**
     * { ending node of list }.
     */
    private Node tail = null;
    /**
     * { size of the list }.
     */
    private int size = 0;

    /**
     * Class for node.
     */
    class Node {
        /**
         * { variable to access data }.
         */
        private int data;
        /**
         * { vaiable for accessing next node }.
         */
        private Node next;
        /**
         * No Parameter Constructor.
         */
        Node() { }
        /**
         * Constructs the object.
         *
         * @param      data  The data
         */
        Node(final int nodedata) {
            this.data = nodedata;
        }
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Gives the size of list.
     *
     * @return     { description_of_the_return_value }
     */
    public int getsize() {
        return size;
    }
    /**
     * Adds the element to the left of the list.
     *
     * @param      element  The element
     */
    public void push(int element) {
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
    /**
     * Removes the element from the left of the list.
     *
     * @return     { description_of_the_return_value }
     */
    public int pop() {
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
    /**
     * Adds the element to the right of the list.
     *
     * @param      element  The element
     */
    public void enqueue(int element) {
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
    /**
     * Function to print the list.
     */
    public void printList() {
        if (size == 0) {
            System.out.println("Steque is empty.");
            return;
        }
        Node tnode = head;
        String s = "";
        while (tnode != null) {
            s += tnode.data + ",";
            tnode = tnode.next;
        }
        String[] str = s.split(",");
        String pr = "";
        for (int i = 0; i < size - 1; i++) {
            pr += str[i] + ", ";
        }
        pr += str[size - 1];
        System.out.println(pr);
    }
}

/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Zero Parameter Constructor.
    }
    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
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
                        queue.push(Integer.parseInt(tokens[1]));
                        break;
                    case "pop":
                        queue.pop();
                        break;
                    case "enqueue":
                        queue.enqueue(Integer.parseInt(tokens[1]));
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