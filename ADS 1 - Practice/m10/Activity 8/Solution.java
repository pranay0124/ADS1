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
     * { append function }.
     *
     * @param      str   The string
     *
     * @return     { description_of_the_return_value }
     */
    static String Append(final String str) {
        if(str.length() <= 1) {
            return str;
        }
        if(str.charAt(0) == str.charAt(1)) {
            return str.charAt(0) + "*" + Append(str.substring(1));
        }
        return str.charAt(0) + Append(str.substring(1));
    }
    /**
     * { main function }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(Append(str));
    }
}
