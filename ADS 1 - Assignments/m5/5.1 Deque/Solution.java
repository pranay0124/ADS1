/**
 * @author : Pranay Kumar Y.
 * Date : 30th September,2018.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
final public class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Zero Parameter Constructor.
    }
    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> queue = new Deque<>();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "pushRight":
                queue.pushRight(Integer.parseInt(tokens[1]));
                break;
            case "pushLeft":
                queue.pushLeft(Integer.parseInt(tokens[1]));
                break;
            case "popRight":
                queue.popRight();
                break;
            case "popLeft":
                queue.popLeft();
                break;
            case "size":
                System.out.println(queue.getSize());
                break;
            default :
            }
        }
    }
}
