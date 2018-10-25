/**
 * @author : Pranay Kumar Y.
 * Date : 25th October,2018.
 */
import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Queue class for list of items.
 *
 * @param      <Item>  The item
 */
class Queue<Item> implements Iterable<Item> {
    /**
     * { variable for beginning of queue }.
     */
    private Node<Item> first;
    /**
     * { variable for end of queue }.
     */
    private Node<Item> last;
    /**
     * { variable for number of elements on queue }.
     */
    private int n;
    /**
     * Class for node.
     * helper linked list class.
     *
     * @param      <Item>  The item
     */
    private static class Node<Item> {
        /**
         * { variable for item }.
         */
        private Item item;
        /**
         * { variable for node next }.
         */
        private Node<Item> next;
    }
    /**
     * Constructs the object.
     * Initializes an empty queue.
     */
    Queue() {
        first = null;
        last  = null;
        n = 0;
    }
    /**
     * Returns true if this queue is empty.
     *
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this queue.
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     * @return     { int value }
     */
    public int size() {
        return n;
    }

    /**
     * { Returns the item least recently added to this queue }.
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     * @return     { the item least recently added to this queue }
     */
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return first.item;
    }

    /**
     * { Adds the item to this queue }.
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     * @param      item  The item
     */
    public void enqueue(final Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        n++;
    }

    /**
     * { Removes and returns the item on this queue
     *   that was least recently added }.
     *
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @return     { the item on this queue that was least recently added }
     * @throws NoSuchElementException if this queue is empty
     */
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    /**
     * Returns a string representation of this queue.
     *
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    /**
     * { Returns an iterator that iterates over the
     *   items in this queue in FIFO order }.
     *
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @return     { an iterator that iterates over the items
     *               in this queue in FIFO order}
     */
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);
    }

    /**
     * Class for list iterator.
     *
     * @param      <Item>  The item
     */
    private class ListIterator<Item> implements Iterator<Item> {
        /**
         * { variable for current node }.
         */
        private Node<Item> current;
        /**
         * Constructs the object.
         *
         * @param      first1  The first
         */
        ListIterator(final Node<Item> first1) {
            current = first1;
        }
        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }
        /**
         * { function for remove }.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * { function for next }.
         *
         * @return     { description_of_the_return_value }
         */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    // /**
    //  * Unit tests the {@code Queue} data type.
    //  *
    //  * @param args the command-line arguments
    //  */
    // public static void main(String[] args) {
    //     Queue<String> queue = new Queue<String>();
    //     while (!StdIn.isEmpty()) {
    //         String item = StdIn.readString();
    //         if (!item.equals("-"))
    //             queue.enqueue(item);
    //         else if (!queue.isEmpty())
    //             StdOut.print(queue.dequeue() + " ");
    //     }
    //     StdOut.println("(" + queue.size() + " left on queue)");
    // }
}

