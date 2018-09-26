/**
 * Name : Pranay Kumar Y.
 * Date : 26th September,2018.
 */
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Zero parameter constructor.
    }

    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] array = new int[size];
        /*Creating the array with values*/
        for (int i = 0; i < size; i++) {
            array[i] = scan.nextInt();
        }
        Arrays.sort(array);

        System.out.println("Enter the number you want : ");
        int value = scan.nextInt();
        int first = 0;
        int last = size;
        int present = 0;
        int mid = 0;

        if (size == 1 && array[size - 1] == value) {
            System.out.println("Array contains the value "
                               + value + " at " + first);
            return;
        }
        while (last != first) {
            mid = ((first + last) / 2);
            if (array[mid] == value) {
                present = 1;
                last = mid;
            } else if (array[mid] < value) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        if (present == 1) {
            System.out.println("Array contains "
                               + value + " at " + last);
            return;
        }
        System.out.println("Array does not contain " + value);
    }
}
