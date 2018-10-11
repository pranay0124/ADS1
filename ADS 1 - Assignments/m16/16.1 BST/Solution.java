/**
 * @author : Pranay Kumar Y.
 * Date : 11th October,2018.
 */
import java.util.Scanner;
/**==========================================================================
 *   Class for Book.
 *==========================================================================*/
class Book {
    /**
     * { variable for name }.
     */
    private String name;
    /**
     * { variable for author }.
     */
    private String author;
    /**
     * { variable for price }.
     */
    private double price;
    /**
     * Constructs the object.
     */
    Book() { }
    /**
     * Constructs the object.
     *
     * @param      name1    The name
     * @param      author1  The author
     * @param      price1   The price
     */
    Book(final String name1, final String author1, final double price1) {
        this.name = name1;
        this.author = author1;
        this.price = price1;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    String getName() {
        return name;
    }
    // public int compareTo(Book other) {
    //  return this.name.compareTo(other.name);
    // }
}

/**==========================================================================
 * Class for binary search tree.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 *==========================================================================*/
class BinarySearchTree<Key extends Comparable<Key>, Value> {
    /**
     * Class for node.
     */
    class Node {
        /**
         * { variable for key }.
         */
        private Book key;
        /**
         * { variable for value }.
         */
        private Value value;
        /**
         * { variable for left }.
         */
        private Node left;
        /**
         * { variable for right }.
         */
        private Node right;
        /**
         * Constructs the object.
         *
         * @param      key1    The key
         * @param      value1  The value
         */
        Node(final Book key1, final Value value1) {
            this.key = key1;
            this.value = value1;
        }
    }

    /**
     * { variable for root }.
     */
    private Node root;
    /**
     * Constructs the object.
     */
    BinarySearchTree() { }
    /**
     * { adds the element into the tree }.
     *
     * @param      key    The key
     * @param      value  The value
     */
    void put(final Book key, final Value value) {
        root = put(root, key, value);
    }
    /**
     * { adds the element into the tree }.
     *
     * @param      obj   The root
     * @param      key    The key
     * @param      value  The value
     *
     * @return     { description_of_the_return_value }
     */
    Node put(final Node obj, final Book key, final Value value) {
        if (obj == null) {
            return new Node(key, value);
        }
        int cmp = key.getName().compareTo(obj.key.getName());
        if (cmp > 0) {
            obj.right = put(obj.right, key, value);
        } else if (cmp < 0) {
            obj.left = put(obj.left, key, value);
        } else {
            obj.value = value;
        }
        return obj;
    }
    /**
     * { gets the element }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    String get(final Book key) {
        Node x = root;
        while (x != null) {
            int cmp = key.getName().compareTo(x.key.getName());
            // System.out.println(cmp + "see me");
            if (cmp > 0) {
                x = x.right;
            } else if (cmp < 0) {
                x = x.left;
            } else {
                String str = String.valueOf(x.value);
                return str;
            }

        }
        return null;
    }
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
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BinarySearchTree bt = new BinarySearchTree();
        Book book = new Book();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
            case "get" :
                book = new Book(tokens[1], tokens[2],
                                Double.parseDouble(tokens[2 + 1]));
                System.out.println(bt.get(book));
                break;
            case "put" :
                book = new Book(tokens[1], tokens[2],
                                Double.parseDouble(tokens[2 + 1]));
                bt.put(book, tokens[2 + 2]);
                break;
            default:
                break;
            }
        }
    }
}