/**
 * Class for separate chaining hash st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class SeparateChainingHashST<Key, Value> {
    /**
     * { variable for capacity }.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * { variable for number of key-value pairs }.
     */
    private int n;
    /**
     * { variable for hash table size }.
     */
    private int m;
    /**
     * { array of linked-list symbol tables }.
     */
    private SequentialSearchST<Key, Value>[] st;

    /**
     * Initializes an empty symbol table.
     */
    SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Constructs the object.
     *
     * @param      m1     { parameter_description }
     */
    SeparateChainingHashST(final int m1) {
        this.m = m1;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m1];
        for (int i = 0; i < m1; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    /**
     * { resize the hash table to have the given number
     *   of chains,rehashing all of the keys}.
     *
     * Complexity :
     *              Best Case : O(N)
     *              Average Case : O(N)
     *              Worst Case : O(N)
     *
     * @param      chains  The chains
     */
    private void resize(final int chains) {
        SeparateChainingHashST<Key, Value> temp = new
        SeparateChainingHashST<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
    }

    /**
     * { hash value between 0 and m-1 }.
     *
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private int hash(final Key key) {
        final int fff = 0x7fffffff;
        return (key.hashCode() & fff) % m;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Determines if empty.
     *
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * { Returns true if this symbol table contains the specified key }.
     *
     * Complexity :
     *              Best Case : O(logN)
     *              Average Case : O(logN)
     *              Worst Case : O(logN)
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to contains() is null");
        }
        return get(key) != null;
    }

    /**
     * { Returns the value associated with the specified
     *   key in this symbol table }.
     *
     *   Complexity :
     *              Best Case : O(logN)
     *              Average Case : O(logN)
     *              Worst Case : O(logN)
     *
     * @param      key   The key
     *
     * @return     { the value associated with in the symbol table }
     */
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to get() is null");
        }
        int i = hash(key);
        return st[i].get(key);
    }

    /**
     * { Inserts the specified key-value pair into the symbol table,
     * overwriting the old value with the new value if the symbol table
     * already contains the specified key. Deletes the specified key
     * (and its associated value) from this symbol table
     * if the specified value is }.
     *
     * Complexity :
     *              Best Case : O(logN)
     *              Average Case : O(logN)
     *              Worst Case : O(logN)
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        final int ten = 10;
        if (key == null) {
            throw new IllegalArgumentException(
                "first argument to put() is null");
        }
        if (val == null) {
            delete(key);
            return;
        }
        // double table size if average length of list >= 10
        if (n >= ten * m) {
            resize(2 * m);
        }
        int i = hash(key);
        if (!st[i].contains(key)) {
            n++;
        }
        st[i].put(key, val);
    }

    /**
     * { Removes the specified key and its associated value
     *   from this symbol table (if the key is in this symbol table) }.
     *
     *   Complexity :
     *              Best Case : O(logN)
     *              Average Case : O(logN)
     *              Worst Case : O(logN)
     *
     * @param      key   The key
     */
    public void delete(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to delete() is null");
        }
        int i = hash(key);
        if (st[i].contains(key)) {
            n--;
        }
        st[i].delete(key);
        // halve table size if average length of list <= 2
        if (m > INIT_CAPACITY && n <= 2 * m) {
            resize(m / 2);
        }
    }

    /**
     * { return keys in symbol table as an Iterable }.
     *
     * Complexity :
     *              Best Case : O(N^2)
     *              Average Case : O(N^2)
     *              Worst Case : O(N^2)
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                queue.enqueue(key);
            }
        }
        return queue;
    }
    // /**
    //  * Unit tests the {@code SeparateChainingHashST} data type.
    //  *
    //  * @param args the command-line arguments
    //  */
    // public static void main(String[] args) {
    //     SeparateChainingHashST<String, Integer> st =
    //     new SeparateChainingHashST<String, Integer>();
    //     for (int i = 0; !StdIn.isEmpty(); i++) {
    //         String key = StdIn.readString();
    //         st.put(key, i);
    //     }

    //     // print keys
    //     for (String s : st.keys())
    //         StdOut.println(s + " " + st.get(s));

    // }

}
/**
 * Class for sequential search st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class SequentialSearchST<Key, Value> {
    /**
     * { variable for number of key-value pairs }.
     */
    private int n;
    /**
     * { the linked list of key-value pairs }.
     */
    private Node first;
    /**
     * Class for node.
     * a helper linked list data type
     */
    private class Node {
        /**
         * { variable for key }.
         */
        private Key key;
        /**
         * { variable for value }.
         */
        private Value val;
        /**
         * { variable for node next }.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      key1   The key
         * @param      val1   The value
         * @param      next1  The next
         */
        Node(final Key key1, final Value val1, final Node next1)  {
            this.key  = key1;
            this.val  = val1;
            this.next = next1;
        }
    }
    /**
     * Constructs the object.
     * Initializes an empty symbol table.
     */
    SequentialSearchST() {
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }
    /**
     * Determines if empty.
     *
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * { returns whether the key is present in the table or not }.
     *
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final Key key) {
        return get(key) != null;
    }

    /**
     * { Returns the value associated with the given key. }.
     *
     * Complexity :
     *              Best Case : O(N)
     *              Average Case : O(N)
     *              Worst Case : O(N)
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Value get(final Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    /**
     * { Inserts the key-value pair into the symbol table,
     *   overwriting the old value
     *   with the new value if the key is already in the symbol table.
     *   If the value is null this effectively deletes the key from
     *   the symbol table }.
     *
     *   Complexity :
     *              Best Case : O(logN)
     *              Average Case : O(logN)
     *              Worst Case : O(logN)
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        if (val == null) {
            delete(key);
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }

    /**
     * { Removes the key and associated value from the symbol table
     *   (if the key is in the symbol table) }.
     *
     *   Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @param      key   The key
     */
    public void delete(final Key key) {
        first = delete(first, key);
    }

    /**
     * { delete key in linked list beginning at Node x }.
     *
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Node delete(final Node x, final Key key) {
        if (x == null) {
            return null;
        }
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    /**
     * { Returns all keys in the symbol table as an.
     *   To iterate over all of the keys in the symbol table named,
     *   use the foreach notation }.
     *
     *   Complexity :
     *              Best Case : O(N)
     *              Average Case : O(N)
     *              Worst Case : O(N)
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }
    // /**
    //  * Unit tests the {@code SequentialSearchST} data type.
    //  *
    //  * @param args the command-line arguments
    //  */
    // public static void main(String[] args) {
    //     SequentialSearchST<String, Integer> st =
    //     new SequentialSearchST<String, Integer>();
    //     for (int i = 0; !StdIn.isEmpty(); i++) {
    //         String key = StdIn.readString();
    //         st.put(key, i);
    //     }
    //     for (String s : st.keys())
    //         StdOut.println(s + " " + st.get(s));
    // }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * { Main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] sizes = scan.nextLine().split(" ");
        SeparateChainingHashST<String, Integer> inputHash =
            new SeparateChainingHashST<>(Integer.parseInt(sizes[0]));
        String[] tokens = scan.nextLine().split(" ");
        for (int i = 0; i < tokens.length; i++) {
            if (inputHash.contains(tokens[i])) {
                inputHash.put(tokens[i], inputHash.get(tokens[i]) + 1);
            } else {
                inputHash.put(tokens[i], 1);
            }
        }
        String[] tokens1 = scan.nextLine().split(" ");
        int count = tokens1.length;
        // System.out.println(count + "before");
        for (int j = 0; j < tokens1.length; j++) {
            if (inputHash.contains(tokens1[j])
                    && inputHash.get(tokens1[j]) > 0) {
                inputHash.put(tokens1[j], inputHash.get(tokens1[j]) - 1);
                count--;
            }
        }
        // System.out.println(count + "after");
        if (count <= 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
