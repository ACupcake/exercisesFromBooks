public class Main {
	public static void main(String[] args) {
		Stack<String> operators = new Stack<String>();
		Queue<String> operands = new Queue<String>();

		while (!StdIn.isEmpty()) {
			String input = StdIn.readString();

			if(	input.equals("+")
				|| input.equals("-")
				|| input.equals("*")
				|| input.equals("/")) {
				operators.push(input);
			} else {
				operands.enqueue(input);
			}
		}

		StdOut.print(InfixToPostfix(operators, operands));
	}

	public static String InfixToPostfix(Stack<String> operators, Queue<String> operands) {
		String postFix = new String();

		while(!operands.isEmpty())
			postFix += operands.dequeue();
		while(!operators.isEmpty())
			postFix += operators.pop();

		return postFix;
	}
}