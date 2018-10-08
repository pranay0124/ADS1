import java.util.Scanner;
class MinHeap<E extends Comparable<E>> {
	E[] heaparray;
	int count;
	int flag;
	MinHeap(final int size) {
		heaparray = (E[])new Comparable[size];
		count = 0;
		flag = 0;
	}
	boolean less(E valueone, E valuetwo) {
		return valueone.compareTo(valuetwo) < 0;
	}
	boolean swim(E[] heaparray, int nodeval) {
		while (nodeval > 1) {
			if (less(heaparray[nodeval], heaparray[(nodeval - 1) / 2])) {
				return false;
			} else {
				nodeval = (nodeval - 1) / 2;
			}
		}
		return true;
	}
	int insert(E item) {
		heaparray[count++] = item;
		if (!swim(heaparray, count - 1)) {
			flag = 1;
		}
		return flag;
	}
}
class Solution {
	private Solution() {
		//unused
	}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		int testnum = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < testnum; i++) {
			outerloop:
			switch (line) {
			case "String":
				String[] tokens = scan.nextLine().split(",");
				MinHeap<String> stringobj = new MinHeap<String>(tokens.length);
				for (int j = 0; j < tokens.length; j++) {
					int returnval = stringobj.insert(tokens[j]);
					if (returnval == 1) {
						System.out.println("false");
						break outerloop;
					}
				}
				System.out.println("true");
				break;
			case "Integer":
				tokens = scan.nextLine().split(",");
				MinHeap<Integer> integerobj = new MinHeap<Integer>(tokens.length);
				for (int j = 0; j < tokens.length; j++) {
					int returnval = integerobj.insert(Integer.parseInt(tokens[j]));
					if (returnval == 1) {
						System.out.println("false");
						break outerloop;
					}
				}
				System.out.println("true");
				break;
			case "Double":
				tokens = scan.nextLine().split(",");
				MinHeap<Double> doubleobj = new MinHeap<Double>(tokens.length);
				for (int j = 0; j < tokens.length; j++) {
					int returnval = doubleobj.insert(Double.parseDouble(tokens[j]));
					if (returnval == 1) {
						System.out.println("false");
						break outerloop;
					}
				}
				System.out.println("true");
				break;
			case "Float":
				tokens = scan.nextLine().split(",");
				if(tokens[0].equals("")) {
					System.out.println("false");
					break;
				}
				MinHeap<Float> floatobj = new MinHeap<Float>(tokens.length);
				for (int j = 0; j < tokens.length; j++) {
					int returnval = floatobj.insert(Float.parseFloat(tokens[j]));
					if (returnval == 1) {
						System.out.println("false");
						break outerloop;
					}
				}
				System.out.println("true");
				break;		
			default:
				break;
			}
		}
	}
}