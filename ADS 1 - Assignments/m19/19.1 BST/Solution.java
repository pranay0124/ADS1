/**.
 * { item_description }
 */
import java.util.Scanner;
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
