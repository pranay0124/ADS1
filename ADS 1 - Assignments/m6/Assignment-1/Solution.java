import java.util.Scanner;
class LinkedList {
    Node first = null;
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
        if (size == 0) {
            return true;
        }
        return false;
    }
    void push(int item) {
        Node tnode = new Node(item);
        tnode.next = first;
        first = tnode;
        size++;
    }
    int pop() {
        int tdata = first.data;
        first = first.next;
        size--;
        return tdata;
    }
    int insertafter(int value) {
        Node tnode = first;
        int counter = 0;
        while (counter < value - 1) {
            tnode = tnode.next;
            counter++;
        }
        int value1 = tnode.data;
        size--;
        return value1;
    }
    String print() {
        Node tnode = first;
        String num = "";
        while (tnode != null) {
            num = num + tnode.data;
            tnode = tnode.next;
        }
        return num;
    }
    int size() {
        return this.size;
    }
}

class AddLargeNumbers {
    static LinkedList l1;
    static LinkedList fl;

    public static LinkedList numberToDigits(String number) {
        l1 = new LinkedList();
        for (int i = number.length() - 1; i >= 0 ; i--) {
            String digit = "" + number.charAt(i);
            l1.push(Integer.parseInt(digit));
        }
        // l1.print();
        return l1;
    }

    public static String digitsToNumber(LinkedList list) {
        return list.print();
        // System.out.println("Present out");
        // String str = "";
        // for (int i = 0; i < list.size(); i++) {
        //     System.out.println("Present in");
        //     // System.out.println(temp);
        //     str = str + Integer.toString(list.pop());
        // }
        // return str;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        fl = new LinkedList();
        // for (int i = 0; i < list1.size(); i++) {
        //     int a = list1.pop() + list2.pop();
        //     fl.push(a);
        // }
        // return fl;
        int place = 0;
        String result = "";
        while (!list1.isEmpty()) {
            place = list1.insertafter(list1.size) + list2.insertafter(list2.size);
            result =  (place % 10) + result;
            if (place > 9) {
                fl.push(place / 10);
            } else {
                fl.push(0);
            }
        }
        while (!list2.isEmpty()) {
            result =  list2.insertafter(list2.size) + fl.pop() + result;
            fl.push(0);
        }
        if (fl.first.data != 0) {
            result = fl.pop() + result;
        }
        return numberToDigits(result);
    }
}


public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        }
    }

}


