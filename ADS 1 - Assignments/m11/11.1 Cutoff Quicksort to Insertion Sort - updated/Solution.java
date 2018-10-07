/**
 * @author : Pranay Kumar Y.
 * Date 5th October,2018.
 */
import java.util.Scanner;
/**==========================================================================
 *              Class for insertion sort.
 *==========================================================================*/
class InsertionSort {
    /**
     *
     * { function for less }.
     *
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @param      u     { parameter_description }
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    boolean less(final Comparable u, final Comparable v) {
        return u.compareTo(v) < 0;
    }
    /**
     * { swaps the elements }.
     * 
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @param      a     { parameter_description }
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    void exch(final Comparable[] a, final int i, final int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    /**
     * { sorts the array }.
     * 
     * Complexity :
     *              Best Case : O(nlogn)
     *              Average Case : O(nlogn)
     *              Worst Case : O(nlogn)
     *
     * @param      array  The array
     * @param      low    The low
     * @param      high   The high
     */
    void sort(final Comparable[] array, final int low, final int high) {
        System.out.println("insertionSort called");
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(array[j], array[j - 1]); j--) {
                exch(array, j, j - 1);
            }
        }
    }
}
/**==========================================================================
 *              Class for Quick sort.
 *==========================================================================*/
class QuickSort {
    /**
     * { function for less }.
     * 
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @param      u     { parameter_description }
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    boolean less(final Comparable u, final Comparable v) {
        return u.compareTo(v) < 0;
    }
    /**
     * { swaps the element }.
     * 
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @param      array  The array
     * @param      a      { parameter_description }
     * @param      b      { parameter_description }
     */
    void swap(final Comparable[] array, final int a, final int b) {
        Comparable temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    /**
     * { sorts the array }.
     * 
     * Complexity :
     *              Best Case : O(nlogn)
     *              Average Case : O(nlogn)
     *              Worst Case : O(nlogn)
     *
     * @param      array   The array
     * @param      start   The start
     * @param      end     The end
     * @param      cutoff  The cutoff
     */
    void sort(final Comparable[] array,
              final int start,
              final int end,
              final int cutoff) {
        // if (start < end) {
        if (end - start < cutoff) {
            InsertionSort is = new InsertionSort();
            is.sort(array, start, end);
            // System.out.println("insertionSort called");
            return;
        }
        int pivot = partition(array, start, end);
        // System.out.println(Arrays.toString(array));
        sort(array, start, pivot - 1, cutoff);
        sort(array, pivot + 1, end, cutoff);
    }
    /**
     * { partition function }.
     * 
     * Complexity :
     *              Best Case : O(n)
     *              Average Case : O(n^2)
     *              Worst Case : O(n^2)
     *
     * @param      array  The array
     * @param      start  The start
     * @param      end    The end
     *
     * @return     { description_of_the_return_value }
     */
    int partition(final Comparable[] array, final int start, final int end) {
        // Comparable pivot = array[start];
        // int i = start - 1;
        // for (int j = start; j < end + 1; j++) {
        //  if (array[j].compareTo(pivot) <= 0) {
        //      i++;
        //      swap(array, i, j);
        //  }
        // }
        // swap(array, i , start);
        // return i;
        Comparable pivot = array[start];
        int p1 = start;
        int p2 = end;
        while (true) {
            while (p2 >= start && array[p2].compareTo(pivot) > 0) {
                p2--;
            }
            while (p1 <= end && array[p1].compareTo(pivot) <= 0) {
                p1++;
            }
            if (p2 < p1) {
                p1--;
                break;
            }
            swap(array, p1, p2);
            p1++;
            p2--;
        }
        array[start] = array[p1];
        array[p1] = pivot;
        System.out.println(toString(array));
        return p1;
    }
    /**
     * { Returns a string representation of the object }.
     *
     * @param      array  The array
     *
     * @return     String representation of the object.
     */
    public String toString(final Comparable[] array) {
        String s = "[";
        int i;
        for (i = 0; i < array.length - 1; i++) {
            s += array[i] + ", ";
        }
        s = s + array[array.length - 1] + "]";
        return s;
    }
}
/**==========================================================================
 *              Class for Solution class.
 *==========================================================================*/
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * { main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int test = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < test; i++) {
            QuickSort qs = new QuickSort();
            int cutoff = Integer.parseInt(scan.nextLine());
            String line = scan.nextLine();

            if (line.equals("")) {
                System.out.println("[]");
            } else {
                Comparable[] array = line.split(" ");
                qs.sort(array, 0, array.length - 1, cutoff);
                System.out.println(qs.toString(array));
            }
        }
    }
}
