import java.util.Scanner;
/**.
 * List of books.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BookList<Key extends Comparable<Key>,Value> {
    /**.
     * Book name
     */
    String name;
    /**.
     * Author name
     */
    String author;
    /**.
     * Cost of the book.
     */
    Float cost;
    /**.
     * Constructs the object.
     *
     * @param      name    The name
     * @param      author  The author
     * @param      cost    The cost
     */
    BookList(String name, String author, Float cost) {
        this.name = name;
        this.author = author;
        this.cost = cost;
    }
    /**.
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**.
     * Sets the name.
     *
     * @param      name  The name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**.
     * Gets the author.
     *
     * @return     The author.
     */
    public String getAuthor() {
        return this.author;
    }
    /**.
     * Sets the author.
     *
     * @param      author  The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    /**.
     * Gets the cost.
     *
     * @return     The cost.
     */
    public float getCost() {
        return this.cost;
    }
    /**.
     * Sets the cost.
     *
     * @param      cost  The cost
     */
    public void setCost(float cost) {
        this.cost = cost;
    }
    /**.
     * { function_description }
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(1)
     */
    public int compareTo(BookList that) {
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
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return getName() + ", " + getAuthor() + ", " + getCost();
    }
}

/**.
 * Class for binary search tree.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchTree<Key extends Comparable<Key>,Value> {
    /**.
     * { var_description }
     */
    private Node root;
    /**.
     * { var_description }
     */
    private int size;
    /**.
     * Class for node.
     */
    private class Node {
        /**.
         * { var_description }
         */
        private BookList key;
        /**.
         * { var_description }
         */
        private Value val;
        /**.
         * { item_description }
         */
        private Node left, right;
        /**.
         * { var_description }
         */
        private int count; 
        /**.
         * Constructs the object.
         */
        public Node () {
        }
    }
    /**.
     * { function_description }
     *
     * @param      key   The key
     * @param      val   The value
     * Time complexity : O(N)
     */
    public void put(BookList key, Value val) {
        if (key == null) {
            System.out.println("key is null");
        }
        root = put(root, key, val);
    }
    /**
     * { function_description }
     *
     * @param      head  The head
     * @param      key   The key
     * @param      val   The value
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(N)
     */
    public Node put(Node head, BookList key, Value val) {
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
     * { function_description }
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(N)
     */
    public Value get(BookList key) {
        return get(root, key);
    }
    /**
     * { function_description }
     *
     * @param      root  The root
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(N)
     */
    private Value get(Node root, BookList key) {
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
        } else{
            return root.val;
        }
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public BookList min() {
        return min(root).key;
    }
    /**.
     * { function_description }
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public Node min(Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public BookList max() {
        return max(root).key;
    }
    /**.
     * { function_description }
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public Node max(Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    /**.
     * { function_description }
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public BookList floor(BookList key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**.
     * { function_description }
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public Node floor(Node x, BookList key) {
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
    /**.
     * { function_description }
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public BookList ceiling(BookList key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**.
     * { function_description }
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public Node ceiling(Node x, BookList key) {
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

    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(1)
     */

    public int size() {
        return size(root);
    }
    /**.
     * { function_description }
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(1)
     */
    public int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.count;
    }
    /**.
     * { function_description }
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public BookList select(int k) {
        if (k < 0 || k >= size()) {
            return null;
        }
        Node x = select(root, k);
        return x.key;
    }
    /**.
     * { function_description }
     *
     * @param      x     { parameter_description }
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(logN)
     */
    public Node select(Node x, int k) {
        if (x == null) {
            return null; 
        }
        int t = size(x.left); 
        if (t > k) {
            return select(x.left,  k); 
        } else if (t < k) {
            return select(x.right, k-t-1);
        } else {
            return x;
        }
    }
    /**.
     * { function_description }
     * Time complexity : O(N)
     */
    public void keys() {
        keys(root);
    }
    /**.
     * { function_description }
     *
     * @param      x     { parameter_description }
     * Time complexity : O(N)
     */
    public void keys(Node x) {
        if (x == null) {
            return;
        } else {
            keys(x.left);
            System.out.println(x.key);
            keys(x.right);
        }
    }
}

/**.
 * { item_description }
 */

/**.
 * { item_description }
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        /**.
         * { item_description }
         */
    }
    /**.
     * { function_description }
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
