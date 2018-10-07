/**
 * @author : Pranay Kumar Y.
 * Date 5th October,2018.
 */
import java.util.Scanner;
/*==========================================================================*/
/*               Class for insertion sort.                                                           */
/*==========================================================================*/
class InsertionSort {
	boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
	}
	void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	void sort(Comparable[] array, int low, int high) {
		System.out.println("insertionSort called");
		for (int i = low; i <= high; i++) {
			for (int j = i; j > low && less(array[j], array[j - 1]); j--) {
				exch(array, j, j - 1);
			}
		}
	}
}
/*==========================================================================*/
/*                                                                          */
/*==========================================================================*/
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
	// }
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
/*==========================================================================*/
/*                                                                          */
/*==========================================================================*/
class Solution {
	public static void main(String[] args) {
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
