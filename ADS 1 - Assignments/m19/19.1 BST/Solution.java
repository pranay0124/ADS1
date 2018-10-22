import java.util.Scanner;
/**.
 * List of books.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BookList<Key extends Comparable<Key>, Value> {
    /**
     * Book name.
     */
    private String name;
    /**
     * Author name.
     */
    private String author;
    /**
     * Cost of the book.
     */
    private Float cost;
    /**
     * Constructs the object.
     *
     * @param      name1    The name
     * @param      author1  The author
     * @param      cost1    The cost
     */
    BookList(final String name1, final String author1, final Float cost1) {
        this.name = name1;
        this.author = author1;
        this.cost = cost1;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Sets the name.
     *
     * @param      name  The name
     */
    public void setName(final String name1) {
        this.name = name1;
    }
    /**
     * Gets the author.
     *
     * @return     The author.
     */
    public String getAuthor() {
        return this.author;
    }
    /**
     * Sets the author.
     *
     * @param      author  The author
     */
    public void setAuthor(final String author1) {
        this.author = author1;
    }
    /**
     * Gets the cost.
     *
     * @return     The cost.
     */
    public float getCost() {
        return this.cost;
    }
    /**
     * Sets the cost.
     *
     * @param      cost  The cost
     */
    public void setCost(final float cost1) {
        this.cost = cost1;
    }
    /**
     * Compare to function.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(1)
     */
    public int compareTo(final BookList that) {
        if (this.getName().compareTo(that.getName()) > 0) {
            return 1;
        } else if (this.getName().compareTo(that.getName()) < 0) {
            return -1;
        } else {
            if (this.getAuthor().compareTo(that.getAuthor()) > 0) {
                return 1;
            } else if (this.getAuthor().compareTo(that.getAuthor()) < 0) {
                return -1;
            } else {
                if (this.getCost() > that.getCost()) {
                    return 1;
                } else if (this.getCost() < that.getCost()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return getName() + ", " + getAuthor() + ", " + getCost();
    }
}

/**
 * Class for binary search tree.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchTree<Key extends Comparable<Key>, Value> {
    /**
     * { node root }.
     */
    private Node root;
    /**
     * { variable for size }.
     */
    private int size;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * { variable for key }.
         */
        private BookList key;
        /**.
         * { variable for value }.
         */
        private Value val;
        /**
         * { variable for left and right nodes }.
         */
        private Node left, right;
        /**
         * { variable for count }.
         */
        private int count;
        /**
         * Constructs the object.
         */
        public Node() { }
    }
    /**
     * { adds the element into the tree }.
     *
     * @param      key   The key
     * @param      val   The value
     * Time complexity : O(N)
     */
    public void put(final BookList key, final Value val) {
        if (key == null) {
            System.out.println("key is null");
        }
        root = put(root, key, val);
    }
    /**
     * { adds the element into the tree }.
     *
     * @param      head  The head
     * @param      key   The key
     * @param      val   The value
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(N)
     */
    public Node put(Node head, final BookList key, final Value val) {
        if (head == null) {
            Node node = new Node();
            node.key = key;
            node.val = val;
            node.left = node.right = null;
            head = node;
            size++;
        }
        int compare = key.compareTo(head.key);
        if (compare < 0) {
            head.left  = put(head.left, key, val);
        } else if (compare > 0) {
            head.right = put(head.right, key, val);
        } else {
            head.val = val;
        }
        head.count = 1 + size(head.left) + size(head.right);
        return head;
    }
    /**
     * { gets the element }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(N)
     */
    public Value get(final BookList key) {
        return get(root, key);
    }
    /**
     * { gets the element }.
     *
     * @param      root  The root
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(N)
     */
    private Value get(final Node root, final BookList key) {
        if (key == null) {
            System.out.println("key is null");
        }
        if (root == null) {
            return null;
        }
        int compare = key.compareTo(root.key);
        if (compare < 0) {
            return get(root.left, key);
        } else if (compare > 0) {
            return get(root.right, key);
        } else {
            return root.val;
        }
    }
    /**
     * { returns the minimum element in the tree }.
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public BookList min() {
        return min(root).key;
    }
    /**
     * { returns the minimum element in the tree }.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public Node min(final Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
    /**
     * { returns the maximum element in the tree }.
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public BookList max() {
        return max(root).key;
    }
    /**
     * { returns the maximum element in the tree }.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public Node max(final Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    /**
     * { function for floor }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public BookList floor(final BookList key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * { function for floor }.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public Node floor(final Node x, final BookList key) {
        if (x == null) {
            return null;
        }
        int compare = key.compareTo(x.key);
        if (compare == 0) {
            return x;
        }
        if (compare < 0) {
            return floor(x.left, key);
        }
        Node temp = floor(x.right, key);
        if (temp != null) {
            return temp;
        } else {
            return x;
        }
    }
    /**
     * { function for ceiling }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public BookList ceiling(final BookList key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * { function for floor}.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public Node ceiling(final Node x, final BookList key) {
        if (x == null) {
            return null;
        }
        int compare = key.compareTo(x.key);
        if (compare == 0) {
            return x;
        }
        if (compare < 0) {
            Node temp = ceiling(x.left, key);
            if (temp != null) {
                return temp;
            } else {
                return x;
            }
        }
        return ceiling(x.right, key);
    }

    /**
     * { returns the size }.
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(1)
     */

    public int size() {
        return size(root);
    }
    /**
     * { returns the size }.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(1)
     */
    public int size(final Node x) {
        if (x == null) {
            return 0;
        }
        return x.count;
    }
    /**.
     * { function for select }.
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public BookList select(final int k) {
        if (k < 0 || k >= size()) {
            return null;
        }
        Node x = select(root, k);
        return x.key;
    }
    /**.
     * { function for select }.
     *
     * @param      x     { parameter_description }
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public Node select(final Node x, final int k) {
        if (x == null) {
            return null;
        }
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
     * { function for keys }.
     *
     * Time complexity : O(N)
     */
    public void keys() {
        keys(root);
    }
    /**
     * { function for keys }.
     *
     * @param      x     { parameter_description }
     * Time complexity : O(N)
     */
    public void keys(final Node x) {
        if (x == null) {
            return;
        } else {
            keys(x.left);
            System.out.println(x.key);
            keys(x.right);
        }
    }
}
/**
 * Solution class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * { Main Function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] tokens = input.split(",");
            switch (tokens[0]) {
            case "put":
                bst.put(new BookList(tokens[1], tokens[2],
                                     Float.parseFloat(tokens[2 + 1])),
                        Integer.parseInt(tokens[2 + 2]));
                break;
            case "get":
                System.out.println(bst.get(new BookList(tokens[1],
                                                        tokens[2], Float.parseFloat(tokens[2 + 1]))));
                break;
            case "min":
                System.out.println(bst.min());
                break;
            case "max":
                System.out.println(bst.max());
                break;
            case "floor":
                System.out.println(bst.floor(new BookList(tokens[1],
                                             tokens[2], Float.parseFloat(tokens[2 + 1]))));
                break;
            case "ceiling":
                System.out.println(bst.ceiling(new BookList(tokens[1],
                                               tokens[2], Float.parseFloat(tokens[2 + 1]))));
                break;
            case "select":
                System.out.println(bst.select(Integer.parseInt(
                                                  tokens[1])));
                break;
            case "keys":
                bst.keys();
                break;
            default:
                break;
            }
        }
    }
}
