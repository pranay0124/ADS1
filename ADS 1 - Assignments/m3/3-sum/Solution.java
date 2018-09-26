/**
 * Author : Pranay Kumar Y.
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
        //Zero Parameter Constructor.
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
        for (int i = 0; i < size; i++) {
            array[i] = scan.nextInt();
        }

        int a = 0;
        int b = 0;
        int c = 0;
        int head = 0;
        int tail = 0;
        int count = 0;
        Arrays.sort(array);
        for (int i = 0; i < size - 2; i++) {
            a = array[i];
            head = i + 1;
            tail = size - 1;
            while (head < tail) {
                b = array[head];
                c = array[tail];
                if (a + b + c == 0) {
                    count++;
                    head += 1;
                    tail -= 1;
                } else if (a + b + c < 0) {
                    head += 1;
                } else {
                    tail -= 1;
                }
            }
        }
        System.out.println(count);

    }
}
