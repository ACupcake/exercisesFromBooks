public class Main {
	public static void main(String[] args) {
		Stack<String> original = new Stack<String>();
		Stack<String> copy = new Stack<String>();
		
		original.push("3");
		original.push("2");
		original.push("1");
		copy = copy(original);

		for(String string: copy)
			StdOut.println(string);
	}

	public static Stack<String> copy(Stack<String> strings) {
		Stack<String> pivot = new Stack<String>();
		Stack<String> stackCopy = new Stack<String>();

		for(String string: strings)
			pivot.push(string);
		for(String string: pivot)
			stackCopy.push(string);

		return stackCopy;
	}
}