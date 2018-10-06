/**
 * @author : Pranay Kumar Y.
 * date : 06th october,2018.
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
/**
 * Class for selection sort.
 */
class SelectionSort {
	/**
	 * { function for greater }.
	 * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
	 *
	 * @param      u     { parameter_description }
	 * @param      v     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	boolean greater(final Student u, final Student v) {
		return u.compareTo(v) == 1;
	}

	/**
	 * { function for exchange }.
	 * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
	 *
	 * @param      a     { parameter_description }
	 * @param      i     { parameter_description }
	 * @param      j     { parameter_description }
	 */
	void exch(final Student[] a, final int i, final int j) {
		Student temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
	/**
	 * { sort function }.
	 * Complexity :
     *              Best Case : O(n)
     *              Average Case : O(n)
     *              Worst Case : O(n)
	 *
	 * @param      array  The array
	 */
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

/*=========================================================================*/
/**
 * Class for student.
 */
class Student implements Comparable<Student> {
	/**
	 * student name.
	 */
	private String studentname;
	/**
	 * dob.
	 */
	private String dob;
	/**
	 * day
	 */
	private int day;
	/**
	 * month.
	 */
	private int month;
	/**
	 * year.
	 */
	private int year;
	/**
	 * marks1.
	 */
	private int sub1marks;
	/**
	 * marks2.
	 */
	private int sub2marks;
	/**
	 * marks3.
	 */
	private int sub3marks;
	/**
	 * tot marks.
	 */
	private int totalMarks;
	/**
	 * reservation.
	 */
	private String reservation;
	/**
	 * Constructs the object.
	 *
	 * @param      studentname1  The studentname 1
	 * @param      dob1          The dob 1
	 * @param      sub1marks1    The sub 1 marks 1
	 * @param      sub2marks1    The sub 2 marks 1
	 * @param      sub3marks1    The sub 3 marks 1
	 * @param      totalMarks1   The total marks 1
	 * @param      reservation1  The reservation 1
	 */
	Student(String studentname1, String dob1,
	        int sub1marks1, int sub2marks1,
	        int sub3marks1, int totalMarks1,
	        String reservation1) {
		this.studentname = studentname1;
		this.dob = dob;
		// String[] d = dob.split("-");
		// this.date = Integer.parseInt(d[0]);
		// this.month = Integer.parseInt(d[1]);
		// this.year = Integer.parseInt(d[2]);
		this.sub1marks = sub1marks1;
		this.sub2marks = sub2marks1;
		this.sub3marks = sub3marks1;
		this.totalMarks = totalMarks1;
		this.reservation = reservation1;
	}
	/**
	 * Gets the student name.
	 *
	 * @return     The student name.
	 */
	String getStudentName() {
		return studentname;
	}
	/**
	 * Gets the total marks.
	 *
	 * @return     The total marks.
	 */
	int getTotalMarks() {
		return totalMarks;
	}
	/**
	 * Gets the reservation.
	 *
	 * @return     The reservation.
	 */
	String getReservation() {
		return reservation;
	}
	/**
	 * compareTo function.
	 * 
	 * @param      that  The that
	 *
	 * @return     { description_of_the_return_value }
	 */
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
		if ((this.dob).compareTo(that.dob) > 0) {
			return 1;
		}
		if((this.dob).compareTo(that.dob) < 0) {
			return -1;
		}
		// if (this.year > that.year) {
		// 	return 1;
		// }
		// if (this.year < that.year) {
		// 	return -1;
		// }
		// if (this.month > that.month) {
		// 	return 1;
		// }
		// if (this.month < that.month) {
		// 	return -1;
		// }
		// if (this.date > that.date) {
		// 	return 1;
		// }
		// if (this.date < that.date) {
		// 	return -1;
		// }
		return 0;
	}
}
/*=========================================================================*/
/**
 * Class for solution.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {}
	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int qualifiedStudents = Integer.parseInt(scan.nextLine());
		Student[] data = new Student[qualifiedStudents];
		int count1 = 0;
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
			data[count1] = studentdetails;
			count1++;
		}
		data = Arrays.copyOf(data, count1);
		sortobj.sort(data);
		// Student[] seatallotment = new Student[vacancies];
		// int j = 0;
		ArrayList<Student> seatallotment = new ArrayList<Student>();
		int count = 0;
		for (int i = 0; i < data.length && unreserved > 0 && vacancies > 0; i++) {
			seatallotment.add(data[i]);
			unreserved--;
			count++;
			vacancies--;
		}
		for (int i = count; i < data.length  && vacancies > 0; i++) {
			if (data[i].getReservation().equals("BC") && bc > 0) {
				seatallotment.add(data[i]);
				bc--;
				count++;
				vacancies--;
			}
			if (data[i].getReservation().equals("ST") && st > 0) {
				seatallotment.add(data[i]);
				st--;
				count++;
				vacancies--;
			}
			if (data[i].getReservation().equals("SC") && sc > 0 ) {
				seatallotment.add(data[i]);
				sc--;
				count++;
				vacancies--;
			}
		}
		// while (vacancies != 0) {
		// 	for (int i = 0; i < data.length; i++) {
		// 		if (((data[i].getReservation()).equals("BC") && bc != 0) || ((data[i].getReservation()).equals("Open") && unreserved != 0)) {
		// 			seatallotment[j] = data[i];
		// 			j++;
		// 			vacancies--;
		// 			bc--;
		// 		} else if (((data[i].getReservation()).equals("SC") && sc != 0) || ((data[i].getReservation()).equals("Open") && unreserved != 0)) {
		// 			seatallotment[j] = data[i];

		// 			j++;
		// 			vacancies--;
		// 			sc--;
		// 		} else if (((data[i].getReservation()).equals("ST") && st != 0) || ((data[i].getReservation()).equals("Open") && unreserved != 0)) {
		// 			seatallotment[j] = data[i];
		// 			j++;
		// 			vacancies--;
		// 			st--;
		// 		} else if (((data[i].getReservation()).equals("Open")  && unreserved != 0)) {
		// 			seatallotment[j] = data[i];
		// 			j++;
		// 			vacancies--;
		// 			unreserved--;
		// 		} else {}
		// 	}
		// }


		for (int i = 0; i < seatallotment.size(); i++) {
			System.out.println(seatallotment.get(i).getStudentName() + "," + seatallotment.get(i).getTotalMarks() + "," + seatallotment.get(i).getReservation());
		}
	}
}
