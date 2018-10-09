
import java.util.Scanner;
import java.util.Arrays;
/**.
 * { item_description }
 */
final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        /**.
         * { item_description }
         */
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        HeapSort sort = new HeapSort();
        int n = sc.nextInt();
        int noOfVacancies = sc.nextInt();
        int vac1 = sc.nextInt();
        int vac2 = sc.nextInt();
        int vac3 = sc.nextInt();
        int vac4 = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] tokens = line.split(",");
            Student student = new Student(tokens[0], tokens[1],
             Integer.parseInt(tokens[2]), Integer.parseInt(tokens[2 + 1]),
             Integer.parseInt(tokens[2 + 2]), Integer.parseInt(tokens[2 + 2 + 1]),
             tokens[2 + 2 + 2]);
            sort.add(student);
        }
        sort.sort();
        System.out.println(sort.toString());
        sort.vacancy1(vac1);
        sort.vacancy2(vac1, vac2, vac3, vac4);
    }
}

/**************************************************************/
/**************************************************************/
/**************************************************************/
/**************************************************************/
/**
 * Class for student.
 */
class Student {
    /**.
     * { var_description }
     */
    private String name;
    /**.
     * { var_description }
     */
    private String date;
    /**.
     * { var_description }
     */
    private int marks1;
    /**.
     * { var_description }
     */
    private int marks2;
    /**.
     * { var_description }
     */
    private int marks3;
    /**.
     * { var_description }
     */
    private int total;
    /**.
     * { var_description }
     */
    private String category;
    /**.
     * Constructs the object.
     *
     * @param      nme      The nme
     * @param      dte      The dte
     * @param      m1       The m 1
     * @param      m2       The m 2
     * @param      m3       The m 3
     * @param      tot      The total
     * @param      categry  The categry
     */
    Student(final String nme, final String dte, final int m1,
        final int m2, final int m3, final int tot, final String categry) {
        this.name = nme;
        this.date = dte;
        this.marks1 = m1;
        this.marks2 = m2;
        this.marks3 = m3;
        this.total = tot;
        this.category = categry;
    }
    /**.
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**.
     * Gets the date.
     *
     * @return     The date.
     */
    public String getDate() {
        String revdate = "";
        revdate = date.substring(2 + 2 + 2) + "-"
        + date.substring(2 + 1, 2 + 2 + 1) + "-" + date.substring(0, 2);
        return revdate;
    }
    /**.
     * Gets the marks 1.
     *
     * @return     The marks 1.
     */
    public int getMarks1() {
        return this.marks1;
    }
    /**.
     * Gets the marks 2.
     *
     * @return     The marks 2.
     */
    public int getMarks2() {
        return this.marks2;
    }
    /**.
     * Gets the marks 3.
     *
     * @return     The marks 3.
     */
    public int getMarks3() {
        return this.marks3;
    }
    /**.
     * Gets the total.
     *
     * @return     The total.
     */
    public int getTotal() {
        return this.total;
    }
    /**.
     * Gets the category.
     *
     * @return     The category.
     */
    public String getCategory() {
        return this.category;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String print() {
        return this.getName() + "," + this.getTotal() + ","
        + this.getCategory();
    }
    // time complexity of this method is O(1) as it checks one time.
    /**.
     * { function_description }
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Student that) {
        if (this.getTotal() > that.getTotal()) {
            return 1;
        } else if (this.getTotal() < that.getTotal()) {
            return -1;
        } else {
            if (this.getMarks3() > that.getMarks3()) {
                return 1;
            } else if (this.getMarks3() < that.getMarks3()) {
                return -1;
            } else {
                if (this.getMarks2() > that.getMarks2()) {
                    return 1;
                } else if (this.getMarks2() < that.getMarks2()) {
                    return -1;
                } else {
                    return compareDate(this.getDate(), that.getDate());
                }
                // return 0;
            }
        }
    }
    /**.
     * { function_description }
     *
     * @param      d1    The d 1
     * @param      d2    The d 2
     *
     * @return     { description_of_the_return_value }
     */
    public int compareDate(final String d1, final String d2) {
        int res = d1.compareTo(d2);
        if (res < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}

/**************************************************************/
/**************************************************************/
/**************************************************************/
/**************************************************************/


/**
 * Class for heap sort.
 */
class HeapSort {
    /**.
     * { var_description }
     */
    private Student[] students;
    /**.
     * { var_description }
     */
    private int size;
    /**.
     * Constructs the object.
     */
    protected HeapSort() {
        final int fourty = 40;
        students = new Student[fourty];
        this.size = 0;
    }
    /**.
     * { function_description }
     *
     * @param      s     { parameter_description }
     */
    public void add(final Student s) {
        students[size++] = s;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**.
     * { function_description }
     */
    // time complexity of this method is O(N log N). It access the array elements twice
    public void sort() {
        int n = size;
        for (int k = n / 2; k >= 1; k--) {
            sink(students, k, n);
        }
        while (n > 1) {
            swap(students, 1, n--);
            sink(students, 1, n);
        }
    }
    /**
     * { function_description }.
     *
     * @param      students  The students
     * @param      k         { parameter_description }.
     * @param      n         { parameter_description }.
     *
     * time complexity of this method is O(log N). It access the array elements twice
     */
    public void sink(Student[] students, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(students, j, j + 1))  {
                j++;
            }
            if (!less(students, k, j)) {
                break;
            }
            swap(students, k, j);
            k = j;
        }
    }
    /**
     * { function_description }.
     *
     * @param      students  The students
     * @param      i         { parameter_description }
     * @param      j         { parameter_description }
     *
     * @return     { description_of_the_return_value }
     *
     * // time complexity of this method is O(1).
     */
    public boolean less(Student[] students, int i, int j) {
        return students[i - 1].compareTo(students[j - 1]) >= 0;
    }
    // time complexity of this method is O(1). It swaps the elements only once.
    /**.
     * { function_description }
     *
     * @param      students  The students
     * @param      j     { parameter_description }
     * @param      min   The minimum
     */
    public void swap(Student[] students, int j, int min) {
        Student temp = students[j - 1];
        students[j - 1] = students[min - 1];
        students[min - 1] = temp;
    }
    // time complexity of this method is O(N). It iterates through the array to
    // print all the objects in array.
    /**.
    @return     String representation of the object.
    */
    public String toString() {
        // System.out.println("in print");
        String str = "";
        for (int i = 0; i < size; i++) {
            str += students[i].getName() + "," + students[i].getTotal() +
                   "," + students[i].getCategory() + "\n";
        }
        return str;
    }
    /**
     * { function_description }.
     *
     * @param      arr   The arr
     * @param      s     { parameter_description }.
     *
     * @return     { description_of_the_return_value }.
     * // time complexity of this method is O(N). It iterates through the array to
     */
    public boolean contains(int[] arr, int s) {
        for (int i : arr) {
            if (s == i) {
                return true;
            }
        }
        return false;
    }
    /**.
     * { function_description }
     *
     * @param      n     { parameter_description }
     */
    // time complexity of this method is O(N). It iterates through the array to
    // print all the objects in array.
    public void vacancy1(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(students[i].getName() + "," + students[i].getTotal() +
                               "," + students[i].getCategory());
        }
    }
    /**.
     * { function_description }
     *
     * @param      n     { parameter_description }
     * @param      n1    The n 1
     */
    // time complexity of this method is O(N). It iterates through the array to
    // print all the objects in array.
    public void vacancy2(int n, int n1, int n2, int n3) {
        int[] array = new int[n1 + n2 + n3];
        int i = 0;
        for (int k = n; k < size; k++) {
            if (students[k].getCategory().equals("BC") && n1 > 0) {
                array[i++] = k;
                n1--;
            } else if (students[k].getCategory().equals("SC") && n2 > 0) {
                array[i++] = k;
                n2--;
            } else if (students[k].getCategory().equals("ST") && n3 > 0) {
                array[i++] = k;
                n3--;
            }
        }
        if (n1 > 0) {
            for (int k = n; k < size; k++) {
                if (students[k].getCategory().equals("Open") && n1 > 0) {
                    if (!contains(array, k)) {
                        array[i++] = k;
                        n1--;
                    }
                }
            }
        }
        if (n2 > 0) {
            for (int k = n; k < size; k++) {
                if (students[k].getCategory().equals("Open") && n2 > 0) {
                    if (!contains(array, k)) {
                        array[i++] = k;
                        n2--;
                    }
                }
            }
        }
        if (n3 > 0) {
            for (int k = n; k < size; k++) {
                if (students[k].getCategory().equals("Open") && n3 > 0) {
                    if (!contains(array, k)) {
                        array[i++] = k;
                        n3--;
                    }
                }
            }
        }
        Arrays.sort(array);
        for (int k = 0; k < array.length; k++) {
            System.out.println(students[array[k]].print());
        }
    }
}

