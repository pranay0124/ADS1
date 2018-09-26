import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size1 = Integer.parseInt(scan.nextLine());
		int size2 = Integer.parseInt(scan.nextLine());
		int[] array1 = new int[size1];
		int[] array2 = new int[size2];
		String[] values1 = scan.nextLine().split(",");
		String[] values2 = scan.nextLine().split(",");
		for (int i = 0; i < size1; i++) {
			array1[i] = Integer.parseInt(values1[i]);
		}
		for (int j = 0; j < size2; j++) {
			array2[j] = Integer.parseInt(values2[j]);
		}

		int i = 0;
		int j = 0;
		int k = 0;
		int[] finalarray = new int[size1 + size2];
		while (k < size1 + size2) {
			if ((i < size1) && (j < size2)) {
				if (array1[i] < array2[j]) {
					finalarray[k] = array1[i];
					i++;
					k++;
				} else if (array1[i] > array2[j]) {
					finalarray[k] = array2[j];
					j++;
					k++;
				} else {
					finalarray[k] = array1[i];
					i++;
					k++;
					finalarray[k] = array2[j];
					j++;
					k++;
				}
			} else {
				break;
			}
		}
		if (i < size1) {
			while (i < size1) {
				finalarray[k] = array1[i];
				i++;
				k++;
			}
		}
		if (j < size2) {
			while (j < size2) {
				finalarray[k] = array2[j];
				j++;
				k++;
			}
		}
		for (int l = 0; l < finalarray.length - 1; l++) {
			System.out.print(finalarray[l] + ",");
		}
		System.out.println(finalarray[finalarray.length - 1]);
	}
}