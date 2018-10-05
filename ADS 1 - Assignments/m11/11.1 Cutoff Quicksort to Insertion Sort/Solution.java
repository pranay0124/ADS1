import java.util.*;
class QuickSort {
	void swap(Comparable[] array, int a , int b) {
		Comparable temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	void sort(Comparable[] array, int start, int end) {
		if (start < end) {
			int pivot = partition(array, start, end);
			sort(array, start, pivot - 1);
			sort(array, pivot + 1, end);
		}
	}
	int partition(Comparable[] array, int start, int end) {
		Comparable pivot = array[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (array[j].compareTo(pivot)<= 0) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, end);
		return i + 1;
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
			qs.sort(inptarray, 0, inptarray.length - 1);
			System.out.println(Arrays.toString(inptarray));
		}
	}
}