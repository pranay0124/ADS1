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
