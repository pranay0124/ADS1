import java.util.*;
// class MinPQ {
// 	int[] minarray;
// 	MinPQ() {

// 	}
// }
// class MaxPQ {
// 	int[] maxarray;
// 	MaxPQ() {

// 	}

// }
class Median {
	int median;
	int i;
	int j;
	int[] minarray;
	int[] maxarray;
	// int size = 0;
	// Median() { }
	Median() {
		median = 0;
		i = 0;
		j = 0;
		minarray = new int[10];
		maxarray = new int[10];
	}
	boolean less(int[] array, int i, int j) {
		return array[i] >= array[j];
	}
	void exch(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	void swim(int[] array, int k) {
		while (k > 1 && less(array, k / 2, k)) {
			exch(array, k, k / 2);
			k = k / 2;
		}
	}
	void insert(int x) {
		int m = median();
		System.out.println(median);
		if (x > m) {
			insertmin(x);
		} else {
			insertmax(x);
		}
	}
	void insertmin(int x) {
		// int median = median(minarray, maxarray, i, j);
		// if (x > median) {
		minarray[++i] = x;
		swim(minarray, i);
		// } else {

		// }
	}
	void insertmax(int x) {
		maxarray[++j] = x;
		swim(maxarray, j);
	}
	void sink(int[] array, int k) {
		while ((2 * k) <= array.length) {
			int j = 2 * k;
			if (j < array.length && less(array, j, j + 1)) {
				j++;
			}
			if (!less(array, k, j)) break;
			exch(array, k, j);
			k = j;
		}
	}
	int delete(int[] array) {
		int key = array[1];
		exch(array, 1, array.length);
		sink(array, 1);
		array[array.length + 1] = 0;
		return key;
	}
	int median() {
		int minsize = minarray.length;
		int maxsize = maxarray.length;
		int deleteele = 0;
		if ((minsize - maxsize) > 1) {
			deleteele = delete(minarray);
			insertmax(deleteele);
		}
		if (maxsize - minsize > 1) {
			deleteele = delete(maxarray);
			insertmin(deleteele);
		}
		if (minsize == maxsize) {
			median = (minarray[1] + maxarray[1]) / 2;
			return median;
		}
		return median;
	}
	// void print() {
	// 	System.out.println(Arrays.toString(minarray));
	// 	System.out.println(Arrays.toString(maxarray));
	// }
}
class Solution {
	Solution() { }
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int line = scan.nextInt();
		Median median = new Median();
		for (int i = 0; i < line; i++) {
			int num = scan.nextInt();
			median.insert(num);
		}
		// median.print();

	}
}