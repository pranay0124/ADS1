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
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].getStudentName() + "," + array[i].getTotalMarks() + "," + array[i].getReservation());
		}
		System.out.println();

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
	String getStudentName() {
		return studentname;
	}
	int getTotalMarks() {
		return totalMarks;
	}
	String getReservation() {
		return reservation;
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
		int qualifiedStudents = Integer.parseInt(scan.nextLine());
		Student[] data = new Student[qualifiedStudents];
		int count = 0;
		int vacancies = Integer.parseInt(scan.nextLine());
		int unreserved = Integer.parseInt(scan.nextLine());
		int bc = Integer.parseInt(scan.nextLine());
		int sc = Integer.parseInt(scan.nextLine());
		int st = Integer.parseInt(scan.nextLine());
		SelectionSort sortobj = new SelectionSort();
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			Student studentdetails = new Student(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), tokens[6]);
			data[count] = studentdetails;
			count++;
		}
		data = Arrays.copyOf(data, count);
		sortobj.sort(data);
		Student[] seatallotment = new Student[vacancies];
		int j = 0;
		while (vacancies != 0) {
			for (int i = 0; i < data.length; i++) {
				if (((data[i].getReservation()).equals("BC") && bc != 0) || ((data[i].getReservation()).equals("Open") && unreserved != 0)) {
					seatallotment[j] = data[i];
					j++;
					vacancies--;
					bc--;
				} 
				else if (((data[i].getReservation()).equals("SC") && sc != 0) || ((data[i].getReservation()).equals("Open") && unreserved != 0)) {
					seatallotment[j] = data[i];

					j++;
					vacancies--;
					sc--;
				} 
				else if (((data[i].getReservation()).equals("ST") && st != 0) || ((data[i].getReservation()).equals("Open") && unreserved != 0)) {
					seatallotment[j] = data[i];
					j++;
					vacancies--;
					st--;
				} 
				else if (((data[i].getReservation()).equals("Open")  && unreserved != 0)) {
					seatallotment[j] = data[i];
					j++;
					vacancies--;
					unreserved--;
				} 
				else {}
			}
			for (int i = 0; i < seatallotment.length; i++) {
				System.out.println(seatallotment[i].getStudentName() + "," + seatallotment[i].getTotalMarks() + "," + seatallotment[i].getReservation());
			}
		}
	}
}