import java.util.Scanner;
import java.util.Arrays;
class Stack {
	String[] stack;
	int size;
	Stack() {
		stack = new String[50];
		size = 0;
	}

	void push(String element) {
		try {
			stack[size] = element;
			size++;
		} catch (Exception e) {
			resize();
			push(element);
		}
	}

	void resize() {
		stack = Arrays.copyOf(stack, size * 2);
	}

	boolean isEmpty() {
		return size == 0;
	}

	String pop() {
		String item = stack[size - 1];
		stack[size - 1] = null;
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
				if (tokens.equals("{") || tokens.equals("[") || tokens.equals("(")) {
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