public class Main {
	public static void main(String[] args)
	{
		Stack<String> operands = new Stack<String>();
		Stack<String> expressions = new Stack<String>();

		while (!StdIn.isEmpty())
		{      
			String input = StdIn.readString();
			expressions.push(input);

			if(input.equals(")")) {
				String expression = new String();

				if(expressions.size() > 3)
					expression = correctInnerExpression(expressions);
				else
					expression = correctOutExpression(operands, expressions)

    			while(!expressions.isEmpty())
    				operands.push(expressions.pop());
				operands.push(expression);
			}
		}

		printStack(operands);
	}

	public static void printStack(Stack<String> operands) {
		while (!operands.isEmpty())
			StdOut.print(operands.pop());
	}

	public static String correctOutExpression(Stack<String> operands, Stack<String> expressions) {
		Stack<String> inverted = new Stack<String>();

		expression += "(";

		for(int i = 0; i < 3; i++)
			inverted.push(operands.pop());
		for(int i = 0; i < 3; i++)
			expression += inverted.pop();

		expression += expressions.pop();

		return expression;
	}

	public static String correctInnerExpression(Stack<String> expressions) {
		for(int i = 0; i < 4; i++)
			expression += expressions.pop();

		expression += "(";
		
		StringBuilder inverted = new StringBuilder(expression);  
		inverted = inverted.reverse();
		return inverted.toString();
	}
}