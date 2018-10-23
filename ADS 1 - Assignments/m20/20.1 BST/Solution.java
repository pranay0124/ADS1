/**
 * @author : Pranay Kumar Y.
 * Date : 23th October, 2018
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        Bst bst = new Bst();
        Book book = new Book();
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                book = new Book(tokens[1], tokens[2],
                                Float.parseFloat(tokens[2 + 1]));
                bst.put(book, tokens[2 + 2]);
                break;
            case "get":
                book = new Book(tokens[1], tokens[2],
                                Float.parseFloat(tokens[2 + 1]));
                System.out.println(bst.get(book));
                break;
            case "max":
                System.out.println(bst.max());
                break;
            case "min":
                System.out.println(bst.min());
                break;
            case "select":
                System.out.println(bst.select(
                                       Integer.parseInt(tokens[1])));
                break;
            case "floor":
                book = new Book(tokens[1], tokens[2],
                                Float.parseFloat(tokens[2 + 1]));
                System.out.println(bst.floor(book));
                break;
            case "ceiling":
                book = new Book(tokens[1], tokens[2],
                                Float.parseFloat(tokens[2 + 1]));
                System.out.println(bst.ceiling(book));
                break;
            case "delete":
                book = new Book(tokens[1], tokens[2],
                                Float.parseFloat(tokens[2 + 1]));
                bst.delete(book);
                break;
            case "deleteMin":
                bst.deleteMin();
                break;
            case "deleteMax":
                bst.deleteMax();
                break;
            default:
                break;
            }
        }
    }
}
