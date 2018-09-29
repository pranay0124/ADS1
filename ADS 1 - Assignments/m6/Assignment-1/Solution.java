import java.util.Scanner;
class LinkedList {
    private class Node {
        int data;
        Node next;
        Node() {}
        Node(int data) {
            this(data, null);
        }
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head, tail;

    void addAtHead(int data) {
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;
    }

    public int popAtHead() {
        int data = head.data;
        head = head.next;
        return data;
    }

    public void addAtTail(int data) {
        Node newhead = head;
        while (newhead != null && newhead.next != null) {
            newhead = newhead.next;
        }
        newhead.next = new Node(data);
    }

    public int popAtTail() {
        int data = tail.data;
        Node newhead = head;
        while (newhead.next != tail) {
            newhead = newhead.next;
        }
        newhead.next = null;
        return data;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public int size() {
        int count = 0;
        while (head != tail) {
            count ++;
        }
        return count;
    }
}


class AddLargeNumbers {
    static LinkedList l1 = new LinkedList();

    public static LinkedList numberToDigits(String number) {
        String[] digits = number.split("");
        for (int i = 0; i < digits.length; i++) {
            l1.addAtTail(Integer.parseInt(digits[i]));
        }
        return l1;
    }

    public static String digitsToNumber(LinkedList list) {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            int temp = list.popAtTail();
            str = str + Integer.toString(temp);
        }
        return str;
    }

    // public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {

    // }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        LinkedList l1 = new LinkedList();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

            // case "addLargeNumbers":
            //     pDigits = AddLargeNumbers.numberToDigits(p);
            //     qDigits = AddLargeNumbers.numberToDigits(q);
            //     LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            //     System.out.println(AddLargeNumbers.digitsToNumber(result));
            //     break;
        }
    }

}
