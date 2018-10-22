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
        Node() { }
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
     * @param      head1  The head
     * @param      key   The key
     * @param      val   The value
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(N)
     */
    public Node put(final Node head1, final BookList key, final Value val) {
        Node head = head1;
        if (head == null) {
            Node node = new Node();
            node.key = key;
            node.val = val;
            // node.left = node.right = null;
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
     * @param      root1  The root
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Time complexity : O(N)
     */
    private Value get(final Node root1, final BookList key) {
        if (key == null) {
            System.out.println("key is null");
        }
        if (root1 == null) {
            return null;
        }
        int compare = key.compareTo(root1.key);
        if (compare < 0) {
            return get(root1.left, key);
        } else if (compare > 0) {
            return get(root1.right, key);
        } else {
            return root1.val;
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
