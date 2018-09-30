/**
 * @author : Pranay Kumar Y.
 * Date : 30th September, 2018.
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
        //Zero Parameter Constructor.
    }
    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String testcases = scan.nextLine();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            int person = Integer.parseInt(tokens[0]);
            int gap = Integer.parseInt(tokens[1]);
            Deque<Integer> queue = new Deque<>();
            createCircle(queue, person);
            queue.josephus(person, gap);
        }
    }
    /**
     * Creates a circle.
     *
     * @param      queue   The queue
     * @param      person  The person
     */
    public static void createCircle(final Deque<Integer> queue,
                                    final int person) {
        for (int i = 0; i < person; i++) {
            queue.push(i);
        }
    }
}
