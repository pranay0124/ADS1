/**
 * @author : Pranay Kumar Y.
 * date : 27th September,2018.
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
        int n = Integer.parseInt(scan.nextLine());
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split("");
            Stack stack = new Stack();
            boolean flag = false;
            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i].equals("{") || tokens[i].equals("[")
                        || tokens[i].equals("(")) {
                    stack.push(tokens[i]);
                }

                if (tokens[i].equals("}")) {
                    String str;
                    if (!stack.isEmpty()) {
                        str = stack.pop();
                        if (!str.equals("{")) {
                            flag = true;
                            break;
                        }
                    }
                }

                if (tokens[i].equals("]")) {
                    String str;
                    if (!stack.isEmpty()) {
                        str = stack.pop();
                        if (!str.equals("[")) {
                            flag = true;
                            break;
                        }
                    }
                }

                if (tokens[i].equals(")")) {
                    String str;
                    if (!stack.isEmpty()) {
                        str = stack.pop();
                        if (!str.equals("(")) {
                            flag = true;
                            break;
                        }
                    }
                }
            } if (!flag && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");

            }
        }
    }
}
