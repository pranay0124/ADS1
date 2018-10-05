import java.util.*;
class InsertionSort {
	boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
	}
	void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
	void sort(Comparable[] array) {
		System.out.println("insertionSort called");
		int n = array.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j > 0; j--) {
				if (less(array[j], array[j - 1])) {
					exch(array, j, j - 1);
				} else {
					break;
				}
			}
		}
	}
}
class QuickSort {
	void swap(Comparable[] array, int a , int b) {
		Comparable temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	void sort(Comparable[] array, int start, int end, int cutoff) {
		if (start < end) {
			int pivot = partition(array, start, end);
			if (end - start + 1 <= cutoff) {
				InsertionSort is = new InsertionSort();
				is.sort(array);
				return;
			}
			System.out.println(Arrays.toString(array));
			sort(array, start, pivot - 1, cutoff);
			sort(array, pivot + 1, end, cutoff);
		}
	}
	int partition(Comparable[] array, int start, int end) {
		Comparable pivot = array[start];
		int i = start - 1;
		for (int j = start; j < end + 1; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i , start);
		return i;
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < test; i++) {
			QuickSort qs = new QuickSort();
			int cutoff = Integer.parseInt(scan.nextLine());
			Comparable[] inptarray = scan.nextLine().split(" ");
			qs.sort(inptarray, 0, inptarray.length - 1, cutoff);
			System.out.println(Arrays.toString(inptarray));
		}
	}
}