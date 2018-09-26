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
        /*Creating the array with values*/
        for (int i = 0; i < size; i++) {
            array[i] = scan.nextInt();
        }
        Arrays.sort(array);
        // System.out.println(Arrays.toString(array));

        /*New Array with the weights of the previous array values*/
        /*in new array indexes*/
        int index = 0;
        int[] newarray = new int[array[size - 1]];
        while (index < size) {
            int elementindex = array[index] - 1;
            if (newarray[elementindex] == 0) {
                newarray[elementindex] = 1;
            } else {
                newarray[elementindex] += 1;
            }
            index++;
        }
        // System.out.println(Arrays.toString(newarray));

        /*Counting the no of pair*/
        int count = 0;
        for (int j = 0; j < array[size - 1]; j++) {
            if (newarray[j] >= 2) {
                int value = newarray[j];
                count += ((value) * (value - 1)) / 2;
            }
        }
        System.out.println("pair count " + count);

    }
}
