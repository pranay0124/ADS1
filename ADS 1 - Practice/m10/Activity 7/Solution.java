/**
 * @author : pranay kumar y.
 * date : 4th October,2018.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * { function for factorial }.
     *
     * @param      n     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    static int factorial(final int n) {
        if(n==1) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
    /**
     * { main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ans = factorial(n);
        System.out.println("Factorial of " + n + " is " + ans);
    }
}
