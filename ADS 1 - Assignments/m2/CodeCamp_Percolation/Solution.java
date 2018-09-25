// public class Percolation {
//    public Percolation(int n)
      /*create n-by-n grid, with all sites blocked*/
//    public    void open(int row, int col)
      /*open site (row, col) if it is not open already*/
//    public boolean isOpen(int row, int col)
      /*is site (row, col) open?*/
//    public boolean isFull(int row, int col)
      /*is site (row, col) full?*/
//    public     int numberOfOpenSites()
      /*number of open sites*/
//    public boolean percolates()
      /*does the system percolate?*/
// }
// You can implement the above API to solve the problem

/**
 * util package.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
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
        int size = Integer.parseInt(scan.nextLine());
        Percolation p = new Percolation(size);
        while (scan.hasNext()) {
            p.open(scan.nextInt(), scan.nextInt());
        }
        System.out.println(p.percolates());
    }
}
