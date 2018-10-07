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
	void sort(Comparable[] array, int low, int high) {
		// System.out.println("insertionSort called");
		int n = array.length;
		for (int i = low; i <= high; i++) {
			for (int j = i; j > low && less(array[i], array[j - 1]); j--) {
				exch(array, j, j - 1);
			}
		}
	}
}

class QuickSort {
	boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
	}
	void swap(Comparable[] array, int a , int b) {
		Comparable temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	void sort(Comparable[] array, int start, int end, int cutoff) {
		if (start < end) {
			if (end <= start + cutoff - 1) {
				InsertionSort is = new InsertionSort();
				is.sort(array, start, end);
				System.out.println("insertionSort called");
				return;
			}
			int pivot = partition(array, start, end);
			// System.out.println(Arrays.toString(array));
			sort(array, start, pivot - 1, cutoff);
			sort(array, pivot + 1, end, cutoff);
		}
	}
	int partition(Comparable[] array, int start, int end) {
		// Comparable pivot = array[start];
		// int i = start - 1;
		// for (int j = start; j < end + 1; j++) {
		// 	if (array[j].compareTo(pivot) <= 0) {
		// 		i++;
		// 		swap(array, i, j);
		// 	}
		// }
		// swap(array, i , start);
		// return i;
		int i = start;
		int j = end + 1;
		while (true) {
			while (less(array[++i], array[start])) {
				if (i == end) {
					break;
				}
			}
			while (less(array[start], array[--j])) {
				if (j == start) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			swap(array, i, j);
		}
		swap(array, start, j);
		System.out.println(toString(array));
		return j;
	}
	public String toString(Comparable[] array) {
		String s = "[";
		int i;
		for (i = 0; i < array.length - 1; i++) {
			s += array[i] + ", ";
		}
		s = s + array[array.length - 1] + "]";
		return s;
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