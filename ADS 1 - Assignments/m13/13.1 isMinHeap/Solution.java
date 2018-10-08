/**
 * @author : Pranay Kumar Y.
 * Date : 8th October,2018.
 */
import java.util.Scanner;
/**==========================================================================
 * Class for minimum heap.
 *
 * @param      <E>   { parameter_description }
 *==========================================================================*/
class MinHeap<E extends Comparable<E>> {
    /**
     * { Heap Array }.
     */
    private E[] heaparray;
    /**
     * { count variable }.
     */
    private int count;
    /**
     * { flag variable }.
     */
    private int flag;
    /**
     * Constructs the object.
     *
     * @param      size  The size
     */
    MinHeap(final int size) {
        heaparray = (E[]) new Comparable[size];
        count = 0;
        flag = 0;
    }
    /**
     * { function that returns the less value }.
     *
     * @param      valueone  The valueone
     * @param      valuetwo  The valuetwo
     *
     * @return     { description_of_the_return_value }
     */
    boolean less(final E valueone, final E valuetwo) {
        return valueone.compareTo(valuetwo) < 0;
    }
    /**
     * { Swim Function }.
     *
     * @param      heaparr  The heaparr
     * @param      node     The node
     *
     * @return     { description_of_the_return_value }
     */
    boolean swim(final E[] heaparr, final int node) {
        int nodeval = node;
        while (nodeval > 1) {
            if (less(heaparr[nodeval], heaparr[(nodeval - 1) / 2])) {
                return false;
            } else {
                nodeval = (nodeval - 1) / 2;
            }
        }
        return true;
    }
    /**
     * { Inserts the element }.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    int insert(final E item) {
        heaparray[count++] = item;
        if (!swim(heaparray, count - 1)) {
            flag = 1;
        }
        return flag;
    }
}
/**==========================================================================
 *              Class for Solution class.
 *==========================================================================*/
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused
    }
    /**
     * { Main Function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        int testnum = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testnum; i++) {
            outerloop:
            switch (line) {
            case "String":
                String[] tokens = scan.nextLine().split(",");
                MinHeap<String> stringobj = new MinHeap<String>(tokens.length);
                for (int j = 0; j < tokens.length; j++) {
                    int returnval = stringobj.insert(tokens[j]);
                    if (returnval == 1) {
                        System.out.println("false");
                        break outerloop;
                    }
                }
                System.out.println("true");
                break;
            case "Integer":
                tokens = scan.nextLine().split(",");
                MinHeap<Integer> intobj = new MinHeap<Integer>(tokens.length);
                for (int j = 0; j < tokens.length; j++) {
                    int returnval = intobj.insert(Integer.parseInt(tokens[j]));
                    if (returnval == 1) {
                        System.out.println("false");
                        break outerloop;
                    }
                }
                System.out.println("true");
                break;
            case "Double":
                tokens = scan.nextLine().split(",");
                MinHeap<Double> doubleobj = new MinHeap<Double>(tokens.length);
                for (int j = 0; j < tokens.length; j++) {
                    int returnval = doubleobj.insert(
                                        Double.parseDouble(tokens[j]));
                    if (returnval == 1) {
                        System.out.println("false");
                        break outerloop;
                    }
                }
                System.out.println("true");
                break;
            case "Float":
                tokens = scan.nextLine().split(",");
                if (tokens[0].equals("")) {
                    System.out.println("false");
                    break;
                }
                MinHeap<Float> floatobj = new MinHeap<Float>(tokens.length);
                for (int j = 0; j < tokens.length; j++) {
                    int returnval = floatobj.insert(
                                        Float.parseFloat(tokens[j]));
                    if (returnval == 1) {
                        System.out.println("false");
                        break outerloop;
                    }
                }
                System.out.println("true");
                break;
            default:
                break;
            }
        }
    }
}
