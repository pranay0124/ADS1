/**
 * Author : Pranay Kumar Y.
 * Date : 27th September,2018.
 */
import java.util.Scanner;
// import java.util.LinkedList;

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
        String[] tokens = scan.nextLine().split(" ");
        LinkedList list = new LinkedList();
        for (int i = 0; i < tokens.length; i++) {
            if (!("+*-/").contains(tokens[i])) {
                list.push(Integer.parseInt(tokens[i]));
            } else {
                switch (tokens[i]) {
                case "+" :
                    int a = list.pop();
                    int b = list.pop();
                    list.push(a + b);
                    break;

                case "-" :
                    a = list.pop();
                    b = list.pop();
                    list.push(a - b);
                    break;

                case "*" :
                    a = list.pop();
                    b = list.pop();
                    list.push(a * b);
                    break;

                case "/" :
                    a = list.pop();
                    b = list.pop();
                    list.push(a / b);
                    break;
                default:
                }
            }
        }
        list.printList();
    }
}
