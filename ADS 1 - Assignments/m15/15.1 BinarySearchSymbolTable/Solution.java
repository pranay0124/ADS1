/**
 * @author : Pranay Kumar Y.
 * Date : 10th October,2018.
 */
import java.util.Scanner;
/**
 * Class for binary search st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchST<Key extends Comparable<Key>, Value> {
    /**
     * { array for keys }.
     */
    private Key[] keys;
    /**
     * { array for values }.
     */
    private Value[]vals;
    /**
     * { variable for size }.
     */
    private int size = 0;
    /**
     * variable.
     */
    final int twenty = 20;
    /**
     * Constructs the object.
     */
    BinarySearchST() {
        keys = (Key[]) new Comparable[twenty];
        vals = (Value[]) new Object[twenty];
    }

    /**
     * { function for put }.
     * Complexity :
     *              Best Case : O(logn)
     *              Average Case : O(logn)
     *              Worst Case : O(logn)
     *
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Key key, final Value value) {
        if (key == null) {
            System.out.println("key is null");
        }
        if (value == null) {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            vals[i] = value;
            return;
        }
        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = value;
        size++;
    }

    /**
     * { returns the index of the key }.
     * Complexity :
     *              Best Case : O(logn)
     *              Average Case : O(logn)
     *              Worst Case : O(logn)
     *
     * @param      key   The key
     *
     * @return     { index }
     */
    public int rank(final Key key) {
        if (key == null) {
            System.out.println("key is null");
        }
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int compare = key.compareTo(keys[mid]);
            if (compare < 0) {
                high = mid - 1;
            } else if (compare > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    /**
     * { return true if the given key is in the symboltable }.
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
        if (key == null) {
            System.out.println("key is null");
        }
        return get(key) != null;
    }

    /**
     * { return value paired with Key }.
     * Complexity :
     *              Best Case : O(logn)
     *              Average Case : O(logn)
     *              Worst Case : O(logn)
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Value get(final Key key) {
        if (key == null) {
            System.out.println("key is null");
        }
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            return vals[i];
        }
        return null;
    }

    /**
     * Determines if empty.
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * { return largest key }.
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @return     { description_of_the_return_value }
     */
    public Key max() {
        if (isEmpty()) {
            System.out.println(
                "No elements are available in the Symbol table");
        }
        return keys[size - 1];
    }

    /**
     * { return largest key less than or equal to key }.
     * Complexity :
     *              Best Case : O(logn)
     *              Average Case : O(logn)
     *              Worst Case : O(logn)
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Key floor(final Key key) {
        int i = rank(key);
        if (i < size && key.compareTo(keys[i]) == 0) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        } else {
            return keys[i - 1];
        }
    }

    /**
     * { delete smallest key }.
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     */
    public void deleteMin() {
        if (isEmpty()) {
            System.out.println(
                "No elements are available in the Symbol table to perform deletion");
        }
        delete(min());
    }

    /**
     * { Finds the minimum element }.
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @return     { description_of_the_return_value }
     */
    public Key min() {
        if (isEmpty()) {
            System.out.println("empty symbol table");
        }
        return keys[0];
    }

    /**
     * { deletes the key }.
     * Complexity :
     *              Best Case : O(logn)
     *              Average Case : O(logn)
     *              Worst Case : O(logn)
     *
     * @param      key   The key
     */
    public void delete(final Key key) {
        if (key == null) {
            System.out.println("key is null");
        }

        int i = rank(key);
        if (i == size || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < size - 1; j++)  {
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }
        size--;
        keys[size] = null;
        vals[size] = null;
    }

    /**
     * { return all keys, in sorted order }.
     * Complexity :
     *              Best Case : O(n)
     *              Average Case : O(n)
     *              Worst Case : O(n)
     *
     * @return     { description_of_the_return_value }
     */
    public String keys() {
        String str = "";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            if (keys[i] != null) {
                str += keys[i] + " " + vals[i] + "\n";
            }
        }
        str += keys[size - 1] + " " + vals[size - 1];
        return str;
    }
}

/**
 * Class for Solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchST bs = new BinarySearchST();
        String line = sc.nextLine();
        String[] tokens = line.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            bs.put(tokens[i], i);
        }
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] tokens1 = input.split(" ");
            switch (tokens1[0]) {
            case "get":
                System.out.println(bs.get(tokens1[1]));
                break;
            case "max":
                System.out.println(bs.max());
                break;
            case "floor":
                System.out.println(bs.floor(tokens1[1]));
                break;
            case "rank":
                System.out.println(bs.rank(tokens1[1]));
                break;
            case "contains":
                System.out.println(bs.contains(tokens1[1]));
                break;
            case "deleteMin":
                bs.deleteMin();
                break;
            case "keys":
                System.out.println(bs.keys());
                break;

            default:
                break;
            }
        }
    }
}
