/**
 * @author : Pranay Kumar Y.
 * Date : 27th October,2018.
 */
import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for solution.
 */
public final class Solution {
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
        int input1 = Integer.parseInt(scan.nextLine());
        RedBlackBST<StudentDetails, Integer> bst = new RedBlackBST<>();
        StudentDetails student = null;
        while (input1 > 0) {
            String[] tokens1 = scan.nextLine().split(",");
            student = new StudentDetails(tokens1[1],
                                         tokens1[2], tokens1[0]);
            bst.put(student, Integer.parseInt(tokens1[0]));
            input1--;
        }
        int input2 = Integer.parseInt(scan.nextLine());
        while (input2 > 0) {
            String[] tokens2 = scan.nextLine().split(" ");
            switch (tokens2[0]) {
            case "BE":
                double min = Double.parseDouble(tokens2[1]);
                double max = Double.parseDouble(tokens2[2]);
                for (StudentDetails each : bst.keys()) {
                    if (each.getMarks() >= min && each.getMarks() <= max) {
                        System.out.println(each.getName());
                    }
                }
                break;
            case "LE":
                double low = Double.parseDouble(tokens2[1]);
                for (StudentDetails each : bst.keys()) {
                    if (each.getMarks() <= low) {
                        System.out.println(each.getName());
                    }
                }
                break;
            case "GE":
                double high = Double.parseDouble(tokens2[1]);
                for (StudentDetails each : bst.keys()) {
                    if (each.getMarks() >= high) {
                        System.out.println(each.getName());
                    }
                }
                break;
            default:
                break;
            }
            input2--;
        }
    }
}

/**
 * Class for student details.
 */
