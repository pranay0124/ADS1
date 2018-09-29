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