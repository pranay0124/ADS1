import java.util.Scanner;
import java.util.Arrays;
class Stack {
	String[] array;
	int size;
	Stack() {
		array = new String[50];
		size = 0;
	}

	void push(String element) {
		try {
			array[size] = element;
			size++;
		} catch (Exception e) {
			resize();
			push(element);
		}
	}

	void resize() {
		array = Arrays.copyOf(array, size * 2);
	}

	boolean isEmpty() {
		return size == 0;
	}

	String pop() {
		String item = array[size - 1];
		array[size - 1] = null;
		size--;
		return item;
	}
}

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split("");
			Stack stack = new Stack();
			boolean flag = false;
			for (int i = 0; i < tokens.length; i++) {
				if (tokens[i].equals("{") || tokens[i].equals("[") || tokens[i].equals("(")) {
					stack.push(tokens[i]);
				}

				if (tokens[i].equals("}")) {
					String str;
					if (!stack.isEmpty()) {
						str = stack.pop();
						if (!str.equals("{")) {
							flag = true;
							break;
						}
					}
				}

				if (tokens[i].equals("]")) {
					String str;
					if (!stack.isEmpty()) {
						str = stack.pop();
						if (!str.equals("[")) {
							flag = true;
							break;
						}
					}
				}

				if (tokens[i].equals(")")) {
					String str;
					if (!stack.isEmpty()) {
						str = stack.pop();
						if (!str.equals("(")) {
							flag = true;
							break;
						}
					}
				}
			} if (!flag && stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");

			}
		}
	}
}