class StudentDetails implements Comparable<StudentDetails> {
    /**
     * { variable for student name }.
     */
    private String name;
    /**
     * { variable for student marks }.
     */
    private double marks;
    /**
     * { variable for student rollnumber }.
     */
    private int rollnumber;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     * @param      m     { parameter_description }
     * @param      o     { parameter_description }
     */
    StudentDetails(final String n, final String m, final String o) {
        this.name  = n;
        this.marks = Double.parseDouble(m);
        this.rollnumber = Integer.parseInt(o);
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the marks.
     *
     * @return     The marks.
     */
    public double getMarks() {
        return marks;
    }
    /**
     * Gets the rollnumber.
     *
     * @return     The rollnumber.
     */
    public int getRollnumber() {
        return rollnumber;
    }
    /**
     * { CompareTo function }.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final StudentDetails that) {
        if (this.marks > that.marks) {
            return 1;
        }
        if (this.marks < that.marks) {
            return -1;
        }
        if (this.rollnumber > that.rollnumber) {
            return 1;
        }
        if (this.rollnumber < that.rollnumber) {
            return -1;
        }
        if (this.name.compareTo(that.name) > 0) {
            return 1;
        }
        if (this.name.compareTo(that.name) < 0) {
            return -1;
        }
        return 0;
    }
}

/**
 * Class for red black bst.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class RedBlackBST<Key extends Comparable<Key>, Value> {
    /**
     * { variable for colour red }.
     */
    private static final boolean RED   = true;
    /**
     * { variable for colour black }.
     */
    private static final boolean BLACK = false;
    /**
     * { root of the BST }.
     */
    private Node root;
    /**
     * Class for node.
     * BST helper node data type
     */
    private class Node {
        /**
         * { variable for key }.
         */
        private Key key;
        /**
         * { associated data }.
         */
        private Value val;
        /**
         * { links to left and right subtrees }.
         */
        private Node left, right;
        /**
         * { color of parent link }.
         */
        private boolean color;
        /**
         * { subtree count }.
         */
        private int size;
        /**
         * Constructs the object.
         *
         * @param      key1    The key
         * @param      val1    The value
         * @param      color1  The color
         * @param      size1   The size
         */
        Node(final Key key1, final Value val1,
             final boolean color1, final int size1) {
            this.key = key1;
            this.val = val1;
            this.color = color1;
            this.size = size1;
        }
    }
    /**
     * Initializes an empty symbol table.
     */
    RedBlackBST() {
    }
    /**
     * Determines if red.
     *
     * @param      x     { parameter_description }
     *
     * @return     True if red, False otherwise.
     */
    private boolean isRed(final Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    /**
     * { number of node in subtree rooted at x; 0 if x is null }.
     *
     * @param      x1     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private int size(final Node x1) {
        Node x = x1;
        if (x == null) {
            return 0;
        }
        return x.size;
    }

    /**
     * { Returns the number of key-value pairs in this symbol table }.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size(root);
    }

    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * { Returns the value associated with the given key }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to get() is null");
        }
        return get(root, key);
    }

    /**
     * { value associated with the given key in
     *   subtree rooted at x; null if no such key }.
     *
     * @param      x1     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Value get(final Node x1, final Key key) {
        Node x = x1;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.val;
            }
        }
        return null;
    }

    /**
     * { Does this symbol table contain the given key }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final Key key) {
        return get(key) != null;
    }

    /**
     * { Inserts the specified key-value pair into the symbol table,
     *   overwriting the old value with the new value if the symbol
     *   table already contains the specified key. Deletes the specified key
     *   (and its associated value) from this symbol table
     *   if the specified value is null }.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        if (key == null) {
            throw new IllegalArgumentException(
                "first argument to put() is null");
        }
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
        root.color = BLACK;
        // assert check();
    }

    /**
     * { insert the key-value pair in the subtree rooted at h }.
     *
     * @param      h1     { parameter_description }
     * @param      key   The key
     * @param      val   The value
     *
     * @return     { description_of_the_return_value }
     */
    private Node put(final Node h1, final Key key, final Value val) {
        Node h = h1;
        if (h == null) {
            return new Node(key, val, RED, 1);
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left  = put(h.left,  key, val);
        } else if (cmp > 0) {
            h.right = put(h.right, key, val);
        } else {
            h.val   = val;
        }

        // fix-up any right-leaning links
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left)  &&  isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left)  &&  isRed(h.right)) {
            flipColors(h);
        }
        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }

    /**
     * { Removes the smallest key and associated value
     *   from the symbol table }.
     */
    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("BST underflow");
        }

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }

        root = deleteMin(root);
        if (!isEmpty()) {
            root.color = BLACK;
        }
        // assert check();
    }

    /**
     * { delete the key-value pair with the minimum key rooted at h }.
     *
     * @param      h1     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node deleteMin(final Node h1) {
        Node h = h1;
        if (h.left == null) {
            return null;
        }

        if (!isRed(h.left) && !isRed(h.left.left)) {
            h = moveRedLeft(h);
        }

        h.left = deleteMin(h.left);
        return balance(h);
    }

    /**
     * { Removes the largest key and associated value from the symbol table }.
     */
    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("BST underflow");
        }

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }

        root = deleteMax(root);
        if (!isEmpty())  {
            root.color = BLACK;
        }
        // assert check();
    }

    /**
     * { delete the key-value pair with the maximum key rooted at h }.
     *
     * @param      h1     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node deleteMax(final Node h1) {
        Node h = h1;
        if (isRed(h.left)) {
            h = rotateRight(h);
        }

        if (h.right == null) {
            return null;
        }

        if (!isRed(h.right) && !isRed(h.right.left)) {
            h = moveRedRight(h);
        }

        h.right = deleteMax(h.right);

        return balance(h);
    }

    /**
     * { Removes the specified key and its associated
     *   value from this symbol table }.
     *
     * @param      key   The key
     */
    public void delete(final Key key) {
        if (key == null)  {
            throw new IllegalArgumentException(
                "argument to delete() is null");
        }
        if (!contains(key))  {
            return;
        }

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }

        root = delete(root, key);
        if (!isEmpty())  {
            root.color = BLACK;
        }
        // assert check();
    }

    /**
     * { delete the key-value pair with the given key rooted at h }.
     *
     * @param      h1     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Node delete(final Node h1, final Key key) {
        // assert get(h, key) != null;
        Node h = h1;

        if (key.compareTo(h.key) < 0)  {
            if (!isRed(h.left) && !isRed(h.left.left)) {
                h = moveRedLeft(h);
            }
            h.left = delete(h.left, key);
        } else {
            if (isRed(h.left)) {
                h = rotateRight(h);
            }
            if (key.compareTo(h.key) == 0 && (h.right == null)) {
                return null;
            }
            if (!isRed(h.right) && !isRed(h.right.left)) {
                h = moveRedRight(h);
            }
            if (key.compareTo(h.key) == 0) {
                Node x = min(h.right);
                h.key = x.key;
                h.val = x.val;
                // h.val = get(h.right, min(h.right).key);
                // h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            } else {
                h.right = delete(h.right, key);
            }
        }
        return balance(h);
    }

    /**
     * { make a left-leaning link lean to the right }.
     *
     * @param      h1     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node rotateRight(final Node h1) {
        // assert (h != null) && isRed(h.left);
        Node h = h1;
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    /**
     * { make a right-leaning link lean to the left }.
     *
     * @param      h1     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node rotateLeft(final Node h1) {
        // assert (h != null) && isRed(h.right);
        Node h = h1;
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    /**
     * { flip the colors of a node and its two children }.
     *
     * @param      h1     { parameter_description }
     */
    private void flipColors(final Node h1) {
        // h must have opposite color of its two children
        // assert (h != null) && (h.left != null) && (h.right != null);
        // assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
        //    || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
        Node h = h1;
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    /**
     * { Assuming that h is red and both h.left and h.left.left
     *   are black, make h.left or one of its children red }.
     *
     * @param      h1     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node moveRedLeft(final Node h1) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.left) && !isRed(h.left.left);
        Node h = h1;
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }

    /**
     * { Assuming that h is red and both h.right and h.right.left
     *   are black, make h.right or one of its children red }.
     *
     * @param      h1     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node moveRedRight(final Node h1) {
        Node h = h1;
        // assert (h != null);
        // assert isRed(h) && !isRed(h.right) && !isRed(h.right.left);
        flipColors(h);
        if (isRed(h.left.left)) {
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }

    /**
     * { restore red-black tree invariant }.
     *
     * @param      h1     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node balance(final Node h1) {
        // assert (h != null);
        Node h = h1;
        if (isRed(h.right)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }

    /**
     * { Returns the height of the BST (for debugging) }.
     *
     * @return     { description_of_the_return_value }
     */
    public int height() {
        return height(root);
    }
    /**
     * { the height of the BST }.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private int height(final Node x) {
        if (x == null) {
            return -1;
        }
        return 1 + Math.max(height(x.left), height(x.right));
    }

    /**
     * { Returns the smallest key in the symbol table }.
     *
     * @return     { description_of_the_return_value }
     */
    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "calls min() with empty symbol table");
        }
        return min(root).key;
    }
    /**
     * { Returns the smallest key in the symbol table }.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node min(final Node x) {
        // assert x != null;
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }

    /**
     * { Returns the largest key in the symbol table }.
     *
     * @return     { description_of_the_return_value }
     */
    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "calls max() with empty symbol table");
        }
        return max(root).key;
    }
    /**
     * { Returns the largest key in the symbol table }.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node max(final Node x) {
        // assert x != null;
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }

    /**
     * { Returns the largest key in the symbol table less
     *   than or equal to key }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Key floor(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to floor() is null");
        }
        if (isEmpty()) {
            throw new NoSuchElementException(
                "calls floor() with empty symbol table");
        }
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }

    /**
     * { Returns the largest key in the symbol table less
     *   than or equal to key }.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Node floor(final Node x, final Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    /**
     * { Returns the smallest key in the symbol table greater
     *   than or equal to key }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Key ceiling(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to ceiling() is null");
        }
        if (isEmpty()) {
            throw new NoSuchElementException(
                "calls ceiling() with empty symbol table");
        }
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }

    /**
     * { Returns the smallest key in the symbol table greater
     *   than or equal to key }.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Node ceiling(final Node x, final Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp > 0) {
            return ceiling(x.right, key);
        }
        Node t = ceiling(x.left, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    /**
     * { Return the key in the symbol table whose rank is k.
     *   This is the (k+1)st smallest key in the symbol table }.
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Key select(final int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException(
                "argument to select() is invalid: " + k);
        }
        Node x = select(root, k);
        return x.key;
    }

    /**
     * { the key of rank k in the subtree rooted at x }.
     *
     * @param      x     { parameter_description }
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node select(final Node x, final int k) {
        // assert x != null;
        // assert k >= 0 && k < size(x);
        int t = size(x.left);
        if (t > k) {
            return select(x.left,  k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }

    /**
     * { Return the number of keys in the symbol table
     *   strictly less than key }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public int rank(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to rank() is null");
        }
        return rank(key, root);
    }

    /**
     * { number of keys less than key in the subtree rooted at x }.
     *
     * @param      key   The key
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private int rank(final Key key, final Node x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(key, x.left);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
    }

    /**
     * { Returns the keys }.
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Key> keys() {
        if (isEmpty()) {
            return new Queue<Key>();
        }
        return keys(min(), max());
    }

    /**
     * { Returns all keys in the symbol table in the given range }.
     *
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Key> keys(final Key lo, final Key hi) {
        if (lo == null) {
            throw new IllegalArgumentException(
                "first argument to keys() is null");
        }
        if (hi == null) {
            throw new IllegalArgumentException(
                "second argument to keys() is null");
        }

        Queue<Key> queue = new Queue<Key>();
        // if (isEmpty() || lo.compareTo(hi) > 0) return queue;
        keys(root, queue, lo, hi);
        return queue;
    }

    /**
     * { add the keys between lo and hi in the subtree rooted at x }.
     *
     * @param      x      { parameter_description }
     * @param      queue  The queue
     * @param      lo     The lower
     * @param      hi     The higher
     */
    private void keys(final Node x, final Queue<Key> queue,
                      final Key lo, final Key hi) {
        if (x == null) {
            return;
        }
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) {
            keys(x.left, queue, lo, hi);
        }
        if (cmplo <= 0 && cmphi >= 0) {
            queue.enqueue(x.key);
        }
        if (cmphi > 0) {
            keys(x.right, queue, lo, hi);
        }
    }

    /**.
     * { Returns the number of keys in the symbol table
     *   in the given range }
     *
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return     { description_of_the_return_value }
     */
    public int size(final Key lo, final Key hi) {
        if (lo == null) {
            throw new IllegalArgumentException(
                "first argument to size() is null");
        }
        if (hi == null) {
            throw new IllegalArgumentException(
                "second argument to size() is null");
        }

        if (lo.compareTo(hi) > 0) {
            return 0;
        }
        if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else              {
            return rank(hi) - rank(lo);
        }
    }
    // /**
    //  * { function for check }.
    //  *
    //  * @return     { description_of_the_return_value }
    //  */
    // private boolean check() {
    //  if (!isBST())            System.out.println("Not in symmetric order");
    //  if (!isSizeConsistent()) System.out.println("Subtree counts not
    //    consistent");
    //  if (!isRankConsistent()) System.out.println("Ranks not consistent");
    //  if (!is23())             System.out.println("Not a 2-3 tree");
    //  if (!isBalanced())       System.out.println("Not balanced");
    //  return isBST() && isSizeConsistent() && isRankConsistent() && is23()
    //   && isBalanced();
    // }
    // /**
    //  * Determines if bst.
    //  *
    //  * @return     True if bst, False otherwise.
    //  */
    // private boolean isBST() {
    //  return isBST(root, null, null);
    // }
    // /**
    //  * Determines if bst.
    //  *
    //  * @param      x     { parameter_description }
    //  * @param      min   The minimum
    //  * @param      max   The maximum
    //  *
    //  * @return     True if bst, False otherwise.
    //  */
    // private boolean isBST(final Node x, final Key min, final Key max) {
    //  if (x == null) return true;
    //  if (min != null && x.key.compareTo(min) <= 0) return false;
    //  if (max != null && x.key.compareTo(max) >= 0) return false;
    //  return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    // }

    // // are the size fields correct?
    // private boolean isSizeConsistent() { return isSizeConsistent(root); }
    // private boolean isSizeConsistent(Node x) {
    //  if (x == null) return true;
    //  if (x.size != size(x.left) + size(x.right) + 1) return false;
    //  return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    // }

    // // check that ranks are consistent
    // private boolean isRankConsistent() {
    //  for (int i = 0; i < size(); i++)
    //      if (i != rank(select(i))) return false;
    //  for (Key key : keys())
    //      if (key.compareTo(select(rank(key))) != 0) return false;
    //  return true;
    // }

    // // Does the tree have no red right links, and at most one (left)
    // // red links in a row on any path?
    // private boolean is23() { return is23(root); }
    // private boolean is23(Node x) {
    //  if (x == null) return true;
    //  if (isRed(x.right)) return false;
    //  if (x != root && isRed(x) && isRed(x.left))
    //      return false;
    //  return is23(x.left) && is23(x.right);
    // }

    // // do all paths from root to leaf have same number of black edges?
    // private boolean isBalanced() {
    //  int black = 0;     // number of black links on path from root to min
    //  Node x = root;
    //  while (x != null) {
    //      if (!isRed(x)) black++;
    //      x = x.left;
    //  }
    //  return isBalanced(root, black);
    // }

    // // does every path from the root to a leaf have the
    //    given number of black links?
    // private boolean isBalanced(Node x, int black) {
    //  if (x == null) return black == 0;
    //  if (!isRed(x)) black--;
    //  return isBalanced(x.left, black) && isBalanced(x.right, black);
    // }



}
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
