import java.util.*;
class SelectionSort {
	boolean greater(final Student u, final Student v) {
		return u.compareTo(v) == 1;
	}

	void exch(final Student[] a, final int i, final int j) {
		Student temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
	void sort(final Student[] array) {
		int n = array.length;
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (greater(array[j], array[min])) {
					min = j;
				}
			}
			exch(array, i, min);
		}
		System.out.println(Arrays.toString(array));
		// for (int i = 0; i < array.length - 1; i++) {
		//     System.out.print(array[i].getTeamname() + ",");
		// }
		// System.out.print(array[array.length - 1].getTeamname());
	}
}
class Student implements Comparable<Student> {
	String studentname;
	String dob;
	int sub1marks;
	int sub2marks;
	int sub3marks;
	int totalMarks;
	String reservation;
	Student(String studentname, String dob, int sub1marks, int sub2marks, int sub3marks, int totalMarks, String reservation) {
		this.studentname = studentname;
		this.dob = dob;
		this.sub1marks = sub1marks;
		this.sub2marks = sub2marks;
		this.sub3marks = sub3marks;
		this.totalMarks = totalMarks;
		this.reservation = reservation;
	}
	public int compareTo(Student that) {
		if (this.totalMarks > that.totalMarks) {
			return 1;
		}
		if (this.totalMarks < that.totalMarks) {
			return -1;
		}
		if (this.sub3marks > that.sub3marks) {
			return 1;
		}
		if (this.sub3marks < that.sub3marks) {
			return -1;
		}
		if (this.sub2marks > that.sub2marks) {
			return 1;
		}
		if (this.sub2marks < that.sub2marks) {
			return -1;
		}
		return 0;
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int qualifiedStudents = scan.nextInt();
		Student[] data = new Student[50];
		int count = 0;
		int vacancies = scan.nextInt();
		int unreserved = scan.nextInt();
		int bc = scan.nextInt();
		int sc = scan.nextInt();
		int st = scan.nextInt();
		SelectionSort sortobj = new SelectionSort();
		while (scan.hasNext()) {
            String line = scan.nextLine();
            System.out.println(line);
            String[] tokens = line.split(",");
			System.out.println(Arrays.toString(tokens) + "input");
			Student studentdetails = new Student(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), tokens[6]);
			data[count] = studentdetails;
			count++;
		}
		data = Arrays.copyOf(data, count);
		sortobj.sort(data);
	}
}