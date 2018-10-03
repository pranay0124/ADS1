import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for insertion sort.
 */
class InsertionSort {
    /**
     * { less function to check for minimum }.
     *
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @param      inputone  The inputone
     * @param      inputtwo  The inputtwo
     *
     * @return     { boolean value }
     */
    boolean less(final  String inputone, final String inputtwo) {

        //checks for the greatness using compareTo function

        return inputone.compareTo(inputtwo) < 0;
    }
    /**
     * { function for exchange }.
     *
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @param      inputarray  The inputarray
     * @param      bigindex    The bigindex
     * @param      smallindex  The smallindex
     */
    void exchange(final String[] inputarray,
                  final int bigindex,
                  final int smallindex) {

        //creates a temporary variable to store the bigindex value

        String temp = inputarray[bigindex];

        //swap the indexe

        inputarray[bigindex] = inputarray[smallindex];

        inputarray[smallindex] = temp;
    }
    /**
     * { sort function }.
     *
     * Complexity :
     *              Best Case : O(n)
     *              Average Case : O(n^2)
     *              Worst Case : O(n^2)
     *
     * @param      inputarray  The inputarray
     * @param      start       The start
     * @param      end         The end
     */
    void sort(final String[] inputarray, final int start, final int end) {
        for (int i = start; i <= end; i++) {
            for (int j = i; j > start; j--) {
                if (less(inputarray[j], inputarray[j - 1])) {

                    //call the exchange function.

                    exchange(inputarray, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
/**
 * Class for mergesort.
 */
class Mergesort {
    /**
     * { function for less }.
     *
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @param      inputone  The inputone
     * @param      inputtwo  The inputtwo
     *
     * @return     { description_of_the_return_value }
     */
    boolean less(final  String inputone, final String inputtwo) {

        //checks for the greatness using compareTo function

        return inputone.compareTo(inputtwo) < 0;
    }
    /**
     * { merge function }.
     *
     * Complexity :
     *              Best Case : O(n)
     *              Average Case : O(n)
     *              Worst Case : O(n)
     *
     * @param      inputarray    The inputarray
     * @param      storingarray  The storingarray
     * @param      first         The first
     * @param      middle        The middle
     * @param      last          The last
     */
    void merge(final String[] inputarray, final String[] storingarray,
        final int first, final int middle, final int last) {
        int subarr1 = first;
        int subarr2 = middle + 1;
        for (int k = first; k <= last; k++) {
            if (subarr1 > middle) {
                storingarray[k] = inputarray[subarr2++];
            } else if (subarr2 > last) {
                storingarray[k] = inputarray[subarr1++];
            } else if (less(inputarray[subarr2], inputarray[subarr1])) {
                storingarray[k] = inputarray[subarr2++];
            } else {
                storingarray[k] = inputarray[subarr1++];
            }
        }
    }
    /**
     * { sort function }.
     *
     * Complexity :
     *              Best Case : O(nlog(n))
     *              Average Case : O(nlog(n))
     *              Worst Case : O(nlog(n))
     *
     * @param      inputarray    The inputarray
     * @param      storingarray  The storingarray
     * @param      first         The first
     * @param      last          The last
     */
    void sort(final String[] inputarray, final String[] storingarray,
        final int first, final int last) {
        // System.out.println(Arrays.toString(inputarray) + "called");
        InsertionSort insertion = new InsertionSort();
        final int seven = 7;
        if (last - first <= seven) {
            insertion.sort(storingarray, first, last);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int middle = (first + last) / 2;
        sort(storingarray, inputarray, first, middle);
        sort(storingarray, inputarray, middle + 1, last);
        if (less(inputarray[middle], inputarray[middle + 1])) {
            for (int i = first; i <= last; i++) {
                storingarray[i] = inputarray[i];
            }
            System.out.println("Array is already sorted."
                + " So, skipped the call to merge...");
            return;
        }
        merge(inputarray, storingarray, first, middle, last);
    }
}

/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused
    }
    /**
     * { main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Mergesort sortobj = new Mergesort();
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.split(",");
            int low = 0;
            int high = tokens.length - 1;
            String[] temparray =  Arrays.copyOf(tokens,
                                    tokens.length);
            sortobj.sort(temparray, tokens, low, high);
            System.out.println(Arrays.toString(tokens));
            System.out.println();
        }
    }
}
