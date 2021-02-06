public class Main {
	public static void main(String[] args) {
		Queue<String> operators = new Queue<String>();
		Stack<Double> operands = new Stack<Double>();

		while (!StdIn.isEmpty()) {
			String input = StdIn.readString();

			if(	input.equals("+")
				|| input.equals("-")
				|| input.equals("*")
				|| input.equals("/")) {
				operators.enqueue(input);
			} else {
				operands.push(Double.parseDouble(input));
			}
		}
		StdOut.print(EvaluatePostfix(operators, operands));
	}

	public static Double EvaluatePostfix(Queue<String> operators, Stack<Double> operands) {
		while(operands.size() != 1) {
			String operation = operators.dequeue();
			Double operator1 = operands.pop();
			Double operator2 = operands.pop();

			if(operation.equals("+"))
				operands.push(operator1 + operator2);
			else if(operation.equals("-"))
				operands.push(operator1 - operator2);
			else if(operation.equals("*"))
				operands.push(operator1 * operator2);
			else if(operation.equals("/"))
				operands.push(operator1 / operator2);
		}

		return operands.pop();
	}

}